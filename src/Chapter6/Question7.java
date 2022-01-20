package Chapter6;

import java.util.Scanner;

/*
An array can be used to store large integers one digit at a time.
For example, the integer 1234 could be stored in the array a by setting
a[0] to 1, a[1] to 2, a[2] to 3, and a[3] to 4.
However, for this exercise you might find it more useful to store the digits backward;
that is, place 4 in a[0], 3 in a[1], 2 in a[2], and 1 in a[3].
In this exercise, write a program that reads in 2 positive integers that are 20 or fewer digits in length and
then outputs the sum of the 2 numbers.
Your program will read the digits as values of type char so that the number 1234 is read as the four characters
'1', '2', '3', and '4'.
After they are read into the program, the characters are changed to values of type int .
The digits should be read into a partially filled array;
you might find it useful to reverse the order of the elements in the array after the array is filled with
data from the keyboard.
(Whether or not you reverse the order of the elements in the array is up to you.
It can be done either way, and each way has its advantages and disadvantages.)
Your program should perform the addition by implementing the usual paper-and-pencil addition algorithm.
The result of the addition should be stored in an array of size 20,
and the result should then be written to the screen.
If the result of the addition is an integer with more than the maximum number of digits
(that is, more than 20 digits), then your program should issue a message saying that
it has encountered “integer overflow.”
You should be able to change the maximum length of the integers by changing only one named constant.
Include a loop that allows the user to continue to do more additions until the user says the program should end.
*/
public class Question7
{
}

class SumNumsDemo
{
    public static int getNum(char convNumToCh)
    {
        return (int) (convNumToCh - 48);
    }

    public static void main(String[] args)
    {

        Scanner scn = new Scanner(System.in);
        String choice = "y";
        while (choice.equals("y"))
        {
            final int lenMax = 20;
            char[] arrNum1 = new char[lenMax];
            char[] arrNum2 = new char[lenMax];
            System.out.print("Enter the First positive integer: ");
            String num1 = scn.nextLine();
            System.out.print("Enter the second positive integer: ");
            String num2 = scn.nextLine();
            int sizeOfNum1 = num1.length();
            int sizeOfNum2 = num2.length();
            while (!num1.equals("")) {
                char digit = num1.charAt(num1.length() - 1);
                arrNum1[sizeOfNum1 - num1.length()] = digit;
                num1 = num1.substring(0, num1.length() - 1);
            }
            while (!num2.equals(""))
            {
                char digit = num2.charAt(num2.length() - 1);
                arrNum2[sizeOfNum2 - num2.length()] = digit;
                num2 = num2.substring(0, num2.length() - 1);
            }
            long resultSum = 0;
            int smallNum = Math.min(sizeOfNum1, sizeOfNum2);
            int largerNum = Math.max(sizeOfNum1, sizeOfNum2);

            long findSize = 1;
            boolean carry = false;
            for (int i = 0; i < smallNum; i++)
            {
                long sum = getNum(arrNum1[i]) + getNum(arrNum2[i]);
                if (carry) {
                    sum++;
                    carry = false;
                }
                if (sum >= 10)
                {
                    carry = true;
                    sum = sum % 10;
                }

                resultSum += sum * findSize;
                findSize *= 10;
            }
            if (smallNum == sizeOfNum1)
            {
                for (int i = smallNum; i < largerNum; i++)
                {
                    int presentDigit = getNum(arrNum2[i]);
                    if (carry) {
                        presentDigit++;
                        carry = false;
                    }
                    if (presentDigit == 10)
                    {
                        presentDigit = 0;
                        carry = true;
                    }

                    resultSum += presentDigit * findSize;
                    findSize *= 10;
                }
            } else
            {
                for (int i = smallNum; i < largerNum; i++)
                {
                    int presentDigit = getNum(arrNum1[i]);
                    if (carry) {
                        presentDigit++;
                        carry = false;
                    }
                    if (presentDigit == 10)
                    {
                        presentDigit = 0;
                        carry = true;
                    }
                    resultSum += presentDigit * findSize;
                    findSize *= 10;
                }

            }
            if (carry)
                resultSum += findSize;

            if (largerNum >= lenMax && carry)
                System.out.println("Integer overflow!");
            else
                System.out.println("Sum= " + resultSum);
            System.out.print("Do you want to continue? (y/n):");
            choice = scn.nextLine();
        }
    }
}
