package Tutorial1;

public class Demo02
{
    public static void main(String[] args)
    {
        Rectangular r = new Rectangular(10, 10);
        Demo02 d = new Demo02();

        d.myMethod(r);
        r.show();
    }

    public void myMethod(Rectangular rect)
    {
        rect.a = 15;
        rect.b = 15;
    }
}

class Rectangular
{
    int a;
    int b;
    Rectangular(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    public void show()
    {
        System.out.println(a+", "+b);
    }
}