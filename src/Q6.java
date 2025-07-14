import java.util.*;
import java.util.stream.Collectors;


class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() { return Objects.hash(productId); }

    @Override
    public String toString() {
        return STR."Product{productId='\{productId}', name='\{name}', price=\{price}}";
    }
}

class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return STR."Order{orderId='\{orderId}', products=\{products}}";
    }
}

public class Q6 {
    public static Set<Product> getAllUniqueProducts(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Product laptop = new Product("P001", "Laptop", 1200.00);
        Product mouse = new Product("P002", "Wireless Mouse", 25.00);
        Product keyboard = new Product("P003", "Mechanical Keyboard", 75.00);
        Product monitor = new Product("P004", "4K Monitor", 350.00);
        Product webcam = new Product("P005", "HD Webcam", 50.00);
        Product headset = new Product("P006", "Gaming Headset", 100.00);

        // Sample Orders
        Order order1 = new Order("ORD001", Arrays.asList(laptop, mouse, keyboard));
        Order order2 = new Order("ORD002", Arrays.asList(monitor, mouse, webcam));
        Order order3 = new Order("ORD003", Arrays.asList(laptop, headset));
        Order order4 = new Order("ORD004", Arrays.asList(keyboard, webcam));

        List<Order> customerOrders = Arrays.asList(order1, order2, order3, order4);

        System.out.println("Customer Orders:");
        customerOrders.forEach(System.out::println);

        Set<Product> uniqueProducts = getAllUniqueProducts(customerOrders);

        System.out.println("\nAll Unique Products Ordered:");
        uniqueProducts.forEach(System.out::println);

        System.out.println("\nTotal unique products found: " + uniqueProducts.size());
    }
}