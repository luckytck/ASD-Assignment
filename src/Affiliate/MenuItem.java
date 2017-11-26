
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
    
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setDiscountRate(double discountRate){
        this.discountRate=discountRate/100;
    }
    public void setStatus(boolean status){
     this.status=status;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public double getDiscountRate(){
        return discountRate;
    }
    public boolean getStatus(){
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
