package Chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
Write a program that takes its input from a binary file of numbers of type double and
outputs the average of the numbers in the file to the screen.
The file contains nothing but numbers of type double written to the file with writeDouble.
*/
public class Question9
{
}

class TestDemoQuestion9
{
    public static void main(String args[])
    {
        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("writeIntFile.dat"));
            System.out.println("Random integer numbers are: ");

            for (int i = 0; i < 10; i++)
            {
                double number =  (Math.random() * 20 + 1);
                System.out.println(" " + number);
                os.writeDouble(number);
            }

            os.close();
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("writeIntFile.dat"));

            double total = 0;
            int num = 10;
            try
            {
                while (true)
                {
                    total += is.readDouble();
                }
            }
            catch (IOException e)
            {
                System.out.println("\nAverage: " + total / num);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error occured in output file.");
        }
    }
}
