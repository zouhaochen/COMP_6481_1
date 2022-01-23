package Chapter3;

import java.util.Random;

/*
You have three identical prizes to give away and a pool of 30 finalists.
The finalists are assigned numbers from 1 to 30.
Write a program to randomly select the numbers of three finalists to receive a prize.
Make sure not to pick the same number twice.
For example, picking finalists 3, 15, 29 would be valid but picking 3, 3, 31 would be invalid
because finalist number 3 is listed twice and 31 is not a valid finalist number.
*/
public class Question11
{
}

class ThreeFinalists
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int num, finalist1 = 0, finalist2 = 0, finalist3 = 0;

        do
        {
            num = 1 + rand.nextInt(30);

            if(finalist1 == 0)
            {
                finalist1 = num;
            }
            else if(finalist2 == 0 && finalist1 != num)
            {
                finalist2 = num;
            }
            else if(finalist3 == 0 && finalist1 != num &&  finalist2 != num)
            {
                finalist3 = num;
            }
        }
        while(finalist1 == 0 || finalist2 == 0 || finalist3 == 0);

        System.out.println("Finalist #1: " + finalist1);
        System.out.println("Finalist #2: " + finalist2);
        System.out.println("Finalist #3: " + finalist3);
    }
}