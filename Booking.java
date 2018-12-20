import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Booking extends JFrame{
	
	JLabel label = new JLabel("BOOKING INFORMATION");
	JLabel name = new JLabel("Name");
	JTextField nameTxtField = new JTextField(10);
	JButton submit = new JButton("Submit");
	JButton cancel = new JButton("Cancel");
	JLabel address = new JLabel("Address");
	JTextField addrsTxtField = new JTextField(10); 
	JLabel phnnum = new JLabel("Phone Number");
	JTextField phnnumTxtField = new JTextField(10);
	JLabel country = new JLabel("Country");
	JTextField countryTxtField = new JTextField(10);
	JLabel creditCard = new JLabel("Credit card");
	JTextField creditCardTxtField = new JTextField(10);
	JLabel Date = new JLabel("Room");
	JTextField roomTxtField = new JTextField(10);
	
	Connection conn;
	//constructor
	public Booking(){
		
		super("booking");
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setVisible(true);
		setSize(800,500);
		setLocationRelativeTo(null);
		
		name.setSize(100,25);
		name.setLocation(10,10);
		getContentPane().add(name);
		
		
		nameTxtField.setSize(100,25);
		nameTxtField.setLocation(115,10);
		getContentPane().add(nameTxtField);
		
		submit.setBackground(Color.PINK);
		submit.setBounds(20,250,120,30);
		getContentPane().add(submit);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTxtField.setText("");
				countryTxtField.setText("");
				creditCardTxtField.setText("");
				phnnumTxtField.setText("");
				roomTxtField.setText("");
				addrsTxtField.setText("");
			}
		});
		
		cancel.setBackground(Color.PINK);
		cancel.setBounds(160,250,120,30);
		getContentPane().add(cancel);
		
		address.setSize(100,25);
		address.setLocation(10,40);
		getContentPane().add(address);
		
		addrsTxtField.setSize(100,25);
		addrsTxtField.setLocation(115,40);
		getContentPane().add(addrsTxtField);
		
		phnnum.setSize(100,25);
		phnnum.setLocation(10,70);
		getContentPane().add(phnnum);
		
		phnnumTxtField.setSize(100,25);
		phnnumTxtField.setLocation(115,70);
		getContentPane().add(phnnumTxtField);
		
		country.setSize(100,25);
		country.setLocation(10,100);
		getContentPane().add(country);
		
		countryTxtField.setSize(100,25);
		countryTxtField.setLocation(115,100);
		getContentPane().add(countryTxtField);
		
		creditCard.setSize(100,25);
		creditCard.setLocation(10,130);
		getContentPane().add(creditCard);
		
		creditCardTxtField.setSize(100,25);
		creditCardTxtField.setLocation(115,130);
		getContentPane().add(creditCardTxtField);
		
		Date.setSize(100,25);
		Date.setLocation(10,160);
		getContentPane().add(Date);
		
		roomTxtField.setSize(100,25);
		roomTxtField.setLocation(115,160);
		getContentPane().add(roomTxtField);
		
		label.setBounds(100,200,200,60);
		label.setForeground(Color.BLUE);
		getContentPane().add(label);
		
		submit.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						
						
						conn = SqliteConnection.dbConnector();
						
						String name = nameTxtField.getText();
						String address = addrsTxtField.getText();
						String phoneNum = phnnumTxtField.getText();
						String country = countryTxtField.getText();
						String creditCard = creditCardTxtField.getText();
						int roomNo = Integer.parseInt(roomTxtField.getText());
						String query;
						
						query = "select roomNo from Booking where roomNo="+roomNo;
						
						try {
							PreparedStatement pst1 = conn.prepareStatement(query);
							ResultSet rSet = pst1.executeQuery();
							if(rSet.next())
							{
								JOptionPane.showMessageDialog(null, "Room Is Occupied");
								pst1.close();
								conn.close();
							}
							else
							{
								try {
									
									conn = SqliteConnection.dbConnector();
									query = "insert into Booking (Name, Address, PhoneNum, Country, CreditCardNum, RoomNo) " + " values(?,?,?,?,?,?)";
									PreparedStatement pst= conn.prepareStatement(query);
									pst.setString(1, name);
									pst.setString(2, address);
									pst.setString(3, phoneNum);
									pst.setString(4, country);
									pst.setString(5, creditCard);
									pst.setInt(6, roomNo);
									
									pst.execute();
									conn.close();
									
									label.setText("YOUR BOOKING IS SUCCESSFUL");
									label.setForeground(Color.RED);
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
					}
				}
			);
	}
	

}
