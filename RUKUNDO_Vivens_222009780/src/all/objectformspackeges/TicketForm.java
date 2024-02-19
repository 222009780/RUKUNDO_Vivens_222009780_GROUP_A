package all.objectformspackeges;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import all.objectspackage.Ticket;
public class TicketForm implements ActionListener {
			    JFrame frame;
			    JLabel id_lb = new JLabel("ticket_id");
			    JLabel event_id_lb = new JLabel("event_id");
			    JLabel type_lb = new JLabel("type");
			    JLabel price_lb = new JLabel("price");
			    JLabel contact_lb = new JLabel("available");
			   

			    JTextField id_txf = new JTextField();
			    JTextField event_id_txf = new JTextField();
			    JTextField type_txf = new JTextField(); // Changed from pass_txf to type_txf
			    JTextField price_txf = new JTextField();
			    JTextField contact_txf = new JTextField();
			    JTextField cont_txf = new JTextField();

			    JButton insert_btn = new JButton("Insert");
			    JButton view_btn = new JButton("View");
			    JButton uptype_btn = new JButton("Uptype");
			    JButton delete_btn = new JButton("Delete");

			    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			    int w = (int) screenSize.getWidth();
			    int h = (int) screenSize.getHeight();

			    public TicketForm() {
			        createForm();
			    }

			    private void addActionListeners() {
			        insert_btn.addActionListener(this);
			        view_btn.addActionListener(this);
			        uptype_btn.addActionListener(this);
			        delete_btn.addActionListener(this); // Added ActionListener for delete_btn
			    }

			    private void createForm() {
			        frame = new JFrame();
			        frame.setTitle("APPOINTMENT FORM");
			        frame.setBounds(10, 10, 500, 400);
			        frame.getContentPane().setLayout(null);
			        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			        frame.setVisible(true);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setResizable(true);
			        setLocationAndSize();
			    }

			    private void setLocationAndSize() {
			    	  id_lb.setBounds(10, 10, 100, 30);
				        event_id_lb.setBounds(10, 50, 100, 30);
				        type_lb.setBounds(10, 90, 100, 30);
				        price_lb.setBounds(10, 130, 100, 30);
				        contact_lb.setBounds(10, 170, 100, 30);
				       
				        
				      
				        
				       

				        id_txf.setBounds(160, 10, 130, 30);
				        event_id_txf.setBounds(160, 50, 130, 30);
				        type_txf.setBounds(160, 90, 130, 30);
				        price_txf.setBounds(160, 130, 130, 30);
				        contact_txf.setBounds(160, 170, 130, 30);
				        
				        
				        insert_btn.setBounds(10, 210, 85, 30);
				        view_btn.setBounds(100, 210, 85, 30);
				        uptype_btn.setBounds(190, 210, 85, 30);
				        delete_btn.setBounds(280, 210, 85, 30);
				        setFontForAll();
				        addComponentsToFrame();
			    }

			    private void setFontForAll() {
			    	   Font font = new Font("Georgia", Font.BOLD, 18);

				        id_lb.setFont(font);
				        event_id_lb.setFont(font);
				        type_lb.setFont(font);
				        price_lb.setFont(font);
				        contact_lb.setFont(font);
				       
				        
				      

				        id_txf.setFont(font);
				        event_id_txf.setFont(font);
				        type_txf.setFont(font);
				        price_txf.setFont(font);
				        contact_txf.setFont(font);
				       
				       

				        Font fonti = new Font("Courier New", Font.BOLD, 12);

				        insert_btn.setFont(fonti);
				        view_btn.setFont(fonti);
				        uptype_btn.setFont(fonti);
				        delete_btn.setFont(fonti);
			    }

			    private void addComponentsToFrame() {
			        frame.add(id_lb);
			        frame.add(event_id_lb);
			        frame.add(type_lb);
			        frame.add(price_lb);
			        frame.add(contact_lb);
			       
			       
			       

			        frame.add(id_txf);
			        frame.add(event_id_txf);
			        frame.add(type_txf);
			        frame.add(price_txf);
			        frame.add(contact_txf);
			       
			       

			        frame.add(insert_btn);
			        frame.add(view_btn);
			        frame.add(uptype_btn);
			        frame.add(delete_btn);

			        addActionListeners();
			    }

			    @Override
			    public void actionPerformed(ActionEvent e) {
			        Ticket ticket = new Ticket();
			        if (e.getSource() == insert_btn) {
			        	 ticket.setEvent_id(event_id_txf.getText());
			        	 ticket.setType(type_txf.getText());
			        	 ticket.setPrice(price_txf.getText());
			        	 ticket.setAvailable(contact_txf.getText());
			        	
			        	 ticket.insertData();
			        } else if (e.getSource() == view_btn) {
			        	 int id = Integer.parseInt(id_txf.getText());
				            ticket.readWithticket_id(id);
				            id_txf.setText(String.valueOf(ticket.getEvent_id()));
				            event_id_txf.setText(ticket.getEvent_id());
				            type_txf.setText(ticket.getType());
				            price_txf.setText(ticket.getPrice());
				             contact_txf.setText(ticket.getAvailable());
					           
			        } else if (e.getSource() == uptype_btn) {
			        	 int id = Integer.parseInt(id_txf.getText());
				            ticket.setEvent_id(event_id_txf.getText());
				        	 ticket.setType(type_txf.getText());
				        	 ticket.setPrice(price_txf.getText());
				        	 ticket.setAvailable(contact_txf.getText());
				        	 
				        	 ticket.update(id);
			        } else if (e.getSource() == delete_btn) {
			        	 int id = Integer.parseInt(id_txf.getText());
				            ticket.delete(id);
			        }
			    }

			    public static void main(String[] args) {
			    	TicketForm TicketForm = new TicketForm();
			        System.out.println(TicketForm);
			    }
			}




