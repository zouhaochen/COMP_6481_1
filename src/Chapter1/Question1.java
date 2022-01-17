package Chapter1;

/*
One way to measure the amount of energy that is expended during exercise is to use metabolic equivalent (MET).
Here are some METS for various activities:
Running 6MPH:   10 METS
Basketball:     8 METS
Sleeping:       1 METS
the number pf calories burned per minute may be estimated using the following formula:
Calories/Minute = 0.0175*MET*Weight in kilograms

Write a program that calculate the total number of calories burned for a 150-pound person who runs 6MPH for 30 minutes,
plays basketball for 30 minutes, and then sleeps for 6 hours.
One kilogram is equal to 2.2 pounds.
*/
public class Question1
{
    public static void main(String[] args)
    {
        double weightInKilogram = 150/2.2;
        double caloriesRunning = 0.0175*10*weightInKilogram*30;
        double caloriesBasketball = 0.0175*8*weightInKilogram*30;
        double caloriesSleeping = 0.0175*1*weightInKilogram*60*6;
        double totalCalories = caloriesBasketball+caloriesRunning+caloriesSleeping;
        System.out.println("calories = "+totalCalories);
    }
}

class Question
{
    private final static int RUNNING6MPH = 10;
    private final static int BASKETBALL = 8;
    private final static int SLEEPING = 1;

    private static double value = 0.0175;
    private static double totalCaloriesBurned = 0;

    public static void main(String[] args)
    {

        totalCaloriesBurned =
                caloriesPerMinute(RUNNING6MPH, 150, 30)
                + caloriesPerMinute(BASKETBALL, 150, 30)
                + caloriesPerMinute(SLEEPING, 150, hoursToMinutes(6));
        System.out.println(totalCaloriesBurned);
    }

    public static double caloriesPerMinute(int met, double weight, double time)
    {
        return value * met * poundToKilogram(weight) * time;
    }

    public static double poundToKilogram(double pound)
    {
        return pound / 2.2;
    }

    public static double hoursToMinutes(double hours)
    {
        return hours * 60;
    }
}
