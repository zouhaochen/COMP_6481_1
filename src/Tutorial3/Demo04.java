package Tutorial3;

public class Demo04
{
    public static void main(String[] args)
    {
        A obj = new A();
        System.out.println("in main()");
        System.out.println("objA.a = "+obj.getA());
        obj.setA(222);
    }
}

class A
{
    private int a = 100;

    public void setA(int value)
    {
        a = value;
    }

    public int getA()
    {
        return a;
    }
}