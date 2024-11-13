# Programming in Java: Lab 14  
Fun With Reflection

In this lab, you will use reflection to inspect the contents of a class.

**New Rules for the Lab If You Have a Lab Partner**

As in previous labs, you will work as a team with one person driver and one person the navigator. _In this lab, you will not be told when to switch roles. Instead, you and your partner should decide at various points in the lab who should be the driver and who should be the navigator._ Even though you will not be told to switch, you still need to follow good paired-programming practice: only the driver should edit the document. **And you must switch roles at least twice during the lab!**

**If you do not have a lab partner**, you are to do the tasks listed below and submit your lab prior to the deadline posted.

---

## Task 1. Introductions and Starting DrJava

If you have a lab partner, tell your lab partner your name as well as your plans for the summer break.

Choose one of you to start as the driver, and launch DrJava.

---

## Task 2: Some Background

Reflection is a way to explore the structure of a program. It is very useful when you need to make your code very flexible. There are two files included with this lab:

- Employee.java
- EmployeeQuery.java

The Employee.java file is similar to the one we developed in lecture, but some of the fields, getter, and setter methods have changed. _You will not modify this file during the lab._

Look at the EmployeeQuery.java file. Notice that it is a program that lets a user query data from an Employee object. The main method is a loop that gets input from the user. The loop uses a Scanner to process the user input. Scanner is a class of the API that is used to parse text data. In this case, we just need to get the next "word" the user types in. If the user types in getName, getAddress or getCity, the program responds with the data and loops. If the user enters quit, the program halts.

First note that if we want to let the user query all the possible getter methods of Employee.java, we will need a much bigger if statement. Also, if we decide later to change the Employee.java file by adding or removing getter methods, we would have to change the EmployeeQuery.java file.

However, if we use reflection, we do not need to write a huge if statement, and we do not need to change the EmployeeQuery.java file every time the Employee.java file changes.

---

## Task 3: Programming with Reflection

To use reflection, you need to import classes from the java.lang.reflect package.

Reflection is used to examine the contents of a class or object. For example, if you have an object that is a String s = new String(), you can use the statement

Class cls = s.getClass();

, and now cls is a variable that stores the contents of s.

To get a method from s, you can use

Method method = cls.getMethod(methodName, parameterArray);

The second parameter is a list of parameter types for the method you want. This must be an array of Class. To get a method with no parameters, just pass in an empty array: new Class[0].

Method stores a method. To call the method, use

method.invoke(s, argumentArray)

s is the object you are calling the method on, and argumentArray is an array of arguments to pass to the method. This must be an array of Object. If you are calling a method with no arguments, pass an empty array: new Object[0].

_Note:_ You will get a warning message when creating an array of Class. This is because Class has a generic type, but because you can not create an array with a parameterized generic, you have to drop the generic when you create an array of type Class. You should ignore this warning message.

### What you are to do:

As noted above, you will not be told when to switch roles. Instead, you and your partner should decide at various points in the lab who should be the driver and who should be the navigator. Even though you will not be told to switch, you still need to follow good paired-programming practice: only the current driver can edit the document.

For the lab, change the code so that you call whatever getter method the user types in and you print the result of calling that method. You are to use reflection so that actual method name does not appear anywhere in your code. For example, the user should be able to type in getName, getCity, getAddress, etc., and the program will respond with the proper data. The program should still stop when the user enters quit, and the program should ignore (or print an error message) if the user enters a value that is not a method name, and keep going.

---

## Task 4: A Little More Challenge

If you complete Task 3, try to modify your code so that the user can also enter the names of setter methods. In this case, the user will then need to enter the value to store, and the appropriate setter method should be called to store the value. As a hint, you can use the getMethods method to get an array of the available public methods. Then, you can look up in the array the method name the user typed. From the method, you can determine the number and type of input parameters, and then read in (and parse if needed) the appropriate number of inputs to the method.

---

## Task Last. Submitting Your Code

Once completed, submit your java file. _Remember that both you and your lab partner should submit this file._