The Java Memory Model, part 2

  The memory is divided into a heap and a stack.

  The heap is used to store classes and instances.
  The stack is used to store information used by method calls.

  Everytime a method is called, a "stack frame" is placed on the top of the stack.  When the method exits, that frame is taken off the top of the stack.
   The top of the stack always contains the stack frame of the currently executing method.

  The stack frame contains:
	1. Method parameters 
	2. The special value "this" for instance (i.e. non-static) methods
        3. Any local variables declared inside the method
	4. Bookkeeping needed to return from a function (where in the code do we need to start executing, and what should we do with the value returned by the method?)


  Consider the method earnsMoreThan:

	public boolean earnsMoreThan(Employee e) {
	  return this.getSalary() > e.getSalary();
	}

   Suppower we have two Employee instances: e1 and e2 and we run:
	e1.earnsMoreThan(e2)

   On the stack will go a stack frame for the execution of earnsMoreThan.  (I will call this Frame 1.)
	Frame 1 contains:
	  - Space for the input parameter e.
	  - Space for the special parameter this.
 	  - There are no local variables
	  - Bookkeeping infor to know where to send the return value

	The e variable in Frame 1 will store the contents of e2 and the this variable of Frame 1 will store the contents of e1.
   
   Now earnsMoreThan can run.
   Its first step is to call this.getSalary.
   On the stack will go a stack frame for the execution of getSalary.  (I will call this Frame 2.) 
	Frame 2 contains:
	  - Space for the special parameter this.
	  - Bookkeeping info

  	The this variable in Frame 2 will store the contents of the this variable of Frame 1.

   Now getSalary can run.
   It will use the variable this in Frame 2 to access the object in the heap and its salary field.
   When getSalary completes, Frame 2 is deallocated from the stack, and execution returns to earnsMoreThan and Frame 1.  Frame 1 is now at the top of the stack.

   Frame 1's next job is to call e.getSalary.
   On the stack will go a stack frame for the execution of getSalary.  (I will call this Frame 3.)
	Frame 3 contains:
	  - Space for the special parameter this.
	  - Bookkeeping info

	The this variable in Frame 3 will store the contents of the e variable of Frame 1.

   Now getSalary can run.
   It will use the variable this in Frame 3 to access the object in the heap and its salary field.
   When getSalary completes, Frame 3 is deallocated from the stack, and execution returns to earnsMoreThan and Frame 1.  Frame 1 is now at the top of the stack.

   earnsMoreThan now compares the value returned from the two getSalary calls and returns true or false.
   When earnsMoreThan returns, its frame is deallocated from the stack.


Compound statements (blocks of code):
    When a compound statement containing a variable declaration is encountered, a "mini-frame" is placed on the stack that contains any variable declared inside the
      compound statement.  This "mini-frame" is removed once the compound statement is done executing.

  Example: 
	public static int binarySearch(int x, int[] array) {
	  int start = 0;
	  int end = array.length - 1;

	  while (start <= end) {
	    int mid = (start + end) / 2;
	    ....
	  }
  	  return -1;
	}

    Suppose we run binarySearch(A, 15);

    On the stack will go a stack frame for binarySearch. (I will call this Frame 1).
	The stack frame contains space for the parameter x, the parameter array (just the address is being stored),
            and the local variables start and end.

	If the loop condition is true, (start <= end), then
	   A "mini-frame" is added to the stack to hold the variable mid.
	   The compound statement that is the loop body executes.
	   When the execution returns to the if statement, the mini-frame is deallocated from the stack so mid no longer exists.

	If the loop condition is still true, (start <= end), then
	   A "mini-frame" is added back to the stack to hold the variable mid.
	   The compound statement that is the loop body executes.

     This process repeats.  Everytime the loop condition is true and we enter the loop body, we put a miniframe on the stack to store the variable mid because the loop body is a compound statement (or block of code).
     When we leave the loop body and return to the loop condition, the mini-frame is deallocated so mid does not exist in the loop condition.
     If the condition is still true, the mini-frame is added back to the stack so mid again exists.
     And so on.

