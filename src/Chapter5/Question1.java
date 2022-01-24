package Chapter5;

/*
You operate several hot dog stands distributed throughout town.
Define a class named HotDogStand that has an instance variable for the hot dog stand’s ID number and
an instance variable for how many hot dogs the stand has sold that day.
Create a constructor that allows a user of the class to initialize both values.
Also create a method named justSold that increments by one the number of hot dogs the stand has sold.
The idea is that this method will be invoked each time the stand sells a hot dog so that
you can track the total number of hot dogs sold by the stand.
Add another method that returns the number of hot dogs sold.
Finally, add a static variable that tracks the total number of hot dogs sold by all hot dog stands and
a static method that returns the value in this variable.
Write a main method to test your class with at least three hot dog stands that each sell a variety of hot dogs.
*/
public class Question1
{
}

// HotDogStand.java
class HotDogStand
{
    private int standsID;
    private int hotDogsSold;

    private static int totalHotDogsSold = 0;

    public HotDogStand()
    {
        standsID = 0;
        hotDogsSold = 0;
    }

    public HotDogStand(int newStandID, int newHotDogsSold)
    {
        standsID = newStandID;
        hotDogsSold = newHotDogsSold;
        totalHotDogsSold += newHotDogsSold;
    }

    public void justSold()
    {
        hotDogsSold++;
        totalHotDogsSold++;
    }

    public int getHotDogsSold()
    {
        return hotDogsSold;
    }

    public static int getTotalHotDogsSold()
    {
        return totalHotDogsSold;
    }

    public int getStandsID()
    {
        return standsID;
    }

    public static void main(String[] args)
    {
        HotDogStand dog1 = new HotDogStand(1111, 20);
        HotDogStand dog2 = new HotDogStand(2222, 0);
        HotDogStand dog3 = new HotDogStand(3333, 10);

        dog1.justSold();
        dog1.justSold();
        dog1.justSold();

        dog2.justSold();
        dog2.justSold();
        dog2.justSold();
        dog2.justSold();
        dog2.justSold();

        dog3.justSold();
        dog3.justSold();

        System.out.printf("%-10s%10s\n", "StandsID", "DogsSold");
        System.out.println("---------------------");
        System.out.printf("%-10d%10d\n", dog1.getStandsID(), dog1.getHotDogsSold());
        System.out.printf("%-10d%10d\n", dog2.getStandsID(), dog2.getHotDogsSold());
        System.out.printf("%-10d%10d\n", dog3.getStandsID(), dog3.getHotDogsSold());

        System.out.println(
                "\nTotal number of hot dogs sold by all hot dog stands: "
                        + HotDogStand.getTotalHotDogsSold());
    }
}