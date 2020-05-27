<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
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
				contextroot).concat('/');
		$('a').attr('href', urlMake);
	}
</script>
</head>

<body>
	<div
		style="position: absolute; margin-top: 50px; margin-left: 370px; background-color: whitesmoke;">
		<div style="border: 2px double black;">
			<div id="msg" style="width: 600px; height: 55px; margin-left: 10px;">
				<h1>
					<b>Congratulations !!! You have passed !!! </b>
				</h1>
			</div>
			<h4 style="margin-left: 10px;">
				<a href="">Exit</a>
			</h4>
		</div>
	</div>
</body>