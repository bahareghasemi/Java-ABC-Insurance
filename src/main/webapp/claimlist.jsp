<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>All Claimed Products</title>
	<link rel="stylesheet" href="./styles/header.css">
	<link rel="stylesheet" href="./styles/userdashboard.css">
</head>
<body>
	<header>
		<nav class="menu">
		<div>
			<a href="userDashboard.jsp" class="btn btn-color">Main Page</a>
			<a href="product.jsp" class="btn btn-color">Register New Product</a>
		</div>
		</nav>
		<div class="nav_right">
			<a href='user.jsp' class="btn btn-color">Logout</a>
		</div>
	</header>
	<hr>
	<div class="dashboard">
		<h1>Claims</h1>
		<div class="table-container">
			<table class="styled-table" id="claimed-table">
				<thead>
					<tr>
						<th>Name of Product</th>
						<th>Registration Id</th>
						<th>Issue</th>
						<th>Claimed Date</th>
						<th>Claim Status</th>
					</tr>
				</thead>
				<tbody>
					<!-- Iterate over the list of claims -->
					<c:forEach var="claim" items="${claims}">
						<tr>
							<td>${claim.productName}</td>
							<td>${claim.productId}</td>
							<td>${claim.description}</td>
							<td>${claim.dateOfClaim}</td>
							<td>${claim.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
