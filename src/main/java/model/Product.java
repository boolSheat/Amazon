package model;

public class Product {
    private String productName;
    private String productCategory;
    private double price;

    public Product(String productName, String productCategory, double price) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
