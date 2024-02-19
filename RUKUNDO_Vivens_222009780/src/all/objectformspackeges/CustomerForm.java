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

import all.objectspackage.*;
public class CustomerForm   implements ActionListener {
									    JFrame frame;
									    JLabel id_lb = new JLabel("Customer_id");
									    JLabel name_lb = new JLabel("FirstName");
									    JLabel lname_lb = new JLabel("LastName");
									    JLabel cont_lb = new JLabel("Phone");
									    JLabel add_lb = new JLabel("Address");
									    JLabel email_lb= new JLabel("Email");
									    
								//text
									    JTextField id_txf = new JTextField();
									    JTextField name_txf = new JTextField();
									    JTextField fname_txf = new JTextField();
									    JTextField email_txf = new JTextField();
									    JTextField add_txf = new JTextField();
									    JTextField cont_txf = new JTextField();
									  

									    JButton insert_btn = new JButton("Insert");
									    JButton view_btn = new JButton("View");
									    JButton update_btn = new JButton("Update");
									    JButton delete_btn = new JButton("Delete");

									    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
									    int w = (int) screenSize.getWidth();
									    int h = (int) screenSize.getHeight();

									    public CustomerForm() {
									        createForm();
									    }

									    private void addActionListeners() {
									        insert_btn.addActionListener(this);
									        view_btn.addActionListener(this);
									        update_btn.addActionListener(this);
									        delete_btn.addActionListener(this);
									    }

									    private void createForm() {
									        frame = new JFrame();
									        frame.setTitle("CUSTOMER FORM");
									        frame.setBounds(10, 10, 400, 350);
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
									        lname_lb.setBounds(10, 90, 100, 30);
									         cont_lb.setBounds(10, 130, 100, 30);
									        add_lb.setBounds(10, 170, 100, 30);
									        email_lb.setBounds(10, 210, 100, 30);
									        
									      
									        
									       

									        id_txf.setBounds(160, 10, 130, 30);
									        name_txf.setBounds(160, 50, 130, 30);
									        fname_txf.setBounds(160, 90, 130, 30);
									         cont_txf.setBounds(160, 130, 130, 30);
									        add_txf.setBounds(160, 170, 130, 30);
									        email_txf.setBounds(160, 210, 130, 30);
									       
									        
									        insert_btn.setBounds(10, 250, 85, 30);
									        view_btn.setBounds(100, 250, 85, 30);
									        update_btn.setBounds(190, 250, 85, 30);
									        delete_btn.setBounds(280, 250, 85, 30);

									        setFontForAll();
									        addComponentsToFrame();
									    }

									    private void setFontForAll() {
									        Font font = new Font("Georgia", Font.BOLD, 18);

									        id_lb.setFont(font);
									        name_lb.setFont(font);
									        lname_lb.setFont(font);
									        email_lb.setFont(font);
									        add_lb.setFont(font);
									        cont_lb.setFont(font);
									       
									      

									        id_txf.setFont(font);
									        name_txf.setFont(font);
									        fname_txf.setFont(font);
									        email_txf.setFont(font);
									        add_txf.setFont(font);
									        cont_txf.setFont(font);
									       

									        Font fonti = new Font("Courier New", Font.BOLD, 12);

									        insert_btn.setFont(fonti);
									        view_btn.setFont(fonti);
									        update_btn.setFont(fonti);
									        delete_btn.setFont(fonti);
									    }

									    private void addComponentsToFrame() {
									        frame.add(id_lb);
									        frame.add(name_lb);
									        frame.add(lname_lb);
									        frame.add(email_lb);
									        frame.add(add_lb);
									        frame.add(cont_lb);
									      
									       
									       

									        frame.add(id_txf);
									        frame.add(name_txf);
									        frame.add(fname_txf);
									        frame.add(email_txf);
									        frame.add(add_txf);
									        frame.add(cont_txf);
									     

									        frame.add(insert_btn);
									        frame.add(view_btn);
									        frame.add(update_btn);
									        frame.add(delete_btn);

									        addActionListeners();
									    }

									    @Override
									    public void actionPerformed(ActionEvent e) {
									    Customer	 user=new Customer();
									        if (e.getSource() == insert_btn) {
									        	 user.setFirstName(name_txf.getText());
									            user.setLastName(fname_txf.getText());
									            user.setPhone(cont_txf.getText());
									            user.setAddress(add_txf.getText());
									            user.setEmail(cont_txf.getText());
									             user.insertData();
									        } else if (e.getSource() == view_btn) {
									            int id = Integer.parseInt(id_txf.getText());
									            user.readWithcustomer_id(id);
									            id_txf.setText(String.valueOf(user.getCustomer_id()));
									            name_txf.setText(user.getFirstName());
									            fname_txf.setText(user.getLastName());
									            email_txf.setText(user.getEmail());
									             add_txf.setText(user.getAddress());
										            cont_txf.setText(user.getPhone());
										            
										            } else if (e.getSource() == update_btn) {
									            int id = Integer.parseInt(id_txf.getText());
									       	 user.setFirstName(fname_txf.getText());
									            user.setLastName(email_txf.getText());
									            user.setPhone(email_txf.getText());
									            user.setAddress(add_txf.getText());
									            user.setEmail(cont_txf.getText());
									           
									            user.upLastName(id);
									        } else {
									            int id = Integer.parseInt(id_txf.getText());
									            user.delete(id);
									        }
									    }

									    public static void main(String[] args) {
									    	CustomerForm  CustomerForm  = new CustomerForm();
									        System.out.println(CustomerForm);
									    }
									}









