# Programming in Java: Lab 5  
Loops, Strings, and StringBuilder; also an Introduction to Testing

In this lab, you will practice writing loops, and you will manipulate the String and StringBuilder classes. You will also start writing a testing class that will verify your code.

## Task 1. Assigning Lab Partners

If you wish to have a lab partner (and you are strongly encouraged to do so), see your lab assistant. You may keep your lab partner from last week, but you do not need to.

---

## Reminder About The Rules For The Lab

### If You Do Not Have a Lab Partner

You are to do the tasks listed below. The tasks require you to write a class that contains specific methods. You need to complete all the methods as described. If you fail to complete all the tasks by the end of lab, you may continue to work on them, but you must complete the lab prior to the deadline posted.

### If You Have a Lab Partner

You will play two different roles in the lab. You will either be the _driver_ or _navigator_.

- **driver:** The person typing in the code.
- **navigator:** The person watching for mistakes, making suggestions, and thinking ahead.

_**Important:** The navigator must not edit the code._

Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.

As in last week's lab, you will write a class that you will submit at the end of lab. You do not have to complete all the tasks by the end of the lab because you are being graded on how well you work as a team. You do have to make a good effort and work for the entire 50 minute lab to get full credit.

### Submitting the Lab

At the end of lab, submit your program. _Both you and your lab partner should submit your code._ Remember that your code is in a file with a .java extension, and depending on your browser, the extension may or may not be visible. _Do **not** submit the file with the .class extension (that is Java bytecode) or the .java~ extension (that is a temporary editor file)._

---

### _If you are new to programming,_ your goal is to make it to Method 2 in Task 5 during the lab session. If you it is getting close to the end of lab and you have not yet completed your second loop method, be certain to ask one of the lab assistants for help.

---

## Task 2. Introductions and Starting DrJava

If you have a lab partner, tell your lab partner your name as well as a movie or TV show you saw recently.

Choose one of you to start as the driver, and launch DrJava.

---

## Task 3. A first class and method

Create a class called Lab5.

**Method 1.** Create a static int method called countSpaces that takes a single String parameter named s. Write the method so that it returns the number of spaces in the String s. _Hint: the only methods from the API you need are the charAt and length methods of String._

Compile and test your method.

---

## Task 4. Writing a testing class

Up to now, you have used the interactions pane for testing your code. This is nice but you have to keep entering the tests. Instead, we can create a testing class so that you can run all your tests with a single button click.

Create a new class called Lab5Tester. You need to import two things at the top:

	import org.junit.Test;
	import static org.junit.Assert.assertEquals;

	public class Lab5Tester {
	}

The first imports the JUnit Test class. That is a class that contains code to let us create automatic tests for our program. The second import is different. Notice the static. That means we are actually importing the static method assertEquals from the Assert class. This will let us write assertEquals instead of Assert.assertEquals in our code. (You could also just do import org.junit.Assert, but then you would need to use Assert.assertEquals.)

**Important: if you are using a lab machine or myapps.case.edu, you need to save this file and your Lab5.java file in the H: drive (H:\My Documents or H:\Documents). If you do not do that, the cloud drive may not synchronize the various Java applications needed for this exercise.**

Now, create an instance method testCountSpaces inside the Lab5Tester class that takes no input, and the method needs the @Test annotation:

	public class Lab5Tester {

	  @Test
	  public void testCountSpaces() {
	  }
	}

We can now place a test inside the method. To create a test we use the Assert.assertEquals method. Since we did a static import, we can just write assertEquals. The method takes two inputs. The first is the _expected value_ that our method should return, and the second is the actual method call. For example, the string "abcde" has no spaces so we expect Lab5.countSpace("abcde") to return 0. We code that as:

	  @Test
	  public void testCountSpaces() {
	    assertEquals(0, Lab5.countSpaces("abcde"));
	  }

Now compile the file. When it compiles and if there are no errors, the _Test_ button at the top should become active. If you click the test button you should see _All tests completed successfully_ and a green _Test Progress_ bar.

Now, let's create a test that gives an error. "a b c d e" has 4 spaces, but let's give the wrong expected value:

	  @Test
	  public void testCountSpaces() {
	    assertEquals(0, Lab5.countSpaces("abcde"));
	    assertEquals(5, Lab6.countSpaces("a b c d e"));
	  }

