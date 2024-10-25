<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="./styles/user.css">
</head>
<body>
    <hr>
    <div class="container">
    <h1>Welcome to <span>ABC-Insure</span></h1>
        <h2>Login</h2>
        <form action="UserLogin" method="POST">
            <div class="form-group">
                <label for="username" >Username</label>
                <input type="text" id="username" name="username" required placeholder="Enter Username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required placeholder="Enter Password">
            </div>
            <button type="submit" class="btn-login">Login</button>
              <% String errorMsg =  (String) request.getAttribute("errorMsg");%>
	
				<% if (errorMsg != null && !errorMsg.isEmpty()) { %>
                <p class="error-message" style="color: red;"><%= errorMsg %></p>
            <% } %>
        </form>
        <div class="additional-links">
            <p>Don't have an account? <a href="register.jsp" class="register-link">Register here</a></p>
        </div>
        <div class="additional-links">
            <p><a href="adminLogin.jsp" class="register-link">Admin Dashboard</a></p>
        </div>
    </div>
</body>
</html>
