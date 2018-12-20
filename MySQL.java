import java.sql.*;

public class MySQL {
	public void addBooking(String name, String address, String phoneNumber, String country, String creditCard, String date){
		String sql1= "INSERT INTO `booking` (`Name`, `Address`, `Phone_number`, `Country`, `Credit_card`,`Date`) VALUES ('"+ name +"', '"+ address +"', '"+ phoneNumber +"', '"+ country +"', '"+ creditCard +"','"+ date +"')";
		
		   Statement stmt=null;
		   ResultSet rs = null;
		  
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/hotel_management","root","");  
				  
				  
				 stmt=con.createStatement();  
				  
				 stmt.executeUpdate(sql1);  
				
				  
				con.close();  
				  
				}catch(Exception e){ System.out.println(e);}  
				  
				}
	
	public boolean checkLogin(String username, String password){
		String sql2= "Select * from `manager` where Email = '"+ username +"' and Password='"+ password +"' ";
		
		   Statement stmt=null;
		   ResultSet rs = null;
		   boolean status = false;
		  
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/hotel_management","root","");  

				 stmt=con.createStatement();  
	 
				 rs = stmt.executeQuery(sql2);    
				
				
				status = rs.next();
				
				
				con.close();
				
				
				}catch(Exception e){ System.out.println(e);}  
				  
				return status;
				
		}

			
			
}

