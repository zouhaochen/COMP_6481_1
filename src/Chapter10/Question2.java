package Chapter10;

import java.util.*;
import java.io.*;

/*
Write a program that will search a text file of strings representing numbers of type int and
will write the largest and the smallest numbers to the screen.
The file contains nothing but strings representing numbers of type int, one per line.
*/
public class Question2
{
}

class SearchNumbers
{
    public static void main(String args[])
    {
        int maxNum,minNum;
        int nextSearch;

        Scanner inputFile = null;
        try
        {
            inputFile = new Scanner(new FileInputStream("numbersFile.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Sorry, this file could not not be found.");
        }

        maxNum = inputFile.nextInt();
        minNum = maxNum;

        while(inputFile.hasNextInt())
        {
            nextSearch= inputFile.nextInt();

            if(minNum > nextSearch)
                minNum = nextSearch;
            if(maxNum < nextSearch)
                maxNum = nextSearch;
        }

        System.out.println("Smallest number in the file: " + minNum);
        System.out.println("Largest number in the file: " + maxNum);
    }
}