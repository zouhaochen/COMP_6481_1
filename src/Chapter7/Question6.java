package Chapter7;

/*
Create a class called Vehicle that has the manufacturer’s name (type String ),
number of cylinders in the engine (type int ), and owner (type Person given next).
Then, create a class called Truck that is derived from Vehicle and has the following additional properties:
the load capacity in tons (type double since it may contain a fractional part)
and towing capacity in pounds (type int ).
Be sure your class has a reasonable complement of constructors, accessor and mutator methods,
and suitably defined equals and toString methods. Write a program to test all your methods.
*/
public class Question6
{
}

//Person.java
class Person
{
    private String name;

    public Person()
    {
        name = "none";
    }

    public Person(String theName)
    {
        name = theName;
    }

    public Person(Person theObject)
    {
        name = theObject.name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String theName)
    {
        name = theName;
    }

    public String toString()
    {
        return name;
    }

    public boolean equals(Object other)
    {
        return name.equals(((Person)other).name);
    }
}

//Vehicle.java
class Vehicle
{
    private String mf;
    private int cd;
    private Person own;

    public Vehicle()
    {
        mf = "none";
        cd = 1;
        own = null;
    }

    public Vehicle(String themf, int numcd, Person theown)
    {
        mf = themf;
        cd = numcd;
        own = new Person(theown);
    }

    public Vehicle(Vehicle other)
    {
        mf = other.mf;
        cd = other.cd;
        own = new Person(other.own);
    }

    public void setmf(String newmf)
    {
        mf = newmf;
    }

    public void setcd(int newNum)
    {
        cd = newNum;
    }

    public void setown(Person newown)
    {
        own = new Person(newown);
    }

    public String getmf()
    {
        return mf;
    }

    public int getcd()
    {
        return cd;
    }

    public Person getown()
    {
        return own;
    }

    public String toString()
    {
        return mf + ", " + cd + " cd, owned by " + own;
    }

    public boolean equals(Vehicle other)
    {
        return mf.equals(other.mf) && cd == other.cd;
    }
}

//Truck.java
class Truck extends Vehicle
{
    private double load;
    public int capacity;

    public Truck()
    {
        super();
        load = 0;
        capacity = 0;
    }

    public Truck(String m, int c, Person p, double loads, int capc)
    {
        super(m, c, p);
        load = loads;
        capacity = capc;
    }

    public Truck(Truck oth)
    {
        super(oth);
        load = oth.load;
        capacity = oth.capacity;
    }

    public void setload(double newLoad)
    {
        load = newLoad;
    }

    public void setcapacity(int newCaps)
    {
        capacity = newCaps;
    }

    public double getload()
    {
        return load;
    }

    public int getcapacity()
    {
        return capacity;
    }

    public String toString()
    {
        return super.toString() + ", " + load + " lbs load, " + capacity + " tow";
    }

    public boolean equals(Truck oth)
    {
        return super.equals(oth) &&
                load == oth.load &&
                capacity == oth.capacity;
    }
}

//CompleteTest.java
class CompleteTest
{
    public static void main(String args[])
    {
        Person owner1 = new Person("Nathan Roy");
        Person owner2 = new Person("Peter England");
        Vehicle aCar = new Vehicle("Honda", 5, owner2);
        Truck aTruck = new Truck();
        aTruck.setmf("Skoda");
        aTruck.setcd(100);
        aTruck.setown(owner1);
        aTruck.setload(150.50);
        aTruck.setcapacity(3200);
        System.out.println("Truck Details: ");
        System.out.println(aTruck.getmf());
        System.out.println(aTruck.getcd());
        System.out.println(aTruck.getown());
        System.out.println(aTruck.getload());
        System.out.println(aTruck.getcapacity());
        System.out.println();
        System.out.println("Details of Vehicle 1: ");
        System.out.println(aCar);
        System.out.println("Details of Vehicle 2: ");
        System.out.println(aTruck);
    }
}

