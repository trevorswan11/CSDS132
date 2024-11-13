# Programming in Java: Lab 8  
Reading From and Writing To Files, and JavaDoc

In this lab, you will learn how to read from and write to files, and you will learn the JavaDoc commenting style.

## Task 1. Assigning Lab Partners

If you wish to have a lab partner (and you are strongly encouraged to do so), see your lab instructor. You may keep your lab partner from last week, but you do not need to.

### Reminder About The Rules For The Lab

### If You Do Not Have a Lab Partner

You are to do the tasks listed below. The tasks require you to write a class that contains specific methods. You need to complete all the methods as described. If you fail to complete all the tasks by the end of lab, you may continue to work on them, but you must complete the lab prior to the deadline posted.

### If You Have a Lab Partner

You will play two different roles in the lab. You will either be the _driver_ or _navigator_.

- **driver:** The person typing at the keyboard.
- **navigator:** The person watching for mistakes, making suggestions, and thinking ahead.

_**Important:** The navigator must not edit the code._

Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.

As in last week's lab, you will write a class that you will submit at the end of lab. You do not have to complete all the tasks by the end of the lab because you are being graded on how well you work as a team. You do have to make a good effort to get full credit.

---

## Task 2. Introductions and Starting DrJava

If you have a lab partner, tell your lab partner your name as well as the title of one of your favorite books.

Choose one of you to start as the driver, and launch DrJava.

### _If you are new to programming,_ your goal is to make it to Task 6 during the lab session. If you have not completed Task 6 and there is less than 15 minutes remaining, be certain to ask one of the lab assistants for help.

---

## Task 3. Getting Started: A JFrame with a Text Area

Download Lab8JFrame.java from Canvas.

Open Lab8JFrame.java in DrJava and inspect the code. Notice that it has a private field for a new gadget that is a JTextArea, and that the constructor places the text area into the center of the JFrame window. The constructor then calls pack() which resizes the window to fit the text area.

Compile Lab8JFrame.java, and in the Interactions pane make a new Lab8JFrame and display (i.e. setVisible(true)) it. Notice how the window now has a text area with some sample text written into it.

For this lab, you will be focused on creating methods involving the text area.

---

## Task 4. Reading From a File

#### Basic File Reading

Java provides a few ways to read from a file. The basic way is the FileReader class. The following opens a file called f.txt for reading, if such a file exists in the appropriate folder:

FileReader fr = new FileReader("f.txt");

(You will have to import something....)

f.txt is the name of the file that will be opened. If no folder path is given, DrJava looks in the same folder that it last used to access your Java files. To open a file in a different folder, you should include the full path. For example: "H:\\MyDocuments\\MyFile.txt" on Windows machines or "/Users/_your id_/Documents/MyFile.txt" on Mac or "~/Documents/MyFile.txt" on Linux machines. (In the Windows example, you need to use the control character \\ when you want the string to contain a single backslash.)

