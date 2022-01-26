package Chapter8;

/*
Extend the previous problem with a Rental class.
This class should store a Movie that is rented,
an integer representing the ID of the customer that rented the movie,
and an integer indicating how many days late the movie is.
Add a method that calculates the late fees for the rental.
In your main method, create an array of type Rental filled with sample data of all types of movies.
Then, create a method named lateFeesOwed that iterates through the array and
returns the total amount of late fees that are outstanding.
*/
public class Question3 {
}

class Rental
{
    private Movie rent;
    private int ID;
    private int lateDays;

    public Rental(Movie aMovie, int ID)
    {
        rent = aMovie;
        ID = ID;
        lateDays = 0;
    }

    public void setMovie(Movie x)
    {
        rent = x;
    }

    public void setID(int y)
    {
        ID = y;
    }

    public void setlateDays(int z)
    {
        lateDays = z;
    }

    public Movie getMovie()
    {
        return rent;
    }

    public int getID()
    {
        return ID;
    }

    public int getlateDays()
    {
        return lateDays;
    }

    public double calculateLateFee()
    {
        return rent.calcLateFees(lateDays);
    }
}

class TestDemoQuestion3
{
    public static double lateFeesOwed(Rental[] rentals)
    {
        double total = 0;
        for (int i = 0; i < rentals.length; i++)
        {
            total += rentals[i].calculateLateFee();
        }

        return total;
    }

    public static void main(String args[])
    {
        Movie movies[] = new Movie[6];
        movies[0] = new Action("PG-13", 1001, "Ronzer");
        movies[1] = new Comedy("dfdf", 1002, "Ted");
        movies[2] = new Drama("PG-13", 1003, "rose");
        movies[3] = new Action("PG-13", 1100, "spdider man");
        movies[4] = new Comedy("R", 2100, "jungle book");
        movies[5] = new Drama("R", 1003, "jamesbond");

        Rental rentals[] = new Rental[6];
        rentals[0] = new Rental(movies[0], 12);
        rentals[1] = new Rental(movies[1], 24);
        rentals[2] = new Rental(movies[2], 88);
        rentals[3] = new Rental(movies[3], 34);
        rentals[4] = new Rental(movies[4], 82);
        rentals[5] = new Rental(movies[5], 9);
        rentals[0].setlateDays(1);
        rentals[1].setlateDays(5);
        rentals[2].setlateDays(0);
        rentals[3].setlateDays(2);
        rentals[4].setlateDays(3);
        rentals[5].setlateDays(4);

        System.out.println("Total late fee: $" + lateFeesOwed(rentals));
    }
}