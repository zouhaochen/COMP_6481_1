public class Demo06
{
    public static void main(String[] args)
    {
        Card card = new Card("Luncinda", "Holiday");
        card.greeting();
        System.out.println();

        ValentineCard valentineCard = new ValentineCard("Walter", 7);
        valentineCard.greeting();
    }
}

class Card
{
    private String recipient = "";
    private String occasion = "";

    public Card(String recipient, String occasion)
    {
        this.recipient = recipient;
        this.occasion = occasion;
    }

    public String getRecipient()
    {
        return recipient;
    }

    public void setRecipient(String recipient)
    {
        this.recipient = recipient;
    }

    public String getOccasion()
    {
        return occasion;
    }

    public void setOccasion(String occasion)
    {
        this.occasion = occasion;
    }

    public void greeting()
    {
        System.out.println("Happy "+occasion);
    }
}

class BirthdayCard extends Card
{
    private int age;
    public BirthdayCard(String recipient, int age)
    {
        super(recipient, "Birthday");
        this.age = age;
    }

    public void greeting()
    {
        System.out.println("Happy "+age+"th Birthday\n\n");
    }
}

class HolidayCard extends Card
{
    public HolidayCard(String recipient)
    {
        super(recipient, "Holiday");
    }

    public void greeting()
    {
        System.out.println("Dear "+getRecipient());
        super.greeting();
    }
}

class ValentineCard extends Card
{
    private int kisses;

    public ValentineCard(String recipient, int kisses)
    {
        super(recipient, "Valentine");
        this.kisses = kisses;
    }

    public void greeting()
    {
        System.out.println("Dear "+super.getRecipient());
        super.greeting();
        System.out.println("Loves and Kisses, \n");
        for(int x = 0; x < kisses; x++)
        {
            System.out.println("X");
        }
        System.out.println("\n\n");
    }
}