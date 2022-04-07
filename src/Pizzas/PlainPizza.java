package src.Pizzas;
//decorator pattern
public class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {

        return 4.00;
    }

    @Override
    public int getToppings() {

        return 0;
    }
}