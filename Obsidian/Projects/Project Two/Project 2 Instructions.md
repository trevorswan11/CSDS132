## Programming Project 2

### Due Friday, March 1 at 11:59pm

_**IMPORTANT:** Read the **Do's and Dont's** in the **Course Honor Policy** found on Canvas._

### I. Overview

This second programming assignment is to give you practice writing loops and manipulating strings. Arrays are not needed, and _and you should not use arrays in your assignment_.

### II. Code Readability (20% of your project grade)

As with the last project, you are required to have code that is easy for another person to read and understand. To accomplish that, the class will have certain rules about how your code should look.

**To receive the full readability marks, your code must follow the following guideline:**

- You should place a comment at the top of the file that contains your name and a short description of the purpose of the class.
- You should place a _short_ comment before (directly above) each method describing the method. The comment should be only describe _what_ the method does, not _how_ it does it. Do not simply copy the descriptions below for your comments.
- You should place a short comment directly above each field (should you really have any?) indicating the purpose of the variable.
- You should place a short comment above or to the right of each local variable explaining the purpose of the variable. _Variables that are only used as loop indexes do not need to have comments._
- You should place a short comment above each loop explaining how the loop works. Ideally, you should list the goal of the loop, any required precondition for the loop, and if you can, a good iteration subgoal for the loop.
- Any other complicated code such as code the has lots of if statements or variables should contain _short_ comments to help the reader. The comments can either be above the code fragment or to the right, aligned in a column.
- Remember to use good style: everything should be indented nicely, variables should have good names, there should be a blank line between each method.

---

### III. Program Testing Document (20% of your project grade)
[[tcs94_CSDS132_Testing2]]
As with the previous project, you are required to submit a document demonstrating that you thoroughly tested your program. In this case, it means documenting tests for each of the methods listed below. If you are unable to complete a method above, you should still describe tests that would test the method had it been completed.

Hints for testing loops. Your tests need to, at the minimum cover the following cases:

1. **Test 0, test 1, test many:** This means you have to test cases where the parameters, if they are integers, are 0, 1 or some value other than 1. If the parameters are strings, you have to test strings of length 0, 1, and more than 1. If the strings must contain certain data, you need to test cases where they contain 0, 1, and more than 1 of the desired data.
2. **Test first, last, and middle:** In cases where you have to search in or modify a string, you need to test cases where the item to be found or modified is the first character of the string, the last character of the string, or somewhere in the middle of the string.

**What must go in the report:** For each method below, your report should describe, in English, what "_test 0, 1, many_" and "_test first, middle, last_" mean for each of the methods. Then, you should list the specific tests that you will do, what the expected output is, and then (if you completed the method) a cut-and-paste from DrJava showing the actual test.

**JUnit**: you were introduced to JUnit in a recent lab. JUnit will be required for future homeworks, and you are welcome to use it with this homework. If you choose to write JUnit tests for your code, you do not need to include the actual tests in your report. Your JUnit file should include comments with each test that link to the report and indicate what you are testing. For example, if your report indicates that the method requires a test with a string of length 0, your JUnit class should have such a test and a comment on the test noting that it is the test of a length 0 string that your report described. Try to organize the JUnit class and report to make it easy for a reader to jump back and forth between the report and the tests.
```ad-info
title: Summary of tests
Each method should have, at a minimum, these 6 tests
- Test 0
- Test 1
- Test many
- Test first
- Test middle
- Test last
```
---

### IV. Java Programming (55% of your grade)

**Guidelines for the program**:

