package Chapter1;

/*
A government research lab has conclude that an artificial sweetener commonly used in diet soda pop will cause death
in laboratory mice.
A friend of yours is desperate to lose weight but cannot give up soda pop.
Your friend wants to know how much diet soda pop it is possible to drink without dying as a result.
Write a program to supply the answer.

The program has no input but does have defined constants for the following items:
the amount of artificial sweetener needed to kill a mouse.
the weight of the mouse.
the starting weight of the dieter.
the desired weight of the dieter.

To insure the safety of your friend, be sure the program uses the weight at which the dieter will stop dieting,
rather than the dieter's current weight, to calculate how much soda pop the dieter can safely drink.
You may use any reasonable values for these defined constants.
Assume that diet soda contains 1/10th of 1% artificial sweeter. Use another named constant for this fraction.
You may want to express the percent as the double value 0.001.
*/
public class Question4
{
    public static void main(String []args)
    {
        double killMouse =0.0000013;
        double weightMouse = 0.020;
        double dieterStart = 120.0;
        double desiredWeight =90.0;
        //Variable declaration
        double safetySoda;
        final double PERCENTAGE_OF_ArtificialSweetener = 0.001;

        // Calculate the proportionate fatal amount of
        // soda for safety
        safetySoda = (killMouse / weightMouse)
                * desiredWeight / PERCENTAGE_OF_ArtificialSweetener;
        //Print result on screen
        System.out.printf("The dieter can safely have up" + " to "+safetySoda + " drink.");

    }
}
