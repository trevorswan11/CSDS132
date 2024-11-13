# Programming in Java: Lab 6  
Working With Arrays and More on JUnit

In this lab, you will write methods using arrays of int and test your results with JUnit

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

**If you are a novice programmer, your goal is to complete at least at least the first two methods of the lab and write the JUnit test case. If you have not completed the second method and there is less than 15 minutes left in the lab, please ask one of the lab assistants for help.**

---

## Task 2. Introductions and Starting DrJava

If you have a lab partner, tell your lab partner your name as well as your favorite Uptown restaurant.

Choose one of you to start as the driver, and launch DrJava.

---

## Task 3. Using JUnit

Download both the ArrayLab.java file and the ArrayLabTester.java file. Load them in DrJava and compile them. **If you are on the lab machines or using the student desktop in the Citrix app, you have to save these to H:\My Documents.** This is the only cloud drive that syncs continuously. If you save anywhere else, DrJava may complain that it can't find the files when you try to run the JUnit tests.

The ArrayLab.java file has a bunch of methods that do practically nothing. Your task in this lab is to get as many of these methods working as you can.

The ArrayLabTester.java file has methods to test the methods of ArrayLab.java using the JUnit testing package. These methods have been created for you in this lab. You can run these tests by clicking the _Test_ button at the top of DrJava. Try that now.

A reminder from last week. You will notice at the bottom of DrJava, the _Test Output_ tab is shown, the _Test Progress_ bar is red (it will be green when all tests pass), and in the text area, the name of each test is red. This means that the specific tests failed. The names will turn green when the tests pass. Underneath the list of names will be descriptions of what failed in each test. If you click on the error, it will take you to the test line that failed. It will also list what the expected value was for the test and what value your method produced. Below the failure descriptions will be a listing, if any, of exceptions that were thrown by the tests.

If you look at the first error listed in the test cases:

**File:** .../ArrayLabTester.java [line:16]
**Failure:** junit.framework.AssertionFailedError: Incorrectly claims 11 is not in a[0..1]

the message states that the method gives the wrong return value. If you click on the message, it will take you to the specific test that was done, namely ArrayLab.contains(a, 0, 1, 11) where a is the array {11, 13}.

_The JUnit error message will tell you which test of JUnit failed, it will not tell you where in your program the error is. If you want a "standard" Java error message, copy the specific JUnit test into the interactions pane and run it there._

---

## Task 4. Writing and Testing Your Code

First, place you name and your lab partner's name at the top of the ArrayLab.java file.

**Step 1:** Write the contains method and test it using the _Test_ button until the test for contains is green.

You are not to modify the ArrayLabTester.java test cases for the contains method.

The comment above each method explains what the method should do. The _Precondition_ is a statement that describes what you can assume will be true about the parameters to the method. The _Postcondition_ statement lists something that, if your code is correct, will be true when the method returns. The "Postcondition" can also be thought of as the goal for the method.

**Switch roles, the driver should navigate and the navigator should drive.**

**Step 2:** Write the arrayToString method and test it using the _Test_ button. _Note that the last test of this JUnit test case will always fail._ When you get to that point, you need to create an appropriate JUnit test case. Your test case should check that the method works correctly on an array with more than two elements.

Each JUnit test consists of methods called assertEquals (or variations like assertTrue or assertArrayEquals). The assertEquals method takes three inputs. The first is a String that is a message that should be printed if the test fails. The second is an object that represents the correct result of the test, and the third input is the actual result of the test.

You need to create an appropriate array for testing the arrayToString method on more than two elements. Then replace the fail method (that always fails) with an assertEquals method call. For the first input, give an appropriate message, for the second message give the String that should be produced by calling arrayToString in your test, and the third input should be the String returned by the call to arrayToString.

_Demonstrate your method and show your test case to the lab assistant._

**Switch roles, the driver should navigate and the navigator should drive.**

**Step 3:** Write the remove method and test it using JUnit.

**Switch roles, the driver should navigate and the navigator should drive.**

**Step 4:** Write the insert method and test it using JUnit.

---

## Task Last. Finishing Up

Once completed, submit your ArrayLab.java and ArrayLabTester.java files. _Remember that both you and your lab partner should submit this file._