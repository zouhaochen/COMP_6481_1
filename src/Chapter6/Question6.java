package Chapter6;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads numbers from the keyboard into an array of type int[].
You may assume that there will be 50 or fewer entries in the array.
Your program allows any number of numbers to be entered, up to 50.
The output is to be a two-column list.
The first column is a list of the distinct array elements;
the second column is the count of the number of occurrences of each element.
The list should be sorted on entries in the first column, largest to smallest.
*/
public class Question6
{
}

class NumberArray
{
    private static void reverseSort(int arr[])
    {
        for(int i =0; i < arr.length; i++)
        {
            arr[i] = (arr[i] * -1);
        }
        Arrays.sort(arr);
        for(int i =0; i < arr.length; i++)
        {
            arr[i] = (arr[i] * -1);
        }
    }

    private static void getCountTable(int arr[])
    {
        int count = 1;
        System.out.printf("Number Count\n");
        for (int i = 0, length = arr.length; i < length; i++)
        {
            if (i < length - 1)
            {
                if (arr[i] == arr[i + 1])
                {
                    count++;
                }
            }
            else
                {
                    System.out.printf("%6d%6d\n", arr[i], count);
                }
            if (i < length - 1 && arr[i] != arr[i + 1])
            {
                System.out.printf("%6d%6d\n", arr[i], count);
                count = 1;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("How many number entries in the array? (at most 50)");
        int[] numberArray = new int[input.nextInt()];

        System.out.println("Enter in the array numbers with a space: ");
        for(int i = 0; i < numberArray.length; i++)
        {
            numberArray[i] = input.nextInt();
        }

        reverseSort(numberArray);
        getCountTable(numberArray);
    }
}
