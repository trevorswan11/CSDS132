# Programming in Java: Lab 3  
Creating Classes

In this lab you will do your first Java programming by creating an new class with methods.

## Task 1. Assigning Lab Partners

The Lab TA will assign you your lab partner. You may keep your lab partner from last week, but you do not need to. Let your TA know if you want to keep the same partner or switch.

---

## Rules For The Lab

You will play two different roles in the lab. You will either be the _driver_ or _navigator_.

- **driver:** The person typing at the keyboard.
- **navigator:** The person watching for mistakes, making suggestions, and thinking ahead.

_**Important:** The navigator the driver is the only person who is doing the coding._ The navigator must not jump in and start editing the program.

Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.

_You do not have to complete all the tasks by the end of lab_, but you do have to make a good effort.  
**The only ways to lose points when working as a team is 1) you do not show up on time, 2) you goof off, 3) you are the navigator and you take over editing the document from the driver, or 4) you sit quietly as the navigator and never offer suggestions.**

**If you are unable to attend the recitation** then you must do this lab exercise on your own. In that case, your grade will be the percent of the exercises you complete.

---

### Completing the Lab

This lab is different from the previous two in that you will not be writing a report. Instead, you will design and write a Java class and submit your code at the end of lab.

Both you and your partner should submit the code. The code you submit is the file ending in .java. You should not submit the file ending in .class (it is the Java bytecode created by the compiler) or the file ending in .java~ (it is a temporary file created by the DrJava editor to be able to restore your edits if the program crashes).

**If you are new to Java and working with a parther in the recitation, your goal is to complete through Task 6.** Be certain to ask for help if we are getting near the end of recitation and you have not completed Task 4.

---

## Task 2. Introduce Yourself to Your Lab Partner and Start DrJava

Introduce yourself to your lab partner. Tell your lab partner your name as well as whether you have any pets at home, and if so what kind.

---

## Task 3. Creating a Class That is a Subclass of JFrame

**Create a subclass of JFrame called MaxWindow. Include a comment at the top of the file with your and your lab partner's names.** If you remember how to do this, create the class now and skip to Task 4. If not, keep reading for the necessary steps.

1. You will type the code into the upper right window of DrJava (the text editor). The left hand window lists all the files you have open and highlights the file you are currently editing. In Java, every public class is placed in its own file so be certain to start typing your code into a new file and not into a file that already contains other data.
    
2. The first step to create the class is to place a _comment_ at the top of the file that contains your name and your lab partner's name. There are two types of comments. Single line comments begin with //:
    
                // This is a comment.  The entire comment must be on this line.
    
    Multiline comments are bracketed by /* and */:
    
    	/* This is a multiline comment.
               The comment continues for as many lines as you want
               until the closing star-slash is encountered.
            */
    
    Write a multiline comment with your names at the top of the file.
    
3. To create the subclass, the code for your class should go below the comment, and it will start with
    
            public class MaxWindow extends JFrame { 
    
    Be certain to add the line
    
             import javax.swing.JFrame;
      
    
    to the top of your file, _above_ the class definition so you can use the JFrame class, but below the comment with your name.
    
4. Add a closing curly brace } to the end of your file, and save the file as MaxWindow.java.
    
    **Important:** In Java, every public class must go into a file with the same name as the class and ending with .java. You should also start your class name with a capital letter. This is not required in Java, but it is the style that has become the industry standard.
    
5. Now compile your code by selecting _Compile_. If the code has no mistakes, move on to the next step. If it does, fix the errors, save, and recompile before continuing.
    

---

## Task 4. Creating Two Methods to Move the Window

Create the following two methods and place a comment above each method.

