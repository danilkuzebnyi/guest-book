package task1;

import java.util.HashMap;
import java.util.Map;

public class Product {
    static String name;
    static double price;
    static int qty;
    static Map<String, Double> inventoryValue = new HashMap<>();

    public Product(String name, double price, int qty) {
        Product.name = name;
        Product.price = price;
        Product.qty = qty;
        addProducts();
    }

    public void addProducts() {
        inventoryValue.put(name, price * qty);
    }

}
