<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Reports</title>
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
		$('[name="allCandidate"]').attr('href', urlMake.concat('allUsers'));
		$('[name="allTest"]').attr('href', urlMake.concat('testCandidate'));
		$('[name="logout"]').attr('href', urlMake.concat('logout'));
	}
</script>
</head>

<body>
	<div
		style="position: absolute; margin-top: 50px; margin-left: 470px; background-color: whitesmoke;">
		<div style="border: 2px double black;">
			<div style="width: 450px; height: 200px; margin-left: 10px;">
				<h1 id="msg">Select Report</h1>
				<h2>
					<a name="allCandidate">View list of all candidates</a>
				</h2>
				<h2>
					<a name="allTest">View list of all tests taken</a>
				</h2>
				<h3>
					<a name="logout">Logout</a>
				</h3>
			</div>
		</div>
	</div>
</body>