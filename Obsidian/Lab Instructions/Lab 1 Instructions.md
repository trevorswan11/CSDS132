# Programming in Java: Lab 1  
Primitive Types  
Getting Comfortable with DrJava

The purpose of this lab is to get you used to using DrJava, to start experimenting with Java expressions, and to understand some of the issues involved in representing and manipulating data with a computer.

---

## Task 1: Getting a Lab Partner

The first thing that will occur in this lab is the assigning of lab partners. The teaching assistants in the recitation will pair you with another student. If there is a person you want to work with, let the teaching assistants know.

---

## Rules For The Lab

> **Your grade will be determined by how well you work as a member of a team.** You will play two different roles in the lab. You will either be the _driver_ or _navigator_.
> 
> - **driver:** The person typing at the keyboard.
> - **navigator:** The person watching for mistakes, making suggestions, and thinking ahead.
> 
> _**Important: The driver is the only one who may do the typing or otherwise edit the document or enter the code. The navigator must not jump in and start editing.**_
> 
> Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.
> 
> _You do not have to complete all the tasks by the end of lab_, but you do have to make a good effort.  
> **The only ways to lose points when working as a team is 1) you do not show up on time, 2) you goof off, 3) you are the navigator and you take over editing the document from the driver, or 4) you are the navigatpr and you sit quietly and never offer suggestions.**

**If you are unable to attend the recitation** then you must do this lab exercise on your own. In that case, your grade will be the percent of the exercises you complete.

---

## Task 2: Introductions

If you have a lab partner, tell your partner your name as well as your favorite snack food.

---

## Task 3: Starting DrJava

_DrJava_ is what is known as an _integrated development environment_ (or IDE for short) for Java. An IDE is an application that assists programmers in writing computer programs. There are a large number of IDEs available for many different languages, and we will be using DrJava for writing Java in our class because DrJava is particularly good for new programmers.

DrJava is available on Case's MyApps (myapps.case.edu). Log in with your Case ID and password, launch the "student desktop" and choose DrJava from the applications list.

You are allowed to use a different IDE _if both you and your lab partner want to_ and the IDE should have JShell installed, but these labs exercises are designed for DrJava. If either you or your lab partner is a coding novice, then you should use DrJava. **Do not pressure your lab partner into using a different IDE.**

### Testing DrJava

All programming languages have their own quirks with how they manipulate numbers and other data. In this lab, you will begin exploring the syntactic form of Java expressions as well as their semantic meaning.

In this lab, you will be entering code fragments in the Interactions Pane of DrJava. At the bottom of the DrJava window, you should see several tabs. Click on the one that is labeled _Interactions_. You should see

Welcome to DrJava.
>

You will enter the code fragments at the > prompt.

Try it now. Type:

1+2

at the > prompt and press the _Enter_ key. The interactions pane should respond with

3

The Interactions Pane is the reason DrJava is a very nice IDE for beginning programmers. You can enter pieces of Java code into the Interactions Pane in order to test the code and see what happens. This way, you can get started working in Java without having to write an entire Java program.

_If you are not using DrJava, you can get the same effect by using JShell in your IDE, but you need to be using Java 9 or greater._

---

## Task 4: Questions and Answers

You will be writing a _lab report_ in this lab. I recommend using the editor window of DrJava to type in your answers and to save them as a .txt file. Alternatively, you can open a google doc shared with your lab partner.

Place both of your names into the document.

Follow the following procedure through the lab.

1. Look over the lines you are asked to type into the interactions pane. Discuss with your lab partner what you think the results should be.
2. Type the expressions _one at a time_ into the Interactions Pane of DrJava and see what happens. (If you try to copy and paste all of them at once, you will get a Java error.)
3. Discuss the results with your lab partner, read the questions that follow and see if you can answer them. If you are unsure, you can enter more test cases into the interactions pane.
4. Write your answers or explanations to the following questions in the lab report document.

### If you are new to Java your goal is to get through question 6 below. If you have previously coded in Java, try to get through question 8.

**At the end of lab**, both you and your partner will submit the report. If you click on the _Lab 1_ link on Canvas to find the form for submitting the lab.

The questions below cover some features of numbers in Java. Don't worry about trying to remember all the syntax. We will be covering this in more detail later. Right now, just focus on the _behavior_ of the different Java expressions below.

**Remember, only the driver is to type either in DrJava or on the lab report. The navigator is to think and offer suggestions.**

1. What is the result of each of the following expressions when you type them in the interactions pane?
    
    5 * 2
    2 + 20 * 10
    (2 - 20) * 10
    
    Answer the following questions. You may enter more test cases, if you need, to determine the correct answers. Write up your answers on your lab report.
    
    1. What is the meaning of +, -, and *?
    2. If your have a mixture of +, *, and - operators in an expression, what is the rule Java uses to evaluate the expression?
    
