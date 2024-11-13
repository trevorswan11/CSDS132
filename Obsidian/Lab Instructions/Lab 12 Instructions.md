# Programming in Java: Lab 12  
Fun With Event Programming (Using Nested and/or Anonymous Classes)

In this lab, you will practice doing event programming with JavaFX to create a simple drawing program. This is a good time to practice nested and anonymous classes. I encourage you to try the "lambda" and "method reference" shortcuts! This is a fun lab, but there are a lot of parts to this lab, and most teams will not be able to complete it. Try to get through at least Task 4 with your team. So if have not completed task 3 within half of an hour, get help from your lab instructor.

#### Remember that both partners must submit their lab files at the end of the lab.

## Task 1. Assigning Lab Partners

If you wish to have a lab partner (and you are strongly encouraged to do so), see your lab instructor. You may keep your lab partner from last week, but you do not need to.

### Reminder About The Rules For The Lab

### If You Do Not Have a Lab Partner

You are to do the tasks listed below and submit your lab prior to the deadline posted.

### If You Have a Lab Partner

You do not have to complete all the tasks, but you do have to work hard and be a good partner. That means the navigator must make good suggestions and must not edit the file.

---

## Task 2. Introductions and Starting DrJava

If you have a lab partner, tell your lab partner your name as well as whether you actually read and follow the directions of this part of the lab.

Choose one of you to start as the driver, and launch DrJava.

---

## Task 3: Create a _JavaFX_ Application with a Canvas and do some drawing

**Important:** You will need to reference the API in this lab. Be sure you have the _JavaFX_ API opened up, and not just the standard Java API. Many of the JavaFX classes have similar names to classes in the standard API.
	
Create a new class called Painter that extends Application. Add a BorderPane to the Scene, add the Scene to the Stage, show the Stage and create a main method that calls Application.launch(...). If you do not recall how to do this, look at your prelab or Lab 8.

Once you have the _JavaFX_ application set up, create a Canvas object and add it to the center of the BorderPane. I suggest making the Canvas a large size like 500x500 or bigger. (Our canvas is not going to be resizable in this lab, so you want something big enough to work with.)

Now we want to be able to draw on the canvas by clicking and dragging on it with a mouse. For this you need to add an EventHandler to your canvas that listens for MouseEvents. You want to call `canvas.setOnMouseDragged(...)` where canvas is the variable storing your Canvas object, and the input to the method is a `EventHandler<MouseEvent>` object. There are multiple ways you can do this:

1. Have the Painter class implement `EventHandler<MouseEvent>`.
2. Create a nested class that implements `EventHandler<MouseEvent>`.
3. Create an anonymous class that extends `EventHandler<MouseEvent>`.
4. Use the "lambda" shortcut that provides the body of what you want to occur in the handle method of EventHandler.
5. Write a method that takes a MouseEvent as input and use the "method reference" shortcut

The body of the handle method (or the body of the "lambda" shortcut, or the body of your method reference) should do the following:

1. Get the GraphicsContext for the Canvas. Canvas has a method getGraphicsContext2D that returns the GraphicsContext.
2. Set the color to draw by using the setFill method of the GraphicsContext. For now, set the color to Color.BLACK.
3. Draw a circle on the Canvas at the current location of the mouse. Use the fillOval method of the GraphicsContext context. Set the width and height parameters to 10 and get the x and y coordinates from the MouseEvent that is the parameter of the method.

Compile and test your program to see if you can draw!

---

## Task 4. Add Some Color

**Switch roles: the navigator should now drive and the driver should navigate.**

Now let us add some color to the pen. JavaFX has a gadget called the ColorPicker that lets a user choose a color.

Create a new ColorPicker and use the constructor that sets the initial color to Color.BLACK. Then place the ColorPicker at the top of your BorderPane.

