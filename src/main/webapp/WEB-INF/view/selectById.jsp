<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/bootstrap.css">
<!-- 引入js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/jquery-3.2.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="plan">
	<table class="table">
		<tr>
			<td>项目名称</td>
			<td>${plan.name}</td>
		</tr>
		<tr>
			<td>投资金额</td>
			<td>${plan.amount}</td>
		</tr>
		<tr>
			<td>项目介绍</td>
			<td>${plan.manager}</td>
		</tr>
		<tr>
			<td>分管领导</td>
			<td>${plan.content}</td>
		</tr>
		<tr>
			<td>部门</td>
			<td>${plan.cname}</td>
		</tr>
	</table>
</form:form>
</body>
</html>