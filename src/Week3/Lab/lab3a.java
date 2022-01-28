package Week3.Lab;

import java.util.Scanner;

/*
While diff is a useful text-processing utility that finds differences between the contents of two files,
this naive diff will start out as a simplistic check, counting how many of the leading characters of
two lines of text are the same.

Input Specification:
The first line contains N, 1 ≤ N ≤ 25, the number of text pairs to be compared.
The next (N*2) lines will contain N sets of input, two lines each.
Each line will be a non-empty string less than 255 characters long.

Output Specification:
The output will comprise of N lines, each printing an integer 0 ≤ i ≤ 255
the number of leading characters that are same between the two lines, up to the first difference.
Note that the two lines could be of different lengths.
The counter stops before the first character that doesn’t match,
so two strings that start differently would have a result of 0.
*/
public class lab3a
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String inputNumberInString = keyboard.nextLine();
        int inputNumber = 0;
        try
        {
            inputNumber = Integer.parseInt(inputNumberInString);
        }
        catch (Exception e)
        {
            System.exit(0);
        }

        if(inputNumber<1||inputNumber>25)
        {
            System.exit(0);
        }

        int line = inputNumber*2;
        String[] list = new String[line];

        for(int i = 0; i < list.length; i++)
        {
            list[i] = keyboard.nextLine();
            if (list[i].isEmpty())
            {
                System.exit(0);
            }
            if (list[i].length()>255)
            {
                System.exit(0);
            }
        }

        int[] outputList = new int[inputNumber];
        for(int i = 0; i < list.length; i++)
        {
            if(i%2==1)
                continue;

            char firstChar1 = list[i].charAt(0);
            char firstChar2 = list[i+1].charAt(0);
            if(firstChar1 != firstChar2)
            {
                outputList[i/2] = 0;
            }

            int indexString = 0;
            while(indexString<list[i].length()&&indexString<list[i+1].length()&&list[i].charAt(indexString) == list[i+1].charAt(indexString))
            {
                indexString++;
            }
            outputList[i/2] = indexString;
        }

        for(int i = 0; i < outputList.length; i++)
        {
            System.out.println(outputList[i]);
        }
    }
}
