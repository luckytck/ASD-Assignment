package SampleData;


import ADTs.CircularDoublyLinkedList;
import ADTs.CircularDoublyLinkedQueue;
import ADTs.ListInterface;
import ADTs.QueueInterface;
import Classes.Address;
import Classes.Affiliate;
import Classes.Customer;
import Classes.MenuItem;
import Classes.Order;
import Classes.OrderItem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class OrderList {
    public static final String ORDERFILE = "order.dat";
    public static final String PENDINGDELIVERYFILE = "pendingDelivery.dat";
    public static final String AFFILIATEFILE = "affiliate.dat";
    public static final String CUSTOMERFILE = "customer.dat";
    
    private static <T> ListInterface<T> initializeList(String fileName) { //Return a List from .dat file
        ListInterface<T> list = new CircularDoublyLinkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (CircularDoublyLinkedList) (oiStream.readObject());
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
        QueueInterface<T> list = new CircularDoublyLinkedQueue<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (CircularDoublyLinkedQueue) (oiStream.readObject());
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

    public static void main(String[] args) {
        //Retrieve Affiliate List from affiliate.dat
        ListInterface<Affiliate> affiliateList = initializeList(AFFILIATEFILE);
        
        //Retrieve Customer List from customer.dat
        ListInterface<Customer> customerList = initializeList(CUSTOMERFILE);
        
        //Create Order Item Lists
        ListInterface<OrderItem> itemList1 = new CircularDoublyLinkedList<>();
        OrderItem item1 = new OrderItem(affiliateList.getEntry(1).getBeverage().getEntry(1), 2, "Less Sugar");
        OrderItem item2 = new OrderItem(affiliateList.getEntry(1).getBeverage().getEntry(2), 1, "Less Ice");
        OrderItem item3 = new OrderItem(affiliateList.getEntry(1).getFood().getEntry(1), 2, "");
        itemList1.add(item1);
        itemList1.add(item2);
        itemList1.add(item3);
        
        ListInterface<OrderItem> itemList2 = new CircularDoublyLinkedList<>();
        OrderItem item4 = new OrderItem(affiliateList.getEntry(2).getBeverage().getEntry(1), 2, "Hot");
        OrderItem item5 = new OrderItem(affiliateList.getEntry(2).getFood().getEntry(1), 1, "");
        OrderItem item6 = new OrderItem(affiliateList.getEntry(2).getFood().getEntry(2), 1, "");
        itemList2.add(item4);
        itemList2.add(item5);
        itemList2.add(item6);
        
        ListInterface<OrderItem> itemList3 = new CircularDoublyLinkedList<>();
        OrderItem item7 = new OrderItem(affiliateList.getEntry(1).getBeverage().getEntry(1), 1, "");
        OrderItem item8 = new OrderItem(affiliateList.getEntry(1).getBeverage().getEntry(2), 1, "Half Ice");
        OrderItem item9 = new OrderItem(affiliateList.getEntry(1).getBeverage().getEntry(3), 1, "Half Sugar");
        OrderItem item10 = new OrderItem(affiliateList.getEntry(1).getFood().getEntry(2), 2, "");
        itemList3.add(item7);
        itemList3.add(item8);
        itemList3.add(item9);
        itemList3.add(item10);
        
        //Create Order
        Order order1 = new Order(itemList1, customerList.getEntry(1), affiliateList.getEntry(1), new GregorianCalendar(2017, 11, 5, 8, 0, 0));
        Order order2 = new Order(itemList2, customerList.getEntry(2), affiliateList.getEntry(2), new GregorianCalendar(2017, 11, 6, 9, 0, 0));
        Order order3 = new Order(itemList3, customerList.getEntry(3), affiliateList.getEntry(1), new GregorianCalendar(2017, 11, 6, 13, 0, 0));
        
        //Create Order List
        ListInterface<Order> orderList = new CircularDoublyLinkedList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        QueueInterface<Order> orderQueue = new CircularDoublyLinkedQueue<>();
        orderQueue.enqueue(order1);
        orderQueue.enqueue(order2);
        orderQueue.enqueue(order3);
        
        //Store orderList into order.dat
        storeList(orderList, ORDERFILE);
        storeQueue(orderQueue, PENDINGDELIVERYFILE);
        
        //Retrieve orderList from order.dat to sampleList
        ListInterface<Order> sampleList = initializeList(ORDERFILE);
        QueueInterface<Order> sampleQueue = initializeQueue(PENDINGDELIVERYFILE);
        
        //Print sampleQueue Details
        System.out.println(String.format("%-8s %-15s %-30s %-12s %-10s %-10s %-20s", "ORDER_NO", "CUSTOMER", "AFFILIATE", "TOTAL_AMOUNT", "ORDER_DATE", "ORDER_TIME", "STATUS"));
        while (!sampleQueue.isEmpty()){
            System.out.println(sampleQueue.dequeue());
        }
        
    }
    
}
