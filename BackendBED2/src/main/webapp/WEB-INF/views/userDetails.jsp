<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All User Details</title>

<style>
table, th, td {
	border: 2px solid black;
}
</style>
</head>

<body>
	<div
		style="position: absolute; margin-top: 50px; margin-left: 400px; background-color: rgb(93, 212, 241);">

		<div style="border: 2px double black;">
			<h1 style="margin-left: 20px;">
				<b>List of All Users</b>
			</h1>
			<div style="width: 580px; height: ${userData.size()*35+30}px; margin-left: 10px;">
				<table style="width: 550px; height: 120px;">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Id</th>
						<th>User Type</th>
					</tr>
					<c:forEach var="dataObj" items="${userData}">
						<tr>
							<td><c:out value="${dataObj.getFirst_Name()}" /></td>
							<td><c:out value="${dataObj.getLast_Name()}" /></td>
							<td><c:out value="${dataObj.getEmail()}" /></td>
							<td><c:out value="${dataObj.getUser_Type()}" /></td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>
</body>

</html>