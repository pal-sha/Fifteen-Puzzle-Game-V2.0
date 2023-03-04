package Fifteenpuzzleplay;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FifteenPuzzlePlay
{

    public final static int UP = 0;
    public final static int DOWN = 1;
    public final static int LEFT = 2;
    public final static int RIGHT = 3;
    public final static int SIZE = 4;
    private int[][] intArr = new int[SIZE][SIZE]; // Creating 2D integer to store board


    // Constructor
    public FifteenPuzzlePlay() {

        Integer[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);

        intList.toArray(intArray);

        int index;
        int i;
        int j;

        for (index = 0; index < intArray.length; index++){
            for (i = 0; i < SIZE; i++){
                for (j = 0; j < SIZE; j++){
                    intArr[i][j] = intArray[index];
                    index++;
                }
            }
        }
    }

    // Function to program moves
    public void makeMove(int tile, int direction) throws IllegalMoveException {

        int initialRow = 0;
        int initialCol = 0;

        int newRow;
        int newCol;

        if (tile > 15 || tile < 1) {
            throw new IllegalMoveException("This is not a valid move!");
        }

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (tile == intArr[i][j]){
                    initialRow = i;
                    initialCol = j;
                    break;
                }
            }
        }

        switch (direction) {
            case 0: // direction = UP
                newRow = initialRow - 1;
                newCol = initialCol;
                break;
            case 1: // direction is DOWN
                newRow = initialRow + 1;
                newCol = initialCol;
                break;
            case 2: // direction is LEFT
                newRow = initialRow;
                newCol = initialCol - 1;
                break;
            case 3: // direction is RIGHT
                newRow = initialRow;
                newCol = initialCol + 1;
                break;
            default: // If direction requested is not valid
                throw new IllegalMoveException("This is not a valid move!");
        }

        if (newRow < 0 || newRow > 3 || newCol < 0 || newCol > 3){
            throw new IllegalMoveException("This is not a valid move!");
        }

        if (this.intArr[newRow][newCol] != 0) {
            throw new IllegalMoveException("This is not a valid move!");
        }

        this.intArr[newRow][newCol] = this.intArr[initialRow][initialCol];
        this.intArr[initialRow][initialCol] = 0; // Initial index is set to 0 i.e.

    }

    // Function to check for solved state
    public boolean isSolved(){

        // Solved state is when the next element after the current one is 1 greater than it
        // Loop stops the moment 15 is hit, indicating end of sequence
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.intArr[i][j] != 15) {
                    if (j != 3) {
                        if (this.intArr[i][j + 1] == this.intArr[i][j] + 1) {
                            j++;
                        } else {
                            return false;
                        }
                    } else {
                        if (this.intArr[i + 1][0] == this.intArr[i][j] + 1) {
                            j++; // Incrementing column value is next element is one more than current
                        } else {
                            return false;
                        }
                    }
                } else {
                    return true;
                }
            }
        }

        return false;

    }

    // Function to print array in correct format
    public String toString(){

        String addtoString = ""; // Creating string variable to hold array as it is concatenated

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (col < SIZE-1) { // Is end of row is not reached, place a "  " after each element added
                    if (this.intArr[row][col] == 0) {
                        addtoString = addtoString + "   "; // Adding "  " if that space is empty, i.e. that index value is 0 in int array
                    } else if (this.intArr[row][col] < 10) { // If number is single digit, add one space before it
                        addtoString = addtoString + " " + this.intArr[row][col] + " ";
                    } else { // If number is double digit, add two spaces before it
                        addtoString = addtoString + this.intArr[row][col] + " ";
                    }

                } else { // If end of row is reached, add a new line character after number
                    if (this.intArr[row][col] == 0) {
                        addtoString = addtoString + "  \n";
                    } else if (this.intArr[row][col] < 10) {
                        addtoString = addtoString + " " + this.intArr[row][col] + "\n";
                    } else {
                        addtoString = addtoString + this.intArr[row][col] + "\n";
                    }
                }
            }
        }

        return addtoString;
    }

}
