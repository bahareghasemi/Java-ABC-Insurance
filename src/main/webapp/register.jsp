<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Page</title>
    <link rel="stylesheet" href="./styles/userRegister.css">
    <link rel="stylesheet" href="./styles/header.css">
</head>
<body>
    <header>
        <nav class="menu">
            <a href="#">Home</a>
            <a href="#">Plans</a>
        </nav>
    </header>
    <hr>
    <div class="container">
        <h2>Sign Up</h2>
        <form action="RegisterUser" method="POST">
            <div class="form-group">
                <label for="name" >Name:</label>
                <input type="text" id="name" name="username" required placeholder="Enter Name">
            </div>
            <div class="form-group">
                <label for="email" >Email*</label>
                <input type="email" id="email" name="email" required placeholder="Enter Email">
            </div>
            <div class="form-group">
                <label for="password" >Password*</label>
                <input type="password" id="password" name="password" required placeholder="Enter Password">
            </div>
            <div class="form-group">
                <label for="confirm-password">Confirm Password*</label>
                <input type="password" id="confirm-password" name="confirm-password" required placeholder="Re-enter Password">
            </div>
            <div class="form-group">
                <label for="phone" >phone_no:</label>
                <input type="number" id="phone" name="phone" required placeholder="Enter Address">
            </div>
            <button type="submit" class="btn-signup">Sign me up</button>
        </form>
    </div>
</body>
</html>
