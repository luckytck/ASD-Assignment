
package Affiliate;

import java.io.Serializable;

public class MenuItem implements Serializable{
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
        this.discountRate=discountRate/100;
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
        String message;
        if(status==true)
        {
            message="Available";
        }else
        {
            message="not Available";
        }
           
        
        
     return String.format("%15s %10.2f %10.0f%% %20s",name,price,discountRate*100,message);
    }
    
    
}
