  The Java API (Application Program Interface)
  An API is typically part of any pre-defined software package that you can use in your programs.
    It lists how you are to use the predefined programs.

  The Java API lists all the pre-defined classes (and other types) in Java.
  In the API you can find:
    the package the class is in (what you need to import)
    the header for the class
    a list of all non-private inner classes, constructors (what new uses to initialize the object), fields, and methods

  Keep the API bookmarked because we will be using it a lot in the course.



Introduction to Arrays

  An array is a collection of variables of the same type, stored in a contiguous chunk of memory.

  We can create an array to hold variables of any type:
     int[] array1      - array1 is an array that will store ints
     JFrame[] array2   - array2 is an array that will store JFrames
     double[] array3   - array3 is an array that will store doubles

  We can initialize the array using the new operator and stating how many variables (elements) will be in the array:
        array1 = new int[100];
  array1 now stores the address for an array that contains 100 int variables.
 	array2 = new JFrame[30];
  array2 now stores the address for an array that contains 30 JFrame variables.


  Now, to access each element, we again use the square brackets.  To store a value in the first element (variable) of the array:
        array1[0] = 12;
        array1[4] = array[0] + 50;

  Remember, the we start counting from 0 in Java!

  Each element of an array is a variable of the given type.  So all the rules of variables apply.
	array1[2] is a variable of type int.  It can store int, but it can't store double or boolean or a nonprimitive type


Array disadvantage:
  Because the array is stored in contiguous memory, we can not change the length (number of variables) of the array once it is created.

Array advantage:
  Because the array is stored in contiguous memory, we can access each element in a single step, no matter how large:
	int[] a = new int[1000000];
    For example, to access a[95436], we do not need to run through the array to the 95436'th entry.
    We know the address of a (it is stored in the variable a), we know the byte size of the type of the array (for example, each int is 4 bytes)
     and we know which one we want (index 95436).
    So the address of a[95436] is:  (address of a) + 4 * 95436

Manipulating Arrays

  Reminder that an array is a non-primitive type that represents multiple variables of the same type that are allocated in contiguous memory.
  Being in contiguous memory means that we get fast access to any element of the array.
  Being in contiguous memory also means that we can't change the size (number of elements) of an array after we create it.

How do we fill an array?
  Usually with a loop. 
	JFrame[] frames;           // frames will store (the location to) an array that stores JFrames
        frames = new JFrame[30];   // now frames has the address of a chunk of memory divided into 30 variables of type JFrame.  But no JFrame is yet stored in frames.  To place a separate JFrame in each one:

	for (int index = 0; index < frames.length; index = index + 1) {
	  frames[index] = new JFrame();
	}

  If you have a small array, then you don't need a loop.  You can enter the elements on at a time, or you can use an "array constructor" shortcut.  See the textbook reading for more.


Example 1: Reversing the contents of an array
  Create a method that reverses the contents of an array
  Each slot in the array is just a variable and so we will use variable assignment.
  We will need one extra variable to store values so we do not lose any values.
	1. save the value at the front of the array into a temporary variable.
	2. copy the value from the back of the array to the front of the array.
	3. store the saved value to the back of the array.

   When do we stop the loop?  When we have gone through half of the loop.  Can you see what happens if we iterate through the entire array?

   Here is the version from class using variables for the left and right side of the array:
	public static void reverse(int[] array) {
	  for (int left = 0, right = array.length - 1; left < right; left = left + 1, right = right - 1) {
	    int temp = array[left];                       // save the value in front of the array because we are about to overwrite it
	    array[left] = array[right];
	    array[right] = temp;
	  }
	}

   Here is a version using one index variable:
	public static void reverse(double[] array) {
	  for (int index = 0; index < length / 2; index = index + 1) {
	    double save = array[index];
	    array[index] = array[array.length - 1 - index];
	    array[array.length - 1 - index] = save;
	  }
	}

Example 2: "increasing" the size of an array

  Create a method that takes an int array and an int.  The array is full, but we need to put the int value at the end of the array.
  We can't change the size of an array, so instead, we must create a brand new array, copy the values over, and then put the new value at the end.

	public static int[] addToEnd(int x, int[] array) {
	  int[] newarray = new int[array.length + 1];

	  for (int index = 0; index < array.length; index = index + 1)
	    newarray[index] = array[index];

	  newarray[newarray.length - 1] = x;

	  return newarray;
	}

  First, note that we needed a loop to do the copy.  If we write "newarray = array;" we instead copy the address of array to newarray.
    That has the affect of having both newarray and array point to the same array.

  Second, note that we copied the new value x in after the loop was over.  This is simpler than trying to do the copy inside the loop body.
    To keep the coding simple, each loop should have only one task.  In this case, the loop task is to just copy the data from the original array to the new array.

  Third, note that we had to return newarray.  If we did not, we would lose the newarray.  
     newarray is a local variable and so it is lost once the method ends.
     When the method ends, all local variables and method parameters are removed from memory.
        If we lose newarray, we lose the address to the new array.
     By returning the new address, we can have it outside the method.
     Another incorrect assumption is to have an assignment statement:  array = newarray.  
      This would copy the address of newarray to array, but it has the same problem because array is a method parameter.  Thus array will be lost once the method ends.

  Example:
	myArray = addToEnd(myArray, 11);
  Will create a new array one larger than myArray, copy the data over, add 11 to the end, and then return the address of the new array, and that address is stored in myArray.
  myArray now points to a new array one larger than the array it originally pointed to.  The old array is still in memory. Java will eventually de-allocate it if there are no other variables storing its address.