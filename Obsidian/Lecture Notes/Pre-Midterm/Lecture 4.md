Primitive operations and their type rules:

  Following are the type rules for the different primitive operators.  Please see your textbook for precedence and associativity rules.
  A few additional "shortcut" operators will be discussed around midterms.

  1) arithmetic operators:  +, -, *, /, %
  2) unary arithmetic operators:  +, -
  3) binary operators (not used in CSDS 132, they manipulate the binary representations): &, |, ^, ~, <<, >>, >>>

     The above operators have the same type rules:
       a) The two operands (or one operand for the unary operators) must be a numeric primitive type (i.e. not boolean as boolean is not numeric) 
       b) The narrower operand is automatically widened to match the wider operand, and if both operands are narrower than int, they are automatically casted/widened to int.
       c) The result is the type of the wider operand, or int if both operands are narrower than int

	ex:  5.0 + 3   (the result type is double because of the 5.0, before the addition is performed, the 3 is widened to 3.0)
	     'a' + 'b'  (the result type is int and both operands are widened to int before the addition is performed)
	     (short)3 + (byte)5   (the result is type int, and both operands are widened to int before the opeation is performed)
	     3 + '3' (char to int autocasting) -> 54

  4) comparison operators:  >, <, >=, <=
      The type rules:
        a) The operands must be a numeric primitive (a non-boolean primitive)
        b) The result type is boolean
        c) The narrower operand type is automatically widened before the operation is performed

	3 <= 3.1    <-  Converts the int 3 to double 3.0 and then compares 3.0 to 3.1
	3 < 4 < 5   <-  Illegal.  First computes 3 < 4, but then the left operand of the second < is type boolean!

  5) equality operators:  , !=
      The type rules:
	a) The operands can be any type (primitive or non-primitive, and *The narrower operand is automatically widened to the wider operand's type*.
            - it is an error if the automatic type conversion is not allowed 
        b) The result is boolean
	c) The value is determined by comparing the boolean values of the two operands (after the automatic widening).

	ex: 
            5 == 5.0			  <- first converts 5 to 5.0 before comparing
	            result: true
	    1 != true			  <- illegal because you can't convert between int and boolean
				result: error	
				true is boolean which is one bit, which cannot be typecasted to  int
		false != true		  <- legal because both operands are the same type
				result: boolean true

  6) boolean operators: &&, ||, !, &, |   (these are AND, OR, NOT, AND, and OR)
     The type rules:
	a) The operands (or operand for !) must be boolean
        b) The result is boolean
	c) && and || use "short-circuit evaluation".  If the result value is known from just the left operand, the right operand is not evaluated:

   AND: &&
      left-operand  right-operand     result
      true          true              true
      true          false             false
      false         NOT EVALUATED     false
  
| **left op** | **right op** | result |
| ---- | ---- | ---- |
| true | true | true |
| true | flase | flase |
| flase | NOT EVAL | false |

   OR: ||
      left-operand  right-operand     result
      true          NOT EVALUATED     true
      false         true              true
      false         false             false
  
| **left op** | **right op** | result |
| ---- | ---- | ---- |
| true | NOT EVAL | true |
| false | true | true |
| false | false | flase |

    We usually use && and || instead of & and |.  The results are the same, and we ofthen take advantage of the short-circuit feature.

     For example, suppose we want to test if (y / x) > 1, but this test can cause an error if x stores 0 (divide by 0 error).
	We can then write the test as:
		if ((x != 0) && ((y / x) > 1))
	so that if x stores 0, we get "false" and do not evaluate y / x
        On the other hand, if we used & instead of && then both operands would be evaluated and we will get an error if x stores 0.
	Typically, we always use && and only use & when we need to have both operands evaluated.

      Suppose we want to test x < y < z.  While that is not valid Java, we can get something equivalent using &&:
	(x < y) && (y < z)

  assignment operator:  =
     a) The left operand must evaluate to a variable.  The variable can be any type (primitive or non-primitive).
     b) The type of the right operand must be the same or narrower as the type of the variable on the left (*)
     c) The result is the same type as the variable and the value that was stored in the variable.

     Because = has a value and a type, we can place assignment operators anywhere in our code that expects a value.

	Ex:  double x
	     x = 1       <-  legal, the int 1 is widened to double 1.0 and stored.  The result is type double and value 1.0.

	     x = 5.3f    <-  legal, the 5.3f is float, float can be automatically widened to double

             float z
             z = 5.3     <-   illegal.  5.3 is a double, z expects float, and double is wider than float

	     int y
	     y = 1.0     <-   illegal.  1.0 is wider than int

	     x = y = 3   <-   legal. the y = 3 happens first.  The result is the int value 3, now we get x = 3, and the 3 is widened to 3.0
	                      The result of this expression will have 3 stored in y, 3.0 stored in x, and the expression will evaluate to the double 3.0
	

	If the type on the right is int, the variable on the left is narrower than int, and the expression is on the right is ONLY constants and primitive operators,
            	and the value "fits" inside the range of values for the narrower type, then the value on the right is automatically converted to the narrower type of the variable.

           byte b = 5           <- legal
           byte b = 5 + 1       <- legal
           byte b = b + 1       <- illegal  (the expression has a variable b in it, so Java will not automatically narrow)
           byte b = 127         <- legal
           byte b = 128         <- illegal, too large to fit in a byte
           byte b = 10000 / 1000  <- legal!
           

