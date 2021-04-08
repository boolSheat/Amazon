package service;

import model.Address;
import model.Order;
import model.ShoppingCart;
import model.user.Member;

public interface IMemberService {
    public void registerNewMember(String emailId, String name);
    public void addAddress(String memberId, Address address);
    public void removeOngoingOrder(String memberId, String orderId);
    public Member getMemberById(String memberId);
    public void addProductToShoppingCart(String memberId, String productName);
    public Order createOrderViaShoppingCart(String memberId, String orderId);
    public Order createOrder(String memberId, String orderId);
}
