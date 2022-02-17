package Week6;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.util.Scanner;

public class FileIO
{
    public static void main(String[] args)
    {
        Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 23000, 2), c3 = new Car();
        String fileName;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the \"binary\" file name to which the objects should be stored: ");
        fileName = keyboard.next();

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try
        {
            //Create an ObjectOutputStream to write into the binary file
            oos = new ObjectOutputStream(new FileOutputStream(fileName));

            //If this point is reached, then the stream was created successfully.
            //Som start writing the objects to the file.
            oos.writeObject(c1);
            oos.writeObject(c2);
            oos.writeObject(c3);

            oos.close();

            System.out.println("Objects have been written to the file " + fileName + ".");
        }
        catch (IOException e)
        {
            System.out.println("Error: Problem Reading from file: " + fileName + ".");
            System.out.println("Program will terminate.");
            System.exit(0);
        }

        //Now the file has been created; try to open it and read the objects
        try
        {
            //Create an ObjectInputStream to write into the binary file
            ois = new ObjectInputStream(new FileInputStream(fileName));

            //If this point is reached, then the stream was created successfully.
            //So, start reading the objects from the file.
            Car car;
            int i = 1;

            System.out.println("\nWill start displaying the objects stored in file: \"" + fileName + "\".");
            System.out.println();
            try
            {
                while(true)
                {
                    //Notice the type cast here; this is the reason that we need to handle ClassNotFoundException
                    car = (Car)ois.readObject();
                    System.out.println("\nHere is the information of object #" + i++ + ":");
                    System.out.println();
                    System.out.println(car);
                }
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Error has occurred while reading the file: " + fileName + ".");
            }
            catch (EOFException e)
            {
                System.out.println("\nReading file \"" + fileName + "\"has been completed.");
            }
            ois.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File: " + fileName + " could not been found.");
            System.out.println("Program will terminate.");
            System.exit(0);
        }
        catch (IOException e)
        {
            System.out.println("Error: Problem Reading from file: " + fileName + ".");
            System.out.println("Program will terminate.");
            System.exit(0);
        }
    }

}

class Car implements Serializable
{
    //Attributes
    private int numOfDoors;
    private double price;
    private int numOfSeats;

    //Constructors
    //default constructor
    public Car()
    {
        numOfDoors = 4;
        price = 10000;
        numOfSeats = 5;
    }

    public Car(int numOfDoors, double price, int numOfSeats)
    {
        this.numOfDoors = numOfDoors;
        this.price = price;
        this.numOfSeats = numOfSeats;
    }

    public Car(Car car)
    {
        numOfDoors = car.numOfDoors;
        price = car.price;
        numOfSeats = car.numOfSeats;
    }

    public int getNumOfDoors()
    {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors)
    {
        this.numOfDoors = numOfDoors;
    }

    public int getNumOfSeats()
    {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats)
    {
        this.numOfSeats = numOfSeats;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String toString()
    {
        return "This Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() + "$. The number of seats of this car is " + getNumOfSeats() + ".";
    }
}
