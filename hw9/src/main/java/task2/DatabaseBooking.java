package task2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseBooking extends Database {
    public void insert(List<Booking> bookings) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO booking(customer_id, product_id, qty_of_products, delivery_place) VALUES (?, ?, ?, ?)")) {

            for (Booking booking : bookings) {
                preparedStatement.setInt(1, booking.getCustomerId());
                preparedStatement.setInt(2, booking.getProductId());
                preparedStatement.setInt(3, booking.getQtyOfProducts());
                preparedStatement.setString(4, booking.getDeliveryPlace());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
}
