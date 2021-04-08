package model.user;

import model.Order;
import model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person{
    private ShoppingCart shoppingCart;
    private List<Order> orders;

    public Member(String userName, String mailId) {
        super(userName, mailId);
        this.shoppingCart = new ShoppingCart();
        this.orders = new ArrayList<>();
    }

    public Member(Guest guest, String userName, String mailId) {
        super(userName,mailId);
        this.shoppingCart = guest.getShoppingCart();
        this.orders = new ArrayList<>();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
