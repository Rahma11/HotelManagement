import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Connection;
import net.proteanit.sql.DbUtils;

public class Table extends JPanel{
	 
	  JTable table;
	  JFrame frame;
	  Connection conn;
	  private JSlider slider;
	  private int sliderVal;
	  private JLabel label;
	  private JLabel label_1;
	  public Table(){
		  
		  frame = new JFrame("Room Information");

                  
		  
//		  String[] columnNames = {"RoomNo.","Type","Facilities","Rent"};
//		  
//		  Object[][] data = {
//                          {"501","Superior Double","2 bed,1 balcony","15000"},
//                          {"502","Superior Double","2 bed,1 balcony","15000"},
//                          {"503","Superior Double","2 bed,1 balcony","15000"},
//                          {"504","Superior Double","2 bed,1 balcony","15000"},
//                          {"201","Superior Triple","3 bed,1 balcony","25000"},
//                          {"202","Superior Triple","3 bed,1 balcony","25000"},
//                          {"203","Superior Triple","3 bed,1 balcony","25000"},
//                          {"204","Superior Triple","3 bed,1 balcony","25000"},
//                          {"601","Premium","2 bed","18000"},
//                          {"602","Premium","2 bed","18000"},
//                          {"603","Premium","2 bed","18000"},
//                          {"604","Premium","2 bed","18000"},
//			  {"301","Deluxe","2 bed,1 balcony","10000"},
//		          {"302","Deluxe","2 bed,1 balcony","10000"},
//                          {"303","Deluxe","2 bed,1 balcony","10000"},
//                          {"304","Deluxe","2 bed,1 balcony","10000"},
//			  {"401","Regular", "1 bed","4000"},
//			  {"402","Regular","1 bed","4000"},
//                          {"403","Regular","1 bed","4000"},
//                          {"404","Regular","1 bed","4000"},			  
//		  };
		  
		  
		  //table = new JTable(data,columnNames);
		  
		  conn=SqliteConnection.dbConnector();
		  table = new JTable();
		  table.setSize(700, 200);
		  table.setPreferredScrollableViewportSize(new Dimension(700,200));
		  table.setFillsViewportHeight(true);
          table.setBackground(Color.PINK);
		  
          setOpaque(true);
          
          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  frame.setSize(800,400);
		  setLayout(null);
		  
		  slider = new JSlider();
		  slider.setToolTipText("Select Maximum Value");
		  slider.setMinorTickSpacing(1000);
		  slider.setBounds(292, 5, 200, 26);
		  add(slider);
		  //setTitle("Room Information");
		  //setVisible(true);
		  
		  
		  JScrollPane scrollPane = new JScrollPane(table);
		  scrollPane.setBounds(41, 36, 702, 202);
		  
		  add(scrollPane);
		  this.refreshTable();
		  
		  frame.setContentPane(this);
		  frame.setVisible(true);
		  
		  slider.setMinimum(1000);
		  slider.setMaximum(15000);
		  
		  label = new JLabel("1000");
		  label.setForeground(Color.BLACK);
		  label.setBackground(Color.RED);
		  label.setBounds(236, 5, 46, 26);
		  add(label);
		  
		  label_1 = new JLabel("15000");
		  label_1.setBounds(507, 5, 46, 26);
		  add(label_1);
		  
		  slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				JSlider slider = (JSlider)arg0.getSource();
				sliderVal = slider.getValue();
				refreshTableWithSlider(sliderVal);
				
			}
		});
		  
		  
	  }
	  
	  public void refreshTableWithSlider(int val) {
	
		  try{
				String query = "select RoomNo,Type,Rent from RoomInfo where Rent between "+1000+" and "+val;
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				pst.close();
				rs.close();
			}catch (Exception e){
				e.printStackTrace();	
		}
	}
	  
	  public void refreshTable() {
			
			try{
				String query = "select RoomNo,Type,Rent from RoomInfo";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				pst.close();
				rs.close();
			}catch (Exception e){
				e.printStackTrace();	
		}
			
		
	}
}