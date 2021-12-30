package Tutorial5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Read file "foo.txt" line by line using BufferedReader object and count the number of lines in file.
Report exception thrown by BufferedReader
*/
public class Demo02
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("foo.txt"));
            String contentLine = br.readLine();
            int lineNumber = 1;
            while(contentLine != null)
            {
                System.out.println(contentLine);
                contentLine = br.readLine();
                lineNumber++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
