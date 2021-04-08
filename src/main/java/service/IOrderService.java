package service;

import enums.OrderStatus;
import model.Order;

public interface IOrderService {
    public void placeOrder(Order order, double price);
    public void updateOrderStatus(String orderId, OrderStatus status);
    public double getOrderPrice(Order order);
}
