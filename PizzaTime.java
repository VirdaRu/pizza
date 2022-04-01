import java.io.Console;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PizzaTime {
    public static void main(String[] args) {

        System.out.println("Welkom bij Java Pizza. Kan ik uw bestelling opnemen?");
        System.out.println("Er is keuze uit: " + menu());
        
        System.out.println(bestelling());
        }

    public static String menu() {
        //menu zit in aparte methode voor makkelijk toevoegen
        return "Margherita, Salami, Tonno, Hawaii";
    }

    public static String datum() {
        //maakt gebruik van java date functie om huidige datum tijd op te vragen
        SimpleDateFormat opmaak = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date datum = new Date();
        System.out.println(opmaak.format(datum));
        return opmaak.format(datum);
    }

    public static String bestelling() {
         /*TODO: input sanitizen - filter op int en char
         TODO: checken of aantal pizza's niet 0 of minder is
        */
        Scanner scanner = new Scanner(System.in);

        String naam;
        String huis;
        String adres;
        String pizza;
        int aantal;
        int toppings;
        String extraToppings;

        //naam van gebruiker input opvragen, mag niet leeg zijn
        while (true) {
            System.out.print("Naam: ");
            naam = scanner.nextLine();
            if (naam.isBlank() == false) {
                break;
            }
            System.out.println("Vul uw naam in");
        }

        //adres van gebruiker input opvragen, mag niet leeg zijn
        while (true) {
            System.out.print("Straat en huisnummer: ");
            huis = scanner.nextLine();
            if (huis.isBlank() == false) {
                break;
            }
            System.out.println("Vul uw adres in");
        }

        //postcode van gebruiker input opvragen, mag niet leeg zijn
        while (true) {
            System.out.print("Postcode en plaats: ");
            adres = scanner.nextLine();
            if (adres.isBlank() == false) {
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

        //kijk of pizza bekend is, anders default
        //Margherita, Salami, Tonno, Hawaii
        switch (pizza) {
            case "Margherita":
                toppings = 0;
                extraToppings = Pizza();
                break;
            case "Salami":
                toppings = 1;
                extraToppings = Salami();
                break;
            case "Tonno":
                toppings = 2;
                extraToppings = Tonno();
                break;
            case "Hawaii":
                toppings = 2;
                extraToppings = Hawaii();
                break;
            default:
                toppings = 0;
                extraToppings = "";
                break;
        }

        //aantal pizza opvragen, alleen int
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Aantal Pizzas: ");
            try {
                aantal = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ongeldige input");
                continue;
            }
            break;
        }

        //maak bestelling in een string en return dat
        //als er extra toppings zijn voeg die toe aan de string
        String bestelling;
        if (extraToppings.isBlank()) {
            bestelling = naam + "\n" + huis + "\n" + adres + "\n" + pizza + "\n" + aantal + "\n" + toppings + "\n" + datum();
        } else {
            bestelling = naam + "\n" + huis + "\n" + adres + "\n" + pizza + "\n" + aantal + "\n" + toppings + "\n" + extraToppings + "\n" + datum();
        }
        scanner.close();
        return bestelling;
    }

    //Structural - The Decorator Design Pattern ((hoop ik))
    //toppings van pizza bepalen
    public static String Pizza() {
        return "";
    }
    public static String Salami() {
        return Pizza() + "Salami";
    }
    public static String Tonno() {
        return Pizza() + "Tonijn \nUi";
    }
    public static String Hawaii() {
        return Pizza() + "Ananas \nHam";
    }

}