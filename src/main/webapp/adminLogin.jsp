<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Admin Login Page</title>
    <link rel="stylesheet" href="./styles/user.css">
    <link rel="stylesheet" href="./styles/header.css">
</head>
<body>
    <hr>
    <div class="container" >
        <h2>Welcome <span>Admin</span>!</h2>
        <form action="AdminLogin" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="uname" name="uname" required placeholder="Enter Admin username">
            </div>
            <div class="form-group">
                <label for="password" >Password:</label>
                <input type="password" id="password" name="password" required placeholder="Enter Password">
            </div>
   
            <button type="submit" class="btn-login">Login</button>
            
            <% String errorMsg =  (String) request.getAttribute("errorMsg"); // Read the errorMsg %>
	
				<% if (errorMsg != null && !errorMsg.isEmpty()) { %>
                <p class="error-message" style="color: red;"><%= errorMsg %></p>
            <% } %>
        </form>
  
    </div>
</body>
</html>