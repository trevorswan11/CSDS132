# Body of Outline
****
**Theme:** Write readable code to create an account for a student in university.
## Important General Comments
<https://canvas.case.edu/courses/41636/pages/course-honor-policy>
- Readability makes up 20% of the final grade, and guidelines can be found [[Project 1 Instructions#II. Code Readability (20% of your project grade)|here]].
- Code *must* be tested along the way as it makes up 20% of the final grade.. This means methods should be tested as they are written, not after completing the program.
	- Grade is determined based on how thorough the tests are, not how correct the resulting code is.
>[!example]
>For example, conditional statements should be tested in a way that guarantees that each branch of the if-statement is tested.
- Tests can include more than one method at a time, such as testing each setter/getter method pair together or you can test constructors and getter methods together.
- **Copy tests into a document along the way so that you can guarantee the code works and so that you have a head-start on the Testing Document part of the submission.**
- If you decide to use VS Code, or any other non-DrJava software, you can create a separate class, like a JUnit test, to test the program. These tests must be included in the testing document as well.
	- Testing code does not go in the main method, that is not the purpose of the main method!
#### For a more in-depth look into testing, look [[Project 1 Instructions#III. Program Testing Document (20% of your project grade)|here]].
>[!note] How to Document Tests
>The report should include the test used in the software, along with a short English description of what you are testing and what the expected result of the test is. Afterwards, there should be a section that briefly discusses the actual result of the test.
- Correctness of the code makes up 55% of the final grade, and a reflection on the project makes up the remaining 5%.
```ad-note
title: Advanced Testing
Moving through the semester, JUnit tests will be needed to receive full marks. These guidelines can be seen and referenced [[Project 2 Instructions#III. Program Testing Document (20% of your project grade)|here]]. 
```
# Program Guidelines
****
All the listed methods must be public.
- You will need to create several instance fields to store data, and every field must be private.
- All fields must be initialized to an appropriate value. They can be initialized either as part if the field declaration or in the constructor. Even if you feel that the default value provided by Java is appropriate, you still must give an explicit initialization.
- Any method whose name begins with set should only assign a value to an appropriately named field. The method should do no other processing. Any processing described in a set method description below is for information only. That actual processing will be done by other methods.
- Any method whose name begins with get should only return the appropriate value. No other processing should occur in these methods.
- Your class must include only the methods listed. You may not write any other methods.
- The behavior of your methods must match the descriptions below.
- You should not write any loops in your program (though loops are allowed in the testing code).
# Object Oriented (O-O) Coding
1. All fields must be privat 
2. Public getter/setter methods for all your fields
3. You can use fields directly in the getter/method and constructor.
	**Any other place you have to use them through getter/setters!!!!!**

````ad-example 
title: Good and Bad Practices
#### The following Code is not good because a field is accessed directly
```
public void compute() {
	count = count + 5;
}
```
#### The following code is good because it makes use of getter setters to access a field
```
private int count
public void compute() {
	steCount(getCount() + 5);
}
```
````