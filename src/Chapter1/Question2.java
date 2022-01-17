package Chapter1;

import java.util.Scanner;

/*
The video game matches at your local arcade output coupons according to how well you play in the game.
You can redeem 10 coupons for a candy bar or 3 coupons for a gumball. You prefer candy bars to gumballs.
Write a program that defines a variable initially assigned to the number of coupons you win.
Next, the program should output how many candy bars and gumballs you can get if you spend all of your coupons
on candy bars first, and remaining coupons on gumballs.
*/
public class Question2
{

    public static final int COUPONS_PER_CANDYBAR = 10;
    public static final int COUPONS_PER_GUMBALL = 3;

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        int numbeOfCouponsWin = keyboard.nextInt();

        int numberOfCandybars = numbeOfCouponsWin / COUPONS_PER_CANDYBAR;

        int remainingCoupons = numbeOfCouponsWin % COUPONS_PER_CANDYBAR;

        int numberOfGumballs = remainingCoupons / COUPONS_PER_GUMBALL;

        remainingCoupons = remainingCoupons % COUPONS_PER_GUMBALL;

        System.out.println("Number of coupons win:       " + numbeOfCouponsWin);
        System.out.println("Number of candy bars get:    " + numberOfCandybars);
        System.out.println("Number of gumballs get:      " + numberOfGumballs);
        System.out.println("Number of remaining coupons: " + remainingCoupons);
    }
}
