package Application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
		
	public static ResultSet executeQuery(String query) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vt","root","admin");
			Statement stmt= con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		  
	}
	
	public static void executeQuery2(String query) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vt","root","admin");
			Statement stmt= con.createStatement();  
			stmt.executeUpdate(query);
		 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
	}

}
