# Programming in Java: Lab 2  
Calling Java Methods (Functions)  
Creating Java Objects

In this lab you will learn how to call some of the pre-defined functions in Java as well as how to to manipulate objects by playing with the Math and JFrame classes and entering Java code fragments into the DrJava interactions pane.

## Task 1. Assigning Lab Partners

The lab assistants will assign you lab partner. You may keep your lab partner from last week or work with a new parther. If there is somebody you want to work with, let the teaching assistants know.

---

## Rules For The Lab

> **Your grade will be determined by how well you work as a member of a team.** You will play two different roles in the lab. You will either be the _driver_ or _navigator_.
> 
> - **driver:** The person typing at the keyboard.
> - **navigator:** The person watching for mistakes, making suggestions, and thinking ahead.
> 
> _**Important: The driver is the only one who may do the typing. The navigator must not jump in and start editing.**_
> 
> Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.
> 
> _You do not have to complete all the tasks by the end of lab_, but you do have to make a good effort.  
> **The only ways to lose points when working as a team is 1) you do not show up on time, 2) you goof off, 3) you are the navigator and you take over editing the document from the driver, or 4) you sit quietly as the navigator and never offer suggestions.**

**If you are unable to attend the recitation** then you must do this lab exercise on your own. In that case, your grade will be the percent of the exercises you complete.

---

## Submitting the Lab

The form of this lab is similar to the one from last week. You are given a series of tasks to do and then some questions to answer. Answer the questions in a lab report and submit the report at the end of lab. _Both lab partners should submit the lab report._

#### If you are new to programming, your goal is to make it at least through Task 5. If you have not completed step 5 and we are getting close to the end of the lab, ask the lab teaching assistants for help.

---

## Task 2. Introductions

Tell your lab partner your name as well as a sport or game you love to play.

Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.

---

## Task 3. Starting DrJava and Starting a Lab Report

Launch DrJava on the lab computer. Just as you did in the last lab, you will create a lab report. You can either use the DrJava editor for writing the report, or you can create a shared Google document. Make sure to put both lab partners' names at the top of the report.

---

## Task 4. Playing with JFrames.

We will begin the lab with the pre-defined class JFrame. The JFrame class represents a window on the screen. To use a pre-defined class, we must first load it. The JFrame class is in the javax.swing package, and so the the Java statement to load a class is

  import javax.swing.JFrame;

Type that into the DrJava interactions pane now.

Now that we have the JFrame class loaded, we can use it.

1. Enter the following lines, and in your lab report, describe what happens after each statement.

  import javax.swing.JFrame;
  JFrame j1 = new JFrame();
  j1.setVisible(true);
  j1.setSize(200,400);
  j1.setLocation(500,500);

Now try creating a few more JFrame variables. You can call the variables (almost) anything you wish. Try calling the following methods:

                setVisible          getWidth 
                setSize             getHeight
                setLocation         getX
                                    getY

setVisible expects a single input of type boolean, setSize and setLocation each expect two values of type int (remember to separate the values by a comma), and getWidth, getHeight, getX and getY do not expect any input.

_Also try calling each method with a semicolon after them and without a semicolon after them._ If you place a semicolon at the end of a line, it is a Java _statement_. A statement does not have a value. If you do not place a semicolon at the end, it is a Java _expression_, and expressions may return values. By omitting the semicolon, you will see any values that an expression may return.

2. Answer the following questions in your lab report:

1. What are the _syntactic_ differences between the methods in the left column and the methods in the right column? _Syntax_ has to do with the actual structure of the line of code: how does the line appear when you type it in? Make a brief list of the syntactic differences you observe.
2. What are the _semantic_ differences between the methods in the left column and the methods in the right column? _Semantics_ has to do with the meaning of the code: what do the methods do to a JFrame? Make a brief list of the semantic differences you observe.

---

## Task 5. Creating, Resizing and Moving JFrames

**Switch roles. The driver should now navigate, and the navigator should now drive.**

Now let us see how much you remember from above.

- Reset the Interactions pane. This erases everything you have done including all variables.
- Create and initialize two JFrame variables, and show (i.e. setVisible) them.
- Use the setSize method to make window 1 300x200.
- Use getWidth and getHeight to get the width and height of window 1 and store the results in two variables called w and h. (What type should the variables be?) _Do this without explicitly typing in the numbers 300 and 200._
- Use setSize to make window 2 the same dimensions as window 1. _Do this without explicitly typing in the numbers 300 and 200_. Instead use the variables you created above.

3. Enter the statements you used to do the above operations in your lab report.

Now, use the setLocation method to move the windows so window 1 is flush against the top edge of the screen, halfway across, and window 2 is flush against the bottom edge of the screen, halfway across. (If your computer has a menu of icons at the top or bottom, you can instead choose to move the windows to the left and right edges of the screen, halfway up.)

4. Enter the two setLocation statements you used in your lab report.

Show your answers to Tasks 4 and 5 to your lab teaching assistant.

---

## Task 6. Calling Functions From the Math Class

**Switch roles. The driver should now navigate and the navigator should now drive.**

The Math class is a pre-defined class that contains common mathematical functions. The Math class is in the java.lang package. All classes in java.lang are automatically loaded in every Java program. This means that we do not need to import the Math class in order to use it.

The methods of the Math class have another interesting property. We do not have to create an instance of the Math class to use the methods. This makes sense because, while the height of a JFrame "belongs" to a specific JFrame, the square root function is universal. Such methods that do not belong to an instance of a class are called _static_ or _class_ methods.

So, to compute 4 raised to the 5th power, we type in

    Math.pow(4.0, 5.0)

Try that now. Notice that we still need to use the dot, but instead of prefixing the method name with an object reference, we prefix it with the class name. Try typing in JFrame.getWidth() and see what happens.

Another method in Math is the square root method, sqrt that takes a single double as input. For example, Math.sqrt(2.0) returns the square root of 2. Note that we can nest method calls such as Math.sqrt(Math.pow(4.0, 2.0)) first computes the square of 4, and then takes the square root of the result, hopefully returning 4.0. You can nest method calls all you want. All that matters is that the _type_ of the value returned by the inside method matches that type expected as input from the outside method. **Always keep track of your types!**

5. Answer the following questions and type your answers in the lab report.

1. Try computing the square root of 22, and then computing the square of the square root of 2. Mathematically these are the same, but does Java give you the same answer? Explain why or why not.
2. Using the fact that sin2(x) + cos2(x) = 1, and using the pow and sqrt methods of Math, create an expression that computes that cosine of an angle that has the sine 0.5. (Do not use variables. Do it in one large expression of nested methods.) When you have an expression that works, add it to your lab report.

---

## Task 7. A Final Challenge

Do the following:

1. Create two JFrame windows and make both visible.
2. Make one window a rectangle, but not a square.
3. Using the setSize, getWidth, and getHeight methods of JFrame and the sqrt method of Math, make the second window a square _such that it has the same area as the first window_. Use the getHeight and getWidth methods and the necessary arithmetic operators to verify your work. _Do this without using any variables except for the two JFrame variables._

6. Enter into your lab report the Java line or lines of code you used to accomplish this task.

Show your results to your lab teaching assistant.

---

## Submit the Lab

Canvas will allow you to submit your lab report. Please do that now. _Both lab partners should submit the lab report._

You are now done with the lab! Take a well deserved break.