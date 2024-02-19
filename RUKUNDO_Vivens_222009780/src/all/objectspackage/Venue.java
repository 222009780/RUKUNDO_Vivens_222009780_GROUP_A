package all.objectspackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Venue {

	

				private int Venue_id;
				private  String Name;
				private  String Address;
				private String Capacity;
				private String ContactPerson;
				
				 public Venue()  {}
				public Venue(int Venue_id,  String Name,  String Address, String Capacity, String ContactPerson
						) {
					this.Venue_id = Venue_id;
					this.Name = Name;
					this.Address = Address;
					this.Capacity = Capacity;
					this.ContactPerson =ContactPerson;
					}
			
			
				public Venue(String Name,  String Address, String Capacity, String ContactPerson) {
					this.Name = Name;
					this.Address = Address;
					this.Capacity = Capacity;
					this.ContactPerson =ContactPerson;
					
				}
				
			
				public int getVenue_id() {
					return Venue_id;
				}
				public void setVenue_id(int venue_id) {
					Venue_id = venue_id;
				}
				public String getName() {
					return Name;
				}
				public void setName(String name) {
					Name = name;
				}
				public String getAddress() {
					return Address;
				}
				public void setAddress(String address) {
					Address = address;
				}
				public String getCapacity() {
					return Capacity;
				}
				public void setCapacity(String capacity) {
					Capacity = capacity;
				}
				public String getContactPerson() {
					return ContactPerson;
				}
				public void setContactPerson(String contactPerson) {
					ContactPerson = contactPerson;
				}
				//Method to establish database connection
				private Connection getConnection() throws SQLException {
				    String url = "jdbc:mysql://localhost/rukundo_vivens_ets";
				    String User= "222009780";
				    String password = "222009780";
				    return DriverManager.getConnection(url, User, password);
				}
				public void insertData() {
				    String sql = "INSERT INTO venue (Name, Address,Capacity, ContactPerson) VALUES ( ?, ?, ?, ?)";
				    try (Connection con = getConnection();
				            PreparedStatement statement = con.prepareStatement(sql)) {
				        statement.setString(1, this.Name);
				        statement.setString(2, this.Address);
				        statement.setString(3, this.Capacity);
				        statement.setString(4, this.ContactPerson);
				        int rowsInserted = statement.executeUpdate();
				        if (rowsInserted > 0) {
				            JOptionPane.showMessageDialog(null, "appointment  inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            JOptionPane.showMessageDialog(null, "Failed to insert Venue!", "Error", JOptionPane.ERROR_MESSAGE);
				        }
				    } catch (SQLException e) {
				        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
				    }
				}


				    public void readWithVenue_id(int inputVenue_id) {
				    	
				        String sql = "SELECT * FROM venue WHERE venue_id = ?";

				        try (Connection con = getConnection();
				                PreparedStatement statement = con.prepareStatement(sql)) {
				            statement.setInt(1, inputVenue_id);

				            ResultSet resultSet = statement.executeQuery();

				            if (resultSet.next()) {
				                this.Name = resultSet.getString("Name");
				                this.Address = resultSet.getString("Address");
				                this.Capacity = resultSet.getString("Capacity");
				                this.ContactPerson= resultSet.getString("ContactPerson");
				               
				               
				            } else {
				                JOptionPane.showMessageDialog(null, "No data found with Resume: " + inputVenue_id, "Read Error", JOptionPane.ERROR_MESSAGE);
				            }
				        } catch (SQLException e) {
				            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
				        }
				    }
				    public void update(int inputVenue_id) {
				        String sql = "UPDATE venue SET Name=?,Address=?, Capacity=?, ContactPerson=? WHERE venue_id=?";

				        try (Connection con = getConnection();
				             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
				            preparedStatement.setString(1, this.Name);
				            preparedStatement.setString(2, this.Address);
				            preparedStatement.setString(3, this.Capacity);
				            preparedStatement.setString(4, this.ContactPerson);
				            preparedStatement.setInt(5, inputVenue_id);

				            int rowsAffected = preparedStatement.executeUpdate();

				            if (rowsAffected > 0) {
				                JOptionPane.showMessageDialog(null, "Data updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
				            } else {
				                JOptionPane.showMessageDialog(null, "No data found with ID: " + inputVenue_id, "Update Error", JOptionPane.ERROR_MESSAGE);
				            }
				        } catch (SQLException e) {
				            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
				        }
				    }


				   public void delete(int inputVenue_id) {
				  
				       String sql = "DELETE FROM venue WHERE venue_id=?";

				       try (Connection con = getConnection();
				               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
				           preparedStatement.setInt(1, inputVenue_id);

				           int rowsAffected = preparedStatement.executeUpdate();

				           if (rowsAffected > 0) {
				               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
				           } else {
				               JOptionPane.showMessageDialog(null, "No data found with venue_id: " + inputVenue_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
				           }
				       } catch (SQLException e) {
				           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
				       }
				   }
				}






