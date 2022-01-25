package Week2.Lab;

/*
“Snakes and ladders” is a very popular game. It uses a 10x10 maze, with cells numbered from 1 to 100,
and populated with snakes and ladders. A sample game is shown in the figure below.
Every player gets a chance to play and advance in the maze,
depending on the number they get on the six-sided dice when thrown.

The advancement is in the increasing order from 1 to 100.
All players start from cell numbered 1 and attempt to reach to cell numbered 100.
The player who reaches first to cell number 100, is the winner.
If the game is stopped in between, the player closest to cell 100 in number is the winner.
Assume that both players will never be on the same cell when the game is stopped.

If a player lands on a snake head, then the player gets a penalty to retreat to tail of the snake.
If a player reaches foot of a ladder, then the player climbs directly to the top of the ladder.
This is repeated if there exists another snake (or ladder) at the new cell.
A cell will never have a mouth of a snake and a foot of a ladder simultaneously.

Write a Java program to simulate the game for a given number of moves.
There will be two players, named A and B, who throw the dice alternately.
Program should output the name of the player at the highest position (closest to 100),
along with the player's cell number.

Input:
The first line of input will contain a single integer N.
Next N lines each will contain a pair of integers.
Each pair will describe either a snake or ladder by its start cell and an end cell.
For a snake, start cell will be higher than end cell and vice versa for a ladder.

Following line of input has a single integer D,
indicating the number of moves (dice throws) made by both players A and B.
Last line contains D integers, each indicating a dice throw, alternately made by A and B.
First throw is made by player A. Each dice throw is an integer between 1 and 6.

Output:
Your program should output the name of the winner (A or B) followed by the player’s position
at the end of game, with a single space in between.
*/
public class Lab2b
{
    public static void main(String[] args)
    {

    }
}
