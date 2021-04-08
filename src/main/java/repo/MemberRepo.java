package repo;

import model.Order;
import model.user.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepo {
    private List<Member> members;
    private static MemberRepo memberRepo;
    private MemberRepo(){
        members = new ArrayList<>();
    }

    public static MemberRepo getMemberRepoSingletonInstance() {
        if(memberRepo==null) memberRepo=new MemberRepo();
        return memberRepo;
    }

    public List<Member> getMembers() {
        return members;
    }

    public Member getMember(String memberId) {
        System.out.println("Getting member with id: " + memberId);
        return members.stream().filter(member -> member.getMailId().equals(memberId)).findFirst().get();
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member:" + member.getUserName()+ " with id:" + member.getMailId()+ " created");
    }

    public void removeMember(String memberId) {
        Member memberToBeRemoved = members.stream().filter(member -> member.getMailId().equals(memberId)).findFirst().get();
        System.out.println("Member:" + memberToBeRemoved.getUserName()+ " with id:" + memberId+ " removed");
        members.remove(memberToBeRemoved);
    }

    public void removeOngoingOrder(String memberId, Order order) {
        Member memberForOrder = members.stream().filter(member -> member.getMailId().equals(memberId)).findFirst().get();
        memberForOrder.getOrders().remove(order);
        System.out.println("Order:" + order.getOrderId()+ " for memberId:" + memberId+ " delivered");
    }
}
