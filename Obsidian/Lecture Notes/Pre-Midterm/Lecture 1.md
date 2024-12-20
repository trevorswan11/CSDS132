## Basic Computer Structure

A computer is composed of wires and switches.  Data is transmitted down wires and each wire can have two different values: on (has current) or off (no current).
So a wire transmits two different values: 1 (on) or 0 (off).
If we put 2 wires together, we get 4 different values: both off (00), both on (11), the first on and the second off (10), the first off and the second on (01).
If we put 3 wires together, we get 8 different values:  000, 001, 010, 011, 100, 101, 110, 111.  (Note that 8 = 2^3.)
If we put 8 wires together, we get 2^8 = 256 different values.

The main processing in a computer is done in the ALU (Arithmetic-Logic Unit) that is a part of the CPU (Central Processing Unit).  The ALU is made up of separate circuits
  to perform different tasks like addition, multiplication, etc.  The ALU has three sets of input wires and one set of output wires.  Two of the sets of input wires are
  for the data to the ALU (for example, if you are going to add two numbers, one number arrives in the first set of wires, and the other number on the second set).
  The third input set of wires controls which operation the ALU should perform.

x-bit Machines

We sometimes refer to machines as x-bit machines.  For example, your computer was probably advertised as a 64-bit machine (newer ones) or a 32-bit machine (older ones).  
The number refers to how many wires go into the computer circuits, and that means how much data the computer can process in one step.  
For example, in a 32-bit machine's each set of input wires to the ALU will consist of 32 wires and the output will also consist of 32 wires.

32 wires together is 32 bits of information, and that means each input can be one of 2^32 different values. 
  As a result, there is a limit to how many different values a computer can add (or subtract or multiply, etc) directly on the chip.
  If we need to do arithmetic on larger numbers, we need to write programs for it.

With a 64-bit machine, we get a lot more values (2^64 different values), but the same idea holds.  There are a limited number of values we can manipulate directly on the chip.  Anything more requires a program.

How a computer does a single operation:
  The input wires for the ALU are turned on/off depending on the desired input values.
  The control wires for the ALU are turned on/off depending on the operation being done (addition, multiplication, etc.)
  As the electricity from these wires passes through the ALU circuits, different switches are activated to perform the calculation, and the resulting output appears as the output wires turn on/off appropriately.
  The control unit has a crystal based clock (similar to what runs a wrist watch), and when enough time passes for the calculation to complete, the control unit takes the output values and stores them into an
   appropriate location of memory.
  The speed of calculation is determined by how long it takes the electric current of the input/control wires to traverse the ALU and reach the output.  Modern computers are so fast because these circuits are incredibly tiny.
   (Just for fun, your computer can probably add two integers in less than 1 billionth of a second.  How far does light travel in 1 billionth of a second?) 

Key idea to remember:
  All data on a computer is transferred by a group of wires.  Therefore all data (whether an integer, a fraction, a music file, etc.) is just a collection of 0's and 1's (is the wire off or on?)
  Even the signals that control the ALU are sent on groups of wires, and so those signals are 0's and 1's.

  We can think of the 0's and 1's as a number (in fact, as an integer) represented in base 2.
  Everything in a digital computer: the data, the commands that control the computer, the program, everything is just numbers.
  The computer does not know about music, pictures, games.  It only sees numbers represented in binary and all it can do is simple math operations like addition, multiplication, etc.
  It is up to us, the human programmers, to give meaning to these numbers.
