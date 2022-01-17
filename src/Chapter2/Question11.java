package Chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
Write a program that calculates the total grade for three classroom exercises as a percentage.
Use the DecimalFormat class to output the value as a percent.
The scores should be summarized in a table.
*/
public class Question11
{
    public static void main(String[] args)
    {

        Scanner input =new Scanner(System.in);
        DecimalFormat percent= new DecimalFormat("##.00%");
        String exercise1,exercise2,exercise3;
        int score1,score2,score3,totalpossiblepoints1,totalpossiblepoints2,totalpossiblepoints3,marks,grandtotal;


        System.out.println("Name of exercise 1:");
        exercise1=input.nextLine();
        System.out.println("Score received for exercise 1:");
        score1=input.nextInt();
        System.out.println("Total points possible for exercise 1:");
        totalpossiblepoints1=input.nextInt();;
        String junk = input.nextLine();  /*To get rid of '\n'*/

        System.out.println("Name of exercise 2:");
        exercise2=input.nextLine();
        System.out.println("Score received for exercise 2 :");
        score2=input.nextInt();
        System.out.println("Total points possible for exercise 2 :");
        totalpossiblepoints2=input.nextInt();;
        String junk2 = input.nextLine();  /*To get rid of '\n'*/

        System.out.println("Name of exercise 3:");
        exercise3=input.nextLine();
        System.out.println("Score received for exercise 3:");
        score3=input.nextInt();
        System.out.println("Total points possible for exercise 3:");
        totalpossiblepoints3=input.nextInt();;
        String junk3 = input.nextLine();  /*To get rid of '\n'*/

        marks=score1+score2+score3;
        grandtotal=totalpossiblepoints1+totalpossiblepoints2+totalpossiblepoints3;



        System.out.printf("%-30s  %-10s %-15s %n","Exercise","Score","Total Possible");
        System.out.printf("%-30s  %-10d %-15d %n",exercise1,score1,totalpossiblepoints1);
        System.out.printf("%-30s  %-10d %-15d %n",exercise2,score2,totalpossiblepoints2);
        System.out.printf("%-30s  %-10d %-15d %n",exercise3,score3,totalpossiblepoints3);
        System.out.printf("%-30s  %-10d %-15d %n","Total",marks,grandtotal);
        System.out.println("Your total "+marks+" out of "+ grandtotal+", or "+percent.format((double)marks /grandtotal )+".");

    }
}
