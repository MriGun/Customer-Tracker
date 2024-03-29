<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
<!-- reference stylesheet -->
<link type = "text/css" rel= "stylesheet" href= "${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id = "wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id = "container">
		<div id="content">
		<!-- put new button -->
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;"
		 class="add-buttion"/>
		<br>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- lopp over and print customers -->
				<c:forEach var = "tempCustomer" items="${customers}">
				
				<!-- construct an "update" link with customer id -->
				<c:url var="updateLink" value="/customer/showFormUpdate">
					<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
				<!-- construct an "update" link with customer id -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- show the update link -->
							<a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this?'))) return false">Delete</a>
							
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>