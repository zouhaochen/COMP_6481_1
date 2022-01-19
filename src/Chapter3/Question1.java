package Chapter3;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
The Babylonian algorithm to compute the square root of a positive number n is as follows:
1. Make a guess at the answer (you can pick n/2 as your initial guess)
2. Compute r = n / guess
3. Set guess = (guess + r)/2
4. Go back to step 2 until the last two guess values are within 1% of each other.
Write a program that inputs a double for n, iterates through the Babylonian algorithm until the guess is within 1%
of the previous guess and outputs the answer as a double to two decimal places.
*/
public class Question1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer to estimate the square root of: ");
        int n = input.nextInt();
        double guess = n / 2.0;
        double previous;

        System.out.println("Current guess: " +guess);
        do
        {
            double r = n / guess;
            previous = guess;
            guess = (guess +r)/2;
            System.out.println("Current guess: " +new DecimalFormat("0.00").format(guess));
        }
        while (Math.abs(guess-previous) > 0.01*previous);
        System.out.printf("The estimated square root of "+n+" is "+new DecimalFormat("0.00").format(guess));
    }
}
