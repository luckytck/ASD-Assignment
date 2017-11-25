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
    private double basicSalary;
    private String status;   
    private String workingStatus;

    public DeliveryMan(String name, String gender, String contactNumber, String email, String homeAddress, String identityCardNo, double basicSalary,String workingStatus) {
        this.id = nextId++;
        this.name = name;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.homeAddress = homeAddress;
        this.status = "Employed";
        this.identityCardNo = identityCardNo;
        this.basicSalary = basicSalary;
        this.workingStatus = workingStatus;
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
    
    public double getBasicSalary(){
        return basicSalary;
    }

    public String getStatus() {
        return status;
    }

    public static int getNextId() {
        return nextId;
    }
    
    public String getWorkingStatus(){
        return workingStatus;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setGender(String gender){
        this.gender = gender;
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
    
    public void setBasicSalary(double basicSalary){
        this.basicSalary = basicSalary;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void setNextId(int nextId) {
        DeliveryMan.nextId = nextId;
    }
    
    public void setWorkingStatus(String workingStatus){
        this.workingStatus = workingStatus;
    }

    public String toString() {
        return String.format("%-4s  %-20s   %-6s    %-12s   %-20s   %-14s   %-12.2f   %-10s\n", id, name, gender, contactNumber, email, identityCardNo, basicSalary, status);
    }

    public static void main(String args[]) {
        //Testing
        DeliveryMan[] test = new DeliveryMan[10];
        test[0] = new DeliveryMan("Tan Cheong Kiat", "Male", "012-3456789", "testing@gmail.com", "Jalan Suasana 3/4", "970219-14-6459", 1800.00,"Offline");
        test[1] = new DeliveryMan("Tan Qi Han", "Male", "012-3456789", "testing@gmail.com", "KL", "970116-12-5897", 1800.00,"Offline");
        test[2] = new DeliveryMan("Wong Li Yi", "Female", "012-3456789", "testing@gmail.com", "Melaka", "970521-22-5526", 1800.00,"Offline");
        String output = String.format("%-4s  %-20s   %-6s    %-12s   %-20s   %-14s   %-12s   %-10s\n", "ID", "NAME", "GENDER", "CONTACT_NO.", "EMAIL", "IC_NO.", "BASIC_SALARY", "STATUS");
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
