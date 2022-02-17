package Chapter10;

import java.io.*;

/*
Write a program that takes its input from a binary file of numbers of type double.
The file contains nothing but numbers of type double written to the file with writeDouble.
The program outputs to the screen the average and standard deviation of the numbers in the file.
The number a is the average of the numbers.
Hint: Write your program so that it first reads the entire file and computes the average of all the numbers,
then closes the file, and then reopens the file and computes the standard deviation.
You will find it helpful to first do Programming Project 10.8 and
then modify that program in order to obtain the program for this project.
*/
public class Question10
{
}

class FileDemo
{
    public static void main(String args[])
    {
        double avg = 0;
        int number = 10;
        double value;
        double dev = 0;
        double nextNum;

        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("numbersFile.dat"));

            for (int i = 0; i < 10; i++)
            {
                value = Math.random() * 20 + 1;
                System.out.println("Number contains: " + value);
                os.writeDouble(value);
            }
            os.close();

            ObjectInputStream is = new ObjectInputStream(new FileInputStream("numbersFile.dat"));

            try
            {
                while (true)
                {
                    avg += is.readDouble();
                }
            }
            catch (IOException e)
            {
                avg /= number;
                System.out.println("Average: " + avg);
            }
            is.close();

            is = new ObjectInputStream(new FileInputStream("numbersFile.dat"));

            try
            {
                while (true)
                {
                    nextNum = is.readDouble();
                    dev += (nextNum - avg) * (nextNum - avg);
                }
            }
            catch (IOException e)
            {
                System.out.println("Standard deviation:" + Math.sqrt(dev / number));
            }
        }
        catch (IOException e)
        {
            System.out.println("Error....");
        }
    }
}