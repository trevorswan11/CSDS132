Linked Lists, Generic Types, Wrapper Classes

Linked Lists:

  Arrays: A collection of variables of the same type stored in contiguous memory.
    Benefits:  Very fast access to any arbitrary element.
    Downside:  Can not change size after created and can't insert or delete without needing to shift values.  
                To change the size, we must create a new array and copy all the data over.

  Linked Lists: A data structure that stores values of the same type
    Benefits:  Can easily incraease or decrease size as needed.  Can easily insert or delete at any location.
    Downside:  Fast access to only a few elements.


A linked list is formed of "nodes".  Each node contains an element and a pointer to the next node of the list.
The first node of the list is called the "head" of the list.

          +---+---+    +---+---+    +---+---+
  head -> | 1 | *-+--> | 2 | *-+--> | 3 | *-+--x
          +---+---+    +---+---+    +---+---+

  NOTE:  LinkedList is a class of the Java API.  However, we are going to implement our own class so you can understand how linked lists work.
         The LinkedList class of the API is identical to our class except that each box also has an array pointing to the box that comes before it.
         Such a linked list is sometimes called a "double linked list".

What type should the element be?  Whatever type we want to store in the list.  This seems to imply that we will need to
create a different linked list class for each possible type we want to store, but starting in Java 5, we can specify a 
"generic type".  A generic type is a place holder (usually a single capital letter) that indicates that the type will
be specified later.

	public class LLNode<T> {

indicates that there is a generic type associated with LLNode.  When we create an instance of the LLNode, we will specify
what the type T is.

  (A class can have as many generic types as you wish associated with it.  For example, if had a class called Box with two
    generic types, we would declare the class as:    public class Box<K,T> {   where K and T are the two letters used as 
    placeholders for the two generic types.)

Inside LLNode, we can use T just like any other type: 

	public class LLNode<T> {
	  private T element;
	  private LLNode<T> next;

	  public LLNode(T element, LLNode<T> next) {
	    this.element = element;
	    this.next = next;
	  }

	  public T getElement() {
	    return element;
	  }

	  public LLNode<T> getNext() {
	    return next;
	  }

	  public void setNext(LLNode<T> next) {
	    this.next = next;
	  }
	}

The use of $LLNode<T>$ in the setNext and the constructor and the next field forces Java to require that the LLNode that next points to
must hold the same type as this node holds.  That way we can force every node of the list to hold the same type.  This was impossible before
generics.  Instead, we would need to either specify a separate list class for each type or we would have to store Object and then use lots
of instanceof expressions and typecasts to enforce that only one type of Object is stored.

When we create an instance of LLNode, we will specify what the type will be.  For example, we can store JFrame:
```
LLNode<JFrame> node = new LLNode<JFrame>(new JFrame(), null);
or we can store String:
LLNode<String> node2 = new LLNode<String>("Hi", null);
```

  The generic type is used by the compiler so it only affects the current type.  The compiler makes sure that the types that you specify match.
```
     new LLNode<String>("Hi", null);   <- legal!  "Hi" is type String and that matches the specified generic.

     new LLNode<String>(new JFrame(), null);  <- ILLEGAL!  JFrame() is not a String.  The generic was specified to be String, and so the element's type must match.
```

  The generic type must be a non-primtive value.  What if we want to store primitives in the linked list?

Wrapper Classes:
  For each primitive type (including void), Java provides a wrapper class that allows you to store the primitive inside an object.  This allows us to use 
primitives where the code is expecting Objects.  For the most part, the wrapper class is the same name as the primitive, but with a capital letter:
     Double d = new Double(4.3);
except for Integer and Character.

  Starting with Java 5, Java will automatically convert between the wrapper class and the primitive, when needed and when it is clear what type is needed.
So, the following are legal:
	Integer x = 5;
	int y = x;

Warning: despite how it is written, things are not exactly as they seem.  
  The line "Integer x = 5" creates a new object of type Integer and stores the value 5 in it.  The line is really: "Integer p = new Integer(5)"
  The next line "int y = x;" looks like it is doing an automatic typecast of x to y, but it is not. It is instead the line is a shortcut for:  "y = x.intValue();".

        
Using wrapper classes and the automatic "boxing" and "unboxing" between the primitive and the wrapper class, we can store Integers:
```
	LLNode<Integer> node = new LLNode<Integer>(5, null);
```
This "boxes" the int value 5 into an Integer object storing 5 and uses the Integer object in the LLNode.
