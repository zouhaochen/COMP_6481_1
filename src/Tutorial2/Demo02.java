package Tutorial2;

public class Demo02
{
    public static void main(String[] args)
    {
        Dog dog = new Dog();
        Cow cow = new Cow();
        Duck duck = new Duck();

        System.out.println(dog.getGreeting());
        System.out.println(cow.getGreeting());
        System.out.println(duck.getGreeting());
    }
}

abstract class Animal
{
    protected boolean isMammal;
    protected boolean isCarnivorous;

    Animal(boolean isMammal, boolean isCarnivorous)
    {
        this.isMammal = isMammal;
        this.isCarnivorous = isCarnivorous;
    }

    public boolean getIsMammal()
    {
        return isMammal;
    }

    public boolean getIsCarnivorous()
    {
        return isCarnivorous;
    }

    abstract String getGreeting();

}

class Dog extends Animal
{
    Dog()
    {
        super(true,true);
    }

    public String getGreeting()
    {
        return "ruff";
    }
}

class Cow extends Animal
{
    Cow()
    {
        super(true,false);
    }

    public String getGreeting()
    {
        return "moo";
    }
}

class Duck extends Animal
{
    Duck()
    {
        super(false,false);
    }

    public String getGreeting()
    {
        return "quack";
    }
}