package Tutorial5;

import java.io.*;

/*
Read binary file input.bin and write the content to output.bin by reading each byte using FileInputStream and FileOutputStream
*/
public class Demo03
{
    public static void main(String[] args)
    {
        String inputFile = "input.bin";
        String outputFile = "output.bin";

        try(InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);)
        {
            int byteRead;
            while((byteRead = inputStream.read())!=-1)
            {
                outputStream.write(byteRead);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
