package Chapter5;

/*
In the land of Puzzlevania, Aaron, Bob, and Charlie had an argument over
which one of them was the greatest puzzler of all time.
To end the argument once and for all, they agreed on a duel to the death.
Aaron was a poor shooter and only hit his target with a probability of 1>3.
Bob was a bit better and hit his target with a probability of 1>2.
Charlie was an expert marksman and never missed. A hit means a kill and the person hit drops out of the duel.
To compensate for the inequities in their marksmanship skills, the three decided that they would fire in turns,
starting with Aaron, followed by Bob, and then by Charlie.
The cycle would repeat until there was one man standing, and that man would be the Greatest Puzzler of All Time.
An obvious and reasonable strategy is for each man to shoot at the most accurate shooter still alive,
on the grounds that this shooter is the deadliest and has the best chance of hitting back.
Write a program to simulate the duel using this strategy.
Your program should use random numbers and the probabilities given in the problem
to determine whether a shooter hits the target.
Create a class named Duelist that contains the dueler’s name and shooting accuracy,
a Boolean indicating whether the dueler is still alive,
and a method ShootAtTarget ( Duelist target ) that sets the target to dead if the dueler hits his target
(using a random number and the shooting accuracy) and does nothing otherwise.
Once you can simulate a single duel, add a loop to your program that simulates 10,000 duels.
Count the number of times that each contestant wins and print the probability of winning for each contestant
(e.g., for Aaron your program might output “Aaron won 3,595>10,000 duels or 35.95%”).
An alternate strategy is for Aaron to intentionally miss on his first shot.
Modify the program to accommodate this new strategy and output the probability of winning for each contestant.
Which strategy is better for Aaron: to intentionally miss on the first shot or to try and hit the best shooter?
Who has the best chance of winning, the best shooter or the worst shooter?
*/
public class Question3
{
}

class DuelistDemo
{
    private String name;
    private double accuracy;
    private boolean alive;

    public DuelistDemo(String n, double acc)
    {
        this.name = n;
        this.accuracy = acc;
        alive = true;
    }

    public boolean isAlive()
    {
        return alive;
    }

    public String getName()
    {
        return name;
    }

    public void ShootAtTarget(DuelistDemo dd)
    {
        if(Math.random() < accuracy)
            dd.alive = false;
    }
}

class DuelistTest
{
    public static void main(String[] args)
    {
        int aWin = 0;
        int bWin = 0;
        int cWin = 0;

        for(int i = 1; i <= 10000; i++)
        {
            DuelistDemo aaron = new DuelistDemo("Aaron", 0.33);
            DuelistDemo bob = new DuelistDemo("Bob", 0.5);
            DuelistDemo charlie = new DuelistDemo("Charlie", 1);

            int aliveCount = 3;
            while(aliveCount > 1)
            {
                if(aaron.isAlive())
                {
                    if(charlie.isAlive())
                    {
                        aaron.ShootAtTarget(charlie);
                        if(!charlie.isAlive())
                            aliveCount--;
                    }
                    else
                    {
                        aaron.ShootAtTarget(bob);
                        if(!bob.isAlive())
                            aliveCount--;
                    }
                }
                if(bob.isAlive())
                {
                    if(charlie.isAlive())
                    {
                        bob.ShootAtTarget(charlie);

                        if(!charlie.isAlive())
                            aliveCount--;
                    }
                    else
                    {
                        bob.ShootAtTarget(aaron);

                        if(aaron.isAlive())
                            aWin++;
                    }
                }
                if(charlie.isAlive())
                {
                    if(bob.isAlive())
                    {
                        charlie.ShootAtTarget(bob);
                        if(!bob.isAlive())
                            aliveCount--;
                    }
                    else
                    {
                        charlie.ShootAtTarget(aaron);

                        if(!aaron.isAlive())
                            aliveCount--;
                    }
                }
            }
            if(aaron.isAlive())
                aWin++;
            else if(bob.isAlive())
                bWin++;
            else
                cWin++;
        }
        System.out.println("Aaron has won " + aWin + " times of 10000 duels.");
        System.out.println("Bob has won " + bWin + " times of 10000 duels.");
        System.out.println("Charlie has won " + cWin + " times of 10000 duels");
    }
}


