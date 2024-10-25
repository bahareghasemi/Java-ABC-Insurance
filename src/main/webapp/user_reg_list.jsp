<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Registered Products</title>
    <link rel="stylesheet" href="./styles/header.css">
    <link rel="stylesheet" href="./styles/userdashboard.css">
</head>
<body>
    <header>
        <nav class="menu">
            <div class="btn btn-color"><a href="userDashboard.jsp">Main Page</a></div>
            <div class="btn btn-color"><a href="product.jsp" class="btn btn-color" >Register New Product</a>  </div>
        </nav>
        <div class="nav_right">
        
        <div class="btn btn-color"><a href='user.jsp' class="navs text-link-primary d-desktop">Log out</a></div>
        </div>
    </header>
    <hr>

    <div class="dashboard">
		<h1>All Registered Products</h1>
        	<div class="table-container">
     			<table class="styled-table" id="registered-table">
					<thead>
						<tr>
							<th>Name of Product</th>
							<th>Registration Id</th>
							<th>Serial No.</th>
							<th>Category</th>
							<th>Purchase Date</th>
							<th>No. of Claims Left</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
                		<c:forEach var="product" items="${registeredProducts}">
                    		<tr>
		                        <td>${product.productName}</td>
		                        <td>${product.productId}</td>
		                        <td>${product.serialNo}</td>
		                        <td>${product.category}</td>
		                        <td>${product.purchaseDate}</td>
		                        <td>${product.claimsLeft}</td>
		                        <td><a href="submitclaim.jsp" class="btn btn-color">Claim Insurance</a></td>      
		                    </tr>
		                </c:forEach>
					</tbody>
			</table>
        </div>
    </div>
</body>
</html>