- All methods listed below must be public and static.
- If your code is using a loop to modify or create a string, you need to use the StringBuilder class from the API.
- Keep the loops simple but also efficient. Remember that you want each loop to do only one "task" while also avoiding unnecessary traversals of the data or lots of unnecessary extra memory.
- No additional methods are needed. However, you may write additional _private_ helper methods, but you still need to have efficient and simple algorithms. Do not write helper methods that do a significant number of _unnecessary_ traversals of the data.
- **_Important_**: you must not use either break or continue in your code. These two commands almost always are used to compensate for a poorly designed loop. Likewise, you must not write code that mimics what break does. Instead, re-write your loop so that the loop logic does not need break-type behavior.
- While it may be tempting to hunt through the API to find classes and methods that can shorten your code, you may not do that. The first reason is that this homework is an exercise in writing loops, not in using the API. The second reason is that in a lot of cases, the API methods may shorten the _writing_ of your code but increase its _running time_. The only classes and methods you can use are listed below. Note: if a method you want to use from the API is not listed, you should _not_ implement the method yourself so you can use it. Rather, you shoud look for the solution that does not need that method.
    
    You _are allowed_ to use the following from the Java API:
    
    - class String
        - length
        - charAt
    - class StringBuilder
        - length
        - charAt
        - append
        - toString
    - class Character
        - any method
    

Create a class called HW2 that contains the following static methods:

1. **samePrefix** takes two String s and one int parameter and returns a boolean:  
    Let x be the input int value (though you should use a better name). The method should return true if the first x characters of each input String are exactly the same.
    
    samePrefix("this is a test", "this is a trial", 11) should return true
    samePrefix("this is a test", "this is a trial", 12)  should return false 
    samePrefix("this is a test", "This is a trial", 4)  should return false 
    samePrefix("this is a test", "this is a test", 100) should return false 
    
2. **matchingParentheses** takes a String as input and returns a boolean:  
    The method should return true if all the parentheses (if any) in the input are properly matched. Any closing parenthesis ')' should be preceded by a matching open parenthesis '(' and there should be exactly one open parenthesis for each closed parenthesis.
    
    matchingParentheses("This is a (test (of the) (matching)) parentheses") should return true
    matchingParentheses("The (second closing) parenthesis) does not match") should return false
    
3. **removeEveryKthWord**: takes a String and an int as input and returns a String. The input number is a value _k_ such that the output string is the same as the input string except that every _k_th word plus the whitespace immediately following that word is removed. If the input is not a positive number, the output will be the same as the original string.
    
    removeEveryKthWord("Four score and seven years ago our fore fathers", 3)     should return "Four score seven years our fore "
    removeEveryKthWord(" Every Who down in Whoville liked Christmas a lot!", 2)  should return " Every down Whoville Christmas lot!"
    
4. **flipEachK** should take a String and an int as input and returns a String.  
    Let _k_ be the name of the input integer. The output string should contain the first _k_ characters of the input string in order, the next _k_ characters of the input string in reverse order, the next _k_ characters of the input string in normal order, and so on. The output string should have all the characters of the input string and no others.
    
    flipEachK("abcdefghijklmn", 4) should return "abcdhgfeijklnm"
    
5. **reverseDigits** should take a String as input and output a String.  
    The output String should be identical to the input String except all digits (0 through 9) of the input String are in reverse order (but same locations) in the output String.  
    
    reverseDigits("0 the d1gits of the2 string3 4 are8 reversed 9!") should return "9 the d8gits of the4 string3 2 are1 reversed 0!"
    
6. **replaceText** takes two Strings as input and returns a String.  
    Each input string will have text with zero or more substrings marked by matching parentheses. The returned string should contain the contents of the first string, except that each substring that is inside parentheses in the first input string is replaced by the matching substring that is inside parentheses in the second input string. (So the first substring of string 1 is replaced by the first substring of string 2, the second by the second, and so on.) If the first input string has more substrings in matching parentheses than the second string does, the substrings are simply removed. If the second string has more substrings in matching parentheses, these are ignored. Any nested and matched parentheses (matched parentheses inside the outer set of matched parentheses) should be treated as regular characters.  
    
    replaceText("a (simple) programming (example)", "(cool) (problem)") should return "a cool programming problem"
    replaceText("a ((nested) example) with (three) replacements (to (handle))", "the replacements are (answer) and (really (two) not three)") should return "a answer with really (two) not three replacements "
