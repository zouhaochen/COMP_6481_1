package Chapter3;

import java.text.DecimalFormat;
import java.util.Random;

/*
In the game of craps, a pass line bet proceeds as follows:
Two six-sided dice are rolled;
the first roll of the dice in a craps round is called the "come out roll."
A come out roll of 7 or 11 automatically wins, and a come out roll of 2, 3, or 12 automatically loses.
If 4, 5, 6, 8, 9, or 10 is rolled on the come out roll, that number becomes "the point".
The player keeps rolling the dice util either 7 or the point is rolled.
If the point is rolled first, then the player wins the bet.
If a 7 is rolled first, then the player loses.

Write a program that simulates a game of craps using these rules without human input.
Instead of asking for a wager, the program should calculate whether the player would win or lose.
The program should simulated rolling the two  dice and calculate the sum.
Add a loop so that the program plays 10000 games.
Add counters that count how many times the player wins and how many times the player loose.
At the end of the 10000 games, compute the probability of winning [i.e., wins/(wins+losses)]
and output this value
*/
public class Question2
{
    public static void main(String[] args)
    {
        DecimalFormat g=new DecimalFormat("#.00%");

        int dice1 = 0;
        int dice2 = 0;

        int sum = 0;
        int point = 0;

        double win=0;
        double lose=0;

        Random ra = new Random();
        int r = ra.nextInt(6)+1;
        int y = ra.nextInt(6)+1;

        dice1=r;
        dice2=y;

        for(int i=1;i<=10000;i++)
        {
            dice1=ra.nextInt(6)+1;
            dice2=ra.nextInt(6)+1;
            sum=dice1+dice2;
            if(sum==7 || sum==11 )
            {
                win++;
            }
            else if(sum==2||sum==3||sum==12)
            {
                lose++;

            }
            else
                {
                    point=sum;
                    dice1=ra.nextInt(6)+1;
                    dice2=ra.nextInt(6)+1;
                    sum=dice1+dice2;
                    while(sum!=7 && sum!=point)
                    {
                        dice1=ra.nextInt(6)+1;
                        dice2=ra.nextInt(6)+1;
                        sum=dice1+dice2;
                    }
                    if(sum==7)
                    {
                        lose++;
                    }
                    else if(sum==point)
                    {
                        win++;
                    }
                    dice1=ra.nextInt(6)+1;
                    dice2=ra.nextInt(6)+1;
                }
        }
        double prob=(win/(lose+win));
        System.out.println("Won: "+win+" Lost:"+lose);
        System.out.println("Wining Percentage: "+g.format(prob));
        if(win>lose)
        {
            System.out.println("You Win!");
        }
        else
            {
                System.out.println("House Wins! and he will win more than you...");
            }
    }
}

class CrapGame
{
    public static void main(String[] args)
    {
        DecimalFormat diceFormat = new DecimalFormat("0.00");

        int dice1 = 0;
        int dice2 = 0;

        int sum = 0;
        int point = 0;

        double win = 0;
        double loose = 0;

        for(int i = 0; i < 10000; i++)
        {
            Random diceNumber = new Random();
            dice1 = diceNumber.nextInt(6)+1;
            dice2 = diceNumber.nextInt(6)+1;
            sum = dice1+dice2;

            if(sum==7||sum==11)
            {
                win++;
            }
            else if(sum==2||sum==3||sum==12)
            {
                loose++;
            }
            else
            {
                point = sum;
                dice1 = diceNumber.nextInt(6)+1;
                dice2 = diceNumber.nextInt(6)+1;
                sum = dice1+dice2;
                while(sum!=7 && sum!=point)
                {
                    dice1=diceNumber.nextInt(6)+1;
                    dice2=diceNumber.nextInt(6)+1;
                    sum=dice1+dice2;
                }
                if(sum==7)
                {
                    loose++;
                }
                else if(sum==point)
                {
                    win++;
                }
            }
        }
        double probability = (win/(win+loose));
        System.out.println(diceFormat.format(probability));
    }
}
