<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Products</title>
    <link rel="stylesheet" href="./styles/header.css">
    <link rel="stylesheet" href="./styles/userdashboard.css">
</head>
<body>
    <header>
        <nav class="menu">
            <div class="btn btn-color"><a href="adminDashboard.jsp">Main Page</a></div>
            <div class="btn btn-color"><a href="productAdmin.jsp" class="btn btn-color" >Add New Product</a>  </div>
        </nav>
        <div class="nav_right">
        
        <div class="btn btn-color"><a href='user.jsp' class="navs text-link-primary d-desktop">Log out</a></div>
        </div>
    </header>
    <hr>

    <div class="dashboard">
		<h1>All Products</h1>
        	<div class="table-container">
     			<table class="styled-table" id="registered-table">
					<thead>
						<tr>
							<th>Name of Product</th>
							<th>Category</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
                		<c:forEach var="product" items="${products}">
                    		<tr>
		                        <td>${product.productName}</td>
		                        <td>${product.category}</td>
		                        <td><a href="productList.jsp" class="btn btn-color">Delete Product</a></td>      
		                    </tr>
		                </c:forEach>
					</tbody>
			</table>
        </div>
    </div>
</body>
</html>
