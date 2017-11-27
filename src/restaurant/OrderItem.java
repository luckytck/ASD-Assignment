package restaurant;

import java.io.Serializable;

public class OrderItem implements Serializable{
    
    private static int nextOrderID = 1000;
    private int orderID;
    private String name;
    private int qty;
    private double price;
    private double totalPrice;

    public OrderItem(String name, int qty, double price, double totalPrice) {
        this.orderID = nextOrderID++;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public OrderItem(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "name=" + name + ", qty=" + qty + ", price=" + price + '}';
    }    
    
}