Now change the EventHandler you use in the setOnMouseDragged method to have the GraphicsContext use the color from the ColorPicker rather than always using Color.BLACK. Use the method getValue to get the current selected color from the ColorPicker.

---

## Task 5: Change the Pen Size

**Switch roles: the navigator should now drive and the driver should navigate.**

Let us improve our drawing program by letting the user change the pen size.

We will use a Slider to select a size. Create a new Slider, and add it to the right side of the BorderPane. Use the constructor to set the minimum value to 1, the maximum to 101, and the default to 10. Next you want to set the orientation to vertical. Try to figure out how to do this using the JavaFX API.

Second, let's make the slider look nice by calling the following methods, replacing "slider" with whatever you chose to name your Slider:

    slider.setShowTickMarks(true);
    slider.setShowTickLabels(true);
    slider.setMajorTickUnit(10);
    slider.setBlockIncrement(1);

Now change your EventHandler used in setOnMouseDragged to use the current value of the slider, found by using the getValue method of Slider for the height and width of fillOval.

---

## Task 6: Improve the Pen Behavior

**Switch roles: the navigator should now drive and the driver should navigate.**

Now let us make a few changes to improve the way your drawing works. First, make the pen size large, and notice that the circle drawn is to the right and down from the current mouse position. Change your program so that the circle drawn is centered on your mouse by subtracting half of the desired pen size from the x and y position of the fillOval.

Now try clicking on the canvas without moving the mouse. Notice that no drawing occurs until you start to drag the mouse. Let us fix this so that a circle is drawn the moment you click your mouse. We do this by calling the method `setOnMousePressed` method of Canvas and adding an `EventHandler<MouseEvent>` that should be called when the mouse is first clicked. _Don't remove the `setOnMouseDragged`, you need both!_ Now have the program do the same thing when the mouse is pressed as it does when the mouse is dragged.

Now test your code and fix your code. One last round to go!

---

## Task 7: Display the Current Pen Size

**Switch roles: the navigator should now drive and the driver should navigate.**

The slider is good for choosing a pen size, but it is hard to choose an exact size. Rather than guess, you will add a TextField that displays the current size. Create a TextField, set its number of columns to 4, its initial value to 10, and set it so that it is not editable. The code will be similar to the following:

    TextField textField;
    textField = new TextField(Integer.toString(10));
    textField.setPrefColumnCount(4);
    textField.setEditable(false);

Note that it would be best to create a static private final variable that holds the default value of 10, and use that to initialize the slider and textfield. Otherwise, if you change one's default value, you might forget to change the other's.

Now, we want to add the TextField to the right of the BorderPane so that it is next to the Slider, but a region of the BorderPane can only hold one component. We fix this by placing another pane inside the BorderPane. You will create a HBox. The HBox can hold multiple components that are displayed left to right. Create an HBox, and call the HBox setAlignment method to set the alignment to CENTER (check with the API to see how to do this). Now you can place the slider and textbox into the HBox with something like the following:

hboxPane.getChildren().add(slider);
hboxPane.getChildren().add(textField);

Then place the HBox to the right side of the BorderPane.

Test your code to see that this happens. Notice that changing the slider does not change the value of the textfield.

**Switch roles: the navigator should now drive and the driver should navigate.**

For your last task, make the textfield display the current value of the slider whenever the slider changes. You do this by adding a ChangeListener to the slider. To add the ChangeListener you use

slider.valueProperty().addListener(_your change listener goes here_);

The ChangeListener has only one method: changed that takes three parameters: an ObservableValue, the _oldValue_ and the _newValue_. Your task is to have the changed method set the value of the textfield to be the _newValue_. If you get stuck, be sure to use the API to see what types you are manipulating. (As before, there are many ways you can do this, with the current class implementing ChangeListener, with a nested class, with an anonymous class, with a lambda expression, or with a method reference.)

Test and fix your code.

## Task Last. Finishing Up

Once completed, submit your java file. _Remember that both you and your lab partner should submit this file._