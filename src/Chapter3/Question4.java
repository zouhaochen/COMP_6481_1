package Chapter3;

import java.util.Scanner;

/*
It is difficult to make a budget that spans several years,
because prices are not stable.
If your company needs 200 pencils, you cannot simply use this year's price
as the cost of pencils two years from now.
Because of inflation, the cost is likely to be higher than it is today.
Write a program to gauge the expected cost of an item in a specified number of years.
The program asks for the cost of the item, the number of years from now that the item will be purchased,
and the rate of inflation.
The program then outputs the estimated cost of the item after the specified period.
Have the user enter the inflation rate as a percentage, such as 5.6 (percentage).
Your program should then convert the percent to a fraction, such as 0.056 and
should use a loop to estimate the price adjusted for inflation.
*/
public class Question4
{
    public static void main(String[] args)
    {
        double cost, inflation;
        int years;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the cost :");
        cost = input.nextDouble();

        System.out.print("Enter the number of years:");
        years = input.nextInt();

        System.out.print("Enter the inflation rate:");
        inflation = input.nextDouble() * .01;

        for (int i = 0; i < years; i++)
            cost += cost * inflation;
        cost = (int) (cost * 100) / 100.0;
        System.out.println("Item will cost about $ " + cost + " in " + years + " years. " );
    }
}
