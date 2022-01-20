package Chapter6;

import java.text.DecimalFormat;

/*
The standard deviation of a list of numbers is a measure of how much the numbers deviate from the average.
If the standard deviation is small, the numbers are clustered close to the average.
If the standard deviation is large, the numbers are scattered far from the average.

Define a static method that takes a partially filled array of numbers as its argument and
returns the standard deviation of the numbers in the partially filled array.
Because a partially filled array requires two arguments, the method should actually have two formal parameters,
an array parameter and a formal parameter of type int that gives the number of array positions used.
The numbers in the array should be of type double. Write a suitable test program for your method.
*/
public class Question5
{
}
class Main
{
    public static void main(String args[])
    {
        int sizeArray = 6;
        double[] nums = new double[10];
        DecimalFormat df=new DecimalFormat("#.##");
        nums[0] = 12.5;
        nums[1] = 53.0;
        nums[2] = 75.3;
        nums[3] = 89.12;
        nums[4] = 65.5;
        nums[5] = 80.0;
        System.out.println("The average standard deviation of a list of numbers is "
                +df.format(standardDevList(nums, sizeArray)));
    }
    public static double standardDevList(double[] n1, int n2)
    {
        double avg = 0;
        double avgStdDev = 0;
        for(int index = 0; index < n2; index++)
        {
            avg += n1[index];
        }
        avg /= n2;

        for(int index2 = 0; index2 < n2; index2++)
        {
            avgStdDev += (n1[index2] - avg) *
                    (n1[index2] - avg);
        }
        avgStdDev = Math.sqrt(avgStdDev / n2);
        return avgStdDev;
    }
}
