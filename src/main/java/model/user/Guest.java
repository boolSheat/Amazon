package model.user;

import model.Product;
import model.ShoppingCart;
import model.user.Person;

public class Guest {

    private ShoppingCart shoppingCart;

    public Guest(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void addProductToShoppingCart(Product product, int items) {
        shoppingCart.addProductToCart(product, items);
    }
}
