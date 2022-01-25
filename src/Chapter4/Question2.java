package Chapter4;

public class Question2 {
}

/**
 * Define a class called Fraction. This class is used to represent a ratio of two integers.
 * Include mutator methods that allow the user to set the numerator and the denominator.
 * Also include a method that returns the value of numerator divided by denominator as a double.
 * Include an additional method that outputs the value of the fraction reduced to lowest terms.
 * This will require finding the greatest common divisor for the numerator and denominator,
 * then dividing both by that number. Embed your class in a test program.
 */

class Fraction
{
    //Instance variables
    private int num;
    private int den;

    //------Constructors------
    // Default
    public Fraction()
    {
        num = den = 1;
    }

    // 1 argument
    public Fraction(int x)
    {
        num = x;
        den = 1;
    }

    // 2 arguments
    public Fraction(int x, int y)
    {
        num = x;
        den = y;
    }

    //------Accessor Methods------
    // Return numerator
    public int getNum()
    {
        return num;
    }

    // Return denominator
    public int getDen()
    {
        return den;
    }

    //------Mutator Methods------
    // Change Numerator
    public void changeNum(int x)
    {
        num = x;
    }

    // Change Denominator
    public void changeDen(int y)
    {
        den = y;
    }

    //------Helper Methods------
    // Method to get greatest common divisor
    private int gcd(int x, int y)
    {
        int rem;

        // Check if dividing by 0
        if(y == 0)
            System.out.println("Error: Divisor = 0");

        // while there is a remainder gcd not found
        //  - make y the dividend
        //  - make rem the divisor
        //  - if rem != 0 repeat until so
        //      - when rem = 0, that means y is the gcd
        //      - return y
        rem = x % y;
        while (rem > 0)
        {
            x = y;
            y = rem;
            rem = x % y;
        }
        // when comes out of loop y contains gcd
        return y;
    }

    // Method to display value of ratio as a double
    public double doubleResult()
    {
        double x = num;
        double y = den;

        return (x/y);
    }

    // Method to reduce numerator
    public int reducedNum()
    {
        // get the gcd
        int gcd = Fraction.this.gcd(num,den);
        // return
        return num/gcd;
    }

    // Method to reduce denominator
    public int reducedDen()
    {
        // get the gcd
        int gcd = Fraction.this.gcd(num,den);
        // return
        return den/gcd;
    }
}

class QuestionMain
{
    public static void main(String[] args)
    {
        // write your code here
        // declare a var of type Fraction
        Fraction fraction = new Fraction(40,10);

        System.out.println("Numerator:           " + fraction.getNum());
        System.out.println("Denominator:         " + fraction.getDen());
        System.out.println("Double result:       " + fraction.doubleResult());
        System.out.println("Reduced numerator:   " + fraction.reducedNum());
        System.out.println("Reduced denominator: " + fraction.reducedDen());

    }
}