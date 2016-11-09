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
<title>新闻编辑</title>
</head>
<body>
	<div style="width:90%;margin:5%;">
		<div>
			<h1 style="text-align:center">新闻编辑</h1>
		</div>
		<br><br>
		<form class="" action="/news/edit" method="post">
		<div style="display:none">
				<input name="N_ID" type="hidden" value="${news.N_ID }"/>
				<input name="N_DATE" type="hidden" value="${news.N_DATE }"/>
			</div>
			<div class="form-inline">
				新闻标题:
				<input class="form-control" name="N_TITLE" type="text" value="${news.N_TITLE }">
			</div><br>
			<div class="form-inline">
				作者:
				<input class="form-control" name="N_AUTHOR" type="text" value="${news.N_AUTHOR }">
			</div><br>
			<div class="form-inline">
				所属模块:<span>${dmname }</span>
				<input class="form-control" name="N_DMID" type="hidden" value="${news.N_DMID }"/>		
			</div><br>
			<div class="form-inline">
				新闻内容:
				<textarea style="display:none" id="contents" name="N_CONTENT"></textarea >
				<div id="editor">${news.N_CONTENT }</div>
			</div><br>
			<div class="form-inline">
				允许所有人查看:
				<select class="form-control" name="N_SHOWALL">
					<option value="1" <c:if test="${news.N_SHOWALL== '1'}"> selected="selected" </c:if> >允许</option>
					<option value="0" <c:if test="${news.N_SHOWALL== '0'}"> selected="selected" </c:if>>不允许</option>
				</select>
			</div><br>
			<span style="color:red">如果允许所有人访问，下面的不需要填写</span><br>
			<div class="form-group">
				可查看该新闻的部门(输入部门名称使用英文逗号隔开):<br>
				<input class="form-control" name="N_SHOWSERVICE" type="text" value="${news.N_SHOWSERVICE }">
			</div><br>
			<div class="form-group">
				可查看该新闻的用户(输入用户登录名使用英文逗号隔开):<br>
				<input class="form-control" name="N_SHOWUSER" type="text" value="${news.N_SHOWUSER }">
			</div>
			<button class="btn btn-primary" onclick="submits();">提交</button>&nbsp;&nbsp;
			<a class="btn btn-warning" href="/module/manager">返回</a>
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