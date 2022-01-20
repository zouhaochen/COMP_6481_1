package Chapter6;

import java.util.Scanner;

/*
Write a program that plays a simple trivia game. The game should have five questions.
Each question has a corresponding answer and point value between 1 and 3 based on the difficulty of the question.
Implement the game using three arrays. An array of type String should be used for the questions.
Another array of type String should be used to store the answers.
An array of type int should be used for the point values.
All three arrays should be declared to be of size 5.

The index into the three arrays can be used to tie the question, answer, and point value together.
For example, the item at index 0 for each array would correspond to question 1,
answer 1, and the point value for question 1. The item at index 1 for each array would correspond to question 2,
answer 2, and the point value for question 2, and so forth.
Manually hardcode the five questions, answers, and point values into your program using trivia of your choice.

Your program should ask the player each question one at a time and allow the player to enter an answer.
If the player’s answer matches the actual answer, the player wins the number of points for that question.
If the player’s answer is incorrect, the player wins no points for the question.
Your program should show the correct answer if the player is incorrect.
After the player has answered all five questions, the game is over,
and your program should display the player’s total score.
*/
public class Question12
{
}
class TriviaGame
{
    public static void main(String args[])
    {

        Scanner input = new Scanner(System.in);
        int totalScore = 0;
        String[] questions = {	"Question 1: What is the capital of CANADA?",
                "Question 2: What is the capital of ITALY?",
                "Question 3: What is the capital of INDIA?",
                "Question 4: How many states are there in USA?",
                "Question 5: What is the largest population COUNTRY in the world?"
        };
        String[] answers = {
                "OTTAWA",
                "ROME",
                "DELHI",
                "50",
                "CHINA"
        };
        int[] index = {2, 3, 2, 3, 5};
        for(int i = 0; i < 5; i++)
        {
            System.out.print(questions[i]);
            String response = input.nextLine();

            if(response.equals(answers[i]))
            {
                System.out.println("Correct!");
                totalScore += index[i];
            }
            else
            {
                System.out.println("Sorry, the correct answer: " + answers[i] + ".");
            }
            System.out.println("---");
        }
        System.out.println("Final score: " + totalScore);
    }
}
