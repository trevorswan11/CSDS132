package llpractice;

import java.util.NoSuchElementException;

/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> implements Iterable<T> {
    /** the first node of the list, or null if the list is empty */
    private LLNode<T> firstNode;

    /**
     * Creates an initially empty linked list
     */
    public LinkedList() {
        firstNode = null;
    }

    /**
     * Returns the first node.
     */
    protected LLNode<T> getFirstNode() {
        return firstNode;
    }

    /**
     * Changes the front node.
     * 
     * @param node the node that will be the first node of the new linked list
     */
    protected void setFirstNode(LLNode<T> node) {
        this.firstNode = node;
    }

    /**
     * Return whether the list is empty
     * 
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return (getFirstNode() == null);
    }

    /**
     * Add an element to the front of the linked list
     */
    public void addToFront(T element) {
        setFirstNode(new LLNode<T>(element, getFirstNode()));
    }

    /**
     * Removes and returns the element at the front of the linked list
     * 
     * @return the element removed from the front of the linked list
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (isEmpty())
            throw new NoSuchElementException();
        else {
            T save = getFirstNode().getElement();
            setFirstNode(getFirstNode().getNext());
            return save;
        }
    }

    /**
     * Returns the length of the linked list
     * 
     * @return the number of nodes in the list
     */
    public int length() {
        int lengthSoFar = 0;
        LLNode<T> nodeptr = getFirstNode();
        while (nodeptr != null) {
            lengthSoFar++;
            nodeptr = nodeptr.getNext();
        }
        return lengthSoFar;
    }

    /**
     * Add an element to the end of a list.
     * 
     * @param element the element to add
     */
    public void addToEnd(T element) {
        if (isEmpty())
            addToFront(element);
        else {
            LLNode<T> nodeptr = getFirstNode();
            while (nodeptr.getNext() != null)
                nodeptr = nodeptr.getNext();
            nodeptr.setNext(new LLNode<T>(element, null));
        }
    }

    /**
     * Returns an iterator for the list
     * 
     * @return an iterator starting at the first element of the list
     */
    public LinkedListIterator<T> iterator() {
        return new LinkedListIterator<T>(getFirstNode());
    }

    /**
     * Print the contents of a list.
     * An example of declaring a generic for a method.
     * 
     * @param list the list to print
     */
    public static <T> void printList(LinkedList<T> list) {
        LLNode<T> nodeptr = list.getFirstNode();
        while (nodeptr != null) {
            System.out.println(nodeptr.getElement());
            nodeptr = nodeptr.getNext();
        }
    }

    /**
     * Prints the contents of a linked list.
     * An example of using the ? generic type wildcard
     * 
     * @param list the list to print
     */
    public static void printList2(LinkedList<?> list) {
        LLNode<?> nodeptr = list.getFirstNode();
        while (nodeptr != null) {
            System.out.println(nodeptr.getElement());
            nodeptr = nodeptr.getNext();
        }
    }

    /**
     * Add each element into sorted order.
     * Prerequisite: the list is already is sorted order.
     * Postcondition: the element is added and the list is in sorted order
     * 
     * @param element to add to the list
     * @param list    the list to add the element
     */
    public static <T extends Comparable<? super T>> void addInOrder(T element, LinkedList<T> list) {
        if (list.isEmpty() || list.getFirstNode().getElement().compareTo(element) > 0) {
            list.addToFront(element);
        } else {
            LLNode<T> nodeptr = list.getFirstNode();
            while (nodeptr.getNext() != null &&
                    nodeptr.getNext().getElement().compareTo(element) < 0)
                nodeptr = nodeptr.getNext();

            nodeptr.setNext(new LLNode<T>(element, nodeptr.getNext()));
        }
    }

    /*-------------------------------------------*/
    /* THE NEXT METHODS WILL BE COMPLETED IN LAB */
    /*-------------------------------------------*/

    /**
     * Returns a String representation of the list
     * 
     * @return a String representing the list
     */
    public String toString() {
        return null;
    }

    /**
     * Determines whether an element is stored in the list
     * 
     * @param element the element to search for in the list
     * @return true if and only if the parameter element is in the list
     */
    public boolean contains(T element) {
        return false;
    }

    /**
     * Deletes the first occurrence of an element in the list.
     * If the element is not in the list, the list is unchanged.
     * 
     * @param element the element to remove
     */
    public void remove(T element) {
    }

}
