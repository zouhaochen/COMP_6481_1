package Tutorial1;

public class Demo03
{
    public static void main(String[] args)
    {
        RectangularNew r1 = new RectangularNew(10, 10);
        RectangularNew r2 = new RectangularNew(15, 15);
        Demo03 d = new Demo03();
        d.myMethod(r1, r2);

        r1.show();
        r2.show();
    }

    public void myMethod(RectangularNew rect1, RectangularNew rect2)
    {
        rect1 = rect2;
    }
}

class RectangularNew
{
    int a;
    int b;
    RectangularNew(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    public void show()
    {
        System.out.println(a+", "+b);
    }
}