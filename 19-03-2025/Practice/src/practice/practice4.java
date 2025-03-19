package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class practice4 {
	public static void main(String[] args) {
		String query = "SELECT * FROM users";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
			System.out.println("Connection established success...");
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("userid") + " " +
						rs.getString("username") + " " +
						rs.getString("gmail") + " " +
						rs.getString("userpass")); 
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
