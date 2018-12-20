import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignedEmployee extends JFrame{
	private JTable table;
	Connection conn;
	JComboBox comboBox, comboBox_1;
	public AssignedEmployee() {
		
		this.setSize(800, 500);
		this.setResizable(false);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setOpaque(true);
		panel.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(67, 23, 88, 25);
		panel.add(comboBox);
		
		JLabel lblUnassignedRoom = new JLabel(" Room");
		lblUnassignedRoom.setBounds(10, 23, 94, 25);
		panel.add(lblUnassignedRoom);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(218, 25, 108, 20);
		panel.add(comboBox_1);
		
		JLabel lblUnassignedEmployee = new JLabel(" Employee");
		lblUnassignedEmployee.setBounds(165, 26, 63, 19);
		panel.add(lblUnassignedEmployee);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomNo = (String) comboBox.getSelectedItem();
				String employeeName = (String) comboBox_1.getSelectedItem();
				
				
				
				
				try {
					conn = SqliteConnection.dbConnector();
					String query = "insert into AssignedEmployee (RoomNo, EmployeeName) " + " values(?,?)";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, roomNo);
					pst.setString(2, employeeName);
					pst.execute();
					conn.close();
					
					refreshTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAssign.setBounds(349, 24, 88, 23);
		panel.add(btnAssign);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(100, 95, 300, 100);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setSize(200, 200);
		table.setPreferredScrollableViewportSize(new Dimension(200,200));
		table.setFillsViewportHeight(true);
        //table.setBackground(Color.PINK);
		scrollPane_1.setViewportView(table);
		
		setVisible(true);
		refreshRoomCombo();
		refreshEmployeeCombo();
		refreshTable();
	}
	
	public void refreshRoomCombo() {
			
				try{
					conn = SqliteConnection.dbConnector();
					String query = "select RoomNo from RoomInfo";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next())
					{
						
						comboBox.addItem(rs.getString(1));
					}
					
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
				}catch (Exception e){
					e.printStackTrace();	
			}
		}
	
	
	public void refreshEmployeeCombo() {
		
			try{
				conn = SqliteConnection.dbConnector();
				String query = "select EmployeeName from EmployeeInformation";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next())
				{
					
					comboBox_1.addItem(rs.getString(1));
				}
				
				//table.setModel(DbUtils.resultSetToTableModel(rs));
				
				pst.close();
				rs.close();
			}catch (Exception e){
				e.printStackTrace();	
		}
		
	}
	
	public void refreshTable() {
		
		try{
			conn = SqliteConnection.dbConnector();
			String query = "select RoomNo,EmployeeName from AssignedEmployee";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
//			while(rs.next())
//			{
//				
//				comboBox_1.addItem(rs.getString(1));
//			}
//			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
		}catch (Exception e){
			e.printStackTrace();	
	}
	
}
}
