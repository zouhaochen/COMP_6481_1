package Week3.POD;

import java.util.Scanner;

public class POD1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        String[] inputArray = input.split(",");
        int[] inputInInteger = inputTransfer(inputArray);
        int volume = getWaterVolume(inputInInteger);
        System.out.println(volume);
    }

    public static int[] inputTransfer(String[] inputArray)
    {
        int inputInt = 0;
        int[] inputArrayInt = new int[inputArray.length];

        for(int i = 0; i < inputArray.length; i++)
        {
            try
            {
                inputInt = Integer.parseInt(inputArray[i]);
            }
            catch (Exception e)
            {
                System.exit(0);
            }

            if (inputInt<0)
            {
                System.exit(0);
            }
            inputArrayInt[i] = inputInt;
        }
        return inputArrayInt;
    }

    public static int getWaterVolume(int[] inputArrayInt)
    {

        int[] waterVolume = new int[inputArrayInt.length];
        waterVolume[inputArrayInt.length-1] = inputArrayInt[inputArrayInt.length-1];

        for (int i = inputArrayInt.length-2; i >= 0; i--)
        {
            waterVolume[i] = Math.max(waterVolume[i+1], inputArrayInt[i]);
        }

        int waterVolumeSum = 0;

        int maxLeft = 0;
        for (int i = 0; i < inputArrayInt.length; i++)
        {
            if(maxLeft < inputArrayInt[i])
            {
                maxLeft = inputArrayInt[i];
            }
            int minRight = Math.min(maxLeft, waterVolume[i]);
            waterVolumeSum += (minRight - inputArrayInt[i]);
        }
        return waterVolumeSum;
    }

}
