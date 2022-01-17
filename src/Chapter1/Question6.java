package Chapter1;

/*
Bicycles can calculate their speed if the gear size and cadence are known.
Gear size refers to the effective diameter of the wheel.
Gear size multiplied by pi(3.14) gives the distance travelled with one turn of the pedals.
Cadence refers to the number of pedal revolutions per minute(rpm).
The speed in mules per hour is calculated by the following.

This is a program that calculates the speed for a gear size of 100 inches and a cadence of 90 rpm.
This would consider a high cadence and a maximum gear size for a typical bicycle.
*/
public class Question6
{
    public static final double PI = 3.14;

    public static void main(String[] args)
    {
        double gearSizeInInches = 100.0;
        double cadenceInRPM = 90.0;

        double speedInMPH = gearSizeInInches * PI * (1.0 / 12.0)
                * (1.0 / 5280.0) * cadenceInRPM * (60.0 / 1.0);

        System.out.println("Gear size in inches   : " + gearSizeInInches);
        System.out.println("Cadence in RPM        : " + cadenceInRPM);
        System.out.println("Bicyclist speed in MPH: " + speedInMPH);
    }
}
