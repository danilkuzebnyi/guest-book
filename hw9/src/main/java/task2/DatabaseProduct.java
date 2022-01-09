package task2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseProduct extends Database{

    public void insert(List<Product> products) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO product(name, description, current_price) VALUES (?, ?, ?)")) {

            for (Product product : products) {
                setValues(preparedStatement, product);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void update(Product updatedProduct, int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE product SET name = ?, description = ?, current_price = ? WHERE id = ?")) {
            setValues(preparedStatement, updatedProduct);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void setValues(PreparedStatement preparedStatement, Product product) throws SQLException {
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getDescription());
        preparedStatement.setFloat(3, product.getCurrentPrice());
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM product WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public Product getTheMostPopularProduct() {
        Product theMostPopularProduct = null;
        ResultSet resultSet;

        String query = "SELECT DISTINCT product_id, name, description, current_price, SUM(qty_of_products) OVER (PARTITION BY product_id) AS qty_of_bookings\n" +
                "FROM booking\n" +
                "JOIN product p on booking.product_id = p.id\n" +
                "ORDER BY qty_of_bookings desc\n" +
                "LIMIT 1;";

        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            resultSet.next();
            theMostPopularProduct = new Product(resultSet.getString("name"),
                                                resultSet.getString("description"),
                                                resultSet.getFloat("current_price"));
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return theMostPopularProduct;
    }
}
