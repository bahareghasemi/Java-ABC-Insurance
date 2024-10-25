<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Products and Claims</title>
     <link rel="stylesheet" href="./styles/admin.css" />
     	<link rel="stylesheet" href="./styles/userdashboard.css">
        <link rel="stylesheet" href="./styles/header.css" />
    <style>
        .container {
            display: flex;
            height: 100vh;
        }
        .users-list {
            width: 25%;
            border-right: 1px solid #ddd;
            padding: 20px;
            overflow-y: auto;
        }
        .users-list ul {
            list-style: none;
            padding: 0;
        }
        .users-list li {
            padding: 10px;
            cursor: pointer;
            border-bottom: 1px solid #ddd;
        }
        .users-list li a {
            text-decoration: none;
            color: black;
        }
        .users-list li:hover {
            background-color: #f0f0f0;
        }
        .user-details {
            width: 75%;
            padding: 20px;
            overflow-y: auto;
        }
        .user-details h3 {
            margin-bottom: 20px;
        }
        .user-details h4 {
            margin-top: 30px;
        }
        .user-details ul {
            list-style: none;
            padding: 0;
        }
    </style>
</head>
<body>

<header>
		<nav class="menu">
            <div class="btn btn-color"><a href="adminDashboard.jsp">Main Page</a></div>
            <div class="btn btn-color"><a href="productAdmin.jsp" class="btn btn-color" >Add New Product</a>  </div>
        </nav>
        <div class="nav_right">
			<a href='user.jsp' class="btn btn-color">Logout</a>
		</div>
	</header>
	<hr>
	
    <div class="container">
        <div class="users-list">
            <h3>Users</h3>
            <c:if test="${empty users}">
        		<p>No users found.</p>
    		</c:if>
            <ul>
                <c:forEach var="user" items="${users}">
                    <li>
                        <a href="userDetails?userId=${user.userId}">${user.username}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
	        <div class="user-details">
			    <c:choose>
			        <c:when test="${not empty products}">
			            <h3>Registered Products</h3>
			            <table>
			                <thead>
			                    <tr>
			                        <th>Product Name</th>
			                        <th>Serial Number</th>
			                        <th>Purchase Date</th>
			                    </tr>
			                </thead>
			                <tbody>
			                    <c:forEach var="product" items="${products}">
			                        <tr>
			                            <td>${product.productName}</td>
			                            <td>${product.serialNo}</td>
			                            <td>${product.purchaseDate}</td>
			                        </tr>
			                    </c:forEach>
			                </tbody>
			            </table>
			        </c:when>
			        <c:otherwise>
			            <h3>Select a User to view their details</h3>
			        </c:otherwise>
			    </c:choose>
			
			    <c:if test="${not empty claims}">
			        <h3>Claims</h3>
			        <table>
			            <thead>
			                <tr>
			                    <th>Claim ID</th>
			                    <th>Date of Claim</th>
			                    <th>Description</th>
			                    <th>Status</th>
			                </tr>
			            </thead>
			            <tbody>
			                <c:forEach var="claim" items="${claims}">
			                    <tr>
			                        <td>${claim.claimId}</td>
			                        <td>${claim.dateOfClaim}</td>
			                        <td>${claim.description}</td>
			                        <td>${claim.status}</td>
			                    </tr>
			                </c:forEach>
			            </tbody>
			        </table>
			    </c:if>
			</div>
   		 </div>
</body>
</html>
