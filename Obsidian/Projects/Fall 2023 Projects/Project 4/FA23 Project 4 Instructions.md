## Programming Project 4

### Due Friday, December 1 at 11:59pm

_**IMPORTANT:** Read the **Do's and Dont's** in the **Course Honor Policy**._

### I. Overview

The purpose of this homework is to give you practice designing and creating a complete program.

---

### II. Code Readability (20% of your project grade)

To receive the full readability marks, your code must follow the following guideline:

- All variables (fields, parameters, local variables) must be given appropriate and descriptive names.
- All variable and method names must start with a lowercase letter. All class names must start with an uppercase letter.
- The class body should be organized so that all the fields are at the top of the file, the constructors are next, the non-static methods next, and the static methods at the bottom with the main method last.
- There should not be two statements on the same line.
- All code must be properly indented (see page 645 of the Lewis book for an example of good style). The amount of indentation is up to you, but it should be at least 2 spaces, and it must be used consistently throughout the code.
- You must be consistent in your use of {, }. The closing } must be on its own line and indented the same amount as the line containing the opening {.
- There must be an empty line between each method.
- There must be a space separating each operator from its operands as well as a space after each comma.
- There must be a comment at the top of the file that **is in proper JavaDoc format** and includes both your name and a description of what the class represents. The comment should include tags for the author. (See Appendix J of the Lewis book of pages 249-257 of the Evans and Flanagan book.)
- There must be a comment directly above each method (including constructors) that **is in proper JavaDoc format** and states _what_ task the method is doing, not how it is doing it. The comment should include tags for any parameters, return values and exceptions, and the tags should include appropriate comments that indicate the purpose of the inputs, the value returned, and the meaning of the exceptions.
- There must be a comment directly above each field that, in one line, states what the field is storing.
- There must be a comment either above or to the right of each non-field variable indicating what the variable is storing. Any comments placed to the right should be aligned so they start on the same column.
- There must be a comment above each loop that indicates the purpose of the loop. Ideally, the comment would consist of any preconditions (if they exist) and the subgoal for the loop iteration.
- Any code that is complicated should have a short comment either above it or aligned to the right that explains the logic of the code.

---

### III. Program Testing (20% of your project grade)

You are to write a test report that indicates the _types_ of tests needed to thoroughly test your project. The tests should demonstrate that all parts of your code behave correctly. Any unit of your program involving conditional statements will need tests that go through each branch of the execution. Any unit of your program involving loops will need tests that cover the "test 0, test 1, test many" and "test first, test middle, test last" guidelines. Your testing report should _not_ list the actual tests and results.

You are to have a JUnit test class or classes that implement as many of the tests as you can. You should have comments, names, or other indicators in your JUnit tests that easily link the JUnit tests back to the testing report.

_The testing report must be separate from the JUnit class._ In most companies, the testing document will be written in a style that allows both programmers and non-programmers to read it and recognize whether all the needed test cases were included.

**Note** that you will not be able to (easily) test methods involving user input or screen output with JUnit. For these parts of your program, your testing report should indicate the specific tests you did to test these routines.

**Note**: you should have parts of your program that implement the game play and _do not_ use JavaFX gadgets. Separating the game play from the game display will let you create JUnit tests that do not involve JavaFX gadgets.

_Hint:_ Make lots of (public) helper methods for each of the different parts of the game. That will make it much easier to design tests for your game, and it will make the testing shorter!

**A reminder, your grade is based on whether you made a good _attempt_ to thoroughly test your program using JUnit and using methods that don't involve the GUI.**

---

### IV. Java Programming (60% of your grade)

For this project you will implement the domino based-game [Mexican Train game](https://www.google.com/url?q=https://en.wikipedia.org/wiki/Mexican_Train&source=gmail-html&ust=1714841806185000&usg=AOvVaw0UGdP89HUMtaET_EDB0t0L).

#### Rules of the game:

There are many variations of the Mexican Train game. We will use the following rules

A domino is a tile with two numbers on it, one number on each side of the tile. A "train" is a line of dominos where two dominos can join in the train if the numbers on the connecting domino sides are identical. (You can match a [5|3] domino to a [3|6] domino because the connecting sides both of the number 3.)

Each player has their own train of dominos that (usually) only they can build on and there is also a Mexican train of dominos that anyone can build on.

The game starts by shuffling all the dominos and every player picks a hand of dominos. The "start" of the board is a single "double" domino (a domino where both its numbers are the same, like [6|6]). That indicates the number that all trains must start with. The players then take turns.

At each turn, a player can play their domino on their train, the Mexican train, or any other player's train if that train is "open". By default, all trains are "closed" so the players can only play on their train or the Mexican train.

If a player cannot play any domino because they hand does not have a domino that matches the end domino of any train they can play, then their train is marked as "open", and they draw a domino from the remaining pile. If they can play that domino, they may do so, but if not then it goes in their hand and their turn is over.

A player's train remains "open" until they add a new domino to it (including a just drawn domino). At that point, the train is "closed". While the train is "open" all other players can play on the train during their turn.

If a player plays a "double" domino (same number on both sides), they get another play, and that play must be to put another domino after the double (matching the double number). If they fail, their train becomes "open". Each subsequent player must play on the double, and if they fail, their train is "open". That continues until some player is able to play on the double, and then play resumes as normal.

The round of play ends when somebody runs out of dominos in their hand. Then all players add up the points on the dominos still in their hand, and they add that sum to their score.

The game continues in "rounds" where a different "double" domino is used as the starting value. Once every double domino has been used, the game ends and the winner is the player with the least total score.

### What you must do:

This project will create the MexicanTrain game. The project will use the LinkedList class we created during lecture/lab to implement the domino train.

You are to create _at least_ the following classes and methods, but you may create more as needed or wanted.

1. LinkedList: This is the LinkedList class we have been creating in lecture. There is only a couple changes you need to make.
    
    - There should be a firstElement method that returns the first element of the linked list without removing it.
    - The Iterator of the LinkedList class should implement a remove method that will remove the last value returned by next from the linked list.
    
2. Domino: The Domino class represents a single domino.
    
    - The class should have two values for the two halves of the domino. Those values do not change.
    - The Domino class should have a rotate method that switches which value is "in front" and which is "in back".
    - The toString method of the Domino class should give a string representation of the domino. I suggest something like "[3|5]" where 3 and 5 are the values of the two sides of the domino. After calling rotate, the toString method of that domino should give "[5|3]"
    
    .
    
3. DominoTrain: The DominoTrain class _is a_ LinkedList of Domino.
    
    - The constructor should take an int value that represents the value of the "starting" double domino used as the initial value of the traina The constructor will create an empty train.
    - The addToFront method should only add a domino to the train if one side of that domino matches the "front" value of the first domino in the train. If the train is empty, one side of the domino must match the starting value of the train. The domino added is rotated so that its "back" value matches the "front" value of the first domino in the train. (We are assuming that the train is being built from "back" to "front".) If there are no dominos, then the domino is rotated so that the "back" value matches the initial value for the train.
    - There should be a method getEndValue that returns the int value that is required to add a domino to this train.
    - There should be a canAdd method that takes a Domino and returns true if either value on this domino matches the "end value" for the train.
    
4. MexicanTrainGame: The MexicanTrainGame class should extend the JavaFX Application class.
    
    - The main method should allow the user to enter the number of players. The default will be a two player game. So, java MexicanTrainGame will launch a JavaFX GUI to play the game with 2 players while java MexicanTrainGame 3 will launch the GUI to play the game with 3 players. It is up to you how many players you wish to allow, but at the minimum you should try to get the game to work with 2, 3 or 4 players.
    - The start method should create the _primary stage_ to display the different trains, and two separate Stages (i.e. windows) will be for each player's hand. While the layout of the display is up to you, I recommend using a VBox layout for the primary stage. This creates a display of "rows". You can make one more row than there are players. For each row, use a BorderPane or a HBox where the left, or first gadget is a label identifying which player owns that train and which is the Mexican train, the center will be train itself using a HBox layout, and the right, or last, gadget will be a button.
    - The start method should create an additional Stage for each player that will represent the player's hands. I recommend using a VBox or GridPane layout so that you can place two components. The first should be the display for the dominos in the hand. I recommend a HBox layout for that component, and the second is a Button that has the text "Draw" (or something similar).
    

#### Implement the Game

**Note: It is difficult to test JavaFX gadgets either directly or in JUnit. To make JUnit testing of your project feasible, you should implement as much of the game mechanics using methods and classes that don't access JavaFX gadgets.**

**Remember, that you are graded on effort and not correctness.** You should make a good effort to implement the first 8 points below.

#### 1. Setup the Game

First create the dominos for the game. In our version, we will have 55 dominos. There will be all possible combinations of numbers from 0 through 9 on each part of the domino. The first round (it is optional to have to game go beyond one round), will use all but the [9|9] double domino. That domino is "reserved" to be the starting point.

The easiest way to shuffle the dominos is to put all of them into an ArrayList and then use the Collections.shuffle method of the Java API.

Then place the dominos into a LinkedList that represents the "draw" pile. Create a separate LinkedList for each player to represent their hand, and then "deal" 12 dominos from the draw pile to the hand for each player.

#### 2. Setup the Game Display

Have each domino displayed in the windows (stages) for each player's hand. The player windows should contain both a HBox and a Button. The HBox class has a method getChildren that returns an ObservableList that holds all the gadgets in the layout. You can then add gadgets to the ObservableList and they will show up on the window. (You should set the window to have an appropriate size.)

For each domino in a player's hand, add a Button to the HBox. I recommend making the text of the button be the toString value of the domino.

#### 3. Let a Player Select a Domino

Add an EventHandler to each Button that represents a domino in the player's hand. Make the code of the EventHandler so that it "remembers" the last domino selected (i.e. the last button clicked). Players will take turns, so when it is player 1's turn, the player should only be able to click on the buttons in the Player 1 hand window. Clicking on buttons for Player 2's dominos should do nothing.

You should have some way to mark the last button clicked. I recommend changing the background of the button clicked to another color. (Technically, you set the Background to have a BackgroundFill that contains the desired Color - see the API.) So, each time a player clicks a button for a domino in their hand. That domino's button color will change to highlight the button and the previously clicked button will revert back to the default. You are welcome to do something else, but a player would like someway to know which domino they are selecting and to be able to change that selection.

#### 4. Let a Player Add a Domino to a Train

Add an EventHandler to buttons that are after each "train display" in the main window of the application. The event handler should check the following:

1. Is this button for the player's train, the Mexican train, or if it is for another player's train, is that train "open"?
2. Can the domino be placed onto the end of the selected train?
3. If this is a legal move, then place the domino corresponding to that button onto the train, and remove that domino from the player's hand. The player's turn is now over.
4. If this is not a legal move, don't do anything.
5. Hint: use the iterator's on the lists to find and then remove the domino and button.
6. Hint: for the train display, I recommend using an HBox containing Labels. Create a Label for the domino added to the train, and then use the getChildren method of HBox to get the list of Labels representing the dominos, and add the new label to the list.

#### 5. Let a Player Draw a Domino

Add an EventHandler to the button in each player's hand that is labelled "Draw" (or what you decided to use). The code for the handle method should get the next domino from the draw pile linked list and add it to this hand. If it is legal to place this domino onto one of the available trains for this player, the player's turn should continue. You should have some way to mark this. For example, you can change the background color on the newly drawn domino to indicate that it should be played.

If the drawn domino cannot be legally played by this player, the player's turn is over.

#### 6. Have the Game Change Players

After the player places a domino on a train or draws a domino that can't be played, the player's turn should end. You need some way to record which player is supposed to play next, and the routine should update this.

#### 7. "Open" and "Close" Trains

When a player selects the Draw button, their train should be "openend". You will need some indicator in your program (like a boolean) to indicate this. You should also have a visual indicator such as changing the background for the player's train.

When a player plays a domino on their own train, their train should be "closed". That should be indicated both in the program and visually for the players (such as by restoring the background color of the train to the default.

#### 8. Note when the round ends

When a player's hand becomes empty, the game should indicate that this round is over. No more plays should be permitted unless you are doing another round.

#### 9. Optional full game

If you want a further programming challenge, when the round ends, have the game reshuffle the dominos, deal them out, and start a new game, but this time with the [8|8] domino as the starting value. The game should repeat through each of the initial dominos ending after the round starting with [0|0].

After each round, the game should total the number of points remaining in each player's hand and add them to their score. At the end of the game, report the final results.

#### 10. Optional "double" rule

For a further programming challenge, and to make a complete game, add the rule that a player must "complete the double". When a "double" domino is player, the player must immediately play another domino on that double. If they don't have a matching domino and draw but don't get a match, their turn is over and their train is "open". Each subsequent player must try to match the "double", and if they can't after drawing, their train is "open" and their turn is over. Play proceeds until either some player successfully plays on the double or no player can because the draw pile is empty and no player has a domino that matches the double.

---

Here is an example of how you can make your game look. In this image, player 2's train is "open". It is player 1's turn, and player 1 has selected the domino [5|2], probably to play on player 2's train.

![TrainGame.jpeg](https://ci3.googleusercontent.com/meips/ADKq_NbEA-HcxzKSVXt7EC4fqp8q48Ut60kmAQCzgmT0KwI32SbdXaTs_PHfa-XAte0e-pLeFjPXl45hYncjsER_elC_mkIIYqQliglIwm411HwQY7dZ=s0-d-e1-ft#https://canvas.case.edu/files/6927160/download?download_frd=1)

---

#### Some General Hints

There is a lot to do in this game so don't try to code everything at once!

Create lots of helper methods. Use inner classes. Each helper method can be really small and do one task. That will make it easier to handle the logic of the game, and you can then write JUnit tests for each helper method, and that will make it easier to test your game.

---

### Extra Credit: (up to 1% of the course grade)

Make the board more aesthetically appealing and/or make the game more enjoyable to play. The amount of extra credit awarded will be based on both the coding challenge and the creativity of your changes. You may need to hunt through the API in order to figure out how to add features to your game.

**IMPORTANT:** If you complete an extra credit, you must put a comment with your canvas submission indicating what you did. Otherwise we will not grade the extra credit.