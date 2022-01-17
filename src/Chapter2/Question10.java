package Chapter2;

import javafx.beans.binding.Bindings;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
Write a program that inputs the name, quantity, and price of three items.
The name may contain spaces.
Output a  ill with a tax rate of 6.25%.
All prices should be output to two decimal places.
The bill should be formatted in columns with 30 characters for name, 10 characters for the quantity,
10 characters for the price, and 10 characters for the total.
*/
public class Question10
{
    public static final double TAX = 6.25;

    DecimalFormat pattern0dot00 = new DecimalFormat("0.00");

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input quantity of item:");
        int quantityItem = sc.nextInt();
    }

    public void itemOutput(int quantityItem)
    {
        if(quantityItem<=0)
        {
            System.out.println("number of item should larger than 0");
        }
        else
        {
            for(int i = 1; i <= quantityItem; i++)
            {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Input name of item "+i+":");
                String itemName = keyboard.nextLine();

                System.out.println("Input quantity of item "+i+":");
                int itemQuantity = keyboard.nextInt();

                System.out.println("Input the price of item "+i+":");
                double itemPrice = keyboard.nextDouble();

                double total = itemQuantity*itemPrice;
                pattern0dot00.format(total);
            }
        }
    }
}

class Q10_ShoppingBill
{
    //Declaring the constant variable for tax
    public static final double TAX = 6.25;

    public static void main(String[] args)
    {
        //Declaring the scanner object
        Scanner input = new Scanner(System.in);

        //Declaring the string variables
        String item = "Item",
                quantity = "Quantity",
                price = "Price",
                itemTotal = "Total",
                subtotal = "Subtotal",
                salesTax = "6.25% sales tax",
                billTotal = "Total";

        //Entering and storing data
        System.out.println("Enter item name: ");
        String itemName1 = input.nextLine();
        System.out.println("Enter item quantity: ");
        double itemQuantity1 = input.nextDouble();
        System.out.println("Enter item price: ");
        double itemPrice1 = input.nextDouble();

        //To get rid of '\n'
        String junk = input.nextLine();

        //Entering and storing data
        System.out.println("Enter item name: ");
        String itemName2 = input.nextLine();
        System.out.println("Enter item quantity: ");
        double itemQuantity2 = input.nextDouble();
        System.out.println("Enter item price: ");
        double itemPrice2 = input.nextDouble();

        //To get rid of '\n'
        String junk2 = input.nextLine();

        //Entering and storing data
        System.out.println("Enter item name: ");
        String itemName3 = input.nextLine();
        System.out.println("Enter item quantity: ");
        double itemQuantity3 = input.nextDouble();
        System.out.println("Enter item price: ");
        double itemPrice3 = input.nextDouble();

        //Calculating totals and tax
        double itemTotal1 = itemQuantity1 * itemPrice1;
        double itemTotal2 = itemQuantity2 * itemPrice2;
        double itemTotal3 = itemQuantity3 * itemPrice3;
        double itemsTotal = itemTotal1 + itemTotal2 + itemTotal3;
        double itemsTax = (itemsTotal * TAX) / 100;
        double itemsTotalWithTax = itemsTotal + itemsTax;

        //Printing the results
        System.out.println(" ");
        System.out.println("Your bill: ");
        System.out.println(" ");

        System.out.printf("%-30s%-10s%-10s%-10s %n", item, quantity, price, itemTotal);
        System.out.printf("%-30s%-10.1f%-10.2f%-10.2f %n", itemName1, itemQuantity1, itemPrice1, itemTotal1);
        System.out.printf("%-30s%-10.1f%-10.2f%-10.2f %n", itemName2, itemQuantity2, itemPrice2, itemTotal2);
        System.out.printf("%-30s%-10.1f%-10.2f%-10.2f %n", itemName3, itemQuantity3, itemPrice3, itemTotal3);
        System.out.printf("%-50s%-10.2f %n", subtotal, itemsTotal);
        System.out.printf("%-50s%-10.2f %n", salesTax, itemsTax);
        System.out.printf("%-50s%-10.2f %n", itemTotal, itemsTotalWithTax);

    }
}