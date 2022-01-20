package Chapter6;

/*
Write a static method called deleteRepeats that has a partially filled array of characters as a formal parameter
and that deletes all repeated letters from the array.
Because a partially filled array requires two arguments, the method should actually have two formal parameters:
an array parameter and a formal parameter of type int that gives the number of array positions used.
When a letter is deleted, the remaining letters are moved one position to fill in the gap.
This create empty positions at the end of the array so that less of the array is used.
Because the formal parameter is a partially filled array, a second formal parameter of type int
should tell how many array positions are filled.
This second formal parameter cannot be changed by a Java method, so have the method return the new value
for this parameter.
*/
public class Question4
{
}

class DeleteRepeatsTest
{
    // Implementation of deleteRepeats method
    public static int deleteRepeats(char arr[], int size)
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = i + 1; j < size; j++)
            {
                if(arr[i] == arr[j])
                {
                    for(int k = j; k < size - 1; k++)
                    {
                        arr[k] = arr[k + 1];
                    }
                    size--;
                    j--;
                }
            }
        }
        return size;
    }
    public static void main(String[] args)
    {
        char[] a = new char[10];

        a[0] = 'a';
        a[1] = 'b';
        a[2] = 'a';
        a[3] = 'c';

        int size = 4;

        System.out.println("Array before deleting duplicates:");
        for(int i = 0; i < size; i++)
            System.out.println("a[" + i + "] = " + a[i]);

        System.out.println("Size: " + size);

        size = deleteRepeats(a, size);

        System.out.println("\nArray after deleting duplicates:");
        for(int i = 0; i < size; i++)
            System.out.println("a[" + i + "] = " + a[i]);

        System.out.println("Size: " + size);
    }
}
