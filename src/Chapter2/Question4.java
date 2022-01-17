package Chapter2;

import java.util.Scanner;

/*
An automobile is used for commuting purposes.
Write a program that takes as input the distance of the commute in miles,
the automobile's fuel consumption rates in mile per gallon, and the price of a gallon of gas.
The program should then output the cost of the commute.
*/
public class Question4
{
    public static void main(String[] args)
    {
        double distance, mpg, gasPrice;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the distance in miles:");
        distance = scn.nextDouble();
        System.out.print("Enter rate of the car (mpg):");
        mpg = scn.nextDouble();
        System.out.print("Enter the cost of one gallon:");
        gasPrice = scn.nextDouble();
        System.out.println("Cost of the commute:" +(distance / mpg * gasPrice));
    }
}
