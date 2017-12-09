package SampleData;


import ADTs.LinkedList;
import ADTs.ListInterface;
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
    public static final String AFFILIATEFILE = "affiliate.dat";
    public static final String CUSTOMERFILE = "customer.dat";
    
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

    public static void main(String[] args) {
        //Retrieve Affiliate List from affiliate.dat
        ListInterface<Affiliate> affiliateList = initializeList(AFFILIATEFILE);
        
        //Retrieve Customer List from customer.dat
        ListInterface<Customer> customerList = initializeList(CUSTOMERFILE);
        
        //Create Order Item Lists
        ListInterface<OrderItem> itemList1 = new LinkedList<>();
        OrderItem item1 = new OrderItem(affiliateList.getEntry(1).getBeverage().getEntry(1), 2, "Less Sugar");
        OrderItem item2 = new OrderItem(affiliateList.getEntry(1).getBeverage().getEntry(2), 1, "Less Ice");
        OrderItem item3 = new OrderItem(affiliateList.getEntry(1).getFood().getEntry(1), 2, "");
        itemList1.add(item1);
        itemList1.add(item2);
        itemList1.add(item3);
        
        ListInterface<OrderItem> itemList2 = new LinkedList<>();
        OrderItem item4 = new OrderItem(affiliateList.getEntry(1).getBeverage().getEntry(1), 2, "Hot");
        OrderItem item5 = new OrderItem(affiliateList.getEntry(2).getFood().getEntry(1), 1, "");
        OrderItem item6 = new OrderItem(affiliateList.getEntry(1).getFood().getEntry(3), 1, "");
        itemList2.add(item4);
        itemList2.add(item5);
        itemList2.add(item6);
        
        //Create Order
        Order order1 = new Order(itemList1, customerList.getEntry(1), affiliateList.getEntry(1), new GregorianCalendar(2017, 11, 5, 8, 0, 0));
        Order order2 = new Order(itemList2, customerList.getEntry(2), affiliateList.getEntry(2), new GregorianCalendar(2017, 11, 6, 9, 0, 0));
        
        //Create Order List
        ListInterface<Order> orderList = new LinkedList<>();
        orderList.add(order1);
        orderList.add(order2);
        
        //Store orderList into order.dat
        storeList(orderList, ORDERFILE);
        
        //Retrieve orderList from order.dat to sampleList
        ListInterface<Order> sampleList = initializeList(ORDERFILE);
        
        //Print sampleList Details
        System.out.println(String.format("%-8s %-15s %-30s %-12s %-10s %-10s %-20s", "ORDER_NO", "CUSTOMER", "AFFILIATE", "TOTAL_AMOUNT", "ORDER_DATE", "ORDER_TIME", "STATUS"));
        for (int i = 1; i <= sampleList.getNumberOfEntries(); i++) {
            System.out.println(sampleList.getEntry(i));
        }
        
    }
    
}
