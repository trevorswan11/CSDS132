More on Constructors:

  When we create an instance, it gets created as an instance of its super type, too, (and the super type of that super type, etc).

How Constructors Work:
	1) The first line of a constructor must be a call to another constructor.  (This is also the only place in the code were we can have a constructor call.)
           These are the two possibilities:
              super() <- possibly with input in the parentheses.  This calls (i.e. executes) the constructor of the parent class (the class this class extends).
	      this() <- possibly with input in the parentheses.  This calls a constructor of the same class.

	   If you do not explicitly have a constructor call as the first line of your constructor body, Java automatically places super(), with no input, there.
	   
	   WHY?  An object of type Employee is also type Object. 
             The purpose of the constructor is to initialize the object.  Before we can initialize the objects as Employee, it must first initialize itself as Object.

	2) The constructors do the following when they are run:
	    a) The first line of the constructor that calls another constructor is executed.  (Recall that Java adds super() if you omit this line.)
	    b) All fields of the instance are initialized.
	    c) The rest of the constructor body is executed.

   Note point (b) above.  Java basically takes any assignment statements on your fields and places that code after the constructor call that is the first line of your constructor and 
     before the rest of the constructor code.  This is important to remember for the situations where you care about the order that things are being done in your program.


  Let's create a class that extends Employee:

	public class HourlyEmployee extends Employee {
	}

  This class will not compile as written!  The reason is that we did not write a constructor so Java provided a default constructor.
  The default constructor takes not input and calls super() with no input.  Something like this:
	   public HourlyEmployee() { 
	      super();
	   }

  Now we see why HourlyEmployee fails to compile.  The first line of the HourlyEmployee constructor is super();
    super() calls the constructor of Employee that takes no input.  But there is no constructor of Employee that takes no input.
    The Employee class has two constructors.  One takes a String, and one takes an int and a String as input.  So, we have to either have a String or an int and String as a parameters to super();

  One thing we could do is to create a constructor that calls 
	super("Some Dumb String");
  And the code will compile because the types now match.  However, this is does not fit what we want Employee to be.
  The purpose of the Employee constructor was to require a name for each Employee.  We should write our code for HourlyEmployee
    to follow this idea, require a name as input, and then pass this name along to the Employee constructor.

  Here is the correct code.

	public class HourlyEmployee extends Employee {

	  public HourlyEmployee(String name) {
	    super(name);
	  }
	}

   Recall that HourlyEmployee inherits everything from employee.  So we get the name, number and salary for free.  HourlyEmployee having
    a salary could be a problem that we need to deal with.  But the key thing is we DO NOT create fields and methods for name and number because the methods are inherited.
   We also need to add things to HourlyEmployee that are not in Employee:  hoursWorked and the hourlyRate.


Remember our initial rules for good object-oriented style coding:
    1. Create private fields
    2. Create public getter/setter methods so that classes that extends this class can change behavior if they want.
    3. Everywhere in our code that uses a value, we use the getter/setter methods instead of the fields.
    4. Except in the constructor where, if we want a field to be initialized, we use the field directly.

  Here is an example to show why we only make methods public and use the methods instead of the fields in our code.

  Example:  Let's create a method in Employee that compares employee's by how much money they make.

  We created the method earnsMoreThan that compares the salaries of this employee to another employee.o
  Suppose we have this:
	public boolean earnsMoreThan(Employee e) {
	  return this.getSalary() > e.getSalary();
	}

  There is a problem: whoever created Employee assumed that all employee's have salaries.
   This is not the case, but we often have situations in Java where the person creating a type does not think of every situation and makes incorrect assumptions on how it is used.
   Because the earnsMoreThan method is following proper O-O coding (using the getter methods instead of the fields),
    it is easy for other classes to adjust so that their classes properly work.

   We will have every employee type define for itself what "salary" means.
	For example, an hourly employee can decide that a salary is hours worked * rate per hour.
	A sales employee can decide salary is number of sales * commission, and so forth.

   HourlyEmployee will "define" how salary works by overriding the salary method:
	public double getSalary() {
	  return this.getHoursWorked() * this.getHourlyRate();
	}

   Because the true type version of an instance method is always used, the hourly employee will always report its salary as the product of its hourly rate and hours worked.
     - it does not matter if we typecast the hourly employee
     - it does not matter if we try to set the salary of the hourly employee
   It just works!

     BAD IDEA:  Use the fields directly:

        public boolean earnsMoreThan(Employee e) {
          return salary > e.salary;    <--- DON'T DO THIS.  IT USES THE FIELDS DIRECTLY!!!  USE THE GET METHODS INSTEAD.
        }

   If we did this, it would take more work to get hourly employee to work with the method.
	Since fields are not inherited and cannot be overridden, we are going to have to make sure hourly employee calls the inherited setSalary method everytime that its hourlyrate is changed or its number of hours worked is changed.
	Not only is that going to mean changes in at least two different places, it means that if Employee changes how earnsMoreThan is computed, we will have to change HourlyEmployee!

   The moral: everytime you choose to not follow the O-O guidelines, you make it more challenging for other coders to extend and use your class.
	So if you want to violate the O-O guidelines, you should think carefully to make sure you have a good reason to do so.




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



  Attempt 1:  A year is a leap year if is is divisible by 4 but not divisible by 100 unless it is divisible by 400

	public boolean leapYear(int year) {
	  if (year % 4 == 0) {
	    if (year % 100 == 0) {
		      if (year % 400 == 0)
		        return true;
		      else
		        return false;
	            }
		else
		  return true;
	  }
	  else
	    return false;
	}

  Attempt 2:  The same but now we can keep track of the cases that are "removed" to make it easier to see the logic
       
	public boolean leapYear(int year) {
	  if (year % 4 != 0)           // take care of the case where we know the value right away : when year is not divisible by 4
            return false;
          else {                       // from here on we know that year IS divisible by 4
	    if (year % 100 != 0)       // this also removes a case where we know the answer
	      return true;
            else {		       // from here on, year IS divisible by 4 AND is divisible by 100
	      if (year % 400 != 0)
	        return false;
	      else
	        return true;
            }
	  }
	}

  Attempt 3: Notice above that the "else" statement is a single conditional statement, even if it takes more than one line
    In this case, we can not only remove the { }, but we can move the "if" up to be on the same line as the "else".
    That formatting looks a little better and is similar to languages that have the "elseif" feature.
    Java does not have an "elseif", but with our formatting, we get something just as nice:

	public boolean leapYear(int year) {
	  if (year % 4 != 0) 
            return false;
          else if (year % 100 != 0) 
	    return true;
          else if (year % 400 != 0)
	    return false;
	  else
	    return true;
	}

  Attempt 4: The same, but without an if statement.  Sometimes the if statement is not even needed!

	public boolean leapYear(int year) {
	  return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
	}

