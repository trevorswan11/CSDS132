Java Reference/Compound Types
  What we have learned so far:
    Everything stored in a computers is just a number in binary.
    All data in a programming language have a type associated with it: the type is what the programmer declares that the data represents.
    Java is strongly typed: all expressions that produce values have types
    Java is strictly types: Java verifies that each type is used correctly and gives an error if it is not.

  There are two kinds of types in Java:
    1) primitive types (int, double, char, boolean, etc) - these are all pre-defined
    2) compound types (called reference types in your book) - these are both pre-defined and created by the programmer

  The basic compound type is called a "class".  A class consists of
    1) variables of any type (Java calls variables inside of classes "fields")
    2) functions that take 0 or more input, possibly performs some action, and returns 0 or 1 value (Java calls these functions "methods")
    3) other reference/compound types
  There are a couple other kinds of reference/compound types that will be covered later.

  A class instance is called an "object" in Java.

  We will now give examples of 3 pre-defined classes:
     Object:  a generic Java class
     Math:    a collection of mathematical functions and constants
     JFrame:  represents a window on your computer screen
```
     import javax.swing.JFrame
     JFrame j = new JFrame()
     j.setVisible(true)
     j.setSize(200,400)
     j.getHeight...
```

    Object, JFrame and Math are different kinds of classes.  Object and JFrame are a "normal" classes in that you can create instances of them.
    Math on the other hand, is more limited in that you can't create an instance.  (Formally, the Math class has a private constructor.  You will see what that means soon.)

What can we do with classes?  Below I show you how to:
  1) Create an instance (i.e. a value) of the class
  2) Execute a method of a class
  3) Access a field of a class or instance
```
- JFrame j1 <- declare a variable j1 with JFrame type
- j1 = new JFrame() <- creates a space in memory with address j1
- This can be done in one line:
  JFrame j2 = new JFrame()

- j2 = j1 <- doesnt create new space in memory, just copies j1's address to j2. This means you have two references for one location 
- j1.setSize(100,200) <- this is nullifieed by the next line, there is no priority
- j2.setSize(300,400)
- j2.getWidth() -} 300
- j1,getWidth() -} 300
Again, this is because both j2 and j1 reference the same part of the memory
```

Using Classes:
  A value of a non-primitive type is called an object or an instance of that type.

  1) To create an instance (or value or object) of a class, use the new operator
	new desired-type(0 or more input values)

	new Object()    -> this results in a value of type Object

	new JFrame()    -> this results in a value of type JFrame
			-> note that to use JFrame, you must "import" the package.  See the note on Java packages below.

    The new operator does the following:
	1. Allocate space in memory for the type instance.
	2. Initializes the instance using the input data (it does this by calling a special method/function, called a constructor, whose sole purpose is initializing instances)
	3. Returns the location in memory of the instance.  This location is called the "reference" of the instance.

     So, when we have
	new JFrame()
      Java first allocates enough space in memory for the JFrame instance, calls the constructor method with no input, and then returns the location of the instance.

			VERY IMPORTANT POINT:  	For primitive types, the value of the type is the binary representation of the value.
			       			For reference types, the value of the type is the location of the instance in memory.

     Note that every time we call 
	new JFrame()
     we are creating a brand new instance of a JFrame. If we want to reuse the same instance, we need to remember it.  What is the only way to remember anything in Java?  With a variabl


Important: beginning programmers often struggle with the difference between a type and an instance of the type.
   For example, if the type is Movie, instances of the type are "Rocky II", "Star Wars: The Last Jedi", "Nope"
     Each instance refers to a specific, separate movie while the type Movie refers to the entire concept of what a film is.

    Ex:   type       |   instance of the type
	  -----------+------------------------
	  int        |   -3, 5, 100
	  JFrame     |   a specific window on your desktop
	  Movie      |   "Pirates of the Caribbean", "Nope", "Star Wars"

  A class instance is called an "object" in Java.

--------------------------
Side note: Java Packages
   All Java pre-defined compound/reference types are organized into packages.  
   JFrame is in the package javax.swing
   Math is in the package java.lang

   You should "import" a reference type before you can use it.
	import javax.swing.JFrame;

	new JFrame()

   You can import all the reference types in a package:
	import javax.swing.*;

   You do not have to import the type.  If you don't, you need to use the full name:

	new javax.swing.JFrame()

   Exception:  All types in the package java.lang are automatically imported.
     As a result, you do not need to import Math to use it.
