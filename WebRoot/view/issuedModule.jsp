<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<title>信息发布</title>
</head>
<body>
	<div style="width:90%;margin:5%;">
		<div>
			<h1 style="text-align:center">信息发布</h1>
		</div>
		<br><br>
		<div>
			<table class="table table-bordered table-hover">
				<thead>
				<tr>
					<th>模块名称</th>
					<th>所属部门</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody  id="items">
					<c:forEach items="${dms }" var="dm">
					<tr>
						<td><a>${dm.DM_NAME }</a></td>
						<td>${dm.DM_SERVICE }</td>
						<td>
							<a class="btn btn-success" href="/news/manager/${dm.DM_ID}">浏览</a>
							<a class="btn btn-info" href="/news/add/${dm.DM_ID}">添加新闻</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<%@include file="footer.jsp" %>
	</div>
</body>
</html>