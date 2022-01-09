package task2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseBooking extends Database {

    public void insert(List<Booking> bookings) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO booking(customer_id, product_id, qty_of_products, delivery_place) VALUES (?, ?, ?, ?)")) {

            for (Booking booking : bookings) {
                setValues(preparedStatement, booking);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void update(Booking updatedBooking, int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE booking SET customer_id = ?, product_id = ?, qty_of_products = ?, delivery_place = ? WHERE id = ?")) {
            setValues(preparedStatement, updatedBooking);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void setValues(PreparedStatement preparedStatement, Booking booking) throws SQLException {
        preparedStatement.setInt(1, booking.getCustomerId());
        preparedStatement.setInt(2, booking.getProductId());
        preparedStatement.setInt(3, booking.getQtyOfProducts());
        preparedStatement.setString(4, booking.getDeliveryPlace());
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM booking WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
}
