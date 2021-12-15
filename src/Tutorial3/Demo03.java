package Tutorial3;

public class Demo03
{
    public static void doPrint(Base o)
    {
        o.print();
    }

    public static void main(String[] args)
    {
        Base x = new Base();
        Base y = new Base();
        Derived z = new Derived();

        doPrint(x);
        doPrint(y);
        doPrint(z);
    }
}

class Base
{
    public void print()
    {
        System.out.println("Base");
    }
}

class Derived extends Base
{
    public void print()
    {
        System.out.println("Derived");
    }
}
