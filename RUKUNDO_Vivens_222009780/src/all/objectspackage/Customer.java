package all.objectspackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Customer {
	                    private int customer_id ;
						private  String FirstName;
						private  String LastName;
						private String Phone;
						private String Address;
						private String Email;
						 public Customer()  {}
						public Customer(int customer_id ,  String FirstName,  String LastName, String Phone, String Address,
								String Email) {
							this.customer_id  = customer_id ;
							this.FirstName = FirstName;
							this.LastName = LastName;
							this.Phone = Phone;
							this.Address =Address;
							this.Email = Email;
							
						}
						public Customer(String FirstName,  String LastName, String Phone, String Address,
								String Email) {
							this.FirstName = FirstName;
							this.LastName = LastName;
							this.Phone = Phone;
							this.Address =Address;
							this.Email = Email;
						}
					
						public int getCustomer_id() {
							return customer_id;
						}
						public void setCustomer_id(int customer_id) {
							this.customer_id = customer_id;
						}
						public String getFirstName() {
							return FirstName;
						}
						public void setFirstName(String firstName) {
							FirstName = firstName;
						}
						public String getLastName() {
							return LastName;
						}
						public void setLastName(String lastName) {
							LastName = lastName;
						}
						public String getPhone() {
							return Phone;
						}
						public void setPhone(String phone) {
							Phone = phone;
						}
						public String getAddress() {
							return Address;
						}
						public void setAddress(String address) {
							Address = address;
						}
						public String getEmail() {
							return Email;
						}
						public void setEmail(String email) {
							Email = email;
						}
						//Method to establish database connection
						private Connection getConnection() throws SQLException {
						    String url = "jdbc:mysql://localhost/rukundo_vivens_ets";
						    String User= "222009780";
						    String password = "222009780";
						    return DriverManager.getConnection(url, User, password);
						}
						public void insertData() {
						    String sql = "INSERT INTO customers (FirstName, LastName, Phone, Address, Email) VALUES (?, ?, ?, ?, ?)";
						    try (Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
						        statement.setString(1, this.FirstName);
						        statement.setString(2, this.LastName);
						        statement.setString(3, this.Phone);
						        statement.setString(4, this.Address);
						        statement.setString(5, this.Email);
						       
						        
						        int rowsInserted = statement.executeUpdate();
						        
						        if (rowsInserted > 0) {
						            JOptionPane.showMessageDialog(null, "data inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
						        } else {
						            JOptionPane.showMessageDialog(null, "Failed to insert data!", "Error", JOptionPane.ERROR_MESSAGE);
						        }
						    } catch (SQLException e) {
						        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
						    }
						}

						    public void readWithcustomer_id (int inputcustomer_id ) {
						    	
						        String sql = "SELECT * FROM customers WHERE customer_id = ?";

						        try (Connection con = getConnection();
						                PreparedStatement statement = con.prepareStatement(sql)) {
						            statement.setInt(1, inputcustomer_id );

						            ResultSet resultSet = statement.executeQuery();

						            if (resultSet.next()) {
						                this.FirstName = resultSet.getString("FirstName");
						                this.LastName = resultSet.getString("LastName");
						                this.Phone = resultSet.getString("Phone");
						                this.Address= resultSet.getString("Address");
						                this.Email = resultSet.getString("Email");
						            } else {
						                JOptionPane.showMessageDialog(null, "No data costume found with venue_id: " + inputcustomer_id , "Read Error", JOptionPane.ERROR_MESSAGE);
						            }
						        } catch (SQLException e) {
						            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
						        }
						    }
						    public void upLastName(int inputcustomer_id ) {
						   	 
						       String sql = "UPdate customers SET FirstName=?, LastName=?,Phone=?,Address=?,Email=? WHERE customer_id=?";

						       try (Connection con = getConnection();
						               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
						           preparedStatement.setString(1, this.FirstName);
						           preparedStatement.setString(2, this.LastName);
						           preparedStatement.setString(3, this.Phone);
						           preparedStatement.setString(4, this.Address);
						           preparedStatement.setString(5, this.Email);
						           preparedStatement.setInt(6, inputcustomer_id );

						           int rowsAffected = preparedStatement.executeUpdate();

						           if (rowsAffected > 0) {
						               JOptionPane.showMessageDialog(null, "Data update successfully!", "After upLastName", JOptionPane.INFORMATION_MESSAGE);
						           } else {
						               JOptionPane.showMessageDialog(null, "No data found with venue_id: " + inputcustomer_id , "UpPhone Error", JOptionPane.ERROR_MESSAGE);
						           }
						       } catch (SQLException e) {
						           JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "UpLastName Error", JOptionPane.ERROR_MESSAGE);
						       }
						   }

						   public void delete(int inputcustomer_id ) {
						  
						       String sql = "DELETE FROM customers WHERE customer_id=?";

						       try (Connection con = getConnection();
						               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
						           preparedStatement.setInt(1, inputcustomer_id );

						           int rowsAffected = preparedStatement.executeUpdate();

						           if (rowsAffected > 0) {
						               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
						           } else {
						               JOptionPane.showMessageDialog(null, "No data found with  venue_id: " + inputcustomer_id , "Delete Error", JOptionPane.ERROR_MESSAGE);
						           }
						       } catch (SQLException e) {
						           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
						       }
						   }
						}










