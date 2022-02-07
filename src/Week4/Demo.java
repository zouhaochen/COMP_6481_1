package Week4;
import java.util.*;

public class Demo
{

}
class POD
{
    public static int maxSumLeftRight(int arr[], int l, int m, int h)
    {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;

        for (int i = m; i >= l; i--)
        {
            sum = sum + arr[i];
            if (sum > left_sum)
            {
                left_sum = sum;
            }
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++)
        {
            sum = sum + arr[i];
            if (sum > right_sum)
            {
                right_sum = sum;
            }
        }

        return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
    }

    public static int maxSubArraySum(int arr[], int l, int h)
    {
        if (l == h)
        {
            return arr[l];
        }

        int m = (l + h) / 2;

        return Math.max(Math.max(maxSubArraySum(arr, l, m), maxSubArraySum(arr, m + 1, h)), maxSumLeftRight(arr, l, m, h));
    }

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

        int length = inputInInteger.length;

        int max = maxSubArraySum(inputInInteger, 0, length-1);
        System.out.println(max);
    }
}