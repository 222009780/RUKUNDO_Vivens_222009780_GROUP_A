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

import all.objectspackage.Event;
public class EventForm implements ActionListener {
		    JFrame frame;
		    JLabel id_lb = new JLabel("event_id");
		    JLabel name_lb = new JLabel("name");
		    JLabel date_lb = new JLabel("date");
		    JLabel description_lb = new JLabel("description");
		    JLabel contact_lb = new JLabel("category");
		   

		    JTextField id_txf = new JTextField();
		    JTextField name_txf = new JTextField();
		    JTextField date_txf = new JTextField(); // Changed from pass_txf to date_txf
		    JTextField description_txf = new JTextField();
		    JTextField contact_txf = new JTextField();
		    JTextField cont_txf = new JTextField();

		    JButton insert_btn = new JButton("Insert");
		    JButton view_btn = new JButton("View");
		    JButton update_btn = new JButton("Update");
		    JButton delete_btn = new JButton("Delete");

		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    int w = (int) screenSize.getWidth();
		    int h = (int) screenSize.getHeight();

		    public EventForm() {
		        createForm();
		    }

		    private void addActionListeners() {
		        insert_btn.addActionListener(this);
		        view_btn.addActionListener(this);
		        update_btn.addActionListener(this);
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
			        name_lb.setBounds(10, 50, 100, 30);
			        date_lb.setBounds(10, 90, 100, 30);
			        description_lb.setBounds(10, 130, 100, 30);
			        contact_lb.setBounds(10, 170, 100, 30);
			       
			        
			      
			        
			       

			        id_txf.setBounds(160, 10, 130, 30);
			        name_txf.setBounds(160, 50, 130, 30);
			        date_txf.setBounds(160, 90, 130, 30);
			        description_txf.setBounds(160, 130, 130, 30);
			        contact_txf.setBounds(160, 170, 130, 30);
			        
			        
			        insert_btn.setBounds(10, 210, 85, 30);
			        view_btn.setBounds(100, 210, 85, 30);
			        update_btn.setBounds(190, 210, 85, 30);
			        delete_btn.setBounds(280, 210, 85, 30);
			        setFontForAll();
			        addComponentsToFrame();
		    }

		    private void setFontForAll(){
		    	   Font font = new Font("Georgia", Font.BOLD, 18);

			        id_lb.setFont(font);
			        name_lb.setFont(font);
			        date_lb.setFont(font);
			        description_lb.setFont(font);
			        contact_lb.setFont(font);
			       
			        
			      

			        id_txf.setFont(font);
			        name_txf.setFont(font);
			        date_txf.setFont(font);
			        description_txf.setFont(font);
			        contact_txf.setFont(font);
			       
			       

			        Font fonti = new Font("Courier New", Font.BOLD, 12);

			        insert_btn.setFont(fonti);
			        view_btn.setFont(fonti);
			        update_btn.setFont(fonti);
			        delete_btn.setFont(fonti);
		    }

		    private void addComponentsToFrame() {
		        frame.add(id_lb);
		        frame.add(name_lb);
		        frame.add(date_lb);
		        frame.add(description_lb);
		        frame.add(contact_lb);
		       
		       
		       

		        frame.add(id_txf);
		        frame.add(name_txf);
		        frame.add(date_txf);
		        frame.add(description_txf);
		        frame.add(contact_txf);
		       
		       

		        frame.add(insert_btn);
		        frame.add(view_btn);
		        frame.add(update_btn);
		        frame.add(delete_btn);

		        addActionListeners();
		    }

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Event evento = new Event();
		        if (e.getSource() == insert_btn) {
		        	 evento.setName(name_txf.getText());
		        	 evento.setDate(date_txf.getText());
		        	 evento.setDescription(description_txf.getText());
		        	 evento.setCategory(contact_txf.getText());
		        	
		        	 evento.insertData();
		        } else if (e.getSource() == view_btn) {
		        	 int id = Integer.parseInt(id_txf.getText());
			            evento.readWithEvent_id(id);
			            id_txf.setText(String.valueOf(evento.getEvent_id()));
			            name_txf.setText(evento.getName());
			            date_txf.setText(evento.getDate());
			            description_txf.setText(evento.getDescription());
			             contact_txf.setText(evento.getCategory());
				           
		        } else if (e.getSource() == update_btn) {
		        	 int id = Integer.parseInt(id_txf.getText());
			            evento.setName(name_txf.getText());
			        	 evento.setDate(date_txf.getText());
			        	 evento.setDescription(description_txf.getText());
			        	 evento.setCategory(contact_txf.getText());
			        	 
			        	 evento.update(id);
		        } else if (e.getSource() == delete_btn) {
		        	 int id = Integer.parseInt(id_txf.getText());
			            evento.delete(id);
		        }
		    }

		    public static void main(String[] args) {
		    	EventForm EventForm = new EventForm();
		        System.out.println(EventForm);
		    }
		}



