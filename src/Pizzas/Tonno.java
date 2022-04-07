package src.Pizzas;

import src.Topping.*;
//decorator pattern
public class Tonno extends ToppingDecorator{

    public Tonno(Pizza newPizza) {
        super(newPizza);

    }
    
    public String getDescription() {

        return tempPizza.getDescription() + "Tonijn \nUi";
    }
    public double getCost() {

        return tempPizza.getCost() + 1.00;
    }
    public int getToppings() {

        return tempPizza.getToppings() + 2;
    }
}