package Tutorial6;

/*
write a program that checks whether an input string is a palindrome or not using a stack
*/
public class Demo03
{
}

// Java implementation of the approach
class GFG
{
    static char [] stack;
    static int top = -1;

    // push function
    static void push(char ele)
    {
        stack[++top] = ele;
    }

    // pop function
    static char pop()
    {
        return stack[top--];
    }

    // Function that returns 1
    // if str is a palindrome
    static int isPalindrome(char str[])
    {
        int length = str.length;

        // Allocating the memory for the stack
        stack = new char[length * 4];

        // Finding the mid
        int i, mid = length / 2;

        for (i = 0; i < mid; i++)
        {
            push(str[i]);
        }

        // Checking if the length of the String
        // is odd, if odd then neglect the
        // middle character
        if (length % 2 != 0)
        {
            i++;
        }

        // While not the end of the String
        while (i < length)
        {
            char ele = pop();

            // If the characters differ then the
            // given String is not a palindrome
            if (ele != str[i])
                return 0;
            i++;
        }

        return 1;
    }

    // Driver code
    public static void main(String[] args)
    {
        char str[] = "madam".toCharArray();

        if (isPalindrome(str) == 1)
        {
            System.out.printf("Yes");
        }
        else
        {
            System.out.printf("No");
        }
    }
}