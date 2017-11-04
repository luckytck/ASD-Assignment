package DeliveryMan;

public class DeliveryMan {
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
        return String.format("Name           : %s\n"
                           + "Gender         : %s\n" 
                           + "Contact Number : %s\n" 
                           + "Home Address   : %s\n" 
                           + "Email          : %s\n" 
                           + "Status         : %s\n", name, gender, contactNumber, homeAddress, email, status);
    }
}
