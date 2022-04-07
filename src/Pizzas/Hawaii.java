package src.Pizzas;

import src.Topping.*;

public class Hawaii extends ToppingDecorator{

    public Hawaii(Pizza newPizza) {
        super(newPizza);

    }
    
    public String getDescription() {

        return tempPizza.getDescription() + "Ananas \nHam";
    }
    public double getCost() {

        return tempPizza.getCost() + 1.00;
    }
    public int getToppings() {

        return tempPizza.getToppings() + 2;
    }
}