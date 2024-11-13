Nested Classes and Generic Types

  When we look at the API for LinkedList, we see no mention of an LLNode class, but there -must- be one to be a linked list!  Why don't we see one?  They must have the LLNode as 
   a private nested class.  In class, we did the same thing in 
	List1:  a linked list with a private static nested class for the nodes
	List2:  a linked list with a private non-static nested class for the nodes.


  Generics and Static Nested Classes:

Because the nested class is static the nested class -does not- have access to the generic type of the containing class.  (The generic type only applies to instances of the class.)
      Thus, we need to define a generic for the nested class.  Specifically, our nested class Node needs its own generic type declaration.
     As a result, we specify the generic on our Node class as:
	`Node<T> node`
     or for it's "full name"
	`List1.Node<T> node`

 To create a member of the nested class Node from outside the List1 class, we can use exactly the same Java terminology we use to create other objects and to
     access static fields and methods:

`List1.Node<String> node = new List1.Node<String>("Hi", null);`

Note that the generic goes on the Node class.  We do not need to specify the generic for List1 because we are not creating an instance of List1.
     (It is not an error to specify the generic for List1, but Java will ignore that generic since no instance is being created.)


  Generics and Non-static Nested Classes

With a non-static nested class, the nested class -does- have access to the generic of the containing class.  Thus the nested class Node of List2 does not need its own generic.
    Note that in List2, the Nodes no longer have generic specifications and our code is a little cleaner.

In List2, we kept the `insertInOrder` as a static method to demonstrate how we have to specify the generic on Node and how to create a Node instance.
	When we create the nodeptr, its type is List2.Node nodeptr, but we need to specify the generic on Node.
	We can't say `List2.Node<S>` because Node does not take a generic.  The generic goes with the containing class List2.  So, we give Node's full name List2.Node, and we place the generic
         on List2 (the generic is declared in List2's header, not Node's).

	List2<S>.Node nodeptr

   In general, non-static nested classes can be more useful because they have access to all the non-static fields and method of the containing class, but they can be a little trickier to use.



Restricting Generic Types and Wildcards:

  Suppose we have the following method:

	public static void displayFrames(LinkedList<JFrame> frameList) {
 	  for (JFrame frame : frameList)
	    frame.setVisible(true);
	}

  This will only work on LinkedLists that have the generic type set to JFrame.
  What if we want to restrict the generic?
```
LinkedList<GeometricFrame> list2 = new LinkedList<GeometricFrame>();	list2.addToFront(new GeometricFrame());
list2.addToFront(new GeometricFrame());
```

However, if we call displayFrames(list2) we get a compile error because you can't convert `LinkedList<GeometricFrame>` to `LinkedList<JFrame>.`
  
  Our solution is to restrict the generic type of LinkedList to be anything that is JFrame or narrower.

1. E extends JFrame	: When you declare generic type E, you restrict E to be JFrame or narrower
2. ? extends JFrame	: When you use the "don't care" wildcard, you say the generic type must be JFrame or narrower
3. ? super JFrame		: When you use the "don't care" wildcard, you say the generic type must be JFrame or wider

     You can also extend generics:
	E extends T
	? extends T
	? super T

  Here are the two ways to write displayFrames.  First, declaring a generic restricted to JFrame or narrower:

```
public static <E extends JFrame> void displayFrames(LinkedList<E> frameList) {
 	  for (JFrame frame : frameList)
	    frame.setVisible(true);
	}
```

  Or using the "Don't care" wild card:

```
public static void displayFrames(LinkedList<? extends JFrame> frameList) {
 	  for (JFrame frame : frameList)
	    frame.setVisible(true);
	}
```

  In both cases we declare frame to be type JFrame.  We know whatever is stored in frameList is JFrame or narrower.


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
	`public class Employee implements Comparable<Employee> {`
  Note that we specified the generic of Employee to state that we must compare Employee's to other Employee's.
  (The easy way to see what the generic should be is to look at the API and see where it is used.  The API for `Comparable<T>` shows the method is - int compareTo(T e) - 
   so we see that the generic needs to be the type that we want to input to the compareTo method.)

  Now, we override the compareTo method.  Let's make the default comparison of employee to be by the employee's name.
   Remember that we want the method to return negative if this object comes before the object in variable employee.  
	
	public int compareTo(Employee employee) {
	  return this.getName().compareTo(employee.getName()); 
	}

