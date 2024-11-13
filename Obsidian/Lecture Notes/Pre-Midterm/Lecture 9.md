Overriding Methods.

The String class (non-primitive)

   String is a pre-defined class in Java and one of the most important classes.
   Strings represent text as a sequence of characters.
   Strings have a special means for creating instances.  While we can create instances using the new operator (just as with any class), we can also just place the desired string inside double quotes.
        "Hello"    <- this is a shortcut to creating a new String using the appropriate sequence of characters as input.
   Note that "Hello" acts just like the new operator, it evaluates to the address of the String object storing h,e,l,l,o.
#### This would have to be done by String s = new String("hello);
   We can use the object just like any other object.  We can store it
	String s = "Hello"; $\leftarrow$ this is so much more efficient

   +  Strings have a special operator, the + operator.  The result of + is a new String that concatenates the two operands together.
      If one operand is not a String, an appropriate String is created (through a sequence of object creation and  method calls) before the concatenation.

    Ex:   "Hello" + "there"    -> "Hellothere"
	  "Hello " + "there"   -> "Hello there"
          "x = " + 3           -> "x = 3"

    Note: you must be careful when mixing Strings and numeric primitives with the +.  When is the + meant to be a String concatenation and when is it meant to be a normal addition?
	"x = " + 3 + 5  will return "x = 35"  (+ is evaluated left to right)
     but
        3 + 5 + " = y"  will return "8 = y"
>[!important] Left to Right execution with the append or concatenate operator.

Overriding methods

  Overriding methods is the technique of Java where we re-define the behavior of an inherited method.
  We override an inherited method by writing a method that has exactly the same access modifier, return type(*), name, and input types.
   (*) the return type can be narrower if the return type is a non-primitive


Overriding methods of Object

    Employee extends Object and inherits the methods of Object.  There are two important methods we should override because their default behavior is not very useful.

   1) String toString()

  This method produces a String representation of the object.  It is used anytime we need a String representation of the object such as when writing to the terminal
    or when used with the String concatenation operator + to concatenate objects to a string.
  The method in Object sets the string to be the true type name of the object and it's "hash code" (basically its location in memory).
  Usually we want the string to be something more useful, so we override the method.

  In our case, we want it to be the employee number followed by the employee name

	public String toString() {
	  return this.getName() + ": " + this.getNumber();
	}


   2) boolean equals(Object o)

  This method is used to compare two objects.  If you use the == operator on non-primitive values, it is comparing the addresses of the values.  Thus, == only returns true if two objects are the exact same object.
    For example, "Hi" == "Hi"  only returns true if the two Strings are really the same string stored at the same location in memory.  If you create a String s that contains "Hi" but is stored at a different location in memory,
       then s == "Hi" will return false.
  The equals method is provided to examine the contents of the object to determine if they are structurally equal.
  However, the equals method will not compare the contents of objects by default.  The equals method in Object just does an == test.  Instead, we must override the method.
  For example, the String class overrides the equals method to compare the individual characters of the string.  Thus  "Hi".equals("Hi") always returns true.

++++++++++++++++++++++
+   IMPORTANT:  To override any method, we must exactly match the method parameter signature.  
+      Many Java textbooks and on-line references do not give the correct way to write an equals.
+      If you seach online, you will often find the suggestion to use      public boolean equals(Employee e) {
+	 but this does not match the parameter signature of the method in Object, and so it is overloading, and not overriding! 
++++++++++++++++++++++++

   We decided that we want employees to be considered "equal" if they have the same name and number.
   Here is the header for equals:

	public boolean equals(Object o) {

   How do we call the getNumber() and getName() methods on o when o is type Object?  First typecast to Employee:
	Employee e = (Employee)o;

   How do we get o's number and name to be able to compare it with this's number and name?
        this.getNumber() == e.getNumber() && this.getName().equals(e.getName());

   Now let's put this together, and to prevent the code from crashing on the typecast if the input is an invalid value, we should first verify that the typecast is legal using a Java operator "instanceof".

        public boolean equals(Object o) {
          if (o instanceof Employee) {
            Employee e = (Employee)o;
            return this.getNumber() == e.getNumber() && this.getName().equals(e.getName());
          }
          else
            return false;
        }

   instanceof:  returns true if object that is the left operand can be typecast as the type that is the right operand.  (I.e. is the object's true type equal or "below" the given type in the hierarchy.)
   If we do not use instanceof, the method will generate a TypeCastException when typecasting a non-Employee to Employee.

++++++++++++++
+ Recall how if works:
+    if (condition)
+       statement1
+    else
+       statement2
+
+  If the condition is true, statement1 is executed, and if it is false, statement2 is executed.  statement1 and statement2 are single statements.
+  They can be simple statements or compound statements, but they are a single statement.
++++++++++++++

   This equals method has overridden the inherited equals method.  And now there is only one version of equals available to Employee, and no matter how Employee is typecast,
	it will always use this version of the method.

+++++++++++++++++++
+     IMPORTANT: Some Java resources suggest using the getClass() method of Object instead of instanceof, but that is not as nice a solution because it will fail on classes that extends Employee.  instanceof only asks if the typecast is legal, not what the actual class of the object is.
+++++++++++++++++++

## Overloading
Constructors with the same name but have different inputs is called overloading. An example can be found below:
````ad-example
```
/* A constructor that takes the name and number as input */
    public Employee(String name, int number) {
        this.name = name;
        this.number = number;
    }

/* A constructor that takes the name as input */
    public Employee(String name) {
        this.name = name;
    }
```
````