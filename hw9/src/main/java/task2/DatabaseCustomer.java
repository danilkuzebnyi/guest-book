package task2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class DatabaseCustomer extends Database {

    public void insert(List<Customer> customers) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO customer(first_name, last_name, cell_phone) VALUES (?, ?, ?)")) {

            for (Customer customer : customers) {
                setValues(preparedStatement, customer);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void update(Customer updatedCustomer, int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE customer SET first_name = ?, last_name = ?, cell_phone = ? WHERE id = ?")) {
            setValues(preparedStatement, updatedCustomer);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void setValues(PreparedStatement preparedStatement, Customer customer) throws SQLException {
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getCellPhone());
    }

    public Customer getCustomerById(int id) {
        Customer customer = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customer = new Customer(resultSet.getString("first_name"),
                                    resultSet.getString("last_name"),
                                    resultSet.getString("cell_phone"));
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return customer;
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM customer WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public HashMap<Customer, Float> selectCustomersAndTheirTotalAmountOfSpentMoney() {
        Customer customer;
        ResultSet resultSet;
        float totalAmountOfSpentMoney;
        HashMap<Customer, Float> customersToTheirTotalAmountOfSpentMoney = new HashMap<>();

        String query = "SELECT DISTINCT c.id, first_name, last_name, cell_phone,\n" +
                "                SUM(qty_of_products * current_price) OVER (PARTITION BY customer_id) AS total_price\n" +
                "FROM customer c\n" +
                "         JOIN booking b on c.id = b.customer_id\n" +
                "         JOIN product p on b.product_id = p.id\n" +
                "GROUP BY c.id, qty_of_products, current_price, customer_id\n";

        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                customer = new Customer(resultSet.getString("first_name"),
                                        resultSet.getString("last_name"),
                                        resultSet.getString("cell_phone"));
                totalAmountOfSpentMoney = resultSet.getFloat("total_price");
                customersToTheirTotalAmountOfSpentMoney.put(customer, totalAmountOfSpentMoney);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return customersToTheirTotalAmountOfSpentMoney;
    }
}
