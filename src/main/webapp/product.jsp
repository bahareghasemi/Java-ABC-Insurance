<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Product</title>
    <link rel="stylesheet" href="./styles/registerProduct.css">
</head>
<body>
    <header>
        <nav class="menu">
        <div class="btn"><a href="userDashboard.jsp" style="text-decoration: none;">Back to Main</a></div>
        </nav>
           <div class="btn"><a href="user.jsp" style="text-decoration: none;">Logout</a></div>
    </header>
    <hr>

    <div class="container">
        <h2>Register Product</h2>
        <form action="RegisterProduct" method="POST">
            <div class="form-group">
                <label for="product-name">Product Name:</label>
                <input type="text" id="product-name" name="product-name" required>
            </div>
            <div class="form-group">
                <label for="serial-number">Product Serial Number:</label>
                <input type="text" id="serial-number" name="serial-no" required>
            </div>
            <div class="form-group">
                <label for="purchased-from">Purchased From:</label>
                <select id="purchased-from" name="purchased-from" required>
                    <option value="">Select</option>
                    <option value="Costco">Costco</option>
                    <option value="BestBuy">BestBuy</option>
                    <option value="Walmart">Walmart</option>
                    <option value="Staples">Staples</option>
                </select>
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <select id="category" name="category" required>
                    <option value="">Select</option>
                    <option value="Mobiles">Mobiles</option>
                    <option value="TV">TV</option>
                    <option value="Appliances">Appliances</option>
                    <option value="SmartWatch">Smart Watch</option>
                    <option value="EarphonesHeadphones">Earphones/Headphones</option>
                    <option value="Laptop">Laptop</option>
                </select>
            </div>
            <div class="form-group">
                <label for="purchase-date">Purchase Date:</label>
                <input type="date" id="purchase-date" name="purchase-date" required>
            </div>
            <button type="submit" class="btn-register">Register</button>
        </form>
    </div>
</body>
</html>
