package Chapter3;

import java.util.Random;
import java.util.Scanner;

/*
The game of Pig is a simple two-player dice game in which the first player to reach 100 or more points wins.
Players take turns. On each turn, a player rolls a six-sided die:
If the player rolls a 1, then the player gets no new points and it becomes the other player’s turn.
If the player rolls 2 through 6, then he or she can either ROLL AGAIN or HOLD.
At this point, the sum of all rolls is added to the player’s score and it becomes the other player’s turn.
Write a program that plays the game of Pig, where one player is a human and the other is the computer.
When it is the human’s turn, the program should show the score of both players and the previous roll.
Allow the human to input “r” to roll again or “h” to hold.
The computer program should play according to the following rule:
Keep rolling when it is the computer’s turn until it has accumulated 20 or more points, then hold.
If the computer wins or rolls a 1, then the turn ends immediately. Allow the human to roll first.
*/
public class Question10 {
}

class GameOfPig
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner keyboard = new Scanner(System.in);

        int humanTotalScore = 0;
        int compTotalScore = 0;
        int compSubTotal = 0;
        boolean run = true;
        String response;
        int roll = 0;

        do
        {
            System.out.println("*** Human's Turn ***");
            run = true;
            do
            {
                roll = 1 + rand.nextInt(6);
                System.out.println("Human rolled " + roll + ".");

                if (roll == 1)
                {
                    System.out.println("Human's score: " + humanTotalScore
                            + " and Computer's score: " + compTotalScore);
                    run = false;
                }
                else
                {
                    humanTotalScore += roll;
                    System.out.println("Human's score: " + humanTotalScore
                            + " and Computer's score: " + compTotalScore);

                    if (humanTotalScore >= 100)
                    {
                        run = false;
                    }
                    else
                    {
                        System.out.print("Enter 'r' to roll again or 'h' to hold: ");
                        response = keyboard.next();
                        if (response.equalsIgnoreCase("h"))
                        {
                            run = false;
                        }
                    }
                }
            }
            while (run);

            if (humanTotalScore < 100)
            {
                System.out.println("\n*** Computer's Turn ***");

                compSubTotal = 0;
                run = true;
                do
                {
                    roll = 1 + rand.nextInt(6);
                    System.out.println("Computer rolled " + roll + ".");

                    if (roll == 1)
                    {
                        System.out.println("Human's score: " + humanTotalScore
                                + " and Computer's score: " + compTotalScore);
                        run = false;
                    }
                    else
                    {
                        compSubTotal += roll;
                        compTotalScore += roll;
                        System.out.println("Human's score: " + humanTotalScore
                                + " and Computer's score: " + compTotalScore);

                        if (compSubTotal >= 20)
                        {
                            System.out.println("Computer's subtotal >= 20.");
                            run = false;
                        }

                        if (compTotalScore >= 100)
                        {
                            run = false;
                        }
                    }
                }
                while (run && compSubTotal < 20);
            }
            System.out.println();
        }
        while (humanTotalScore < 100 && compTotalScore < 100);

        if (humanTotalScore >= 100)
            System.out.println("Human wins the game!");
        else
            System.out.println("Computer wins the game!");

        keyboard.close();
    }
}
