package task2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseCustomer extends Database {

    public void insert(List<Customer> customers) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO customer(first_name, last_name, cell_phone) VALUES (?, ?, ?)")) {

            for (Customer customer : customers) {
                preparedStatement.setString(1, customer.getFirstName());
                preparedStatement.setString(2, customer.getLastName());
                preparedStatement.setString(3, customer.getCellPhone());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void update(Customer customer, int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE customer SET first_name = ?, last_name = ?, cell_phone = ? WHERE id = ?")) {

            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getCellPhone());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM customer WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

}
