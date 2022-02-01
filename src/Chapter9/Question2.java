package Chapter9;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Here is a snippet of code that inputs two integers and divides them:
Scanner scan = new Scanner(System.in);
int n1, n2;
double r;
n1 = scan.nextInt();
n2 = scan.nextInt();
r = ( double) n1 / n2;
Place this code into a try-catch block with multiple catches so that different error messages are printed
if we attempt to divide by zero or if the user enters textual data instead of integers.
If either of these conditions occurs, then the program should loop back and let the user enter new data.
*/
public class Question2
{
}

// DivisionByZeroException.java
class DivisionByZeroException extends Exception
{
    public DivisionByZeroException()
    {
        super("Division by zero!");
    }

    public DivisionByZeroException(String msg)
    {
        super(msg);
    }
}

class ExceptionDemo
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n1, n2;
        double r;
        boolean solved = false;

        while(!solved)
        {
            try
            {
                System.out.print("Please enter a value for n1: ");
                n1 = scan.nextInt();

                System.out.print("Please enter a value for n2: ");
                n2 = scan.nextInt();

                if(n2 == 0)
                    throw new DivisionByZeroException();

                r = (double) n1 / n2;

                System.out.println("Result:  " + n1 + "/" + n2 + " = " + r);

                solved = true;
            }
            catch(InputMismatchException imme)
            {
                scan.nextLine();
                System.out.println("The user enters textual data instead of integers. Try again! \n");
            }
            catch(DivisionByZeroException dbze)
            {
                scan.nextLine();
                System.out.println("The user attempts to divide by zero. Try again! \n");
            }
            catch(Exception e)
            {
                scan.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }
}
