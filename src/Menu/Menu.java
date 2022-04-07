package src.Menu;
import src.Pizzas.*;

//singleton pattern
public class Menu {
    private static Menu firstInstance = null;

    private Menu() {}
    public static Menu getInstance() {
        if (firstInstance == null) {
            firstInstance = new Menu();
        }

        return firstInstance;
    }

    public String pizzas(){
        Pizza Margaritha = new PlainPizza();
        Pizza Salami = new Salami(new PlainPizza());
        Pizza Tonno = new Tonno(new PlainPizza());
        Pizza Hawaii = new Hawaii(new PlainPizza());      
        //System.out.println("Margeritha " + Margaritha.getCost() + "  Salami " + Salami.getCost() + "  Tonno " + Tonno.getCost() + "  Hawaii " + Hawaii.getCost());
        return "Margeritha " + Margaritha.getCost() + "  Salami " + Salami.getCost() + "  Tonno " + Tonno.getCost() + "  Hawaii " + Hawaii.getCost();
    }
}