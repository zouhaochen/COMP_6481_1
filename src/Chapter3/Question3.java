package Chapter3;

import java.util.Scanner;

/*
One way to estimate the adult height of a child is to use the following formula,
which uses the height of the parents
All heights re in inches.
Write a program that takes as input the gender of the child,
the height of the mother in inches, and the height of the father in inches,
and output the estimated adult height of the child in inches.
The program should allow the user to enter a new set of values and
output the predicted height until the user decides to exit.
The user should be able to input the heights in feet and inches,
and the program should output the estimated height pf the child in feet and inches.
Use the int data type to store the height.
*/
public class Question3
{
}

class HeightDemo
{
    public static void main(String[] args)
    {
        String genderChild, units, userChoice;
        int fatherHeight, motherHeight, childHeight;

        Scanner keyboard = new Scanner(System.in);
        while (true)
        {
            fatherHeight = 0;
            motherHeight = 0;
            childHeight = 0;

            System.out.println("Enter your userChoice('boy' or 'girl'):");
            genderChild = keyboard.next();

            System.out.println("Enter 'feet' for feet  and inches,or 'inch' for inches:");
            units = keyboard.next();

            if (units.equals("feet"))
            {
                System.out.println("Enter father's height feet:");
                fatherHeight = 12 * keyboard.nextInt();

                System.out.println("Enter father's height inches:");
                fatherHeight += keyboard.nextInt();

                System.out.println("Enter mother's height feet:");
                motherHeight = 12 * keyboard.nextInt();

                System.out.println("Enter mother's height inches:");
                motherHeight += keyboard.nextInt();
            }
            else if (units.equals("inch"))
            {
                System.out.println("Enter father's height inches:");
                fatherHeight = keyboard.nextInt();

                System.out.println("Enter mother's height inches:");
                motherHeight = keyboard.nextInt();
            }
            if (genderChild.equals("boy"))
            {
                childHeight = (int) (((motherHeight * 13 /
                        12.0)	+ fatherHeight) / 2.0);
            }
            else if (genderChild.equals("girl"))
            {
                childHeight = (int) (((fatherHeight + 12
                        /13.0)+ fatherHeight) / 2.0);
            }
            if (units.equals("feet"))
            {
                System.out.println("The children will be"
                        + " about " + childHeight / 12 + " feet, "+ childHeight % 12 + " inches tall.");
            }
            else if (units.equals("inch"))
            {
                System.out.println("The children will be about " + childHeight +" inches tall.");
            }

            System.out.println("Enter 'yes' to continue (or) 'no' to exit.");
            userChoice = keyboard.next();

            if (userChoice.equals("yes"))
                System.out.println("Continuing...");
            else if (userChoice.equals("no"))
                break;
        }
    }
}
