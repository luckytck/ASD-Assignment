import Classes.File;
import Classes.Affiliate;
import Classes.MenuItem;
import ADTs.LinearSinglyLinkedList;
import ADTs.ListInterface;
import ADTs.CircularDoublyLinkedQueue;
import ADTs.QueueInterface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class addnewitem {

   
    public static void main(String[] args) {
       String fileName="affiliate.dat";
      ListInterface<Affiliate> affiliate=new LinearSinglyLinkedList<>();
      affiliate=File.retrieveAffiliateList(fileName);
      addNewItem(affiliate.getEntry(0).getUsername());  
      
      
        
    }
     public static void printMenuItem(ListInterface list) {
        ListInterface<MenuItem> itemlist=new LinearSinglyLinkedList<>();
        itemlist=list;
        if(itemlist.isEmpty()){
            System.out.println("No item in the list.");
        }else{
            String Title, Price, Discount, Status;
        Title = "TiTle";
        Price = "Price";
        Discount = "Discount(%)";
        Status = "Status";
        String outputStr = String.format("%15s %13s %15s %13s \n", Title, Price, Discount, Status);
            for (int i = 1; i <= itemlist.getNumberOfEntries(); ++i) {
            outputStr += (i) + ". " + itemlist.getEntry(i) + "\n";
        }
        System.out.println(outputStr);
        } 
        
        
        
        

    }

    public static boolean checkValid(String name, double price, double discountrate) {
        if (!name.isEmpty() && price > 0 && discountrate >= 0) {
            return true;
        }

        return false;
    }

 
     public static int getAffiliateIndex(String username){
         ListInterface<Affiliate> list =new LinearSinglyLinkedList<>();
         list=File.retrieveAffiliateList("affiliate.dat");
         int index=-1;
         
         for(int i=1;i<=list.getNumberOfEntries();++i){
             if(list.getEntry(i).getUsername().equals(username)){
                 index=i;
             }
             
         }
         return index;
         
     }
     
     
     
    public static void addNewItem(String username){
        Scanner scanner=new Scanner(System.in);
        int index=getAffiliateIndex(username);
        ListInterface<Affiliate> affiliateList=File.retrieveAffiliateList("affiliate.dat");
        System.out.println("Which type of menu you want to add? :");
        System.out.println("1.Food");
        System.out.println("2.Beverage");
        System.out.print("Enter the number of your choice :");
        int choice = scanner.nextInt();
         switch (choice) {
            case 1: {

                printMenuItem(affiliateList.getEntry(index).getFood());
                System.out.print("Do you want to add new item?(Yes=Y)");
                char answer2 = scanner.next().charAt(0);
                scanner.nextLine();

                if (Character.toUpperCase(answer2) == 'Y') {
                    String Name;
                    double price = -1;
                    double discountrate = -1;
                    do {
                        System.out.print("Item's Name:");
                        Name = scanner.nextLine();

                        System.out.print("Price:");
                        price = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Discount(%):");
                        discountrate = scanner.nextDouble();
                        scanner.nextLine();
                        if (!checkValid(Name, price, discountrate)) {
                            System.out.println("Please enter again.");
                            System.out.println("\n");
                        }
                    } while (!checkValid(Name, price, discountrate));
                    if (checkValid(Name, price, discountrate)) {
                        MenuItem item=new MenuItem();
                        item.setName(Name);
                        item.setPrice(price);
                        item.setDiscountRate(discountrate);
                        affiliateList.getEntry(index).getFood().add(item);
                        File.storeAffiliateList(affiliateList,"affiliate.dat");
                        System.out.println("Your item has been added successful.");
                        printMenuItem(affiliateList.getEntry(index).getFood());
                    }
                } else {
                    System.out.println("Thanks for using.");
                }
                break;
            }
            case 2: {

                printMenuItem(affiliateList.getEntry(index).getBeverage());
                System.out.print("Do you want to add new item?(Yes=Y)");
                char answer2 = scanner.next().charAt(0);
                scanner.nextLine();

                if (Character.toUpperCase(answer2) == 'Y') {
                    String Name;
                    double price = -1;
                    double discountrate = -1;
                    do {
                        System.out.print("Item's Name:");
                        Name = scanner.nextLine();

                        System.out.print("Price:");
                        price = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Discount(%):");
                        discountrate = scanner.nextDouble();
                        scanner.nextLine();
                        if (!checkValid(Name, price, discountrate)) {
                            System.out.println("Please enter again.");
                            System.out.println("\n");
                        }
                    } while (!checkValid(Name, price, discountrate));
                    if (checkValid(Name, price, discountrate)) {
                        MenuItem item=new MenuItem();
                        item.setName(Name);
                        item.setPrice(price);
                        item.setDiscountRate(discountrate);
                        affiliateList.getEntry(index).getBeverage().add(item);
                        File.storeAffiliateList(affiliateList,"affiliate.dat");
                        System.out.println("Your item has been added successful.");
                        printMenuItem(affiliateList.getEntry(index).getBeverage());

                    }
                } else {
                    System.out.println("Thanks for using.");
                }

                break;
            }
            default:
                break;
        }
        
     
        
        
    }
    
}
