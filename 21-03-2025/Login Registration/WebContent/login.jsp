<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.mysql.jdbc.Driver" %>
<%
    String url = "jdbc:mysql://localhost:3306/logindb"; 
    String username = "root"; 
    String password = "root"; 
    
    String driver = "com.mysql.jdbc.Driver";
   
    try
    {
    	Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        out.println("Connection Successful!");
        
        String usergmail = request.getParameter("userMail");
        String pass = request.getParameter("userpass");
        
        String query = "SELECT * FROM USERS WHERE email = ? and pass = ?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,usergmail);
        ps.setString(2,pass);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        	session.setAttribute("ID",rs.getInt("ID"));
        	session.setAttribute("username",rs.getString("username"));
        	session.setAttribute("usermail", rs.getString("email")); 
        	session.setAttribute("password", pass); 
        	session.setAttribute("role",rs.getString("role"));
        	
        	 response.sendRedirect("success.jsp");
        	
        	out.println("User exist...");
        	out.println("<a href='Logout.jsp'>Logout</a>");
        }
        else{
        	out.println("User not found...");
        	out.println("<a href='register.jsp'>Sign Up</a>");
        }
    } 
    catch (SQLException e) 
    {
        out.println(e);
    } 
%>  


