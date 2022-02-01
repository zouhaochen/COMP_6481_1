package Chapter9;

import java.util.Scanner;
import java.util.InputMismatchException;

/*
Write a program that calculates the average of N integers.
The program should prompt the user to enter the value for N and then afterward must enter all N numbers.
If the user enters a non positive value for N, then an exception should be thrown (and caught)
with the message “N must be positive.” If there is any exception as the user is entering the N numbers,
an error message should be displayed, and the user prompted to enter the number again.
 */
public class Question1
{
}

class AverageCalculate
{
    public static void main(String args[])
    {
        double total = 0, N, userInput;
        Scanner input = new Scanner(System.in);
        while (true)
        {
            System.out.print("Enter how many numbers(N) to calculate average:");
            userInput = input.nextDouble();
            if (userInput > 0)
            {
                N = userInput;
                break;
            }
            else
                System.out.println("N must be positive.");
        }
        for (int i = 0; i < N; i++)
        {
            while (true)
            {
                System.out.print("Enter number:");
                try
                {
                    userInput = input.nextDouble();
                    total += userInput;
                    break;

                }
                catch (InputMismatchException e)
                {
                    input.nextLine();
                    System.out.println("Input must be a number. Try again");
                }
            }
        }
        System.out.println("Average: "+ total / N);
    }
}