/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.Scanner;

public class Restaurant {

    public static String strFoodMenu;
    public static String strDrinkMenu;
    public static String strMenu;
    public static int choice;
    public static char choice2;

    public static void main(String[] args) {
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
                + "MF1.Papa Pan Mee RM7.50\n"
                + "MF2.Mama Pan Mee RM6.50\n"
                + "MF3.Vegetarian Pan Mee RM5.50\n"
                + "MF4.Traditional Pan Mee(Dry) RM6.00\n";

        strDrinkMenu = "\n\nDRINK CHOICE: \n"
                + "MD1.Jasmine Green Tea(Hot/Cold) RM4.50\n"
                + "MD2.Honey Milk(Hot/Cold) RM5.50\n"
                + "MD3.Cappuccino(Hot/Cold) RM5.50\n"
                + "MD4.Latte(Hot/Cold) RM5.00\n";

        strMenu = strFoodMenu + strDrinkMenu;

        System.out.println("\n" + "Welcome to MEET MEE NOODLE CAFE :)"
                + strMenu);

        promptChoice();
    }

    public static void newPlace() {
        strFoodMenu = "\n\nFOOD CHOICE: \n"
                + "NF1.Nasi Lemak Biasa RM4.00\n"
                + "NF2.Nasi Goreng Cina RM6.50\n"
                + "NF3.Asam Laksa RM5.50\n"
                + "NF4.Curry Mee RM6.00\n";

        strDrinkMenu = "\n\nDRINK CHOICE: \n"
                + "ND1.Teh tarik(Hot/Cold) RM2.00\n"
                + "ND2.Teh O Limau(Hot/Cold) RM2.20\n"
                + "ND3.Kopi(Hot/Cold) RM2.50\n"
                + "ND4.Soya milk(bottle) RM4.00\n";

        strMenu = strFoodMenu + strDrinkMenu;

        System.out.println("\n" + "Welcome to NEW PLACE RESTAURANT :)"
                + strMenu);

        promptChoice();
    }

    public static void sweetForest() {
        strFoodMenu = "\n\nFOOD CHOICE: \n"
                + "SF1.Chicken chop(Mushroom/Black pepper/Mango) RM10.50\n"
                + "SF2.Spaghetti(Bolognese/Aglio Olio/White sauce) RM7.00\n"
                + "SF3.Beef steak RM15.00\n"
                + "SF4.Pancake(Honey/Butter) RM5.50\n";

        strDrinkMenu = "\n\nDRINK CHOICE: \n"
                + "SD1.Champagne(Cold) RM7.00\n"
                + "SD2.Lemon Tea(Hot/Cold) RM3.50\n"
                + "SD3.Americano(Hot) RM5.50\n"
                + "SD4.Mocha(Hot/Cold) RM5.00\n";

        strMenu = strFoodMenu + strDrinkMenu;

        System.out.println("\n" + "Welcome to SWEET FOREST CAFE :)"
                + strMenu);

        promptChoice();
    }

    public static void promptChoice() {
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Do you want to view other restaurant menu?(Y=Yes, N=No): ");
        choice2 = reader.next().charAt(0);

        if (choice2 == 'y' || choice2 == 'Y') {
            menu();
        } else {
            System.out.println("Thanks for using! Please come again :)");
            System.exit(0);
        }
    }
}
