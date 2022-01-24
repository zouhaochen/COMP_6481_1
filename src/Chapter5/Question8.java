package Chapter5;

public class Question8
{
}

// Pizza.java
class Pizza
{
    private String pizzaSize;
    private int cheeseCount;
    private int pepperoniCount;
    private int hamCount;

    public Pizza()
    {
        this.pizzaSize = "";
        this.cheeseCount = 0;
        this.pepperoniCount = 0;
        this.hamCount = 0;
    }

    public Pizza(String pizzaSize, int cheeseCount, int pepperoniCount, int hamCount)
    {
        this.pizzaSize = pizzaSize;
        this.cheeseCount = cheeseCount;
        this.pepperoniCount = pepperoniCount;
        this.hamCount = hamCount;
    }

    public Pizza(Pizza piz)
    {
        if(piz == null)
        {
            return;
        }
        this.pizzaSize = piz.pizzaSize;
        this.cheeseCount = piz.cheeseCount;
        this.pepperoniCount = piz.pepperoniCount;
        this.hamCount = piz.hamCount;
    }

    public String getPizzaSize()
    {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize)
    {
        this.pizzaSize = pizzaSize;
    }

    public int getNumCheeseToppings()
    {
        return cheeseCount;
    }

    public void setNumCheeseToppings(int cheeseCount)
    {
        this.cheeseCount = cheeseCount;
    }

    public int getNumPepperoniToppings()
    {
        return pepperoniCount;
    }

    public void setNumPepperoniToppings(int pepperoniCount)
    {
        this.pepperoniCount = pepperoniCount;
    }

    public int getNumHmaToppings()
    {
        return hamCount;
    }

    public void setNumHmaToppings(int hamCount)
    {
        this.hamCount = hamCount;
    }

    public double calcCost()
    {
        if(pizzaSize.equalsIgnoreCase("small"))
        {
            return 10 + (cheeseCount + pepperoniCount + hamCount) * 2;
        }
        else if(pizzaSize.equalsIgnoreCase("medium"))
        {
            return 12 + (cheeseCount + pepperoniCount + hamCount) * 2;
        }
        else if(pizzaSize.equalsIgnoreCase("large"))
        {
            return 14 + (cheeseCount + pepperoniCount + hamCount) * 2;
        }
        else
        {
            return 0.0;
        }
    }

    public String getDescription()
    {
        return "Pizza size: " + pizzaSize + "\n Cheese toppings: "
                + cheeseCount + "\n Pepperoni toppings: "
                + pepperoniCount + "\n Ham toppings: "
                + hamCount + "\n Pizza cost: $" + calcCost() + "\n";
    }
}

// PizzaOrder.java
class PizzaOrder
{
    private int numPizzas;
    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;

    public PizzaOrder()
    {
        this.numPizzas = 0;
        this.pizza1 = null;
        this.pizza2 = null;
        this.pizza3 = null;
    }

    public PizzaOrder(int numPizzas, Pizza pizza1, Pizza pizza2, Pizza pizza3)
    {
        setNumPizzas(numPizzas);
        setPizza1(pizza1);
        setPizza2(pizza2);
        setPizza3(pizza3);
    }

    public PizzaOrder(PizzaOrder order)
    {
        if(order == null)
            return;

        numPizzas = order.numPizzas;

        if(order.pizza1 == null)
            pizza1 = null;
        else
            pizza1 = new Pizza(order.pizza1);

        if(order.pizza2 == null)
            pizza2 = null;
        else
            pizza2 = new Pizza(order.pizza2);

        if(order.pizza3 == null)
            pizza3 = null;
        else
            pizza3 = new Pizza(order.pizza3);
    }

    public void setNumPizzas(int numPizzas)
    {
        if(numPizzas < 1)
            this.numPizzas = 1;
        else if(numPizzas > 3)
            this.numPizzas = 3;
        else
            this.numPizzas = numPizzas;
    }

    public void setPizza1(Pizza pizza1)
    {
        if(numPizzas >= 1)
            this.pizza1 = pizza1;
        else
            this.pizza1 = null;
    }

    public void setPizza2(Pizza pizza2)
    {
        if(numPizzas >= 2)
            this.pizza2 = pizza2;
        else
            this.pizza2 = null;
    }

    public void setPizza3(Pizza pizza3)
    {
        if(numPizzas >= 3)
            this.pizza3 = pizza3;
        else
            this.pizza3 = null;
    }

    public int getNumPizzas()
    {
        return numPizzas;
    }

    public Pizza getPizza1()
    {
        return pizza1;
    }

    public Pizza getPizza2()
    {
        return pizza2;
    }

    public Pizza getPizza3()
    {
        return pizza3;
    }

    public double calcTotal()
    {
        double total = 0.0;

        if(pizza1 != null)
            total += pizza1.calcCost();

        if(pizza2 != null)
            total += pizza2.calcCost();

        if(pizza3 != null)
            total += pizza3.calcCost();

        return total;
    }
}

// PizzaOrderTest.java
class PizzaOrderTest
{
    public static void main(String[] args)
    {
        Pizza pizza1 = new Pizza("large", 1, 0, 1);
        Pizza pizza2 = new Pizza("medium", 2, 2, 0);

        PizzaOrder order1 = new PizzaOrder();
        order1.setNumPizzas(2);
        order1.setPizza1(pizza1);
        order1.setPizza2(pizza2);
        double total1 = order1.calcTotal();

        System.out.println(order1.getPizza1().getDescription());
        System.out.println(order1.getPizza2().getDescription());
        System.out.println("Total cost1: $" + total1);
        System.out.println();

        PizzaOrder order2 = new PizzaOrder(order1);
        order2.getPizza1().setNumCheeseToppings(3);
        double total2 = order2.calcTotal();

        System.out.println(order2.getPizza1().getDescription());
        System.out.println(order2.getPizza2().getDescription());
        System.out.println("Total cost2: $" + total2);
        System.out.println();

        double origTotal = order1.calcTotal();
        System.out.println("Total cost1: $" + origTotal);
    }
}