import ADTs.LinkedList;
import ADTs.LinkedQueue;
import ADTs.ListInterface;
import ADTs.QueueInterface;
import Classes.Customer;
import Classes.Order;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class TrackFoodOrder {
    
    public static final String CUSTOMERFILE = "customer.dat";
    public static final String ORDERFILE = "order.dat";
    
        private static <T> QueueInterface<T> initializeQueue(String fileName) { //Return a Queue from .dat file
        QueueInterface<T> list = new LinkedQueue<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (LinkedQueue) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return list;
    }
    
    private static <T> ListInterface<T> initializeList(String fileName) { //Return a List from .dat file
        ListInterface<T> list = new LinkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (LinkedList) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return list;
    }    
    
      private static boolean ValidateAccount(String username, String password) {
        boolean isValid = false;
        ListInterface<Customer> customerList = initializeList(CUSTOMERFILE);
        String tempUsername, tempPassword;
        for (int i = 1; i <= customerList.getNumberOfEntries(); i++) {
            tempUsername = customerList.getEntry(i).getUsername();
            tempPassword = customerList.getEntry(i).getPassword();
            if (tempUsername.equalsIgnoreCase(username) && tempPassword.equals(password)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Login as Customer");
        System.out.println("----------------------");
        System.out.print("User name: ");
         String username = scanner.nextLine();
        System.out.print("Password  : ");
        String password = scanner.nextLine();
        if(ValidateAccount(username,password)){
             System.out.println("\nFood Ordered List");
             System.out.println("===========");
          
              ListInterface<Customer> sampleList = initializeList(CUSTOMERFILE);
              ListInterface<Order> orderList = initializeList(ORDERFILE);
                    if (!orderList.isEmpty()) {
                        String checkUsername;
                        for(int i = 1; i <= sampleList.getNumberOfEntries( ); i++ ){
                            checkUsername = sampleList.getEntry(i).getUsername();
                            
                            if(checkUsername.matches(username)){                 
                                System.out.println("Order No \t Restaurant \t Order Date \t Order Time \t Order Status \t\t Estimated Remaining Time " );
                                 System.out.println(orderList.getEntry(i).getOrderNo() + "\t"+ orderList.getEntry(i).getAffiliate().getRestaurantName() + "\t"+ orderList.getEntry(i).printOrderDate()  + "\t"+ orderList.getEntry(i).printOrderTime() + "\t"+ orderList.getEntry(i).getStatus()  + "\t"+ "35 minute(s) left");
                            }
       
                        }

                    }
            
        }else
            System.out.println("Wrong username or password!");
        
        
        
       
        
        
    }
    
}
