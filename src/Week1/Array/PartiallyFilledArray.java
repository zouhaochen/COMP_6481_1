package Week1.Array;

/*
Class for a partially filled array of doubles。
The class enforces the following invariant:
All element are at the beginning of the array in locations 0, 1, 2, and so forth up to
a highest index with no gaps.
 */
public class PartiallyFilledArray
{
    private int maxNumberElement;
    private double[] a;
    private int numberUsed;
    private int maxCapacity;

    /*
    Set the maximum number of allowable elements to 10;
     */
    PartiallyFilledArray()
    {
        maxNumberElement = 10;
        a = new double[maxNumberElement];
        numberUsed = 0;
    }

    /*
    Precondition arraySize > 0.
     */
    PartiallyFilledArray(int arraySize)
    {
        if(arraySize <= 0)
        {
            System.out.println("Error array size zero or negative");
            System.exit(0);
        }
        maxNumberElement = arraySize;
        a = new double[maxNumberElement];
        numberUsed = 0;
    }

    PartiallyFilledArray(PartiallyFilledArray original)
    {
        if(original == null)
        {
            System.out.println("Fatal Error: aborting program.");
            System.exit(0);
        }
        maxNumberElement = original.maxNumberElement;
        numberUsed = original.numberUsed;
        a = new double[maxNumberElement];
        for(int i = 0; i < numberUsed; i++)
            a[i] = original.a[i];
    }

    /*
    Adds newElement to the first unused array position
     */
    public void add(double newElement)
    {
        if(numberUsed >= a.length)
        {
            System.out.println("ERROR: Adding to a full array");
        }
        else
        {
            a[numberUsed] = newElement;
            numberUsed++;
        }
    }

    public double getElement(int index)
    {
        if(index < 0 || index >= numberUsed)
        {
            System.out.println("ERROR: Illegal or unused index.");
            System.exit(0);
        }
        return a[index];
    }

    /*
    index must be an index in use or the first unused index.
     */
    public void resetElement(int index, double newValue)
    {
        if(index < 0 || index >= maxNumberElement)
        {
            System.out.println("Error: Illegal index.");
            System.exit(0);
        }
        else if(index > numberUsed)
        {
            System.out.println("Error: Changing an index that is too large.");
            System.exit(0);
        }
        else
            a[index] = newValue;
    }

    public void deleteLast()
    {
        if(empty())
        {
            System.out.println("Error: Deleting from an empty array.");
            System.exit(0);
        }
        else
            numberUsed--;
    }

    /*
    Deletes the element in position index.
    Move down all elements with indices higher than the deleted element.
     */
    public void delete(int index)
    {
        if(index < 0 || index >= numberUsed)
        {
            System.out.println("Error: Illegal or unused index.");
            System.exit(0);
        }
        for(int i = index; i < numberUsed; i++)
            a[i] = a[i+1];
        numberUsed--;
    }

    public boolean empty()
    {
        return (numberUsed==0);
    }

    public boolean full()
    {
        return (numberUsed == maxNumberElement);
    }

    public int getMaxNumberElement()
    {
        return maxNumberElement;
    }

    public int getNumberOfElement()
    {
        return numberUsed;
    }

    public int getMaxCapacity()
    {
        return maxCapacity;
    }
}
