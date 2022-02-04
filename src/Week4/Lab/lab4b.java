package Week4.Lab;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
An “n-gram” is a contiguous sub-sequence of n items in a given sequence.
For example, given the sequence “ALIGATOR”, its only 5-grams are ALIGA, LIGAT, IGATO and GATOR.
There are special names for the first few n-grams: unigram for 1-gram, bigram for 2-gram, and trigram for 3-gram.
Write a program that, given a paragraph, will find the most-frequently appearing n-gram in it.
We are interested in n-grams consisting of only alphabets.
More specifically, you need to find “the single letter that appears the most (Unigram)”,
“two consecutive letters that appear the most (Bigram)”, and “three consecutive letters that appear the most (Trigram)”.
If there is a tie for number of occurrences, (e.g., several bigrams appearing the most),
you must print one that appears first alphabetically (i.e., the smallest in string comparison).
Note that "consecutive" letters mean one letter immediately after another letter,
i.e., no other characters (spaces or other separators) in between.

Input  Specification:
The first line of the input is an integer p (0<p<51) indicating the number of lines in the paragraph.
The following p input lines provide the text for the paragraph.
Each of these input lines will contain only lowercase letters, spaces, commas and periods.
Assume that these input lines will not exceed column 70 and that each line will contain at least one letter.
(Note that the only separators are spaces, commas, periods, and  end-of-line.)
(p+2)th line or the last line in the input is an integer n (0<n<4).
It indicates n-gram to be printed as the output (1->Unigram, 2->Bigram and 3->Trigram).

Output Specification:
Print appropriate “n-gram” text (Unigram/Bigram/Trigram) followed by most-frequently appearing n-gram.
Note that for a string such as “aaaaaa”, some interpretations view it as having three copies of “aa”
and some view it as having five occurrences of “aa”.
Use the latter view for this problem (same concept applies to trigrams as well).
*/
public class lab4b
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        String inputFirst = keyboard.nextLine();
        int inputFirstInInt = 0;

        try
        {
            inputFirstInInt = Integer.parseInt(inputFirst);
        }
        catch (Exception e)
        {
            System.exit(0);
        }

        if(inputFirstInInt <= 0 || inputFirstInInt >= 51)
        {
            System.exit(0);
        }

        String paragraph = "";

        for(int i = 0; i < inputFirstInInt; i++)
        {
            if (i == 0)
            {
                paragraph = keyboard.nextLine();
            }
            else
            {
                paragraph = paragraph + " " + keyboard.nextLine();
            }
        }

        StringTokenizer stringTokenizer = new StringTokenizer(paragraph, " .,");


        int inputLast = keyboard.nextInt();

        if(inputLast < 1 || inputLast > 3)
        {
            System.exit(0);
        }

        switch(inputLast)
        {
            case 1:

                int[] uni = new int[26];
                int best = 0;
                int besti = 0;

                while (stringTokenizer.hasMoreTokens())
                {
                    String word = stringTokenizer.nextToken();

                    for(int i = 0; i < word.length(); i++)
                    {
                        uni[word.charAt(i) - 'a']++;
                    }
                }

                for(int i=0; i<26; i++)
                {
                    if(uni[i] > best)
                    {
                        besti = i;
                        best = uni[i];
                    }
                }
                System.out.println("Unigram "+(char)(besti+'a'));
                break;

            case 2:

                int[][] bi = new int[26][26];
                int best2 = 0;
                int best2i = 0;
                int best2j = 0;

                while (stringTokenizer.hasMoreTokens())
                {
                    String word = stringTokenizer.nextToken();

                    for(int i = 1; i < word.length(); i++)
                    {
                        bi[word.charAt(i-1) - 'a'][word.charAt(i) - 'a']++;
                    }
                }

                for(int i = 0; i<26; i++)
                {
                    for(int j = 0; j < 26; j++)
                    {
                        if (bi[i][j] > best2)
                        {
                            best2i = i;
                            best2j = j;
                            best2 = bi[i][j];
                        }
                    }
                }
                System.out.println("Bigram "+(char)(best2i+'a')+(char)(best2j+'a'));
                break;

            case 3:
                int[][][] tri = new int[26][26][26];
                int best3 = 0;
                int best3i = 0;
                int best3j = 0;
                int best3k = 0;

                while(stringTokenizer.hasMoreTokens())
                {
                    String word = stringTokenizer.nextToken();

                    for(int i = 2; i < word.length(); i++)
                    {
                        tri[word.charAt(i-2) - 'a'][word.charAt(i-1) - 'a'][word.charAt(i) - 'a']++;
                    }
                }

                for(int i = 0; i<26; i++)
                {
                    for(int j = 0; j < 26; j++)
                    {
                        for(int k = 0; k < 26; k++)
                        {
                            if (tri[i][j][k] > best3)
                            {
                                best3i = i;
                                best3j = j;
                                best3k = k;
                                best3 = tri[i][j][k];
                            }
                        }
                    }
                }
                System.out.println("Trigram "+(char)(best3i+'a')+(char)(best3j+'a')+(char)(best3k+'a'));
                break;
        }

    }

}
