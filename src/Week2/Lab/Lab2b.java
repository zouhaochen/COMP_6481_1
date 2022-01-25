package Week2.Lab;

import java.util.Scanner;

/*
“Snakes and ladders” is a very popular game. It uses a 10x10 maze, with cells numbered from 1 to 100,
and populated with snakes and ladders. A sample game is shown in the figure below.
Every player gets a chance to play and advance in the maze,
depending on the number they get on the six-sided dice when thrown.

The advancement is in the increasing order from 1 to 100.
All players start from cell numbered 1 and attempt to reach to cell numbered 100.
The player who reaches first to cell number 100, is the winner.
If the game is stopped in between, the player closest to cell 100 in number is the winner.
Assume that both players will never be on the same cell when the game is stopped.

If a player lands on a snake head, then the player gets a penalty to retreat to tail of the snake.
If a player reaches foot of a ladder, then the player climbs directly to the top of the ladder.
This is repeated if there exists another snake (or ladder) at the new cell.
A cell will never have a mouth of a snake and a foot of a ladder simultaneously.

Write a Java program to simulate the game for a given number of moves.
There will be two players, named A and B, who throw the dice alternately.
Program should output the name of the player at the highest position (closest to 100),
along with the player's cell number.

Input:
The first line of input will contain a single integer N.
Next N lines each will contain a pair of integers.
Each pair will describe either a snake or ladder by its start cell and an end cell.
For a snake, start cell will be higher than end cell and vice versa for a ladder.

Following line of input has a single integer D,
indicating the number of moves (dice throws) made by both players A and B.
Last line contains D integers, each indicating a dice throw, alternately made by A and B.
First throw is made by player A. Each dice throw is an integer between 1 and 6.

Output:
Your program should output the name of the winner (A or B) followed by the player’s position
at the end of game, with a single space in between.
*/
public class Lab2b
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int numberInput = 0;

        try
        {
            numberInput = keyboard.nextInt();
        }
        catch (Exception e)
        {
            System.exit(0);
        }
        keyboard.nextLine();

        if (numberInput<0)
        {
            System.exit(0);
        }

        String[] intPairInString = new String[numberInput];
        int[][] startAndEndList = new int[numberInput][2];
        String startInString;
        String endInString;
        int startInInt = 0;
        int endInInt = 0;

        for (int i = 0; i < intPairInString.length; i++)
        {
            intPairInString[i] = keyboard.nextLine();

            if(intPairInString[i].length() < 3 || intPairInString[i].length() > 6)
            {
                System.exit(0);
            }

            String[] pair = intPairInString[i].split(" ");
            startInString = pair[0];
            endInString = pair[1];

            if(startInString.length() < 1 || startInString.length() > 2)
            {
                System.exit(0);
            }
            if(endInString.length() < 1 || endInString.length() > 2)
            {
                System.exit(0);
            }

            try
            {
                startInInt = Integer.parseInt(startInString);
                endInInt = Integer.parseInt(endInString);
            }
            catch (Exception e)
            {
                System.exit(0);
            }

            if(startInInt<1||startInInt>100)
            {
                System.exit(0);
            }

            if(endInInt<1||endInInt>100)
            {
                System.exit(0);
            }

            startAndEndList[i][0] = startInInt;
            startAndEndList[i][1] = endInInt;
        }

        int sumA = 1;
        int sumB = 1;

        int move = 0;
        try
        {
            move = keyboard.nextInt();
        }
        catch (Exception e)
        {
            System.exit(0);
        }

        keyboard.nextLine();
        if(move < 1)
        {
            System.exit(0);
        }

        int[] moveList = new int[move];

        for(int i = 0; i < moveList.length; i++)
        {
            try
            {
                moveList[i] = keyboard.nextInt();
            }
            catch (Exception e)
            {
                System.exit(0);
            }

            if(moveList[i] < 1 || moveList[i] > 6)
            {
                System.exit(0);
            }
        }

        for(int i = 0; i < moveList.length; i++)
        {
            if (i % 2 == 0)
            {
                sumA = sumA + moveList[i];

                int j = 0;
                while(j<startAndEndList.length)
                {
                    if(startAndEndList[j][0] == sumA)
                    {
                        sumA = startAndEndList[j][1];
                        j = 0;
                    }
                    else
                    {
                        j++;
                    }
                }
            }
            else
            {
                sumB = sumB + moveList[i];

                int j = 0;
                while(j<startAndEndList.length)
                {
                    if(startAndEndList[j][0] == sumB)
                    {
                        sumB = startAndEndList[j][1];
                        j = 0;
                    }
                    else
                    {
                        j++;
                    }
                }
            }
        }

        if(sumA > sumB)
        {
            System.out.println("A "+sumA);
        }
        else if(sumA < sumB)
        {
            System.out.println("B "+sumB);
        }
        else if (sumA == sumB)
        {
            System.exit(0);
        }
    }
}
