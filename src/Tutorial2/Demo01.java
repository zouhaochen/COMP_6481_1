package Tutorial2;

public class Demo01
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle();
        c1.setRadius(2.0);
        System.out.println("Area of c1 "+c1);

        Circle c2 = new Circle();
        c2.setRadius(4.0);
        System.out.println("Area of c2 "+c2);

        Rectangular r1 = new Rectangular();
        r1.setHeight(2.0);
        r1.setWidth(4.0);
        System.out.println("Area of r1 "+r1);

        Rectangular r2 = new Rectangular();
        r2.setHeight(3.0);
        r2.setWidth(6.0);
        System.out.println("Area of r2 "+r2);

        Shape shapes[] = {c1, c2, r1, r2};
        System.out.println("Total Area is: "+totalArea(shapes));

    }

    public static double totalArea(Shape[] shaps)
    {
        double area_sum = 0;

        for(int i = 0; i < shaps.length; i++)
        {
            area_sum += shaps[i].getArea();
        }

        return Math.round(area_sum*100.0)/100.0;
    }
}

abstract class Shape
{
    public abstract double getArea();
}

class Circle extends Shape
{
    private static final double pi = 3.14;
    private double radius;

    public Circle()
    {
        radius = 0.0;
    }

    public Circle(double radius)
    {
        this.setRadius(radius);
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public double getArea()
    {
        return pi*radius*radius;
    }

    public String toString()
    {
        return "Circle: "+this.getArea();
    }
}

class Rectangular extends Shape
{
    private double height;
    private double width;

    public Rectangular()
    {
        height = 0.0;
        width = 0.0;
    }

    public Rectangular(double height, double width)
    {
        this.width = width;
        this.height = height;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getArea()
    {
        return height*width;
    }

    public String toString()
    {
        return "Rectangular: "+this.getArea();
    }
}