1. **Write a void method (with a comment above it) called snapToTop that moves the window to the top of the screen, but does not change it's horizontal location.** If you remember how to do this, do so and move to the next method, if you do not, here are futher instructions.
    
    The method should begin:
    
    public void snapToTop() {
    
    Each method definition in a class goes between the opening curly brace { and the close curly brace } of the class definition. The code should be indented. _The code you write inside { } should also be indented and aligned so that each statement inside a compound statement starts on the same column._
    
    You will need to call some methods that your class inherits from JFrame (setLocation, getX, getY). You used these methods in the last lab. You can look at that lab for a hint.
    
    **Hint:** Recall that the syntax for a method call is
    
    _object-reference_._methodname_(_argument list_)
    
    Your snapToTop method will be run for a specific window (object), and you need to be able to call that window's methods from inside snapToTop. Java provides a reference called this that is used inside a method to get the reference of the object running that method. So, to get the current horizontal location of your window, from inside snapToTop, use this.getX(). **Further Hint:** you can drop the this. from the method call and just use getX() because if you do not provide a dot operator, Java automatically prefixes this. to the front of the method call.
    
    Once you complete the method, save your code and compile it. If it has no errors, test your code: create a new MaxWindow in the Interactions pane, move that window to somewhere other than the top, and call the snapToTop method. If correct, the window should now jump to the top of the screen without changing in size or moving left or right.
    
    Place a comment above your method explaining what the method does. You should indent your comment so that it starts in the same column as the method.
    
2. **Create a method snapToLeft that moves the window to the left edge of the screen without changing its vertical location or its size, and put a comment above it.** The technique is almost exactly the same as the snapToTop method.
    
    Please note, your new method goes inside the { } of maxWindow so it can be part of the class, but it goes outside the { } of snapToTop because the new method is a separate method. _Leave a blank line between the closing } of one method and the start of the next method._
    
    _Special note for Mac's. Apple will not let the the methods you are calling cause the window to cover the Apple Dock (menu of icons). If you have the Dock on the left side of the screen, your window will not move all the way to the left edge. As long as it is as close as possible to the Dock, your method is working correctly._
    
    Place a comment above your method explaining what the method does. You should indent your comment so that it starts in the same column as the method.
    

_Demonstrate your class to your lab teaching assistant._

---

## Task 5. A Short Pause in Coding: Getting The Screen Size

**Switch roles. The driver should now navigate and the navigator should now drive.** The driver should send their code to the navigator, either by saving the java file to their Google drive and sharing it, or by copying the code of the Java file to a shared Google doc. Then the new driver can launch DrJava and either load the shared file or copy in the shared code. Then change so the new driver is now sharing their screen.

In last week's lab, you had to move a window to the edge of the screen. This was challenging because you probably did not know the screen size of your monitor. Java has pre-defined classes that can provide you with the screen size. You will use them in this lab to help you with your tasks.

Toolkit is a pre-defined class that is used to manipulate the computer's desktop. One of the useful methods of Toolkit is getScreenSize which returns an object of type Dimension. Dimension represents a 2-dimensional coordinate.

Before you code with these classes, you should practice using them. Type the following code into the Interactions pane _(not in the editor)_. Of course, before you can use the classes, you have to import them!

import java.awt.Dimension;
import java.awt.Toolkit;

Now you can use these classes:

Toolkit kit = Toolkit.getDefaultToolkit();
Dimension d = kit.getScreenSize();

The first line calls a method of the Toolkit _class_ that creates and returns a Toolkit object of the proper _type_ for your system, and this object (or really its location in memory) is stored in the variable called kit. The second line calls the getScreenSize method of Toolkit on the Toolkit object and stores the reference to the returned Dimension in a variable called d.

Now you can access the values of the Dimension through either its methods or its fields. Type the following into the interactions pane. Remember to omit the semicolons so that you can see the values of these expressions.

d.getWidth()
d.getHeight()
d.width
d.height

So, you can use either the methods or the fields of Dimension to get the screen size. Note that the methods have a return type of double while the type of the fields is int. It does not matter which you use, but depending on what you decide you may need to use a typecast.

---

## Task 6. Creating Methods that Use the Screen Size

