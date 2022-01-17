package Chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
The straight-line method for computing the yearly depreciation in value D for an item is given by the following formula.
where P is the purchase price, S is the salvage value, and Y is the number of years the item is used.
Write a program that takes as input the purchase price of an item, the expected number of year of service,
and the expected salvage value. The program should then output the yearly depreciation for the item
*/
public class Question5
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        DecimalFormat pattern0dot00 = new DecimalFormat("0.00");

        System.out.print("Enter the purchase price of an item: ");
        double P = keyboard.nextDouble();

        System.out.print("Enter the expected number of years of service: ");
        double Y = keyboard.nextDouble();

        System.out.print("Enter the expected salvage value: ");
        double S = keyboard.nextDouble();

        double D = (P - S) / Y;

        System.out.println("\nThe yearly depreciation for the item: "
                + pattern0dot00.format(D));

        keyboard.close();
    }
}
