
package restaurant;

public class MenuItem {
    private String name;
    private double price;
    private double discountRate;
    private boolean status=true;
    
    public MenuItem()
    {
    }
    public MenuItem(String name,double price){
        this.name=name;
        this.price=price;
        this.discountRate=0;
        
    }
    
    void setName(String name){
        this.name=name;
    }
    void setPrice(double price){
        this.price=price;
    }
    void setDiscountRate(double discountRate){
        this.discountRate=discountRate;
    }
    void setStatus(boolean status){
     this.status=status;
    }
    String getName(){
        return name;
    }
    double getPrice(){
        return price;
    }
    double getDiscountRate(){
        return discountRate;
    }
    boolean getStatus(){
     return status;   
    }
    @Override
    public String toString(){
     return String.format("%s %.2f %.2f %s",name,price,discountRate,status);
    }
    
    
}
