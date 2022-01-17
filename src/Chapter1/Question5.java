package Chapter1;

import java.util.Scanner;

/*
Write a program that starts with a line of text and then output that line of text which
the first occurrence of "hate" changed to "love".
*/
public class Question5
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String text = keyboard.nextLine();

        changeText(text);
    }

    public static void changeText(String text)
    {
        int startIndex = text.indexOf("hate", 0);
        if(startIndex<0)
        {
            System.out.println("no string hate");
        }
        else
            {
                String frontSubstring = text.substring(0, startIndex);
                String backSubstring = text.substring(startIndex+4);
                System.out.println(frontSubstring+"love"+backSubstring);
            }
    }
}

class HateToLove
{
    public static final String STRING_TO_BE_CHANGED = "I hate you.";

    public static void main(String[] args)
    {
        String replacedString = STRING_TO_BE_CHANGED.replaceFirst("hate", "love");

        System.out.println("The line of text to be changed is:");
        System.out.println(STRING_TO_BE_CHANGED);

        System.out.println("I have rephrased that line to read:");
        System.out.println(replacedString);
    }
}