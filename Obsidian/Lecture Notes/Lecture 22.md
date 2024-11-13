Creating a Class Hierarchy

  Suppose we want to create a program that does high school geometry?  We first need to identify the types of things that must be modelled in the program:
    lines, points, area, polygons, perimeter, triangles, squares, circles, circumference, etc..

  How do we organize this into classes?
    1. is-a rule:  If A is-a B then we make A and B classes where A extends B.
         Examples:  Square is-a Rectangle.
                    Square is-a Polygon
		    Triangle is-a Polygon
		    Rectangle is-a Shape
		    Circle is-a Ellipse

	So, the is-a relation suggests the following hierarchy:
		
                        Polygon         Ellipse
                      /        \          |
                  Rectangle   Triangle  Circle
				      |
				    Square
The Next rule we have is:
    2. has-a rule:  If A has-a B, then make B a method/methods in A.
	Examples: Square has-a area
		  Polygon has-a numAngles
		  Circle has-a area
****
    - To use inheritance well, we want to move each attribute as high up the hierarchy as we can.
	- Since all the above classes have an area, this suggests that we should make a common parent at the top of the hierarchy
so we can define area there, and if the other classes need to change how area is defined, they can "override" the area method.

                                 Shape
                               /       \
                        Polygon         Ellipse
                      /        \          |
                  Rectangle   Triangle  Circle
				      |
				    Square


    numAngles does not belong in Shape because ellipse and circle does not have sides.  Instead, the highest we will move that attribute is into Polygon.
    We will place height and width into Rectangle as well as into Triangle.  
It would be nice to move them up to a common ancestor as well, but Polygon may not be the right choice.  
What does height and width mean for an arbitrary polygon? 


#### Abstract Classes:
**methods must be overridden when extended**
- The only reason we created the Shape class was to have a common ancestor for things that all shapes have like area and perimeter.
- We do not want to be able to create an instance of "Shape" without specifying what type of Shape.
- So we can make Shape be an abstract class.
- **An abstract class is a class that cannot be instantiated.  It is used to enforce common behavior of all its child classes.**
- In this case, we want to be able to say that polygons, circles, rectangles, triangles, and squares are all "shapes", and all shapes have area.
- To get the last behavior, we make area a method of the abstract class.
- However, we do not know how to compute the area without knowing what type of shape it is, so we make area an "abstract method".
- An abstract method is a method with no body (i.e. it is a method stub).  All classes inherit the abstract method, but unless the class is abstract, it must override the abstract method to give it a body.
  (Otherwise, we could call the method without defining what it does!)

	public abstract class Shape {
	  public abstract double getArea();
	}

  An abstract class can containt -everything- that a normal class can (including constructors!), plus it can contain abstract methods.
  So, I can add normal methods too.

	public abstract class Shape {
	  public abstract double getArea();

	  public boolean isLargerThan(Shape s) {
	    return this.getArea() > s.getArea();
	  }
	}


Why have abstract classes and abstract methods if all classes extending Shape will need to override the method?
	Because it lets us guarantee that all "shapes" will have a getArea method.
	It will also mean that every shape will have Shape as one of its valid polymorphic types, so every shape can be typecast to Shape.
	This lets me write one "isLargerThan" method that will work for all possible shapes.
	If we did not have a class hierarchy, we would have to write a separate isLargerThan method in all the different classes, and we would have to overload it will all possible input types.
	Instead, I write it once, I can write it even though I don't know how to implement the area in an arbitrary shape, and it will just work for all possible shapes.
	It also means that other programmers can create new shapes I did not think of.  They just need to make their shape extend Shape, override the getArea method, and now their shapes will seemlessly interact with all of my shapes!!!!


