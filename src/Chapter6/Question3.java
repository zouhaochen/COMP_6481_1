package Chapter6;

import java.util.Scanner;

/*
Write a program that reads in the average monthly rainfall for a city for each month of the year
and then reads in the actual monthly rainfall for each of the previous 12 months.
The program should then print out a nicely formatted table showing the rainfall for each of
the previous 12 months as well as how much above or below average the rainfall was for each month.
The average monthly rainfall is given for the months January, February, and so forth, in order.
To obtain the actual rainfall for the previous 12 months, the program should first ask
what the current month ia and then ask for the rainfall figures for the previous 12 months.
*/
public class Question3
{
    private static String monthString(int rainfallMonth)
    {
        switch(rainfallMonth)
        {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                System.out.println("Incorrect month entered. ");
                System.exit(0);
                return "Error";
        }
    }
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        double[] actualRain = new double[12];
        double[] averageRain = new double[12];

        System.out.println("Enter the average rainfall for each month:");
        for(int i = 1; i <= 12; i++)
        {
            System.out.print(monthString(i) + ": ");
            averageRain[i - 1] = input.nextDouble();
        }
        System.out.println();
        System.out.print("What is the current month?(month number): ");
        int currentMonth = input.nextInt();

        System.out.println("Enter the actual rainfall to the past 12 months:");

        for(int i = currentMonth; i <= 12; i++)
        {
            System.out.print(monthString(i) + ": ");
            actualRain[i - 1] = input.nextDouble();
        }
        for(int i = 1; i < currentMonth; i++)
        {
            System.out.print(monthString(i) + ": ");
            actualRain[i - 1] = input.nextDouble();
        }
        System.out.println("Month\t\tAverage\t\t" +	" Actual\t\tDifference");
        System.out.println("------\t\t-------\t\t" +"-------\t\t----------");
        for(int i = 1; i <= 12; i++)
        {
            System.out.print(monthString(i) + "\t");

            //for formatting purposes
            if(i != 2 && i != 9 && i != 11 && i != 12)
                System.out.print("\t");
            System.out.print("  " + averageRain[i - 1] + "\t\t");
            System.out.print("  " + actualRain[i - 1] + "\t\t");
            System.out.print("   " +(averageRain[i - 1] - actualRain[i - 1]));
            System.out.println();
        }
    }
}
