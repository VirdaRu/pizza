package src.Topping;

import src.Pizzas.Pizza;


//decorator pattern
public class ToppingDecorator implements Pizza {

    protected Pizza tempPizza;

    public ToppingDecorator(Pizza newPizza) {

        tempPizza = newPizza;
    }

    public String getDescription() {

        return tempPizza.getDescription();
    }
    public double getCost() {

        return tempPizza.getCost();
    }
    public int getToppings() {

        return tempPizza.getToppings();
    }
}