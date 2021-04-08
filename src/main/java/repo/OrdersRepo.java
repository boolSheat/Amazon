package repo;

import enums.OrderStatus;
import model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersRepo {
    private final List<Order> orders = new ArrayList<>();
    private final Map<String, List<Order>> memberVsOrdersMap = new HashMap<>();
    private final Map<String, Order> orderIdVsOrderMap = new HashMap<>();
    private static OrdersRepo ordersRepo;
    private OrdersRepo(){
    }

    public static OrdersRepo getOrdersRepoSingletonInstance() {
        if(ordersRepo==null) ordersRepo = new OrdersRepo();
        return ordersRepo;
    }

    public List<Order> getPastOrders(String member) {
        return memberVsOrdersMap.get(member);
    }

    private void addPastOrder(Order order) {
        orders.add(order);
        if(!memberVsOrdersMap.containsKey(order.getMemberId())){
            memberVsOrdersMap.put(order.getMemberId(), new ArrayList<>());
        }
        memberVsOrdersMap.get(order.getMemberId()).add(order);
    }

    public void addNewOrder(Order order) {
        orderIdVsOrderMap.put(order.getOrderId(), order);
    }

    public Order updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orderIdVsOrderMap.get(orderId);
        order.setStatus(status);
        if(status.equals(OrderStatus.DELIVERED)) {
            orderIdVsOrderMap.remove(orderId);
            addPastOrder(order);
        }
        return order;
    }

}
