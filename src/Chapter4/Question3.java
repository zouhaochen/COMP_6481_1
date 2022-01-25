package Chapter4;
import java.security.PrivateKey;
import java.util.Scanner;

public class Question3
{
}

/**
 * Define a class called Odometer that will be used to track fuel and mileage for an automobile.
 * The class should have instance variables to track the miles driven and
 * the fuel efficiency of the vehicle in miles per gallon.
 * Include a mutator method to reset the odometer to zero miles, a mutator method to set the fuel efficiency,
 * a mutator method that accepts miles driven for a trip and adds it to the odometer’s total,
 * and an accessor method that returns the number of gallons of gasoline that
 * the vehicle has consumed since the odometer was last reset.
 * Use your class with a test program that creates several trips with different fuel efficiencies.
 * You should decide which variables should be public, if any.
 */
class Odometer
{
    // Instance Variables
    private int milesDriven;
    private double fuelEfficiency;

    // ---------- Constructors ----------
    // Default Constructor
    public Odometer()
    {
        milesDriven = 0;
        fuelEfficiency = 1.0;
    }

    // Mutator Methods
    // Method to reset odometer to 0
    public void reset()
    {
        milesDriven = 0;
    }

    //Method to set the fuel efficiency
    public void setFuelEfficiency(double f)
    {
        fuelEfficiency = f;
    }

    //Method to add miles driven to a trip
    public void milesDriven(int m)
    {
        milesDriven = milesDriven + m;
    }

    // method to calculate gallons consumed
    public double gallonsUsed()
    {
        double galUsed = milesDriven/fuelEfficiency;
        return galUsed;
    }
}

class MainQuestion3
{
    public static void main(String[] args)
    {
        boolean flag = true;
        int choice;
        Scanner keyboard = new Scanner(System.in);

        // write your code here
        // create an object of odomoter
        Odometer odometer = new Odometer();

        // Keep showing options until exit
        while(flag)
        {
            // Menu
            System.out.println("Please choose an option:\n");

            System.out.println("1) Enter mileage\n" +
                    "2) Enter fuel efficiency (Miles/Gallon)\n" +
                    "3) Calculate gallons of gas used since last reset\n" +
                    "4) Reset Odometer\n" +
                    "5) Quit");
            // Get user input
            choice = keyboard.nextInt();

            // Switch statements to pick right choice
            switch (choice)
            {
                case 1:
                    System.out.print("Enter mileage: ");
                    odometer.milesDriven(keyboard.nextInt());
                    break;
                case 2:
                    System.out.print("Enter fuel efficiency: ");
                    odometer.setFuelEfficiency(keyboard.nextDouble());
                    break;
                case 3:
                    System.out.println("Gallons used: " + odometer.gallonsUsed());
                    break;
                case 4:
                    System.out.println("Odometer was reset.");
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        System.out.print("Goodbye");
    }
}