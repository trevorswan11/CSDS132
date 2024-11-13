Anonymous Classes:
  An anonymous class is one defined in the new expression that is creating the instance of the class.

```
new InterfaceToImplement() {  code to override the various methods here };
```

  or 
```
new ClassToExtend() {  code to extend the class by overriding methods here };
```

Local Variables and Anonymous Classes (and Local Classes)
    Because the anonymous class is created at a specific line of code, it has access to everything available at that line.
    For example, if you create the anonymous class inside a method, it will have access to the local variables of the method.
    However, this can create a problem because local variables are allocated from the stack while the instance of the anonymous class is allocated from the heap.  
    Thus, when the method ends, the anonymous class still exists but those local variables are gone.
    So, if you want an anonymous class to use a local variable, that variable must be declared "final".
    Recall that a "final" variable is a variable that will not change values.  Thus, Java can safely copy the value of the variable to another location that is not the stack. There will be no chance that the variable value will change.
    Alternatively, you can make the variable a field so that it will be stored in the heap instead of the stack.


Java 8 Alternative Syntax for Anonymous classes: The "lambda" expression and the "method reference" expression.

  Java has created two new ways for creating anonymous classes in the special case that the class is implementing an interface that contains a single method stub.

  a. The "lambda" syntax
  b. The "method reference" syntax

The Java "lambda" syntax is not a true lambda.  (In programming languages, a lambda expression is an anonymous function that can be stored to a variable, input to another function, returned from a function, etc.)  
While the "lambda" sytnax makes it -appear- that we are giving a function as input to a method, we are really giving an instance of an anonymous class as input to the method. 

Likewise, the "method reference" is not truly a method reference.  It is written to -appear- as if we are passing a method as input to another method, but that is not what is happening.
 Instead, the "method reference" is effectively another form of an anonymous class.

  The "lambda" syntax for anonymous classes
#### Example 1: A basic anonymous class with a method that takes one input and no return value:
Recall the EventHandler interface.  It has a single method stub handle(ActionEvent e).
 	   Here is code creating an anonymous class implementing the interface: 

```
EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
	public void handle(ActionEvent e) {
	  System.out.println("I was clicked");
	}
  };

	button1.setOnAction(handler);
```

Here is the "lambda" syntax.  Because there is only one method in EventHandler, there is no ambiguity about which method is being overridden.  All we need to know is what the input parameter name is and what the body of the method is.
 Java uses the "->" symbol to indicate that we are using the lambda syntax.
    How does Java know that this is an EventHandler anonymous class?  Because that is the parameter type for setOnAction!

```
EventHandler<ActionEvent> handler = (ActionEvent e) -> {					System.out.println("I was clicked");
});
button1.setOnAction(handler);
```

We can shorten it a little more by noting that the parameter type is also not needed:

```
EventHandler<ActionEvent> handler = (e) -> {
	System.out.println("I was clicked");
});
button1.setOnAction(handler);
```

Even more, since there is only one line in the body, we can remove the { }, and since there is only one input parameter, we can remove the ( ) around it to get the very short: 

```
EventHandler<ActionEvent> handler = e -> System.out.println("I was clicked");
	    button1.setOnAction(handler);

```
#### Example 2: A non-void method in the interface

We did an example with the Comparator interface.  It has many methods but a single non-default method stub: compare
	   Here is an example:

```
  public static Comparator<Employee> compareByName() {
	return new Comparator<Employee>() {
	  public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2);
	  }
	};
  }
```

We will use the lambda expression.  Java knows that we are creating and returning a `Comparator<Employee>` because that is the return type of the method.
Comparator has a single (non-default) method stub, and so there is no confusion about which method we are overriding.
Therefore, we can drop the interface name, the method name, and the input type.  All that we need is the name of the input parameters and the body of the method.

```
public static Comparator<Employee> compareByNumber() {
return (e1, e2) -> {
	return e1.getName().compareTo(e2);
	};
}
```

As before we can drop the { } because it is one line, and since the only line is a return statement, we can drop the return.  Java knows that the method has to return a value.  It just needs to know what value.

```
public static Comparator<Employee> compareByNumber() {
	  return (e1, e2) -> e1.getName().compareTo(e2);
}
```


 The "method reference" syntax for anonymous classes

Consider the following anonymous class:

```
b.setOnAction(new EventHandler<ActionEvent>() {
	   public void handle(ActionEvent e) {
	      reset();
	   }
    });
```

where reset is a private method:
```
	private void reset() {
	   -- code to reset the application --
	}
```

 In this case, the method we are overriding is simply calling another method. 
      On one hand, this leads to a simple "lambda" syntax:
		`b.setOnAction(e -> {reset()};);`

However, if we change the other method so that it's input parameters are identical to the anonymous class method:

```
b.setOnAction(new EventHandler<ActionEvent>() {
	   public void handle(ActionEvent e) {
	      reset(e);
	   }
        });
```

where reset is a private method:
```
	private void reset(ActionEvent e) {
	   -- code to reset the application --
	}
```

  Then we can use the "method reference" syntax.  The key for this syntax is to know what is to the left of the dot in the method call.  Java automatically adds "this", but it is the containing class "this", not the EventHandler "this":

```
b.setOnAction(new EventHandler<ActionEvent>() {
	   public void handle(ActionEvent e) {
	      ButtonGUI.this.reset(e);
	   }
        });
```

where reset is a private method:
```
	private void reset(ActionEvent e) {
	   -- code to reset the application --
	}
```

 Here is what the "method reference" syntax looks like:
	b.setOnAction(ButtonGUI.this::reset);

 Note the syntax.  To the right of the :: is the name of the method our anonymous class method will call.  To the left of the :: is the object or class that we will call the method on.
       So, you can think of "ButtonGUI.this::reset" as being the same as "ButtonGUI.this.reset"; however, the :: makes it clear we are using the method reference syntax.  Java will effectively replace the "ButtonGUI.this::reset" with 
       an anonymous class and its only method will call ButtonGUI.this.reset with the same input as was passed into the anonymous class function.

One nice thing about this syntax is that Java will automatically determine which "this" you are using.  So whilethis.reset(e) in the normal form of an anonymous class will give an error because "this" refers to the EventHandler this and not the ButtonGUI this, b.setOnAction(this::reset); will work because the code is now inside ButtonGUI and not inside the anonymous class. Similarly, we Java is not confused when we use the lambda syntax: b.setOnAction(e -> this.reset(e));
