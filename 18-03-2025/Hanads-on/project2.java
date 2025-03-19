package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class project2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		try {
			Connection con = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established Successfully...");
			
			System.out.print("Enter the Mail : ");
			String mail = sc.next();
			
			String query = "SELECT * FROM users WHERE gmail = '" + mail + "';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				System.out.println("User already found...");
			}
			else {
				System.out.print("Enter the password : ");
				String pass = sc.next();
				
				String query1 = "INSERT INTO users (gmail, pass) VALUES ('" + mail + "', '" + pass + "');";
				int rowsAffect = st.executeUpdate(query1);
				if(rowsAffect > 0) {
					System.out.println("Account created successfully");
				}
				else {
					System.out.println("Failed to create a account");
				}
			}
			
			st.close();
			rs.close();
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
