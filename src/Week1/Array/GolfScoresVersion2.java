package Week1.Array;

import java.util.Scanner;

public class GolfScoresVersion2
{
    int maxCapacity;
    public static final int MAX_NUMBER_SCORES = 10;

    /*
    Show the difference between each of a list of golf scores and their average
     */
    public static void main(String[] args)
    {
        PartiallyFilledArray score = new PartiallyFilledArray(MAX_NUMBER_SCORES);

        System.out.println("This program reads golf scores and shows how much each differs from the average.");
        System.out.println("Enter golf scores:");

        fillArray(score);
        showDifference(score);
    }

    /*
    Reads values into the PartiallyFilledArray a.
     */
    public static void fillArray(PartiallyFilledArray a)
    {
        System.out.println("Enter up to "+a.getMaxCapacity()+" non negative numbers, one per line.");
        System.out.println("Mark the end of the list with a negative number");

        Scanner keyboard = new Scanner(System.in);
        double next = keyboard.nextDouble();

        while((next>=0)&&(!a.full()))
        {
            a.add(next);
            next = keyboard.nextDouble();
        }

        if(next>=0)
            System.out.println("Could only read in "+a.getMaxCapacity()+" input values.");
    }

    /*
    Returns the average of numbers in the PartiallyFilledArray a
     */
    public static double computeAverage(PartiallyFilledArray a)
    {
        double total = 0;
        for(int index = 0; index < a.getNumberOfElement(); index++)
            total = total + a.getElement(index);
        if(a.getNumberOfElement() > 0)
        {
            return (total/a.getNumberOfElement());
        }
        else
        {
            System.out.println("ERROR: Trying to average 0 numbers.");
            System.out.println("computeAverage returns 0.");
            return 0;
        }
    }

    /*
    Gives screen output showing how much each of the element in the PartiallyFilledArray a differs from the average
     */
    public static void showDifference(PartiallyFilledArray a)
    {
        double average = computeAverage(a);
        System.out.println("Average of the "+a.getNumberOfElement()+" scores = "+average);
        System.out.println("The scores are:");
        for(int index = 0; index < a.getNumberOfElement(); index++)
        {
            System.out.println(a.getElement(index)+" differs from average by "+(a.getElement(index)-average));
        }
    }
}
