package restaurant;

import java.util.Scanner;
import Affiliate.addItem;
import static Affiliate.addItem.getRestaurantName;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public static int choice;
    public static int option;
    public static int foodChoice;
    public static int drinkChoice;
    public static double foodPrice = 0;
    public static double drinkPrice = 0;
    public static double accPrice = 0;
    public static String foodMenu = "";
    public static String drinkMenu = "";
    public static int count = 0;
    public static char answer;

    public static List<String> FoodList = new ArrayList<>();
    public static List<String> BeverageList = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("\nRestaurant List");
        System.out.println("=================");

        addItem.getRestaurant();

        Scanner reader = new Scanner(System.in);
        System.out.print("Select a restaurant: ");
        choice = reader.nextInt() - 1;
        reader.nextLine();

        System.out.println("\n");
        System.out.println("FOOD CHOICE:");
        addItem.printFood(getRestaurantName(choice));
        System.out.println("BEVERAGE CHOICE:");
        addItem.printBeverage(getRestaurantName(choice));
        System.out.println("\n");

        //Prompt for multiple food choice
        do {
            food();

            for (int i = 0; i < foodMenu.length(); i++) {
                FoodList.add(foodMenu + "\t" + foodPrice);
                accPrice = accPrice + foodPrice;
                break;
            }

            System.out.print("Do you want to select more food?(Y=Yes)");
            Scanner reader2 = new Scanner(System.in);
            answer = reader2.next().charAt(0);

        } while (answer == 'Y' || answer == 'y');

        System.out.println("");

        //Prompt for multiple beverage choice
        do {
            beverage();

            for (int i = 0; i < drinkMenu.length(); ++i) {
                BeverageList.add(drinkMenu + "\t" + drinkPrice);
                accPrice = accPrice + drinkPrice;
                break;
            }

            System.out.print("Do you want to select more beverage?(Y=Yes)");
            Scanner reader2 = new Scanner(System.in);
            answer = reader2.next().charAt(0);

        } while (answer == 'Y' || answer == 'y');

        System.out.println("YOUR ORDER");
        System.out.println("Item" + "\t\t" + "Price(RM)");
        System.out.println("===================================");
        System.out.println("FOOD:");
        for (int i = 0; i < addItem.FoodList.size(); ++i) {
            System.out.println(FoodList.get(i) + "\t");
        }

        System.out.println("\nBEVERAGE:");
        for (int i = 0; i < addItem.BeverageList.size(); i++) {
            System.out.println(BeverageList.get(i) + "\t");
        }

        System.out.println("\nTotal price: RM " + String.format("%.2f", accPrice));
    }

    //Select food and store into variable
    public static void food() {
        Scanner food = new Scanner(System.in);
        System.out.print("Select your food:");
        foodChoice = food.nextInt() - 1;
        food.nextLine();

        foodMenu = addItem.FoodList.get(foodChoice).getName();
        foodPrice = addItem.FoodList.get(foodChoice).getPrice();
    }

    //Select beverage and store into variable
    public static void beverage() {
        Scanner drink = new Scanner(System.in);
        System.out.print("Select your drink:");
        drinkChoice = drink.nextInt() - 1;
        drink.nextLine();

        drinkMenu = addItem.BeverageList.get(drinkChoice).getName();
        drinkPrice = addItem.BeverageList.get(drinkChoice).getPrice();
    }
}
