package model;

import enums.OrderStatus;
import model.user.Member;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {
    private String orderId;
    private List<Product> products;
    private Instant orderedAt;
    private double price;
    private OrderStatus status;
    private String memberId;
    private Address address;

    public Order(String memberId, String orderId) {
        this.products = new ArrayList<>();
        this.memberId = memberId;
        this.orderId = orderId;
        this.status = OrderStatus.CREATED;
    }

    public Order(String memberId, String orderId, ShoppingCart shoppingCart) {
        this.memberId = memberId;
        this.orderId = orderId;
        this.status = OrderStatus.CREATED;
        this.products = new ArrayList<>();
        addProducts(shoppingCart.getProducts());
        this.price =shoppingCart.getPrice();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public void addProduct(Product product) {
        this.products.add(product);
        price += product.getPrice();
    }

    public Instant getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Instant orderedAt) {
        this.orderedAt = orderedAt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }
}
