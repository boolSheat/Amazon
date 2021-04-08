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
        memberService.addProductToShoppingCart("slingShot", "Ganje ke liye shampoo", 2);
        Order order = memberService.createOrder("slingShot", "order1");
        order.addProduct(hairfallShampoo);
        orderService.placeOrder(order, orderService.getOrderPrice(order));
        orderService.updateOrderStatus("order1", OrderStatus.DELIVERED);
    }

}