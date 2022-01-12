package Week1.Array;

import java.util.Scanner;

public class Utility2
{
    /*
    Returns the first argument with all occurrences of other arguments deleted
     */
    public static String censor(String sentence, String ... unwanted)
    {
        for(int i = 0; i < unwanted.length; i++)
            sentence = deleteOne(sentence, unwanted[i]);
        return sentence;
    }

    /*
    Returns sentence with all occurrences of oneUnwanted removed
     */
    private static String deleteOne(String sentence, String oneUnwanted)
    {
        String ending;
        int position = sentence.indexOf(oneUnwanted);

        //while word was found in sentence
        while(position >= 0)
        {
            ending = sentence.substring(position + oneUnwanted.length());
            sentence = sentence.substring(0, position)+ending;
            position = sentence.indexOf(oneUnwanted);
        }
        return sentence;
    }
}

class StringProcessingDemo
{
    public static void main(String[] args)
    {
        System.out.println("what did you eat for dinner?");
        Scanner keyboard = new Scanner(System.in);
        String sentence = keyboard.nextLine();
        sentence = Utility2.censor(sentence, "candy", "french fries", "salt", "beer");
        sentence = Utility2.censor(sentence, ","); //delete extra comma
        System.out.println("you would be healthier if you could answer:");
        System.out.println(sentence);
    }
}
