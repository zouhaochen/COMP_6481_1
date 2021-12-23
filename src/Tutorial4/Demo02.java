package Tutorial4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo02
{
    public static void main(String[] args)
    {
        Scanner inputStream = null;
        String nameFile = "";
        try
        {
            inputStream = new Scanner(new FileInputStream(nameFile));
            if(inputStream.hasNext())
            {
                int min = inputStream.nextInt();
                int max = min;
                double sum = min;
                int nbelm = 1;
                while (inputStream.hasNext())
                {
                    int temp = inputStream.nextInt();
                    if (temp < min)
                    {
                        min = temp;
                    }
                    if (temp > max)
                    {
                        max = temp;
                    }
                    sum += temp;
                    nbelm++;
                }
                System.out.println("The min is: "+min);
                System.out.println("The max is: "+max);
                System.out.println("The mean is: "+sum/nbelm);
                inputStream.close();
            }
            else
            {
                System.out.println("The file is empty");
                System.exit(0);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file "+nameFile+"does noy exist!");
            System.out.println("or could not be opened");
            System.exit(0);
        }
        catch (IllegalStateException e)
        {
            System.out.println("Problem trying to read the file");
        }
    }
}
