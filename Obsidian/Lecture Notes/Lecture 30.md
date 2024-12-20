Event Driven Programming Paradigm and Java Interfaces

  In the "normal" programming model, a program executes a series of instructions until completion.
  In the event driven paradigm, the program waits for an event to happen.  For example, it waits until the user clicks a button, and then the program responds to the event.
  For this paradigm, we need:
    - the program must register with the operating system to receive events
    - the operating system needs to know how to inform the program when desired event occurs.
  In Java, the JVM handles most of the registering, but we still need to register our objects with the JVM to receive certain events.


In this class, we created a window with a button, and we registered to receive button events.  We then had our program do something when a button occurred.

Registering for button clicks in JavaFX:

   We will register our program to be informed when the button we creat is clicked.
   The method to register for button clicks is in the Button class, and the API for the method is:
	`setOnAction(EventHandler<ActionEvent> h)`

   What you see is that the method setOnAction takes a value of type EventHandler as input.
   If we lookup EventHander, we see:
	`Interface EventHandler<T extends Event>`

   So, EventHandler is an interface that takes a generic type, where the generic type can be anything that extends the Event class. 
     We also see that setOnAction for Button specifies that this generic type should be ActionEvent.

   Finally, we see that the EventHandler interface has a single abstract method:
	void handle(T event)
   Since we know that the generic is going to be specified as ActionEvent, we are going to have to override the method
	void handle(ActionEvent event)
   in our class that implemets EventHandler.
   

   Here is the code to set up the GUI and then register for the button click event:

```
  public void start(Stage primaryStage) {
	Button button = new Button("click me");    // create the button
	BorderPane borderPane = new BorderPane();   
	borderPane.setCenter(button);              // place the button in the center of the layout
	Scene scene = new Scene(borderPane);       // create the scene with this layout
	primaryStage.setScene(scene);              // add the scene to the window
	primaryStage.show();                       // display the window


	button.setOnAction(...);                  // register that this object should receive the button clicks
  }
```

   Now, we have to implement the EventHandler interface, we decided to have our class implement the EventHandler

```
private class ButtonGUI extends Application implements EventHandler<ActionEvent> {

  -- the previous code here ---

  public void handle(ActionEvent e) {
	--- do something when the click happens ---
  }
}
```

The handle method is what will be called when the operating system detects a click of the button.
    How does the Java Virtual Machine know the method is in ButtonGUI?  Because ButtonGUI implements EventHandler.


   So here is our code again:

```
public class ButtonGUI extends Application implements EventHandler<ActionEvent> {
  public void start(Stage primaryStage) {
	Button button = new Button("click me");    // create the button

	button.setOnAction(this);                  // register that "this" object should receive the button clicks

	BorderPane borderPane = new BorderPane();   
	borderPane.setCenter(button);              // place the button in the center of the layout
	Scene scene = new Scene(borderPane);       // create the scene with this layout
	primaryStage.setScene(scene);              // add the scene to the window
	primaryStage.show();                       // display the window
  }
```

Next, we decided to create to buttons, and use the same EventHandler instance on both, but we wanted the action to be different.
      There is a method in ActionEvent called getSource that gets the object that produced the event.
      The return type of getSource is Object, but since we are creating the GUI, we know that the only thing that can produce that event is the Button, so we can safely typecast it.

   
```
public class ButtonGUI extends Application implements EventHandler<ActionEvent> {
  private Button button1;

  public void start(Stage primaryStage) {
	button1 = new Button("click me");
	Button button2 = new Button("and me");      

	button1.setOnAction(this);  
	button2.setOnAction(this);   

	BorderPane borderPane = new BorderPane();   
	borderPane.setTop(button1);                // place the button at the top of the layout
	borderPane.setBottom(button2);             // place the button at the bottom of the layout
	Scene scene = new Scene(borderPane);       // create the scene with this layout
	primaryStage.setScene(scene);              // add the scene to the window
	primaryStage.show();                       // display the window
  }

  public void handle(ActionEvent e) {
	Button b = e.getSource();
	if (b == button1) {
	  -- do something when button1 is clicked --
	}
	else {
	  -- do something if a different button is clicked --
	}
  }
}
```


   A couple things to note:
     1) Why did we have to make button1 a field?  
     2) We chose to not have getter/setter methods for button1 and button2. 
        This violates our O-O coding guidelines, but we are okay with that because we do not want other code modifying these buttons.
	If we do want to let another class extend this GUI and change how the buttons work, we will need to create getter/setter values.
     3) Why does the nested class have access to the instance fields of the outer class?  Because the nested class is not static.  
        We can think of the nested class as belonging to a specific instance of the GUI and not the the class.