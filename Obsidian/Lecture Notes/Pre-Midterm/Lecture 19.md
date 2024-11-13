Lets remember The Java API (Application Program Interface)
  An API is typically part of any pre-defined software package that you can use in your programs.
    It lists how you are to use the predefined programs.

  The Java API lists all the pre-defined classes (and other types) in Java.
  In the API you can find:
    the package the class is in (what you need to import)
    the header for the class
    a list of all non-private inner classes, constructors (what new uses to initialize the object), fields, and methods

  Keep the API bookmarked because we will be using it a lot in the course.
```ad-seealso
[[Java SE 8 API Documentation](https://docs.oracle.com/javase/8/docs/api/)]
```
Java Non-Primitive Type Rules
   Let's create a Phone class to represent telephones:

	public class Phone extends Object  {

	   /* a method to make a call to a particular number */
	   public void makeCall(PhoneNumber number) {
	      /* some code goes here */
	   }
	}
#### Private means it cannot be extended to another class!!!
	extends will ONLY inherit public and protected methods and fields
 What does the "extends Object" mean?  It says that any instance that is type Phone also is type Object.
   The Phone class "inherits" all the public and protected instance methods of Object.
   The Phone class "has access to" all the public and protected fields (both class and instance), class (i.e. static) methods, constructors, and nested classes of Object.

	public class CellPhone extends Phone {

	   /* a method to send a text */
	   public boolean sendText(PhoneNumber number, String text) {
	     /* some code goes here */
	   }

	   // <- Note that CellPhone inherits the method makeCall from Phone
	}

	public class SmartPhone extends CellPhone {

	   /* a method to download an app */
	   public void downloadApp(App app) {
	     /* some code goes here */
	   }

	   /* a method to use an app */
	   public void useApp(App app) {
	     /* some code goes here */
	   }

	   // <- Note that SmartPhone inherits makeCall and sendText from CellPhone
	}

	public class iPhone extends SmartPhone {

	  // <- iPhone inherits makeCall, sendText, downloadApp, and useApp from CellPhone

	  // <- iPhone will change the behavior of downloadApp so that it gets the app from the AppStore
	  // <- changing the behavior of a method is called "overriding" the method
	}

	public class AndroidPhone extends SmartPhone {

	  // <- AndroidPhone inherits makeCall, sendText, downloadApp, and useApp from CellPhone

	  // <- AndroidPhone will change the behavior of downloadApp so that it gets the app from the Google Play
	  // <- changing the behavior of a method is called "overriding" the method
	}

	
   Here is a map of the class heirarchy with a few extra classes thrown in 
Object
|
Phone (includes the method makeCall)
/    \
LandLine    CellPhone (includes the method sendText)
/    \
NokiaPhone   SmartPhone (includes the methods downloadApp and useApp)
	 /      \
Android    iPhone (overrides the method downloadApp, includes the method faceTime)
 $\uparrow$(overrides the method downloadApp)
	/   \                      \
Galaxy10  Galaxy20    iPhone13

Suppose we create an instance of iPhone13:   iPhone13 phone = new iPhone13();
1. When you create an instance of a class:
		new iPhone13()
	the instance is type iPhone13, but it is also the type of every class it extends (all the way up to Object),
	  so it is also type iPhone, SmartPhone, CellPhone, Phone, and Object
	It is all these types at the same time.  This is called "polymorphism" for "many types".

