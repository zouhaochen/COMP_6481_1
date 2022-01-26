package Chapter8;

/*
In Programming Project 7.3 from Chapter 7, the Alien class was rewritten to use inheritance.
The rewritten Alien class should be made abstract because there will never be a need to
create an instance of it, only its derived classes.
Change this to an abstract class and also make the getDamage method an abstract method.
Test the class from your main method to ensure that it still operates as expected.
*/
public class Question1
{
}

//Alien.java
abstract class Alien
{
    protected int damageType,health;
    protected String name;

    Alien(int type, String name, int damg)
    {
        this.health=type;
        this.name=name;
        this.damageType=damg;
    }
    public abstract int getDamage();
}

//Snake.java
class Snake extends Alien
{

    Snake(int type, String name)
    {
        super(type, name,200);

    }
    public int getDamage()
    {
        return this.damageType;
    }

}

//Ogre.java
class Ogre extends Alien
{
    Ogre(int type, String name)
    {
        super(type, name, 100);

    }
    public int getDamage()
    {
        return this.damageType;
    }
}

//MarshmallowMan.java
class MarshmallowMan extends Alien
{

    MarshmallowMan(int type, String name)
    {
        super(type, name, 200);

    }
    public int getDamage()
    {
        return this.damageType;
    }
}

//AlienPack.java
class AlienPack
{
    private Alien[] a;
    public AlienPack(int countAliens)
    {

        a=new Alien[countAliens];
    }

    public void addAlien(Alien newAlien, int index)
    {
        a[index]=newAlien;
    }

    public Alien[] getAliens()
    {
        return a;
    }

    public int calculateDamage()
    {
        int d=0;
        for(int i=0;i<a.length;i++)
            d+=a[i].getDamage();
        return d;
    }
}

//TestDemo
class TestDemoQuestion1
{
    public static void main(String[] args)
    {

        AlienPack ap=new AlienPack(3);
        ap.addAlien(new Ogre(10,"Mark"),0);
        ap.addAlien(new Snake(10,"Peter"),1);
        ap.addAlien(new MarshmallowMan(10,"John"),2);
        System.out.println("Total damages="+ap.calculateDamage());
    }
}