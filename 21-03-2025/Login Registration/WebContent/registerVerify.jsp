<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.mysql.jdbc.Driver" %>

<% try {
	 String url = "jdbc:mysql://localhost:3306/logindb"; 
	    String name = "root"; 
	    String pass = "root"; 
	    
	    String Driver = "com.mysql.jdbc.Driver";
	    Class.forName(Driver);
	    Connection  con = DriverManager.getConnection (url,name, pass);
	    
	    String Username = request.getParameter("Username");
	    String userMail =request.getParameter("userMail");
	    String userpass = request.getParameter("userpass");
	    
	    String query1 = "SELECT * FROM USERS WHERE email = ?;";
	    PreparedStatement ps = con.prepareStatement(query1);
	    ps.setString(1,userMail);
	    
	    ResultSet rs = ps.executeQuery();
	   
	    if(rs.next()) {    	
	     out.println("<h3>User Already present</h3>");
	 	 out.println("<a href ='index.jsp'>Login</a>");
	    }
	    else {
	    	String query2 = "INSERT INTO USERS (username,email,pass) VALUES (? ,?, ?);";
	    	ps =con.prepareStatement(query2);
	    	 ps.setString(1,Username);
	    	 ps.setString(2,userMail);
	 	     ps.setString(3,userpass);
	 	     
	 	     int rows = ps.executeUpdate();
	 	     if(rows > 0){
	 	    	 out.println("<h3>User added successfully</h3>");
	 	    	 out.println("<a href ='index.jsp'>Login</a>");
	 	     }
	 	     else {
	            out.println("<h3>Failed to add user!!!</h3>");
	 	    	 out.println("<a href ='index.jsp'>Login</a>");
	 	     }
	    }
}
	    
catch(SQLException e) {
    e.printStackTrace();
}
%>

 
  