2. What is the result of each of the following expressions when you type them in the interactions pane?
    
    5 - 2
    5 - 2.0
    6.0 - 5
    6.0 - 5.0
    
    Answer the following questions. You may enter more test cases, if you need, to determine the correct answers. Write up your answers on your lab report.
    
    1. What is the _type_ of each of the resulting values? What is the rule Java uses to determine what _type_ the resulting value is?
    

**Switch roles. The driver should now navigate and the navigator should now drive.**

4. What is the result of each of the following expressions when you type them in the interactions pane?
    
    11 / 5
    11.0 / 5.0
    11 % 5
    12 % 5
    4 / 5 * 10.0
    
    Answer the following questions. You may enter more test cases, if you need, to determine the correct answers. Write up your answers on your lab report.
    
    1. What is the meaning of the / and % operators?
    2. What is the rule for / if the operands have decimal points (double) and if they do not (int)?
    3. Why did the last expression evaluate to 0.0?
    
    _Note: Because of the possibly confusing results when mixing int and double values, we try to avoid doing so when we write programs._
    
5. What is the result of the following expressions when you type them in the interactions pane?
    
    2147483647 + 1
    Integer.MAX_VALUE
    Integer.MAX_VALUE + 1
    Integer.MAX_VALUE + 2
    Integer.MIN_VALUE
    Integer.MIN_VALUE - 1
    
    Answer the following questions. You may enter more test cases, if you need, to determine the correct answers. Write up your answers on your lab report.
    
    1. Explain the behavior witnessed above. Can you come up with rules for very positive or very negative int/Integer type numbers?
    

**Switch roles. The driver should now navigate and the navigator should now drive.**

7. What is the result of the following expressions when you type them in the interactions pane?
    
    Double.MAX_VALUE
    Double.MAX_VALUE + 10
    Double.MAX_VALUE / 10
    Double.MAX_VALUE * 10
    Double.MIN_VALUE
    Double.MIN_VALUE * 10
    Double.MIN_VALUE / 10
    
    Answer the following questions. You may enter more test cases, if you need, to determine the correct answers. Write up your answers on your lab report.
    
    1. Can you come up with rules for very large or very small double type numbers?
    
8. What is the result of the following expressions when you type them in the interactions pane?
    
    4 < 5
    5.01 > 5.00
    6 > 5 > 4
    2 == 2
    2 == 3
    
    Answer the following questions. You may enter more test cases, if you need, to determine the correct answers. Write up your answers on your lab report.
    
    1. What do < and > do?
    2. What does == do?
    3. Why did one of the above expressions give an error message? (Hint: the answer has to do with a _data type_.)
    
    _Once you complete this question, show the answer to your lab teaching assistant._
    
    **Note: true and false are also values of a primitive type. They are the only two values of the type boolean.**
    

**Switch roles. The driver should now navigate and the navigator should now drive.**

10. What is the result of the following expressions when you type them in the interactions pane?
    
    (int)5.3
    (int)5.9
    (double)4
    (int)2.5 + 2.5
    
    Answer the following questions. You may enter more test cases, if you need, to determine the correct answers. Write up your answers on your lab report.
    
    1. What is the difference between int and double?
    2. What does placing (int) to the left of a value do to the value? What does placing (double) to the left of a value do to the value?
    3. Why did the last example still give a double value (a number with a decimal point)?
    
    _Note: int and double are called **types** and (int) and (double) are called **typecasts**._
    
11. What is the result of the following expressions when you type them in the interactions pane? (Note that the symbol used is the single-quote, known in English as the apostrophe.)
    
    'a'
    'a' + 1
    (char)('a' + 1)
    3 == 3
    '3' == '3'
    3 == '3'
    
    Answer the following quesitons. You many enter more test cases, if you need, to determine the correct answers. Write up your answers in your lab report.
    
    1. What does the single-quote do?
    2. Why did 'a' + 1 and (char)('a' + 1) behave differently?
    3. Describe, as best you can, what '3' and 3 represent in Java.
    
    _Note: char is also a **type** of Java, similar to int and double._
    

**Switch roles. The driver should now navigate and the navigator should now drive.**

13. What is the result of the following expressions when you type them in the interactions pane?
    
    int x
    int y
    x = 10
    y = x * 2
    x
    y
    x = x + 1
    x
    y
    x = 2.0
    x = (int)2.0
    x
    
    Answer the following questions. You may enter more test cases, if you need, to determine the correct answers. Write up your answers on your lab report.
    
    1. What does the = operator do?
    2. In your own words, explain the behavior of the line x = x + 1.
    3. Why, after the line x = x + 1 did the value of x change but not the value of y?
    4. Why did the third to last line cause an error?
    
    **_Important:_ remember the difference between = and ==.**
    

---

## Task 5: Submitting Your Report

Make certain both lab partners' names are on the report, save it, and _both_ lab partners should submit it through Canvas.