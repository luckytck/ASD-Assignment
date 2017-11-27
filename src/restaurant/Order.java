package restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Affiliate.Affiliate;
import Affiliate.MenuItem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Order {

    public static int choice, option, foodChoice, drinkChoice, choice2;
    public static char answer;
    public static int foodCount = 0, beverageCount = 0;
    public static double totalPrice = 0;

    public static OrderItem foodOrder[] = new OrderItem[100];
    public static OrderItem beverageOrder[] = new OrderItem[100];
    public static String foodName, beverageName;
    public static int foodQty, beverageQty;
    public static double foodPrice, beveragePrice;

    private static List<MenuItem> FoodList = new ArrayList<>();
    private static List<MenuItem> BeverageList = new ArrayList<>();
    private static List<Affiliate> AffiliateList = new ArrayList<>();
    private static List<OrderItem> OrderList = new ArrayList<>();

    //Read restaurant from Affiliate.dat
    public static void getRestaurant() {
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("Affiliate.dat"));
            AffiliateList = (ArrayList) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        String str = "";
        for (int a = 0; a < AffiliateList.size(); ++a) {
            str += String.format("%d. %s\n", a + 1, AffiliateList.get(a).getRestaurant_Name());
        }
        System.out.println(str);
    }

    //Get the restaurant name
    public static String getRestaurantName(int index) {

        return AffiliateList.get(index).getRestaurant_Name();
    }

    //Display the available food menu
    public static void printFood(String restaurantName) {
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(restaurantName + "Food.dat"));
            FoodList = (ArrayList) (oiStream.readObject());

            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }

        String Title, Price, Discount, Status;
        Title = "Title";
        Price = "Price";
        Discount = "Discount(%)";
        Status = "Status";
        String outputStr = String.format("%15s %13s %15s %13s \n", Title, Price, Discount, Status);
        for (int i = 0; i < FoodList.size(); ++i) {
            outputStr += (i + 1) + ". " + FoodList.get(i) + "\n";
        }
        System.out.println(outputStr);

    }

    //Display the available beverage menu
    public static void printBeverage(String restaurantName) {
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(restaurantName + "Beverage.dat"));
            BeverageList = (ArrayList) (oiStream.readObject());

            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        String Title, Price, Discount, Status;
        Title = "Title";
        Price = "Price";
        Discount = "Discount(%)";
        Status = "Status";
        String outputStr = String.format("%15s %13s %15s %13s \n", Title, Price, Discount, Status);
        for (int i = 0; i < BeverageList.size(); ++i) {
            outputStr += (i + 1) + ". " + BeverageList.get(i) + "\n";
        }
        System.out.println(outputStr);

    }

    public static void main(String[] args) {

        System.out.println("\nRestaurant List");
        System.out.println("=================");

        getRestaurant();

        Scanner reader = new Scanner(System.in);
        System.out.print("Select a restaurant: ");
        choice = reader.nextInt() - 1;
        reader.nextLine();

        System.out.println("\n");
        System.out.println("FOOD CHOICE:");
        printFood(getRestaurantName(choice));
        System.out.println("BEVERAGE CHOICE:");
        printBeverage(getRestaurantName(choice));
        System.out.println("\n");

        //Prompt for multiple food choice
        do {

            Scanner food = new Scanner(System.in);
            System.out.print("Select your food:");
            foodChoice = food.nextInt() - 1;
            food.nextLine();

            Scanner qty = new Scanner(System.in);
            System.out.print("Enter food quantity:");
            foodQty = qty.nextInt();
            qty.nextLine();

            for (int a = 0; a < FoodList.size(); ++a) {
                foodName = FoodList.get(foodChoice).getName();
                foodPrice = FoodList.get(foodChoice).getPrice();
                totalPrice += (foodPrice * foodQty);
                foodOrder[a] = new OrderItem(foodName, foodQty, foodPrice, totalPrice);
                OrderList.add(foodOrder[a] = new OrderItem(foodName, foodQty, foodPrice, totalPrice));
                break;
            }

            System.out.print("Do you want to select more food?(Y=Yes)");
            Scanner reader2 = new Scanner(System.in);
            answer = reader2.next().charAt(0);

        } while (answer == 'Y' || answer == 'y');

        System.out.println("");

        //Prompt for multiple beverage choice
        do {

            Scanner drink = new Scanner(System.in);
            System.out.print("Select your drink:");
            drinkChoice = drink.nextInt() - 1;
            drink.nextLine();

            Scanner qty = new Scanner(System.in);
            System.out.print("Enter beverage quantity:");
            beverageQty = qty.nextInt();
            qty.nextLine();

            for (int a = 0; a < BeverageList.size(); ++a) {
                beverageName = BeverageList.get(drinkChoice).getName();
                beveragePrice = BeverageList.get(drinkChoice).getPrice();
                totalPrice += (beveragePrice * beverageQty);
                beverageOrder[a] = new OrderItem(beverageName, beverageQty, beveragePrice, totalPrice);
                OrderList.add(beverageOrder[a] = new OrderItem(beverageName, beverageQty, beveragePrice, totalPrice));
                break;
            }
            System.out.print("Do you want to select more beverage?(Y=Yes)");
            Scanner reader2 = new Scanner(System.in);
            answer = reader2.next().charAt(0);

        } while (answer == 'Y' || answer == 'y');

        System.out.println("YOUR ORDER");
        System.out.println("No." + "\t" + "Item" + "\t\t" + "Quantity" + "\t" + "Unit Price(RM)");
        System.out.println("=======================================================");
        for (int i = 0; i < OrderList.size(); i++) {
            System.out.println((i + 1) + "\t" + OrderList.get(i).getName() + "\t"
                    + OrderList.get(i).getQty() + "\t\t" + String.format("%.2f", OrderList.get(i).getPrice()));
        }

        System.out.println("\nTotal price: RM " + String.format("%.2f", totalPrice));
    }

//    public static void addOrder() {
//        try {
//            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("Order.dat"));
//            ooStream.writeObject(OrderList);
//            ooStream.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found");
//        } catch (IOException ex) {
//            System.out.println("Cannot save to file");
//        }
//    }
//    
//    public static void printOrder() {
//        try {
//            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("Order.dat"));
//            OrderList = (ArrayList) (oiStream.readObject());
//
//            oiStream.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found");
//        } catch (IOException ex) {
//            System.out.println("Cannot read from file");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Class not found");
//        }
//
//        System.out.println("No." + "\t" + "Item" + "\t\t" + "Quantity" + "\t" + "Price(RM)");
//        System.out.println("=======================================================");
//        for (int i = 0; i < OrderList.size(); i++) {
//            System.out.println((i + 1) + "\t" + OrderList.get(i).getName() + "\t"
//                    + OrderList.get(i).getQty() + "\t\t" + OrderList.get(i).getPrice());
//        }
//    }
}
