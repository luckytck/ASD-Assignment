
package SampleData;

import ADTs.LinkedList;
import ADTs.ListInterface;
import Classes.Address;
import Classes.OperationalStaff;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OperationalStaffList {
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
    
    public static void main(String[] args) {
        //Create Addresses
        Address address1 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        Address address2 = new Address("Jalan Han 1/2, Taman Han", "Kuala Lumpur", "Setapak", 53300);
        
        //Create Delivery Men
        OperationalStaff staff1 = new OperationalStaff("970219-14-6459","luckytck97@gmail.com", 2000.00, address1, "Human Resources", "staff1", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        OperationalStaff staff2 = new OperationalStaff("971115-14-1455","qihan@gmail.com", 1900.00, address2, "Accounting", "staff2", "1234", "Tan Qi Han", 'M', "012-3456789");
        
        //Print Staff Details
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-20s %-14s %-20s %-12s %-80s %-10s", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "DEPARTMENT", "NRIC", "EMAIL", "BASIC_SALARY", "ADDRESS", "STATUS"));
        System.out.println(staff1);
        System.out.println(staff2);
        
        //Create Staff List
        ListInterface<OperationalStaff> operationalStaffList = new LinkedList<>();
        operationalStaffList.add(staff1);
        operationalStaffList.add(staff2);
        
        //Store Staff List into operationalStaff.dat
        storeList(operationalStaffList, OPERATIONALSTAFFFILE);
    }
    
}
