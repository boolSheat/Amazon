package model;

import java.util.*;

public class ShoppingCart {
    private double price;
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
        price=0;
    }

    public List<Product> getProducts() {
        return products;
    }
    public void addProductToCart(Product product) {
        products.add(product);
        price += product.getPrice();
    }

    public double getPrice() {
        return price;
    }

    public void removeProductFromCart(Product product) {
        products.remove(product);
    }

    public void clear(){products.clear();}
}
