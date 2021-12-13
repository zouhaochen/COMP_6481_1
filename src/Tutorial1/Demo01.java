package Tutorial1;

public class Demo01
{
    public static void main(String[] args)
    {
        Car c = new Car();
        c.color = "蓝色";

        Demo01 d = new Demo01();
        d.myMethod(c);

        c.run();
    }

    public void myMethod(Car c)
    {
        c.color = "黑色";
    }
}

class Car
{
    String color = "红色";

    void run()
    {
        System.out.println("color: "+color);
    }
}