package DeliveryMan;

import java.io.Serializable;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class DeliveryMan implements Serializable {

    private static int nextId = 1000;
    private int id;
    private String name;
    private String gender;
    private String contactNumber;
    private String email;
    private String homeAddress;
    private String identityCardNo;
    private String status;   

    public DeliveryMan(String name, String gender, String contactNumber, String email, String homeAddress, String identityCardNo) {
        this.id = nextId++;
        this.name = name;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.homeAddress = homeAddress;
        this.status = "Active";
        this.identityCardNo = identityCardNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }
    
    public String getIdentityCardNo(){
        return identityCardNo;
    }

    public String getStatus() {
        return status;
    }

    public static int getNextId() {
        return nextId;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    public void setIdentityCardNo(String identityCardNo){
        this.identityCardNo = identityCardNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void setNextId(int nextId) {
        DeliveryMan.nextId = nextId;
    }

    public String toString() {
        return String.format("%-4s  %-20s   %-6s    %-12s   %-20s   %-14s   %-10s\n", id, name, gender, contactNumber, email, identityCardNo, status);
    }

    public static void main(String args[]) {
        //Testing
        DeliveryMan[] test = new DeliveryMan[10];
        test[0] = new DeliveryMan("Tan Cheong Kiat", "Male", "012-3456789", "testing@gmail.com", "Jalan Suasana 3/4", "970219-14-6459");
        test[1] = new DeliveryMan("Tan Qi Han", "Male", "012-3456789", "testing@gmail.com", "KL", "970116-12-5897");
        test[2] = new DeliveryMan("Wong Li Yi", "Female", "012-3456789", "testing@gmail.com", "Melaka", "970521-22-5526");
        String output = String.format("%-4s  %-20s   %-6s    %-12s   %-20s   %-14s  %-10s\n", "ID", "NAME", "GENDER", "CONTACT NO.", "EMAIL", "IC NO.", "STATUS");
        for (int i = 0; i < test.length; i++) {
            if (test[i] != null) {
                output += test[i].toString();
            }
            else{
                break;
            }
        }
        System.out.print(output);
        
        String name, contactNo, homeAddress, email, identityCardNo;
        char gender;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Delivery Man Registration");
            System.out.println("=========================");
            System.out.println("Please enter the delivery man details:");
            System.out.print("Name           : ");
            name = scanner.nextLine();
            System.out.print("Gender (M/F)   : ");
            gender = Character.toUpperCase(scanner.next().charAt(0));
            scanner.nextLine();
            System.out.print("Contact Number : ");
            contactNo = scanner.nextLine();
            System.out.print("Home Address   : ");
            homeAddress = scanner.nextLine();
            System.out.print("Email          : ");
            email = scanner.nextLine();
        } while (gender != 'M' && gender != 'F');
        System.out.println("Registered Successful.");
        System.out.println("Name           : " + name);
        System.out.println("Gender         : " + gender);
        System.out.println("Contact Number : " + contactNo);
        System.out.println("Home Address   : " + homeAddress);
        System.out.println("Email          : " + email);

    }
}
