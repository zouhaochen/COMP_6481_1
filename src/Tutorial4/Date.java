package Tutorial4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Date implements Serializable
{
    private String month;
    private int day;
    private int year;

    public void writeOutput()
    {
        System.out.println(month+", "+day+", "+year);
    }

    public void readInput() throws IOException
    {
        boolean tryAgain = true;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while (tryAgain)
        {
            System.out.println("Enter month, day, and year on three lines");
            System.out.println("Enter month, day, and year as three integer");
            int monthInput = Integer.parseInt(keyboard.readLine());
            int dayInput = Integer.parseInt(keyboard.readLine());
            int yearInput = Integer.parseInt(keyboard.readLine());
            if (dateOK(monthInput, dayInput, yearInput))
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
        }
    }

    public void setDate(int month, int day, int year)
    {
        if(dateOK(month, day, year))
        {
            this.month = monthString(month);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setMonth(int monthNumber)
    {
        if((monthNumber <= 0)||(monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    public void setDay(int day)
    {
        if((day <= 0)||(day > 31))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public void setYear(int year)
    {
        if((year < 1000)||(year > 9999))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }

    public boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ((monthInt >= 1) && (monthInt <=12) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000) && (yearInt <= 9999));
    }

    public boolean equals(Date otherDate)
    {
        return ((month.equals(otherDate.month))) && (day == otherDate.day) && (year == otherDate.year);
    }

    public boolean precedes(Date otherDate)
    {
        return ((year < otherDate.year) || (year == otherDate.year && getMonth() < otherDate.getMonth()) || (year == otherDate.year && month.equals(otherDate.month)&& day < otherDate.day));
    }

    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Ocy";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return "Error";
        }
    }

    public int getDay()
    {
        return day;
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        if(month.equals("Jan"))
            return 1;
        else if (month.equals("Feb"))
            return 2;
        else if (month.equals("Mar"))
            return 3;
        else if (month.equals("Apr"))
            return 4;
        else if (month.equals("May"))
            return 5;
        else if (month.equals("Jun"))
            return 6;
        else if (month.equals("Jul"))
            return 7;
        else if (month.equals("Aug"))
            return 8;
        else if (month.equals("Sep"))
            return 9;
        else if (month.equals("Oct"))
            return 10;
        else if (month.equals("Nov"))
            return 11;
        else if (month.equals("Dec"))
            return 12;
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0;
        }
    }
}
