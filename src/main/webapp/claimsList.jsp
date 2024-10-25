<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>All Claims</title>
	<link rel="stylesheet" href="./styles/header.css">
	<link rel="stylesheet" href="./styles/userdashboard.css">
</head>
<body>
	<header>
		<nav class="menu">
            <div class="btn btn-color"><a href="adminDashboard.jsp">Main Page</a></div>
            <div class="btn btn-color"><a href="productAdmin.jsp" class="btn btn-color" >Add New Product</a></div>
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
						<th>Approved Date</th>
						<th>Reject Reason</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!-- Iterate over the list of claims -->
					<c:forEach var="claim" items="${claims}">
						<form action="UpdateClaim" method="POST">
							<tr>
								<td>${claim.productName}</td>
								<td>${claim.productId}</td>
								<td>${claim.description}</td>
								<td>${claim.dateOfClaim}</td>
								<td>
									<select name="status">
										<option value="Pending" ${claim.status == 'Pending' ? 'selected' : ''}>Pending</option>
										<option value="Approved" ${claim.status == 'Approved' ? 'selected' : ''}>Approved</option>
										<option value="Rejected" ${claim.status == 'Rejected' ? 'selected' : ''}>Reject</option>
									</select>
								</td>
								<td>
									<input type="date" name="approvalDate" value="${claim.approvalDate}" />
								</td>
								<td>
									<input type="text" name="rejectionReason" value="${claim.rejectionReason}" />
								</td>
								<td>
									<input type="hidden" name="claimId" value="${claim.claimId}" />
									<button type="submit" class="btn btn-color">Save</button>
								</td>
							</tr>
						</form>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