Now compile the file. When it compiles and if there are no errors, the _Test_ button at the top should become active. If you click the test button you should see a red _Test Progress_ bar and the message _Failure: java.lang.AssertionError: expected <5> but was:<4>_. This shows that the countSpaces method returned 4, but the test was expecting it to return 5.

Fix the test so that it expects 4. Write a few more tests. Here is a guideline: _Test 0, 1, many. Test first, middle, last_. That means that you should have a test with 0 spaces, a test with 1 space, and a test with many spaces. You should also make sure that some test has a space as the first character of the string, some test has a space as the last character, and some test has a space in the middle.

---

## Task 5. Writing more methods and loops

**Switch roles: the driver now navigates and the navigator now drives.**

**Method 2.**Write a static String method removeSpaces in the Lab5 class that takes a single String parameter s and prints out a new String with all spaces removed. Recall that you must use StringBuilder or StringBuffer when building a String. _Hint: Use the charAt method of String and the append method of StringBuilder._

Write a test method testRemoveSpaces in the Lab5Tester class. (Rememeber to put the @Test annotation above the method header.) Write a bunch of test cases using assertEquals, except now the expected value shoud be a string instead of an int. Remember to use the _Test 0, 1, many; Test first, middle, last_ guideline, but that means you should use similar test strings to the ones you did for testCountSpaces. _I recommend writing all the test cases before you fix any errors in your method. That way you can just keep hitting the _Test_ button and fixing errors until all tests are passed._

Compile, test, and fix your code.

Demonstrate your method to your lab assistant or instructor.

---

**A note on the assertEquals method.** You may notice that when some test fails, it is not always easy to see which specific test failed. Here are two ways to design your tests to help you.

First, the assertEquals method is _overloaded_ so that it can also have a String input that is a message printed if the test fails. The message should be the first input. For example:

	  @Test
	  public void testCountSpaces() {
	    assertEquals(0, Lab5.countSpaces("abcde"));
	    assertEquals(5, Lab6.countSpaces("a b c d e"));
	  }

can be changed to:

	  @Test
	  public void testCountSpaces() {
	    assertEquals("The test with no spaces fails", 0, Lab5.countSpaces("abcde"));
	    assertEquals("The test of five letters separated by spaces fails", 4, Lab6.countSpaces("a b c d e"));
	  }

Now you will have a custom message printed when a specific test fails.

Second, you get only one error message per testing method. If more than one assertEquals test fails, only the first one that fails prints a message. If you want to see all the tests that fail, then you should put each assertEquals call in its own method inside the Lab5Tester class.

---

**Switch roles: the driver now navigates and the navigator now drives.**

Write the following method and test method.

**Method 3.** Write a static String method everyNthChar that takes two parameters, a String s and an int n. The method should output a string that contains each nth character, separated by spaces. For example, everyNthChar("abcdefghijklmn", 2) should output "a c e g i k m" and everyNthChar("abcdefghijklmn", 3) should output "a d g j m" You should use only a single loop.

Write a testEveryNthChar method in the tester class. The _Test 0, 1, many_ guideline means you should have a test with the input string is an empty string, where it contains a single character, and where it is a long string. You should have the input int be 1 as well as a large value. The _Test first, middle, last_ guideline means you should have a test where the last character must be output, and you should have a test where the last character should not be output.

---

**Switch roles: the driver now navigates and the navigator now drives.**

Write the following method and test method.

**Method 4.** Write a static String method allDigits that takes a single int parameter i and outputs a string containing the digits of i one at a time, on a single line, in reverse order, separated by commas. For example, given 5641, the method will output "1, 4, 6, 5" A hint is to use % and / to isolate the digits. Try using a while loop.

Write a testAllDigits method in your tester class. The _Test 0, 1, many_ guideline means you should have tests with input 0, a single digit number non-zero number, and a many digit number. The _Test first, middle, last_ guideline does not really apply to this problem because all digits are output.

---

## Task 6. Finishing Up

Once completed, submit _both_ your Lab5.java file and your Lab5Tester.java file. _Remember that both you and your lab partner should submit these files._

Wasn't that fun?