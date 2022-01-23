package Chapter3;

import java.util.Scanner;

/*
The Fibonacci numbers Fn are defined as follows:
The first few Fibonacci numbers are 1, 1, 2, 3, 5, and 8.
One place where these numbers occur is as certain population growth rates.
If a population has no deaths, then the series shows the size of the population after each time period.
It takes an organism two time periods to mature to reproducing age,
and then the organism reproduces once every time period.
The formula applies most straightforwardly to asexual reproduction at a rate of one offspring per time period.
In any event, the green crud population grows at this rate and has a time period of five days.
Hence, if a green crud population starts out as 10 pounds of crud,
then in 5 days, there is still 10 pounds of crud;
in 10 days, there is 20 pounds of crud;
in 15 days, 30 pounds; in 20 days, 50 pounds; and so forth.
Write a program that takes both the initial size of a green crud population (in pounds)
and a number of days as input and outputs the number of pounds of green crud after that many days.
Assume that the population size is the same for four days and then increases every fifth day.
Your program should allow the user to repeat this calculation as often as desired.
*/
public class Question6
{
}

class GreenCrudPopulation
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        char repeat;

        do
        {
            System.out.print("Enter the initial size of a green crud population (in pounds): ");
            int initialPopulation = keyboard.nextInt();

            System.out.print("Enter the number of days: ");
            int numberOfDays = keyboard.nextInt();

            int f0 = 0;
            int f1 = initialPopulation;
            int f2 = f1 + f0;

            for (int day = 1; day <= numberOfDays; day++)
            {
                if (day % 5 == 0)
                {
                    f2 = f1 + f0;
                    f0 = f1;
                    f1 = f2;
                }
            }

            System.out.println("The number of pounds of green crud after " + numberOfDays + " days: " + f2);

            System.out.print("\nEnter 'y' or 'Y' to repeat: ");
            repeat = keyboard.next().charAt(0);
            System.out.println();
        }
        while (repeat == 'Y' || repeat == 'y');

        keyboard.close();
    }
}