```ad-example
title: Cases to consider
- $(((\text{hello}()))))()$ $\to$ $(++++----)$ should be the substrig bc $-+-$ is mismatched
- 
```
**Note: As in the examples, the behavior for unmatched parentheses is up to you, but your method should not crash.**
```ad-abstract
title: Algorithm
1. Establish variables to keep track of where you are in the two strings
2. Create a StringBuilder instance to assist in the creation of the modified String
3. Loop through the strings while the indices from step 1 are less than the length of their respective strings
4. Append characters from the base unless an open parenthesis is found
5. If this is the case, find the first set of matching parenthesis in the base String
6. Remember the starting index of the matched delimiters, and also the ending index of them
7. If Step 4 does not find anything, then the base string is returned unaltered
8. If matching parentheses are not found anywhere, then the base string is returned unaltered
9. If there are matching parentheses found, then find the first set of matching parentheses in the replacement string
10. If there are no matching parentheses in the replacements, return the original string
11. If matching one are found, remember their indices
12. Append Everything in the replacement matched parentheses besides the opening and closing parentheses to the modified string.
13. Set the appending index of the base string to be one after the remebered index from step 6
14. Repeat the process until their are no more matching parentheses in either string.
15. If this happens for the base string first, then do not take any different appening action
16. If the second string runs out of substrings, then the appending should stop before the next matching parentheses from the base string is appended 
```
#### I consulted April for some help
	This is the outline of the code she came up with
```
// Create a new StringBuilder to assist in the modification of the baseString
	StringBuilder newString = new StringBuilder("");

	// Create indexes for both the baseString and replacement string 
	int replacementIdx = 0;
	int baseIdx = 0;
	int pIss = 0;
	boolean activated = false;

	// Loop through the entire baseString and replacement String until the indices are exhausted
	while (baseIdx < baseString.length() && replacementIdx < replacement.length()) {
		if (baseString.charAt(baseIdx) == '(') {
			while (baseString.charAt(baseIdx) != ')' && baseIdx < baseString.length()) {

			}
		}
	}

	while (baseIdx < baseString.length())
		if (baseString.charAt(baseIdx) == '(') {
			pIss = baseIdx;
			activated = true;
		}
		if (baseString.charAt(baseIdx) == ')' && activated) {
			//loop through replacement for next pair with same if statments as baseString core 
			
			replacementIdx += 1;

			// replace from pIss to baseIdx 
			activated = false;

		}
		baseIdx = baseIdx + 1;

		
	}

	// Return the StringBuilder to the user as a String
	return newString.toString();
```
7. **Extra Credit (10 points):** **reverseAll** should take a String and return a String  
    All substrings inside matching parentheses should be reversed. If the reversed portion contains matching parentheses, these should be "re-reversed" and so on. The parentheses should still be correctly matched and nested about the different affected substrings.  
    
    reverseAll("a b (c d e (f g) (h (i j k l (m n o) (p q)) r s t)) (u v w) x y z") should return
		    "a b ((h ((p q) (m n o) l k j i) r s t) (f g) e d c) (w v u) x y z"
    

---

### V. Submitting Your Project

Submit the .java file (not the .class files or the .java~ files) of your class plus the testing report on Canvas.

