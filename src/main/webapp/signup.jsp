<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Sign Up - Event Tracker</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div style="max-width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        <h2 style="text-align: center;">Create Account</h2>
        
        <% if (request.getAttribute("error") != null) { %>
            <div style="color: red; margin-bottom: 15px;"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <form action="auth/signup" method="post">  
            <div style="margin-bottom: 15px;">
                <label>Name:</label>
                <input type="text" name="name" required style="width: 100%; padding: 8px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label>Email:</label>
                <input type="email" name="email" required style="width: 100%; padding: 8px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label>Password:</label>
                <input type="password" name="password" required style="width: 100%; padding: 8px;">
            </div>
            
            <button type="submit" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 4px; width: 100%;">
                Sign Up
            </button>
        </form>
        
        <p style="text-align: center; margin-top: 15px;">
            Already have an account? <a href="login.jsp">Login here</a>
        </p>
        <p style="text-align: center;">
            <a href="index.jsp">Back to Home</a>
        </p>
    </div>
</body>
</html>