package Tutorial5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
Week2.Inheritance.Read the whole file "foo.txt" line by line using Scanner object.
At the same time count the number of lines in file
*/
public class Demo01
{
    public static void main(String[] args) throws IOException
    {
        File text = new File("foo.txt");
        Scanner sc = new Scanner(text);

        int lineNumber = 1;
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            System.out.println("line "+lineNumber+" :" +line);
            lineNumber++;
        }
    }
}
