package service;

import model.Address;
import model.Order;
import model.Product;
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
        System.out.println("Order: " + orderId+" removed from in process orders for member: " + memberId);
    }

    @Override
    public Member getMemberById(String memberId) {
        return memberRepo.getMember(memberId);
    }

    @Override
    public void addProductToShoppingCart(String memberId, String productName) {
        IProductService productService = ProductServiceImpl.getProductServiceImplSingletonInstance();
        Product product = productService.getProductByName(productName);
        getMemberById(memberId).getShoppingCart().addProductToCart(product);
        System.out.println("Product: " + productName + " added to cart");
    }

    @Override
    public Order createOrderViaShoppingCart(String memberId, String orderId) {
        Member member = memberRepo.getMember(memberId);
        Order order = new Order(memberId, orderId, member.getShoppingCart());
        member.getOrders().add(order);
        member.getShoppingCart().clear();
        return order;
    }

    @Override
    public Order createOrder(String memberId, String orderId) {
        Order order = new Order(memberId, orderId);
        memberRepo.getMember(memberId).getOrders().add(order);
        return order;
    }
}
