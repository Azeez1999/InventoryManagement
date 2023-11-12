
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(2, "Azeez Ahamed", "azeezahamed946@gmail.com", "123 Main St, City", "0772523767", "1999-07-27", "Male");
        customer.saveCustomer();
        System.out.println(customer);
    }
}