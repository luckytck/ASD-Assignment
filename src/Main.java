
import ADTs.LinkedList;
import ADTs.ListInterface;
import Classes.User;
import Classes.Validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    public static final String ORDERFILE = "order.dat";
    public static final String CUSTOMERFILE = "customer.dat";
    public static final String AFFILIATEFILE = "affiliate.dat";
    public static final String DELIVERYMANFILE = "deliveryMan.dat";
    public static final String OPERATIONALSTAFFFILE = "operationalStaff.dat";
    public static final String EXECUTIVEFILE = "executive.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection[] = new int[10];
        boolean loop[] = new boolean[10];
        do {
            loop[0] = false;
            System.out.println("Fastest Deliveryman");
            System.out.println("===================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Selection: ");
            if (!scanner.hasNext("[012]{1}")) {
                System.out.println("Please select option [0-3] only.");
                scanner.nextLine();
                loop[0] = true;
            } else {
                selection[0] = scanner.nextInt();
                scanner.nextLine();
                if (selection[0] == 1) {
                    do {
                        loop[1] = false;
                        System.out.println("Type Of Account");
                        System.out.println("===============");
                        System.out.println("1. Customer");
                        System.out.println("2. Affiliate");
                        System.out.println("3. Delivery Man");
                        System.out.println("4. Operational Staff");
                        System.out.println("5. HR Executive");
                        System.out.println("0. Return to previous page");
                        System.out.print("Login As: ");
                        if (!scanner.hasNext("[012345]{1}")) {
                            System.out.println("Please select option [0-5] only.");
                            scanner.nextLine();
                            loop[1] = true;
                        } else {
                            selection[1] = scanner.nextInt();
                            scanner.nextLine();
                            String fileName = "";
                            switch (selection[1]) {
                                case 1:
                                    fileName = CUSTOMERFILE;
                                    break;
                                case 2:
                                    fileName = AFFILIATEFILE;
                                    break;
                                case 3:
                                    fileName = DELIVERYMANFILE;
                                    break;
                                case 4:
                                    fileName = OPERATIONALSTAFFFILE;
                                    break;
                                case 5:
                                    fileName = EXECUTIVEFILE;
                                    break;
                            }
                            if (selection[1] >= 1 && selection[1] <= 5) {
                                do {
                                    loop[2] = false;
                                    System.out.println("Please login your account:");
                                    System.out.print("Username: ");
                                    String username = scanner.nextLine();
                                    System.out.print("Password: ");
                                    String password = scanner.nextLine();
                                    if (Validation.ValidateAccount(username, password, fileName)) {
                                        if (selection[1] == 1) {//Customer
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Place Ad-hoc Order");
                                                System.out.println("2. Make Schedule Order");
                                                System.out.println("3. Track Order");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
                                                if (!scanner.hasNext("[0123]{1}")) {
                                                    System.out.println("Please select option [0-3] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Place Ad-hoc Order
                                                        placeAdHocOrder(username);
                                                    } else if (selection[2] == 2){
                                                        //TODO: Make Schedule Order
                                                        makeScheduleOrder(username);
                                                    } else if (selection[2] == 3){
                                                        //TODO: Track Order
                                                        trackOrder(username);
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 2){//Affiliate
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Add New Items");
                                                System.out.println("2. Update Item Details");
                                                System.out.println("3. Update Item Status");
                                                System.out.println("4. Remove Items");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
                                                if (!scanner.hasNext("[01234]{1}")) {
                                                    System.out.println("Please select option [0-4] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Add New Items
                                                        addNewItems(username);
                                                    } else if(selection[2] == 2){
                                                        //TODO: Update Item Details
                                                        updateItemDetails(username);
                                                    } else if(selection[2] == 3){
                                                        //TODO: Update Item Status
                                                        updateItemStatus(username);
                                                    } else if(selection[2] == 4){
                                                        //TODO: Remove Items
                                                        removeItems(username);
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 3){//Delivery Man
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Clock In");
                                                System.out.println("2. Clock Out");
                                                System.out.println("3. Retrieve Customer Details");
                                                System.out.println("4. Update Working Status");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
                                                if (!scanner.hasNext("[01234]{1}")) {
                                                    System.out.println("Please select option [0-4] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Clock In
                                                        clockIn(username);
                                                    } else if (selection[2] == 2){
                                                        //TODO: Clock Out
                                                        clockOut(username);
                                                    } else if (selection[2] == 3){
                                                        //TODO: Retrieve Customer Details
                                                        retrieveCustomerDetails();
                                                    } else if (selection[2] == 4){
                                                        //TODO: Update Working Status
                                                        updateWorkingStatus(username);
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }            
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 4){//Operational Staff
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Retrieve Pending Delivery");
                                                System.out.println("2. Retrieve Scheduled Orders");
                                                System.out.println("0. Logout");
                                                if (!scanner.hasNext("[012]{1}")) {
                                                    System.out.println("Please selection option [0-2] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Retrieve Pending Delivery
                                                        retrievePendingDelivery();
                                                    } else if (selection[2] == 2){
                                                        //TODO: Retrieve Scheduled Orders
                                                        retrieveScheduledOrders();
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 5){//HR Executive
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Add New Delivery Man");
                                                System.out.println("2. Update Delivery Man Details");
                                                System.out.println("3. Update Delivery Man Status");
                                                System.out.println("4. Generate Daily Report");
                                                System.out.println("0. Logout");
                                                if (!scanner.hasNext("[01234]{1}")) {
                                                    System.out.println("Please select option [0-4] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Add New Delivery Man
                                                        addNewDeliveryMan();
                                                    } else if (selection[2] == 2){
                                                        //TODO: Update Delivery Man Details
                                                        updateDeliveryManDetails();
                                                    } else if (selection[2] == 3){
                                                        //TODO: Update Delivery Man Status
                                                        updateDeliveryManStatus();
                                                    } else if (selection[2] == 4){
                                                        //TODO: Generate Daily Report
                                                        generateDailyReport();
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        }
                                    } else {
                                        System.out.println("Access Denied!!!");
                                        System.out.println("Please enter a valid username & password.");
                                        loop[2] = true;
                                    }
                                } while (loop[2] == true);

                            } else {//Return to previous page
                                loop[0] = true;
                            }
                        }

                    } while (loop[1] == true);
                } else if (selection[0] == 2) {//Register
                    do {
                        loop[1] = false;
                        System.out.println("Type Of Account");
                        System.out.println("===============");
                        System.out.println("1. Affiliate");
                        System.out.println("0. Return to previous page");
                        System.out.print("Register As: ");
                        if (!scanner.hasNext("[01]{1}")) {
                            System.out.println("Please select option [0-1] only.");
                            scanner.nextLine();
                            loop[1] = true;
                        } else {
                            selection[1] = scanner.nextInt();
                            scanner.nextLine();
                            if (selection[1] == 1) {
                                //TODO: Register As Affiliate
                                registerAsAffiliate();
                            } else {//Return to previous page
                                loop[0] = true;
                            }
                        }
                    } while (loop[1] == true);

                } else {
                    System.out.println("Thank you for using this system.");
                    System.out.println("Please come back again~");
                }
            }
        } while (loop[0] == true);
    }
    
    public static void placeAdHocOrder(String username){
        
    }
    public static void makeScheduleOrder(String username){
        
    }
    public static void trackOrder(String username){
        
    }

    private static void addNewItems(String username) {
        
    }

    private static void updateItemDetails(String username) {
        
    }

    private static void updateItemStatus(String username) {
        
    }

    private static void removeItems(String username) {
        
    }

    private static void clockIn(String username) {
        
    }

    private static void clockOut(String username) {
        
    }

    private static void retrieveCustomerDetails() {
        
    }

    private static void updateWorkingStatus(String username) {
        
    }

    private static void retrievePendingDelivery() {
        
    }

    private static void retrieveScheduledOrders() {
        
    }

    private static void addNewDeliveryMan() {
        
    }

    private static void updateDeliveryManDetails() {
        
    }

    private static void updateDeliveryManStatus() {
        
    }

    private static void generateDailyReport() {
        
    }

    private static void registerAsAffiliate() {
        
    }
}
