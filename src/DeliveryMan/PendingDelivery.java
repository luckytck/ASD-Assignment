package DeliveryMan;

import ADTs.LinkedList;
import ADTs.LinkedQueue;
import ADTs.ListInterface;
import ADTs.QueueInterface;
import Classes.OperationalStaff;
import Classes.Order;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PendingDelivery {

    public static final String ORDERFILE = "order.dat";
    public static final String PENDINGDELIVERYFILE = "pendingDelivery.dat";
    public static final String OPERATIONALSTAFFFILE = "operationalStaff.dat";

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

    private static <T> void storeList(ListInterface<T> list, String fileName) { //Store a List into .dat file
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ooStream.writeObject(list);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
        }
    }

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

    private static <T> void storeQueue(QueueInterface<T> list, String fileName) { //Store a Queue into .dat file
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ooStream.writeObject(list);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
        }
    }

    private static boolean ValidateAccount(String username, String password) {
        boolean isValid = false;
        ListInterface<OperationalStaff> staffList = initializeList(OPERATIONALSTAFFFILE);
        String tempUsername, tempPassword;
        for (int i = 1; i <= staffList.getNumberOfEntries(); i++) {
            tempUsername = staffList.getEntry(i).getUsername();
            tempPassword = staffList.getEntry(i).getPassword();
            if (tempUsername.equalsIgnoreCase(username) && tempPassword.equals(password)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("OPERATIONAL STAFF");
        System.out.println("=================");
        System.out.println("Please login your account,");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (ValidateAccount(username, password)) {
            System.out.println("OPERATION LIST");
            System.out.println("==============");
            System.out.println("1. Retrieve Pending Delivery");
            System.out.println("2. Exit");
            System.out.print("Selection: ");
            while (!scanner.hasNext("[12]{1}")) {
                System.out.println("Please enter option 1-2 only.");
                System.out.print("Selection: ");
                scanner.next();
            }
            int operation = scanner.nextInt();
            scanner.nextLine();
            if (operation == 1) {
                QueueInterface<Order> orderQueue = initializeQueue(PENDINGDELIVERYFILE);
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
                System.out.println("Thank you for using this system!!");
            } else {
                System.out.println("Thank you for using this system!!");
            }
        } else {
            System.out.println("Wrong username or password!!");
        }

    }

}
