package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Booking {
    static List<Booking> allBookings = new ArrayList<>();
    private int customerId;
    private int productId;
    private int qtyOfProducts;
    private String deliveryPlace;

    public Booking(int customerId, int productId, int qtyOfProducts, String deliveryPlace) {
        this.customerId = customerId;
        this.productId = productId;
        this.qtyOfProducts = qtyOfProducts;
        this.deliveryPlace = deliveryPlace;
    }

    public static void addBookings(Booking... bookings) {
        allBookings.addAll(Arrays.asList(bookings));
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQtyOfProducts() {
        return qtyOfProducts;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }
}
