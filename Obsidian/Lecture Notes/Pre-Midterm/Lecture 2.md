First we talked about the lab:

   You saw some strange behavior with the int type in lab 1.  Recall:
        > Integer.MAX_VALUE
        2147483647
        > 2147483647 + 1
        -2147483648

   Why does Integer.MAX_VALUE + 1 become a large negative number?
     It is because the int type is only 32-bits so there is a limit to the number of values it can store.  The reason it "wraps" to negative numbers
       is a trick of the binary representation currently used for int.

   Here is another strange behavior, but this time with the double type:
        > 1.3 + 1.3
        1.6
        > 1.3 + 2.3
        3.5999999999999996

  Why does 1.3 + 1.3 equal 2.6, but 1.3 + 2.3 does not equal 3.6?
    The numbers are represented in binary, and some fraction numbers (such as 3/10) can not be represented exactly.
    This is similar to how 1/3 and 1/7 can not be represented exactly in decimal.
    If the error in the representation is small enough, the Java routine that prints the numbers will round the printed number to a "nice" decimal value.
    For 1.3 + 2.3, the errors in the representation just happen, when added, to be big enough so that the result is not "close enough" to 3.6.

  Why should you care?
   Mathematics in Java is not the same as "real" mathematics.  Errors will crop up due to the fixed size of the numeric data types that would not appear if we
   were manipulating the numbers using "real" mathematics.  A programmer must always be alert to situations where such errors could occur so that they do not cause
   strange program behavior.

   For example, if you do a lot of arithmetic operators, the tiny errors can accumulate and become very large errors to where you
    can't trust the result.
   You also should avoid doing exact tests of double values.  (For example 3.6 == 1.3 + 2.3), they may not hold exactly the same value.


Recall last time:
  Remember that a computer is just wires and switches.  All data is represented by wires that are ON or OFF. (1 or 0)
  A bit is the smallest unit of information.  A bit is 2 values.

  We get more than 2 values by grouping wires together.  (A byte is 8 bits (8 wires), and thus a byte can have 256 different values.)
  To a computer, all data is just 0's & 1's.  All data is just a number.

Data Types:
  The type of a piece of data is what the piece of data represents.  It is specified by the programmer and by rules of the programming language.

   Java's Strict Typing:
       Java is a "strongly typed" language.  That means that every piece of data will have a well defined type and unambiguous type.
       Java is a "strictly typed" language.  That means the compiler will verify that every type is used correctly.
       The programmer must set the type of every expression (either explicitly or implicitly), and the Java compiler will verify that each type is used correctly.  If a type is used incorrectly, an error is given.
       For example, if you specify that a piece of data is English text, then Java will only allow you to do actions appropriate for text on it.
    (Java was built to replace C/C++ which had no such safety restrictions.)

  There are two kinds of types in Java: 
    1.  primitive types : these are pre-defined in the language
    2.  compound types (called reference types in your book) : there are some pre-defined, but the programmer can define new types

Primitive Types in Java

 The following are the eight primitive types:

  int:  32-bits of data.  Represents an integer between -2^31 and +2^31 - 1.
	All whole numbers in your program default to the type int.
	  example:  5, -30, 0  are all ints

  double: 64-bits of data.  Represents a "floating point" number (a number with a decimal point) in scientific notation.  
        Roughly 52 bits for the mantissa, 11 bits for the exponent, 1 sign bit.
	All numbers with decimal points or in scientific notation in your program default to the type double.
        The largest/smallest values that can be represented are +/- 4.9 x 10^-324 and +/- 1.7 x 10^308.
	   example:  3.1415, -0.3,  10.,  3e10  are all doubles

  char: 16-bits of data.  Represents a character. 
	char values are single characters inside single quotes.
	  example:  'a', 'x', ' ', '?', '3'  are all char values.
           (Note that '3' and 3 are not the same thing!  The first is a binary value that Java interprets as the character 3, and
            the second is a (different) binary value that Java interprets as the whole number 3.)

  boolean:  1-bit of data (really stored as 8-bits).  Represents either true or false.
  
