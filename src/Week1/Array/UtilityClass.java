package Week1.Array;

import java.util.Scanner;

public class UtilityClass
{
    /*
    Returns the largest of any number of int value
     */
    public static int max(int ... arg)
    {
        if(arg.length == 0)
        {
            System.out.println("Fatal Error: maximum of zero values.");
            System.exit(0);
        }

        int largest = arg[0];
        for(int i = 1; i < arg.length; i++)
        {
            if (arg[i] > largest)
                largest = arg[i];
        }
        return largest;
    }
}

class VariableParameterDemo
{
    public static void main(String[] args)
    {
        System.out.println("Enter scores for Tom, Dick and Harriet: ");
        Scanner keyboard = new Scanner(System.in);

        int tomsScore = keyboard.nextInt();
        int dickScore = keyboard.nextInt();
        int harrietScore = keyboard.nextInt();

        int highestScore = UtilityClass.max(tomsScore, dickScore, harrietScore);
        System.out.println("Highest score = " + highestScore);
    }
}
