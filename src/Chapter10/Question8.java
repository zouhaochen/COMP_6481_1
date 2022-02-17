package Chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
Write a program that will search a binary file of numbers of type int and
write the largest and the smallest numbers to the screen.
The file contains nothing but numbers of type int written to the file with writeInt.
*/
public class Question8
{
}

class TestDemo
{
    public static void main(String args[])
    {
        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("writeIntFile.dat"));
            System.out.println("Ten Random integer numbers are: ");

            for (int i = 0; i < 10; i++)
            {
                int number = (int)(Math.random() * 20) + 1;
                System.out.println(" " + number);
                os.writeInt(number);
            }
            os.close();
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("writeIntFile.dat"));

            int small = 20, large = 0;
            try
            {
                while(true)
                {
                    int nextInt = is.readInt();
                    if(nextInt < small)
                        small = nextInt;
                    if(nextInt > large)
                        large = nextInt;
                }
            }
            catch (IOException e)
            {
                System.out.println("\nLargest number: " + large);
                System.out.println("Smallest number: " + small);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error with file output.");
        }
    }
}

