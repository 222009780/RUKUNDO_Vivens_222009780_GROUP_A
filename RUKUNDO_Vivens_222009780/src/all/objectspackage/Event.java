package all.objectspackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Event {


		

					private int Event_id;
					private  String name;
					private  String date;
					private String description;
					private String category;
					
					 public Event()  {}
					public Event(int Event_id,  String name,  String date, String description, String category
							) {
						this.Event_id = Event_id;
						this.name = name;
						this.date = date;
						this.description = description;
						this.category =category;
						}
				
				
					public Event(String name,  String date, String description, String category) {
						this.name = name;
						this.date = date;
						this.description = description;
						this.category =category;
						
					}
				
					public int getEvent_id() {
						return Event_id;
					}
					public void setEvent_id(int event_id) {
						Event_id = event_id;
					}
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public String getDate() {
						return date;
					}
					public void setDate(String date) {
						this.date = date;
					}
					public String getDescription() {
						return description;
					}
					public void setDescription(String description) {
						this.description = description;
					}
					public String getCategory() {
						return category;
					}
					public void setCategory(String category) {
						this.category = category;
					}
					//Method to establish database connection
					private Connection getConnection() throws SQLException {
					    String url = "jdbc:mysql://localhost/rukundo_vivens_ets";
					    String User= "222009780";
					    String password = "222009780";
					    return DriverManager.getConnection(url, User, password);
					}
					public void insertData() {
					    String sql = "INSERT INTO Event (name, date,description, category) VALUES ( ?, ?, ?, ?)";
					    try (Connection con = getConnection();
					            PreparedStatement statement = con.prepareStatement(sql)) {
					        statement.setString(1, this.name);
					        statement.setString(2, this.date);
					        statement.setString(3, this.description);
					        statement.setString(4, this.category);
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


					    public void readWithEvent_id(int inputEvent_id) {
					    	
					        String sql = "SELECT * FROM Event WHERE Event_id = ?";

					        try (Connection con = getConnection();
					                PreparedStatement statement = con.prepareStatement(sql)) {
					            statement.setInt(1, inputEvent_id);

					            ResultSet resultSet = statement.executeQuery();

					            if (resultSet.next()) {
					                this.name = resultSet.getString("name");
					                this.date = resultSet.getString("date");
					                this.description = resultSet.getString("description");
					                this.category= resultSet.getString("category");
					               
					               
					            } else {
					                JOptionPane.showMessageDialog(null, "No data found with Resume: " + inputEvent_id, "Read Error", JOptionPane.ERROR_MESSAGE);
					            }
					        } catch (SQLException e) {
					            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
					        }
					    }
					    public void update(int inputEvent_id) {
					        String sql = "UPDATE Event SET name=?,date=?, description=?, category=? WHERE Event_id=?";

					        try (Connection con = getConnection();
					             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
					            preparedStatement.setString(1, this.name);
					            preparedStatement.setString(2, this.date);
					            preparedStatement.setString(3, this.description);
					            preparedStatement.setString(4, this.category);
					            preparedStatement.setInt(5, inputEvent_id);

					            int rowsAffected = preparedStatement.executeUpdate();

					            if (rowsAffected > 0) {
					                JOptionPane.showMessageDialog(null, "Data updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
					            } else {
					                JOptionPane.showMessageDialog(null, "No data found with ID: " + inputEvent_id, "Update Error", JOptionPane.ERROR_MESSAGE);
					            }
					        } catch (SQLException e) {
					            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
					        }
					    }


					   public void delete(int inputEvent_id) {
					  
					       String sql = "DELETE FROM Event WHERE Event_id=?";

					       try (Connection con = getConnection();
					               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
					           preparedStatement.setInt(1, inputEvent_id);

					           int rowsAffected = preparedStatement.executeUpdate();

					           if (rowsAffected > 0) {
					               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
					           } else {
					               JOptionPane.showMessageDialog(null, "No data found with Event_id: " + inputEvent_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
					           }
					       } catch (SQLException e) {
					           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
					       }
					   }
					}







