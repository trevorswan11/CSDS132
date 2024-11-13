# Programming in Java: Lab 11  
Graphical User Interfaces, Buttons, amd the EventHandler Interface

In this lab, you will learn about events in JavaFX, and in particular you'll learn how to process button clicks.

## Task 1. Assigning Lab Partners

If you wish to have a lab partner (and you are strongly encouraged to do so), see your lab instructor. You may keep your lab partner from last week, but you do not need to.

### Reminder About The Rules For The Lab

### If You Do Not Have a Lab Partner

You are to do the tasks listed below. The tasks require you to write a class that contains specific methods. You need to complete all the methods as described. If you fail to complete all the tasks by the end of lab, you may continue to work on them, but you must complete the lab prior to the deadline posted.

### If You Have a Lab Partner

You will play two different roles in the lab. You will either be the _driver_ or _navigator_.

- **driver:** The person typing at the keyboard.
- **navigator:** The person watching for mistakes, making suggestions, and thinking ahead.

_**Important:** The navigator must not touch the keyboard or the mouse._ If the navigator either types or moves the mouse, the navigator will get a zero for the lab.

Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.

---

### _If you are new to programming_, your goal is to make it at least through Task 5. If you have not made it to Task 5 and there is less than 15 minutes in the lab session, ask the lab assistants for help.

---

## Task 2. Introductions and Starting DrJava

If you have a lab partner, tell your lab partner your name as well as your favorite Pixar movie.

Choose one of you to start as the driver, and launch DrJava.

---

## Task 3. Learning about JavaFX Button

To remind you: a javafx.scene.control.Button is a clickable button, and a javafx.scene.control.TextArea is a typing area. Both those things are _components_. GUI components are placed into a javafx.scene.Scene. The components can either be placed directly, or they can be added to a _layout manager_ that automatically arranges them in the _scene_. The javafx.scene.Scene is placed onto a javafx.stage.Stage in order to display it. The _primary stage_ in JavaFX is the main window of the application.

An _event_ in Java is something the user does to interact with your program: click a button, type a letter, move the mouse, and so on. When an event happens, Java notifies any object that is interested in the event. For example, when a Button is clicked, every object that has registered with the Button has their handle method called to handle the event.

Download ButtonLabGUI.java.

Once you have saved the file and opened it in DrJava, add your names to the top of the file, compile it, and run the application.

