package Chapter7;

/*
The following is some code designed by J. Hacker for a video game.
There is an Alien class to represent a monster and
an AlienPack class that represents a band of aliens and how much damage they can inflict:
The code is not very object oriented and does not support information hiding in the Alien class.
Rewrite the code so that inheritance is used to represent the different types of
aliens instead of the “type” parameter. This should result in deletion of the “type” parameter.
Also rewrite the Alien class to hide the instance variables and
create a getDamage method for each derived class that returns the amount of damage the alien inflicts.
Finally, rewrite the calculateDamage method to use getDamage and write a main method that tests the code.
*/
public class Question3
{
}

class Alien
{
    protected int health;
    protected String name;

    Alien()
    {
    }

    Alien(int health,String name)
    {
        this.health=health;
        this.name=name;
    }
}

class MarshmallowAlien extends Alien
{
    private final int damage=1;
    private int number;

    MarshmallowAlien(int number,int health, String name)
    {
        super(health,name);
        this.number=number;
    }

    int getDamage()
    {
        return damage;
    }

    int calculateDamage()
    {
        return getDamage()*number;
    }

    public String toString()
    {
        return ("The Alien "+name+" with Health "+health+" caused Damage "+calculateDamage());
    }
}

class OgreAlien extends Alien
{
    private final int damage=6;
    private int number;

    OgreAlien(int number,int health, String name)
    {
        super(health,name);
        this.number=number;
    }

    int getDamage()
    {
        return damage;
    }

    int calculateDamage()
    {
        return getDamage()*number;
    }

    public String toString()
    {
        return ("The Alien "+name+" with Health "+health+" caused Damage "+calculateDamage());
    }
}

class SnakeAlien extends Alien
{
    private final int damage=10;
    private int number;

    SnakeAlien(int number,int health, String name)
    {
        super(health,name);
        this.number=number;
    }

    int getDamage()
    {
        return damage;
    }

    int calculateDamage()
    {
        return getDamage()*number;
    }

    public String toString()
    {
        return ("The Alien "+name+" with Health "+health+" caused Damage "+calculateDamage());
    }
}

class TestMethod
{
    public static void main(String[] args)
    {
        SnakeAlien alien1= new SnakeAlien(50,78,"Snake");
        OgreAlien alien2= new OgreAlien(22,99,"Ogre");
        MarshmallowAlien alien3=new MarshmallowAlien(44,100,"Marshmallow Alien");
        System.out.println(alien1.toString());
        System.out.println(alien2.toString());
        System.out.println(alien3.toString());
    }
}