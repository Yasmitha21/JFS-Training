<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background-color: #e3f2fd; /* Light blue background */
        }

        .centre {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh; /* Full viewport height for proper centering */
        }

        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
            color: #333;
        }

        input {
            padding: 10px;
            width: 250px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        button {
            width: 100px;
            padding: 8px;
            margin: 5px;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #5a6268;
            color: #fff;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <div class="centre">
        <h1>Register Page</h1>
        <form action="registerVerify.jsp" method="post">
            <input type="text" name="Username" placeholder="Enter the user name" required><br>
            <input type="email" name="userMail" placeholder="Enter the Mail Id" required><br>
            <input type="password" name="userpass" placeholder="Enter the Password" required><br>
            <button type="submit" class="btn btn-dark btn-sm">Create</button>
            <button type="reset" class="btn btn-outline-secondary btn-sm">Reset</button>
        </form>
        <br>
        <a href="index.jsp">Login here</a>
    </div>
</body>

</html>
