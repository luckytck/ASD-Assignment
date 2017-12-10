package restaurant;

import ADTs.ListInterface;
import Classes.Customer;
import Classes.File;
import Classes.Validation;
import java.util.Scanner;

public class RetrieveCustomer {

    public static final String fileName = "customer.dat";
    private static String name, address, state, city;
    private static int postcode;
    private static char gender;

    public static void main(String[] args) {

        String phone;

        do {
            Scanner phoneNo = new Scanner(System.in);
            System.out.print("Please enter customer phone no.(01x-xxxxxxxx):");
            phone = phoneNo.next();

            if (Validation.ValidateContactNumber(phone) == true) {
                if (existPhoneNo(phone) == true) {
                    System.out.println("\nCustomer details");
                    System.out.println("================");
                    System.out.println("Customer name: " + name);
                    System.out.println("Gender: " + gender);
                    System.out.println("Delivery address: " + address + ", " + postcode + " " + city + ", " + state);
                } else {
                    System.out.println("Sorry, no such customer. Thank you");
                }
            } else {
                System.out.println("This number is not valid. Please try again.");
            }
        } while (Validation.ValidateContactNumber(phone) == false);
    }

    private static boolean existPhoneNo(String phoneNo) {
        boolean exist = false;

        ListInterface<Customer> customer = File.retrieveList(fileName);
        String phoneNumber;

        for (int i = 1; i <= customer.getNumberOfEntries(); i++) {
            phoneNumber = customer.getEntry(i).getContactNo();

            if (phoneNumber.equals(phoneNo)) {
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
        return exist;
    }

}
