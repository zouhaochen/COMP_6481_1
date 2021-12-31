package Tutorial6;

/*
write a program that reads in a positive integer and prints the binary representation of that integer
Hint: divide the integer by 2
*/
class Demo02
{
    public static void bin(int n)
    {
        /* step 1 */
        if (n > 1)
            bin(n / 2);

        /* step 2 */
        System.out.print(n % 2);
    }

    // Driver code
    public static void main(String[] args)
    {
        bin(7);
        System.out.println();
        bin(4);
    }
}
