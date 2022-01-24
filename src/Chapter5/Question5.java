package Chapter5;

/*
Part One: Define a class named Money whose objects represent amounts of U.S. money.
The class should have two instance variables of type int for the dollars and cents in the amount of money.
Include a constructor with two parameters of type int for the dollars and cents,
one with one constructor of type int for an amount of dollars with zero cents, and a no-argument constructor.
Include the methods add and minus for addition and subtraction of amounts of money.
These methods should be static methods, should each have two parameters of type Money,
and return a value of type Money.
Include a reasonable set of accessor and mutator methods as well as the methods equals and toString.
Write a test program for your class.

Part Two: Add a second version of the methods for addition and subtraction.
These methods should have the same names as the static version
but should use a calling object and a single argument.
For example, this version of the add method (for addition) has a calling object and one argument.
So m1.add(m2) returns the result of adding the Money objects m1 and m2.
Note that your class should have all these methods; for example, there should be two methods named add.

Alternate Part Two: Add a second version of the methods for addition and subtraction.
These methods should have the same names as the static version
but should use a calling object and a single argument. The methods should be void methods.
The result should be given as the changed value of the calling object.
For example, this version of the add method (for addition) has a calling object and one argument.
Therefore, m1.add(m2); changes the values of the instance variables of m1
so they represent the result of adding m2 to the original version of m1.
Note that your class should have all these methods; for example, there should be two methods named add.
(If you want to do both Part Two and Alternate Part Two, they must be two classes.
You cannot include the methods from both Part Two and Alternate Part Two in a single class. Do you know why?)
*/
public class Question5
{
}
class Money
{
    private int dollars;
    private int cents;

    public Money()
    {
        dollars = 0;
        cents = 0;
    }

    public Money(int dollars)
    {
        this.dollars = dollars;
        cents = 0;
    }

    public Money(int dollars, int cents)
    {
        this.dollars = dollars;
        this.cents = cents;
        if (cents > 99)
        {
            int totalDollars = cents / 100;
            cents -= totalDollars * 100;
            dollars += totalDollars;
        }
    }

    public void setDollars(int newDollars)
    {
        dollars = newDollars;
    }

    public void setCents(int newCents)
    {
        cents = newCents;
        if (cents > 99)
        {
            int totalDollars = cents / 100;
            cents -= totalDollars * 100;
            dollars += totalDollars;
        }
    }

    public int getDollars()
    {
        return dollars;
    }

    public int getCents()
    {
        return cents;
    }

    public static Money add(Money initial, Money toAdd)
    {
        initial.dollars += toAdd.dollars;
        initial.cents += toAdd.cents;
        if (initial.cents > 99)
        {
            int totalDollars = initial.cents / 100;
            initial.cents -= totalDollars * 100;
            initial.dollars += totalDollars;
        }
        return initial;
    }

    public static Money subtract(Money initial, Money toSubtract)
    {
        if (initial.dollars < toSubtract.dollars
                || (initial.dollars == toSubtract.dollars && initial.cents < toSubtract.cents))
        {
            initial.dollars = 0;
            initial.cents = 0;
            return initial;
        }
        initial.dollars -= toSubtract.dollars;
        initial.cents -= toSubtract.cents;
        if (initial.cents < 0)
        {
            initial.cents += 100;
            initial.dollars--;
        }
        return initial;
    }

    public Money add(Money addAmount)
    {
        dollars += addAmount.dollars;
        cents += addAmount.cents;
        if (cents > 99)
        {
            int totalDollars = cents / 100;
            cents -= totalDollars * 100;
            dollars += totalDollars;
        }
        return this;
    }

    public Money subtract(Money subAmount)
    {
        if (dollars < subAmount.dollars || (dollars == subAmount.dollars && cents < subAmount.cents))
        {
            dollars = 0;
            cents = 0;
            return this;
        }
        dollars -= subAmount.dollars;
        cents -= subAmount.cents;
        if (cents < 0)
        {
            cents += 100;
            dollars--;
        }
        return this;
    }

    public boolean equals(Money other)
    {
        return (dollars == other.dollars) && (cents == other.cents);
    }

    public String toString()
    {
        return "$" + dollars + "." + cents;
    }

    public static class TestMoney
    {
        public static void main(String[] args)
        {
            Money a1 = new Money();
            Money a2 = new Money(1000);
            Money a3 = new Money(100, 25);
            System.out.println("Start initial Amounts :");
            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
            System.out.println();
            a1 = add(a1, a2);
            a3 = subtract(a3, a1);
            a2.add(a1);
            a2.subtract(a3);
            System.out.println("After adding and subtracting:");
            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
            System.out.println("--------------");
            Money amount4 = new Money(1, 50);
            System.out.println("Fourth amount Status:");
            System.out.println("Dollars: " + amount4.getDollars());
            System.out.println("Cents: " + amount4.getCents());
            if (amount4.equals(a2))
                System.out.println("Fourth Amount  is equal to second amount.");
            else
                System.out.println("Fourth Amount  is not equal to second amount");
        }
    }
}
