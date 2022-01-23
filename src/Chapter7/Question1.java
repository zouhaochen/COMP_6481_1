package Chapter7;

/*
Define a class named Payment that contains an instance variable of type double
that stores the amount of the payment and appropriate accessor and mutator methods.
Also create a method named paymentDetails that outputs an English sentence to describe the amount of the payment.
Next, define a class named CashPayment that is derived from Payment.
This class should redefine the paymentDetails method to indicate that the payment is in cash.
Include appropriate constructor(s).
Define a class named CreditCardPayment that is derived from Payment.
This class should contain instance variables for the name on the card, expiration date, and credit card number.
Include appropriate constructor(s).
Finally, redefine the paymentDetails method to include all credit card information in the printout.
Create a main method that creates at least two CashPayment and two CreditCardPayment objects
with different values and calls paymentDetails for each.
*/
public class Question1
{
}

abstract class Payment
{
    protected double cash;

    Payment(double val)
    {
        this.cash = Math.round(val*100)/100.0;
    }

    public double getcash()
    {
        return cash;
    }

    public void setcash(double newval)
    {
        this.cash = newval;
    }

    public void paymentDetails()
    {
        System.out.println("The payment of cash: $" +this.cash);
    }
}

class CashPayment extends Payment
{

    CashPayment(double val)
    {
        super(val);
    }

    public void paymentDetails()
    {
        System.out.println("The payment of cash:  $" + this.cash);
    }
}

class CreditCardPayment extends Payment
{

    public String name, expDate, number;

    CreditCardPayment(double value, String name, String expDate, String number)
    {
        super(value);
        this.number = number;
        this.expDate = expDate;
        this.name = name;
    }

    public void paymentDetails()
    {
        System.out.println("The payment of $" + this.cash + " through the card " + this.number
                + ",  and expire date "	+ this.expDate + ", and the owner name: " + this.name + ".");
    }
}

class TestDemo
{
    public static void main(String[] args)
    {
        CreditCardPayment x = new CreditCardPayment(2.12, "George bush","11/27", "************1234");

        CashPayment p = new CashPayment(20.03);

        CreditCardPayment y = new CreditCardPayment(11.22, "Trump Henry","22/11","987654321");

        CashPayment q = new CashPayment(55.12);

        x.paymentDetails();
        p.paymentDetails();
        y.paymentDetails();
        q.paymentDetails();
    }

}