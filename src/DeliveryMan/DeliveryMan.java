package DeliveryMan;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class DeliveryMan implements Serializable {
    private static int nextId = 1000;
    private int id;
    private String name;
    private String gender;
    private String contactNumber;
    private String email;
    private String homeAddress;
    private String status;
    
    public DeliveryMan(String name, String gender, String contactNumber, String email, String homeAddress){
        this.id = nextId++;
        this.name = name;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.homeAddress = homeAddress;
        this.status = "Active";
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getGender(){
        return gender;
    }
    
    public String getContactNumber(){
        return contactNumber;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getHomeAddress(){
        return homeAddress;
    }
    
    public String getStatus(){
        return status;
    }
    
    public static int getNextId(){
        return nextId;
    }
    
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setHomeAddress(String homeAddress){
        this.homeAddress = homeAddress;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public static void setNextId(int nextId){
        DeliveryMan.nextId = nextId;
    }
    
    public String toString(){
        return String.format("%-4s  %-20s   %-6s    %-12s   %-20s   %-10s\n", id, name, gender, contactNumber, email, status);
    }
    
    public static void main(String args[]){
        DeliveryMan[] test = new DeliveryMan[10];
        test[0] = new DeliveryMan("Tan Cheong Kiat", "Male", "012-3456789", "testing@gmail.com", "Jalan Suasana 3/4");
        test[1] = new DeliveryMan("Tan Qi Han", "Male", "012-3456789", "testing@gmail.com", "KL");
        test[2] = new DeliveryMan("Wong Li Yi", "Female", "012-3456789", "testing@gmail.com", "Melaka");
        String output = String.format("%-4s  %-20s   %-6s    %-12s   %-20s   %-10s\n", "ID", "NAME", "GENDER", "CONTACT NO.", "EMAIL", "STATUS");
        for (int i = 0; i < test.length; i++) {
            if (test[i] != null) {
                output += test[i].toString();
            }
            else{
                break;
            }
        }
        System.out.print(output);
    }
}
