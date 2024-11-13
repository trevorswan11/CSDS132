An Interesting Java Class, inherited methods, the keyword "this"
  
  In lecture, we built GeometricFrame, a class that adds new features to JFrame.

  First, we create the class structure:
 
	public class GeometricFrame extends JFrame {

	}

  (Remember to import something!)

  Now, all the new features of that we want to add to GeometricFrame go in the class body:  between the { and }

The super/parent class:
   Every class (except one) in Java has exactly one super, or parent, class.
   The super class is set by the "extends ..." portion of the class header.
   If you do not write the "extends ...", then your class extends the Object class by default.
     (Object is the only class in Java that does not have a super clsas.)

   A class inherits all the public and protected instance methods of its super class.
   A class has access to all the public and protected class methods, instance and class fields, nested classes of the super class.
     - essentially a class has access to everything public and protected of the super class, but the instance methods are special.
       Instance methods are inherited from the super class. 
       You will see the difference between "access" and "inherited" in a lecture coming soon.


  In our example, GeometricFrame's super class is JFrame.
    That means GeometricFrame inherits all the public and protected instance methods of JFrame (plus access to the other public and protected things).
    So the GeometricFrame can do everything that a JFrame can do.  It can become visible, change its size, etc.

  How do we get the GeometricFrame to do something JFrame cannot?   We put a method inside the GeometricFrame class body.
     Everything we place inside the class will be indented.  This is the professional Java style (and general coding style) used to make clear what is inside the class and what is not.

  We added three methods:
    1) transpose:  flips the height and with width of the window.

       What access modifier?  public: we want to be able to use this method anywhere.
       What return type?  void: there is nothing we need to return.  (Hint: a method should just do what its name says it will do.  Any additional actions will only confuse the programmer.)
       What name?  transpose:  a great choice!
       What input values?  No input.  We want to just type j.transpose() to flip the window, similar to j.getHeight() to get the height.
	 One way to think of it: the window knows its own height and width.  We only should only provide as input data that the window does not already know.

	  public void transpose() {


       Now, how do we get the height and width of the window?  We use the getHeight() and getWidth() methods.  But whose height and width?
       When we type window.transpose() we want window's width and height, but window is not declared inside the method body or the class.
       The Java keyword we need is "this".
        this is a special variable that exists inside instance (non-static) methods.
	this stores the address to the object that the method is acting on.
	this acts a hidden parameter to the method.  We do not see it as input to the method, but it is.  When we call window.transpose(), Java will take the value stored in window (an address for an object) and copy it into the special variable called this.


	  public void transpose() {
	    int height = this.getHeight();
	    int width = this.getWidth();
	    this.setSize(height, width);
	  }

       As a hint, you don't actually need variables here.  Can you write it without variables?  See the posted code for the no-variables version.

    2) scale:  changes the window size by a scaling factor

       What access modifier?  public: we want to be able to use this method anywhere.
       What return type?  void: there is nothing we need to return. 
       What name?  scale: another great choice!
       What input values?  One input, the scaling factor.  What type should it be? double so that we can scale by values like one half. 

	  public void scale(double factor) {

	We again get the height and width:
	    int height = this.getHeight();
	    int width = this.getWidth();

	Now we can set the new height and width by multiplying by the scaling factor:
	    int newHeight = height * factor;
	    int newWidth  = width * factor;
	  
	    BUT, factor is type double so width * factor is also type double.  We need to convert this to int because newWidth expects an int value input, not a double.  (And setSize expects two int values, not two double values.)

	    int newHeight = (int)(height * factor);
	    int newWidth  = (int)(width * factor);
	    this.setSize(newWidth, newHeight));

	    If you want to be completely accurate, we should fix the math a little.  The typecast will truncate the values instead of round them.  You will see rounding in next week's lab.
		
       Again, you don't actually need variables here.  We can replace each of the local variables with the expression representing its value.

	  public void scale(double factor) {
	    this.setSize((int)(this.getWidth() * factor), (int)(this.getHeight() * factor));
	  }


   3) isSameArea:  returns true if this window is equal in area to another window
	What access modifier?  public so we can use the code anywhere
	What return type?  boolean, to say true or false
	What input values?  We need to know what window we are comparing this window to.  So we need a single input value
	   What should I use for the input type?  I decided on JFrame.
	   
	  public boolean isSameArea(JFrame frame) {

	Now, to compare the area, we need the width and the height
     
	  public boolean isSameArea(JFrame frame) {
	    int thisArea = this.getWidth() * this.getHeight();
	    int framesArea = frame.getWidth() * frame.getHeight();

	  Now, what do we return?  The result of comparing the two areas.
	    (Remember, that we can use any expression anywhere in the code as long as the types match.  Here, we need to return a boolean.
	    return thisArea == framesArea;

	 So, here is the full code:

	  public boolean isEqualTo(JFrame other) {
	    int thisArea = this.getWidth() * this.getHeight();
	    int framesArea = frame.getWidth() * frame.getHeight();
	    return thisArea == framesArea;
	  }

	Again, we can write this without using the three variables "framesArea" and "thisArea" and "sameArea".

    How do we call the method?

	GeometricFrame frame1 = new GeometricFrame(100, 100);
	GeometricFrame frame2 = new GeometricFrame(1000, 10);

	frame1.isSameArea(frame2)

      What is important?  The value to the left of the dot must be of type GeometricFrame, and frame1 is.
	The input value must be of type JFrame, but we gave it a frame2 that has type GeometricFrame.

	This is okay because the rules for automatic widening applies to non-primitive types as well as primitive types.
	   Just as int values are automatically widened to double when needed (but the other direction requires a typecast),
	     a value that is a class type can be automatically widened to its super class (but the other direction requires a typecast).


       Every GeometricFrame is a JFrame, but not every JFrame is a GeometricFrame.
	
	JFrame f1 = new GeometricFrame();    <=  Legal because JFrame is wider than GeometricFrame
	f1.setSize(300,500);
	f1.scale(1.3);                       <=   error scale does not exist for JFrame

	More on non-primitive type rules in the next few lectures!


