package Chapter3;

/*
In crypt arithmetic puzzles, mathematical equations are written using letters.
Each letter can be a digit from 0 to 9, but no two letters can be the same.
Here is a sample problem:
SEND + MORE = MONEY
A solution to the puzzle is S = 9, R = 8, O = 0, M = 1, Y = 2, E = 5, N = 6, D = 7.
Write a program that finds a solution to the crypt arithmetic puzzle of the following:
TOO + TOO + TOO + TOO = GOOD
*/
public class Question8
{
}
class CryptArithmeticPuzzle
{
    public static void main(String[] args)
    {
        for (int T = 0; T <= 9; T++)
        {
            for (int O = 0; O <= 9; O++)
            {
                for (int G = 0; G <= 9; G++)
                {
                    for (int D = 0; D <= 9; D++)
                    {
                        if (T != O && T != D && T != G && G != O && G != D && D != O)
                        {
                            int too = (100 * T) + (10 * O) + O;
                            int good = (1000 * G) + (100 * O) + (10 * O) + D;

                            if (4 * too == good)
                            {
                                System.out.println("TOO + TOO + TOO + TOO = " + (4 * too));
                                System.out.println("GOOD = " + good);
                                System.out.println("Therefore, T = " + T + ", O = " + O + ", G = " + G + ", and D = " + D);
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
    }
}