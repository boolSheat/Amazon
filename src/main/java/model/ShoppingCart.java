package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    private Map<Product, Integer> products;

    public Set<Product> getProducts() {
        return products.keySet();
    }
    public void addProductToCart(Product product, int items) {
        if(products.containsKey(product)) {
            products.put(product, products.get(product)+items);
        }
    }

    public void editCart(Product product, int items) {
        if(products.get(product) + items ==0) removeProductFromCart(product);
        else products.put(product, products.get(product)+items);
    }

    private void removeProductFromCart(Product product) {
        products.remove(product);
    }
}