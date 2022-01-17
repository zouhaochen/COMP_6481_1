package Chapter2;

import java.util.Scanner;

/*
The Babylonian algorithm to compute the square root of a positive number n is as follows:
1. Make a guess at the answer (you can pick n/2 as your initial guess)
2. Compute r = n / guess
3. Set guess = (guess + r)/2
4. Go back to step 2 for as many iterations as necessary.
The more you repeat steps 2 and 3, the closer guess will be most accurate for small values of n
Write a program that inputs a double for n, iterates through the Babylonian algorithm five times,
and outputs the answer as a double to two decimal places.
Your answer will be most accurate for small values of n
*/
public class Question1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        double n;
        double guess;
        double r;

        System.out.print("Enter a value for n: ");
        n = keyboard.nextDouble();

        guess = n / 2;

        r = n / guess;
        guess = (guess + r) / 2.0;

        r = n / guess;
        guess = (guess + r) / 2.0;

        r = n / guess;
        guess = (guess + r) / 2.0;

        r = n / guess;
        guess = (guess + r) / 2.0;

        r = n / guess;
        guess = (guess + r) / 2.0;

        System.out.printf(
                "The square root of %.2f is approximately: %.2f\n", n, guess);
    }
}
