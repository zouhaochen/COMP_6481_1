package Chapter1;

import java.util.Scanner;

/*
Write a program that outputs the number of hours, minutes, and seconds that corresponds to 50,391 total seconds.
*/
public class Question7
{
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int time = keyboard.nextInt();
        timeOutput(time);
    }

    public static void timeOutput(int totalSeconds)
    {
        int remainingSeconds;
        int hours;
        int minutes;
        int seconds;

        hours = totalSeconds / SECONDS_PER_HOUR;

        remainingSeconds = totalSeconds % SECONDS_PER_HOUR;

        minutes = remainingSeconds / SECONDS_PER_MINUTE;

        remainingSeconds = remainingSeconds % SECONDS_PER_MINUTE;

        seconds = remainingSeconds;

        System.out.println("There are " + hours + " hours, "
                + minutes + " minutes, and " + seconds
                + " seconds in " + totalSeconds + " seconds.");
    }
}
