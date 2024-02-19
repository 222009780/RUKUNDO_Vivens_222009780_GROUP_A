package all.objectspackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
     public class Ticket {

						private int ticket_id;
						private  String event_id;
						private  String type;
						private String price;
						private String available;
						
						 public Ticket()  {}
						public Ticket(int ticket_id,  String event_id,  String type, String price, String available
								) {
							this.ticket_id = ticket_id;
							this.event_id = event_id;
							this.type = type;
							this.price = price;
							this.available =available;
							}
					
					
						public Ticket(String event_id,  String type, String price, String available) {
							this.event_id = event_id;
							this.type = type;
							this.price = price;
							this.available =available;
							
						}
					
						public int getTicket_id() {
							return ticket_id;
						}
						public void setTicket_id(int ticket_id) {
							this.ticket_id = ticket_id;
						}
						public String getEvent_id() {
							return event_id;
						}
						public void setEvent_id(String event_id) {
							this.event_id = event_id;
						}
						public String getType() {
							return type;
						}
						public void setType(String type) {
							this.type = type;
						}
						public String getPrice() {
							return price;
						}
						public void setPrice(String price) {
							this.price = price;
						}
						public String getAvailable() {
							return available;
						}
						public void setAvailable(String available) {
							this.available = available;
						}
						//Method to establish database connection
						private Connection getConnection() throws SQLException {
						    String url = "jdbc:mysql://localhost/rukundo_vivens_ets";
						    String User= "222009780";
						    String password = "222009780";
						    return DriverManager.getConnection(url, User, password);
						}
						public void insertData() {
						    String sql = "INSERT INTO ticket (event_id, type,price, available) VALUES ( ?, ?, ?, ?)";
						    try (Connection con = getConnection();
						            PreparedStatement statement = con.prepareStatement(sql)) {
						        statement.setString(1, this.event_id);
						        statement.setString(2, this.type);
						        statement.setString(3, this.price);
						        statement.setString(4, this.available);
						        int rowsInserted = statement.executeUpdate();
						        if (rowsInserted > 0) {
						            JOptionPane.showMessageDialog(null, "data  inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
						        } else {
						            JOptionPane.showMessageDialog(null, "Failed to insert ticket!", "Error", JOptionPane.ERROR_MESSAGE);
						        }
						    } catch (SQLException e) {
						        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
						    }
						}


						    public void readWithticket_id(int inputticket_id) {
						    	
						        String sql = "SELECT * FROM ticket WHERE ticket_id = ?";

						        try (Connection con = getConnection();
						                PreparedStatement statement = con.prepareStatement(sql)) {
						            statement.setInt(1, inputticket_id);

						            ResultSet resultSet = statement.executeQuery();

						            if (resultSet.next()) {
						                this.event_id = resultSet.getString("event_id");
						                this.type = resultSet.getString("type");
						                this.price = resultSet.getString("price");
						                this.available= resultSet.getString("available");
						               
						               
						            } else {
						                JOptionPane.showMessageDialog(null, "No data found with Resume: " + inputticket_id, "Read Error", JOptionPane.ERROR_MESSAGE);
						            }
						        } catch (SQLException e) {
						            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
						        }
						    }
						    public void update(int inputticket_id) {
						        String sql = "UPtype ticket SET event_id=?,type=?, price=?, available=? WHERE ticket_id=?";

						        try (Connection con = getConnection();
						             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
						            preparedStatement.setString(1, this.event_id);
						            preparedStatement.setString(2, this.type);
						            preparedStatement.setString(3, this.price);
						            preparedStatement.setString(4, this.available);
						            preparedStatement.setInt(5, inputticket_id);

						            int rowsAffected = preparedStatement.executeUpdate();

						            if (rowsAffected > 0) {
						                JOptionPane.showMessageDialog(null, "Data update successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
						            } else {
						                JOptionPane.showMessageDialog(null, "No data found with ID: " + inputticket_id, "Update Error", JOptionPane.ERROR_MESSAGE);
						            }
						        } catch (SQLException e) {
						            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
						        }
						    }


						   public void delete(int inputticket_id) {
						  
						       String sql = "DELETE FROM ticket WHERE ticket_id=?";

						       try (Connection con = getConnection();
						               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
						           preparedStatement.setInt(1, inputticket_id);

						           int rowsAffected = preparedStatement.executeUpdate();

						           if (rowsAffected > 0) {
						               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
						           } else {
						               JOptionPane.showMessageDialog(null, "No data found with ticket_id: " + inputticket_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
						           }
						       } catch (SQLException e) {
						           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
						       }
						   }
						}







