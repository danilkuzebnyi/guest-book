package task2;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Customer.addCustomers(new Customer("Maxim", "Schevchuk", "0951111111"),
                              new Customer("Oleg", "Makov", "0682222222"),
                              new Customer("Alex", "Adamov", "0673333333"),
                              new Customer("Alexey", "Polishuk", "0985555555"),
                              new Customer("Peter", "Stevenson", "0504444444"));
        //Customer.addCustomers(new Customer("Olivia", "Nate", "0506666666"));

        Product.addProducts(new Product("notebook", "lenovo ideapad", 24000),
                            new Product("telephone", "iphone 11", 21000),
                            new Product("book", "history of Ukraine", 300),
                            new Product("jacket", "winter jacket", 5000));
        //Product.addProducts(new Product("flower", "rose", 400));

        Booking.addBookings(new Booking(1, 2, 1, "Cherkasy"),
                            new Booking(1, 4, 2, "Cherkasy"),
                            new Booking(2, 3, 3, "Kaniv"),
                            new Booking(2, 2, 1, "Kaniv"),
                            new Booking(3, 1, 1, "Kiev"),
                            new Booking(4, 2, 1, "Chernihiv"),
                            new Booking(5, 3, 2, "Lutsk"));
        //Booking.addBookings(new Booking(5, 4, 3, "Lutsk"));

        Database.getConnection();

        DatabaseCustomer dbCustomer = new DatabaseCustomer();
        //dbCustomer.insert(Customer.allCustomers);
        //System.out.println(dbCustomer.getCustomerById(3));
        //dbCustomer.update(new Customer("Serhiy", "Voronov", "0984444444"), 4);
        //dbCustomer.update(new Customer("John", "Johnson", "0675555555"), 5);
        //dbCustomer.delete(10);
        //System.out.println(dbCustomer.selectCustomersAndTheirTotalAmountOfSpentMoney());

        DatabaseProduct dbProduct = new DatabaseProduct();
        //dbProduct.insert(Product.allProducts);
        //dbProduct.update(new Product("flower", "tulpan", 500), 6);
        //dbProduct.delete(6);
        //System.out.println(dbProduct.getTheMostPopularProduct());

        DatabaseBooking dbBooking = new DatabaseBooking();
        //dbBooking.insert(Booking.allBookings);
        //dbBooking.update(new Booking(5, 4, 1, "Lviv"),9);
        //dbBooking.delete(9);
    }
}
