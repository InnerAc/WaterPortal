<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/static/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="/static/css/summernote.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<script src="/static/js/myjs/addmodule.js"></script>

<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/summernote.min.js"></script>

<title>新闻添加</title>
</head>
<body>
	<div style="width:90%;margin:5%;">
		<div>
			<h1 style="text-align:center">新闻添加</h1>
		</div>
		<br><br>
		<form id="form" class="" action="/news/add" method="post">
			<div class="form-inline">
				新闻标题:
				<input class="form-control" name="N_TITLE" type="text" >
			</div><br>
			<div class="form-inline">
				作者:
				<input class="form-control" name="N_AUTHOR" type="text">
			</div><br>
			<div class="form-inline">
				所属模块:<span>${dmname }</span>
				<input class="form-control" name="N_DMID" type="hidden" value="${dmid }"/>		
			</div><br>
			<div class="form-inline">
				新闻内容:
				<textarea style="display:none" id="contents" name="N_CONTENT"></textarea >
				<div id="editor"></div>
			</div><br>
			<div class="form-inline">
				允许所有人查看:
				<select class="form-control" name="N_SHOWALL">
					<option value="1"  >允许</option>
					<option value="0" >不允许</option>
				</select>
			</div><br>
			<span style="color:red">如果允许所有人访问，下面的不需要填写</span><br>
			<div class="form-group">
				可查看该新闻的部门(输入部门名称使用英文逗号隔开):<br>
				<input class="form-control" name="N_SHOWSERVICE" type="text">
			</div><br>
			<div class="form-group">
				可查看该新闻的用户(输入用户登录名使用英文逗号隔开):<br>
				<input class="form-control" name="N_SHOWUSER" type="text" value="${userid }">
			</div>
			<button class="btn btn-success" onclick="submits()">提交</button>
		</form>
		<%@include file="footer.jsp" %>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#editor').summernote();
		});
		function submits(){
			$('#contents').html($('#editor').summernote('code'));
			$('#editor').next().remove();
			$('#form').submit();
		}
	</script>
</body>
</html>