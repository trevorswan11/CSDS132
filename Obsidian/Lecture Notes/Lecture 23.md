Java Shortcuts:
   Binary Operator shortcuts:
        i += 3    $\leftarrow$ shorthand for i = i + 3
             This shortcut works for all binary operators:
        x /= 10   $\leftarrow$ shorthand for x = x / 10

   Conditional Operator:
	condition ? value1 : value2
          - if condition is true, the result is value1.  Otherwise the result is value2

	Instead of 
	   if (x <= 10)
	     y = 5;
	   else
	     y = -5;
	We can write
	    y = (x <= 10) ? 5 : -5;
	    
	Instead of
	   if (x < 0)
	     return -1 * x;
	   else
	     return x;
	We can write
	   return x < 0 ? -1 * x : x;

Switch Statements:
	Multiple if statements that test equality of values:
	  if (month == 1)
	    days = 31;
	  else if (month == 2)
	    days = 28;
	  else if (month == 3)
	    days = 31;
	    $\vdots$
	Switch statements can do the same thing
	*You have to use break here, so this is an exception to the 'no break' rule*
	switch (month) {
	  case 1:
	    days = 31;
	    break;
	  case 2:
	    days = 28;
	    break;
	 
Or they can do it in a more efficient way
	switch (month) {
	  case 1:
	  case 3:
	  case 5:
	  case 7:
	  case 8:
	  case 10:
	  case 12:
	    days = 31;
	    break;
	  case 2:
	    days = 28;
	    break;
	  default:
	    days = 30;
	    break;
	}

Note that break is used to exit execution.  If a break is omitted on a case, execution "falls through" to the next case.
****
Here is an example taking advantage of the "fall through".  Suppose we want to add up the number of days since January 1 based on the current date.
	
	int days = 0;
	switch (month) {
	  case 12: days += 30;
	  case 11: days += 31;
	  case 10: days += 30;
	  case 9:  days += 31;
	  case 8:  days += 31;
	  case 7:  days += 30;
	  case 6:  days += 31;
	  case 5:  days += 30;
	  case 4:  days += 31;
 	  case 3:  days += isLeapYear(year) ? 29 : 28;
          case 2:  days += 31;
	  default: days += day - 1;
	}

**Important:** the switch statement uses == to test equality.  This works well with primitive, and it can work with objects -as long as you are testing whether two objects are the same address-.
	  (Exception, starting in Java 7, the case will test the contents of String).

#### Increment and Decrement Shortcuts
- i++   $\leftarrow$ increments i and then returns the original value of i
- ++i   $\leftarrow$ increments i by 1 and then returns the new value of i
- i--   $\leftarrow$ same but with a decrement by 1
- --i $\uparrow$

    Be careful that you use the ++ shortcut correctly!  i++ and ++i have different effects.

    Ex:   i = 5;
          i = ++i;

           1. i is incremented to 6
           2. the value of i is returned and stored into i
         The result is that i stores 6.

          i = 5;
          i = i++;

1. The value of i is returned and remembered for when the right side is done evaluating
2. The value of i is incremented to 6
3. The original remembered value of i is stored into i.
*The result is that i stored 5.*

     Increment and loops:
	for (int i = 0; i < a.length; i++)
	  a[i] = i;

	for (int i = 0; i < a.length; ++i)
	  a[i] = i;

 Both of the above loops do the same thing.  a is assigned {0, 1, 2, 3, ...}

	int i = 0;
	while (i < a.length)
	  a[i++] = i;

 	int i = 0;
	while (i < a.length)
	  a[++i] = i;

  These two loops are different.  The first assigns to a {1, 2, 3, ...}.  The second skips over the first element to give {*, 1, 2, 3, ...} but then crash when it tries to store a value in a[a.length].

       Here are two more
	int i = 0;
	while (i < a.length)
	  a[i] = ++i;

	int i = 0;
	while (i < a.length)
	  a[i] = i++;

  The first assigns to a {1, 2, 3, 4, ...} and the second assigns to a {0, 1, 2, 3, ...}

      What does this do?
	int i = 0;
	while (i < a.length - 1)
	  a[i] = a[++i];
     
      Or this?
	int i = 0;
	while (i < a.length)
	  ++a[i++];

      The first "slides" all the entries of the array one spot to the left.
      The second increases each entry in the array by one.


  Array Creation Shortcuts

	You can initialize an array as follows:
	  int[] array = new int[] {1,2,3,4,5,6,7,8,9,10}
	or
	  int[] array2 = {20, 21, 22, 23}

	You can do this for any time of array:
	  String[] welcomes = {"Hello", "Hi", "Howdy", "Hiya"}

	Arrays of arrays follows the same pattern
	  double[][] grid = {{1.2, 1.4, 2.1, 3.3}, {0.2, 1.9, -3,3, 2,1}, {3.2, 0.5, 6.4}, {1.1, 5.0, 0.4, -2.1, -1.9}}


The main method.
  The main method is a special method of Java.  Every stand-alone program must have a main method.  It is what the Java Virtual Machine calls to start your program.

  Each class may have one (and only one) main method.  The form is
        public static void main(String[] args) {

  If you have a program that contains a class with a main method, you can run your program from the command line of your computer using the Java Virtual Machine.  The JVM is a program provided by the Java runtime environment (JRE) and is pre-loaded on most computers:
        java DesiredClass 
  the above can be followed by 0 or more input values that will be passed to your main method through the String array parameter.
   (Depending on your system, you may also have to set the CLASSPATH environment property to indicate the folder where the Java files are.)
  DesiredClass must have a main method in it.
  See the MyFirstProgram class we wrote in the lecture. For example, try
	java MyFirstProgram this is a test of the program

  We can also create a stand alone program by placing all the classes of the program in a jar file.
     (We will demonstrate this when we start building larger programs later in the second half of the course.)
     (A jar file is just a collection of Java .class files, and when creating the jar file, we specify which class contains the main method that should be called when launching the program.)
  You can then run the jar file with
	java -jar jarfile
  Most operating systems will let you run a jar file by just clicking on it.  

  Finally, what should you place into the main method to run your program?
    The main method is a static method.
    The interactions pane is a static context (i.e. it acts like the body of a static method).
    So, whatever you would have typed in the interactions pane to launch the program, place into the main method.

