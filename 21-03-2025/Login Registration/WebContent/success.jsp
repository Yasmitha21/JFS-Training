<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background-color: #e3f2fd; /* Light blue background */
            font-family: Arial, sans-serif;
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            margin-top: 50px;
        }

        .card {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 12px;
            border: none;
            background-color: #fff;
            width: 400px;
        }

        .btn-custom {
            background-color: #000;
            color: #fff;
            border-radius: 8px;
            padding: 8px 16px;
            text-decoration: none;
        }

        .btn-custom:hover {
            background-color: #333;
            color: #fff;
        }

        .welcome-msg {
            font-size: 20px;
            font-weight: bold;
        }
    </style>
</head>

<body>
    <div class="container d-flex justify-content-center align-items-center">
        <div class="card p-4">
            <%
                if (session.getAttribute("ID") != null) {
                    String username = (String) session.getAttribute("username");
                    String role = (String) session.getAttribute("role");

                    if ("users".equals(role)) {
            %>
            <p class="welcome-msg text-success text-center">Welcome Back, <%= username %>!</p>
            <p class="text-center">You are logged in as a <strong>User</strong>.</p>
            <%
                } else {
            %>
            <p class="welcome-msg text-primary text-center">Welcome Back, Admin <%= username %>!</p>
            <p class="text-center">You have administrator privileges.</p>
            <div class="text-center mb-3">
                <a href="userList.jsp" class="btn btn-custom">View User Table</a>
            </div>
            <%
                }
            } else {
            %>
            <p class="text-danger text-center">Session Expired. Please log in again.</p>
            <div class="text-center">
                <a href="index.jsp" class="btn btn-custom">Login</a>
            </div>
            <%
                }
            %>
            <div class="text-center mt-3">
                <a href="Logout.jsp" class="btn btn-danger">Logout</a>
            </div>
        </div>
    </div>
</body>

</html>

