package Affiliate;
import java.io.Serializable;
public class Affiliate implements Serializable{

    private String Restaurant_Name;
    private static int number = 1001;
    private int AffiliateNo;
    private String Owner_Name;
    private String Restaurant_ContactNo;
    private String Location;
    private String Owner_ContactNo;

    public Affiliate(String Restaurant_Name, String Owner_Name, String Restaurant_ContactNo, String Location, String Owner_ContactNo) {
        this.Restaurant_Name = Restaurant_Name;
        this.AffiliateNo=number++;
        this.Owner_Name = Owner_Name;
        this.Owner_ContactNo = Owner_ContactNo;
        this.Restaurant_ContactNo = Restaurant_ContactNo;
        this.Location = Location;

    }
     public Affiliate(String Restaurant_Name) {
    this.Restaurant_Name = Restaurant_Name;
    this.AffiliateNo = number++;
  }
    public static int getnextnumber(){
        return number;
    }
    public static void setnextnumber(int number){
        Affiliate.number=number;
    }

    public void setRestaurant_Name(String Restaurant_Name) {
        this.Restaurant_Name = Restaurant_Name;
    }

    public void setOwner_ContactNo(String Owner_ContactNo) {
        this.Owner_ContactNo = Owner_ContactNo;
    }

    public void setAffiliateNo(int number) {
        this.AffiliateNo =number;
    }

    public void setOwner_Name(String Owner_Name) {
        this.Owner_Name = Owner_Name;
    }

    public void setRestaurant_ContactNo(String Restaurant_ContactNo) {
        this.Restaurant_ContactNo = Restaurant_ContactNo;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getRestaurant_Name() {
        return Restaurant_Name;
    }

    public int getAffiliateNo() {
        return AffiliateNo;
    }

    public String getOwner_Name() {
        return Owner_Name;
    }

    public String getRestaurant_ContactNo() {
        return Restaurant_ContactNo;
    }

    public String getOwner_ContactNo() {
        return Owner_ContactNo;
    }

    public String getLocation() {
        return Location;
    }
    public String tostring(){
    return String.format("%d %s %s %s %s %s",AffiliateNo,Restaurant_Name,Owner_Name,Owner_ContactNo,Restaurant_ContactNo,Location);
    }
}
