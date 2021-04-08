import enums.OrderStatus;
import model.Order;
import model.Product;
import model.user.Member;
import service.*;

public class Runner {
    public static void main(String[] args) {
        IMemberService memberService = MemberServiceImpl.getMemberServiceSingletonInstance();
        IOrderService orderService = OrderServiceImpl.getOrderServiceSingletonInstance();
        IProductService productService = ProductServiceImpl.getProductServiceImplSingletonInstance();
        memberService.registerNewMember("slingShot", "SuperStar Arjun");
        Product hairfallShampoo = new Product("Ganje ke liye shampoo", "ProductsForBaldPeople", 3600);
        productService.addNewProduct(hairfallShampoo);
        memberService.addProductToShoppingCart("slingShot", "Ganje ke liye shampoo");
        memberService.addProductToShoppingCart("slingShot", "Ganje ke liye shampoo");
        Order order1 = memberService.createOrder("slingShot", "order1");
        order1.addProduct(hairfallShampoo);
        orderService.placeOrder(order1, orderService.getOrderPrice(order1));
        orderService.updateOrderStatus("order1", OrderStatus.DELIVERED);
        Order order2 = memberService.createOrderViaShoppingCart("slingShot", "order2");
        orderService.placeOrder(order2, orderService.getOrderPrice(order2));
    }

}