Try it now. Replace f.txt in the line above with the name and/or path of a real text file on your system. You can use a Java file (such as "Lab8JFrame.java" or a file you create with a text editor such as the DrJava editor, TextEdit on Mac or Notepad on Windows. Do not use a Word file because it uses proprietary character representations and you will have a hard time reading the results.

Now you can read from the file using the read method of FileReader. The read method is overloaded, and the basic form is to read one character at a time:

fr.read()

Try this a few times so you can see the first few characters of your file. Note that the return type of read is int. How do you see the character representation instead of the number?

#### Buffered File Reading

Java provides several classes that we can "wrap around" a basic reader class to provide additional functionality. One of those classes is called a BufferedReader. The class BufferedReader provides a method called readLine that lets us read in an entire line of a file at a time, instead of one character at a time.

To create a BufferedReader object, you must first have a Reader object (and FileReader extends Reader and so "is-a" Reader).

BufferedReader br = new BufferedReader(fr);

or, we can combine the two steps:

BufferedReader br = new BufferedReader(new FileReader("f.txt"));

To read a line, use br.readLine(). When there is no more input, br.readLine() returns null. Test this a couple times so you can see how it works.

#### Handling Exceptions

An _exception_ is an object that indicates that some unusual condition, such as an error, occurred during your program execution. Up to now, we have ignored exceptions because the type of exceptions we have seen, such as NullPointerException were _unchecked exceptions_, and your code does not need to explicitly state how it will deal with an unchecked exception.

Most of the methods of FileReader and BufferedReader can throw an IOException, and IOException is a _checked_ exception. That means we must explicitly state how we will deal with the exception, if it occurs. There are two things you can do with an exception. You can _catch_ it (write code that is executed in the event an exception occurs) or you can _throw_ it (pass it on).

For this lab, you will throw the exception (pass it on). To pass on the exception, you must add throws IOException to the end of any method header that uses a method from one of the java.io classes. The throws IOException has two purposes. First, it indicates that the method will throw this exception, if it occurs, and second, it warns any method that will use this method that an unchecked exception could be thrown.

---

## Task 5. Displaying a File

**Switch roles: The navigator should drive and the driver should navigate.**

Create a void method called fileDisplay that takes a single String as input. The input String is the name of a text file whose contents will be displayed on the screen. You will using the FileReader constructor and the BufferedReader readLine method, and both can throw an IOException so you must explicitly deal with it:

public void fileDisplay(_parameter list_) throws IOException {

The method should display the contents of the file to the text area. You will need to do the following:

1. Clear the text area contents by setting it's text to be the empty string. (If you can't figure out how, look up the appropriate method from the API.)
2. Open a BufferedReader for the file specified by the parameter.
3. Create a loop that reads from the BufferedReader and appends the contents read to the text area. There are two ways to do this:
    - Use the readLine method of BufferedReader to read the file one line at a time. When appending the line to the text area, you will also need to append the special newline character '\n' at the end of each line.
    - Use the read method of BufferedReader or FileReader to read the file one character at a time. When appending the character to the text area, you may need to convert it to the appropriate type.If you can not figure out how to append a line or character to the text area, look up the method from the Java API.
4. You should close the readers once you are done reading in the file and placing the contents in the JTextArea.
5. Make sure you pack the JFrame at the end of the method so that the window resizes to display the whole file.

For example,

frame.fileDisplay("Lab8JFrame.java")

should make make a new window showing your class code.

**The most common error students get is to have only every other line of the file appear in the text area. If you have this error, look closely at your loop and reason through what each line is doing.**

Demonstrate to your instructor or lab assistant that it works.

---

## Task 6. JavaDoc! Comments

There is a comment directly above the class definition. Change it to include your names. The format of the comment should be:

/**
 * A window with a text area that works as a simple text editor.
 * @author _Your name goes here_
 * @author _Your partner's name goes here_
 */

Now create a comment directly above the fileDisplay method you just added. The comment should be:

  /** 
   * Displays the contents of a file to the center text area.
   * @param fileName  the file to be displayed
   * @throws IOException if there is a problem reading from input file.
   */

fileName should be replaced with the name of the parameter variable you use in your method. The use of two *'s at the start of the comment is important as is the correct spelling of @param.

Save the file and then run JavaDoc on Lab8JFrame.java by clicking on the _Javadoc_ button on DrJava. The button will prompt you for a destination directory. The default will be the same folder as your lab files. You can use this folder, but it may be better to create a subfolder called _doc_ and select that. DrJava will then run a program called JavaDoc on every Java file you have in the folder. At the end, DrJava may automatically pop a browser that loads the page index.html in the folder you selected.

If JavaDoc gets an error or says that it runs correctly but fails to create HTML files, it is because there is some Java file in your folder that does not compile. You can either temporarily remove it by changing its file extension to something other than .java, for example .java-, JavaDoc will work. Or, you can place the Lab8JFrame.java in its own folder, and then run JavaDoc on it.

If a browser does not automatically open, launch either Firefox or Explorer, select _File_, then _Open_ or _Open File_, and navigate to the folder you selected for JavaDoc, either the same folder as your lab files or a subfolder called _doc_. You will see a file called index.html in that folder. Load it into your browser.

**When the browser pops up, you are allowed to gasp at how cool this is! Be sure your lab partner hears your gasp!**

Scroll through the page. Notice the comment at the top of the page corresponds to the comment you placed at the top of the file. See how your names appear and compare that to what you placed after the @author tag. Scroll down to the bottom of the HTML page. Notice that the comment for fileDisplay lists the **Parameters:**. Notice, in Lab8JFrame.java the comment tag @param that produces them. You will use a separate @param tag for each parameter of your method. (You will also use a @return tag for non-void methods.) It is important that you remember these because all homeworks starting with Project 3 will require you to write comments in the JavaDoc style.

---

## Task 7. Writing to a file

**Switch roles: The navigator should drive and the driver should navigate.**

#### Writing to a file

Similar to reading from a file, Java provides classes for writing to a file. The base class to write to a file is FileOutputStream. As with the FileReader, the FileOutputStream only writes a byte at a time. A second class, PrintStream can wrap around the FileOutputStream and provides the ability to write a line at a time.

The following code opens a file for writing; PrintStream has methods print and println, just like with System.out:

    f

So, p.print("Hello"); will print the string "Hello" to the file file.txt, and p.println("Hello") behaves exactly the same except that it includes a newline character to the end of "Hello".

#### Your programming task

Create a void method called saveFile that takes one String parameter. The parameter is the name of the output file, and the method should copy the contents of the text area to the output file. _As a warning, do not use an important file as the output file; you will lose the contents!_

Find an appriopriate method in the Java API to get the text currently in the text area. You can then use some combination of the print, println methods of PrintStream with either the String or a StringReader to write the contents to the output file. There is more than one way to do this.

Note that you can edit the text currently displayed in the center text area, and your changes will be saved to the file by the saveFile method.

---

## Task 8. Prevent the Overwriting of Existing Files

The problem with the saveFile method is that it will overwrite an existing file. To prevent this, modify the saveFile method so that it first creates a File object for the output file. Use the File object to test whether the output file already exists. If it does, print an error message and do not do the copy.

---

## Optional Task 9. Handling Exceptions

**Switch roles: The navigator should drive and the driver should navigate.**

Right now, if an IOException occurs, your code will "crash" and print an error to the interactions pane. Instead, you can use a try/catch to catch the exception in both the fileDisplay and saveFile methods. We will not have gone over try/catch yet in lecture, and so if you want to do this optional task, you will need to look it up.

If the IOException occurs, pop up a Swing JOptionPane.showMessageDialog with an appropriate messge. Using the API, see if you can give a different message for different types of problems that may have occurred with reading or writing the files.

---

## Task Last. Finishing Up

Submit your Lab8JFrame.java file. Remember that both you and your lab partner should submit the file.