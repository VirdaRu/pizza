package src.Main;
//import java.io.Console;
import java.util.Scanner;

import src.Interface.Pizza;
import src.Interface.Visitor;
import src.Pizzas.*;
import src.Menu.*;
import src.Order.*;
import src.Visitor.VisitorPrice;

import java.text.SimpleDateFormat;
import java.util.Date;

//TODO: chain of command voor loggers = security pattern
public class PizzaTime {
    public static void main(String[] args) {
        //     Pizza Margeritha = new PlainPizza();
        //     Pizza Salami = new Salami(new PlainPizza());
        //     OrderGroup bestelling = new OrderGroup();
        //     OrderGroup dagBestellingen = new OrderGroup();

        //     Order order = new Order(Salami, 2);
        //     Order order2 = new Order(Margeritha, 1);
        //     VisitorPrice prijs = new VisitorPrice();
        //     bestelling.addChild(order);
        //     bestelling.addChild(order2);

        //     OrderGroup bestelling2 = new OrderGroup();
        //     bestelling2.addChild(new Order(Salami, 1));

        //     dagBestellingen.addChild(bestelling);
        //     dagBestellingen.addChild(bestelling2);
        //    // bestelling.acceptVisitor(prijs);
        //     dagBestellingen.acceptVisitor(prijs);

        //     //prijs.getTotalPrice();
        //     System.out.println(prijs.getTotalPrice());

        System.out.println("Welkom bij Java Pizza. Kan ik uw bestelling opnemen?");
        System.out.println("Er is keuze uit: ");
        //het menu
        Menu newInstance = Menu.getInstance();
        System.out.println(newInstance.pizzas());

        System.out.println(order());
    }

    public static String date() {
        //maakt gebruik van java date functie om huidige datum tijd op te vragen
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(format.format(date));
        return format.format(date);
    }

    public static Order order() {
        /*TODO: input sanitizen - filter op int en char
         TODO: checken of aantal pizza's niet 0 of minder is
        */
        Scanner scanner = new Scanner(System.in);

        String name;
        String house;
        String adress;
        String pizza;
        int amount;
        int toppings;
        String extraToppings;

        //naam van gebruiker input opvragen, mag niet leeg zijn
        while (true) {
            System.out.print("Naam: ");
            name = scanner.nextLine();
            if (name.isBlank() == false) {
                break;
            }
            System.out.println("Vul uw naam in");
        }

        //adres van gebruiker input opvragen, mag niet leeg zijn
        while (true) {
            System.out.print("Straat en huisnummer: ");
            house = scanner.nextLine();
            if (house.isBlank() == false) {
                break;
            }
            System.out.println("Vul uw adres in");
        }

        //postcode van gebruiker input opvragen, mag niet leeg zijn
        while (true) {
            System.out.print("Postcode en plaats: ");
            adress = scanner.nextLine();
            if (adress.isBlank() == false) {
                break;
            }
            System.out.println("Vul uw postcode in");
        }

        //soort pizza opvragen, mag niet leeg zijn
        while (true) {
            System.out.print("Pizza: ");
            pizza = scanner.nextLine();
            if (pizza.isBlank() == false) {
                break;
            }
            System.out.println("Vul uw keus in");
        }

        //kijk of pizza bekend is, anders default hij naar Margherita
        Pizza Margeritha = new PlainPizza();
        Pizza Salami = new Salami(new PlainPizza());
        Pizza Tonno = new Tonno(new PlainPizza());
        Pizza Hawaii = new Hawaii(new PlainPizza());
        switch (pizza) {
            case "Margherita":
                pizza = "Margherita";
                toppings = Margeritha.getToppings();
                extraToppings = Margeritha.getDescription();
                break;
            case "Salami":
                pizza = "Salami";
                toppings = Salami.getToppings();
                extraToppings = Salami.getDescription();
                break;
            case "Tonno":
                toppings = Tonno.getToppings();
                extraToppings = Tonno.getDescription();
                break;
            case "Hawaii":
                toppings = Hawaii.getToppings();
                extraToppings = Hawaii.getDescription();
                break;
            default:
                toppings = Margeritha.getToppings();
                extraToppings = Margeritha.getDescription();
                break;
        }

        //aantal pizza opvragen, alleen int
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Aantal Pizzas: ");
            try {
                amount = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ongeldige input");
                continue;
            }
            break;
        }

        OrderGroup bestelling = new OrderGroup();
        OrderGroup dagBestellingen = new OrderGroup();
        Order order = new Order(extraToppings, extraToppings, extraToppings, Margeritha , toppings, toppings, extraToppings);
        switch (pizza) {
            case "Margherita":
                order = new Order(name, house, adress, Margeritha, amount, toppings, extraToppings);
                break;
            case "Salami":
                order = new Order(name, house, adress, Salami, amount, toppings, extraToppings);
                break;
            case "Tonno":
                order = new Order(name, house, adress, Tonno, amount, toppings, extraToppings);
                break;
            case "Hawaii":
                order = new Order(name, house, adress, Hawaii, amount, toppings, extraToppings);
                break;
            default:
                order = new Order(name, house, adress, Margeritha, amount, toppings, extraToppings);
                break;
        }
        scanner.close();


        VisitorPrice prijs = new VisitorPrice();
        bestelling.addChild(order);
        bestelling.acceptVisitor(prijs);

        System.out.println(name + "\n" + house + "\n" + adress + "\n" + pizza + "\n" + amount + "\n" + toppings + "\n" + extraToppings + "\n" + date());
        System.out.println("De totale prijs is: " + prijs.getTotalPrice());

        
       // return order;
        return null;

        //maak bestelling in een string en return dat
        //als er extra toppings zijn voeg die toe aan de string
        // String order;
        // if (extraToppings.isBlank()) {
        //     order = name + "\n" + house + "\n" + adress + "\n" + pizza + "\n" + amount + "\n" + toppings + "\n" + date();
        // } else {
        //     order = name + "\n" + house + "\n" + adress + "\n" + pizza + "\n" + amount + "\n" + toppings + "\n" + extraToppings + "\n" + date();
        // }
        //scanner.close();
        // order;
    }
}