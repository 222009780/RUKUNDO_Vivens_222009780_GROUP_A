package all.objectspackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Booking {
                    private int BookingID;
					private  String customer_id;
					private  String date;
					private String NumberOfTickets;
					private String ticket_id;
					
					 public Booking()  {}
					public Booking(int BookingID,  String customer_id,  String date, String NumberOfTickets, String ticket_id
							) {
						this.BookingID = BookingID;
						this.customer_id = customer_id;
						this.date = date;
						this.NumberOfTickets = NumberOfTickets;
						this.ticket_id =ticket_id;
						}
				
				
					public Booking(String customer_id,  String date, String NumberOfTickets, String ticket_id) {
						this.customer_id = customer_id;
						this.date = date;
						this.NumberOfTickets = NumberOfTickets;
						this.ticket_id =ticket_id;
						
					}
				
					public int getBookingID() {
						return BookingID;
					}
					public void setBookingID(int bookingID) {
						BookingID = bookingID;
					}
					public String getCustomer_id() {
						return customer_id;
					}
					public void setCustomer_id(String customer_id) {
						this.customer_id = customer_id;
					}
					public String getDate() {
						return date;
					}
					public void setDate(String date) {
						this.date = date;
					}
					public String getNumberOfTickets() {
						return NumberOfTickets;
					}
					public void setNumberOfTickets(String numberOfTickets) {
						NumberOfTickets = numberOfTickets;
					}
					public String getTicket_id() {
						return ticket_id;
					}
					public void setTicket_id(String ticket_id) {
						this.ticket_id = ticket_id;
					}
					//Method to establish database connection
					private Connection getConnection() throws SQLException {
					    String url = "jdbc:mysql://localhost/rukundo_vivens_ets";
					    String User= "222009780";
					    String password = "222009780";
					    return DriverManager.getConnection(url, User, password);
					}
					public void insertData() {
					    String sql = "INSERT INTO booking (customer_id, date,NumberOfTickets, ticket_id) VALUES ( ?, ?, ?, ?)";
					    try (Connection con = getConnection();
					            PreparedStatement statement = con.prepareStatement(sql)) {
					        statement.setString(1, this.customer_id);
					        statement.setString(2, this.date);
					        statement.setString(3, this.NumberOfTickets);
					        statement.setString(4, this.ticket_id);
					        int rowsInserted = statement.executeUpdate();
					        if (rowsInserted > 0) {
					            JOptionPane.showMessageDialog(null, "data  inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
					        } else {
					            JOptionPane.showMessageDialog(null, "Failed to insert Event!", "Error", JOptionPane.ERROR_MESSAGE);
					        }
					    } catch (SQLException e) {
					        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
					    }
					}


					    public void readWithBookingID(int inputBookingID) {
					    	
					        String sql = "SELECT * FROM booking WHERE BookingID = ?";

					        try (Connection con = getConnection();
					                PreparedStatement statement = con.prepareStatement(sql)) {
					            statement.setInt(1, inputBookingID);

					            ResultSet resultSet = statement.executeQuery();

					            if (resultSet.next()) {
					                this.customer_id = resultSet.getString("customer_id");
					                this.date = resultSet.getString("date");
					                this.NumberOfTickets = resultSet.getString("NumberOfTickets");
					                this.ticket_id= resultSet.getString("ticket_id");
					               
					               
					            } else {
					                JOptionPane.showMessageDialog(null, "No data found with Resume: " + inputBookingID, "Read Error", JOptionPane.ERROR_MESSAGE);
					            }
					        } catch (SQLException e) {
					            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
					        }
					    }
					    public void update(int inputBookingID) {
					        String sql = "UPDATE booking SET customer_id=?,date=?, NumberOfTickets=?, ticket_id=? WHERE BookingID=?";

					        try (Connection con = getConnection();
					             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
					            preparedStatement.setString(1, this.customer_id);
					            preparedStatement.setString(2, this.date);
					            preparedStatement.setString(3, this.NumberOfTickets);
					            preparedStatement.setString(4, this.ticket_id);
					            preparedStatement.setInt(5, inputBookingID);

					            int rowsAffected = preparedStatement.executeUpdate();

					            if (rowsAffected > 0) {
					                JOptionPane.showMessageDialog(null, "Data updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
					            } else {
					                JOptionPane.showMessageDialog(null, "No data found with ID: " + inputBookingID, "Update Error", JOptionPane.ERROR_MESSAGE);
					            }
					        } catch (SQLException e) {
					            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
					        }
					    }


					   public void delete(int inputBookingID) {
					  
					       String sql = "DELETE FROM booking WHERE BookingID=?";

					       try (Connection con = getConnection();
					               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
					           preparedStatement.setInt(1, inputBookingID);

					           int rowsAffected = preparedStatement.executeUpdate();

					           if (rowsAffected > 0) {
					               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
					           } else {
					               JOptionPane.showMessageDialog(null, "No data found with BookingID: " + inputBookingID, "Delete Error", JOptionPane.ERROR_MESSAGE);
					           }
					       } catch (SQLException e) {
					           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
					       }
					   }
					}







