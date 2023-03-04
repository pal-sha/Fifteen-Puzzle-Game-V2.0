import Fifteenpuzzleplay.BadBoardException;
import Fifteenpuzzleplay.FifteenPuzzlePlay;
import Fifteenpuzzleplay.IllegalMoveException;

import java.io.IOException;
import java.util.Scanner;

public class TestGamePlay {

    public static void main(String[] args) throws IllegalMoveException, BadBoardException, IOException {

        int userInput = 0;
        
        while (userInput != 2){
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("FIFTEEN PUZZLE!!!!");
            System.out.println("Solve the scrambled board and order the numbers correctly.");
            System.out.println("The only valid moves are: UP, DOWN, RIGHT and LEFT");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

            FifteenPuzzlePlay newBoard = new FifteenPuzzlePlay();

            System.out.println("NEW GAME STARTED.");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.print(newBoard);
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

            while (!newBoard.isSolved()){

                int userTile;
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Please enter which tile you want to move: ");
                userTile = sc1.nextInt();

                if (userTile <= 0 || userTile >= 16 ){
                    System.out.println("This is an invalid tile number! Please try again!");
                    System.out.println("Please enter which tile you want to move: ");
                    userTile = sc1.nextInt();
                }

                int userDirection;
                Scanner sc2 = new Scanner(System.in);
                printMoveMenu();

                userDirection = sc2.nextInt();

                if (userDirection != 0 && userDirection != 1 && userDirection != 2 && userDirection != 3){
                    printMoveMenu();
                    userDirection = sc2.nextInt();
                }

                boolean success = false;
                while (!success) {
                    try {
                        newBoard.makeMove(userTile, userDirection);
                        success = true;
                    } catch (IllegalMoveException i) {
                       printMoveMenu();
                       userDirection = sc2.nextInt();
                    }
                }

                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                System.out.print(newBoard);
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

                if (newBoard.isSolved()) {
                    break;
                }
            }

            Scanner sc3 = new Scanner(System.in);
            System.out.println("You have solved the puzzle! :D");
            System.out.println("To play a new game, enter 1.");
            System.out.println("To play exit, enter 2.");
            userInput = sc3.nextInt();

            if (userInput != 1 && userInput != 2) {
                System.out.println("Invalid input. Please enter again.");
                System.out.println("To play a new game, enter 1.");
                System.out.println("To play exit, enter 2.");
                userInput = sc3.nextInt();
            }
        }

        System.out.println("Thanks for playing! See you next time!");
    }

    public static void printMoveMenu(){
        System.out.println("This is an invalid move! Please try again!");
        System.out.println("Please enter which direction you want to move the tile.");
        System.out.println("Enter 0 for UP");
        System.out.println("Enter 1 for DOWN");
        System.out.println("Enter 2 for LEFT");
        System.out.println("Enter 3 for RIGHT.");
    }
}