We will use int, double, char, and boolean in projects and tests.  Here are the other 4 primitive types for your reference (they could show up in quizzes or labs):

  short: 16-bits of data.  Represents an integer between -2^15 and +2^15 - 1.

  byte: 8-bits of data.  Represents an integer between -2^7 and +2^7 - 1.

  long: 64-bits of data.  Represents an integer between -2^63 and +2^63 - 1.
	To enter a long value, you use the letter L (upper or lower case).
	  example:   10L, 3000000L  are all long values

  float: 32-bits of data.  Binary, scientific notation.  Roughly 23 bits for the mantissa, 8 bits for the exponent, 1 sign bit.
        The largest/smallest values that can be represented by floats are +/- 1.4 x 10^-45 and +/- 3.4 x 10^38
	To enter a float, you use F (upper or lower case).
	   example:  3.14F  is a float value

  Please note that the number of bits of the type determines how many different values it can store.
  Even though a long stores numbers between -2^63 and +2^63, and double stores values between +/- 4.9 x 10^-324 and +/- 1.7 x 10^308,
  the double stores the same number of different values as the long does.  The long can store every integer in that range, the double
  stores only some of the possible floating point numbers in that range.  Thus double cannot store all the integer values long can.


Typecasts (type conversions)

  Java allows the programmer to convert a value of one type into a value of a different type.
  To do this, you place the desired type in parentheses and immediately to the left of the value.
	(desired-type) value

   For example:
	   (double)3     converts the int value 3 to the double value that is the closest to 3.  In this case, the value is 3.0.
	   (short)100    converts the int value 100 to the short value that is the closts to 100.  In this case, the value is still 100 (but stored in 16 bits instead of 32 bits).
	   (int)3.8	 coverts the double value 3.8 to the int value 3
	   
      The typecast must "make sense".  In Java, you can convert between all the numeric primitive types, but not between boolean and
        a numeric primitive so:
	    (int)false   <= error, you can't convert a boolean to a numbers

            (int)'A'     <= this is legal.  Java considers a char to also be a number


Automatic Typecasts (called "type coercions")

      Values are automatically converted "narrower" to "wider" types.  A conversion from a "wider" to a "narrower" type
    requires an explicit typecast.  Generally, when converting to a wider type, Java converts the value to be as close as
    possible to the original value.  When converting to a narrower type, Java generally truncates the value.

        Widest:   double, float, long, int, char / short, byte   :  Narrowest

   Note that char is narrower than int, short and byte are narrower than int, but short and char are not narrower than each other. byte is narrower than short.  byte and char and not narrower or wider than each other.
   So double is the widest primitive type and both char and byte are the narrowest primitive types.

   Also note that boolean is not in this list.  You can not convert a value of type boolean to any other primitive.  You can not convert another primitive value to boolean.


        Ex:  'A' + 1         <-   This is legal because the 'A' will be automatically converted to int since 'A' is type char and char is narrower than int.

	     (char)65        <-   This will change the value 65 from type int to type char



Introduction to Variables

  A variable is the name given to a location in memory.  In Java, variable has a type associated with it.
  A variable is used to store data.  In Java, you can only store values with the appropriate type into the variable.

  Creating Variables
       We call creating a variable "declaring the variable"
       A declaration has the form:
                type variable-name

       Two examples:
                int number
                double average

       Java now sets aside a chunk of memory for each varialble.  The first is a 32-bit chunk that is associated with the name "number".
        Java will make sure that only values of type int can be stored in here.  (Remember that the type is what WE decide the value represents.  The computer does not care.  It is happy storing any 32-bit values there.)
        The second is a 64-bit chunk of memory that is associated with the name "average", and we can store values of type double in it.

  Storing Values in Variables
     We call storing a value "assigning a variable".

      To store a value in the variable, you use the = operator.
                variable = value

      For example:
                number = 23
                average = 40.75

      This is a source of confusion because the assignment operator looks like math's equality, but it is not an equality test.
        Instead, we are storing into the memory location named "number" the data that represents the int 23, and we are
                 storing into the memory that is named "average" the data that represents the double value 40.75.

      Remember that Java is a strong typed language so
                number = 3.1415   <=  error, you promised students would store int, and you are giving it a double
      If we really want to store that value, we have to convert it explicity to type int using a typecast

		number = (int)3.1415


      One more example:
	double x
	x = 5		  <- this is legal because 5 is type int, int is narrower than double, and so Java will covert the int 5 to double 5.0 and store 5.0 in x

