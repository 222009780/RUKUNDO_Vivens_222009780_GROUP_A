package testconnectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Testconnect {
	

	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost/event_ticketing_system";
	        String user = "root"; // Replace with your MySQL username
	        String password = ""; // Replace with your MySQL password

	        try {
	            // Register MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establish connection
	            Connection connection = DriverManager.getConnection(url, user, password);
	            
	            // Check if connection is successful
	            if (connection != null) {
	                System.out.println("Connected to the database!");
	                // You can perform database operations here
	                // Don't forget to close the connection when done
	                connection.close();
	            } else {
	                System.out.println("Failed to connect to the database!");
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.println("MySQL JDBC driver not found!");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Failed to connect to the database!");
	            e.printStackTrace();
	        }
	    }
	}



