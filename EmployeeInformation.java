import java.util.*;
import javax.swing.*;

import com.sun.scenario.effect.impl.prism.ps.PPSDisplacementMapPeer;
import com.sun.xml.internal.ws.client.sei.ValueSetter;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeInformation extends JFrame{
	
	Connection conn = SqliteConnection.dbConnector();
	JLabel label = new JLabel("Employee INFORMATION");
	JLabel empName = new JLabel("Employee Name");
	JTextField empNameTxtField = new JTextField(10);
	
	JButton addEmp = new JButton("Add Employee");
	JButton cancel = new JButton("Cancel");
	
	JLabel address = new JLabel("Address");
	JTextField addrsTxtField = new JTextField(10);
	
	JLabel fatherName = new JLabel("Father's Name");
	JTextField fatherNmTxtField = new JTextField(10);
	
	JLabel motherName = new JLabel("Mother's Name");
	JTextField MotherNmTxtField = new JTextField(10);
	
	JLabel postName = new JLabel("Post Name");
	JTextField postNameTxtField = new JTextField(10);
	
	
	
	//constructor
	public EmployeeInformation(){
		
		super("EmployeeInformation");
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(800,500);
		setLocationRelativeTo(null);
		
		empName.setSize(100,25);
		empName.setLocation(10,10);
		getContentPane().add(empName);
		
		
		empNameTxtField.setSize(100,25);
		empNameTxtField.setLocation(115,10);
		getContentPane().add(empNameTxtField);
		
		addEmp.setBackground(Color.CYAN);
		addEmp.setBounds(20,250,120,30);
		getContentPane().add(addEmp);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fatherNmTxtField.setText("");
				empNameTxtField.setText("");
				MotherNmTxtField.setText("");
				postNameTxtField.setText("");
				addrsTxtField.setText("");
			}
		});
		
		cancel.setBackground(Color.CYAN);
		cancel.setBounds(160,250,120,30);
		getContentPane().add(cancel);
		
		address.setSize(100,25);
		address.setLocation(10,40);
		getContentPane().add(address);
		
		addrsTxtField.setSize(100,25);
		addrsTxtField.setLocation(115,40);
		getContentPane().add(addrsTxtField);
		
		fatherName.setSize(100,25);
		fatherName.setLocation(10,70);
		getContentPane().add(fatherName);
		
		fatherNmTxtField.setSize(100,25);
		fatherNmTxtField.setLocation(115,70);
		getContentPane().add(fatherNmTxtField);
		
		motherName.setSize(100,25);
		motherName.setLocation(10,100);
		getContentPane().add(motherName);
		
		MotherNmTxtField.setSize(100,25);
		MotherNmTxtField.setLocation(115,100);
		getContentPane().add(MotherNmTxtField);
		
		postName.setSize(100,25);
		postName.setLocation(10,130);
		getContentPane().add(postName);
		
		postNameTxtField.setSize(100,25);
		postNameTxtField.setLocation(115,130);
		getContentPane().add(postNameTxtField);
		
		
		label.setBounds(100,200,200,60);
		label.setForeground(Color.BLUE);
		getContentPane().add(label);
		
		addEmp.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						label.setText("Your Employee information added");
						label.setForeground(Color.RED);
						
						
						try {
							String empName = empNameTxtField.getText();
							String address = addrsTxtField.getText();
							String fathersName = fatherNmTxtField.getText();
							String motherName = MotherNmTxtField.getText();
							String postName = postNameTxtField.getText();
							
							conn = SqliteConnection.dbConnector();
							String query = "insert into EmployeeInformation (EmployeeName, Address,FathersName, MothersName, PostName) " + " values(?,?,?,?,?)";
							PreparedStatement pst= conn.prepareStatement(query);
							
							pst.setString(1, empName);
							pst.setString(2, address);
							pst.setString(3, fathersName);
							pst.setString(4, motherName);
							pst.setString(5, postName);
							
							pst.execute();
							conn.close();
							//ResultSet rs = pst.executeQuery();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				}
			);
	}
	

}
