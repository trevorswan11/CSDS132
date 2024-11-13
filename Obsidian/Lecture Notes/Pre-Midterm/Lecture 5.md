Starting Java Programming

  Expressions are code fragments that have values (and types).  
    For example:  5,  3+3,  j.getWidth()   are all expressions
    (Note: Java allows expressions without values.  These are considered to be type "void".)

  A statement is a Java command.  A statement can either be a single simple statement or a compound statement
     - all simple statements end in a semi-colon.
     - a compound statement is where you combine 0 or more statements into a single statement
        - compound statements are bracketed by { }
        - a compound statement is also called a "block" of code

All Java programming consists of writing non-primitive types.

Creating a Non-Primitive Type
	*means you're creating a class. you can create instances of class*
			use instances for method fields

  The basic non-primitive type is a class.  Here is how we create a class:

	public class MyFirstClass extends Object {
	}

The part the starts with "public" is called the **"class header"**.  
The part between the { } is called the "class body". 
All elements of the class (fields, method, other compound types) go in the body (between the { }).

The parts are:
   public:  the access modifier
   class:   this is a class
   MyFirstClass: the name of the class (a name can be almost anything, but professional Java style is to always start with a capital letter)
   extends Object:  indicates the super class of this class.  Every class has exactly 1 super class (also called the "parent" class).

The access modifier determines where the code can be directly accessed.  (This is not a security feature.  All code can still be indirectly accessed.)
The access modifier can be any of the four:
 	public:  the code can be used/accessed anywhere in the program
 	protected:  the code can be used in this type and in any type that extends this type (or in any type in the same folder as this type)
 	private: the code can only be used in the body of this type

	If you omit the access modifier, the default is "package-private": the code can be used in any type that is in the same package (i.e. in the same folder) as the containing type.

public(access modifier) class(keyword) *meaningful file/class name* 


Super Classes:
   What is the point of the super class?  Your class inherits all the public and protected instance methods of the super class:

	import javax.swing.JFrame;

	public class MyFirstWindow extends JFrame {
	}

   -> Now MyFirstFrame inherits all the public and protected methods of JFrame, and so we can use them even though we did not explicitly write them in the MyFirstFrame body:

	MyFirstWindow f = new MyFirstWindow();
	f.setVisible(true);
	f.setSize(300,500);
	
      and so on.




What can go in a class body?
  - field declarations (these can include assignment operators)
  - methods
  - other non-primitive type definitions (these are called inner types or nested types)
 
  4. Each public class must go in its own file.  The file name must be the same as the class name, and the file extension must be .java.  
     The class must be compiled before you use it.  The compiler creates a file with the same name but .class extension that contains the Java bytecode for the class.

  5. What's the point of a super class?
     - Every class "inherits" all public and protected instance methods of the super class.
     - Every class has access to all public and protected constructors, fields, class (i.e. static) methods, and nested types of the super class.
    (More about this later.)


Fields:
  There are two kinds of fields. Instance fields are memory that is allocated inside each instance.  Class fields are memory that is allocated outside of the instances.
   Thus, every instance has its own copy of an instance field.  There is only one copy of a class field that all the instances share.

  To create an instance field is the same as declaring a variable except you add an access modifier:
	access-modifier type name 
  To create a class field, you do the same but add the word "static" before the variable type:

    public class MyFirstClass extends Object {

        public int myInstanceField;
        public static double myClassField;

    }

  (We are making the instance fields public so we can use them directly in the interactions pane.  Typically, most fields will be private.)

  Every instance gets its own copy of the instance field.  The class field belongs to the entire class and not to individual instances.

  To access the class field, use the class name followed by a dot.
       MyFirstClass.myClassField = 10.0;
       double d = MyFirstClass.myClassField

  To use the instance field, you have to create an instance first.

	MyFirstClass c = new MyFirstClass()
	c.myInstanceField = 10; 


Methods:
   An instance method definition is a method header followed by a compound statement.

	access-modifier return-type name(input parameters) {
        }

 - here is an example that takes two inputs of type int and returns a value of type int

	public int myInstanceMethod(int input1, int input2) {

   A class method uses the same declaration but adds "static" before the return type:

	public static int myClassMethod(int input1, int input2) {

     (An instance method "operates" on an instance while a class method does not.  More on this very soon!)

 - the input parameters are a sequence of 0 or more variable declarations separated by commas.  There is one variable declaration for each input your method will take.

 - the return type can be any type, or if the method will not return a value, it is "void".

 - the part starting with the access modifier is called the "method header"
 - the part between the { } is called the "method body".
 - all code describing the behavior of the method goes in the body.  The body is by definition a compound statement.
    
	  public static int myClassMethod(int x, int y) {
 	    return x + y;
	  }

	A return statement must be included in any method that has a non-void return type.  The return statement gives the output of the method.


Here is an example of a class:

	public class MyFirstClass extends Object {

	  public static int myClassField = 100;
	  
	  public int myInstanceField = 20;

	  public static int myClassMethod(int x, int y) {
	    return x + y;
	  }
	}

Now we can use the methods and fields:
	> MyFirstClass.myClassField
	100
		-- Notice that we did not have to create an instance of MyFirstClass to access the class/static field
	> MyFirstClass.myInstanceField
	Error!
		-- The instance field belongs to an instance, and so we have to create an instance for it to exist.
	> MyFirstClass c1 = new MyFirstClass()    
	> c1.myInstanceField
	20
		-- Now we can ask for the instance field of the instance stored in c1
        > MyFirstClass c2 = new MyFirstClass()
        > c1.myInstanceField = 200
        > c2.myInstanceField = 100
        > c1.myInstanceField
	200
	> c2.myInstanceField
	100
		-- Notice how each "instance" of MyFirstClass has its own myInstanceField with its own value
	> c1.myClassField = 1000
	> c2.myClassField = 2000
	> c1.myClassField
	2000
	> c2.myClassField
	2000
	> MyFirstClass.myClassField
	2000
		-- Notice how there is only one class field that actually belongs to MyFirstClass.  The two instances share the same field.
	> MyFirstClass.myInstanceMethod(10, 20)
	30

