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
<form:form action="update" method="post" modelAttribute="plan">
<form:hidden path="id"/>
	<table class="table">
		<tr>
			<td>项目名称</td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>投资金额</td>
			<td><form:input path="amount"/></td>
		</tr>
		<tr>
			<td>项目介绍</td>
			<td><form:input path="manager"/></td>
		</tr>
		<tr>
			<td>分管领导</td>
			<td><form:input path="content"/></td>
		</tr>
		<tr>
			<td>部门</td>
			<td><form:select path="dept_id" items="${dept}" itemLabel="cname" itemValue="dept_id"></form:select></td>
		</tr>
		<tr>
			<td><form:button>修改</form:button></td>
		</tr>
	</table>
</form:form>
</body>
</html>