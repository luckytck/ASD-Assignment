package restaurant;

import ADTs.ListInterface;
import Classes.Customer;
import Classes.File;
import Classes.Validation;
import java.util.Scanner;

public class RetrieveCustomer {

    public static final String fileName = "customer.dat";

    public static void main(String[] args) {

        String phone, findPhoneNo, name = "", address = "", state = "", city = "";
        int postcode = 0;
        char gender = 0;
        boolean exist = false;

        ListInterface<Customer> customer = File.retrieveList(fileName);

        do {
            Scanner phoneNo = new Scanner(System.in);
            System.out.print("Please enter customer phone no.(01x-xxxxxxxx):");
            phone = phoneNo.next();

            if (Validation.ValidateContactNumber(phone) == true) {
                for (int i = 1; i <= customer.getNumberOfEntries(); i++) {
                    findPhoneNo = customer.getEntry(i).getContactNo();

                    if (findPhoneNo.equals(phone)) {
                        exist = true;
                        name = customer.getEntry(i).getName();
                        address = customer.getEntry(i).getAddress().getAddress();
                        state = customer.getEntry(i).getAddress().getState();
                        city = customer.getEntry(i).getAddress().getCity();
                        postcode = customer.getEntry(i).getAddress().getPostcode();
                        gender = customer.getEntry(i).getGender();
                        break;
                    }
                }
                break;
            } else {
                System.out.println("This phone number is not valid. Please re-enter.");
            }
        } while (Validation.ValidateContactNumber(phone) == false);

        if (exist == true) {
            System.out.println("\nCustomer details");
            System.out.println("================");
            System.out.println("Customer name: " + name);
            System.out.println("Gender: " + gender);
            System.out.println("Delivery address: " + address + ", " + postcode + " " + city + ", " + state);
        } else {
            System.out.println("Sorry,no such customer in the record. Thank you");
        }
    }
}
