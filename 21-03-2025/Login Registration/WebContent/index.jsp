<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEo5p5srbXBk7RyEebAK4e2QbnP5aZ9gHEq0inhhbL6E54gBbsIjL8" crossorigin="anonymous">
    <style>
        body {
            background-color: #e3f2fd;
            margin: 0;
            padding: 0;
        }
        .centre {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .card-container {
            background-color: #fff;
            padding: 30px 25px;
            /* Added padding on left and right */
            border-radius: 12px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        input {
            padding: 12px;
            width: 95%;
            /* Reduced width slightly to prevent touching */
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        button {
            width: 100%;
            padding: 12px;
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
        .btn-container {
            display: flex;
            gap: 10px;
            justify-content: center;
        }
        .btn-container button {
            width: 48%;
        }
        /* Mobile Responsiveness */
        @media (max-width: 576px) {
            .card-container {
                width: 90%;
                padding: 25px;
            }
            h1 {
                font-size: 24px;
                margin-bottom: 20px;
            }
            input {
                padding: 12px;
                width: 100%;
            }
            .btn-container {
                flex-direction: column;
                gap: 8px;
            }
            .btn-container button {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="centre">
        <div class="card-container">
            <h1>Login</h1>
            <form action="login.jsp" method="post">
                <input type="email" name="userMail" placeholder="Enter your Email" required>
                <input type="password" name="userpass" placeholder="Enter your Password" required>
                <div class="btn-container">
                    <button type="submit" class="btn btn-dark btn-sm">Login</button>
                    <button type="reset" class="btn btn-outline-secondary btn-sm">Reset</button>
                </div>
            </form>
            <br>
            <a href="register.jsp">Don't have an account? Register here</a>
        </div>
    </div>
</body>
</html>








