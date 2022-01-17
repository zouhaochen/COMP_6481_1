package Chapter1;

import java.util.Scanner;

/*
Write a program that starts with the string variable first set to your first name
and the string variable last set to your last name.
Both names should be all lowercase.
Your program should then create a new string that contains you full name in pig latin with
the first letter capitalized for the first and last name.
Use only the pig latin rule of moving the first letter to the end of the word and adding "ay".
Output the pig latin name to the screen. Use the substring and toUpperCase methods to construct the new name.

For example, give
first = "walt";
last = "savitch";
the program should create a bew string with the text "Altway Avitchsay" and print it.
*/
public class Question3
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("First Name: ");
        String firstName = keyboard.nextLine();
        System.out.println("Last Name: ");
        String lastName = keyboard.nextLine();

        String name = pigLatin(firstName,lastName);
        System.out.println(name);
    }

    public static String pigLatin(String firstName, String lastName)
    {
        firstName.toLowerCase();
        lastName.toLowerCase();

        char firstLetterFirstName = firstName.charAt(0);
        char firstLetterLastName = lastName.charAt(0);

        String newFirstLetterFirstName = String.valueOf(firstName.charAt(1));
        String newFirstLetterLastName = String.valueOf(lastName.charAt(1));

        String subStringFirstName = firstName.substring(2);
        String subStringLastName = lastName.substring(2);

        return newFirstLetterFirstName.toUpperCase()+subStringFirstName+firstLetterFirstName+"ay "
                +newFirstLetterLastName.toUpperCase()+subStringLastName+firstLetterLastName+"ay";

    }
}

class PigLatinStrings
{
    public static void main(String[] args)
    {
        String first;
        String last;
        String pigLatinFirst;
        String pigLatinLast;
        String pigLatinName;

        first = "walt";
        last = "savitch";

        pigLatinFirst = first.substring(1) + first.charAt(0) + "ay";
        pigLatinLast = last.substring(1) + last.charAt(0) + "ay";

        pigLatinFirst = pigLatinFirst.substring(0, 1).toUpperCase()
                + pigLatinFirst.substring(1);

        pigLatinLast = pigLatinLast.substring(0, 1).toUpperCase()
                + pigLatinLast.substring(1);

        pigLatinName = pigLatinFirst + " " + pigLatinLast;

        System.out.println("First Name:    " + first);
        System.out.println("Last Name:     " + last);
        System.out.println("PigLatin Name: " + pigLatinName);
    }
}
