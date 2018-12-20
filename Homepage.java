import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame{
	//Components
	JLabel title = new JLabel("Hotel Management System");
	JButton bookRoom = new JButton("Book Room");
	JLabel login = new JLabel("Login");
	JButton manager = new JButton("Manager");
	JLabel contact = new JLabel("Contact us:");
	JLabel contactInfo = new JLabel("01626078626");
	Booking booking = new Booking(); 
	//constructor
	public Homepage(){
		super("Hotel Management");
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		
		title.setFont(new Font("Rockwell",Font.ITALIC,30));
		title.setForeground(Color.BLUE);
		title.setBounds(100,30,500,50);
		getContentPane().add(title);
		bookRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				booking.setVisible(true);
			}
		});
		
		bookRoom.setBackground(Color.CYAN);
		bookRoom.setBounds(20,300,120,60);
		getContentPane().add(bookRoom);
		
		login.setForeground(Color.BLACK);
		login.setFont(new Font("Rockwell",Font.PLAIN,18));
		login.setBounds(650,250,80,40);
		getContentPane().add(login);
		
		manager.setBackground(Color.CYAN);
		manager.setBounds(650,300,120,40);
		getContentPane().add(manager);
		
		contact.setFont(new Font("Rockwell",Font.PLAIN,20));
		contact.setForeground(Color.BLACK);
		contact.setBounds(350,500,150,40);
		getContentPane().add(contact);
		
		contactInfo.setFont(new Font("Rockwell",Font.PLAIN,20));
		contactInfo.setForeground(Color.RED);
		contactInfo.setBounds(500,500,400,40);
		getContentPane().add(contactInfo);
		
		
	}
}
