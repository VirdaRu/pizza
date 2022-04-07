package src.Order;
import src.Interface.*;

//composite pattern
public class Order implements IOrder {
    private IOrder parrent;

    private String name; //naam klant
    private String house; //straat + nummer
    private String adress; //postcode + plaats
    private Pizza pizza; //naam
    private int quantity; //hoeveelheid
    private int toppings; //hoeveel extra toppings
    private String extraToppings; //welke toppings
    

    public Order(String name, String house, String adress, Pizza pizza, int quantity, int toppings, String extraToppings) {
        this.name = name;
        this.house = house;
        this.adress = adress;
        this.pizza = pizza;
        this.quantity = quantity;
        this.toppings = toppings;
        this.extraToppings = extraToppings;
    }

    @Override
    public void setParrent(IOrder parrent) {
        this.parrent = parrent;

    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);

    }

    public String getName(){
        return name;
    }
    public String getHouse(){
        return house;
    }
    public String getAdress(){
        return adress;
    }
    public Pizza getPizza() {
        return pizza;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getToppings(){
        return toppings;
    }
    public String extraToppings(){
        return extraToppings;
    }

}