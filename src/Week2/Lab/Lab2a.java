package Week2.Lab;

import java.util.Scanner;

/*
You are invigilating a high school level contest,
so to ensure that no middle school students try to sneak in and make older students feel uncomfortable,
an age gate is being considered.

Input:
The first line contains N, 1 ≤ N ≤ 25, the number of students taking the exam.
Each of the next N lines contain 3 integers representing a person’s birth date,
in the format DD MM YYYY (separated by spaces).

Output:
The output will comprise of N lines, each printing a decision about whether the participant is
at least 13 years old as of April 18, 2022 (18 04 2022) or not.
The message to be printed is either “old enough” or “too young” depending on the participant’s age.
*/
public class Lab2a
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int studentNumber = 0;
        try
        {
            studentNumber = keyboard.nextInt();
        }
        catch (Exception e)
        {
            System.exit(0);
        }
        if(studentNumber<1||studentNumber>25)
        {
            System.exit(0);
        }
        keyboard.nextLine();

        String[] studentList = new String[studentNumber];
        for(int i = 0; i < studentList.length; i++)
        {
            studentList[i] = keyboard.nextLine();
            if(studentList[i].length()!=10)
            {
                System.exit(0);
            }
        }

        studentAgeCompare(studentList);
    }

    public static void studentAgeCompare(String[] studentList)
    {
        for(int i = 0; i < studentList.length; i++)
        {
            int firstBlank = studentList[i].indexOf(" ");
            if(firstBlank!=2)
            {
                System.exit(0);
            }
            String dayInString = studentList[i].substring(0, 2);
            int dayInInt = Integer.parseInt(dayInString);
            if(dayInInt<1||dayInInt>31)
            {
                System.exit(0);
            }

            int secondBlank = studentList[i].indexOf(" ", 5);
            if(secondBlank!=5)
            {
                System.exit(0);
            }
            String monthInString = studentList[i].substring(3, 5);
            int monthInInt = Integer.parseInt(monthInString);
            if(monthInInt<1||monthInInt>12)
            {
                System.exit(0);
            }

            String yearInString = studentList[i].substring(6);
            int yearInInt = Integer.parseInt(yearInString);

            if (yearInInt>2009)
            {
                System.out.println("too young");
            }
            else if (yearInInt<2009)
            {
                System.out.println("old enough");
            }
            else if (yearInInt == 2009)
            {
                if (monthInInt < 4)
                {
                    System.out.println("old enough");
                }
                else if (monthInInt > 4)
                {
                    System.out.println("too young");
                }
                else if (monthInInt == 4)
                {
                    if (dayInInt > 18)
                    {
                        System.out.println("too young");
                    }
                    else
                    {
                        System.out.println("old enough");
                    }
                }
            }
        }
    }
}
