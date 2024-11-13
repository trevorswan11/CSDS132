
A short history of programming languages.
  - All data on a computer is just numbers (interpret each wire as a binary bit: current = 1, no current = 0)
  - Computer programs are likewise just numbers that (current on a wire = 1, no current = 0), but now the signals on the wires control the switches.
  - Each central processing unit (CPU) has its own "machine code"
     - the numbers that do the specific CPU operations
     - there are a limited number of operations a CPU can do (simple integer and floating point arithmetic, storing and retrieving bytes from memory, controlling which operation to do next)
         - primitive operators, variables, if-statements

  - Programming languages have been devised to make programming more human-friendly.

  Computers were invented in the 1940's.  The first programming languages appeared in the late 1950's:
    FORTRAN (scientific computing), Cobol (business computing), LISP (Artificial intelligence), Algol (intended as a general purpose language but never implemented)
  1970's: C developed at AT&T Bell Labs for use in writing the Unix operating system.  Based on Algol, very close to machine code so was good for coding hardware.
            - became popular in academia because C and Unix were free (AT&T, as a phone monopoly, was not allowed to compete in the computer industry)
            - no safety features and limited data management features
  late 1970's: object-oriented programming developed at Xerox (along with other cool computer things) as a natural way to represent data
  1980's: C++ was created by adding objects to C.  Became one of the most popular industrial langauges.
  1990's: Java was created by Sun Microsystems by as a safe variation C++.
  2000's: C# developed by Microsoft by adding C++ conveniences back into Java.  (Popular for game development because the XBox libraries are in C#.)

Compilers
  Computers still use machine code.
  Compilers are needed to convert programs written in a non-machine code programming language to machine code.
    - Since each machine has its own machine code, you would need to compile down to different machine codes.
    - Then the machine code is sent to your customers.  It does not matter what the original programming language was.

  Java does things a little differently.
  - The Java compiler converts Java code into "Java bytecode"
    - Java bytecode is close to machine code, but is not directly run on the machine
    - Instead an interpreter, called the Java Virtual Machine, interprets the Java bytecode.
    - To run a Java program, the computer needs the Java Virtual Machine.
    - The design decision allows us to compile the Java program once and the JVM will make sure it behaves the same on every machine.
  - You can compile the Java code all the way to machine code for a specific machine, but you need to download a special compiler from Oracle for that.

## **FIELDS WILL BE CREATED AS PRIVATE. WE DONT WANT THEM TO MAKE THEM PUBLIC. IF YOU WANT TO READ THEM FROM OUTSIDE CLASSES, YOU NEED TO USE GETTER-SETTER METHODS**

Building a Class from Scratch
   We are going to create a game die. (This is the example in section 4.1 of the "Java Software Solutions" book, but we will improve it.)

     First we need to figure out what properties we want the game die to have and what behaviors it should be able to do.
     Then we code these using fields and methods.

Good Object-Oriented Coding, Part 1:
    To take advantage of the nice features of the Java language, we should follow some rules when writing our types.  Here are the first rules:
     1. Any data that must be stored in a type should be stored in a private field.
     2. Any access of the data (by code outside the class) should be implemented using a public (or protected) method.
     3. Any other behaviors we want for our type should be implemented using public methods.
#### STATIC DOESNT MEAN YOU CANT CHANGE IT, IT JUST MEANS ITS A DEFINED CLASS FIELD
   Java's power is in its methods (as we will see later).  As a result we want outside code to interact with our type through the methods as much as possible and not through the fields.  So we make the fields private and the methods public so that direct access to our code is through the methods.

  If we want to model a game die, we need to create a class, and we need the properties of:
    1) rolling a die
    2) getting a die face / value
    3) setting the die face
  For each behavior/property, we need to create an appropriate method. 

  What information will we need to remember for the die:
    1) the current face value (we have to remember the result of a roll)
    2) the size of the die (maybe we want a 4-sided die, a 6-sided die, etc.)

   What should the class extend?  If there is nothing in the API that matches the Die type, we should just extend Object.
     Note: do NOT extend a class unless it makes sense to say Die "is a" ... for the class you are extending. 
       Ex: If Die extends JFrame, then we are saying that all game dice are JFrames.  That would indeed be bizarre.

	public class Die extends Object {     // if we do not include "extends Object", Java will do that by default

	  private int currentValue = 1;

	  public int getValue() {
	    return currentValue;
  	  }

  We should add comments above each method and field so that someone reading the code understands the purpose:

	/* returns the current face value */
	public int getValue() {
	  return currentValue;
	}

        /* sets the value of the die */
	public void setValue(int value) {
	  currentValue = value;
 	}

  The problem is that this allows us to set the face to be any integer at all, and not just a value between 1 and 6.

  We can fix this using a conditional statement.

  Conditional statements
        if (condition)
           then-statement
        else
           else-statement

     condition is an expression with a boolean type
     then-statement and else-statement can be either simple or compound (but they must be a single statement)
     The "else else-statement" part is optional.

     How it works:
        1) the condition is evaluated
        2a) if the condition is true, the then-statement is executed
        2b) if the condition is false and the else-statement exists, the else-statement is executed
	3) the next statement of the program is executed

  Let's first set the size of a die.  We will use a variable for two reasons.
    1) This way we can create die with different sizes (Friday's lecture)
    2) We use a "name" for the size of the die and that makes our code easier to understand than using straight numbers.  Generally, any number that is not a 0 or 1 should be given a name to explain its purpose.

  The size of a die will not change so we mark the field as "final".  "final" means that the value will not change once set.

	private static final int dieSize = 6;

	private int currentValue = 1;

	public void setValue(int value) {
	  if ((value >= 1) && (value <= dieSize))
	    currentValue = value;
	}


    Finally, let's write the code to roll a die.
    To get a random value, we use the method Math.random that returns a double in the range [0.0, 1.0), and we use math and our typecasting to convert the number to {1,2,3,4,5,6}.
    We will also use the methods we created to set and get the face of the die.

	public int roll() {
	  setValue((int)(Math.random() * dieSize + 1));
          return getValue();
	}


