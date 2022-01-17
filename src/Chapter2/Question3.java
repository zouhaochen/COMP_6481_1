package Chapter2;

import java.util.Scanner;

/*
Write a program that reads in two integers typed on the keyboard and outputs their sum, difference, and product.
*/
public class Question3
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int a = keyboard.nextInt();
        int b = keyboard.nextInt();
        int sum = sum(a,b);
        int difference = difference(a, b);
        int product = product(a, b);
        System.out.println("sum: "+sum+", difference: "+difference+", product: "+product);
    }

    public static int sum(int a, int b)
    {
        return a+b;
    }

    public static int difference(int a, int b)
    {
        return a-b;
    }

    public static int product(int a, int b)
    {
        return a*b;
    }

}
