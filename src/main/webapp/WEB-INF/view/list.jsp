<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/bootstrap.css">
<!-- 引入js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/jquery-3.2.1.js"></script>
</head>
<body>
<form id="fid" method="post">
	<input type="text" name="name" value="${plan.name}" placeholder="按照项目名查找">
	<input type="submit" class="btn btn-primary" value="查询" onclick="query()">
	<input type="button" class="btn btn-primary" value="批量删除" onclick="del()">
</form>
<table class="table">
	<tr>
		<td>
			<input type="button" value="全选" onclick="qx()" class="btn btn-primary">
			<input type="button" value="反选" onclick="fx()" class="btn btn-primary">
			<input type="button" value="全不选" onclick="qbx()" class="btn btn-primary">
		</td>
		<td>主键</td>
		<th>项目名称</td>
		<td>投资金额</td>
		<td>分管领导</td>
		<td>部门</td>
		<td>操作
		</td>
	</tr>
	<c:forEach items="${info.list}" var="p">
		<tr>
			<td><input type="checkbox" name="ck" value="${p.id}"></td>
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.amount}</td>
			<td>${p.content}</td>
			<td>${p.cname}</td>
			<td>
				<a href="${pageContext.request.contextPath}/selectById?id=${p.id}" class="btn btn-primary">查看详情</a>
				<a href="${pageContext.request.contextPath}/toUpdate?id=${p.id}" class="btn btn-primary">修改</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="10">
			<jsp:include page="/WEB-INF/view/pages.jsp"></jsp:include>
		</td>
	</tr>
</table>
</body>
<script type="text/javascript">
	function goPage(page) {
		location = "/select?page="+page+"&"+$("#fid").serialize();
	}
	function query() {
		location = "/select?"+$("#fid").serialize();
	}
	function qx() {
		$("[name='ck']").each(function () {
			this.checked=true;
		})
	}
	function qbx() {
		$("[name='ck']").each(function () {
			this.checked=false;
		})
	}
	function fx() {
		$("[name='ck']").each(function () {
			this.checked=!this.checked;
		})
	}
	function del() {
		var ids=$("[name='ck']:checked").map(function () {
			return this.value;
		}).get().join();
		if(confirm("确定要删除这些数据吗？")){
			$.ajax({
				url:'/del',
				type:'post',
				data:{"ids":ids},
				success:function(i){
					if(i>0){
						alert("删除成功");
						location="/select";
					}else{
						alert("删除失败");
					}
				}
			})
		}
	}
</script>
</html>