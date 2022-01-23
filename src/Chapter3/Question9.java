package Chapter3;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
Write a program that calculates the total grade for N classroom exercises as a percentage.
Use the DecimalFormat class to output the value as a percent.
The user should input the value for N followed by each of the N scores and totals.
Calculate the overall percentage (sum of the total points earned divided by the total points possible)
and output it using the DecimalFormat class. Sample input and output is shown below.
How many exercises to input?
3
Score received for exercise 1:
10
Total points possible for exercise 1:
10
Score received for exercise 2:
7
Total points possible for exercise 2:
12
Score received for exercise 3:
5
Total points possible for exercise 3:
8
Your total is 22 out of 30, or 73.33%.
*/
public class Question9
{
}
class ExercisesPercentage
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        DecimalFormat percent=new DecimalFormat("00.00%");
        int num_exercise,score,points,total_score=0,total_points=0;

        System.out.println("How many exercises to input?");
        num_exercise=input.nextInt();

        for(int i=1;i<=num_exercise;i++)
        {
            System.out.println("Score received for exercise "+i+" :");
            score=input.nextInt();

            System.out.println("Total points possible for exercise "+i+" :");
            points=input.nextInt();

            total_score+=score;
            total_points+=points;
        }
        System.out.println("Your total "+total_score+" out of "+total_points+", or "+percent.format((double)total_score/total_points )+".");
    }

}