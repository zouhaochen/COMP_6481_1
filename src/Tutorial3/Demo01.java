package Tutorial3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo01
{
    public static void main(String[] args)
    {
    }

    public static void cat(File named)
    {
        RandomAccessFile input = null;
        String line = null;

        try
        {
            input = new RandomAccessFile(named, "r");
            while ((line = input.readLine())!=null)
            {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File: "+named+" not found.");
        }
        catch (Exception e)
        {
            System.err.println(e.toString());
        }
        finally
        {
            if(input!=null)
            {
                try
                {
                    input.close();
                }
                catch (IOException e)
                {

                }
            }
        }
    }
}
