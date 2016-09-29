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
			<h1 style="text-align:center">展示模块添加</h1>
		</div>
		<br><br>
		<form class="form-inline" action="/module/add" method="post">
			<div class="form-inline">
				模块名称:
				<input class="form-control" name="DM_name" type="text">
			</div><br>
			<div class="form-inline">
				所属部门:
				<input class="form-control" name="DM_service" type="text">
			</div><br>
			<div class="form-inline">
				展示类型:
				<select class="form-control" name="DM_type">
					<option value="1">文字展示</option>
					<option value="2">新闻列表</option>
				</select>
			</div><br>
			<div class="form-inline">
				展示尺寸:
				<select class="form-control" name="DM_size">
					<option value="1">正常尺寸</option>
					<option value="2">长</option>
					<option value="3">超长</option>
				</select>
			</div><br>
			<div class="form-inline">
				开放权限:
				<select class="form-control" name="DM_lvl">
					<option value="1">本部门</option>
					<option value="2">全厅</option>
					<option value="3">首页</option>
				</select>
			</div><br>
			<div class="form-inline">
				图片或新闻显示数量:
				<input class="form-control" name="DM_disnum" type="text">
			</div><br>
			<div class="form-inline">
				图片或新闻显示id:
				<input class="form-control" name="DM_disid" type="text">
			</div><br>
			<div class="form-inline">
				图片显示类型:
				<input class="form-control" name="DM_pictype" type="text">
			</div><br>
			<input value=" 提交 " type="submit">
		</form>
	</div>
</body>
</html>