Let's make some more types:
    Polygon should also be an abstract class because we do not know how to define the area of an arbitrary polynomial.
    Polygon class will be an abstract class with a constructor.  The constructor will set the number of sides to the polygon.

	public abstract class Polygon extends Shape {
	  private final int numSides;

	  public Polygon(int numSides) {
	    this.numSides = numSides;
	  }

	  public int getNumSides() {
	    return numSides;
	  }
	}

  Notice that Polygon does not need to override the area method.  It inherits the abstract method, and because Polygon is abstract, it is allowed to have abstract methods.

Now, we will create the Rectangle class.  Note that Rectangle is required to have a constructor because the Polygon DOES NOT have a constructor that takes no input. 
  Because Rectangle is not abstract, we must override any abstract methods Rectangle inherits.  In this case, it inherits area.  To compute the area, we need the height and width, and thus we should have a constructor that sets those values.

	public class Rectangle extends Polygon {
	  private double height;
	  private double width;

	  public Rectangle(double height, double width) {
	    super(4);
	    this.height = height;
	    this.width = width;
	  }

	  /* include getter and setter methods for height and width */

	  @Override
	  public double getArea() {
	    return getHeight() * getWidth();
	  }

	}

  Note that we are using the getter methods inside the body for area.  Doing so will make our work for Square (and any other class that extends Rectangle) a lot simpler.  

Here are the take-aways so far.  We will expand on these in our next lesson.
   1. Form a hierarchy using the "is-a" and "has-a" rules.
   2. "is-a":
      2a. If type B "is-a" type A, then we make B extend A.  You must be sure that everywhere type A is used type B can also be used.  If that is not true, then B is not also type A.
	  For example, we can use Square anywhere Rectangle is expected, and it makes sense.  Likewise, we can use Square and Rectangle anywhere that expects a Shape, and that makes sense.
	  It would not make sense to use Triangle anywhere that expects a Rectangle.
   3. "has-a":
      3a. Use "has-a" to decide on the methods for the class, and push common methods as high up the hierarchy as possible.
      3b. Use private fields to store the data and public or protected getter/setter methods as needed.
   4. Outside of the constructors, always use the getter/setter methods instead of the fields when accessing values of an object.  



Why do we follow the OO rules when making our classes?
  It provides the most flexibility when creating classes that extend our classes.
  Anytime we violate these rules, we limit the options for extending classes and we risk having code that does not work correctly.

  Consider Square that extends Rectangle.
    Square will not have to change how area is computed because Square will simply override the getter and setter methods to make sure that a square has the same width as height. 

	public class Square extends Rectangle {
	  public Square(double size) {
	    super(size, size);
	  }

	  /* need to override setLength and setWidth to make sure that this object is always has equal width and height (i.e. it is always a square) */
	}

  Here are two different ways to do this:
	Version 1:  Override the setWidth and setWidth methods so that both the width and height are always set the same
	  @Override
	  public void setWidth(double width) {
	    super.setWidth(width);
	    super.setHeight(width);
	  }

	  @Override
	  public void setHeight(double height) {
	    this.setWidth(height);
	  }

            --> Note the use of "super" above in super.getWidth(width);  super is a special word that means to use the method (or field) of the parent class.  This is the only way we can have a class call a method that was overridden.
                If we did not use "super", then the true type's version of setWidth would be called.


	Version 2:  We will use only the Rectangle's height to determine both the height and width of Square
	  @Override
	  public void setWidth(double width) {
	    this.setHeight(width);
	  }

	  @Override
	  public double getWidth() {
	    return this.getHeight();
	  }

	  (In this version, we can change the constructor to be:   super(size, 0);  because we are using only the height of Rectangle for the square and not the width)

   Which method is better?  Neither!  They both work the same.  However, note that if we had Rectangle's area method use "height * width" instead of "getHeight() * getWidth()", then Version 2 would not work!
    That does not mean Version 1 is better because there are other things we could have done in Rectangle using fields instead of methods that could have broken Version 1 as well.
    Instead, if we always use the methods in our code instead of the fields directly, we are giving programmers who need to extend our types the maximum amount of flexibility to write the code as they want.
 
