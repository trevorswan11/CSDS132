Java Memory Model, Part 1

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

The Java Memory Model:

  Java (and all programming languages) split the memory available for the program into two parts: the heap and the stack.

  The stack is organized memory used for method calls.  In Java, the default is to set aside about 1MB for the stack (this can be changed when you launch Java).
  The heap is unorganized memory used for data that needs to be more permanent.  In Java, all classes and objects are stored in the heap.

For every class your program uses, a class "object" is stored in the heap.  The class "object" stores:
  1) The super class of the class
  2) All methods (static and non-static) defined in the class.
  3) All constructors of the class.
  4) All static fields declared in the class.
  5*) Any classes that are inside this class.

For every object (instance of a class) created by your program (e.g. by the new operator), space for the instance is allocated in the heap.
The instance record stores:
  1) The true type of the object.
  2) All non-static fields of all the polymorphic types of the object. (this class, the class this class extends, etc.)
     The fields are stored in order starting from Object and down to the true type.

For example, we have a program that uses our Employee and HourlyEmployee classes.
In the heap, Java will place "objects" for the Employee and HourlyEmployee classes.  There will also be an "object" for the Object class since that class is extended by Employee.
   There will also be an "object" for String since String is used in these classes.

  The Employee class "object" in the heap stores:
	super class: the address of the Object class "object"
	methods:  getName(), setName(String), getNumber(), getSalary(), setSalary(double), toString(), equals(Object), earnsMoreThan(Employee)
	constructors: there are two overloaded constructors:  Employee(String), Employee(String, int)
	static fields: lastEmployeeNumber

  The HourlyEmployee class "object" in the heap stores:
	super class: the address of the Employee class "object"
	constructors: there is currently only one constructor:  HourlyEmployee(int, String)
	methods: getHourlyWage(), setHourlyWage(double), getHoursWorked(), setHoursWorked(double),  getSalary()
	static fields: none

Creating an object:
  	Employee e1 = new Employee("Deb")

  Space is allocated for an instance in the heap.  The instance object contains:
    true type:  the address of the Employee class "object" 
    the fields of Object:  (whatever they are)
    the fields of Employee: name, number, salary

  How does new work:
    1) allocates space in the heap for the instance
    2) calls the constructor for Employee.  In this case we call the Constructor that takes (String) as input.
       2.a) the first thing the constructor for Employee does is call this(name, Employee.lastEmployeeNumber + 1), another constructor of Employee.
       2.b) the first thing that constructor for Employee does is call super(), the constructor for Object.  That initializes all the Object fields.
       2.c) next the constructor initializes the Employee fields to 0, null or false - this is important because salary is not being set in the constructor body.
       2.d) now we execute the body of the constructor (if you look at the code, it assigns the name and number fields as well as the lastEmployeeNumber static field)
    3) returns the location in the heap of the instance (this is the value that gets assigned to variable e1)

  Another example:
	Employee e2 = new HourlyEmployee("Ryan")
	
  	1) Space is allocated for an instance in the heap.  The instance object contains:
	    true type:  the address of the HourlyEmployee "object" 
	    the fields of Object:  (whatever they are)
	    the fields of Employee: name, number, salary
	    the fields of HourlyEmployee: hourlyWage, hoursWorked
	2) Run HourlyEmployee's constructor to initialize those fields
	  2.a) The first line is "super(name)" so Employee's constructor that takes a String as input is run
	    2.a.1)  The first line of Employee's constructor is "this(name, Employee.lastEmployeeNumber + 1)" so Employee's constructor that takes a string and an int is run
	    2.a.2)  The first line of Employee's constructor is "super()" so Object's constructor is run
	    2.a.3)  The fields of Employee are given their default values.
	    2.a.4)  Now the rest of Employee's constructor body is run to initialize the name and number fields.
	  2.b) The fields of HourlyEmployee are given their default values
	3) The address of the HourlyEmployee object is returned so it can be stored in variable e2.

Polymorphism:  An object is multiple types: every type from its true type up the hierarchy to Object
  true type (run-time type): what the object is (as created by new).
    The true type never changes.
    The true type of a value in a piece of code can often not be determined just by reading the code.  (This is why "run-time type" is often used.  You can only know what the true type is by running or tracing the code and seeing what gets stored.)
    The true type determines what version of a method is executed.

  current type (compile-time type): how the object is being used - what whas it typecast to?
    The current type constantly changes with each typecast.
    You can always tell what the current type is by reading the code -> just look at the variable declaration, any typecast, or the return value of the method  (This is why "compile-time type" is often used. The compiler can figure out the type by reading the code.)
    The current type determines whether a method call is legal and which fields can be accessed.

    Remember that the computer does not care about types (everything it sees is binary numbers).
    We, the programmer, use types as a safety feature.  By setting a type, we are indicating what the value represents, and the Java compiler (Java being a strictly typed language) verifies that we are using the types correctly.
      That means, the compiler verifies that we do not call a method unavailable to the type nor access a field unavailable to the type.

