Introduction to Loops

Loops are a technique that allow us to execute a statement many times.  This is what gives a computer program its true power because computers can execute statements in 
loops millions of times a second.

There are 4 basic loop structures in Java.
  1. while loop
  2. for loop
  3. do-while loop
  4. foreach loop
The first three are general purpose loops.  The fourth is a special loop form that can only be used with arrays and Iterable types.  We will cover foreach loops later in the term.
#### technically for and while loops do the same tasks, just have different syntax

1. The while loop:

	while (condition)
	   loop-body-statement

      loop-body-statement is a single statement, simple or compound
      condition is any boolean expression

  While loop behavior:
    1) the condition is evaluated
    2) if the condition is true:
        2a) the loop body statement is executed
        2b) repeat step 1
   if the condition is false, go to the next statement of the program

Example 1: A silly example that prints "Hello" forever:

	while (true)
	  System.out.println("Hello");

  Note that we can put anything that evaluates to a boolean inside the parentheses.

Example 2: A loop that prints "Hello" never:

	while (false)
	  System.out.println("Hello");

Example 3: An example that prints "Hello" 5 times:
    We need to keep track of how many times we have printed "Hello".  So we need a variable to store that number.

	int count = 0;
	// count stores the number of times we have printed "Hello"
	while (count < 5) {
	  System.out.println("Hello");
	  count = count + 1;
	}
        // note: at this point in the code, count stores 5

    What does count remember?  The number of times we have printed out "Hello".
    Are we using count correctly?
      - At the beginning, we have not printed anything and count is 0. 
      - Each time we print "Hello", we add one to count.
      So, our use of count matches what we want it to do.
    What is true at the end of the loop?   count stores 5
      We wanted to print 5 times, and count stores 5 so we did print 5 times.


2. The for loop

	for (initial statement; condition; increment statements) 
	   loop-body-statement

      the initial statement is a single statement
      increment statements are 0 or more statements, separated by commas (no terminating semicolons)
      condition and loop-body-statement are the same as for while loops.
     
  For loop behavior:
    1) the initial statement is executed
    2) the condition is evaluated
    3) if the condition is true
        3a) the loop body statement is executed
	3b) the increment statements are executed
	3c) repeat step 2
    if the condition is false, go to the next statement of the program


Example 4: Write a loop that prints "Hello" 5 times, but this time using a for loop.

	// numHellos stores the number of times we have printed "Hello"
	for (int count = 0; count < 5; count = count + 1)
	  System.out.println("Hello");

        // note: at this point in the code count does not exist

   Note the close similarity to the while loop we wrote.  Notice where the different statements of the while loop ended up in the for loop.

While loops and for loops in Java are really the same thing, just different formatting.

We did not get to the do-while loop in class, but here is the syntax for completeness.

3. The do-while loop

   do {
      loop-body-statement(s)
   } while (condition);

 do-while-loop behavior:
    1) Execute the loop-body-statement(s)
    2) Evaluate the condition
       If the condition is true, repeat step 1
       If the condition is false, go to the next statement of the program

   The do-while loop should be avoided except in cases where you really need the body of the loop to execute before testing the condition.
   The problem with the do-while loop is that, if you accidentally drop the "do", the rest of the code is still valid Java, but it does something entirely different!
      It becomes a compound statement followed by a while loop!


While Loops

  While loop behavior:
    1) the condition is evaluated
    2) if the condition is true:
        2a) the loop body statement is executed
        2b) repeat step 1
   if the condition is false, go to the next statement of the program

  When to use a while loop and when to use a for loop?  Your choice.  The two are exactly the same, just ordered differently.
     * while loop advantage is that the syntax is simpler.
       while loops are good when the increment is complicated 


While Loop Example 1:  Euclid's Greatest Common Divisor algorithm

   We want to compute the greatest common divisor of two positive integers: a and b
	If a % b = 0 then the greatest common divisor is b
	Otherwise gcd(a,b) = gcd(b, a % b)

   This gives us a loop.  For example:
	gcd(30, 12) = gcd(12, 6) = gcd(6,0) = 6
	gcd(24, 15) = gcd(15, 9) = gcd(9, 6) = gcd(6, 3) = gcd(3,0) = 3

  	public static int gcd(int a, int b) {
	  while (b ! = 0) {
	    int r = a % b;
	    a = b;
	    b = r;
	  }
	  return a;
	}

    This algorithm seems to require a > b.  (It does not, trace the loop and see what happens if b > a.)


While Loop Example 2: Computing a square root using Newton's method
  Here is a first crack that we did in lecture:

  A little background.  Please look up Newton's method if you do not understand how it works.
    Let x0 be a guess for the square root of n.  
    Let f(x) = x * x - a   (Note that f(x) = 0 when x is the square root of a.
    Since the plot of f(x) is concave up, we can get a new guess by following the tangent to the curve from the current guess (x0, f(x0)) to (x1, 0).  x1 is the new, better guess.
    Using the slope formula were m is the slope of the tangent, we have
	m = (f(x0) - 0) / (x0 - x1)
    Note that m = f'(x0) = 2 * x0
	2 * x0 = f(x0) / (x0 - x1)
    or
      	x1 = x0 - (x0 * x0 - a) / (2 * x0)

    We then repeat setting x0 to be x1 and x1 to be the new, even better, guess.
    When do we stop?  One option is to stop when the difference in the guesses is really small:  x0 - x1 < 1e-10.
      Another option is to stop when the best guess is really close the the square root:  x1 * x1 - a < 1e-10.
      A good option is to stop when the "relative error" is small instead of the "absolute error" (which is what we are doing).

    This is a good situation for a while loop because the increment is complicated.
    Here is the code

	public static double squareRoot(double a) {
	  double x0 = ???;          // the square root guess of the previous iteration
 	  double x1 = ???;          // the best current guess for the square root

	  while (x1 * x1 - a > 1e-10) {
            x0 = x1;
            x1 = x0 - (x0 * x0 - a) / (2 * x0);
	  }
	  return x1;
	}

   What should the initial x0 and x1 be?  We should set x1 to be the initial "guess" for the squareroot and set x0 to be larger.  
    If you know how Newton's method work, the initial guess does not have to be that good, just larger than the square root and not orders of magnitude away from the square root.
    So, using a as the initial value will work if a >= 1.  If a < 1, you don't want to use a because then your guess will be smaller than the square root.
    We decided to use a+1.

	public static double squareRoot(double a) {
	  double x0 = a + 2;          // the square root guess of the previous iteration
 	  double x1 = a + 1;          // the best current guess for the square root

	  while (x1 * x1 - a > 1e-10) {
            x0 = x1;
            x1 = x0 - (x0 * x0 - a) / (2 * x0);
	  }
	  return x1;
	}

  It is possible to shorten the code.  Can you see why this works?
  
	public static double squareRoot(double a) {
	  double x = a + 1;          // the square root guess of the previous iteration

	  while (x * x - a > 1e-10) {
            x = x - (x * x - a) / (2 * x);
	  }
	  return x;
	}


Note, these use "absolute error" when determining the stopping condition.  Using "relative error" is better if you want the function to 
work well on all possible doubles.  (Relative error is when how close we want to value to be depends on how large a is.)

## Strings
```ad-example
Indexing starts at 0 in java!
"hello".length() = 5
String s = "Hello";
s.length(); = 5
s.charAt(1); = 'e'
```
