Designing Good Loops, part 1.

Recap of good loop design: 

**********************
*  What we want for a good algorithm:
*   - Space efficiency
*      Do not use more memory that is needed.  For example, don't create extra copies of strings (or arrays) when not explicitly needed.
*  
*   - Time efficiency
*      Do not make more traversals of the String than needed.
*        (We have to be a little careful when counting traversals because two traversals that do one operation at each step is the same as one traversal that does two operations in each step.)
*  
*   - Logical simplicity
*      The loop should do one logical task.  If we need two different tasks, we should use separate loops for each.
*  
*   - Simple iterations
*      The loop should do a single iteration with each step.
************************

*************************
* Hint for writing good algorithms:
*  Think about how you would solve the problem.
*  We usually hate doing unnecessary busy work and so our natural solutions avoid a lot of the "extra memory" isses or "extra traversal" issues of the previous solutions.
*  If we had to solve this problem using pencil and paper, we would never waste time first copying down the string again without the punctuation, and then copying another time changing the letters to lower case.
*
* One important skill is to learn how to take what we naturally do in problem solving and then breaking that down
*  into simple steps that you can write into a program.
*************************

Problems and advantages of algorithm 1:
  The algorithm is simple with each loop doing one task.
  The algorithm creates an extra, unnecessary String.
  The algorithms use multiple traversals of the String.

  How much extra memory did it use?  It created one new StringBuilder plus one new String (the toString method).  
  So, it needed more memory equal to twice the length of the string.
   (Note that if we used the + operator instead of StringBuilder, we would need more memory that is equal to the square of the length of the string!)

Here is code for algorithm 1:

	StringBuilder b = new StringBuilder();
 	for (int index = 0; index < s.length(); index = index + 1) {
	  if (Character.isLetter(s.charAt(index))
	    b.append(Charater.toUpperCase(s.charAt(index)));
	}
	return isPalindrome(b.toString());

Problems and advantages of algorithm 2:
  The algorithm does not create any extra space and does one traversal of the string
  Each inner loop does 1 task, and the outerloop then does essentially one task.
  However, the increment, from the point of view of the outer loop, is complex because the indeces will change by arbitrary amounts each iteration

int front = 0;
	int back = s.length() - 1;
	while (front < back) {
	   // repeat until front hits a letter
	   while (!Character.isLetter(s.charAt(front)))
	     front = front + 1;
	   while (!Character.isLetter(s.charAt(back)))
	     back = back - 1;
	   // now test the two characters
           if (Character.toUpperCase(s.charAt(front)) == Character.toUpperCase(s.charAt(back))) {
	     front = front + 1;
	     back = back - 1;
	   }
	   else
             return false;
	}
	return true;
	

    BUT THIS CODE IS NOT RIGHT!!!   IT WILL CRASH - We start fixing this method:

	We need to add extra conditions in the each while and in the test!
	We have to make sure each while does not move the index outside the string or s.charAt(..) will return an error.
	We need to make sure, when we test the two charaters after the while loop, that we are testing two letters.  Maybe either while loop halted because we reached the end of the string.

	int front = 0;
	int back = s.length() - 1;
	while (front < back) {
	   // repeat until front hits a letter
	   while (front < s.length() && !Character.isLetter(s.charAt(front))
	     front = front + 1;
	   while (back >= 0 && !Character.isLetter(s.charAt(back))
	     back = back - 1;
	   // now test the two characters
           if (front < s.length() && back >= 0 && Character.toUpperCase(s.charAt(front)) == Character.toUpperCase(s.charAt(back)) {
	     front = front + 1;
	     back = back - 1;
	   }
	   else
             return false;
	}
	return true;

   The point is: because we do not have all the loop increment information inside the for loop header, the writing the algorithm has become much more complicated.

   Recall, though, that this code did have the advantage of a single traversal and no extra memory created.
     So a good algorithm will keep those features but do only a simple increment at each step


Here is a better algorithm that keeps the same general logic as algorithm 3 but uses simple increments:
  1) Have two indeces, one at the front and one at the back.
  2) Repeat until done:
     2a) If the first is not a letter, move the index up one and repeat 2
     2b) Otherwise if the second is not a letter, move the index down one and repeat 2
     2c) Otherwise if both match, move both indeces one character
     2d) Otherwise we have letters that do not match and we can return false.

  This algorithm uses no extra space and does a single traversal of the String.
  The algorithm is logically simple because we are still doing one task: comparing each letter at the front to the corresponding letter at the rear.
  The loop has a simple organization because each index will increment or decrement AT MOST once each iteration, and at least one will change.
  Since either the front or end index changes, it is easy to logically reason that our loop will eventually terminate.


  public static boolean isEnglishPalindrome(String s) {
    int front = 0;
    int back = s.length() - 1;
    
    while (front < back) {
      if (/* the front is not a letter */)
        front = front + 1;
      else if (/* the back is not a letter */)
        back = back - 1;
      else if (/* the two letters not match */)
        front = front + 1;
        back = back - 1;
      else 
	return false;
      
    }
    return true;
  }


To check if things are letters and to capitalize, etc, we can either write the math code from last lecture or
  we can use the API.  There is no difference in terms of simplicity or efficiency.

  public static boolean isPalindrome(String s) {
    int front = 0;
    int back = s.length() - 1;
    
    while (front < back) {
      if (!Character.isLetter(s.charAt(front)))
        front = front + 1;
      else if (!Character.isLetter(s.charAt(back)))
        back = back - 1;
      else if (Character.toUpperCase(s.charAt(front)) == Character.toUpperCase(s.charAt(back)) {
        front = front + 1;
        back = back - 1;
      }
      else
        return false;
    }
    return true;
  }




Testing Loops

  It can be hard to find errors in loops.  Sometimes an error does not show up until the loop has run for a while.
  Here is a "mantra" that you can use to find test cases that catch a large number of common mistakes.

	1. Test 0, test 1, test many
	2. Test first, test middle, test last

  The idea is that errors often occur early in a loop (what if the loop condition is immediately false, or if the loop only does one iteration),
   of they can show up in not stopping at the right time.  Or an error can accumulate over multiple iterations.
  
  You can use this to think in terms of what your loop does:
    Can you make a tests where the loop does not run, where the loop does one iteration, or where the loop does many iterations?
    What is your loop trying to accomplish.  Can you make the conditions it checks happen early in the data or late in the data?

  For example, in isEnglishPalindrome, we can come up with the following tests.
	Test 0, test 1, test many can be interpreted to mean:
		a) test on strings of length 0, length 1, and length large.
		b) test on strings that have 0 letters (but plenty of other non-letters), only 1 letter, or many letters.
	Test first, test middle, test last
		a) test on strings where the "mismatched letters" happens at the very beginning/end of the string, where the mismatched letters happens around 1/4, 3/4, and where the mismatched letters happens right in the middle of the string.
			(Note that because the loop starts at the ends and works to the middle, "test last" would refer to the very middle when the loop finished.)
		b) test on strings where the non-letters appear at the beginning, the middle, and the end of the string.
