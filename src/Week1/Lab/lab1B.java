package Week1.Lab;

import java.util.Scanner;

/*
Most credit card numbers are encoded with a "Check Digit".
It is a digit added to a number that validates the authenticity of the number.

Write a java program to validate a given credit card number.
For this problem, you should make use of the LUHN Formula (Mode 10) for validating credit card numbers.
The algorithm has following steps:

Step 1: Double the value of alternate digits of the credit card number
beginning with the second digit from the right (the rightmost digit is the check digit)
Step 2: Add the individual digits comprising the products obtained in Step 1
Step 3: The total obtained in Step 2 must be a number ending in zero for the account number to be validated.
The total mod 10 = 0;

Output: If the credit card number is valid, output the word "VALID".
If the credit card number is not valid, output the word "INVALID" followed by a space and the correct check digit,
which is the right-most digit, which would make the credit card number valid.
*/
public class lab1B
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String cardNumber = keyboard.nextLine();
        cardNumberCheck(cardNumber);
        cardNumberValidate(cardNumber);
    }

    public static void cardNumberCheck(String cardNumber)
    {
        if(cardNumber.length()<20)
        {
            for (int i = 0; i < cardNumber.length(); i++)
            {
                char item = cardNumber.charAt(i);
                if (item == '0' || item == '1' || item == '2' || item == '3' || item == '4' || item == '5'
                        || item == '6' || item == '7' || item == '8' || item == '9')
                {
                }
                else
                    System.exit(0);
            }
        }
        else
        {
            System.exit(0);
        }
    }

    public static void cardNumberValidate(String cardNumber)
    {
        int digitNumber = cardNumber.length();

        if (digitNumber == 1)
        {
            if (cardNumber.equals("0"))
            {
                System.out.println("VALID");
            }
            else
            {
                System.out.println("INVALID "+0);
            }
        }
        else
        {
            int sum = 0;
            for (int i = digitNumber-1, j = 1; i >= 0; i--, j++)
            {
                int individualSum = 0;
                int numberAtPosition = cardNumber.charAt(i) - '0';
                if (j%2==0)
                {
                    numberAtPosition = numberAtPosition * 2;
                    if (numberAtPosition >= 10)
                    {
                        individualSum = numberAtPosition / 10 + numberAtPosition % 10;
                    }
                    else
                    {
                        individualSum = numberAtPosition;
                    }
                }
                else
                {
                    individualSum = numberAtPosition;
                }
                sum = sum + individualSum;
            }

            if(sum%10 == 0)
            {
                System.out.println("VALID");
            }
            else
            {
                int lastDigit = cardNumber.charAt(cardNumber.length()-1)-'0';
                int remainder = sum%10;
                int correctDigit = lastDigit-remainder;
                if (correctDigit>0)
                {
                    System.out.println("INVALID "+correctDigit);
                }
                else
                {
                    correctDigit = correctDigit + 10;
                    System.out.println("INVALID "+correctDigit);
                }
            }
        }
    }
}
