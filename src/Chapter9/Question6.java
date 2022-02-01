package Chapter9;

import java.util.*;

/*
Write a program that can serve as a simple calculator.
This calculator keeps track of a single number (of type double ) that is called result and that starts out as 0.0.
Each cycle allows the user to repeatedly add, subtract, multiply, or divide by a second number.
The result of one of these operations becomes the new value of result.
The calculation ends when the user enters the letter R for “result” (either in upper- or lowercase).
The user is allowed to do another calculation from the beginning as often as desired.
The input format is shown in the following sample dialogue.
If the user enters any operator symbol other than + , −, * , or / ,
then an UnknownOperatorException is thrown and the user is asked to reenter that line of input.
Defining the class UnknownOperatorException is part of this project.
*/
public class Question6
{
}

class SimpleCalculator
{
    // definition of performOperation method
    public static double performOperation(double value, String activity) throws UnknownOperatorException
    {
        //Get the first character of the String action
        String arthOpter = activity.substring(0, 1);
        if(!arthOpter.equals("+") && !arthOpter.equals("-") && !arthOpter.equals("*") && !arthOpter.equals("/") && !arthOpter.equals("R") && !arthOpter.equals("r"))
            throw new UnknownOperatorException(arthOpter);

        if(arthOpter.equals("R") || arthOpter.equals("r"))
            return value;

        //Get all the characters exclude the first character of the String
        // action
        double number = Double.parseDouble(activity.substring(1, activity.length()));

        System.out.print("result " + arthOpter + " " + number + " = ");
        if(arthOpter.equals("+"))
            return value += number;
        else if(arthOpter.equals("-"))
            return value -= number;
        else if(arthOpter.equals("*"))
            return value *= number;
        else
            return value /= number;
    }

    // main method
    public static void main(String args[])
    {
        // object for Scanner class
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        String decision = "y";
        System.out.println("Calculator is on.");

        //Check whether the first character of the string decision is y or Y
        while(decision.charAt(0) == 'y'|| decision.charAt(0) == 'Y')
        {
            int count=0;
            double result = 0.0;
            String arthOpter = "";
            System.out.println("result = " + result);
            // Check whether the string operator is r or R
            while(!arthOpter.equals("R") && !arthOpter.equals("r"))
            {
                arthOpter = input.nextLine();
                try
                {
                    result = performOperation(result, arthOpter);
                    count++;
                    if(!arthOpter.equals("R")
                            && !arthOpter.equals("r"))
                    {
                        if(count==1)
                        {
                            System.out.println(result);
                            System.out.println("New result = "+ result);
                        }
                        else
                        {
                            System.out.println(result);
                            System.out.println("Updated result = "
                                    + result);
                        }
                    }
                }
                catch(UnknownOperatorException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Reenter, your last line.");
                }
            }
            System.out.println("Final result = " + result);
            System.out.println("Again? (y/n)");
            decision = input.nextLine();
        }
        System.out.println("End of Program.");
    }
}

class UnknownOperatorException extends Exception
{
    // definition of UnknownOperatorException constructor
    public UnknownOperatorException(String operator)
    {
        super(operator + " is an unknown operation.");
    }
}
