package task2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseProduct extends Database{
    public void insert(List<Product> products) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO product(name, description, current_price) VALUES (?, ?, ?)");

            for (Product product : products) {
                preparedStatement.setString(1, product.getName());
                preparedStatement.setString(2, product.getDescription());
                preparedStatement.setFloat(3, product.getCurrentPrice());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
}
