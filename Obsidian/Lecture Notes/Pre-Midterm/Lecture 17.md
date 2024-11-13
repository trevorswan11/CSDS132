Binary Search - *Relies on a Sorted List*
1. Examine middle element
2. If the middle element is smaller than x, search in the upper half
3. If the middle element is bigger than x, search in the lower half
Only checks $\frac{n}{2}$ elements
#### Can be repeated for larger array sizes
n elements $\to$ $\frac{n}{2}$ elements $\to \frac{n}{4}\text{ elements}\to\dots\to \frac{n}{n}$ elements
$\log_2 n +1$ Programming is done in base 2, so 2 is assumed leaving us with:
$$
\log_2n+1
$$
#### Number of Traversals of Algorithm
****

| Array Size | Linear Search | Binary Search |
| ---------- | ------------- | ------------- |
| 8          | 8             | 4             |
| 1000       | 1000          | 11            |
| 1000000    | 1000000       | 21            |
| 1000000000 | 1000000000    | 31            |
Binary Search is very efficient, but it relies on a sorted list!
## Goals for Loops
Decide an actual goal for the loop, the establish subgoals
Properties of subgoals (per iteration)
1. Subgoal is true before entering the loop
2. Subgoal is true after each iteration
3. Subgoal and loop condition being false logically implies the goal of the loop
#### Loop Goals for Binary Search
1. **Goal:** At the end of the loop, x should not be in array
2. **Subgoal:** If x is in the array, it is in array $\text{[start...end]}$
	- Start == end, loop condition is false
		"If x is in the array, it is in array $\text{[end...end]}$"

Linear Searching in an Array

  Here is a standard loop for searching for an item in an array:

	public static int linearSearch(double x, double[] array) {
	  for (int index = 0; index < array.length; index = index + 1) {
	    if (x == array[index])
	      return index;
	  } 			// at this point index = array.length so we checked all entries of array
	  return -1;
	}

  What if we want to search for a String in an array of Strings?  Because of how typecasting arrays works, we can create one method for Object arrays and we can use it with all arrays of non-primitive values:

	public static int linearSearch(Object x, Object[] array) {
	  for (int index = 0; index < array.length; index = index + 1) {
	    if (x.equals(array[index]))
	      return index;
	  } 			// at this point index = array.length so we checked all entries of array
	  return -1;
	}

  So, if we want a search to work for all possible array types, we have to overload the method with 9 versions.  One for Object and one for each of the 8 primitive types.

  Can we write a faster algorithm to search for an element in an array?
    No!  What is the proof?  No matter how we decide to run through the array, until we look at every location, we can not be sure if x is not in the array.

  So, unless we know more information about the array, our linearSearch method is optimal.

