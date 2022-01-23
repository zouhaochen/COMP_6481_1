package Chapter3;

import java.util.Scanner;

/*
The value can be approximated by the following sum:
Write a program that takes a value x as input and outputs this sum for n taken to be
each of the values 1 to 10, 50, and 100.
Your program should repeat the calculation for new values of x until the user says she or he is through.
The expression n! is called the factorial of n and is defined as
n! = 1 * 2 * 3 * ... * n
Use variables of type double to store the factorials
(or arrange your calculation to avoid any direct calculation of factorials);
otherwise, you are likely to produce integer overflow, that is, integers larger than Java allows.
*/
public class Question7
{
}

class ExpX
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int x;
        int n;
        int k;
        double fact;
        double result;
        char repeat;

        do
        {
            System.out.print("Enter a value of x: ");
            x = keyboard.nextInt();

            result = 0;

            for (n = 0; n <= 100; n++)
            {
                fact = 1;

                for (k = 1; n > 0 && k <= n; k++)
                {
                    fact = fact * k;
                }

                result += Math.pow(x, n) / fact;

                if((n >= 1 && n <= 10) || n == 50 || n == 100)
                {
                    System.out.println("At n = " + n + ", e^" + x + " = " + result);
                }
            }

            System.out.print("\nEnter 'y' or 'Y' to repeat: ");
            repeat = keyboard.next().charAt(0);
            System.out.println();
        }
        while(repeat == 'y' || repeat == 'Y');

        keyboard.close();
    }
}