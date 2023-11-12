import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {
    private int customerId;
    private String customerName;
    private String email;
    private String address;
    private String contactNumber;
    private String dateOfBirth;
    private String gender;

    // Constructor
    public Customer(int customerId, String customerName, String email, String address, String contactNumber, String dateOfBirth, String gender) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    // Getters and Setters (unchanged)

    public void saveCustomer() {
        Connection con;
        PreparedStatement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Published");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "");
            System.out.println("Connected");

            String queryString = "INSERT INTO customer (customerId, customerName, email, address, contactNumber, dateOfBirth, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1, customerId);
            stmt.setString(2, customerName);
            stmt.setString(3, email);
            stmt.setString(4, address);
            stmt.setString(5, contactNumber);
            stmt.setString(6, dateOfBirth);
            stmt.setString(7, gender);

            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected");

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Not Found");
        } catch (SQLException ex) {
            System.out.println("Database Error");
            ex.printStackTrace();
        }
    }
}
