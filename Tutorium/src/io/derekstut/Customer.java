package io.derekstut;

/**
 * Created on 01.05.17.
 */
class Customer {
    public String firstName, lastName;
    public int customerAge;

    public Customer(String firstName, String lastName, int customerAge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAge = customerAge;
    }

    public static Customer[] getCustomers() {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("Bob", "Dylan", 43);
        customers[1] = new Customer("Bob", "Smith", 23);
        customers[2] = new Customer("Peter", "Swarowsky", 43);
        customers[3] = new Customer("Hubba", "Bubba", 41);
        customers[4] = new Customer("Blah", "BLAH2", 22);
        return customers;
    }
}
