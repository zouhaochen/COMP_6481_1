package Chapter4;

import java.util.Scanner;

public class Question4
{
}


/**
 * Define a class called BlogEntry that could be used to store an entry for a Web log.
 * The class should have instance variables to store the poster’s username, text of the entry,
 * and the date of the entry using the Date class from this chapter.
 * Add a constructor that allows the user of the class to set all instance variables.
 * Also add a method, DisplayEntry, that outputs all of the instance variables,
 * and another method called getSummary that returns the first 10 words from the text
 * (or the entire text if it is less than 10 words). Test your class from your main method
 */
class BlogEntry
{
    // Instance variables
    private String myUserName;
    private String myEntry;
    private DateNew myDateNew;

    // -------------------- Constructors --------------------
    // default
    public BlogEntry()
    {
        myUserName = "";
        myEntry = "";
        myDateNew = null;
    }

    // ALl instance variables
    public BlogEntry(String user, String entry, DateNew dateNew)
    {
        myUserName = user;
        myEntry = entry;
        myDateNew = dateNew;
    }

    // -------------------- Method --------------------
    // Method to display all instance variables
    public void DisplayEntry()
    {
        System.out.println("Username: " + this.myUserName);
        System.out.println("Entry: \n" + this.myEntry);
        System.out.println("Date: " + this.myDateNew);
    }

    // Method to return first ten words or entire text if less than 10 words
    public String getSummary()
    {
        // String variables to hold summary
        String summary = this.myEntry;

        //Each word is seperated by a space so the method should count 9 spaces or less
        int spaceCount = 0;
        // Variable to store the current index of the word
        // while ten words havent been found or blog post is finished
        int subscript = 0;
        // While loop
        while(spaceCount <= 9 && subscript < this.myEntry.length())
        {
            String nextChar = this.myEntry.substring(subscript, subscript + 1);
            // Check if space
            if (nextChar.equals(" "))
            {
                if (spaceCount <= 9)
                    spaceCount++;
                else
                    break;
            }
            summary = summary + nextChar;
            subscript++;
        }
        return summary;
    }
}

class DateNew
{
    private String month;
    private int day;
    private int year; //a four digit number.

    public DateNew( )
    {
        month = "January";
        day = 1;
        year = 1000;
    }

    public DateNew(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    public DateNew(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

    public DateNew(int year)
    {
        setDate(1, 1, year);
    }

    public DateNew(DateNew aDateNew)
    {
        if (aDateNew == null)//Not a real date.
        {
            System.out.println("Fatal Error.");
            System.exit(0);
        }

        month = aDateNew.month;
        day = aDateNew.day;
        year = aDateNew.year;
    }

    public void setDate(int monthInt, int day, int year)
    {
        if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(int year)
    {
        setDate(1, 1, year);
    }

    public void setYear(int year)
    {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }

    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    public int getDay( )
    {
        return day;
    }

    public int getYear( )
    {
        return year;
    }

    public String toString( )
    {
        return (month + " " + day + ", " + year);
    }

    public boolean equals(DateNew otherDateNew)
    {
        return ( (month.equals(otherDateNew.month))
                && (day == otherDateNew.day) && (year == otherDateNew.year) );
    }

    public boolean precedes(DateNew otherDateNew)
    {
        return ( (year < otherDateNew.year) ||
                (year == otherDateNew.year && getMonth( ) < otherDateNew.getMonth( )) ||
                (year == otherDateNew.year && month.equals(otherDateNew.month)
                        && day < otherDateNew.day) );
    }

    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
            System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
        }
    }

    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                (dayInt >= 1) && (dayInt <= 31) &&
                (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                (dayInt >= 1) && (dayInt <= 31) &&
                (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    private String monthString(int monthNumber)
    {
        switch (monthNumber)
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
                return "Error"; //to keep the compiler happy
        }
    }
}

class MainQuestion4
{
    public static void main(String[] args)
    {
        // variables
        DateNew today = new DateNew(3,17,2016);
        BlogEntry entry1 = new BlogEntry("krazyman29", "yooooo fuck this mother fucking shit you " +
                "cock sucking mother fucker", today);
        BlogEntry entry2 = new BlogEntry("krazyman29", "yooooo fuck this mother fucking shit you " +
                "cock sucking", today);

        //entry1.DisplayEntry();
        entry2.getSummary();
        entry2.getSummary();
    }
}