
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Affiliate extends User implements Serializable{
    private String restaurantName;
    private String businessRegNo; //Format - ######-# e.g 123456-M
    private String GSTRegNo; //Format - 12-digit number e.g 000130928640
    private String restaurantContactNo; //Format - 03-########
    private Address address;
    private List<MenuItem> food;
    private List<MenuItem> beverage;

    public Affiliate() {
    }

    public Affiliate(String restaurantName, String businessRegNo, String GSTRegNo, String restaurantContactNo, Address address, String username, String password, String name, char gender, String contactNo) {
        super(username, password, name, gender, contactNo);
        this.restaurantName = restaurantName;
        this.businessRegNo = businessRegNo;
        this.GSTRegNo = GSTRegNo;
        this.restaurantContactNo = restaurantContactNo;
        this.address = address;
        this.food = null;
        this.beverage = null;
    }
    

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getBusinessRegNo() {
        return businessRegNo;
    }

    public void setBusinessRegNo(String businessRegNo) {
        this.businessRegNo = businessRegNo;
    }

    public String getGSTRegNo() {
        return GSTRegNo;
    }

    public void setGSTRegNo(String GSTRegNo) {
        this.GSTRegNo = GSTRegNo;
    }

    public String getRestaurantContactNo() {
        return restaurantContactNo;
    }

    public void setRestaurantContactNo(String restaurantContactNo) {
        this.restaurantContactNo = restaurantContactNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<MenuItem> getFood() {
        return food;
    }

    public void setFood(List<MenuItem> food) {
        this.food = food;
    }

    public List<MenuItem> getBeverage() {
        return beverage;
    }

    public void setBeverage(List<MenuItem> beverage) {
        this.beverage = beverage;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-30s %-12s %-12s %-15s %-80s", restaurantName, businessRegNo, GSTRegNo, restaurantContactNo, address);
    }
    
    //You can put validation method in here. e.g below
    //Call it using classname.methodname e.g Affiliate.validateBusinessRegNo("830776-U")
    public static boolean validateBusinessRegNo(String businessRegNo){
        //You can use regularExpression here
        //Pattern...Matches...
        return true;
    }
    
    public static void main(String[] args) { //Run it to understand
        Address address1 = new Address("AEON (Jusco) Cheras Selatan Shopping Centre", "Selangor", "Balakong", 43200);
        Address address2 = new Address("90, Jalan Peel, Maluri,", "Kuala Lumpur", "Wilayah Persekutuan", 55100);
        //2 way to declare Affiliate object
        User affiliate1 = new Affiliate("Tealive", "962113-K", "000808083456", "03-62113891", address1, "chatime", "1234", "Bryan Loo", 'M', "012-3456789");
        Affiliate affiliate2 = new Affiliate("OldTown White Coffee", "830776-U", "000801587200", "03-12566852", address2, "oldtown", "1234", "Goh Ching Mun", 'M', "011-45621445");
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-30s %-12s %-12s %-15s %-80s", "ID", "USERNAME", "OWNER_NAME", "GENDER", "CONTACT_NO", "RESTAURANT_NAME", "BUSS_REG_No", "GST_REG_NO", "REST_CONTACT_NO", "ADDRESS"));
        System.out.println(affiliate1);
        System.out.println(affiliate2);
        //Note - If you want use getter & setter in child class, u need cast it to the child class first e.g below
        System.out.println(((Affiliate)affiliate1).getBusinessRegNo());
        //Note - If you declare the class using child class name, you no need cast it to the child class e.g below
        System.out.println(affiliate2.getBusinessRegNo());
        //Example to use static method using class name
        if (Affiliate.validateBusinessRegNo("830776-U")) {
            System.out.println("830776-U = " + "True");
        } else {
            System.out.println("830776-U = " + "False");
        }
        //Example to store food to the affiliate class
        List<MenuItem> food1 = new ArrayList<>();
        MenuItem item1 = new MenuItem("Mee Goreng", "", 4.00, 0);
        MenuItem item2 = new MenuItem("Nasi Goreng", "", 5.00, 10);
        MenuItem item3 = new MenuItem("Lobster burger", "Special Promotion", 50.00, 10);
        food1.add(item1);
        food1.add(item2);
        food1.add(item3);
        affiliate2.setFood(food1);
        //Example to retrive food from the affiliate class
        List<MenuItem> food2 = affiliate2.getFood();
        System.out.println(String.format("%-30s %-30s %10s %12s %-15s", "NAME", "DESCRIPTION", "PRICE(RM)", "DISCOUNT(%)", "STATUS"));
        for (int i = 0; i < food2.size(); i++) {
            System.out.println(food2.get(i).toString());
        }
        
    }
}
