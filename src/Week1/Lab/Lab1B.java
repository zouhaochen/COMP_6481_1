package Week1.Lab;

import java.util.Scanner;

public class Lab1B
{
    public static void checkDigit(String cardNumber)
    {
        int digitNumber = cardNumber.length();


        if(digitNumber<20)
        {
            if(digitNumber==1)
            {
                if(cardNumber.equals("0"))
                    System.out.println("VALID");
                else
                    System.out.println("INVALID " + 0);

            }
            else {
                int sum = 0;
                boolean isSecond = false;
                for (int i = digitNumber - 1; i >= 0; i--) {
                    int j = cardNumber.charAt(i) - '0';

                    if (isSecond == true)
                        j = j * 2;

                    sum += j / 10;
                    sum += j % 10;

                    isSecond = !isSecond;
                }

                if (sum % 10 == 0)
                    System.out.println("VALID");
                else {
                    char lastDigit = cardNumber.charAt(cardNumber.length() - 1);
                    int remainder = sum % 10;
                    int checkDigit = lastDigit - '0';
                    int correctNumber = checkDigit - remainder;
                    if (correctNumber > 0)
                        System.out.println("INVALID " + correctNumber);
                    else
                        System.out.println("INVALID " + (correctNumber + 10));
                }
            }
        }
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String cardNumber = sc.nextLine();
        checkDigit(cardNumber);
    }
}