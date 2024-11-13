Manipulating Linked Lists

Now, let us create the linked list:
          +-----+---+ 
  list -> | 1.0 | *-+--x
          +-----+---+   
  
  LLNode<Double> list = new LLNode<Double>(1.0, null);

Suppose we have the following list:

          +-----+---+    +-----+---+    +-----+---+
  list -> | 1.0 | *-+--> | 2.0 | *-+--> | 3.0 | *-+--x
          +-----+---+    +-----+---+    +-----+---+

Suppose we want to add 0.0 to the front of this list:

  list = LLNode<Double>(0.0, list);

That will create:

          +-----+---+    +-----+---+    +-----+---+    +-----+---+
  list -> | 0.0 | *-+--> | 1.0 | *-+--> | 2.0 | *-+--> | 3.0 | *-+--x
          +-----+---+    +-----+---+    +-----+---+    +-----+---+

Now suppose we want to add 1.5 between 1.0 and 2.0.
  We must be careful to do things in the right order, or we will break the list.
  1) Create a new node for 1.5.
  2) Move the next pointer for the 1.5 node to point to the 2.0 node.
  3) Move the next pointer for the 1.0 node to point to the 1.5 node.

  If we did step 3 before step 2, we would lose all access to the 2.0 node.

    What is the name of the next pointer of 1.0?  list's next's next
      To do step 2, we need to change the new box's next pointer to point to list's next's next, i.e. what the 1.0 box is pointing at.
      To do step 3, we need to change list's next's next pointer to point to the new box.
    We can do this in one line of carefully organized code!

	Step 1) LLNode<Integer> newNode = new LLNode<Integer>(1.5, null);
	Step 2) newNode.setNext(list.getNext().getNext());
	Step 3) list.getNext().setNext(newNode);

    Or in one line:
	list.getNext().setNext(new LLNode<Integer>(1.5, list.getNext().getNext());



Abstract Data Types
  An abstract data type is a data structure that guarantees certain behaviors to the user, but it keeps its implementation details hidden.
  By hiding the implementation details, we are able to change them if we discover a better way to do things without breaking the code that uses the
    data structure.  We also can prevent code that uses the data structure from accidentally breaking the data structure.

  Examples:
     Strings are an ADT.  You are guaranteed certain behavior such as accessing a character from a location and appending strings, but you are not told how 
they are implemented (though they are probably implemented as an array of chars).
     JFrames are an ADT.  You are guaranteed certain behavior such as changing its size, displaying it on the screen, but you do not know exactly how the
Java Swing developers chose to implement the window.

  We will create the LinkedList as an abstract data type.  The list is going to be a list of LLNodes, but we will keep the details away from the users
of the LinkedList so that code that uses the LinkedList can not accidentally break the list.

Creating a LinkedList class
  A LinkedList will store a list of LLNodes.  The only field we need is to store the node that is the first node of the list.  We call this the "first" or "head" of the linked list.
  There are several ways we can implement the linked list.  We decided that if a list is empty, its front should be a null pointer, to indicate that there are
no nodes in the list.  Another option would be to create a special node that acts as a "caboose" to the linked list.  No implementation technique is wrong
as long as the list works properly.  If we correctly create the LinkedList as an abstract data type, we should be able to switch between implementations and
code that uses the LinkedList class will still operate exactly the same.

  Note that the LinkedList will need to use a generic to specify the type that will be stored in the list, and we want each LLNode in the list to use the same generic.

	public class LinkedList<T> {
	  private LLNode<T> firstNode;

	  public LinkedList() {
	    firstNode = null;
	  }

  Now, let use crete a method to add an element to the front of the list.

	  public void addToFront(T element) {
            firstNode = new LLNode<T>(element, firstNode);
	  }

  If we want to allow polymorphism and extending for this class, we should use getter/setter methods for firstNode, but we don't want to make them public because that would let 
   any code using the LinkedList (rather than any code that "is" a LinkedList) to need to understand how the head of the linked list works.  In particular, the getter/setter methods
   return an LLNode.  Having code outside the LinkedList know about LLNodes would violate the "keep implementation details hidden" nature of an abstract data type.
 
  The solution is to make the getter/setter methods "protected".  Recall that protected means it can be used in this class or any class that extends this class.  (Why would private not work? Hint: getter/setter's are used so to making extending the class easier.)

	  public void addToFront(T element) {
            setFirstNode(new LLNode<T>(element, getFirstNode());
	  }

  How about testing if a list is empty? 

	public boolean isEmpty() {
 	  return getFirstNode() == null;
	}

  How about removing an element at the the front? 

	public T removeFromFront() {

    We need to move the front from the current node to the next node.
    But before we do that, we should save the value stored in the front so we can return it at the end.

	public T removeFromFront() {
	  T save = getFirstNode().getElement();
	  setFirstNode(getFirstNode().getNext();
	  return save;
	}

    But, what if the list is empty, then the front will be null, and we will get a NullPointerException!
      It is not a good idea to throw a NullPointerException because that will not mean anything to the programmers who are using our code.
      The null value is an issue with our implementation, and we don't want programmers using our linked list to need to worry about our implementation.
      The problem, from the programmers point of view, is that the list is empty, not that our implementation has a null value.
      We will still throw an exception, but now we will throw a more meaningfully named exception: NoSuchElementException

     The NoSuchElementException is in the java.util class, and it is an unchecked exception so we do not have to indicate that the method may throw it in the method header

	public T removeFromFront() throws NoSuchElementException {    // the "throws NoSuchElementException" is optional because it is an "unchecked exception"
	  if (isEmpty())
	    throw new NoSuchElementException();
	  else {
	    T save = getFirstNode().getElement();
	    setFirstNode(getFirstNode().getNext());
	    return save;
	  }
	}

	public boolean isEmpty() {
	  return getFirstNode() == null;
	}

