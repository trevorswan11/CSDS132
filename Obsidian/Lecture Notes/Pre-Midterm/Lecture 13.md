For Loops and Strings:
  In this lecture, we wrote loops on strings, and we used for loops for the loops.

  For loops work well when the increment is simple.
  The advantage of a for loop is that all the loop control information is on a single line.

Strings:

  Recall that String is a class that represents text.  A String object can not be changed once created.
  Some useful methods and operators:
    +:  creates a new String that is the result of concatentating two Strings
    length():  returns the number of characters in the String
    charAt(5): returns the 6th character of the String.  (In Java, the first character is at index 0.)

  So,
    String s = "Hello"
    s.length()  =>  returns 5
    s.charAt(1) =>  returns 'e'
    s.charAt(s.length()) => gives an error because it asks for the index 5 in a string with only 5 characters
    s.charAt(s.length() - 1) -> returns 'o' 
    "Hello there!".length()  -> returns 12 because every character is counted (including the space and !)

For Loop Example 1:  Write a method that determines if a String is a palindrome (the same forward as backwards).  For example "radar" is a palindrome.
 
  The trick is to first think how YOU would do it.  What are the different steps you need?
    - You read the string backwards and compare with how it is read forwards.
    - That means you first compare the first character with the last, then the 2nd with the 2nd to last, and so on.

  So, we need two variables: one to keep track of where we are at the start of the string, and one to keep track of were we are at the end of the string:
  We decided to do a for loop because we have a simple increment:
	for (int first = 0, last = s.length() - 1; ???; first = first + 1, last = last - 1)

  What test do we need?
	if (s.charAt(first) == s.charAt(last)) 
              // then keep going
	else
	      // it can't be a palindrome

    There is nothing to do if we need to keep going.  The index as to be increased, but that is being done by the increment statement if the for loop.
    So our code so far is:

	public static boolean isPalindrome(String s) {
	  for (int first = 0, last = s.length() - 1; ???; first = first + 1, last = last - 1)
	    if (s.charAt(first) == s.charAt(last)) 
              ;                // then keep going
	    else
	      return false;    // it can't be a palindrome

    
  
    The empty statement is a little awkward.  Sometimes, empty statements are not easy to avoid.  Here we can easily avoid it by switching the then and else statements and doing the opposite condition.
     Since the else is an empty statement, we can drop it.

	public static boolean isPalindrome(String s) {
	  for (int first = 0, last = s.length() - 1; ???; first = first + 1, last = last - 1)
	    if (s.charAt(first) != s.charAt(last)) 
	      return false;    // it can't be a palindrome

    What is the goal we want to achieve when we get to the end of the loop?  We want our loop to catch every time that s is not a palindrome, so if we get all the way to the end of the loop without returning,
     we know that s must be a palindrome.

	public static boolean isPalindrome(String s) {
	  for (int first = 0, last = s.length() - 1; ???; first = first + 1, last = last - 1)
	    if (s.charAt(first) != s.charAt(last)) 
	      return false;    // it can't be a palindrome
	  }
	  return true;         // the loop completed without finding a mismatch, so s is a palindrome
	}

     When do we stop?
     If we stop when first == last (and the string has odd length) then we will have tested all but the very center character.  Since the center character is (obviously) equal to itself, we don't actually have to test it.
     If we stop when first == last + 1 (and the string has even length) then we will have tested every character.
     So, we stop when first >= last, and our loop condition is the opposite: first < last.

	public static boolean isPalindrome(String s) {
          // compare the characters at 0..(first-1) against the characters (length-1)..(last+1)
          // and exit the method if we find a mismatch
	  for (int first = 0, last = s.length() - 1; first < last; first = first + 1, last = last - 1)
	    if (s.charAt(first) != s.charAt(last)) 
	      return false;    // it can't be a palindrome
	  }
	  return true;         // the loop completed without finding a mismatch, so s is a palindrome
	}

   Note that we only need one variable to keep track of which characters we are examining instead of two.
   Here is the same method, but using a single index variable instead of two. 

	public static boolean isPalindrome(String s) {
          // compare the first "offset" characters against the last "offset" characters, exit the method if we find a mismatch
	  for (int offset = 0; offset < s.length() / 2; offset = offset + 1)
	    if (s.charAt(offset) != s.charAt(s.length() - 1 - offset)) 
	      return false;    // it can't be a palindrome
	  }
	  return true;         // the loop completed without finding a mismatch, so s is a palindrome
	}
  
Creating Strings:

  When building a string using a loop, we may be tempted to use the + operator. 
	String result = "";

	for (....) {
	  ....
	  result = result + c;
	  ....
	}
	return result;
  However, this is not a good solution.  The + operator creates a new String each time.  If we are dealing with a very long String, such as if we want to capitalize a DNA code of millions of characters,
   we will be creating a LOT of unnecessary Strings and using up our memory.

   	String s = "Hello";
	for (int i = 0; i < 100000; i = i + 1)
	   s = s + "!";

        This will create 100000 new strings!  That is a lot of unnecessary memory usage.

  Java provides a StringBuilder class to create Strings.
    StringBuilder has all the same methods as String (charAt, length, etc) plus several others.
    Once useful one is append that adds new characters (or other values) to the end of the string being created.
    StringBuilder is not a string.  Instead, it is a class that optimizes the amount of memory used when creating a string.

    How to create an empty StringBuilder?  Just like you create any other initial instance:   StringBuilder result = new StringBuilder();

    What do we return at the end?  We can't return result because it is not a String.  But Object has a method that returns a String representation, and every class inherits it from Object.
	result.toString();


For Loop Example 2:
  Write a method that capitalizes every lower case letter in a string.
  How would we do it?
    Look at each character one at a time.  If it is lower case, capitalize it.  If it is not lower case, keep it.

  Note that we can not change the String so we must create a new String that is the same as the original, but with capital letters.

    Finally, how to we test if letters are lower case, and how to make them upper case?
      One way is to use methods from the Character class:
	Character.isLetter(c): will return true if the character stored in c represents a letter
	Character.toUppercase(c): will return an upper case version of the character stored in c.

      Here is another way that takes advantage of how computers make everything a number.  This trick will work in most programing languages.
       Since characters are numbers, we can treat them as numbers.
       That means we can test to see if the "number" of the letter is in the proper range of lowercase letters.
       We can also use math to "shift" a value from one range to another.
       We must remember that that applying a primitive arithmetic operator will result in an int type so we will need to remember to typecast back to char.

	  public static String capitalize(String s) {
	    StringBuilder builder = new StringBuilder();
    
	    for (int index = 0; index < s.length(); index = index + 1) {
	      char c = s.charAt(index);
	      if (c >= 'a' && c <= 'z')
	        c = (char)(c - 'a' + 'A');

	      builder.append(c);
	    }
	    return builder.toString();
	  }
                      
