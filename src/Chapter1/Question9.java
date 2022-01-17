package Chapter1;

/*
A simple rule to estimate your ideal body weight is to allow 110 pounds for the first 5 feet of height and
5 pounds for each additional inch.
Write a program with a variable for the height of a person in feet and another variable for the additional inches.
*/
public class Question9
{
    public static final int WEIGHT_FOR_MINIMUM_HEIGHT_IN_POUNDS = 110;
    public static final int MINIMUM_ALLOW_HEIGHT_IN_FEET = 5;
    public static final int WEIGHT_PER_ADDITIONAL_INCH_IN_POUNDS = 5;
    public static final int INCHES_PER_FEET = 12;

    public static void main(String[] args)
    {
        int personHeightInFeet = 6;
        int personHeightInInches = 3;

        double idealBodyWeightInPounds = WEIGHT_FOR_MINIMUM_HEIGHT_IN_POUNDS
                + ((personHeightInFeet - MINIMUM_ALLOW_HEIGHT_IN_FEET)
                * INCHES_PER_FEET + personHeightInInches)
                * WEIGHT_PER_ADDITIONAL_INCH_IN_POUNDS;

        System.out.println("Person height in feet: "
                + personHeightInFeet + "."
                + personHeightInInches);

        System.out.println("Ideal Body Weight in pounds: "
                + idealBodyWeightInPounds);
    }
}