2. The "true type" is the type it is created as:  new iPhone13() means the instance will have true type iPhone13.
	(The "true type" is called the "run-time type" in Java references or sometimes just "class".)
       The "true type" is the narrowest of the valid polymorphic types for the nonprimitive value.
       Every object knows its true type (it is stored in the object's data), and the true type does not change.

3. The "current type" is which of its polymorphic types it is currently acting as at this instruction of the program.
	Every place that value is used in the code will have a current type associated with it.
	(The "current type" is called the "compile-time type" in Java references or sometimes just "type".)

4. You can typecast a non-primitive value to any of its valid polymorphic types.
	(An object created with "new iPhone13()" can be typecast as any of Object, Phone, CellPhone, SmartPhone, iPhone, or iPhone13, and no other class.  
         Likewise Galaxy10 is on a "different branch" from iPhone13 so an object with true type iPhone13 cannot be typecast to Galaxy10.)
        

 5. A typecast that goes "up" the hierarchy (wider) is automatic, by a typecast that goes "down" the hierarchy (narrower) must be explicit.

6. The current type determines what methods you are allowed to call as well as what fields and inner classes you will access.
	 For example,
	CellPhone c = new iPhone();
	  The object stored in c has true type iPhone, but the current type of c is CellPhone.
	  The typecast from iPhone to CellPhone is automatic and legal because CellPhone is wider than (up the hierarchy from) iPhone.
	  You can only call methods valid for CellPhone on c:
	c.sendText(...)    is legal
	c.downloadApp(...)  is not.
	= even though the object stored in c is currently a iPhone, you can't write this code because it will not work
	  for *all* cell phones. Later in the program, c might store a FlipPhone.
```ad-note
title:TypeCasting
Remember that narrow to wide typecasting is automatic!
Narrow is more specific while Wider is more general. Not really representative of the size of memory or class.
```
7.  The true type determines the version of an instance method that is called.
	  For example:
	 SmartPhone p = new iPhone();
	 p.downloadApp(...)   <- this will get the app from the AppStore
			  <-  why?  Because the true type of the object stored in p is iPhone and the iPhone class
				overrode the downloadApp method to use the AppStore
	 p = new AndroidPhone();
	 p.downloadApp(...)   <-  Same code, but now it will download from Google Play
			  <-  why?  Even though the current type of p is SmartPhone, the object stored in p has true type
				   AndroidPhone, and the AndroidPhone class overrode the downloadApp method to use GooglePlay.


 Why have this hierarchy?
    It enables us to write a method once and have it works for lots of different kinds of types:

	public void securePhone(SmartPhone p) {
	   p.downLoadApp(SpartanSafe);
        }

     Now we can write a program:
	For every phone in our database, call:
	   securePhone(phone)
        and it will load the SpartanSafe app onto the phone.  We don't need to write special code to test whether the phone we
	  are loading the app onto is Android, iOS, BlackBerry, or whatever.  We just call the downloadApp method of 
	  SmartPhone and count on the instance to know it's true type and thus to know which overridden version of the method to use.


A summary of the rules:
  1) Every object is created as a specific type using the new operator. I call this type the "true type". 
     The true type determines how the object will behave. It does this by determining what version of a method is run.
     The true type never changes.

  2) The object is not only its "true type".  It is also the type of the super class of the true type, that class's super class, and so on up to Object.  This property of being many types at the same time is called "polymorphism".

  3) A typecast does not change the object.  The typecast does not change the true type of the object.  Instead, the typecast determines which of the legal polymorphic types for the object is the object acting as at this line of code.
     I call the type that the object is acting as the "current type".  The compiler uses the current type to determine what methods you are allowed to call and what fields you can access.
     You can only call methods and access fields that exist for that current type.
     The specific field or class method accessed will depend on the current type, but the instance method that is used will be the version of the true type.


Arrays and Typecasting

  We can always typecast an array to Object because everything that is not a primitive value in Java is an object.

    int[] array1     <- array1 will store the location of the array in memory
    new int[100]     <- the new operator will return the address of the array
    Object o = array1   <- the typecast is legal because Object is above everything in the class hierarchy.
    array1 = (int[])o   <- the typecase is legal because the "true type" of the value in o is int[]

  Typecasting the individual variables in the array

    Because a typecast on a non-primitive type does not change the true type of the object, just its current type, Java allows us to typecast the types of the variables for arrays of non-primitive types:
	JFrame[] frameArray = new JFrame[100]
	Object[] oArray = (Object[])frameArray; <- Legal.  Object is wider than JFrame.  An explicit typecast is not needed.
	frameArray = (JFrame[])oArray;		<- Legal as long as the true type of oArray is an array storing JFrames or something below JFrame in the hierarchy
	oArray[0] = new JFrame();
	oArray[1] = "Hello"			<- Illegal.  While Object o = "Hello" is legal, here oArray[1] is referring to an element of frameArray.  frameArray knows that it is only to store JFrames.

    This does not work for primitive arrays:
	int[] array = new int[10];
	double[] darray = (double[])array;	<- Illegal.  Even though double is wider than int, Java will not allow this.
	char[] letters = new char[100];
	short[] values = (short[])letters;	<- Illegal.  Even though char and short are the same byte size, Java will not allow this.
    Java forbids any typecasting between primitive array.





