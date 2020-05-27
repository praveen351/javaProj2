<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Assessment</title>
</head>
<script>
	function handleEvent(currentData) {
		
	}
</script>
<body>
	<div
		style="position: absolute; margin-top: 5px; margin-left: 400px; background-color: #08EBD6; border: 2pxdouble black">
		<h1>
			<b style="margin-left: 160px;">Spring Assessment</b>
			<hr>
		</h1>
		<div style="width: 600px; height: 650px;">
			<c:forEach var="data" items="${question.getTestQuestionAnswerList()}"
				varStatus="loopCounter">
			&nbsp;&nbsp;<b><c:out value="Question: ${loopCounter.count}" /></b>
				<b> <label id="ques${loopCounter.count}"> <c:out
							value="${data.getTestQuestion()}" />
				</label></b>
				<br>
				<c:forEach var="data1" items="${data.getTestQuestionOptionList()}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="${data1.getTestOptionCode()}"
						name="Question${loopCounter.count}"
						value="${data1.getTestQuestionOption()}"
						onclick="handleEvent(this)">
					<c:out value="${data1.getTestQuestionOption().toUpperCase()}" />
					<br>
				</c:forEach>
				<br>
				<br>
			</c:forEach>
		</div>
	</div>
</body>