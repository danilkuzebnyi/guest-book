package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {
    static List<Product> allProducts = new ArrayList<>();
    private String name;
    private String description;
    private float currentPrice;

    public Product(String name, String description, float currentPrice) {
        this.name = name;
        this.description = description;
        this.currentPrice = currentPrice;
    }

    public static void addProducts(Product... products) {
        allProducts.addAll(Arrays.asList(products));
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public String toString() {
        return "Product(" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", currentPrice=" + currentPrice +
                ')';
    }
}