--------------------------

  Now that we can create an instance of a class, let's store the value into a variable.
    Variables and Assignment with Reference Types:
        The rules are EXACTLY the same as for primitive types
	    int x          <- creates a variable called x that stores values of type double
            JFrame j       <- creates a variable called j that stores values of type JFrame

	    x = 5              <- stores the value 5 in variable x.  
	    j = new JFrame()   <- stores the location of the JFrame instance in variable j. 


To access something from inside a compound type, we use the "dot" operator. 
  2) Calling methods of a class
      There are two types of methods: instance methods and static (or class) methods.
        a) An instance method "acts" on an instance of the class.
           To call (execute) an instance method you use:
                instance-location.method-name(0 or more inputs separated by commas)
           For example, JFrame has an instance method setSize that takes two int values as input.  To call the method on 
             the JFrame instance whose location is stored in j, we use:

		j.setSize(300, 600)	<- calls the setSize method on the object whose address is stored in j.  The method takes two inputs, both of type int

            Here are some other examples:
	        j.setVisible(true)		<- calls the setVisible method on the object whose address is stored in j.  The method takes a single boolean input value
	        j.getHeight()		<- calls the getHeight method on the object whose address is stored in j.  The method takes no input.  The method returns a value of type int.

	        new JFrame().setVisible(true)	<- calls the setVisible method on the instance that was just created and returned by the new operator.

            Note: what is to the left of the dot has to be a value of an appropriate compound type.  Recall: in Java you can use *any* expression anywhere in your code as long as the types match.
	j and "new JFrame()" are both expressions with type JFrame so both expressions can be to the left of the .


        b) A static (or class) method "acts" on the class as a whole (or on nothing) and not instances of the class.
           To call (execute) a class method you use either:
             class-name.method-name(0 or more inputs)
             instance-location.method-name(0 or more inputs)

           While you can use either, we prefer the first.  That make it obvious that you are using a class method.
           Here are some examples:
	     	Math.cos(1.0)			<- the cos method "operates" on the entire Math type.
		Math.sqrt(5.0)

  3) Accessing fields
     There are two kinds of fields: instance fields and static (or class) fields.
     a) Instance fields: an instance field as a variable that belongs to an instance of the class.
           As a result, each separate instance has its own version of the field.

        To access an instance field, you use
	     instance-location.field

        Example: JFrame has a field (variable) of type boolean called rootPaneCheckingEnabled

		JFrame j
		j = new JFrame()
		boolean z = j.rootPaneCheckingEnabled
		j.rootPaneCheckingEnabled = true

	  You can think of the . as an "apostrophe s".  The expression j.rootPaneCheckingEnabled in Java is asking for j's (or more specifically, the JFrame whose address is stored in j) rootPaneCheckingEnabled variable.

     b) Class fields: a class field is a variable that belongs to the class as a whole.
           As a result, there is a single copy of the variable that all instances of the class share.

        To access a class field, you use either
	     class-name.field
	     instance-location.field

         As with class methods, we prefer that you use class-name.field when accessing a class field to make it obvious.

	 Example, the Math class has a class field called PI that stores the value of PI.

	    double x = Math.PI

  "Static" is not a really good name for class fields and methods because it sounds like a class field can't be changed.  It can.


Important: Remember that instances (i.e. values) of a class are actually addresses to where the data is stored, not the data itself.
   Consider how primitives work:
	int x
	int z
	x = 5
	z = x         -> z and x both now store 5
	z = x + 1
	  -> Now z is storing 6, but x is still storing 5.  They are two different memory locations storing two different values.

   Consider the same for non-primitives:
	JFrame j1
	JFrame j2
	j1 = new JFrame()
	j1.setSize(500,600)
	j2 = j1         -> j2 and j1 now both store the same value: the location of the actual JFrame data
	j2.setSize(1000,300)
	j2.getWidth()   => returns 1000
	j1.getWidth()   => also returns 1000
	  -> j1 and j2 are two different variables, but they both store the same location of JFrame data, so they are both accessing the exact same JFrame value
