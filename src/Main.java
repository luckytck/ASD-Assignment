
import ADTs.CircularDoublyLinkedList;
import ADTs.LinearSinglyLinkedList;
import ADTs.ListInterface;
import ADTs.QueueInterface;
import Classes.Address;
import Classes.Affiliate;
import Classes.DeliveryMan;
import Classes.File;
import Classes.File;
import static Classes.File.storeAffiliateList;
import Classes.Order;
import Classes.User;
import Classes.Validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final String PENDINGDELIVERYFILE = "pendingDelivery.dat";
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
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Make Schedule Order
                                                        makeScheduleOrder(username);
                                                    } else if (selection[2] == 3) {
                                                        //TODO: Track Order
                                                        trackOrder(username);
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 2) {//Affiliate
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
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Update Item Details
                                                        updateItemDetails(username);
                                                    } else if (selection[2] == 3) {
                                                        //TODO: Update Item Status
                                                        updateItemStatus(username);
                                                    } else if (selection[2] == 4) {
                                                        //TODO: Remove Items
                                                        removeItems(username);
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 3) {//Delivery Man
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
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Clock Out
                                                        clockOut(username);
                                                    } else if (selection[2] == 3) {
                                                        //TODO: Retrieve Customer Details
                                                        retrieveCustomerDetails();
                                                    } else if (selection[2] == 4) {
                                                        //TODO: Update Working Status
                                                        updateWorkingStatus(username);
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 4) {//Operational Staff
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Retrieve Pending Delivery");
                                                System.out.println("2. Retrieve Scheduled Orders");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
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
                                                        loop[3] = true;
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Retrieve Scheduled Orders
                                                        retrieveScheduledOrders();
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 5) {//HR Executive
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Add New Delivery Man");
                                                System.out.println("2. Update Delivery Man Contact Details");
                                                System.out.println("3. Update Delivery Man Status");
                                                System.out.println("4. Generate Daily Report");
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
                                                        //TODO: Add New Delivery Man
                                                        addNewDeliveryMan();
                                                        loop[3] = true;
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Update Delivery Man Details
                                                        updateDeliveryManContactDetails();
                                                        loop[3] = true;
                                                    } else if (selection[2] == 3) {
                                                        //TODO: Update Delivery Man Status
                                                        updateDeliveryManStatus();
                                                    } else if (selection[2] == 4) {
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

    public static void placeAdHocOrder(String username) {

    }

    public static void makeScheduleOrder(String username) {

    }

    public static void trackOrder(String username) {

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
        Scanner scanner = new Scanner(System.in);
        QueueInterface<Order> orderQueue = File.retrieveQueue(PENDINGDELIVERYFILE);
        System.out.println("RETRIEVE PENDING DELIVERY");
        System.out.println("=========================");
        System.out.print("Retrieve next pending delivery? (Y=Yes): ");
        char getNext = scanner.next().charAt(0);
        while (Character.toUpperCase(getNext) == 'Y') {
            if (!orderQueue.isEmpty()) {
                Order order = orderQueue.dequeue();
                System.out.println("ORDER DETAILS");
                System.out.println("=============");
                System.out.println("Order No            : " + order.getOrderNo());
                System.out.println("Customer Name       : " + order.getCustomer().getName());
                System.out.println("Customer Contact No.: " + order.getCustomer().getContactNo());
                System.out.println("Affiliate Name      : " + order.getAffiliate().getRestaurantName());
                System.out.println("Order Date          : " + order.printOrderDate());
                System.out.println("Order Time          : " + order.printOrderTime());
                System.out.println("Order Status        : " + order.getStatus());
                System.out.println("continue....assign pending delivery to delivery man");
                System.out.println("---------------------------------------------------------------------");
                System.out.print("Retrieve next pending delivery? (Y=Yes): ");
                getNext = scanner.next().charAt(0);
            } else {
                System.out.println("Well done!! All pending deliveries have been assigned.");
                break;
            }
        }
        System.out.println("You will be returned back to operation list in 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static void retrieveScheduledOrders() {

    }

    private static void addNewDeliveryMan() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        DeliveryMan.setNextID(1000 + deliveryManList.getNumberOfEntries());
        char addOther;
        do {
            System.out.println("Add New Delivery Man");
            System.out.println("====================");
            System.out.println("Please enter following details:");
            System.out.print("                 Username : ");
            String username = scanner.nextLine();
            while (Validation.CheckDuplicateUsername(username, deliveryManList)) {
                System.out.println("Sorry, this username already exist.");
                System.out.println("Please try other username.");
                System.out.print("                 Username : ");
                username = scanner.nextLine();
            }
            System.out.print("                 Password : ");
            String password = scanner.nextLine();
            System.out.print("                     Name : ");
            String name = scanner.nextLine();
            System.out.print("             Gender (M/F) : ");
            while (!scanner.hasNext("[mMfF]{1}")) {
                System.out.println("Please enter character [M/F] only");
                System.out.print("             Gender (M/F) : ");
                scanner.next();
            }
            char gender = scanner.next().charAt(0);
            System.out.print("Contact No.(01#-########) : ");
            while (!scanner.hasNext("01[0-9]{1}-[0-9]{7,8}")) {
                System.out.println("Please enter a valid contact number.");
                System.out.print("Contact No.(01#-########) : ");
                scanner.next();
            }
            String contactNo = scanner.next();
            scanner.nextLine();
            System.out.print("     NRIC(######-##-####) : ");
            while (!scanner.hasNext("[0-9]{6}-[0-9]{2}-[0-9]{4}")) {
                System.out.println("Please enter a valid NRIC.");
                System.out.print("     NRIC(######-##-####) : ");
                scanner.next();
            }
            String NRIC = scanner.next();
            scanner.nextLine();
            System.out.print("            Email Address : ");
            while (!scanner.hasNext("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})")) {
                System.out.println("Please enter a valid email address.");
                System.out.print("            Email Address : ");
                scanner.next();
            }
            String email = scanner.next();
            scanner.nextLine();
            System.out.print("                  Address : ");
            String address = scanner.nextLine();
            System.out.print("                    State : ");
            String state = scanner.nextLine();
            System.out.print("                     City : ");
            String city = scanner.nextLine();
            System.out.print("        Postcode(5-digit) : ");
            while (!scanner.hasNext("[0-9]{5}")) {
                System.out.println("Please enter 5-digit postcode.");
                System.out.print("        Postcode(5-digit) : ");
                scanner.next();
            }
            int postcode = scanner.nextInt();
            scanner.nextLine();
            System.out.print("         Basic Salary(RM) : ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter numeric value.");
                System.out.print("         Basic Salary(RM) : ");
                scanner.next();
            }
            double basicSalary = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Confirm to add a new delivery man? (Y=Yes): ");
            char confirmation = scanner.next().charAt(0);
            scanner.nextLine();
            if (Character.toUpperCase(confirmation) == 'Y') {
                Address fullAddress = new Address(address, state, city, postcode);
                DeliveryMan newDeliveryMan = new DeliveryMan(NRIC, email, basicSalary, fullAddress, username, password, name, gender, contactNo);
                deliveryManList.add(newDeliveryMan);
                File.storeList(deliveryManList, DELIVERYMANFILE);
                System.out.println("Added Successfully!!!");
            } else {
                System.out.println("Operation Cancelled!!!");
            }
            System.out.print("Do you want to add another delivery man? (Y=Yes): ");
            addOther = scanner.next().charAt(0);
            scanner.nextLine();
        } while (Character.toUpperCase(addOther) == 'Y');
        System.out.println("You will be returned back to operation list in 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static void updateDeliveryManContactDetails() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        DeliveryMan.setNextID(1000 + deliveryManList.getNumberOfEntries());
        int count = deliveryManList.getNumberOfEntries();
        int selection[] = new int[2];
        boolean loop[] = new boolean[3];
        do {
            loop[0] = false;
            System.out.println("Update Delivery Man Contact Details");
            System.out.println("===================================");
            System.out.println(String.format("%-3s %-4s %-10s %-20s %-6s %-12s %-14s %-20s %-12s %-80s %-10s %-14s", "NO.", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "NRIC", "EMAIL", "BASIC_SALARY", "ADDRESS", "STATUS", "WORKING_STATUS"));
            for (int i = 1; i <= deliveryManList.getNumberOfEntries(); i++) {
                System.out.printf("%-3s %s\n", i + ".", deliveryManList.getEntry(i));
            }
            if (count != 0) {
                System.out.print("Please select a delivery man you want to update (0 to cancel): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter numeric value only.");
                    scanner.nextLine();
                    loop[0] = true;
                } else {
                    selection[0] = scanner.nextInt();
                    scanner.nextLine();
                    if (selection[0] >= 0 && selection[0] <= count) {
                        if (selection[0] != 0) {
                            do {
                                loop[1] = false;
                                System.out.println("Delivery Man Contact Details");
                                System.out.println("============================");
                                System.out.println("1. Contact Number");
                                System.out.println("2. Address");
                                System.out.println("0. Reselect Delivery Man");
                                System.out.print("Please select a contact detail you want to update: ");
                                while (!scanner.hasNext("[012]{1}")) {
                                    System.out.println("Please select option [0-2] only.");
                                    scanner.nextLine();
                                    loop[1] = true;
                                }
                                selection[1] = scanner.nextInt();
                                scanner.nextLine();
                                if (selection[1] == 1) {//Update Contact Number
                                    do {
                                        loop[2] = false;
                                        String oldContactNo = deliveryManList.getEntry(selection[0]).getContactNo();
                                        System.out.println("Update Contact Number");
                                        System.out.println("=====================");
                                        System.out.println("Old Contact No. : " + oldContactNo);
                                        System.out.println("---------------------");
                                        System.out.print("New Contact No.(01#-########): ");
                                        String newContactNo = scanner.nextLine();
                                        if (Validation.ValidateContactNumber(newContactNo)) {
                                            deliveryManList.getEntry(selection[0]).setContactNo(newContactNo);
                                            File.storeList(deliveryManList, DELIVERYMANFILE);
                                            System.out.println("Updated Successfully!!!");
                                            System.out.print("Do you want to update other details? (Y=Yes): ");
                                            char updateOtherDetails = scanner.next().charAt(0);
                                            scanner.nextLine();
                                            if (Character.toUpperCase(updateOtherDetails) == 'Y') {
                                                loop[1] = true;
                                            }
                                        } else {
                                            System.out.println("Please enter a valid contact number.");
                                            loop[2] = true;
                                        }
                                    } while (loop[2] == true);

                                } else if (selection[1] == 2) {//Update Address
                                    do {
                                        loop[2] = false;
                                        Address oldFullAddress = deliveryManList.getEntry(selection[0]).getAddress();
                                        String oldAddress = oldFullAddress.getAddress();
                                        String oldState = oldFullAddress.getState();
                                        String oldCity = oldFullAddress.getCity();
                                        int oldPostcode = oldFullAddress.getPostcode();
                                        System.out.println("Update Address");
                                        System.out.println("=====================");
                                        System.out.println("Old Address : " + oldAddress);
                                        System.out.println("Old State   : " + oldState);
                                        System.out.println("Old City    : " + oldCity);
                                        System.out.println("old Postcode: " + oldPostcode);
                                        System.out.println("---------------------");
                                        System.out.print("New Address : ");
                                        String newAddress = scanner.nextLine();
                                        System.out.print("New State   : ");
                                        String newState = scanner.nextLine();
                                        System.out.print("New City    : ");
                                        String newCity = scanner.nextLine();
                                        System.out.print("New Postcode: ");
                                        while (!scanner.hasNext("[0-9]{5}")) {
                                            System.out.println("Please enter 5-digit postcode.");
                                            System.out.print("New Postcode: ");
                                            scanner.next();
                                        }
                                        int newPostcode = scanner.nextInt();
                                        scanner.nextLine();
                                        Address newFullAddress = new Address(newAddress, newState, newCity, newPostcode);
                                        deliveryManList.getEntry(selection[0]).setAddress(newFullAddress);
                                        File.storeList(deliveryManList, DELIVERYMANFILE);
                                        System.out.println("Updated Successfully!!!");
                                        System.out.print("Do you want to update other details? (Y=Yes): ");
                                        char updateOtherDetails = scanner.next().charAt(0);
                                        scanner.nextLine();
                                        if (Character.toUpperCase(updateOtherDetails) == 'Y') {
                                            loop[1] = true;
                                        }

                                    } while (loop[2] == true);
                                } else {//Reselect Delivery Man
                                    loop[0] = true;
                                }
                            } while (loop[1] == true);

                        }
                    } else {
                        System.out.println("Please select option [0-" + count + "] only.");
                        loop[0] = true;
                    }
                }
            } else {
                System.out.println("No delivery man found in database.");
            }
        } while (loop[0] == true);
        System.out.println("You will be returned back to operation list in 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static void updateDeliveryManStatus() {

    }

    private static void generateDailyReport() {

    }

    private static void registerAsAffiliate() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<Affiliate> affiliateList = new LinearSinglyLinkedList<>();
        affiliateList = File.retrieveAffiliateList(AFFILIATEFILE);

        String username, password, name, contactNo, restaurantName, businessRegNo, GSTRegNo, restaurantContactNo, address, state, city;
        char gender;
        int postcode = 0;
        System.out.println("Register as Affiliate");
        System.out.println("===========================================================================================");

        System.out.println("Please enter your :");

        do {
            System.out.print("Username    :");
            username = scanner.nextLine();
            if (Validation.CheckDuplicateUsername(username, affiliateList)) {
                System.out.println("The username already exist.");
            }
        } while (Validation.CheckDuplicateUsername(username, affiliateList));

        System.out.print("Passowrd    :");
        password = scanner.nextLine();

        System.out.print("Name        :");
        name = scanner.nextLine();
        do {
            System.out.print("Gender (M=Male or F=Female):");
            gender = scanner.next().charAt(0);
            gender = Character.toUpperCase(gender);
            if (gender != 'M' && gender != 'F') {
                System.out.println("Please enter M or F.");
            }
        } while (gender != 'M' && gender != 'F');
        scanner.nextLine();
        do {

            System.out.print("Contact No. (01#-########) :");
            contactNo = scanner.nextLine();

            if (!Validation.ValidateContactNumber(contactNo)) {
                System.out.println("Please enter a valid contact No.");
            }
        } while (!Validation.ValidateContactNumber(contactNo));
        System.out.println("");
        System.out.println("Please fill up restaurant's detail :");
        System.out.print("Resaturant Name :");
        restaurantName = scanner.nextLine();

        System.out.print("Business Registration No. :");
        businessRegNo = scanner.nextLine();

        System.out.print("GST Registration No. :");
        GSTRegNo = scanner.nextLine();
        do {
            System.out.print("Restaurant Contact No.(01#-########) :");
            restaurantContactNo = scanner.nextLine();
            if (!Validation.ValidateContactNumber(restaurantContactNo)) {
                System.out.println("Please enter a valid contact No.");
            }
        } while (!Validation.ValidateContactNumber(restaurantContactNo));

        System.out.println("");
        System.out.println("Restaurant Location :");
        System.out.print("Address :");
        address = scanner.nextLine();

        System.out.print("State :");
        state = scanner.nextLine();

        System.out.print("City :");
        city = scanner.nextLine();
        boolean isNotInteger = false;
        do {
            System.out.print("Postcode :");
            try {
                postcode = scanner.nextInt();

            } catch (NumberFormatException e) {
                System.out.println("Please enter integer.");
                isNotInteger = true;
            }
        } while (isNotInteger);
        char ans;

        System.out.print("Are you confirm to register?(Yes = Y) : ");
        ans = scanner.next().charAt(0);
        if (Character.toUpperCase(ans) == 'Y') {
            Address affiliateAddress = new Address(address, state, city, postcode);
            Affiliate newAffiliate = new Affiliate(restaurantName, businessRegNo, GSTRegNo, restaurantContactNo, affiliateAddress, username, password, name, gender, contactNo);
            affiliateList.add(newAffiliate);
            if (storeAffiliateList(affiliateList,AFFILIATEFILE)) {
                System.out.println("\nYou had register successful.");
            } else {
                System.out.println("\nFailed to register ,please try again.");
            }

        } else {
            System.out.println("\nYou had cancel to register.");
        }

    }
}
