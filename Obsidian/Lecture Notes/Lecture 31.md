The Comparable Interface
  - one of the two most used interfaces in Java (along with Iterable)
  - indicates that instances of the type can be ordered

  The Comparable interface takes a generic type that indicates the type this object will be compared to.
  The Comparable interface requires a compareTo method that takes a parameter of the generic type.
    It should return < 0 if this object comes before the parameter in the default ordering of the type.
    It should return > 0 if this object comes after the parameter in the default ordering of the type.
    It should return = 0 if the two objects are equivalent in the default ordering of the type.

We made the Employee class Comparable.
  We decided that the default ordering would be to order employee's by their employee number
  So, we made Employee implement Comparable:
```
public class Employee implements Comparable<Employee> {
```
  Note that we specified the generic of Employee to state that we must compare Employee's to other Employee's.
  (The easy way to see what the generic should be is to look at the API and see where it is used.  The API for `Comparable<T>` shows the method is - int compareTo(T e) - 
   so we see that the generic needs to be the type that we want to input to the compareTo method.)

  Now, we override the compareTo method.  Let's make the default comparison of employee to be by the employee's number.
   Remember that we want the method to return negative if this object comes before the object in variable employee.  
	
	public int compareTo(Employee employee) {
	  return this.getNumber() - employee.getNumber(); 
	}

Using Comparable objects.
  Where we would like to write "if (e1 < e2)" we instead write
	if (e1.compareTo(e2) < 0)
  Note that the < operator is the same, we just moved its location.  This is the reason the return value for the compareTo is specified the way it is. 


Nested Types
  We can create types inside other types.  Here are the kinds of nested types:

static nested types
	- classes, abstract classes, or interfaces created inside another type
	- they are exactly the same as the classes, abstract classes, and interfaces we have already created
		- except they are located inside another type's body instead of in their own file
		- they have access to the static private fields and methods of the type they are inside
		- they can be public, private, protected, or package

non-static nested types
	- classes, abstract classes, or interfaces that "belong to" an instance of another type
	- they have access to the non-static methods and fields of the instance they "belong to"

local types
	- a type the is declared inside of a method giving it access to the local variables of the method as well as
		anything of the class that the method has access to

anonymous classes
	- a kind of local class that where the class is created on the same line of code that the instance is created
	- the class has no name

```
new TypeToExtendOrImplement() {
	body of class
}
```


Static Nested Types

  We used the static nested class to create a comparator that ordered employees by salary.
```
private class CompareBySalary extends Object implements Comparator<Employee> {
  public int compare(Employee e1, Employee e2) {
	** code **
  }
}
```

  How would you access the nested class?  Because it is static, you access it exactly as you do a static field.
    If the class were public, you could write:
	Employee.CompareBySalary c = new Employee.CompareBySalary();

Using the Comparator and Comparable

  We created a method to return an instance of the CompareBySalary class
	public static CompareBySalary compareBySalary() {
	  return new CompareBySalary();
	}

  Suppose we have a array storing Employees:  Employee[] workers.  We can sort the array by name:  
	 Arrays.sort(workers)
  or we can sort the array by salary: 
	 Arrays.sort(workers, Employee.compareBySalary())
  Arrays is a class that has a lot of useful methods for arrays.



Non-static Nested Classes

  In this lesson we are going to create a Comparator for Employee as a non-static nested class.
  The comparator will order Employees based on how close their salary is to one Employee (namely "this" Employee).

  Creating a non-static nested class is the same as any nested class except that we do not use "static".

  However, there are a couple of rules you need to be aware of:
1) The non-static nested class has access to the "this" of the containing class.
   This is the instance of the containing class that "owns" this non-static nested class.

2) Inside an instance method of the non-static nested class, there are two "this" values, the "this" that is the
	instance of the non-static nested class that the method is running on, and the "this" that is the instance
	of the containing class that the non-static class is "inside".

	When you use "this", you are referring to the instance of the nested class.
	If you want to be specific about which instance you want, you have to put the type before the this.

For example, we created
```
   private class CompareSalaryToThisEmployee implements Comparator<Employee> {
	inside the Employee class, so

	this                                 -> the instance of CompareSalaryToThisEmployee
	Employee.this                        -> thie instance of Employee
	CompareSalaryToThisEmployee.this     -> the instance of CompareSalaryToThisEmployee
```

3) When creating an instance of the non-static nested class, you must first create the instance that this nested class instance will "belong to".
   The syntax for the creation takes a little to get used to:

	 Employee e = new Employee("Harold", 10000)     
	 Employee.CompareSalaryToThisEmployee c = e.new CompareSalaryToThisEmployee()     

   Notice the unusual "new" operator!



Anonymous Classes

   You can create classes directly inside the body of a method.
   There are two ways to do this, and we are going to focus on the anonymous class because that is used more often.
   The textbook shows the other way of creating a "local class".

   An anonymous class has no name.  Instead, you just state what interface or class you are extending (implementing).
   For example, suppose we want to create a class that implements the `Comparator<Employee>` instance.

```
Comparator<Employee> c = new Comparator<Employee>() {
```

   The curly brace { indicates that we are creating an anonymous class that implements `Comparator<Employee>`.
   Inside the { }, you place all fields and methods you want for the class.

   What we need to do is override the abstract compare method.

```
	Comparator<Employee> c = new Comparator<Employee>() {
	  public int compare(Employee e1, Employee e2) {
	    return e1.getName().compareTo(e2.getName());
	  }
	};
```

   Now, in that line of code we both created a class that implements `Comparator<Employee>`, created an instance of
that class, and assigned the address to the instance to the variable c.

   Anonymous classes are really useful when you need to create "small" classes that have a single use.
     This way you do not have to create additional files or come up with new type names.

