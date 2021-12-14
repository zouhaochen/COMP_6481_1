package Tutorial2;

public class Demo03
{
    public static void main(String[] args)
    {
        new Inherit();
    }
}

class Inherit
{
    abstract class Speaker
    {
        abstract public void speak();
    }

    class Cat extends Speaker
    {
        public void speak()
        {
            System.out.println("Meow");
        }
    }

    class Dog extends Speaker
    {
        public void speak()
        {
            System.out.println("Woof");
        }
    }

    public Inherit()
    {
        Speaker dog = new Dog();
        Speaker cat = new Cat();
        dog.speak();
        cat.speak();
    }
}
