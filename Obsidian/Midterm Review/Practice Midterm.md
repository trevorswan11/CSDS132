## Question 1: Operators and Types
For each expression below, write the type of the expression on the first line, then the value of the expression on the line to the right. Write "*illegal*" if the expression is never allowed in java. If the expression might be allowed, assume it is used in a valid context. Only write "*illegal*" if there is absolutely no context where the expression is valid. Write "*unknown*" if the expression is legal but *impossible* to determine the value from what is given.
$$
\begin{align}
\qquad\qquad\qquad\qquad&\underline{Expression}\qquad\qquad\underline{Type}\qquad&\underline{Value} \\ \\
&{1 + 2}\qquad\qquad\qquad\quad\text{int}&\qquad\qquad{3} \tag{$\ast$}
\end{align}
$$
****
$$
\begin{align}
 2 + \left( \frac{1}{4} \right)\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{1}\\ \\
 (\text{double})2+\frac{1}{4}\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{2}\\ \\
 2+\left( \frac{1.0}{4} \right)\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{3}\\ \\
\text{new Object() == new Object()}\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{4}\\ \\
\text{'b' + (char)0}\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{5}\\ \\
 x=(y==z)\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{6}\\ \\
 2!=3!=4\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{7}\\ \\
 \text{true || false}\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{8}\\ \\
 \text{false} == 1\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{9}\\ \\
(3<4)\ \&\&\ (5<6)\qquad\qquad&\_\_\_\_\_\_\_\_ &\_\_\_\_\_\_\_\_ \tag{10}\\
\end{align}
$$
<br><br><br><br>
## Question 2: Strings
Write a method *capitalizeFirstK* that takes a String and an int value *k* as input and returns a String. The output should be the same as the input string except that the first *k* lower case letters are converted to upper case. You may use (but are not required to use) the following java API methods:
- boolean Character.isLetter(char ch)
- boolean Character.isLowerCase(char ch)
- char Character.toUpperCase(char ch)
```
> Midterm.capitalizeFirstK("How are you doing?", 4)
"HOW ARe you doing?"
```
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
## Question 3: Short Descriptions
Please give precise answers to the following questions.
1. What is the purpose of a *type*?
<br><br><br><br><br><br><br><br><br>
2. What is *short-circuit evaluation* and what Java constructs use it?
<br><br><br><br><br><br><br><br><br><br>
3. What exactly happens if you do not provide a constructor for a class? Be precise.
<br><br><br><br><br><br><br><br><br><br><br><br>
## Question 4a: Classes
Create a **BankAccount** class. The BankAccount should contain three values, an int *number*, a double *balance*, and a Customer *customer* (Assume Customer is a class that already exists).
- The **BankAccount** should be such that when we create an instance, the *number* must be included when we use new.
	(Example: new BankAccount(3345123))
- There should be a way to separately retrieve all three values and separately change the *balance* and *customer*
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
## Question 5: Extending Classes
Suppose we have a class Customer that already exists.
The Customer class has the constructor:
- Customer(String name): creates a Customer instance with the given name and the method
- void deposit(double amount): deposits the given amount into the customer's account
Create a class **BankCustomer** that extends Customer. The **BankCustoemr** class should have two attributes *checkingAccount* and *savingsAccount* both of type BankAccount of the previous question (4a).
- When an instance of BankAccount is created, the *name* must be included when we use new.
- Provide a means to retrieve and change the *checkingAccount* and *savingsAccount* values.
- When changing either the *savingsAccount* or the *checkingAccount*, that account's *customer* value should be set to this **BankCustomer** instance.
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
## Question 6: Updating Inherited Methods
This question continues the class you started in Question 5.
The **BankCustomer** class inherits the deposit method of Customer.
- void deposit(double amount): deposits the given amount into the customer's account.
Change how the deposit method works so that:
- If the *checkingAccount* exists, set the *checkingAccount*'s balance to be its existing balance plus the input amount.
- Otherwise, if the *savingsAccount* exists, set the *savingsAccount*'s balance to be its existing balance plus the input amount.
- Otherwise, call the inherited deposit methods with the given amount.