package Week4;

import java.util.*;

/*
You are given a one-dimensional array that may contain both positive and negative integers,
find the sum of a contiguous subarray of numbers that has the largest sum.
For example, if the given array is {-2, -5, 6, -2, -3, 1, 5, -6}, then the maximum subarray sum is 7.
The naive method is to run two loops.
The outer loop picks the beginning element,
the inner loop finds the maximum possible sum with the first element picked by the outer loop and
compares this maximum with the overall maximum.
Finally, return the overall maximum.
The time complexity of the Naive method is O(n^2).
Using Divide and Conquer approach, we can find the maximum subarray sum in O(nLogn) time.
Following is the Divide and Conquer algorithm:

1. Divide the given array into two halves
2. Return the maximum of the following three
Maximum subarray sum in left half (Make a recursive call)
Maximum subarray sum in right half (Make a recursive call)
Maximum subarray sum such that the subarray crosses the midpoint
*/
public class POD2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String inputValue = keyboard.nextLine();
        String[] inputEach = inputValue.split("\\.");

        for(int i = 0; i < inputEach.length; i++)
        {
            if(inputEach[i].matches("^-[0-9]*[1-9][0-9]*$"))
            {
                if(inputEach[i].charAt(1) == '0')
                {
                    System.exit(0);
                }
            }
            else if(inputEach[i].matches("^[0-9]*[1-9][0-9]*$"))
            {
                if(inputEach[i].charAt(0) == '0' && inputEach[i].charAt(1) == '0')
                {
                    System.exit(0);
                }
            }
            else if(inputEach[i].equals("0"))
            {
            }
            else
            {
                System.exit(0);
            }
        }

        int[] inputInInteger = new int[inputEach.length];

        for(int i = 0; i < inputEach.length; i++)
        {
            inputInInteger[i] = Integer.parseInt(inputEach[i]);
        }


        int[] integerFront;
        int[] integerBack;

        if(inputEach.length%2 == 0)
        {
            integerFront = new int[inputEach.length/2];
            integerBack = new int[inputEach.length/2];

            for(int i = 0; i < inputEach.length/2; i++)
            {
                integerFront[i] = inputInInteger[i];
            }

            for(int i = inputEach.length/2, j = 0; i < inputEach.length; i++, j++)
            {
                integerBack[j] = inputInInteger[i];
            }
        }
        else
        {
            int number = inputEach.length - 1;
            integerFront = new int[number/2];
            integerBack = new int[(number/2) + 1];

            for(int i = 0; i < number/2; i++)
            {
                integerFront[i] = inputInInteger[i];
            }

            for(int i = number/2, j = 0; i < inputEach.length; i++, j++)
            {
                integerBack[j] = inputInInteger[i];
            }
        }

        int sumFront = 0;

        for(int i = 0; i < integerFront.length; i++)
        {
            sumFront = sumFront + integerFront[i];
            if(sumFront <= 0)
            {
                sumFront = 0;
            }
        }

        int sumBack = 0;
        int sumBackMax = 0;


        for(int i = 0; i < integerBack.length; i++)
        {
            sumBack = sumBack + integerBack[i];
            if(sumBack > sumBackMax)
            {
                sumBackMax = sumBack;
            }
        }

        int sumTotal = sumFront + sumBackMax;
        System.out.println(sumTotal);
    }
}

