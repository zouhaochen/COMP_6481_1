package Chapter6;

import java.util.Random;
import java.util.Scanner;

/*
Traditional password entry schemes are susceptible to “shoulder surfing”
in which an attacker watches an unsuspecting user enter his or her password or PIN number and
uses it later to gain access to the account.
One way to combat this problem is with a randomized challenge-response system.
In these systems, the user enters different information every time
based on a secret in response to a randomly generated challenge.
Consider the following scheme in which the password consists of a five-digit PIN number (00000 to 99999).
Each digit is assigned a random number that is 1, 2, or 3.
The user enters the random numbers that correspond to their PIN instead of their actual PIN numbers.

For example, consider an actual PIN number of 12345.
To authenticate it, the user would be presented with a screen such as the following:
PIN: 0 1 2 3 4 5 6 7 8 9
NUM: 3 2 3 1 1 3 2 2 1 3

The user would enter 23113 instead of 12345.
This does not divulge the password even if an attacker intercepts the entry
because 23113 could correspond to other PIN numbers, such as 69440 or 70439.
The next time the user logs in, a different sequence of random numbers would be generated,
such as the following:
PIN: 0 1 2 3 4 5 6 7 8 9
NUM: 1 1 2 3 1 2 2 3 3 3

Your program should simulate the authentication process.
Store an actual PIN number in your program.
The program should use an array to assign random numbers to the digits from 0 to 9.
Output the random digits to the screen, input the response from the user,
and output whether or not the user’s response correctly matches the PIN number.
*/
public class Question14
{
}

class PinNumber
{
    public static int [] random_numbers = new int[10];
    public static int [] password_encrypted = new int[5];
    public static String password = "12345";
    public static void main(String[] args)
    {
        boolean result = false;
        Scanner keyboard =new Scanner(System.in);

        while(result == false)
        {
            random_number_generation();
            print_random_numbers();
            encrypt_password(password);
            System.out.println(" \n");
            System.out.println("Enter Pin according to above Encryption \n");
            String user_input = keyboard.nextLine();

            if(verification(user_input))
            {
                System.out.println(" Correct PIN MATCH !");
                result = true;
            }
            else
                {
                    System.out.println(" InCorrect PIN Try Again !");
                    result=false;
                }
        }
    }

    public static void random_number_generation()
    {
        Random rand = new Random();
        for(int i =0; i<random_numbers.length; i++)
        {
            random_numbers[i] = (int)((rand.nextFloat()*3)+1);

        }
    }

    public static void print_random_numbers()
    {
        System.out.println("PIN : 0 1 2 3 4 5 6 7 8 9");
        System.out.printf("NUM : ");

        for(int i =0; i<random_numbers.length;i++)
        {
            System.out.printf("%d ", random_numbers[i]);
        }

    }

    public static void encrypt_password(String password)
    {
        String [] input_password =password.split("");
        for(int i =0;i<input_password.length;i++)
        {
            int index = Integer.parseInt(input_password[i]);

            password_encrypted[i] = random_numbers[index];
        }
    }

    public static boolean verification(String input_password)
    {
        String [] user_input = input_password.split("");
        if(user_input.length != 5)
        {return false;}

        for(int i=0;i<user_input.length;i++)
        {
            if(Integer.parseInt(user_input[i]) != password_encrypted[i])
            {  return false;}
        }
        return true;
    }

}
