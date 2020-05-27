<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Tests Details</title>

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
				<b>List of Candidates and Tests</b>
			</h1>
			<div
				style="width: 620px; height: ${userTestData.size()*40+50+20}px; margin-left: 10px;">
				<table style="width: 600px; height: 120px;">
					<tr>
						<th>Test Date</th>
						<th>Assessment</th>
						<th>Test Marks</th>
						<th>Email ID</th>
						<th>Total Marks</th>
						<th>Result</th>
					</tr>
					<c:forEach var="dataObj" items="${userTestData}">
						<tr>
							<td><c:out value="${dataObj.getTestData()}" /></td>
							<td><c:out value="${dataObj.getSubjectName()}" /></td>
							<td><c:out value="${dataObj.getTestMark()}" /></td>
							<td><c:out value="${dataObj.getEmailID()}" /></td>
							<td><c:out value="${dataObj.getTotalMark()}" /></td>
							<td><c:out value="${dataObj.getResult()}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>

</html>