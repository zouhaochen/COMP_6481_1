package Chapter6;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Write a program that will allow two users to play tic-tac-toe.
The program should ask for moves alternately from player X and player O.
The program displays the game positions as follows:
1 2 3
4 5 6
7 8 9

The players enter their moves by entering the position number they wish to mark.
After each move, the program displays the changed board. A sample board configuration is
X X O
4 5 6
O 8 9
*/
public class Question10
{
}
class TikTacToe
{
    // Declare array for game board
    static String[] gameBoard;

    // Create a string to store the player turns
    static String playerTurn;

    // This method is used to check the winner
    static String checkWinner()
    {
        // This for-loop is used to check the each cell in the game board
        for (int a = 0; a < 8; a++)
        {
            String eachRow = null;
            // Create a switch-statement to check each row
            switch (a)
            {
                case 0:
                    eachRow = gameBoard[0] + gameBoard[1] + gameBoard[2];
                    break;
                case 1:
                    eachRow = gameBoard[3] + gameBoard[4] + gameBoard[5];
                    break;
                case 2:
                    eachRow = gameBoard[6] + gameBoard[7] + gameBoard[8];
                    break;
                case 3:
                    eachRow = gameBoard[0] + gameBoard[3] + gameBoard[6];
                    break;
                case 4:
                    eachRow = gameBoard[1] + gameBoard[4] + gameBoard[7];
                    break;
                case 5:
                    eachRow = gameBoard[2] + gameBoard[5] + gameBoard[8];
                    break;
                case 6:
                    eachRow = gameBoard[0] + gameBoard[4] + gameBoard[8];
                    break;
                case 7:
                    eachRow = gameBoard[2] + gameBoard[4] + gameBoard[6];
                    break;
            }

            // Check for X winner
            if (eachRow.equals("XXX"))
            {
                return "X";
            }

            // check for O winner
            else if (eachRow.equals("OOO"))
            {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++)
        {
            if (Arrays.asList(gameBoard).contains(String.valueOf(a + 1)))
            {
                break;
            } else if (a == 8)
            {
                return "draw";
            }
        }
        System.out.println(playerTurn + "'s playerTurn; enter a slot number to place " + playerTurn + " in:");
        return null;
    }


    // Display board
    static void printgameBoard()
    {
        System.out.println();
        System.out.println(" " + gameBoard[0] + " " + gameBoard[1] + " " + gameBoard[2] + " ");
        System.out.println(" " + gameBoard[3] + " " + gameBoard[4] + " " + gameBoard[5] + " ");

        System.out.println(" " + gameBoard[6] + " " + gameBoard[7] + " " + gameBoard[8] + " ");
        System.out.println();
    }

    // Create a main method to run the program.
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        gameBoard = new String[9];
        playerTurn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++)
        {
            gameBoard[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to Tic Tac Toe.");
        printgameBoard();

        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner == null)
        {
            int numInput;

            // Create a try-block to handle exceptions
            try
            {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9))
                {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }

            // This game has two player x and O.
            // Create an if-statement to check the playerTurn.
            if (gameBoard[numInput - 1].equals(String.valueOf(numInput)))
            {
                gameBoard[numInput - 1] = playerTurn;

                if (playerTurn.equals("X"))
                {
                    playerTurn = "O";
                } else
                {
                    playerTurn = "X";
                }

                printgameBoard();
                winner = checkWinner();
            } else
            {
                System.out.println("Slot already taken; re-enter slot number:");
            }
        }

        // Check the game is draw or not.
        if (winner.equalsIgnoreCase("draw"))
        {
            System.out.println("It's a draw! Thanks for playing.");
        }

        // Display winner.
        else
        {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
    }
}
