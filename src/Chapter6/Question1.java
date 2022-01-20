package Chapter6;

import java.util.Scanner;

/*
In the sport of diving, seven judges award a score between 0 and 10,
where each score may be a floating-point value.
The highest and lowest scores are thrown out, and the remaining scores are added together.
The sum is then multiplied by the degree of difficulty for that dive.
The degree of difficulty ranges from 1.2 to 3.8 points.
The total is the multiplied by 0.6 to determine the diver's score

Write a computer program that inputs a degree of difficulty and seven judges' scores and
outputs the overall score for that dive.
The program should ensure that all inputs are within the allowable data ranges.
*/
public class Question1
{
    public static void main(String[] args)
    {
        final int MAXIMUM_SCORES = 7;
        Scanner keyboard = new Scanner(System.in);

        double divingScores[] = new double[MAXIMUM_SCORES];
        double difficulty;

        System.out.print("Please enter the difficulty level (1.2 - 3.8): ");
        difficulty = keyboard.nextDouble();

        while(difficulty < 1.2 || difficulty > 3.8)
        {
            System.out.print("Please enter the valid difficulty level: ");
            difficulty = keyboard.nextDouble();
        }

        for(int i = 0; i < MAXIMUM_SCORES; i++)
        {
            System.out.print("Enter the score of judge " + (i + 1) + " (0 - 10): ");
            divingScores[i] = keyboard.nextDouble();

            while(divingScores[i] < 1 || divingScores[i] > 10)
            {
                System.out.print("Enter the valid score of judge " + (i + 1) + ": ");
                divingScores[i] = keyboard.nextDouble();
            }
        }

        double minimum = divingScores[0];
        double maximum = divingScores[0];
        double total = 0;

        for(int i = 0; i < MAXIMUM_SCORES; i++)
        {
            if(divingScores[i] < minimum)
                minimum = divingScores[i];

            if(divingScores[i] > maximum)
                maximum = divingScores[i];

            total = total + divingScores[i];
        }

        total = total - maximum - minimum;
        total = total * difficulty;
        total = total * 0.6;

        System.out.printf("\nThe overall score for the dive: %.1f\n", total);
    }
}
