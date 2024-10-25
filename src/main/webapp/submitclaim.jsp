<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submit Claim</title>
    <link rel="stylesheet" href="./styles/submitClaim.css">
</head>
<body>
    <header>
        <nav class="menu">
         <div class="btn-dashboard"><a href="userDashboard.jsp">Main Page</a></div>
        </nav>
        <div class="btn-dashboard"><a href="user.jsp" style="text-decoration: none;">Logout</a></div>
    </header>
    <hr>

    <div class="container">
        <h2>Submit Claim</h2>
        <form action="SubmitClaim" method="POST">
            <div class="form-group">
                <label for="product-name">Product Name:</label>
                <input type="text" id="product_name" name="product_name" required>
            </div>
            <div class="form-group">
                <label for="serial-number">Registration_Id</label>
                <input type="number" id="reg_Id" name="reg_Id" required>
            </div>
      

            <div class="form-group">
                <label for="issue">Issue:</label>
                <textarea id="issue" name="issue" rows="8" cols="100" required></textarea>
            </div>
            <button type="submit" class="btn-submit-claim">Submit Claim</button>
        </form>
    </div>
</body>
</html>
