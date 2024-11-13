# Programming in Java: Lab 9  
Building a Class Hierarchy

In this lab, you will create a hierarchy of classes and abstract classes and start to learn some benefits of using the hierarchy.

## Task 1. Assigning Lab Partners

If you wish to have a lab partner (and you are strongly encouraged to do so), see your lab assistant. You may keep your lab partner from last week, but you do not need to.

---

## Reminder About The Rules For The Lab

### If You Do Not Have a Lab Partner

You are to do the tasks listed below. The tasks require you to write a class that contains specific methods. You need to complete all the methods as described. If you fail to complete all the tasks by the end of lab, you may continue to work on them, but you must complete the lab prior to the deadline posted.

### If You Have a Lab Partner

You will play two different roles in the lab. You will either be the _driver_ or _navigator_.

- **driver:** The person typing at the keyboard.
- **navigator:** The person watching for mistakes, making suggestions, and thinking ahead.

_**Important:** The navigator must not edit the code._

Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.

As in last week's lab, you will write a class that you will submit at the end of lab. You do not have to complete all the tasks by the end of the lab because you are being graded on how well you work as a team. You do have to make a good effort and work for the entire 50 minute lab to get full credit.

### Submitting the Lab

At the end of lab, submit your program on the _Lab 3_ assignment on Canvas. _Both you and your lab partner should submit your code._ Remember that your code is in a file with a .java extension, and depending on your browser, the extension may or may not be visible. _Do **not** submit the file with the .class extension (that is Java bytecode) or the .java~ extension (that is a temporary editor file)._

---

### _If you are new to programming,_ your goal is to make it to Task 6 during the lab session. If you are having trouble with Tasks 3 through 5, be sure to ask the lab assistant for help.

---

## Task 2. Introductions and Starting DrJava

If you have a lab partner, tell your lab partner your name as well as what you did over spring break.

Choose one of you to start as the driver, and launch DrJava.

---

## Task 3. A First Class Hierarchy.

In many computer games, we have a world filled with items that the game characters can pick up and use. Some items can be food, some items can be weapons, and so on. There can be hundreds of different items, and we want to avoid having to write giant if statements listing all the possible items.

First, get the Person.java file with this lab. You can see that currently a person has strength, intelligence, and energy.

Now, let's create items that the person can pickup and carry. For now, we want the following six items:

1. Apple
2. Sword
3. Hammer
4. Steak
5. Bread
6. Statue

We want each item to have a _weight_ and a _name_ associated with it. We want a person to be able to pick up an item as long as it is not too heavy.

To help us, let's create an _abstract class_ that collects all of these properties into a single place.

I will start out by showing you one way to do that. Here is such an abstract class. Add this class to your code. Notice that it states that all items have weights and names. It also defines a toString method for the item. Initially the toString just uses the name of the item. The reason these are separate methods is so that later on we can have toString methods that can adjust to game situations.

public abstract class GameItem {
  private double weight;
  private String name;

  public GameItem(String name, double weight) {
    this.name = name;
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }
}

Now that we have this class, defining each of the items is easy. Here is the class for Apples. An apple does not weigh very much so I give it a very light weight.

public class Apple extends GameItem {
  public Apple() {
    super("Apple", 0.25);
  }
}

Create a class for each of the six objects. Then add two new methods to Person:

- public boolean pickup(GameItem o): If the item weighs less than the strength of the person, return true and set a field indicating that the person is carrying this object.
- public GameItem drop(): Change the field so that the person is no longer carrying an object and return the object that was dropped. Return null if the person was not carrying anything.

To make things easy, right now we will assume a person can carry only one item at a time.

Compile and test your code. Make sure some items (like the statue) are too heavy to pickup.

## Task 4. Adding to the Hierarchy: Food

**Switch roles, the driver should navigate and the navigator should drive.**

We want to designate some items as food. A food item should have _calories_ that increase the energy of a person who eats it.

Create an _abstract_ class Food that extends GameItem. Just as how GameItem has a weight, a Food should have a name, a weight (inherited from GameItem so do not create it), and _calories_.

