Exception Handling

  Consider the following class:

	public class Averager {
	
	  // return the average of the numbers (represented as strings) in the array
	  public static int average(String[] values) {
	    int sum = 0;
	    for (int i = 0; i < values.length; i++) {
	      sum += Integer.parseInt(values[i]);
	    }
	    return sum / values.length;
	  }

	  public static void main(String[] args) {
	    int average = average(args);
	    System.out.println("The integer average of the inputs is " + average);
	  }
	}

  Since we have a main method, this program can be run stand alone, and it averages (using int average) the command line arguments

	java Averager 4 5 6
	> 5

  What can go wrong?
    1.  If the user does not enter an int (for example 4.5 or apple).  In this case, the program will generate a NumberFormatException.
    2.  If the user does not enter anything.  Then args.length is a 0, and the program will generate an ArithmeticException.

How to deal with errors:
  1. Print an error message.  This solution should only be used in routines that are directly interacting with the user.  Otherwise the error message will be ignored.
  2. Return a special "error" value.  This solution should only be used when either the error value makes sense or there is no possibility that the error value could be confused for legitimate output.
  3. Use a separate channel to send an error indication.
       For this technique, Java uses exceptions.
  4. Deal with the error.

We have already seen several types of exceptions:
	NumberFormatException, ArithmeticException, NullPointerException, IndexOutOfBoundsException
  Each of these exceptions are called unchecked exceptions.  All unchecked exceptions are subclasses of either Error or RunTimeException.

  With unchecked exceptions, the programmer does not have to explicitly state what to do if an exception occurs (is thrown).
   The default is to stop the method and throw the exception on the the calling method.

  The other types of exceptions (for example IOException), are checked exceptions.  With checked exceptions, the programmer must specify what to do if the exception is thrown.
    It is a compiler error to use code that can generate a checked exception but not explicitly state how to deal with it.

  Key point:  exceptions are just objects and they otherwise behave exactly like all other objects in Java.
   Exceptions are not errors.  Throwing an exception is just another way (besides the return statement) of getting data out of a method. 
   However, throwing an exception is like "break" in a loop.  Not only does it stop the method execution, but the calling method might simply throw exceptions to the methods that call it.
   As a result, exceptions are harder to reason about logically than "normal" return, and overuse will make our code more difficult to manage and harder to determine correctness.
   Exceptions should be used for handling infrequent situations, and thus are often used for errors.

How to Handle an Exception
  There are two things the programmer can do for an exception: handle the exception or throw the exception on to the calling method.
  To throw the exception, we can do either or both of these:
    1. Place "throws ExceptionType" in the header of the method.  See the lab example with IOException.  This must be done if throwing a checked exception.
        This notation in the header both informs the compiler that the specified exception may be thrown and sets the default behavior of the method to throw the exception should it occur.
    2. Explicitly throw the exception with the throw statement.
	throw e;
	throw new ExceptionType();

  To handle the exception, we use the try/catch statement.

	try {
	  - code that could throw an exception
	}
	catch (ExceptionType e) {
	  - code that is executed if an exception of type ExceptionType occurs inside the try block
	  - e is a variable that stores the exception object address, and it exists inside this block
	}
	finally {
	  - code that is always executed upon exit of the try and catch blocks
	}

  There may be 0 or more catch blocks with a try and at most one finally block.  There must be at least one catch block or a finally block with the try statement.
  Note that the catch statement is a variable declaration.  The variable e will hold the address of the exception that was thrown in the try block code.
  If you have more than one catch, Java will go in order from the top to the bottom and run the first catch block whose exception type matches (using the instanceof command) the actual exception thrown. 
  So, if one exception type extends another, be sure to put the narrower exception's catch first before the wider one.

Example:  Dealing with the integer divide by 0:

   The divide by 0 occurs in the line:
	    return total / values.length;

   We can place a try/catch block around it and catch ArithmeticExceptions

	    try {
	      return total / values.length;
	    }
	    catch (ArithmeticException e) {
	      // do something?
	    }

   In class, we decided to print an error message, and in this case, the error should be handled in main, and not in average.
   Exceptions have the benefit that we can handle the exception where it makes the most sense, not necessarily where they occur.
   So, we do not place the try block around "return total / values.length;" but instead place it around the code in main that calls average.

	  public static void main(String[] args) {
	    try {
	      int average = average(args);
	      System.out.println("The integer average of the inputs is " + average);
            }
            catch (ArithmeticException e) {
	      System.out.println("You entered nothing to average.");
	    }
	  }

Example 2: Dealing with the NumberFormatException

  If the input contains a String that does not represent a number, a NumberFormatException occurs.
  We changed the code to catch this error and ignore the values that are not numbers.
  Note that here we do the try inside the for loop so that the loop can contine after we handle the error.

	try {
	  sum += Integer.parseInteger(values[i]);
	  count++;
	}
	catch (NumberFormatException e) {
	   // we tried to format as a double first, and then if that failed, we ignored the value
	}

Example 3: Creating a new exception type and using the exception value

  The change we made now was to have the averaging method, if there was bad data, both compute the average and report that there was non-integer values.
  How to do that?  The return value is only int, so to return something other than int requires throwing an exception.
  Exceptions are just classes like any other class, and so let's create our own exception that will store a value.
  That way we can effectively both throw the exception and return the value by having an exception that contains the return value.

	public class BadDataException extends Exception {
		-- place a field, constructor, and getter method here for the value we want
	}

   Since this is a "checked exception", when we throw the exception, using
	throws new BadDataException(place value here);
   we also have to put "throws BadDataException" onto the method header.

   To deal with this exception, we catch it.
   In this case, the code is already handling an exception, but you can catch multiple exceptions on the same try block with:

	try {
	   code that can throw an exception
	}
	catch (ExceptionType1 e) {
	   code run if ExceptionType1 is thrown
	}
	catch (ExceptionType2 e) {
	   code run if ExceptionType2 is thrown
	}

    When an exception is thrown in the try block, Java runs through each catch statement in order stopping and running the first catch block for which the exception type of the catch equals or is wider than the exception type thrown.
    Only one catch is run, and so you should order the catch blocks appropriately.
    If the thrown exception does not match any of the catch blocks, then the exception is not caught, the method immediately halts, and the exception is further thrown to the calling method.

