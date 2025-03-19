package package1;

import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class practice {

	public static void main(String[] args) {
		String query = "SELECT gmail , pass FROM Users"
				+ ";";
		String url = "jdbc:mysql://localhost:3306/testdb";
		String user ="root";
		String pass = "root";
		try {
			 Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Established Successfully...");
			
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String email = rs.getString("gmail");
				String password = rs.getNString("pass");
				System.out.println(email + " " + password);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
				
		}
	}
}