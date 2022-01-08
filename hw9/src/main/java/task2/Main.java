package task2;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Customer.addCustomers(new Customer("Maxim", "Schevchuk", "0951111111"),
                              new Customer("Oleg", "Makov", "0682222222"),
                              new Customer("Alex", "Adamov", "0673333333"),
                              new Customer("Alexey", "Polishuk", "0985555555"),
                              new Customer("Peter", "Stevenson", "0504444444"));

        Product.addProducts(new Product("notebook", "lenovo ideapad", 24000),
                            new Product("telephone", "iphone 11", 21000),
                            new Product("book", "history of Ukraine", 300),
                            new Product("jacket", "winter jacket", 5000));

        Booking.addBookings(new Booking(1, 2, 1, "Cherkasy"),
                            new Booking(1, 4, 2, "Cherkasy"),
                            new Booking(2, 3, 3, "Kaniv"),
                            new Booking(2, 2, 1, "Kaniv"),
                            new Booking(3, 1, 1, "Kiev"),
                            new Booking(4, 2, 1, "Chernihiv"),
                            new Booking(5, 3, 2, "Lutsk"));

        Database.getConnection();
        DatabaseCustomer dbCustomer = new DatabaseCustomer();
        dbCustomer.insert(Customer.allCustomers);
        DatabaseProduct dbProduct = new DatabaseProduct();
        dbProduct.insert(Product.allProducts);
        DatabaseBooking dbBooking = new DatabaseBooking();
        dbBooking.insert(Booking.allBookings);
    }
}
