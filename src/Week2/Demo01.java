package Week2;

import java.util.Scanner;

public class Demo01
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int row = keyboard.nextInt();
        int col = keyboard.nextInt();
        int[][] matrix = new int[row][col];

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = keyboard.nextInt();
            }
        }
        show(matrix);
        int[][] temp = change(matrix);
        System.out.println();
        show(temp);
    }

    public static int[][] change(int[][] matrix)
    {
        int[][] temp = new int[matrix[0].length][matrix.length];
        int dst = matrix.length-1;
        for(int i = 0; i<matrix.length; i++, dst--)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                temp[j][dst]=matrix[i][j];
            }
        }
        return temp;
    }

    public static void show(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
