package Tutorial1;

public class Demo05
{
    public static void main(String[] args)
    {
        Dog fido = new Dog();
        BullDog terror = new BullDog();
        System.out.println(fido);
        System.out.println(terror);
        System.out.println();

        Chiwawa carlos = new Chiwawa();

        System.out.println(fido.bark1());
        System.out.println(carlos.bark1());
        System.out.println(fido.bark2());
        System.out.println(carlos.bark2());

    }
}

class Dog
{
    public void bark()
    {
        System.out.println("Bark!");
    }

    public String bark1()
    {
        return "Bark!";
    }

    public String bark2()
    {
        return "Bark! Bark!";
    }

    public void wagTail()
    {
        System.out.println("Wag Tail");
    }

    public static void sleep(int minute)
    {
        System.out.println("Sleep: "+minute);
    }

    public String toString()
    {
        return "This is a dog";
    }
}

class BullDog extends Dog
{
    /*
    静态只能覆盖静态
    public static void bark()
    {

    }
     */

    public void wagTail()
    {
        System.out.println("Bull Dog Wag Tail");
    }

    /*
    非静态不能覆盖静态
    public void sleep(int minute)
    {
    }
     */

    public String toString()
    {
        return super.toString()+", but also bull dog";
    }
}

class Chiwawa extends Dog
{
    public String bark2()
    {
        return "Yip！Yip!";
    }
}