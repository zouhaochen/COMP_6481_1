package Chapter1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/*
Science estimate that roughly 10 grams of caffeine consumed at one time is a lethal overdose.
Write a program with a variable that holds the number of milligrams of caffeine in a drink and
outputs how many drinks it takes to kill a person.
*/
public class Question10
{
    public static final int CAFFEINE_KILL_AMOUNT = 10000;
    public static final int CAFFEINE_COLA = 34;
    public static final int AMOUNT_COLA = 12;
    public static final int CAFFEINE_COFFEE = 160;
    public static final int AMOUNT_COFFEE = 160;

    public static void main(String[] args)
    {
        double killAmountCola = CAFFEINE_KILL_AMOUNT/CAFFEINE_COLA;
        int canCola = (int)Math.ceil(killAmountCola);
        double killAmountCoffee = CAFFEINE_KILL_AMOUNT/CAFFEINE_COFFEE;
        int cupCoffee = (int)Math.ceil(killAmountCoffee);
        System.out.println(canCola+" cans cola will kill.");
        System.out.println(cupCoffee+" cups coffee will kill.");
    }
}
