package Chapter5;

/*
First, complete Programming Project 4.13 from Chapter 4.
Modify the main method with a loop so that an arbitrary number of BoxOfProduce objects are created and
substitutions are allowed for each box. Add a menu so the user can decide when to stop creating boxes.
You would like to throw in a free recipe flyer for salsa verde if the box contains tomatillos.
However, there are only five recipe flyers.
Add a static variable to the BoxOfProduce class that counts the number of recipe flyers remaining and
initialize it to 5.
Also add an instance variable that indicates whether or not the box contains a recipe flyer and
modify the toString() method to also output “salsa verde recipe ” if the box contains a recipe flyer.
Finally, add logic inside the class so that if the box contains at least one order of tomatillos then
it automatically gets a recipe flyer until all of the recipe flyers are gone.
Note that a box should only get one recipe flyer even if there are multiple orders of tomatillos.
Test your class by creating boxes with tomatillos from your menu until all of the flyers are gone.
*/
public class Question10
{
}

class BoxOfProduce
{
    private final int SIZE_LENGTH=20;
    int size;
    private String[] itemType=new String[SIZE_LENGTH];

    public BoxOfProduce(String[] items)
    {
        size=0;
        setFirstFruit(items[0]);
        setSecondFruit(items[1]);
        setThirdFruit(items[2]);
    }

    public void add(String fruit)
    {
        if(this.size()<SIZE_LENGTH)
        {
            itemType[size]=fruit;
            size=size+1;
        }
    }

    public void insertAt(int index,String fruit)
    {
        itemType[index-1]=fruit;
    }

    public void setFirstFruit(String firstItemType)
    {
        itemType[size]=firstItemType;
        size=size+1;
    }

    public void setSecondFruit(String secondItemType)
    {
        itemType[size]=secondItemType;
        size=size+1;
    }

    public void setThirdFruit(String thirdItemType)
    {
        itemType[size]=thirdItemType;
        size=size+1;
    }

    public int size()
    {
        return size;
    }

    public String toString()
    {
        String items="";
        for (int index = 0; index < size; index++)
            items+=itemType[index]+"\n";
        return items;
    }
}