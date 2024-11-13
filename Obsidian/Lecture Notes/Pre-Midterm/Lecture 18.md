Multidimensional Arrays
#### Java does not have multi-dimensional arrays.
  Instead, Java allows arrays to store other arrays.

  For example, to declare and create an array storing double:
	double[] array = new double[10];
  To declare and create an array of arrays that stores int:
	int[][] grid = new int[5][8];

  We read the type right to left.  The right most [] indicates that we have an array, and what comes before the [] (i.e. "int[]") indicates the type stored in the array.
  We read the array creation left to right.  What we have is an array of 5 elements, and each element is an array of 8 JFrames.

  To access an element:
     grid[3][5]   <-  again we read left to right.  In the first array, we go to the 4th element.  That element is an array of int.  (We can think of it as the 4th row of the grid.)
                        Then, we go to the 6th element of that array.  (We can think of it as going to the 6th column of the array.)

	- but if thinking of the array as rows and columns, always remember that there is no "column" stored in memory.  We just have an array storing arrays.

  It is useful to think of the different arrays separately.

  Since it is an array storing arrays, we can do things in Java that you can't do with a "real" multidimensional array.

	int[][] grid = new int[10][];   // creates an array of 10 "rows", each row is an array but we have not created it yet
	grid[3] = new int[100];		// now the 4th "row" is length 100 (but the others all still have length 5
	grid[4] = a[3]			// the 5th row is also the 4th row
	grid[0] = null;			// the 1st "row" is now gone

Example: loop through the elements of a two dimensional array

	int[][] grid = new int[10][3];              // here we are creating 10 arrays, each is an array of 3 ints
```ad-note
int[][] grid = new int[amount of arrays][array size]

or 

grid[index of array][index in array]
```

	for (int i = 0; i < grid.length; i = i + 1) {	        <-  notice that nothing has changed from how we traverse through a "normal" array
	  for (int j = 0; j < grid[i].length; j = j + 1) { 	<-  nothing changed here, except that the array we are going to traverse through has its address stored in grid[i]
	     grid[i][j] = .....;

You do not have to specify all the sizes of the array as long as what you declare can be a valid array

	String[][] biggerArray = new String[5][];
    This creates an array of size 5, each element will store an array of String, but each element will only be storing null (i.e. not an array).

#### Sizes of nested arrays do not have to be the same

More On Writing Good Loops - two examples from lab

  Reminder: we want our loops space efficient (don't create extra arrays), time efficient (don't do too many traversals of the data), logically simple (each loop does one task), and use a simple increment (always increment by the same amount at each step).

 1. The first example is removing an element from an array. 
  /**
   * Remove k from list[0..n-1].
   * Precondition: list[0..n-1] is sorted, and k is an element of list[0..n-1].
   * Postcondition: list[0..n-2] is sorted.
   * @param list the sorted array.
   * @param n the number of items in list.
   * @param k the number to remove from list.
   */
  public static void remove(int[] list, int n, int k) {

   An obvious, but not optimal, algorithm:
	Have a boolean variable indicate whether we have located k.
	Create a single loop from 0 to n. 
	  If we find k, set the indicator variable to true.
	  If the indicator variable is true and this is not the last index, shift the next element down to this element.

   This loop idea will work fine.  However, it is more complicated than needed and will run slightly slower than needed.
    The problem is that the loop does two tasks.  We need if statements to check for which task we are doing, and we need a special
     if statement to avoid a possible error at the end of the loop.

  We can make the code much simpler by breaking the loop into two.  Each loop does one task.  The first loop finds k.
   The second loop shifts everything after k down one index.

  /**
   * Remove k from list[0..n-1].
   * Precondition: list[0..n-1] is sorted, and k is an element of list[0..n-1].
   * Postcondition: list[0..n-2] is sorted.
   * @param list the sorted array.
   * @param n the number of items in list.
   * @param k the number to remove from list.
   */
  public static void remove(int[] list, int n, int k) {
    int i;

    // step 1: find index of k
    for (i = 0; i < n && k != list[i]; i = i + 1)
      ;
          // <- at this point, k = list[i] (or i == n if k is not in the list)

    // step 2: remove k and slide the rest of the entries down
    for (; i < n - 1; i = i + 1)
      list[i] = list[i + 1];
  }

 2. The second example is adding an element to the array.  
  /**
   * Add k to list[0..n-1].
   * Precondition: list[0..n-1] is sorted and list[n] is unused.
   * Postcondition: list[0..n] is sorted, and list contains k.
   * @param list the sorted array.
   * @param n the number of items in list.
   * @param k the number to add to list.
   */
  public static void insert(int[] list, int n, int k) {

    An obvious, but not optimal, algorithm:
	Have a loop that runs through until we find an index with list[index] <= k <= list[index + 1]
	Now shift everything up by using a saved value that starts at k.  Repeat: save the value at index + 1, place the previously saved value into index + 1, increment the index.
    This sliding is complex and requires extra memory and is a little complex to write.

    A better solution is to write a loop that runs from the back to the front, sliding as it goes.  
    (Note that we do not need to find the location for k first.  Instead, we just slide and stop when we get to the spot for k.)
    It is a little tricky getting the stopping condition right.  Logic helps! 

    // Start from back, slide each element to the right, and stop when we get to the spot where k goes
    for (i = n - 1; i >= 0 && k < list[i]; i = i - 1) {
      list[i] = list[i + 1];
    }
        // <- at this point, we have k >= list[i] OR i == -1 
    list[i + 1] = k;
  }

Morals of the Lecture:
  1) Break a problem up into smaller tasks.  Use a separate loop for each task.
  2) Place all stopping criteria in the condition of the loop.
  3) Sometimes, working in "reverse" leads to simpler code.  Always think about the problem in both directions.
  In each case, we ended up with simpler loops that were easier to code, and our programs will run faster because there are fewer steps inside each loop.


```ad-important
title: **Never use Break!!!!**
```
