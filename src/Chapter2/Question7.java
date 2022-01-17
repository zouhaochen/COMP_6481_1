package Chapter2;

import java.util.Scanner;

/*
Write a program that determines the change to be dispensed from a vending machine.
An item in the machine can cost between 25 cents and 1 dollar, in 5-cent increments(25, 30, 35, ..., 90, 95),
and the machine accepts only a single dollar bill to pay for the item.
*/
public class Question7
{
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);
        int amount, quarters, dimes, nickels, pennies, exchange;

        System.out.println("Enter the price of item");
        System.out.println("(from 25 cents to a dollar, in 5-cent increments)");
        amount=input.nextInt();

        exchange= 100-amount;

        quarters=exchange/25;
        exchange=exchange%25;

        dimes=exchange/10;
        exchange=exchange%10;

        nickels=exchange/5;
        exchange=exchange%5;

        pennies=exchange;

        System.out.println("You bought an item for "+amount+" cents and gave me a dollar,");
        System.out.println("so your change is");
        System.out.println(quarters+" quarters,");
        System.out.println(dimes+" dimes,");
        System.out.println(nickels+" nickels,");
        System.out.println(pennies+" pennies.");
    }
}
