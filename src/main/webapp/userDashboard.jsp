<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Main</title>
<link rel="stylesheet" href="./styles/header.css">
<link rel="stylesheet" href="./styles/userdashboard.css">
</head>
<body>
	<header>
		<div class="menu">
			<div class="btn"><a href="product.jsp" class="btn btn-color">Register New Product</a></div>
		</div>
		<div  class="btn"><a href='user.jsp' class="navs text-link-primary d-desktop">Logout</a></div>
		
	</header>
	<hr>

	<div class="dashboard">
		<h1>
			Hello, <span>User</span>!
		</h1>
		<h3 style="text-align: center;">Registered Products</h3>
		<div style="text-align: center;" class="table-container">

			<div class="see-more">
				<a href="ReadUserProducts">View All Registered Products</a>
			</div>
		</div>

		<h3 style="text-align: center;">Claimed Products</h3>
		<div style="text-align: center;" class="table-container">
		
			<div class="see-more">
				<a href="ReadUserClaims">View All Claimed Products</a>
			</div>
		</div>
	</div>
</body>
</html>