package service;

import model.Address;
import model.Order;
import model.user.Member;
import repo.MemberRepo;

public class MemberServiceImpl implements IMemberService{

    private MemberRepo memberRepo;

    private static MemberServiceImpl memberService;

    private MemberServiceImpl(){
        memberRepo = MemberRepo.getMemberRepoSingletonInstance();
    }

    public static MemberServiceImpl getMemberServiceSingletonInstance() {
        if(memberService==null) memberService = new MemberServiceImpl();
        return memberService;
    }

    @Override
    public void registerNewMember(String emailId, String name) {
        memberRepo.addMember(new Member(name, emailId));
    }

    @Override
    public void addAddress(String memberId, Address address) {

    }

    @Override
    public void removeOngoingOrder(String memberId, String orderId) {
        Order orderToBeRemoved = memberRepo.getMember(memberId).getOrders().stream().filter(order -> order.getOrderId().equals(orderId)).findFirst().get();
        memberRepo.removeOngoingOrder(memberId, orderToBeRemoved);
    }

    @Override
    public void addNewOrder(String memberId, String orderId) {
        memberRepo.getMember(memberId).getOrders().stream().filter(order -> order.getOrderId().equals(orderId)).findFirst().get();
    }
}