Using Comparable objects.
  Where we would like to write "if (e1 < e2)" we instead write
	if (e1.compareTo(e2) < 0)
  Note that the < operator is the same, we just moved its location.  This is the reason the return value for the compareTo is specified the way it is. 


Using Comparable and Restricting the Generic Type:
  The class example was to create a method in LinkedList that inserts elements in order into a linked list.  To be able to order the elements, we need to be able
    to restrict the type stored to something that can be ordered.  That is, something that is Comparable.
  We are going to make the method static.  Remember that a static method does not inherit the generic of the containing class so we have to declare it.
    We made the method static so that we could give the method its own generic and restrict that generic to be Comparable.
    If we want to keep the method non-static, we have to use the unrestricted generic T of the LinkedList class, and we would need to use typecasts and instanceof to
     check that the instance is a Comparable type and do the typecast so we can change the current type can call the compareTo method.

  How do we insert in order?  There are three cases: the element being added goes first, goes middle or goes last.  It turns out that we can combine middle and last.
    For going first, either the element is smaller than the first thing in the list or the list is empty.
    Otherwise, we have to loop through the list to find where to put the element.  We do the normal linked list loop, but we have to be careful to stop at the right spot.

   FIRST TRY:

	public void insertInOrder(T element) {
	   ...
	}

We already have a problem.  We want to call the compareTo method on elements but that will require the type of element to be Comparable.
      Right now, T can be any type.  We don't want to restrict the T on LinkedList because we want the LinkedList to still be able to store all possible types.

- Solution 1:  Use instanceof and typecasts everywhere.  If we are going to do that, we lose the power of the generic typecasting.
- Solution 2:  Create a class that extends LinkedList and in the extending class we restrict the generic to be Comparable.
- Solution 3:  Make the insertInOrder method static so it no longer has the generic T.  Now, we declare a new generic for the method and restrict that generic to be Comparable.

We decided to do solution 3.  We will call the new generic S to distinguish it from T (but we could use T if we wanted to because T does not exist in static methods).

```
public static <S> void insertInOrder(S element, LinkedList<S> list) {
	  if (list.isEmpty() || element.compareTo(list.getFirstNode().getElement()) <= 0)
	    list.addToFront(element);
	  else {
	   // to be added later
	  }
	}
```

   If we compile this, we get an error because S may not contain the compareTo method.  We remembered to create a new generic for the method but we forgot to restrict it!
   We need to restrict S to be only things that implement the Comparable interface.
   We don't use the word "implements" because S is a type and not a class.  The only time we use "implements" is when a class implements an interface.  All other situations use "extends".

   SECOND TRY: (The only change is in the generic declaration)
	
```
public static <S extends Comparable<S>> void insertInOrder(S element, LinkedList<S> list) {
	  if (list.isEmpty() || element.compareTo(list.getFirstNode().getElement()) <= 0)
	    list.addToFront(element);
	  else {
	   // to be added later
	  }
	}
```


   This compiles and works great on a linked list of Employee, but it does not compile if we try to use it on a linked list of HourlyEmployee:
```
	LinkedList<HourlyEmployee> list = new LinkedList<HourlyEmployee>()
	list.insertInOrder(new HourlyEmployee("Harold"))    <= compile error!
```

   To see why we have the error, look at the class types involved.
```
	public class Employee implements Comparable<Employee> 
	public class HourlyEmployee extends Employee
```
   - Remember that HourlyEmployee "is-a" Employee, and Employee is both an Object and a `Comparable<Employee>`.
      So HourlyEmployee is both an Object and a `Comparable<Employee>`

   There is the problem!  insertInOrder states that the generic type is limited to `<S extends Comparable<S>>`  (note that the S used in Comparable must be exactly the same as the type of the generic)
	and thus it works on a linked list storing "Employee implements `Comparable<Employee>`" but not on "HourlyEmployee implements `Comparable<Employee>`".

   The solution is to change the restriction on Comparable to allow the Comparable's generic to be above the generic type used in the method.

   FINAL SOLUTION: (The only change is again in the generic declaration)

```
public static <S extends Comparable<? super S>> void insertInOrder(S element, LinkedList<S> list) {
	  if (list.isEmpty() || element.compareTo(list.getFirstNode().getElement()) <= 0)
	    list.addToFront(element);
	  else {
	   // to be added later
	  }
	}
```

   Now, we are stating that we do not care what type S is, but it must be Comparable - either because it implements Comparable directly or it inherits the Comparable from a parent class.
    Either way, we don't care how it became Comparable, but we know it has a compareTo method.