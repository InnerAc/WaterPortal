<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<script src="/static/js/myjs/addmodule.js"></script>
<title>首页</title>
</head>
<body>
	<div style="width:90%;margin:5%;">
		<div>
			<h1 style="text-align:center">新闻添加</h1>
		</div>
		<br><br>
		<form class="form-inline" action="/news/add" method="post">
			<div class="form-inline">
				新闻标题:
				<input class="form-control" name="N_title" type="text">
			</div><br>
			<div class="form-inline">
				作者:
				<input class="form-control" name="N_author" type="text">
			</div><br>
			<div class="form-inline">
				所属部门:
				<input class="form-control" name="N_service" type="text">
			</div><br>
			<div class="form-inline">
				所属模块:
				<select class="form-control" name="N_superid" >
					<c:forEach items="${modules }" var="module">
						<option value="${module.DM_id }">${module.DM_name}</option>
					</c:forEach>
				</select>
			</div><br>
			<div class="form-inline">
				新闻内容:
				<textarea  class="form-control" row="5" name="N_content">
				</textarea >
			</div><br>
			<input value=" 提交 " type="submit">
		</form>
	</div>
</body>
</html>