package Chapter10;

import java.util.*;
import java.io.*;

/*
Write a program that takes its input from a text file of strings representing numbers of type double and
outputs the average of the numbers in the file to the screen.
The file contains nothing but strings representing numbers of type double, one per line.
*/
public class Question3
{
}

class TypeConversion
{
    public static void main(String args[])
    {
        Scanner input = null;
        try
        {
            input = new Scanner(new FileInputStream("input.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file was not found.");
        }

        double sum = 0;
        int number = 0;
        while(input.hasNextDouble())
        {
            sum += input.nextDouble();
            number++;
        }

        System.out.println("The Average of numbers: " + sum /number);
        input.close();
    }
}
