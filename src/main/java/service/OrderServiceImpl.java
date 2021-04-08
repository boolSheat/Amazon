package service;

import Exceptions.AmountPaidNotEnoughException;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import enums.OrderStatus;
import model.Order;
import model.Product;
import repo.OrdersRepo;

public class OrderServiceImpl implements IOrderService {

    private static OrderServiceImpl orderService;
    private static OrdersRepo ordersRepo;

    private OrderServiceImpl() {
        ordersRepo = OrdersRepo.getOrdersRepoSingletonInstance();
    }

    public static OrderServiceImpl getOrderServiceSingletonInstance() {
        if(orderService==null) orderService = new OrderServiceImpl();
        return orderService;
    }

    @Override
    public void placeOrder(Order order, double amountPaid) {
        double price = order.getPrice();
        if(amountPaid!=price) {
            throw new AmountPaidNotEnoughException();
        }
        else {
            ordersRepo.addNewOrder(order);
            IMemberService memberService = MemberServiceImpl.getMemberServiceSingletonInstance();
        }
    }

    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order = ordersRepo.updateOrderStatus(orderId, status);
        if(status.equals(OrderStatus.DELIVERED)) {
            IMemberService memberService = MemberServiceImpl.getMemberServiceSingletonInstance();
            memberService.removeOngoingOrder(order.getMemberId(), orderId);
        }
    }

    @Override
    public double getOrderPrice(Order order) {
        double price = 0;
        for(Product product: order.getProducts()) {
            price += product.getPrice();
        }
        System.out.println("Order price is: " + price);
        return price;
    }
}
