# Programming in Java: Lab 10  
Working With Linked Lists and JUnit

In this lab, you will write methods out linked list class and testing your code with JUnit

## Task 1. Assigning Lab Partners

If you wish to have a lab partner (and you are strongly encouraged to do so), see your lab instructor. You may keep your lab partner from last week, but you do not need to.

### Reminder About The Rules For The Lab

### If You Do Not Have a Lab Partner

You are to do the tasks listed below and submit your lab prior to the deadline posted.

### If You Have a Lab Partner

You do not have to complete all the tasks, but you do have to work hard and be a good partner. That means the navigator must make good suggestions and must not edit the document for the driver.

---

### _If you are new to programming,_ your goal is to complete Task 5 during the lab session and hopefully at least start on Task 6. If you are having trouble with Task 4 or 5, be sure to ask the lab assistant for help.

---

## Task 2. Introductions and Starting DrJava

If you have a lab partner, tell your lab partner your name and the city or town where you grew up.

Choose one of you to start as the driver, and launch DrJava.

---

## Task 3. Loading the Linked List and Using JUnit

You will use the LLNode and LinkedList classes we developed in class. In addition, you will have a JUnit test class, LinkedListTester. Download these classes from the Canvas site to your machine.

---

## Task 4. Writing and Testing Your Code for LLNode

Now add the following two methods to the LLNode class. As a hint, it is possible to write them with very little code.

1. public void insertAfter(T element)  
    Create a new node of the linked list that contains element element such that element is inserted immediately after this node in the linked list. For example,
    
```
    LLNode<Integer> listNode = new LLNode<Integer>(1, new LLNode<Integer>(3, null));
    listNode.insert(2)
```
    
should produce a list where listNode.getElement() returns 1, listNode.getNext().getElement() returns 2, and listNode.getNext().getNext().getElement() returns 3.
    
2. public void deleteNext()  
    Removes the node immediately after this node from the linked list. If there is no node immediately after this element, nothing is removed. For example,
    
```
    LLNode<Integer> listNode = new LLNode<Integer>(1, new LLNode<Integer>(2, new LLNode<Integer>(3, null)));
    listNode.deleteNext()
```
    
should produce a list where listNode.getElement() returns 1, and listNode.getNext().getElement() returns 3. However,
    
```
    LLNode<Integer> list = new LLNode<Integer>(1, null)
    listNode.deleteNext()
```
    
should make no change to listNode.
    

After you complete each method, press the _Test_ button on DrJava. Do not continue unless the tests testInsert and testDeleteNext appear green (i.e. they pass the test). If one or more fails, find out which test fails and fix the problem in your code. (_Hint: you can still use the interactions pane to test your code._)

---

## Task 5: Traversing the Linked List and Writing JUnit Tests

**Switch roles: the navigator should now drive and the driver should navigate.**

You will next add a method to the LinkedList class as well as write a JUnit test method in LinkedListTester.

Add the next method to the LinkedList class:  
public boolean contains(T element)  
Returns true if the element is in the linked list and false if it is not. For example,

LinkedList list = new LinkedList():
list.addToFront(3);
list.addToFront(2);
list.addToFront(1);
list.contains(3)

should return true and

list.contains(0)

should return false.

There are two ways you can do this. Either you can have a single method in the LinkedList class that contains a loop. Or you can create a method called contains in both the LinkedList and LLNode class where the method in LLNode uses structural recursion and the method in LinkedList calls the contains method of the head.

**Note:** When you try to test this method, the JUnit tester will always fail. This is because the JUnit test for this method is set to always fail. You need modify this test to be an appropriate test. You can look at the other JUnit tests to get an idea about the code needed. For your test cases, remember to have tests for the following:

1. Test 0, test 1, test many: Test the method on an empty list, a list with one node, and a list with more than one node.
2. Test front, test middle, test end: Have the method search for an element at the front of the linked list, at the end, in the middle, and one that is not in the list.

When you have completed the method and its test case, demonstrate your code to your lab instructor.

---

## Task 6: Two More Methods

### Another method that traverses the linked list.

**Switch roles: the navigator should now drive and the driver should navigate.**

Add the following method to the LinkedList class. You should implement the method by creating a StringBuilder and use a loop to run through the linked list:  
public String toString()  
Returns a string representation of the linked list. The string should begin with "list:" and then have each element preceded by a space. For example,

LinkedList list = new LinkedList():
list.addToFront(3);
list.addToFront(2);
list.addToFront(1);
list.toString()

should return "list: 1 2 3".

Test the method with JUnit.

### A small challenge

**Switch roles: the navigator should now drive and the driver should navigate.**

Here is a useful but slightly more challenging method.

Add the following method to the LinkedList class.  
public void remove(T element)  
Removes the first node of the list that contains element. If the element is not in the list, the list should remain unchanged. The method should traverse the linked list to the appropriate place and then call the deleteNext method of LLNode that you previously wrote.

Once you have completed these methods, and they all pass the JUnit test, demonstrate your code to your lab instructor.

## Task Last. Finishing Up

Once completed, submit your LinkedList.java, LLNode.java, and LinkedListTester.java files. _Remember that both you and your lab partner should submit this file._