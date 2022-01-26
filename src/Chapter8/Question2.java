package Chapter8;

/*
Create a class named Movie that can be used with your video rental business.
The Movie class should track the Motion Picture Association of America (MPAA) rating
(e.g., Rated G, PG-13, R), ID Number, and movie title with appropriate accessor and mutator methods.
Also create an equals() method that over rides Object’s equals() method,
where two movies are equal if their ID number is identical.
Next, create three additional classes named Action, Comedy, and Drama that are derived from Movie.
Finally, create an overridden method named calcLateFees that takes as input the number of days a movie
is late and returns the late fee for that movie.
The default late fee is $2/day. Action movies have a late fee of $3/day, comedies are $2.50/day,
and dramas are $2/day. Test your classes from a main method.
*/
public class Question2
{
}

// Movie.java
class Movie
{
    private String rating;
    private int ID;
    private String title;

    public Movie()
    {
        rating = "";
        ID = 0;
        title = "";
    }

    public Movie(String aRating, int aID, String aTitle)
    {
        rating = aRating;
        ID = aID;
        title = aTitle;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String aRating)
    {
        rating = aRating;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int aID)
    {
        ID = aID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String aTitle)
    {
        title = aTitle;
    }

    public double calcLateFees(int days)
    {
        return 2.0 * days;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        else if(getClass() != obj.getClass())
            return false;
        else
        {
            Movie other = (Movie)obj;
            return (rating.equals(other.rating) && ID == other.ID && title.equals(other.title));
        }
    }

    public String toString()
    {
        return "\nMPAA Rating: " + rating + "\nID Number: " + ID + "\nMovie Title: " + title;
    }
}

// Action.java
class Action extends Movie
{
    public Action()
    {
        super();
    }

    public Action(String aRating, int aID, String aTitle)
    {
        super(aRating, aID, aTitle);
    }

    public double calcLateFees(int days)
    {
        return 3.0 * days;
    }
}

// Comedy.java
class Comedy extends Movie
{
    public Comedy()
    {
        super();
    }

    public Comedy(String aRating, int aID, String aTitle)
    {
        super(aRating, aID, aTitle);
    }

    public double calcLateFees(int days)
    {
        return 2.5 * days;
    }
}

// Drama.java
class Drama extends Movie
{
    public Drama()
    {
        super();
    }

    public Drama(String aRating, int aID, String aTitle)
    {
        super(aRating, aID, aTitle);
    }

    public double calcLateFees(int days)
    {
        return 2.0 * days;
    }
}

// MovieTest.java
class MovieTest
{
    public static void main(String[] args)
    {
        Movie movie = new Movie("PG-13", 3691, "Norm of the North");
        Action action = new Action("G", 2587, "Eye In The Sky");
        Comedy comedy = new Comedy("R", 7989, "Kung Fu Panda 3");
        Drama drama = new Drama("PG-13", 4563, "Batman v Superman");

        System.out.println(movie);
        System.out.println("Late Fee: $" + movie.calcLateFees(6));

        System.out.println(action);
        System.out.println("Late Fee: $" + action.calcLateFees(6));

        System.out.println(comedy);
        System.out.println("Late Fee: $" + comedy.calcLateFees(6));

        System.out.println(drama);
        System.out.println("Late Fee: $" + drama.calcLateFees(6));
    }
}