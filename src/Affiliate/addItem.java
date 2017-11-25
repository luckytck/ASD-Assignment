
package Affiliate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.*;

public class addItem{
    
    private static List<MenuItem> FoodList = new ArrayList<>();
    private static List<MenuItem> BeverageList = new ArrayList<>();
    private static List<Affiliate> AffiliateList = new ArrayList<>();
    private static int affiliateindex;
   
    public static void printBeverage(String restaurantName){
         try {
      ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(restaurantName+"Beverage.dat"));
      BeverageList = (ArrayList) (oiStream.readObject());

       oiStream.close();
    } catch (FileNotFoundException ex) {
             System.out.println("File not found");
    } catch (IOException ex) {
             System.out.println("Cannot read from file");
    } catch (ClassNotFoundException ex) {
             System.out.println("Class not found");
    }
          String Title,Price,Discount,Status;
     Title="TiTle";
     Price="Price";
     Discount="Discount(%)";
     Status="Status";
    String outputStr = String.format("%15s %13s %15s %13s \n",Title,Price,Discount,Status);
    for (int i = 0; i < BeverageList.size(); ++i) {
      outputStr += (i + 1) + ". " + BeverageList.get(i)+"\n";
    }
        System.out.println(outputStr);
         
    }
    public static void printFood(String restaurantName){
         try {
      ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(restaurantName+"Food.dat"));
      FoodList = (ArrayList) (oiStream.readObject());

       oiStream.close();
    } catch (FileNotFoundException ex) {
             System.out.println("File not found");
    } catch (IOException ex) {
             System.out.println("Cannot read from file");
    } catch (ClassNotFoundException ex) {
             System.out.println("Class not found");
    }
        
     String Title,Price,Discount,Status;
     Title="TiTle";
     Price="Price";
     Discount="Discount(%)";
     Status="Status";
    String outputStr = String.format("%15s %13s %15s %13s \n",Title,Price,Discount,Status);
    for (int i = 0; i < FoodList.size(); ++i) {
      outputStr += (i + 1) + ". " + FoodList.get(i)+"\n";
    }
        System.out.println(outputStr);
    
  }
    public static boolean checkValid(String name,double price,double discountrate){
        if(!name.isEmpty()&&price>0&&discountrate>=0)
        {
         return true;
        }
        
        return false;
    } 
    public static void addFood(String name,double price,double discountrate,String restaurantName){
         MenuItem item1=new MenuItem(name,price);
         item1.setDiscountRate(discountrate);
        FoodList.add(item1);

         try {
             
      ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(restaurantName+"Food.dat"));
      ooStream.writeObject(FoodList);
      //ooStream.close();
      ooStream.close();
    } catch (FileNotFoundException ex) {
        System.out.println("File not found");
    } catch (IOException ex) {
        System.out.println("Cannot save to file");
      
    }       
    }
    public static void addBeverage(String name,double price,double discountrate,String restaurantName){
        MenuItem item1=new MenuItem(name,price);
         item1.setDiscountRate(discountrate);
        BeverageList.add(item1);

         try {
      ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(restaurantName+"Beverage.dat"));
      ooStream.writeObject(BeverageList);
      //ooStream.close();
      ooStream.close();
    } catch (FileNotFoundException ex) {
        System.out.println("File not found");
    } catch (IOException ex) {
        System.out.println("Cannot save to file");
      
    }       
    }
  public static void getRestaurant(){
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
       String str="";
      for(int a=0;a<AffiliateList.size();++a){
          str+=String.format("%d. %s\n",a+1,AffiliateList.get(a).getRestaurant_Name());
      }
          System.out.println(str); 
  }
  public static String getRestaurantName(int index){
      
      return AffiliateList.get(index).getRestaurant_Name();
  }
 
    
     public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        
         getRestaurant();
         System.out.print("Select a restaurant to add menu item:");
         affiliateindex=scanner.nextInt()-1;
         scanner.nextLine();
         System.out.println("");  
         
             System.out.println("Which type of menu you want to add? :");
        System.out.println("1.Food");
        System.out.println("2.Beverage");
        System.out.print("Enter the number of your choice :");
        int choice=scanner.nextInt();        
        switch(choice){
            case 1:
            {          
                
              printFood(getRestaurantName(affiliateindex));
                System.out.print("Do you want to add new item?(Yes=Y)");
              char answer2=scanner.next().charAt(0);
              scanner.nextLine();
                
              if(Character.toUpperCase(answer2)=='Y')
              {
                  String Name;
                   double price=-1;
                   double discountrate=-1;
                   do{
                  System.out.print("Item's Name:");                 
                  Name=scanner.nextLine();
                  
                  System.out.print("Price:");
                  price=scanner.nextDouble();
                 scanner.nextLine();
                 System.out.print("Discount(%):");
                  discountrate=scanner.nextDouble();
               scanner.nextLine();
                  if(!checkValid(Name,price,discountrate)){
                      System.out.println("Please enter again.");
                      System.out.println("\n");
                  }
                   }while(!checkValid(Name,price,discountrate));
                  if(checkValid(Name,price,discountrate))
                  {
                      addFood(Name,price,discountrate,getRestaurantName(affiliateindex));
                      System.out.println("Your item has been added successful.");
                      printFood(getRestaurantName(affiliateindex));
                  }
              }
              else
              {
                  System.out.println("Thanks for using.");
              }
                   break;           
            }
            case 2:{
                
                 printBeverage(getRestaurantName(affiliateindex));
                System.out.print("Do you want to add new item?(Yes=Y)");
              char answer2=scanner.next().charAt(0);
              scanner.nextLine();
                
              if(Character.toUpperCase(answer2)=='Y')
              {
                  String Name;
                   double price=-1;
                   double discountrate=-1;
                   do{
                  System.out.print("Item's Name:");                 
                  Name=scanner.nextLine();
                  
                  System.out.print("Price:");
                  price=scanner.nextDouble();
                 scanner.nextLine();
                 System.out.print("Discount(%):");
                  discountrate=scanner.nextDouble();
               scanner.nextLine();
                  if(!checkValid(Name,price,discountrate)){
                      System.out.println("Please enter again.");
                      System.out.println("\n");
                  }
                   }while(!checkValid(Name,price,discountrate));
                  if(checkValid(Name,price,discountrate))
                  {
                      addBeverage(Name,price,discountrate,getRestaurantName(affiliateindex));
                      System.out.println("Your item has been added successful.");
                      printBeverage(getRestaurantName(affiliateindex));
                      
                  }
              }
              else
              {
                  System.out.println("Thanks for using.");
              }
                
                break;
            }
            default:
                break;
        } 
         }
        
         
      
     

   
}
