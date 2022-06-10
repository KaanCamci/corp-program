import java.util.Calendar;

public class Product {

    private String productName;
    private java.util.Calendar saleDate;
    private double price;


    public Product(String productName, Calendar saleDate, double price) {
        this.productName = productName;
        this.saleDate = saleDate;
        this.price = price;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public java.util.Calendar getSaleDate() {
        return this.saleDate;
    }


    public void setSaleDate(java.util.Calendar saleDate) {
        this.saleDate = saleDate;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }





}
