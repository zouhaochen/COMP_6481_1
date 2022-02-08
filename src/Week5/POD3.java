package Week5;

import java.util.Scanner;

/*
Description Determine if it is possible to produce two triangles of given side lengths,
by cutting some rectangle with a single line segment, and freely rotating and flipping the resulting pieces.
Input
The input consists of two lines.
The first line contains three space-separated positive integers,
indicating the desired side lengths of the first triangle.
Similarly, the second line contains three space-separated positive integers,
denoting the desired side lengths of the second triangle.
It is guaranteed that the side lengths produce valid triangles.
All side lengths are less than or equal to 100.
Output
Print, on a single line, whether there exists a rectangle which could have been cut to form
triangles of the given side lengths.
If such a rectangle exists, print YES. Otherwise, print NO.
*/
public class POD3
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        String inputSecond = keyboard.nextLine();

        String[] inputEach = input.split(" ");
        int[] inputEachInInteger = new int[inputEach.length];

        String[] inputEachSecond = inputSecond.split(" ");
        int[] inputEachInIntegerSecond = new int[inputEachSecond.length];

        if(inputEach.length!=3 || inputEachSecond.length!=3)
        {
            System.exit(0);
        }

        for(int i = 0; i < inputEach.length; i++)
        {
            try
            {
                inputEachInInteger[i] = Integer.parseInt(inputEach[i]);
            }
            catch (Exception e)
            {
                System.exit(0);
            }
        }

        for(int i = 0; i < inputEachSecond.length; i++)
        {
            try
            {
                inputEachInIntegerSecond[i] = Integer.parseInt(inputEachSecond[i]);
            }
            catch (Exception e)
            {
                System.exit(0);
            }
        }

        for (int i = 0; i < inputEachInInteger.length; i++)
        {
            if(inputEachInInteger[i] < 1 || inputEachInInteger[i] > 100)
                System.exit(0);
        }

        for (int i = 0; i < inputEachInIntegerSecond.length; i++)
        {
            if(inputEachInIntegerSecond[i] < 1 || inputEachInIntegerSecond[i] > 100)
                System.exit(0);
        }

        sort(inputEachInInteger);
        sort(inputEachInIntegerSecond);

        int k = 0;

        for(int i = 0; i < 3; i++)
        {
            if (inputEachInInteger[i] == inputEachInIntegerSecond[i])
            {
                k++;
            }
        }

        if(inputEachInInteger[0]*inputEachInInteger[0]+inputEachInInteger[1]*inputEachInInteger[1]==inputEachInInteger[2]*inputEachInInteger[2] && k == 3)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }

    public static void sort(int[] inputInInteger)
    {
        for(int i = 0; i < inputInInteger.length - 1; i++)
        {
            for(int j = i + 1; j < inputInInteger.length; j++)
            {
                if (inputInInteger[i] > inputInInteger[j])
                {
                    int temp = inputInInteger[i];
                    inputInInteger[i] = inputInInteger[j];
                    inputInInteger[j] = temp;
                }
            }
        }
    }
}
