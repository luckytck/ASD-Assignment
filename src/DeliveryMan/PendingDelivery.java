package DeliveryMan;

import ADTs.CircularDoublyLinkedList;
import ADTs.CircularDoublyLinkedQueue;
import ADTs.ListInterface;
import ADTs.QueueInterface;
import Classes.File;
import Classes.OperationalStaff;
import Classes.Order;
import Classes.User;
import Classes.Validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PendingDelivery {
    public static final String PENDINGDELIVERYFILE = "pendingDelivery.dat";
    public static final String OPERATIONALSTAFFFILE = "operationalStaff.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("OPERATIONAL STAFF");
        System.out.println("=================");
        System.out.println("Please login your account,");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (Validation.ValidateAccount(username, password, OPERATIONALSTAFFFILE)) {
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
                System.out.println("Thank you for using this system!!");
            } else {
                System.out.println("Thank you for using this system!!");
            }
        } else {
            System.out.println("Access Denied!!! Wrong username or password!!");
        }

    }

}