Polymorphism and methods:
  Typecasting has no effect on what version of an instance method is called.  The instance method version is always the version
    of the true type.
  Typecasting does affect what field is accessed and what static method is called.


  Consider the two variables/instances:
      Employee e1
      Employee e2
  Both variables have type Employee so whatever is stored in those variables will have current type Employee.

  However, we used the code:
	Employee e2 = new Employee("Deb")
        Employee e2 = new HourlyEmployee("Ryan")
  So, because we can see the new operators, at this point it time we have the address to an instance with true type Employee in e1,
   and the address of an instance with true type HourlyEmployee in e2.

  What happens when we call a method?
	e1.setSalary(50000.0)
  (When the code was compiled, the compiler used the type of e1 to verify that setSalary with a single double is valid for that type.  i.e. is valid for Employee.)

  When Java sees a method call, Java does the following:
    1) Evaluates the left side of the dot to get an address.  (Here the needed address is stored in e1.)
    2) Goes to that address in the heap (it is an object), and goes to that object's true type in the heap. (Here, it will go to the Employee class.)
    3) Run's through the class's list of methods to find one that matches.  (It will find setSalary(double) in this list.)
    4) If the method is not found, if goes to the class's super class, and repeats step 3.
  In this case, it finds the setSalary method of Employee.  It runs
	this.salary = salary.
  The current type of "this" is Employee so it uses the salary field of Employee and it stores 200000.0 in that field.

  Another example:
	e2.setSalary(150000.0)
  The compiler uses the type of e3 to verify that the method getSalary with no input is valid for that type. 

  When Java sees a method call, Java does the following:
    1) Evaluates the left side of the dot to get an address.  (Here the needed address is stored in e2.)
    2) Goes to that address in the heap (it is an object), and goes to that object's true type in the heap. (Here, it will go to the HourlyEmployee class. Note that the type of e3 does not matter.  It uses the address stored in e3 to find the method to run.)
    3) Runs through the class's list of methods to find one that matches.  (There is no such method in HourlyEmployee.)
    4) If the method is not found, if goes to the class's super class, and repeats step 3.
  In this case, it finds the setSalary method of Employee.  It runs
	this.salary = salary.
  The current type of "this" is Employee so it uses the salary field of Employee and it stores 250000.0 in that field.
   (Note that if HourlyEmployee also had a salary field, that field would NOT be set by the setSalary method.  It is the field of Employee that gets set.)

  Another example:
	e2.earnsMoreThan(e1)
  Java does the following:
    1) Evaluates the left side of the dot to get an address.  (Here it is stored in e1.)
    2) Goes to that address in the heap (it is an object), and goes to that object's true type in the heap. (Here, it will go to the HourlyEmployee class.)
    3) Runs through the class's list of methods to find one that matches.  (It will not find earnsMorethan.)
    4) Go to the super class of HourlyEmployee.  (Here, it will go to the Employee class.)
    5) Run through Employee's list of methods.  (It will find earnsMoreThan in this list).

    Now it will run earnsMoreThan.
    Inside, it runs "this.getSalary().
    1) Evaluates the left side of the dot to get an address.  (Here it is the value this which is the address of the object that called earnsMoreThan, which is the address in e2.)
    2) Go to that address in the heap (it is an object), and goes to that object's true type in the heap.  (Here, it will go to the HourlyEmployee class.)
    3) Runs through the class's list of methods to find one that matches.  (It will find setSalary.)
    Note that "this" inside earnsMoreThan has "current type" Employee (because we are in the Employee class), but in this case it had "true type" HourlyEmployee.
    As a result, it found HourlyEmployee's version of getSalary() and will use that method.
    This is why we used getSalary() instead of the salary field inside earnsMoreThan.
    If we used the salary field, since the current type of "this" is Employee, it will only know about Employee's fields and will use Employee's salary field.  But with methods, the version of the true type is always run.


Polymorphism and static methods:
  When you access a static method, you place the class name or an instance to the left of the dot.  If you place an instance,
the Java compiler replaces it with the current type name.  
  Since the class name is used, Java goes directly to that class to access the method.

Polymorphism and fields:
  The compiler uses the current type to determine which field is accessed.  
  When you typecast an HourlyEmployee as Employee, you are saying that you will be treating it as an Employee.  Java will only
    make the Employee part of the instance visible (Object's fields and Employee's fields).  The fields
    of HourlyEmployee are still there, but they can't be accessed when the current type is not HourlyEmploye (or something that
    extends HourlyEmployee.)