There is only one button with the text `Click me
Currently nothing happens when you click on it.

Now take a look at the code for ButtonLabGUI. Notice that the start method creates a Button, creates the layout manager BorderPane, and places the button into the center of the pane. The BorderPane is placed into a Scene, and the Scene is placed on the _primary stage_. Finally, the show method of the _primary stage_ is called to display the window.

What we now need to do is have the program respond when the button is clicked.

1. First, create a _nested_ class inside the ButtonLabGUI class that implements the `EventHandler<ActionEvent>` interface:  
    `private class ButtonAction implements EventHandler<ActionEvent> {`  
    This tells Java that ButtonAction will contain a method called handle that takes a single ActionEvent as input.
    
    To do this, you will need to import two types: javafx.event.EventHandler and javafx.event.ActionEvent.
    
    Also notice that you are making the nested class non-static. This will give the nested class access to the private instance fields and methods of the containing ButtonLabGUI class.
    
2. Now add the following line:
    
    button.setOnAction(new ButtonAction());
    
    directly below the line button = new Button ...  
    This tells Java to call the ButtonAction's object's handle method whenever button is clicked.
    
3. Add the method handle to your nested class. This is required by the EventHandler interface, and it is the method you asked Java to call whenever button is clicked.
    
      /** React to a button click:  change the text on the button
        * @param e  information about the button click event that occurred
        */
      public void handle(ActionEvent e) {
        Button b = (Button) e.getSource(); // this points to what b1 points to!
        b.setText("Ouch!"); // change the text of the button.
      }
    
    e.getSource() returns the memory address of the button that was clicked on. In this case the memory address will be the button that button refers to, and b.setText("Ouch!") sets the text on the button to the new string.
    

Compile the program and run it. You should be able to click the button and have the button's text change.

---

## Task 4: Change the behavior of the button

Do the following:

1. Change the initial button text from "Click me" to "Click count: 0".
2. Add an instance field that keeps track of the number of clicks.
3. Change handle to update the instance field.
4. Change handle so that it no longer sets the button text to "Ouch", but instead changes the text of the button to "Click count: i", where i is the number of clicks so far. Be sure to rewrite the comment! You should to call the sizeToScene() method of the primaryStage at the end of handle otherwise your button may be truncated when the count goes from 1 digit to 2 and then 3. (How do you access the primary stage in the handle method when it is an input parameter to the start method?)

Compile it, test it, and fix any errors.

Demonstrate to your lab assistant that it works.

---

## Task 5: Adding in a TextArea

**Switch roles: the driver should navigate and the navigator should drive.**

Do the following:

1. Change the button text back to "Click me".
2. Add a TextArea to the center and move the button to the top.
3. Change the code so that on each click it appends "Click count: i" to the TextArea, where i is the number of clicks so far. After three clicks, for example, it should contain
    
    Click count: 0
    Click count: 1
    Click count: 2
    Click count: 3
    
    If you don't know how to append text to a TextArea, look it up in the JavaFX API or take a look at last week's lab.  
    Be sure to rewrite the comment!
4. **Do not use any loops.**

Compile it, test it, and fix any errors.

Demonstrate to your lab instructor that it works.

---

## Task 6: The GridPane

**Switch roles: the driver should navigate and the navigator should drive.**

So far we have only used the BorderPane layout manager to align the components of the GUI. Now, we will create buttons in a grid by using the GridPane layout manager.

A grid is created by using a GridPane.

GridPane gridPane = new GridPane();

To add a component to the third row and second column of the grid, you use

gridPane.add(component, 3, 2);

In the start method, create a GridPane. Create a 2-dimensional array of Buttons with 3 rows and 3 columns. Set this to be the event handler for the buttons, just as you did with button. Add the buttons to the GridPane in the proper order so the position of the buttons in the panel matches their position in the array. Finally, add the GridPane to the center of the BorderPane content pane, moving the text area to the bottom.

Note that since all the buttons use the same EventHandler, pressing any button should update the click count in the text area.

Compile it, test it, and fix any errors.

---

## Task 7: Recognizing the Different Buttons

**Switch roles: the driver should navigate and the navigator should drive.**

Add code to the handle method so that the click count is only updated for the original button. For the grid buttons, have the method place a message in the text area that indicates the row and column of the button that is pressed. (Hint: you can use the getSource method to get the address of the button that was clicked. You can use a loop to run through the 2-dimension array of buttons you created to find the one that was clicked.) Try to organize your loop and if statement so that you do not write a huge amount of code. Note, keep the code that works for the button at the top of the window.

Compile it, test it, and fix any errors.

Demonstrate to your lab instructor that it works.

---

## Optional Task 8: Tic-Tac-Toe

**Switch roles: the driver should navigate and the navigator should drive.**

If you made it this far here is something challenging to try. If you are doing this lab solo, you do not have to do this part to get full credit, but it is an interesting challenge.

Implement the game tic-tac-toe. You need to change the handle method so that each time a button in the grid is clicked and if the button has no label, it sets the button label to "X" or "O". You will need a boolean field to keep track of which player's turn. Then, add code to check the grid to see if there are 3 X's or 3 O's in a row, and if so, append to the text area a message stating who wins. If all buttons have labels, append to the text area a message indicating the game is a draw. Also, modify the top button so that clicking it clears the labels of all the buttons in the grid, but keep the rest of the actions for that button.

As a hint, create separate methods to check for a win or a draw so that your handle method does not get too crowded.

---

## Task Last. Finishing Up

Once completed, submit your ButtonLabGUI.java file. Remember that both you and your lab partner should submit this file.