1. **Add a void method to the MaxWindow class called maximizeHeight. The method will move the window to the top of the screen and make it as tall as the screen.**
    
    The method should begin:
    
    public void maximizeHeight() {
    
    Your method will need to use the Toolkit and Dimension classes described above. First, you need to import the classes
    
      
             import java.awt.Dimension;
             import java.awt.Toolkit;
      
    
    Now, you will add code from above to your method to get the screen height and width. Note, you do not add _all_ the code you typed into the Interactions pane, just what is needed to get the required screen dimension.
    
    Save your code, compile it, and fix any errors. Test your code in the interactions pane. Create a MaxWindow instance and move it to somewhere other than the upper left corner. Call the maximizeHeight method, and if correct, the window should now stretch from the top to the bottom of the screen without changing in width or moving left or right.
    
    Place a comment above your method explaining what the method does. You should indent your comment so that it starts in the same column as the method.
    
2. **Add the void method maximizeWidth to the class that moves the window to the left of the screen and makes it as wide as the screen.** Save, compile, and test your class.
    

_Demonstrate your class to your lab teaching assistant._

---

## Task 7. Instance Fields and Conditional Statements

**Switch roles. The driver should now navigate and the navigator should now drive.**

We are now going to change the maximizeHeight and maximizeWidth methods. So that they can both maximize and restore the window sizes.

1. Create two fields inside the MaxWindow class. A field goes inside the class body but not inside any methods. The first field should be type boolean and given the name heightMaximized. The second field should be type int and given the name originalHeight. Just as with methods, fields need access modifiers, but unlike methods, we like to make fields private. Give heightMaximized the initial value of false and originalHeight the initial value of 0.
    
2. Change the maximizeHeight method so that it accepts a single boolean as input. You do this by creating a variable declaration for the input value inside the ( ) of the method header.
    
3. Save, compile your code, and test to see if you must now use boolean values when calling maximizeHeight. There should be no other differences. If there are any errors, fix them before moving on.
    
4. In the body of the maximizeHeight method, create a conditional statement. A conditional statement is of the form:
    
         if (condition)
            then-statement
         else
            else-statement
    
    In this case, our _then-statement_ will be a compound statement containing several simple statements. Our _else-statement_ will be another conditional statement. That second conditional statement will have a _then-statement_ that is a compound statement with several simple statements and no _else-statement_. The form looks like this:
    
    	if (condition1) {
    	   statement1;
    	   statement2;
    	   statement3;     (Note there could be more than 3 statements here)
    	} 
    	else if (condition2) {
    	   statement4;
    	   statement5;
    	}
    
5. The first condition should check if the input to maximizeHeight is true _and_ the heightMaximized field is false.
    
6. The simple statements inside the then-statement compound statement should do the following:
    
    1. Store the current height of the window to the field originalHeight.
    2. Do the code to maximize the window and move it to the top of the screen. (The code should be moved here so that this is the only place the code exists inside the method.)
    3. Set the heightMaximized field to store true.
    
7. The second condition should check if the input to maximizeHeight is false _and_ the heightMaximized field is true.
    
8. The second compound statement should contain simple statements to do the following:
    
    1. Set the window height to be the value stored in the originalHeight field while keeping the width the same.
    2. Set the heightMaximized field to store false.
    
9. Compile and test your code. The window's height should be maximized when you call maximizeHeight(true) and it should be restored when you call maximizeHeight(false) (though the window location will still be the top of the screen.
    

**Switch roles. The driver should now navigate and the navigator should now drive.**

11. Once you have this working, make the same changes to maximizeWidth, and then _demonstrate your class to your lab teaching assistant_.
    

---

## Optional Task 8. Restoring the Window Location

Notice that when you restore the window height or width, the heigh and width goes back to what it was before you maximized the window, but the window is still moved to the top or left of the screen. Fix your code so that when you restore the height/width, you also restore the location so that it moves back to the location it was before you maximized it. As a hint, the change is _very_ similar to what you did with the originalHeight and originalWidth fields.

---

## Optional Task 9. Constructors and Instance Fields

Each class has one or more special methods called _constructors_. The constructor method is called whenever an object of the class is created by the new operator. At the moment, your class does not have a constructor. This is ok because Java uses a default constructor for any class in which no constructor is specified. The default constructor takes no arguments and (basically) does nothing.

Notice that both maximizeWidth and maximizeHeight methods have the same code to get the screen dimensions. Since the screen is unlikely to change during an execution of this code, it is not really necessary to have the method get the screen dimensions every time. Instead, we can have the object get the screen dimensions once when it is created and then use those dimensions as needed in maximizeWidth and maximizeHeight.

- Create two fields in your class called screenWidth and screenHeight. The fields should be created inside the class but outside the methods. Recall that a field is just a variable so you will use a variable declaration, but you should prefix the declaration with the access modifier private.
    
- Create a constructor method with no arguments. The constructor method is created in the same fashion as other methods except that it's name is the same as the class name and it has no return type.
    
    public MaxWindow () {
    
    The above constructor returns a MaxWindow object and takes no parameters.
- In the body of the constructor method, place the Toolkit code that gets the screen dimensions and store those dimensions in the screenWidth and screenHeight variables you created. (This means that while the declarations for the screenWidth and screenHeight fields/variables are outside the constructor, the assignment statements are inside the body of the constructor method.)
    
- Remove the Toolkit code that retrieves the screen dimensions from maximizeWidth and maximizeHeight methods, and replace the Dimension values in those methods with the screenWidth and screenHeight variables.
    

Demonstrate the constructor to your lab teaching assistant.

---

## Save and Submit Your Lab

Both you and your lab partner must submit MaxWindow.java. If you click on the _Lab 3_ hyperlink on Canvas, you will get a page allowing you to submit the lab and attach your MaxWindow.java. Please do that now.

**Important:** You must submit the file ending in .java. The files ending in .java~ are temporary files created by the DrJava editor. These probably contain incomplete and older versions of your code. The files ending in .class are created by the compiler and contain the conversion of your Java file into the intermediate bytecode that is interpreted by the Java Virtual Machine.