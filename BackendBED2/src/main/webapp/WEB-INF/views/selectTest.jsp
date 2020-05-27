<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Tests</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var url = window.location.href;
		var strArrInf = url.split(':')[2];
		var strValA = strArrInf.split('/');
		var port = strValA[0];
		var contextroot = strValA[1];
		var urlMake = 'http://localhost:'.concat(port).concat('/').concat(
				contextroot).concat('/');
		$('[name="sprAss"]').attr('href', urlMake.concat('sprinigAssessment'));
		$('[name="hiberAss"]').attr('href',
				urlMake.concat('hibernateAssessment'));
		$('[name="logout"]').attr('href', urlMake.concat('logout'));
	}
</script>
</head>
	
<body>
	<div
		style="position: absolute; margin-top: 50px; margin-left: 470px; background-color: whitesmoke;">
		<div style="border: 2px double black;">
			<div id="msg" style="width: 350px; height: 180px; margin-left: 10px;">
				<h1 style="margin-left: 70px;">Select the Test</h1>
				<h2 style="margin-left: 10px;">
					<a name="sprAss">Spring Assessment</a> <br> <a name="hiberAss">Hibernate
						Assessment</a>
				</h2>
				<h3 style="margin-left: 10px;">
					<a name="logout">LogOut</a>
				</h3>
			</div>

		</div>
	</div>
</body>