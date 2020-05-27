	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorld page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('[name="check"]').mouseover(function() {
			$(this).css({
				'cursor' : 'pointer',
				'background-color' : '#71B9B9'
			})
		})
		$('[name="check"]').mouseleave(function() {
			$(this).css({
				'cursor' : 'default',
				'background-color' : 'white'
			})
		})
	})
</script>
<style>
body {
	background-color: #08EBD6;
}

.double39 {
	border-top: 9px double #999;
	border-right: 3px double #999;
	border-bottom: 9px double #999;
	border-left: 3px double #999;
}

table, th, td {
	border: 1px solid black;
	border-spacing: 5px;
}

th, td {
	padding: 7px;
}
</style>
</head>

<body>
	<div style="position: absolute; margin-top: 50px; margin-left: 480px;"
		class="double39">
		<h1>
			<b>Check For Credit Card Eligibility</b>
		</h1>
		<form:form modelAttribute="ccEligibility" action="checkEligibility"
			method="POST" name="creditcheckEligibility">
			<table style="width: 100%">
				<tr>
					<td>Enter PAN Number</td>
					<td><form:input type="text" path="PANNumber" name="PANNumber"
							id="panNo" style="width: 300px;height: 20px;" autofocus="true"
							pattern="[a-zA-Z0-9]+" minlength="10" maxlength="10"
							required="required"
							title="Field Must Contain 10 Characters (all are aplphanumeric in nature) " /></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="submit" name="check">Check</form:button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>

</html>