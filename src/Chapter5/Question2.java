package Chapter5;

import java.util.Scanner;

/*
Define a class called Fraction. This class is used to represent a ratio of two integers.
Include mutator methods that allow the user to set the numerator and the denominator.
Also include a method that displays the fraction on the screen as a ratio (e.g., 5/9).
This method does not need to reduce the fraction to lowest terms.
Include an additional method, equals that takes as input another Fraction and returns true
if the two fractions are identical and false if they are not.
This method should treat the fractions reduced to lowest terms;
that is, if one fraction is 20>60 and the other is 1>3, then the method should return true.
Embed your class in a test program that allows the user to create a fraction.
Then the program should loop repeatedly until the user decides to quit.
Inside the body of the loop, the program should allow the user to enter a target fraction into
an anonymous object and learn whether the fractions are identical.
*/
public class Question2
{
}

class Fraction
{
    private int numerator;
    private int denominator;

    public Fraction(int n, int d)
    {
        numerator = n;
        denominator = d;
    }

    public void setNumerator(int n)
    {
        numerator = n;
    }
    public void setDenominator(int d)
    {
        denominator = d;
    }

    public void displayFraction()
    {
        System.out.print(numerator + "/" + denominator);
    }

    public boolean equals(Fraction other)
    {
        int num1, num2;
        int num3, num4;
        int num5 = 1;
        for (int i = 2; i <= Math.min(numerator, denominator); i++)
        {
            if (numerator % i == 0 && denominator % i == 0)
                num5 = i;
        }

        num1 = numerator / num5;
        num2 = denominator / num5;

        int otherGcf = 1;
        for (int i = 2; i <= Math.min(other.numerator, other.denominator); i++)
        {
            if (other.numerator % i == 0 && other.denominator % i == 0)
                otherGcf = i;
        }

        num3 = other.numerator / otherGcf;
        num4 = other.denominator / otherGcf;

        return (num1 == num3 && num2 == num4);

    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int numerator, denominator;
        System.out.print("Enter target Fraction's Numerator: ");
        numerator = input.nextInt();
        System.out.print("Enter target Fraction's Denominator: ");
        denominator = input.nextInt();
        Fraction fraction = new Fraction(numerator, denominator);
        String choice = "y";

        do {
            System.out.print("Enter new numerator: ");
            int otherNumerator = input.nextInt();
            System.out.print("Enter new denominator: ");
            int otherDenominator = input.nextInt();
            Fraction otherFraction = new Fraction(otherNumerator, otherDenominator);
            if (fraction.equals(otherFraction)) {
                fraction.displayFraction();
                System.out.print(" is equal to ");
                otherFraction.displayFraction();
            } else

            {
                fraction.displayFraction();
                System.out.print(" is not equal to ");
                otherFraction.displayFraction();
            }
            System.out.println();
            System.out.print("Continue another operation? (Y/N) ");
            choice = input.next();
            System.out.println("--------------------------------");

        }
        while (choice.equals("y") || choice.equals("Y"));
    }
}
