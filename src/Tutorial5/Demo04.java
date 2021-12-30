package Tutorial5;

import java.io.*;

/*
Assume that the file size is big then the previous solution might not work.
Now modify the previous problem so that it can copy block of size 4KB at a time.
*/
public class Demo04
{
    public static void main(String[] args)
    {
        String inputFile = "input.bin";
        String outputFile = "output.bin";

        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile))
        {
            byte[] buffer = new byte[4096];
            while(inputStream.read(buffer)!=-1)
            {
                outputStream.write(buffer);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
