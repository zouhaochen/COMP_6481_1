package Week1;

public class Demo01
{
    public static void main(String[] args)
    {
        int[][] table = new int[5][10];
        for(int row = 0; row < table.length; row++)
            for(int col = 0; col < table[row].length; col++)
                table[row][col] = row * 10 + col;
            for(int row = 0; row < table.length; row++)
            {
                for(int col = 0; col < table[row].length; col++)
                    System.out.println(table[row][col]+"\t");
                System.out.println();
            }
    }
}
