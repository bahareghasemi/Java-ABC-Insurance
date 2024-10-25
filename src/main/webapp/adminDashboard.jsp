<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="./styles/header.css" />
   <link rel="stylesheet" href="./styles/admin.css" />
   <link rel="stylesheet" href="./styles/userdashboard.css">
	<title>ABC-Insure</title>
</head>

<body>
    <header>
        <nav class="menu">
            <div class="nav_left"> 
            	<div><a href="productAdmin.jsp" class="btn btn-color" >Add new Product</a>  </div>
            </div>  
        </nav>
        <div class="nav_right">
                <div  class="btn"><a href='user.jsp' class="navs text-link-primary d-desktop">Logout</a></div>
        </div>
     </header>
     <hr />
	<section class="analytics-container">
			
		<div class="stat-container">

            <div class="each-stat">
				

            <div class="each-stat">
				<img src="./images/pending.png" alt=""  class="symbol">

				<div>
					<p>Pending Claims</p> 
					<h3 class="complaints">1</h3>
					
				</div>
			</div>
		</div>
	
		<div class="dashboard">
			<h1>Hello, <span>Admin</span>!</h1>
			<h3 style="text-align: center;">All Products</h3>
			<div style="text-align: center;" class="table-container">
				<div class="see-more">
					<a href="ReadAdminProducts">View All Products</a>
				</div>
			</div>
			<h3 style="text-align: center;">All Users</h3>
			<div style="text-align: center;" class="table-container">
			
				<div class="see-more">
					<a href="ReadAdminUsers">View All Users</a>
				</div>
			</div>
			<div style="text-align: center;" class="table-container">
			
				<div class="see-more">
					<a href="userDetails">View All Users Details</a>
				</div>
			</div>
			<h3 style="text-align: center;">All Claims</h3>
			<div style="text-align: center;" class="table-container">
			
				<div class="see-more">
					<a href="ReadAdminClaims">View All Users Claims</a>
				</div>
			</div>
		</div>
	</section>
</body>
</html>