package Chapter6;

import java.util.Scanner;

/*
Write a program to assign passengers seats in an airplane.
The program should display the seat pattern, with an 'X' marking the seats already assigned.
For example, after seats 1A, 2B, and 4C are taken, the display should like the following.
After displaying the seats available, the program should prompt for the seat desired,
the user can type in a seat, and then the display of available seats should be updated.
This continues until all seats are filled or until the user signals that the program should end.
If the user types in a seat that is already assigned, the program should say that that seat is occupied
and ask for another choice.
*/
public class Question11
{
    public static boolean filledSeats(char[][] plane)
    {
        for (int i = 0; i < plane.length; i++)
        {
            for (int j = 0; j < plane[i].length; j++)
            {
                if (plane[i][j] != 'X')
                    return false;
            }
        }
        return true;
    }

    public static int findRowSeat(String numSeat)
    {
        char rowChar = numSeat.charAt(0);
        int rowNumber = rowChar - '1';
        return rowNumber;
    }

    public static int findColumnSeat(String numSeat)
    {
        char colChar = numSeat.charAt(1);
        if (colChar == 'A')
            return 0;
        else if (colChar == 'B')
            return 1;
        else if (colChar == 'C')
            return 2;
        else if (colChar == 'D')
            return 3;
        else
            return -1;
    }

    public static void displaySeats(char[][] plane)
    {
        for (int i = 0; i < plane.length; i++)
        {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < plane[i].length; j++)
            {
                System.out.print(plane[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        char[][] plane = { { 'A', 'B', 'C', 'D' },
                { 'A', 'B', 'C', 'D' },
                { 'A', 'B', 'C', 'D' },
                { 'A', 'B', 'C', 'D' },
                { 'A', 'B', 'C', 'D' },
                { 'A', 'B', 'C', 'D' },
                { 'A', 'B', 'C', 'D' }, };
        Scanner input = new Scanner(System.in);
        String decision = "y";
        while (decision.equals("y") ||decision.equals("Y")&& !filledSeats(plane))
        {

            displaySeats(plane);
            System.out.print("Enter a seat(For example 1A, 2B, or 4C): ");

            boolean okSeat = false;
            while (okSeat == false)
            {
                String seat = input.nextLine();
                int r = findRowSeat(seat);
                int c = findColumnSeat(seat);

                if (plane[r][c] == 'X')
                    System.out.print("Sorry, seat is occupied, enter a different seat:");
                else
                    {
                        plane[r][c] = 'X';
                        okSeat = true;
                    }
            }
            System.out.print("Still Continue ? (y/n)");
            decision = input.nextLine();
        }

        System.out.println("Plane seating chart:");
        displaySeats(plane);
    }
}