package Week3.Lab;

import java.util.Scanner;

/*
Basketball players are ranked according to a statistic called points per minute (ppm).
This is calculated by dividing the points scored by a player by the number of minutes that
the player has played on the court.
The resulting value is scaled to 1000 and rounded to an integer.
The program must output name of the player and the value of the statistic for a given rank.
You can assume that there will be no ties.

Input Specification:
The first line contains N, the number of players on the team, 1 < N ≤ 50 and the required rank.
For each player on the team, there will be 5 lines of data their name (in upper case),
number of foul shots made (one point each), number of field goals made (two  points  each),
number of three-point baskets made (three points  each), number of minutes played, an integer > 0.

Output Specification:
The output will comprise of a single line containing name of the player followed by the score
with exactly one space between them and terminated by new line character.
No leading or trailing spaces for the name or the score.
*/
public class lab3b
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int player = keyboard.nextInt();
        int rank = keyboard.nextInt();
        keyboard.nextLine();

        if (player <= 1 || player > 50)
        {
            System.exit(0);
        }

        if(rank>player || rank <= 0)
        {
            System.exit(0);
        }

        String[][] data = new String[player][5];
        for (int i = 0; i < data.length; i++)
        {
            String name = keyboard.nextLine();
            if (name.isEmpty())
            {
                System.exit(0);
            }
            data[i][0] = name.toUpperCase();

            String foulShotsInString = keyboard.nextLine();
            float foulShots = 0;
            try
            {
                foulShots = Float.parseFloat(foulShotsInString);
            }
            catch (Exception e)
            {
                System.exit(0);
            }
            if(foulShots < 0)
            {
                System.exit(0);
            }
            data[i][1] = foulShotsInString;

            String fieldGoalsInString = keyboard.nextLine();
            float fieldGoals = 0;
            try
            {
                fieldGoals = Float.parseFloat(fieldGoalsInString);
            }
            catch (Exception e)
            {
                System.exit(0);
            }
            if(fieldGoals < 0)
            {
                System.exit(0);
            }
            data[i][2] = fieldGoalsInString;

            String threePointBasketsInString = keyboard.nextLine();
            float threePointBaskets = 0;
            try
            {
                threePointBaskets = Float.parseFloat(threePointBasketsInString);
            }
            catch (Exception e)
            {
                System.exit(0);
            }
            if(threePointBaskets < 0)
            {
                System.exit(0);
            }
            data[i][3] = threePointBasketsInString;

            String minuteInString = keyboard.nextLine();
            float minute = 0;
            try
            {
                minute = Float.parseFloat(minuteInString);
            }
            catch (Exception e)
            {
                System.exit(0);
            }
            if(minute <= 0)
            {
                System.exit(0);
            }
            data[i][4] = minuteInString;
        }

        String[][] scoreTotal = scoreList(data);
        sortScore(scoreTotal);
        System.out.println(scoreTotal[rank-1][0]+" "+scoreTotal[rank-1][1]);
    }

    public static String[][] scoreList(String[][] data)
    {
        String[][] score = new String[data.length][2];

        for(int i = 0; i < data.length; i++)
        {
            score[i][0] = data[i][0];

            float foul = 0;
            try
            {
                foul = Float.parseFloat(data[i][1]);
            }
            catch (Exception e)
            {
                System.exit(0);
            }

            float field = 0;
            try
            {
                field = Float.parseFloat(data[i][2]);
            }
            catch (Exception e)
            {
                System.exit(0);
            }

            float threePoint = 0;
            try
            {
                threePoint = Float.parseFloat(data[i][3]);
            }
            catch (Exception e)
            {
                System.exit(0);
            }

            float minute = 0;
            try
            {
                minute = Float.parseFloat(data[i][4]);
            }
            catch (Exception e)
            {
                System.exit(0);
            }

            float scoreTotal = ((foul + field*2 + threePoint*3)*1000)/minute;
            int scoreAfterRound = Math.round(scoreTotal);

            score[i][1] = String.valueOf(scoreAfterRound);
        }
        return score;
    }

    public static void sortScore(String[][] scoreTotal)
    {
        for(int i = 0; i < scoreTotal.length - 1; i++)
        {
            for(int j = i + 1; j < scoreTotal.length; j++)
            {
                int scoreI = Integer.parseInt(scoreTotal[i][1]);
                int scoreJ = Integer.parseInt(scoreTotal[j][1]);
                if(scoreI<scoreJ)
                {
                    String tempName = scoreTotal[i][0];
                    scoreTotal[i][0] = scoreTotal[j][0];
                    scoreTotal[j][0] = tempName;

                    String tempScore = scoreTotal[i][1];
                    scoreTotal[i][1] = scoreTotal[j][1];
                    scoreTotal[j][1] = tempScore;
                }
            }
        }
    }
}