Binary Search, More on Reasoning About Loops

  Suppse the array is sorted in non-decreasing order.  Now can we write a faster method?
    Proposed Algorithm (Binary Search)
     1. Examine the middle element.
     2. If the middle element is smaller than x, repeat on the upper half of the array.
     3. If the middle element is larger than x, repeat on the bottom half of the array.

   Is this a lot faster than linear search? 

   We start with a list of n elements, and each time, we cut the number of elements we are considering in half.
   n -> n/2 -> n/4 -> n/8 -> ... -> 1
   So, the number of iterations (and the number of elements of the array we check) is k where n / (2^(k-1)) = 1.
   k = log(base 2) n + 1

  How much an improvement is this over linear search?
        Array size              # elements linear search checks         # elements binary search checks
        8                       8                                       4
        1000                    1000                                    11
        1,000,000               1,000,000                               21
        1,000,000,000           1,000,000,000                           31
        1,000,000,000,000,000   1,000,000,000,000,000                   51


   So, it is very worth it to write this method.  
   Here is our first incorrect attempt:

	/** Return the index of x in a or -1 if x is not in array.
	  * Precondition: a is sorted in non-decreasing order
          */
	public static int binarySearch(int x, int[] array) {
	  int start = 0;                      // stores the smallest index of array in the region still being considered
	  int end   = array.length - 1;       // stores the largest index of array in the region still being considered
	  while (start < end ) {
	    int mid = (start + end ) / 2;
	    if (x < array[mid])
	      end  = mid;
	    else if (x > array[mid])
	      start = mid;
	    else /* only other case is x == array[mid] */
	      return mid;
	  } 
	  return -1;
	}


   Loops are tricky to get completely correct so it is not surprising that our first attempt is not quite correct.
    Because of that, computer scientists have developed mathematical logic to reason about loops.

    First, we have to decide what the goal of our loop is.  That is something we -should- be able to do since we are writing the code.
      (Note, this is another reason why we want our loops to do just one task.  It makes describing the goal easier.)

    Given the goal for the loop, we must next determine what the -subgoal- for each loop iteration is.
      The subgoal (in formal math terms the subgoal is called the "loop invariant") is what we need to accomplish with each iteration
        of the loop in order to achieve the goal.

    Verifying that a loop is correct means that we verify that we are able to achieve the subgoal after each iteration,
      that we have a correct subgoal in order to achieve the desired goal,
      and we verify that the loop will eventually stop.

    A correct subgoal has the following properties:
        a) The subgoal is true just before entering the loop.
        b) The subgoal is true after each iteration of the loop.
        c) The subgoal AND the loop condition being false logically implies the goal of the looo.

    Let us check the reasoning of our loop.
	1) What is the goal:
		At the end of the loop, x should not be in array. (Because if we reached the end of the loop, we did not return x.)
	2) What is the subgoal for each loop iteration:
		After each iteration, if x is in array, it is in array[start...end ] (i.e. it is between start and end ,inclusive).

	   Now let us verify the subgoal.  Recall the three properties we need:
		a) The subgoal is true just before entering the loop.
		b) The subgoal is true at the end of each loop iteration.
		c) When the loop condition becomes false, the subgoal and the conditiond being false logically implies the goal.

	   Property a is easy to verify.  Before we start the loop, start = 0 and end  = array.length - 1.  Of course, if x is in array it will be in array[0..length-1].
	   Property c is does not hold in our loop:
		c) When the loop condition becomes false, the subgoal and the condition being false implies the goal.
		   The loop condition becomes false when start == end .
		   The subgoal is now:
		    "If x is in array, it is in array[end...end]"
	           That does NOT logically imply the loop goal!  x could still be in array if x is at array[end].

   Using the logic reasoning, we see that our loop is incorrect. Maybe thorough testing would have found this problem, but the error will only occur in specific situations (do you see why?).
   Let us fix the method by changing the loop condition so that when it is false we do get the loop goal:
	  while (start <= end ) {
   Now, when the loop stops, start = end + 1 and so the loop subgoal becomes "if x is in array, it is in array[(end+1)..end]", and an array where the first index is larger than the last index is mathematically empty.


   Next, we will check point (b): the subgoal must be true after each iteration. 
    We went over this part briefly in lecture.
    The way you verify this is check that if the loop subgoal is true at the start of the iteration, then it is still true
       at the end of the iteration.
    See if you can reason through the code and verify that we always achieve the loop subgoal.

   Are we done?  We verified the loop subgoal so the logic of our loop is correct, but we still must verify that the loop terminates.
     Having a logically correct loop does no good if the loop runs forever.

   Are we guaranteed that the loop will terminate, or could it run forever?
     To guarantee that it does not run forever, we have to show that the gap between start and end  decreases with each iteration.  Thus, either start increases or end  decreases.
     Is it possible to have a situation where start and end do not change?  YES!!  Consider start = 5 and end  = 6 and the element we are looking for is at index 6.  
     Note that in this situation, mid = 5, array[mid] is smaller than the element, and so start = mid = 5.  start never changed!
     What is our fix?  To note that we know that the element is not at the array[mid] and so we will not include it.
     Since we know that start <= mid <= end , setting start = mid + 1 and end  = mid - 1 guarantees that either start is increased or end  is decreased on each iteration.


   Here is the corrected code:

	/** Return the index of x in a or -1 if x is not in array.
	  * Precondition: a is sorted in non-decreasing order
	  */
	public static int binarySearch(int x, int[] array) {
	  int start = 0;                      // stores the smallest index of array in the region still being considered
	  int end  = array.length - 1;        // stores the largest index of array in the region still being considered
	  while (start <= end ) {
	    int mid = (start + end ) / 2;
	    if (x < array[mid])
	      end = mid - 1;
	    else if (x > array[mid])
	      start = mid + 1;
	    else /* only other case is x == array[mid] */
	      return mid;
	  } 
	  return -1;
	}


  The moral:  using the formal logic reasoning helps us design correct loops before we code them into the program.


Loop Testing

  How to test loops?
  Here is a good "rule of thumb" to follow to help you catch most of the usualy bugs that can show up in loops:
  1) Test 0, test 1, test many
  2) Test first, test middle, test last

  Consider the binarySearch method.  What does "test 0, tests 1, test many" mean?
    One interpretation is test arrays of length 0, 1, and many.

  What does "test first, test middle, test last" mean?
    One interpretation is to test where we are searching for an element in at the front of the array, an element at the back, and an element somewhere in the middle.

    Another interpretation is to test where we find the elemenet quickly (the first iteration of the loop), and one where the loop runs to the end (the element is not in the array).

  So, this guide suggests that we have to test the following array lengths:  0, 1, and large, and we have to search for the middle element, elements not the middle, the element at the front, the element at the end, and elements that are not in the array: one smaller than all elements in the array, one larger than all elements in the array, and one that falls between the largest and smallest.

