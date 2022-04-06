//decorator pattern
public class Salami extends ToppingDecorator{

    public Salami(Pizza newPizza) {
        super(newPizza);

    }
    
    public String getDescription() {

        return tempPizza.getDescription() + "Salami";
    }
    public double getCost() {

        return tempPizza.getCost() + .50;
    }
    public int getToppings() {

        return tempPizza.getToppings() + 1;
    }
}