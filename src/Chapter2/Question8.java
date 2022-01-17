package Chapter2;

import java.util.Scanner;

/*
Write a program that reads in a line of text and then outputs that line of text first in all uppercase letters
and then in all lowercase letters
*/
public class Question8
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String textLine;
        System.out.print("Enter a line of text:");
        textLine = input.nextLine();
        System.out.println("Text in uppercase:"+textLine.toUpperCase());
        System.out.println("Text in lowercase:"+textLine.toLowerCase());
    }
}
