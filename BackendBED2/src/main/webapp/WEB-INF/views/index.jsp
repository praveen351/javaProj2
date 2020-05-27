<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Assessment - Home Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('[name="login"]').mouseover(function() {
			$(this).css({
				'cursor' : 'pointer'
			})
		})
		$('[name="login"]').mouseleave(function() {
			$(this).css({
				'cursor' : 'default'
			})
		})
	});
	window.onload = function() {
		var url = window.location.href;
		var strArrInf = url.split(':')[2];
		var strValA = strArrInf.split('/');
		var port = strValA[0];
		var contextroot = strValA[1];

		var urlMake = 'http://localhost:'.concat(port).concat('/').concat(
				contextroot).concat('/').concat('register');
		$('a').attr('href', urlMake);
	}
</script>
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
			<b>Welcome to Online Assessments</b>
		</h1>
		<form:form action="login/do" method="POST" modelAttribute="userAuthenticate">
			<table style="width: 100%">
				<tr>
					<td>Email ID</td>
					<td><form:input type="email" path="Email" name="Email"
							id="email" style="width: 300px; height: 20px;" autofocus="true"
							required="required"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
							title="Please Enter Proper Mail id i.e., raj@gmail.com" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input type="password" path="Password"
							name="Password" id="password" style="width: 300px; height: 20px;"
							required="required"
							title="Please UpperCase, LowerCase, Number/SpecialChar and min 8 Chars" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="submit" name="login">LOGIN</button>
					</td>
				</tr>
				<tr>
					<td colspan="2">New User ? <a>register here</a>
					</td>
				</tr>

			</table>
		</form:form>
	</div>
</body>

</html>