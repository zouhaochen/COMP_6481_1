package Week1.Lab;

import java.util.Scanner;

public class Lab1A
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        String firstName;
        String middleName;
        String lastName;
        String name;

        name = keyboard.nextLine();

        int fistNameIndex = name.indexOf(" ");
        if(fistNameIndex < 0)
        {
            if(name.length()<=50)
                System.out.println(name);
        }
        else
            {
                firstName = name.substring(0, fistNameIndex);

                int middleNameIndex = name.indexOf(" ", fistNameIndex + 1);

                if (middleNameIndex < 0)
                {
                    lastName = name.substring(fistNameIndex + 1);
                    if(lastName.endsWith("a")||lastName.endsWith("e")||lastName.endsWith("i")||lastName.endsWith("o")||lastName.endsWith("u")||lastName.endsWith("A")||lastName.endsWith("E")||lastName.endsWith("I")||lastName.endsWith("O")||lastName.endsWith("U"))
                    {
                        if (lastName.length() <= 50 || firstName.length() <= 50)
                            System.out.println(lastName + " " + firstName);
                    }
                    else
                        System.out.println(firstName + " " + lastName);
                }
                else
                    {
                        middleName = name.substring(fistNameIndex + 1, middleNameIndex);
                        lastName = name.substring(middleNameIndex + 1);
                        if(lastName.length()<=50||firstName.length()<=50||middleName.length()<=50)
                            System.out.println(lastName + " " + firstName + " " + middleName);
                    }
            }
    }
}