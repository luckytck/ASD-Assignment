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
     public static int getAffiliateIndex(String username) {
        ListInterface<Affiliate> list = new LinearSinglyLinkedList<>();
        list = File.retrieveList("affiliate.dat");
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
           if(itemlist.getEntry(index).getFood().isEmpty()==true){
               System.out.println("No item in the list.");
           }else{
                String Title, Price, Discount, Status;
                Title = "TiTle";
                Price = "Price";
                Discount = "Discount(%)";
                Status = "Status";
                String outputStr = String.format("%15s %13s %15s %13s \n", Title, Price, Discount, Status);
                for (int i = 1; i <= itemlist.getEntry(index).getFood().getNumberOfEntries(); ++i) {
                    outputStr += (i) + ". " + itemlist.getEntry(index).getFood().getEntry(i) + "\n";
                }
                System.out.println(outputStr);
           }
        } 
       else {
            if (itemlist.getEntry(index).getBeverage().isEmpty()) {
                System.out.println("No item in the list.");
            } else {
                String Title, Price, Discount, Status;
                Title = "TiTle";
                Price = "Price";
                Discount = "Discount(%)";
                Status = "Status";
                String outputStr = String.format("%15s %13s %15s %13s \n", Title, Price, Discount, Status);
                for (int i = 1; i <= itemlist.getEntry(index).getBeverage().getNumberOfEntries(); ++i) {
                    outputStr += (i) + ". " + itemlist.getEntry(index).getBeverage().getEntry(i) + "\n";
                }
                System.out.println(outputStr);
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
