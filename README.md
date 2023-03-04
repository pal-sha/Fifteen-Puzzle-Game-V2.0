## **Fifteen Puzzle Game - Java Object Oriented Programming V2.0**

**Date**: 03/03/2023

After a completing an assignment in my Java object-oriented programming class in which we had to write part of the program for the
Fifteen Puzzle game, I was motivated to complete this game all the way, with full real interaction, random board generator, GUI, and more. 

In the assignment, I am also implemented the following classes: ArrayIterator, RangeIterator, and PrimeNumbersIterator. 
These three classes were a part of an interface called IntegerIterator with three methods for each class (which I also implemented): hasnext, next, and reset.

The three classes that implemented the IntegerIterator interface are the following:

**1. ArrayIterator** 
   - Iterates over an integer array, both circular and non-circular

**2. RangeIterator**
   - Iterators over a range of integer values

**3. PrimeNumbersIterator**
   - Generates prime numbers and iterates over either an infinite or finite sequence of prime numbers (range can be specified for finite sequences)

Aside from these, the project also has the classes called FifteenPuzzlePlay and TestGamePlay, 
as well as a class for the exception IllegalMoveException (thrown in makeMove):

**1. FifteenPuzzlePlay**
   - Consists of the following constructor/methods:
     - FifteenPuzzlePlay: the constructor creates a randomized board with numbers between 0 and 15 (0 holds position that is blank).
       - First create an array list with numbers 0 to 15, which is converted into an integer list to be shuffled for a randomized order.
       - After being converted back into an array list, this randomized list is then loaded into a 2D integer array to construct the board.
     - makeMove: the four possible moves (up, down, right, and left) on the board were programmed 
     - isSolved: to check for solved state of board 
     - toString: to re-print board onto terminal in a proper format (see board1.txt for an example)

**2. TestGamePlay**
   - Implements the entire user interface and interactions which appear in terminal (GUI implementation is in progress).
   - New randomized game board is created, reads user input for which tile to move and in which direction in each move, checks for solved state, and continues game based on the result of this. 
  
As mentioned earlier, GUI implementation is in progress as well as the user ability to use computer keyboard to make move instead of typing choice into terminal.
