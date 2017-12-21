package Classes;

import ADTs.CircularDoublyLinkedList;
import ADTs.CircularDoublyLinkedQueue;
import ADTs.LinearSinglyLinkedList;
import ADTs.ListInterface;
import ADTs.QueueInterface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class File {

    /**
     * Task: Store a new list to a specified file name within the project
     * directory.
     *
     * @param list an ListInterface being saved into the specified file name
     * @param fileName an String of the file name
     */
     public static int getAffiliateIndex(String username,String fileName) {
        ListInterface<User> list= retrieveList(fileName);
        
        int index = -1;

        for (int i = 1; i <= list.getNumberOfEntries(); ++i) {
            if (list.getEntry(i).getUsername().equals(username)) {
                index = i;
            }

        }
        return index;

    }

   
   public static void printMenuItem(int index, int menuCode) {
        ListInterface<Affiliate> itemlist = retrieveList("affiliate.dat");
        
       if(menuCode==1){
           System.out.println("Food");
           System.out.println("=====================================");
           if(itemlist.getEntry(index).getFood().isEmpty()==true){
               System.out.println("No item in the list.");
           }else{
                String Title, Price, Discount, Status,Description;
                Title = "TiTle";
                Description="Description";
                Price = "Price";
                Discount = "Discount(%)";
                Status = "Status";
                String outputStr = String.format("%-30s %-30s %14s %12s %-15s \n", Title,Description, Price, Discount, Status);
                for (int i = 1; i <= itemlist.getEntry(index).getFood().getNumberOfEntries(); ++i) {
                    outputStr += (i) + ". " + itemlist.getEntry(index).getFood().getEntry(i) + "\n";
                }
                System.out.println(outputStr);
           }
        } 
       else {
           System.out.println("Beverage");
           System.out.println("=====================================");
            if (itemlist.getEntry(index).getBeverage().isEmpty()) {
                System.out.println("No item in the list.");
            } else {
                String Title, Price, Discount, Status,Description;
                Title = "TiTle";
                Description="Description";
                Price = "Price";
                Discount = "Discount(%)";
                Status = "Status";
                String outputStr = String.format("%-30s %-30s %14s %12s %-15s \n", Title,Description, Price, Discount, Status);
                for (int i = 1; i <= itemlist.getEntry(index).getBeverage().getNumberOfEntries(); ++i) {
                    outputStr += (i) + ". " + itemlist.getEntry(index).getBeverage().getEntry(i) + "\n";
                }
                System.out.println(outputStr);
            }
        }

    }
   
    public static void printWholeMenu(int index) {
        ListInterface<Affiliate> menuList = retrieveList("affiliate.dat");
        
        if (menuList.getEntry(index).getFood().isEmpty() == true) {
            System.out.println("No food in the list.");
        } 
        else {
            System.out.println("\nAvailable Food Menu");
            System.out.println("===================");
            System.out.println("No.\tFood Name\t\tUnit Price(RM)");
            for (int a = 1; a <= menuList.getEntry(index).getFood().getNumberOfEntries(); a++) {
                System.out.println(a + "\t" + menuList.getEntry(index).getFood().getEntry(a).getName() +
                        "\t\t" + String.format("%.2f",menuList.getEntry(index).getFood().getEntry(a).getPrice()));
            }
        }
        
        System.out.println("\n");
        
        if (menuList.getEntry(index).getBeverage().isEmpty() == true) {
            System.out.println("No beverage in the list.");
        } 
        else {
            System.out.println("Available Beverage Menu");
            System.out.println("========================");
            System.out.println("No.\tBeverage Name\t\tUnit Price(RM)");
            for (int a = 1; a <= menuList.getEntry(index).getFood().getNumberOfEntries(); ++a) {
                System.out.println(a + "\t" + menuList.getEntry(index).getBeverage().getEntry(a).getName() +
                        "\t\t" + String.format("%.2f",menuList.getEntry(index).getBeverage().getEntry(a).getPrice()));
            }
        }
    }

    public static <T> void storeList(ListInterface<T> list, String fileName) {
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

   

    public static <T> ListInterface<T> retrieveList(String fileName) {
        ListInterface<T> list = new CircularDoublyLinkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (ListInterface<T>) (oiStream.readObject());
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

    /**
     * Task: Retrieve a list from a specified file name within the project
     * directory.
     *
     * @param fileName an String of the file name where the list stored at
     * @return a reference to the indicated list or null, if either file does
     * not exist or the file does not contains a list
     */
  

    /**
     * Task: Store a new queue to a specified file name within the project
     * directory.
     *
     * @param queue an QueueInterface being saved into the specified file name
     * @param fileName an String of the file name
     */
    public static <T> void storeQueue(QueueInterface<T> queue, String fileName) {
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ooStream.writeObject(queue);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
        }
    }

    /**
     * Task: Retrieve a queue from a specified file name within the project
     * directory.
     *
     * @param fileName an String of the file name where the list stored at
     * @return a reference to the indicated queue or null, if either file does
     * not exist or the file does not contains a queue
     */
    public static <T> QueueInterface<T> retrieveQueue(String fileName) {
        QueueInterface<T> queue = new CircularDoublyLinkedQueue<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            queue = (QueueInterface<T>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return queue;
    }
}
