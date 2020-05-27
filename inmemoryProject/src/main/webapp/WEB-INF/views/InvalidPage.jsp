<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CreditCard-Invalid</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		var url = window.location.href;
		var strArrInf = url.split(':')[2];
		var strValA = strArrInf.split('/');
		var port = strValA[0];
		var contextroot = strValA[1];

		var urlMake = 'http://localhost:'.concat(port).concat('/').concat(contextroot).concat('/');
		$('a').attr('href',urlMake);
	}
</script>	
</head>
<body style="background-color: orange;">
	<div style="position: absolute; margin-top: 50px; margin-left: 480px;">
		<div id="msg" style="width: 750px; height: 55px">
			<h1>Invalid PAN Entry !!!</h1>
		</div>
		<br>
		<h4>
			<a id="index">Enter Again</a>
		</h4>
	</div>
</body>
</html>