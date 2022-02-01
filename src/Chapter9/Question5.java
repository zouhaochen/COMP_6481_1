package Chapter9;

import java.util.*;

/*
Write a program that converts dates from numerical month/day/year format to normal “month day, year” format
(for example, 12/25/2000 corresponds to December 25, 2000).
You will define three exception classes, one called MonthException,
another called DayException, and a third called YearException.
If the user enters anything other than a legal month number (integers from 1 to 12 ),
your program will throw and catch a MonthException and ask the user to reenter the month.
Similarly, if the user enters anything other th an a valid day number
(integers from 1 to either 28 , 29 , 30 , or 31, depending on the month and year),
then your program will throw and catch a DayException and ask the user to reenter the day.
If the user enters a year that is not in the range 1000 to 3000 (inclusive),
then your program will throw and catch a YearException and ask the user to reenter the year.
(There is nothing very special about the numbers 1000 and 3000 other than giving a good range of likely dates.)
*/
public class Question5
{
}

class DateConversion
{
    public static int maximumDay(int monthNumber)
    {
        switch(monthNumber)
        {
            case 2:
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static int readMonthNumber() throws MonthException
    {
        Scanner input = new Scanner(System.in);
        int month;
        System.out.println("Enter month number:");
        try
        {
            month = input.nextInt();
            if(month <= 0 || month > 12)
                throw new MonthException();
        }
        catch(InputMismatchException e)
        {
            throw new MonthException();
        }
        return month;
    }

    public static int readDayNumber(int month) throws DayException
    {
        Scanner input = new Scanner(System.in);
        int day;
        System.out.println("Enter day number:");
        try
        {
            day = input.nextInt();
            if(month != 2 && (day <= 0 || day > maximumDay(month)))
                throw new DayException();
        }

        catch(InputMismatchException e)
        {
            throw new DayException();
        }
        return day;
    }

    public static int readYearNumber() throws YearException
    {
        Scanner input = new Scanner(System.in);
        int year;
        System.out.println("Enter year number:");
        try
        {
            year = input.nextInt();
            if(year <= 1000 || year > 3000)
                throw new YearException();
        }
        catch(InputMismatchException e)
        {
            throw new YearException();
        }
        return year;
    }

    public static int checkFebruary(int day, int year) throws DayException
    {
        int maxDay = maximumDay(2);
        if(year % 4 == 0)
            maxDay++;
        if(day <= 0 || day > maxDay)
        {
            throw new DayException();
        }
        else
            return day;
    }

    public static String monthString(int monthNumber)
    {
        switch(monthNumber)
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
                System.out.println("Fatal Error");
                System.exit(0);
                return "Error";
        }
    }

    public static void main(String args[])
    {
        int month = 1, day = 1, year = 1000;
        boolean gotMonth = false;
        while(!gotMonth)
        {
            try
            {
                month = readMonthNumber();
                gotMonth = true;
            }
            catch (MonthException e)
            {
                System.out.println(e.getMessage());
            }
        }
        boolean gotDay = false;
        while(!gotDay)
        {
            try
            {
                day = readDayNumber(month);
                gotDay = true;
            }
            catch (DayException e)
            {
                System.out.println(e.getMessage());
            }
        }
        boolean gotYear = false;
        while(!gotYear)
        {
            try
            {
                year = readYearNumber();
                gotYear = true;
            }
            catch (YearException e)
            {
                System.out.println(e.getMessage());
            }
        }
        if(month == 2)
        {
            boolean okFebruaryDate = false;
            while(!okFebruaryDate)
            {
                System.out.println("Checking February date...");
                try
                {
                    day = checkFebruary(day, year);
                    okFebruaryDate = true;
                }
                catch(DayException e)
                {
                    System.out.println(e.getMessage());
                    try
                    {
                        day = readDayNumber(month);
                    }
                    catch (DayException e1)
                    {
                    }
                }
            }
        }
        System.out.println("The date is " + monthString(month) + " " + day +", " + year);
    }
}


class MonthException extends Exception
{
    public MonthException()
    {
        super("Invalid month.");
    }
    public MonthException(String message)
    {
        super(message);
    }
}


class DayException extends Exception
{
    public DayException()
    {
        super("Invalid day.");
    }
    public DayException(String message)
    {
        super(message);
    }
}


class YearException extends Exception
{
    public YearException()
    {
        super("Invalid year.");
    }

    public YearException(String message)
    {
        super(message);
    }
}