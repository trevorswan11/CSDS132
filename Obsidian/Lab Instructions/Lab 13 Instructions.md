# Programming in Java: Lab 13  
Double Linked Lists

In this lab, you will continue the work with double linked lists that you started with the pre-lab exercise.

## Task 1. Assigning Lab Partners

If you wish to have a lab partner (and you are strongly encouraged to do so), see your lab instructor. You may keep your lab partner from last week, but you do not need to.

### Reminder About The Rules For The Lab

### If You Do Not Have a Lab Partner

You are to do the tasks listed below and submit your lab prior to the deadline posted.

### If You Have a Lab Partner

You do not have to complete all the tasks, but you do have to work hard and be a good partner. That means the navigator must make good suggestions and not try to edit the document.

**_Your goal is to make it through Task 5 during the recitation section._**

---

## Task 2. Introductions and Starting DrJava

Tell your lab partner your name, and with fall registration now open, your favorite class at CWRU (no extra credit for saying CSDS 132).

Choose one of you to start as the driver, and launch DrJava.

---

## Task 3. Loading the Double Linked List and Using JUnit

Download the DLNode.java, DoubleLinkedList.java and DoubleLinkedListTester.java classes from the Canvas site to your machine.

Take a look at the constructor for DLNode. You should have done something similar in the pre-lab. If the constructor is different that what you did, discuss with your lab partner how this constructor behaves because it will affect how you do the lab exercises below.

---

## Task 4. Writing and Testing Code to Add Elements to a DoubleLinkedList

Add the following two methods to DoubleLinkedList.java. Use the DoubleLinkedListTester JUnit testing class to test your methods. If the test fails, be sure to look at the line of the tester that fails and try to figure out why you are getting the error.

Note that the DoubleLinkedList class is similar to the LinkedList you wrote in the last lab and we used in class except that it has both a _head/front_ and a _tail/back_. The tail will point to the last node of the linked list. The trick to writing the methods below is to make certain both the head and the tail are set correctly.

- addToFront(T element): adds the element into a new DLNode that is placed at the head of the double linked list.
- addToBack(T element): adds the element into a new DLNode that is placed at the tail of the double linked list.

_Demostrate your code to your lab instructors._

---

## Task 5. Writing and Testing Code to Remove Elements from a DoubleLinkedList

**Switch roles: the navigator should now drive and the driver should navigate.**

Add the following two methods to DoubleLinkedList.java and use the DoubleLinkedListTester JUnit testing class to test your methods.

- removeFromFront(): removes and returns the element at the front of the double linked list.
- removeFromBack(): removes and returns the element at the back of the double linked list.

_Demostrate your code to your lab instructors._

---

## Task 6: Writing a Complete Iterator for the DoubleLinkedList

### Task 6, Part 1: Writing the hasNext and next methods.

**Switch roles: the navigator should now drive and the driver should navigate.**

Create a class that will implement the Iterator interface and return an instance of that class for the DoubleLinkedList iterator method. For the first part, you need to create the Iterator's hasNext and next methods. Also, make sure that the iterator has access to the linked list (and not just the nodes of the linked list) because you will need that for the next part.

### Task 6, Part 2: Writing the remove method.

**Switch roles: the navigator should now drive and the driver should navigate.**

Now write the remove method for the double linked list. The remove method should remove the node of the element that had just been returned by the next method. As a hint, you can tell what this method is just by looking at the value of your iterator's node pointer. Also note that you may have to change the _head_ and _tail_ of the LinkedList depending on which node gets deleted.

---

## Task Last. Finishing Up

Once completed, submit your DoubleLinkedList.java and DoubleLinkedListTester.java files. If you wrote an iterator as a separate class, be sure to submit that class as well. _Remember that both you and your lab partner should submit these files._