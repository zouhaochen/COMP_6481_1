package Chapter4;

public class Question5
{
}

/**
 * Define a class called Counter whose objects count things.
 * An object of this class records a count that is a non negative integer.
 * Include methods to set the counter to 0, to increase the count by 1, and to decrease the count by 1.
 * Be sure that no method allows the value of the counter to become negative.
 * Include an accessor method that returns the current count value and
 * a method that outputs the count to the screen.
 * There should be no input method or other mutator methods.
 * The only method that can set the counter is the one that sets it to 0.
 * Also, include a toString method and an equals method.
 * Write a program (or programs) to test all the methods in your class definition.
 */
class Counter
{
    private int count;

    // Default constructor
    public Counter ()
    {
        count = 0;
    }

    // Reset count
    public void resetCounter()
    {
        this.count = 0;
    }

    // Increase by 1
    public void incrementCounter()
    {
        this.count++;
    }

    // Decrease by 1
    public void decrementCounter()
    {
        if (this.count < 0)
        {
            System.out.println("Error");
            System.exit(-2);
        }
        else
            this.count--;
    }

    // Accessor method
    public int showCount()
    {
        // Send copy and display count
        int c = this.count;
        System.out.println(count);
        return c;
    }

    // To string
    public String toString()
    {
        return "" + this.count;
    }

    // does count equal to a certain number?
    public boolean equals(Counter other)
    {
        return (this.count == other.count);
    }
}

class MainQuestion5
{
    public static void main(String[] args)
    {
        // Test methods
        Counter c = new Counter();
        Counter c2 = new Counter();

        c.incrementCounter();
        c.incrementCounter();
        c.incrementCounter();
        c.incrementCounter();// should be 4
        c2.incrementCounter();
        c2.incrementCounter();
        c2.incrementCounter();
        c2.incrementCounter();// should be 4
        c.showCount();
        c2.showCount();
        if(c.equals(c2))
            System.out.println("True");
        else
            System.out.println("False");

        c.decrementCounter();
        c.decrementCounter();
        c.decrementCounter();
        c.showCount();
        c2.showCount();
        if(c.equals(c2))
            System.out.println("True");
        else
            System.out.println("False");
    }
}