Change Apple, Steak, and Bread to now extends Food intead of GameItem and give each some calories. For example, here is Apple:

public class Apple extends Food {
   public Apple() {
     super("Apple", 0.25, 10);
   }
}

Just as before, an apple is very light, and I decided that it should provide 10 game "calories".

Now create an eat method in Person. You should only be able to eat food and when you eat food, you should increase the energy of the person eating it.

Compile and test your code. You should still be able to carry all items but only eat food.

## Task 5. Special Food

**Switch roles, the driver should navigate and the navigator should drive.**

It is quite common in games for food to give special benefits to the eater besides energy. For example, we could have apples increase intelligence, steak increase strength, and so on. We do **not** want a giant if statement inside the Person class to cover all the possibilities for the special food benefits.

Add the following method to the Food class:

public void eat(Person p) {
}

Next, change the eat method in Person to both increase the energy of the person, and to call the eat method of the Food.

Finally, override the eat method in Steak so that increases the strength of the person who ate the steak.

Compile and test your code. Eating steak should now increase a person's strength.

## Task 6. Further Expanding the Heirarchy

**Switch roles, the driver should navigate and the navigator should drive.**

Let's create additional abstract subclasses of Food. The subclasses should be Meat, Vegetable (that includes fruit), and Grain. Then make the apple, steak, and bread classes extend these classes.

Now, create a Vegetarian that is a subclass of Person where a Vegetarian overrides the eat method so that it only eats food that is not meat.

## Task 7. Adding a New Food Item

If you have a good hierarchy, adding new food items should be easy. Create a new food that is Carrot. A carrot is a vegetable, and a carrot will increase the intelligence of the person eating it. **You should be able to add Carrot with these features by only creating the class Carrot. You should not have to adjust any other class of your program.**

## Task 8. Adding a New Kind of Class to the Hierarchy

**Switch roles, the driver should navigate and the navigator should drive.**

Create three new items:

- Box
- Bag
- MagicBag

These new items have the following features. As a hint, you will want an abstract class to put the behavior that is common to all (or most) of the box, bag, and magic bag in the abstract class. You will want to place the abstract class inside your heirarchy so that some of the behvior below is already done. That way you do not have to duplicate very much code.

1. A person can carry them
2. A person cannot eat them
3. Another item can be placed inside the bag, box, or magic bag (including another bag, box, or magic bag). Hint: you want a getter/setter method.
4. The bag, box, and magic bag has a _capacity_ and you can only place an item inside it if the item weighs less than the bag, box, or magic bag capacity.
5. The _weight_ of a bag or box is the weight of the empty bag or box plus the weight of what is inside it. (Hint: Override a method.)
6. The _weight_ of a magic bag is the weight of the empty magic bag plus half the weight of the item inside it. (Hint: Override a method.)
7. The toString method should change to include the item inside it. So, if a box is empty, the toString method should return "Box", but if it has a steak inside it, it should return "Box of Steak".

Compile and test your code.

## Task 9. Using Interfaces

**Switch roles, the driver should navigate and the navigator should drive.**

I want to add weapons to the game. But I want to allow lots of things to be weapons (but not everything). For example, besides the Sword and Hammer, we could allow things like a bag of rocks, or even a loaf of bread (because why not). We can't group all these different classes under a common abstract class as before without breaking our current hierarchy. Instead, we can designate items that are weapons using an _interface_.

1. Create a Weapon interface, set sword, hammer, bread, and bag to all be weapons.
2. Add the ability for a person to wield a weapon, but it should only be one of these four weapons.
3. Give each weapon a power rating. Because we are using an interface, you can only specify the getter method for the power rating in the interface. You will either need to do this without a field or find an appropriate place to put a field.
4. Have the power rating for a bag depend on the weight of the item inside the bag.

Compile and test your code.

---

## Task 5. Finishing Up

Both you and your lab partner should submit your lab. You should submit all the .java files you created. Please do that now.