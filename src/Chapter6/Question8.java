package Chapter6;

public class Question8
{
}
class Bubble
{
    public static void main(String args[])
    {
        int[] elements = { 159, 77, 543, 38, 19, 115, 93};
        System.out.println("Un-sorted array elements are:");
        for(int i = 0; i < elements.length; i++)
            System.out.print(elements[i] + " ");
        System.out.println();
        BubbleSort sorter = new BubbleSort();
        sorter.sort(elements);
        System.out.println("\nAscending sorted array elements by using bubble sort:");
        for(int i = 0; i < elements.length; i++)
            System.out.print(elements[i] + " ");
    }
}
class BubbleSort
{
    public void sort(int[] index)
    {
        for(int outer = index.length - 1; outer > 0; outer--)
        {
            for(int inner = 0; inner < outer; inner++)
            {
                if(index[inner] > index[inner + 1])
                {
                    int temp = index[inner];
                    index[inner] = index[inner + 1];
                    index[inner + 1] = temp;
                }
            }
        }

    }
}