#### Current Method for replaceText
```
/**
* Replaces substrings of an inputted string, indicated by parentheses (...)
* with substrings from another string using the same nomenclature. If the first
* string contains more substrings than the second, they are removed. If the
* second string contains more substrings than the first, then they are ignored.
* Mismatched parentheses will be ignored in a way that they are still included
* in the output, but are not considered for replacement. Substrings are
* replaced in the exact same order as they appeared originally.
* 
* @param baseString  A string with zero or more indicated substrings to be
*                    replaced
* @param replacement A string with indicated substrings that will replace
*                    those indicated in the baseString
* 
* @return A string that is an altered version of the baseString with the
*         substrings replaced in the manner indicated above.
*/
public static String replaceText(String baseString, String replacement) {
// If there are no parentheses in the baseString, return it unaltered
if (!containsParentheses(baseString)) {
return baseString;
}

/* Notes:
* Cases to consider
*      Matched parentheses everywhere
*      Mismatched parentheses in Base or replacements
*      Nested matched parentheses
*/

// Otherwise proper inspection of the strings is necessary
else {  
// Create a new StringBuilder to create the modified string
StringBuilder newString = new StringBuilder();

// Create a boolean variable that indicates whether or not a replacement should be done
boolean replacementTime = false;

// Create a boolean and int variable to indicate a repeated ( in the base that is mismatched
boolean mismatch = false;
int mismatchIdx = 0;

// Create indices for the the base and the replacements
int baseIdx = 0;
int replaceIdx = 0;

// Create a sum variable to keep track of the number of parentheses found down the line
int sum = 0;

// Create temporary indices to keep track of where substrings end
int temp = 0;
int ending = 0;

/* Iterate through the base index until all indices have been exhausted
* Each iteration appends a base/replacement character to the StringBuilder
*/
while (baseIdx < baseString.length()) {
// If a replacement must be done, then enter the replacement string to look for the next substring
if (replacementTime) {
	/* Loop through the replacements until a ( is found
	 * Each iteration increases the index until a ( is found by the loop
	 */
	while (replaceIdx < replacement.length() && replacement.charAt(replaceIdx) != '(') {
		replaceIdx = replaceIdx + 1;
	}

	// Set the ending part of the substring to one greater than the index of the full string
	ending = replaceIdx + 1;

	// Start at the replaceIdx found and go up until a closing bracket is found
	while (replacement.charAt(ending) != ')' && ending < replacement.length()) {
		/* If another open parenthesis is found, there is a possible mismatch 
		 * This variable can be reused because the if else statements are independent
		*/
		if (baseString.charAt(ending) == '(') {
			mismatch = true;
			mismatchIdx = ending;
		}
		ending++;
	}

	// If the replacement substring is only '()' append nothing and move on
	if (!mismatch && replacement.charAt(replaceIdx) == '(' && replacement.charAt(ending) == ')' && (ending - replaceIdx) == 1) {
		replaceIdx = ending + 1;
	}

	// If a potential mismatch is found, then check if the parentheses are nested or truly mismatched
	else if (mismatch) {
		sum = 1;

		/* Loop through the replacements until an equal amount of parentheses are found
		 * Each loop iteration leaves the sum corresponding to the number of parentheses found
		 */
		int j = replaceIdx + 1;
		while (sum >= 0 && j < replacement.length()) {
			// If an open parentheses is found, increment the sum
			if (replacement.charAt(j) == '(') {
				sum = sum + 1;
			}

			// If a closed parentheses is found, decrement the sum
			else if (replacement.charAt(j) == ')') {
				sum = sum - 1;
			}
			j++;
		}

		// If the sum is 0, then there is no mismatch
		if (sum == 0) {
			mismatch = false;

			// The replacement will be between replaceIdx and j
			for (int rep = replaceIdx + 1; rep < j; rep++) {
				// Each iteration of this loop append the next character in the current replacement substring
				newString.append(replacement.charAt(rep));    
			}

			// Set the replaceIdx to one after the last character in the substring
			replaceIdx = j + 1;
		}

		// If the sum isn't 0, check if there is a ) at ending idx
		else if (replacement.charAt(ending) == ')') {
			// The replacement will be between mismatchIdx and ending
			for (int rep = mismatchIdx + 1; mismatchIdx < ending; mismatchIdx++) {
				// Each iteration of this loop appends the next character in the current substring
				newString.append(replacement.charAt(rep));
			}

			// Set the replaceIdx to one after the last character in the substring
			replaceIdx = ending + 1;
		}
	} 

	// If a mismatch was not found, then check if there is a ) at ending
	else if (replacement.charAt(ending) == ')') {
		// Append everything between the replaceIdx and ending to the new String
		for (int rep = replaceIdx + 1; rep < ending; rep++) {
			// Each iteration of this loop appends the next character in the replacement substring
			newString.append(replacement.charAt(rep));
		}

		// Set the replaceIdx to one after the last character in the substring
		replaceIdx = ending + 1;
	}

	// Otherwise there are no more substrings in the replacements
	else {
		// Set the replacement index to an out of bounds index
		replaceIdx = replacement.length();
	}

	// Set the replacementTime to false
	replacementTime = false;
}

// if there is an open parentheses found at the current index, look for a closing parentheses
else if (baseString.charAt(baseIdx) == '(') {
	temp = baseIdx + 1;
	sum = 1;

	/* Loop through the baseString until a closing parentheses is found and store the index in temp
	 * Each iteration ends with a value of the current index
	 */
	while (temp < baseString.length() && baseString.charAt(temp) != ')') {
		// If another ( is found, then there is a possible mismatch
		if (baseString.charAt(temp) == '(') {
			mismatch = true;
			mismatchIdx = temp;
		}
		temp++;
	}

	System.out.println(temp);

	// If there is a potential mismatch, then check if there are nested parentheses 
	if (mismatch) {
		/* Loop through the baseString and stop when there is an equal number of parentheses indicating nested parentheses
		 * Each iteration of the loop results in a value pertaining to the sum of the number of each parenthesis found
		 */
		int i = baseIdx + 1;
		while (sum >= 0 && i < baseString.length()) {
			// If an open parentheses is found at i, add 1
			if (baseString.charAt(i) == '(') {
				sum = sum + 1;
			}

			// If a closed parentheses is found at 1, subtract 1
			else if (baseString.charAt(i) == ')') {
				sum = sum - 1;
			}
			i++;
		}

		// If sum is 0 after going through the loop above, then there is no mismatch
		if (sum == 0) {
			mismatch = false;

			// This means the substring is contained between baseIdx and i; temp should be used instead of i
			temp = i;

			/* Indicate it is time to do a replacement using the previously initialized boolean
			 * Here, the replacement is done on the characters from baseIdx and temp
			 */
			replacementTime = true;

			// Set the base index to one after temp
			baseIdx = temp + 1;
		}

		// If the sum is anything else, then the substring is between the mismatchIdx and temp
		else {
			mismatch = false;

			/* Any characters before the mismatched index should be appended 
			 * Each iteration appends a character from the base string until the mismatch index is met
			*/
			for (int j = baseIdx; j < mismatchIdx; j = j + 1) {
				newString.append(baseString.charAt(j));
			}

			/* Indicate it is replacement time
			 * Here, the replacement is done on the characters frp, mismatchIdx and temp
			 */
			replacementTime = true;

			// Set the base index to one after temp
			baseIdx = temp + 1;
		}
	}

	// If there is not a closing parentheses found, append the rest of the baseString to the StringBuilder and return
	else if (temp >= baseString.length() || baseString.charAt(temp) != ')') {
		/* Each loop iteration appends the next character in the base to the builder */
		for (int i = baseIdx; i < baseString.length(); i++) {
			newString.append(baseString.charAt(i));
		}

		// Return the string builder as a string
		return newString.toString();
	}
}

// If temp is in range and a closing delimiter is found at the end
else if (temp < baseString.length() && baseString.charAt(temp) == ')') {
	// It is time to do a replacement, move the baseIdx to after the substring 
	replacementTime = true;
	baseIdx = temp + 1;
}

// If an opening parentheses is not found, append the next character in the base 
else {
	newString.append(baseString.charAt(baseIdx));
	baseIdx = baseIdx + 1;
}
}

// Return the modified string
return newString.toString();
}
}
```
