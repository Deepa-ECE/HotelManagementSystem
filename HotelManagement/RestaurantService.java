// RestaurantService.java
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private List<String> orders;

    public RestaurantService() {
        orders = new ArrayList<>();
    }

    public void placeOrder(String orderDetails) {
        orders.add(orderDetails);
        System.out.println("Order placed: " + orderDetails);
    }

    public void viewOrders() {
        System.out.println("Restaurant Orders:");
        if (orders.isEmpty()) {
            System.out.println("No orders placed.");
        } else {
            for (String order : orders) {
                System.out.println("- " + order);
            }
        }
    }
}