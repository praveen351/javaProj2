<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style>
table, th, td {
	border-spacing: 5px;
}

th, td {
	padding: 7px;
}
</style>

</head>

<body>
	<div
		style="position: absolute; margin-top: 50px; margin-left: 480px; background-color: #08EBD6; border: 2pxdouble black">
		<h1>
			<b>Registration</b>
		</h1>
		<form:form action="registration/do" method="POST" modelAttribute="user">
			<table style="width: 100%">
				<tr>
					<td>First Name</td>
					<td><form:input path="First_Name" type="text"
							name="First_Name" id="firstname"
							style="width: 300px; height: 20px;" required="required"
							pattern="[a-zA-Z0-9]+"
							title="Please Enter Proper First Name i.e., Praveen" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="Last_Name" type="text" name="Last_Name"
							id="lastname" style="width: 300px; height: 20px;"
							required="required" pattern="[a-zA-Z0-9]+"
							title="Please Enter Proper Last Name i.e., Kumar" /></td>
				</tr>
				<tr>
					<td>Email ID</td>
					<td><form:input path="Email" type="email" name="Email"
							id="email" style="width: 300px; height: 20px;"
							required="required"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
							title="Please Enter Proper Mail id i.e., raj@gmail.com" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="Password" type="password"
							name="Password" id="password" style="width: 300px; height: 20px;"
							required="required"
							pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
							title="Please UpperCase, LowerCase, Number/SpecialChar and min 8 Chars" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="submit" name="register">REGISTER</button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>

</html>