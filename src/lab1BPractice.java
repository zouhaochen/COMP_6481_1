import java.util.Scanner;

public class lab1BPractice
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
                if (correctDigit>=0)
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
