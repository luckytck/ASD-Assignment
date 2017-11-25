
package restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    
    public static String strFoodMenu;
    public static String strDrinkMenu;
    public static String strMenu;
    public static int choice;
    public static int choice2;
    public static double price = 0;
    public static double accPrice = 0;
    public static String menu = "";
    public static int count = 0;

    public static List<MenuItem> MenuItemList = new ArrayList<>();
    public static List<String> Menu = new ArrayList<>();
    public static List<Double> Price = new ArrayList<>();

    public static void main(String[] args) {
        
        MenuItem meetMee1 = new MenuItem("Papa Pan mee",7.50);
        MenuItem meetMee2 = new MenuItem("Mama Pan mee",6.50);
        
        MenuItemList.add(meetMee1);
        MenuItemList.add(meetMee2);
        
        menu();
    }
    
     public static void menu() {
        System.out.println("\nWelcome to delivery system.");
        System.out.println("Please choose a restaurant to view menu");
        System.out.println("1.Meet Mee noodle cafe - Combination of noodle & coffee");
        System.out.println("2.New place restaurant - Malaysian's favourite place");
        System.out.println("3.Sweet forest cafe - Best western food choice");

        Scanner reader = new Scanner(System.in);
        
        System.out.print("Your choice(1-3): ");
        choice = reader.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.println("Sorry, no such restaurant");
            System.out.print("Re-enter your choice(1-3): ");
            choice = reader.nextInt();
        }

        switch (choice) {
            case 1:
                meetMee();
                break;

            case 2:
                newPlace();
                break;

            case 3:
                sweetForest();
                break;
        }
    }
     
     public static void meetMee() {
        strFoodMenu = "\n\nFOOD CHOICE: \n"
                + "1.Papa Pan Mee RM7.50\n"
                + "2.Mama Pan Mee RM6.50\n"
                + "3.Vegetarian Pan Mee RM5.50\n"
                + "4.Traditional Pan Mee(Dry) RM6.00\n";

        strDrinkMenu = "\n\nBEVERAGE CHOICE: \n"
                + "5.Jasmine Green Tea(Hot/Cold) RM4.50\n"
                + "6.Honey Milk(Hot/Cold) RM5.50\n"
                + "7.Cappuccino(Hot/Cold) RM5.50\n"
                + "8.Latte(Hot/Cold) RM5.00\n";

        strMenu = strFoodMenu + strDrinkMenu;

        System.out.println("\n" + "Welcome to MEET MEE NOODLE CAFE :)"
                + strMenu);
        
        do
        {
            Scanner reader = new Scanner(System.in);
            System.out.print("Please select your choice(1-8), -1 to order cart: ");
            choice2 = reader.nextInt();
        
            switch(choice2){
            case 1:
               Menu.add("Papa Pan Mee");
               Price.add(7.50);
               accPrice += MenuItemList.get(0).getPrice();
               count++;
               break;
               
            case 2:
               Menu.add("Mama Pan Mee");
               Price.add(6.50);
               accPrice += MenuItemList.get(1).getPrice();
               count++;
               break;
            }
        }while(choice2 > 0);
        
        System.out.println("\nYOUR ORDER");
        System.out.println("No." + "\t" + "Item" + "\t\t" + "Price(RM)");
        System.out.println("===================================");
        
        for(int i = 0; i < count; ++i){
            System.out.println((i+1) + "\t" + Menu.get(i) + "\t" + String.format("%.2f",Price.get(i)));
        }
        
        System.out.println("\nTotal price: RM" + String.format("%.2f",accPrice));

    }

    public static void newPlace() {
        strFoodMenu = "\n\nFOOD CHOICE: \n"
                + "NF1.Nasi Lemak Biasa RM4.00\n"
                + "NF2.Nasi Goreng Cina RM6.50\n"
                + "NF3.Asam Laksa RM5.50\n"
                + "NF4.Curry Mee RM6.00\n";

        strDrinkMenu = "\n\nBEVERAGE CHOICE: \n"
                + "ND1.Teh tarik(Hot/Cold) RM2.00\n"
                + "ND2.Teh O Limau(Hot/Cold) RM2.20\n"
                + "ND3.Kopi(Hot/Cold) RM2.50\n"
                + "ND4.Soya milk(bottle) RM4.00\n";

        strMenu = strFoodMenu + strDrinkMenu;

        System.out.println("\n" + "Welcome to NEW PLACE RESTAURANT :)"
                + strMenu);
    }

    public static void sweetForest() {
        strFoodMenu = "\n\nFOOD CHOICE: \n"
                + "SF1.Chicken chop(Mushroom/Black pepper/Mango) RM10.50\n"
                + "SF2.Spaghetti(Bolognese/Aglio Olio/White sauce) RM7.00\n"
                + "SF3.Beef steak RM15.00\n"
                + "SF4.Pancake(Honey/Butter) RM5.50\n";

        strDrinkMenu = "\n\nBEVERAGE CHOICE: \n"
                + "SD1.Champagne(Cold) RM7.00\n"
                + "SD2.Lemon Tea(Hot/Cold) RM3.50\n"
                + "SD3.Americano(Hot) RM5.50\n"
                + "SD4.Mocha(Hot/Cold) RM5.00\n";

        strMenu = strFoodMenu + strDrinkMenu;

        System.out.println("\n" + "Welcome to SWEET FOREST CAFE :)"
                + strMenu);
    }
}
