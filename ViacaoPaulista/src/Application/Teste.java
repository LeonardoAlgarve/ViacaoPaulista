package Application;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		String query;
		
		try {
			query = "Select * from cartoes";
			ResultSet resultSet = Connect.executeQuery(query);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber;			
			columnsNumber = rsmd.getColumnCount();
			while (resultSet.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print(",  ");
			        String columnValue = resultSet.getString(i);
			        System.out.print(columnValue + " " + rsmd.getColumnName(i));
			    }
			    System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
