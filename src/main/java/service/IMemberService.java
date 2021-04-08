package service;

import model.Address;

public interface IMemberService {
    public void registerNewMember(String emailId, String name);
    public void addAddress(String memberId, Address address);
    public void removeOngoingOrder(String memberId, String orderId);
    public void addNewOrder(String memberId, String orderId);
}
