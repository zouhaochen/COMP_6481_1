package Chapter10;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

/*
The text files boynames.txt and girlnames.txt, which are included in the source code for this book text,
contain a list of the 1,000 most popular boy and girl names in the United States for the year 2003
as compiled by the Social Security Administration.
These are blank-delimited files, where the most popular name is listed first,
the second most popular name is listed second, and so on, to the 1,000 th most popular name, which is listed last.
Each line consists of the first name followed by a blank space and then the number of registered births
using that name in the year. For example, the girlnames.txt file begins with
Emily 25494
Emma 22532
Madison 19986
This indicates that Emily was the most popular name with 25,494 registered namings,
Emma was the second most popular with 22,532, and Madison was the third most popular with 19,986.
Write a program that reads both the girl and boy files into memory using arrays.
Then, allow the user to input a name. The program should search through both arrays.
If there is a match, then it should output the popularity ranking and the number of namings.
The program should also indicate if there is no match.
For example, if the user enters the name “Justice,” then the program should output
Justice is ranked 456 in popularity among girls with 655 namings.
Justice is ranked 401 in popularity among boys with 653 namings.
If the user enters the name “Walter,” then the program should output
Walter is not ranked among the top 1000 girl names.
Walter is ranked 356 in popularity among boys with 775 namings.
 */
public class Question1
{
}
class NamesDemo
{
    private String[] nameBoys = new String[1000], nameGirls = new String[1000];
    private int[] numBoys = new int[1000], numGirls = new int[1000];

    public void readData(String fName)
    {
        String[] names = new String[1000];
        int[] total = new int[1000];

        try
        {
            String line = null;
            int countNum = 0;

            BufferedReader br = new BufferedReader(new FileReader(fName));
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(" ");
                names[countNum] = data[0];
                total[countNum] = Integer.parseInt(data[1]);
                countNum++;
            }

            if (fName == "boynames.txt")
            {
                this.nameBoys = names;
                this.numBoys = total;
            }
            else
            {
                this.nameGirls = names;
                this.numGirls = total;
            }
            br.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("An error contains in input file");
            e.printStackTrace();
        }
    }

    public void getNameData()
    {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a boy or girl name:");
        String name = scn.next();

        if (Arrays.asList(this.nameBoys).contains(name))
        {
            int index = Arrays.asList(this.nameBoys).indexOf(name);
            int occurences = numBoys[index];
            System.out.println(name + " is ranked " + (index + 1) + " in popularity " + "among boys with " + occurences + " namings.");
        }
        else
            System.out.println(name + " is not ranked among the top 1000 girl names.");

        if (Arrays.asList(this.nameGirls).contains(name))
        {
            int index = Arrays.asList(this.nameGirls).indexOf(name);
            int occurences = numGirls[index];
            System.out.println(name + " is ranked " + (index + 1) + " in popularity " + "among girls with " + occurences + " namings.");
        }
        else
            System.out.println(name + " is not ranked among the top 1000 girl names.");
    }

    public static void main(String[] args)
    {
        NamesDemo  nd= new NamesDemo();
        nd.readData("boynames.txt");
        nd.readData("girlnames.txt");
        nd.getNameData();
    }
}