TAKE AWAY RULE:
  A local variable exists from the moment it is declared (that is when it is placed into its frame, method frame or mini-frame, until the end of the compound
statement it is in (that is when the frame it is in gets removed from the stack).


  Example 2:
    Computing the factorial of an integer.  5! = 5 x 4 x 3 x 2 x 1
    We will use a technique called recursion.  In recursion, we identify a base case (the smallest case for which the method needs to work), and we handle the base case explicitly.
      For other cases, we reduce the problem to bring it closer to the base case, and call the method on the reduced problem.

    What is the smallest case?  0! = 1  (by mathematical definition)
    If we assume that we can correctly compute factorial for smaller values, how do we compute n! ?  We note that n! = n x (n-1)!

        public static int factorial(int n) {
          if (n == 0)
            return 1;
          else
            return factorial(n - 1) * n;
        }

  Now, we trace the behavior of calling factorial(6).

  The stack places a new method frame for factorial on the stack.
    1) bookkeeping info
    2) the parameter n storing the value 6  (note there is no hidden parameter this because factorial is a static method)
  In the execution of factorial(6), we get to the line "return factorial(n-1) * n".  This is a method call, so we must place a frame on the stack.
  A new frame for factorial(5) is placed on the stack on top of the frame for factorial(6).  The frame contains:
    1) bookkeeping info
    2) the parameter variable n storing the value 5
  NOTE: The parameter variable n in the frame of factorial(5) is a DIFFERENT variable from the parameter variable n of the frame for factorial(6).
     They both have the same name, but the memory location (location on the stack) is different, and they each are storing a different value.
  In the execution of factorial(5), we get to the line "return factorial(n-1) * n".  This is a method call, so we must place a frame on the stack.
  A new frame for factorial(4) is placed on the stack on top of the frame for factorial(5).  The frame contains:
    1) bookkeeping info
    2) the parameter variable n storing the value 4

  And the process continues.  Finally, we get to the method call factorial(0).  At this point we have 5 frames on the stack.  At the top is the frame
  for factorial(0), under it is the frame for factorial(1), etc, down to the bottom which is the frame for factorial(4).  When factorial(0) returns, the
  value 1 is sent to the line "return factorial(n-1) * n" and the frame for factorial(0) is removed.  Now the top frame of the stack is the frame for
  factorial(1).  So, when the line "return factorial(n-1) * n" is executed, the return value of 1 is used, and the value of the parameter variable n is 1.

  At this time, we multiply 1*1 and the method returns 1.  When the factorial method returns, the top frame is removed from the stack.  The frame underneath is now the top frame.
  That frame has a variable n storing the value 2.  So, when the line "return factorial(n-1) * n" is executed, n stores 2, the value returned was 1, and the
  multiplication is 2*1.  Thus, the value of 2 is returned.

  When the factorial method returns, the top frame is removed from the stack.  The frame underneath is now the top frame.
  That frame has a variable n storing the value 3.  So, when the line "return factorial(n-1) * n" is executed, n stores 3, the value returned was 2, and the
  multiplication is 3*2.  Thus, the value of 6 is returned.

  When the factorial method returns, the top frame is removed from the stack.  The frame underneath is now the top frame.
  That frame has a variable n storing the value 4.  So, when the line "return factorial(n-1) * n" is executed, n stores 4, the value returned was 6, and the
  multiplication is 4*6.  Thus, the value of 24 is returned.

  When the factorial method returns, the top frame is removed from the stack.  The frame underneath is now the top frame.
  That frame has a variable n storing the value 5.  So, when the line "return factorial(n-1) * n" is executed, n stores 5, the value returned was 24, and the
  multiplication is 5*24.  Thus, the value of 120 is returned.

  When the factorial method returns, the top frame is removed from the stack.  The frame underneath is now the top frame.
  That frame has a variable n storing the value 6.  So, when the line "return factorial(n-1) * n" is executed, n stores 6, the value returned was 120, and the
  multiplication is 6*120.  Thus, the value of 720 is returned.

  Finally, our call to factorial(6) returns the value 720.

