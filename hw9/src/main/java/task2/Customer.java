package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
    static List<Customer> allCustomers = new ArrayList<>();
    private int id;
    private String firstName;
    private String lastName;
    private String cellPhone;

    public Customer(String firstName, String lastName, String cellPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
    }

    public static void addCustomers(Customer... customers) {
        allCustomers.addAll(Arrays.asList(customers));
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }
}
