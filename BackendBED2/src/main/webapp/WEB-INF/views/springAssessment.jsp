<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Assessment</title>
</head>
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
</script>
<script>
	var QuestionVal = [];
	var OptionVal = [];
	function handleEvent(currentData) {
		var id = parseInt(currentData.name.substr("Question".length,
				currentData.name.length));
		var question = document.getElementById("ques".concat(id)).innerHTML
				.trim();
		if (QuestionVal.indexOf(currentData.name) != -1) {
			OptionVal[QuestionVal.indexOf(currentData.name)] = question.concat(
					'-').concat(currentData.value);
		} else {
			QuestionVal.push(currentData.name);
			OptionVal.push(question.concat('-').concat(currentData.value));
		}
	}
	function setData() {
		var stringData = '';
		for (var i = 0; i < OptionVal.length; i++) {
			stringData = stringData.concat('#').concat(OptionVal[i]);
		}
		stringData = stringData.substr(1,stringData.length);
		console.log(QuestionVal.toString());
		console.log(OptionVal.toString());
		$('[name="aqData"]').val(stringData);
	}
</script>

<body>
	<div
		style="position: absolute; margin-top: 5px; margin-left: 400px; background-color: #08EBD6; border: 2pxdouble black">
		<h1>
			<b style="margin-left: 160px;">Spring Assessment</b>
			<hr>
		</h1>
		<form:form action="evaluate/spring/test" method="POST"
			onsubmit="setData()" modelAttribute="qaData">
			<div style="width: 600px; height: 650px;">
				<c:forEach var="data" items="${QAList}" varStatus="loopCounter">
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
				<form:hidden path="aqData" name="aqData" />
				<div style="margin-left: 20px;">
					<form:button type="submit" id="submitData" name="submitDataN">SUBMIT</form:button>
				</div>
			</div>
		</form:form>
	</div>
</body>