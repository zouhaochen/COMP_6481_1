package Week1.Lab;

import java.util.Scanner;

/*
A student uses her/his name in order of FIRSTNAME MIDDLENAME LASTNAME (also known as family name).
We want to print the name as LASTNAME FIRSTNAME MIDDLENAME.
Write a JAVA program to do this required manipulation.

As students come from different part of the world, names are printed in many different forms.
Some student don't have all the 3 components; they just use FIRSTNAME followed by MIDDLENAME/LASTNAME.
If only two components are present,
your program must print them in the same order if they use FIRSTNAME and MIDDLENAME.
The program, however, must print them in reverse order if they use FIRSTNAME and LASTNAME.
To differentiate, you must assume that all the LASTNAMES will end in vowel(a, e, i, o, u or A, E, I, O, U).
If a student's name only has the FIRSTNAME, it will be printed as it is.

Input Specification:
Name will be inputted in FIRSTNAME MIDDLENAME LASTNAME or FIRSTNAME LASTNAME or FIRSTNAME MIDDLENAME or FIRSTNAME.
All parts of the name will be separated by a single space.
Each part of a name can contain maximum 50 characters.

Output Specification:
Name as expected based on the description above.
Each part of the name must be separated by a single space.
*/
public class lab1A
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();

        int firstNameIndex = name.indexOf(" ");
        if(firstNameIndex < 0)
        {
            if(name.length()<=50)
            {
                System.out.println(name);
            }
        }
        else
        {
            String firstName = name.substring(0,firstNameIndex);
            int secondNameIndex = name.indexOf(" ", firstNameIndex+1);

            if(secondNameIndex < 0)
            {
                String secondName = name.substring(firstNameIndex+1);
                if(secondName.endsWith("a")||secondName.endsWith("e")||
                        secondName.endsWith("i")||secondName.endsWith("o")||
                        secondName.endsWith("u")||secondName.endsWith("A")||
                        secondName.endsWith("E")||secondName.endsWith("I")||
                        secondName.endsWith("O")||secondName.endsWith("U"))
                {
                    if(firstName.length()<=50||secondName.length()<=50)
                    {
                        System.out.println(secondName+" "+firstName);
                    }
                }
                else
                {
                    if(firstName.length()<=50||secondName.length()<=50)
                    {
                        System.out.println(firstName+" "+secondName);
                    }
                }
            }
            else
            {
                String secondName = name.substring(firstNameIndex+1, secondNameIndex);
                String thirdName = name.substring(secondNameIndex+1);
                if(firstName.length()<=50||secondName.length()<=50||thirdName.length()<=50)
                    System.out.println(thirdName + " " + firstName + " " + secondName);
            }
        }
    }
}
