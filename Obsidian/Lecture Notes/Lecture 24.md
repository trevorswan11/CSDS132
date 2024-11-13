Rules for Creating a Class Hierarchy
  If "A is a B" then make A and B non-primitive types where A extends B.
  If "A has a B" then make B a method of A.

  Move common attributes (i.e. methods) as high in the hierarchy as makes sense.  If "unrelated" classes have common behavior, then
   make an abstract class (or an interface that we will see in this lecture) that is a common super class.

  For all attributes, use private fields and public getter and (if allowing the value to change) setter methods.

  Anywhere you use the value in your code, except the constructor, use the getter and setter methods instead of the field.


Why do we follow the OO rules when making our classes?
  It provides the most flexibility when creating classes that extend our classes.
  Anytime we violate these rules, we limit the options for extending classes and we risk having code that does not work correctly.

Why do we use methods in our code and not fields?

   Since we write Rectangle using getWidth() and getHeight() in the area() method, we could define squares differently.
   We instead wrote Square1 that define the square so that it only used the height value.  Changing the width actually changes
     the height and getting the width actually gets the height.
   Then we demonstrated that if we used the fields in the area() method of Rectangle, this Square solution would not work because
     it would compute the area incorrectly.


   Here is another example using the original Square class.
   Right now, Square works correctly making sure that the height and width are always the same.
   However, somebody later updates Rectangle giving it a new method, and they do not write it correctly:

	public void doubleWidth() {
		width = width * 2;
	}

   This method just broke the Square class.  Square inherits this method, and if it is called, the resulting "square" will have a larger width than height!
   Those who use Square and rely on it will complain the Square is broken, but the problem is with Rectangle.
   Let's write the doubleWidth() method correctly:

	public void doubleWidth() {
	  setWidth(getWidth() * 2);
	}

   Now Square works correctly.  Square correctly overrides any methods it needs to force the correct behavior, and now if we call this method in Square, both the height and width are doubled.


Multiple Inheritance

  Some object-oriented languages such as C++ allow a class to have more than one parent.  For example, class C can extend both classes A and B.
   This means C will inherit methods from both A and B.  What if both A and B have a method m(), and inside class C we call method m()?  Whose method is called, A's or B's?
   This becomes really tricky if A and B both extend a super class X.  Suppose X has method m() and A and B both override m().
   Now consider:  X x = new C();
     x has current type X so x.m() is a legal method call.
     But the true type C determines which version of m is called.  So which version is it, A's or B's?

  In Java, each class can only extend one other class.  Thus there is no ambiguity.  We can get something like multiple inheritance by allowing a class to implement more than one interface.

Why Do We Need Multiple Inheritance?

  Consider the Shape hierarchy from the last lecture.
  What if we want to add a RegularPolygon to the hierarchy?
    A RegularPolgon is-a Polygon
    A Square is-a RegularPolygon
    A Rectangle is not a RegularPolygon
    A Hexagon is a RegularPolygon

  There is no way to correctly place RegularPolygon in the tree hierarchy for the classes and have all the "is-a" relations correct.

  Instead, let use create RegularPolygon as an interface.
  Now, we can have classes like Octagon and Hexagon extend Polygon, and have Octagon, Hexagon and Square "implement" RegularPolygon.


Java Interfaces

  A Java interface is a non-primitive type like a class, but it cannot contain instance methods, fields, or constructors.

    Specifically, an interface can contain:
      - static final fields
      - static public nested types
      - static methods
      - abstract public instance methods (method stubs)
      - starting in Java 9, private methods will be allowed

   The main purpose is to contain public abstract methods.

  To create an interface:

        public interface MyInterface {
          void methodStub1(int x, int y);

          int methodStub2();
        }
 (since all methods stubs in an interface have to be public and abstract, we can drop the "public abstract" part)

  An interface can extend 0 or more interfaces.  (You place "extends ..." just like you do with a class, and for multiple interfaces, you separate them with commas.)

   
  To use an interface in a class: a class can implement 0 or more interfaces.

	public class MyClass implements MyInterface {
	   // here MyClass inherits the abstract methods methodStub1 and methodStub2
           // because a class cannot have abstract methods, we must override these method stubs with methods with bodies
	}

   Here is another example:

        public class Square extends Rectangle implements RegularPolygon {
          ....
        }

  If you will implement more than one interface, separate the interface names with commas.
  Implementing an interface is -exactly- like extending a class.
  So, a class that implements an interface inherits all the methods (or in this case method stubs) of the interface.
  A class (that is not abstract) cannot contain method stubs.  So, the class must override each of the method stubs from the interface.

  Note how this simplifies the multiple inheritance problem above.  A class may inherit a method stub from more than one parent, but it can only inherit an instance method that contains a body from its class parent.  


  NOTE: Students tend to get mixed up on "extends" vs. "implements".  They mean exactly the same thing. 
    Java uses "implements" for the specific situation where we are indicating that a class as an interface as a supertype.
    All other situations where we are indicating a supertype, we use "extends".


Interface Example

  We created the RegularPolygon interface

	public interface RegularPolygon {

  The first thing we added is a method to compute the area of a regular polygon.  There are two ways we could do that.  Since interfaces allow static methods, we could (but did not) create a static method:

	public static double areaOfRegularPolygon(RegularPolygon p) {
	   ... a formula using p.getNumberAngles() and p.getSideLength()
	}

  But what we did was make a non-static abstract method and give it a default method body:

	default double areaOfRegularPolygon() {
	    ... a formula using this.getNumSides() and this.getSideLength()
	}

     You might want to make this method getArea() and hope that because it is a default method, any regular polygon can use it to automatically override the abstract method getArea() of Shape.
     That does not work.  When a class inherits methods, the methods it inherits from the class it extends has precedence over the methods it inherits from the interface it implements.
     So, because the class inherits the abstract method getArea() of abstract class Shape, that takes priority over an abstract method getArea() from RegularPolygon.

  Next, note that we need the instance methods getNumSides and getSideLength.  How do we make sure that RegularPolygon has them?
    We add them as abstract methods.

  Since all instance methods of an interface MUST be public and abstract, the Java style is to drop those two modifiers (but you can keep them if you want).

	public interface RegularPolygon {

	  int getNumberAngles();

	  double getSideLength();

	  default double getAreaOfRegularPolygon() {
	     ... a formula using this.getNumberAngles() and this.getSideLength()
	  }
 	}

   Now, anything that is a RegularPolygon will inherit the getNumSides and getSideLength method stubs and (if not an abstract class),
     must override them to make them normal methods.

     already get a normal getNumSides method inherited from Polygon and so will not have to override the method stub.
   The classes that implement RegularPolygon will still have to override the getSideLength method stub.

	public class Hexagon extends Polygon implements RegularPolygon {

	    private double sideLength;

	    public Hexagon(double sideLength) {
	      super(6);
	      this.sideLength = sideLength;
	    }

	    public double getSideLength() {       <-- this method is required by RegularPolygon so I decided to name my getter/setters appropriately
	       return sideLength;
	    }

	    public void setSideLength(double sideLength) {
	       this.sideLength = sideLength;
	    }

	    public double getArea() {            <- this method is require by Shape, but we have a static method in the interface for the area
	      return this.getAreaOfRegularPolygon();
	    }
	}
