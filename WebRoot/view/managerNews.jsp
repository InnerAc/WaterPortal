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
<title>新闻管理</title>
</head>
<body>
	<div style="width:90%;margin:5%;">
		<div>
			<h1 style="text-align:center">新闻管理</h1>
		</div>
		<br><br>
		<div style="float:right">
			<a href="/news/add/${dmid }" class="btn btn-success">增加新闻</a>
		</div>
		<br><br>
		<div>
			<table class="table table-bordered table-hover">
				<thead>
				<tr>
					<th>新闻标题</th>
					<th>发布日期</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody  id="items">
					<c:forEach items="${newss }" var="news">
					<tr>
						<td><a href="/news/${news.N_ID }">${news.N_TITLE }</a></td>
						<td>${news.N_DATE }</td>
						<td>
							<a class="btn btn-info" href="/news/edit/${news.N_ID}">编辑</a>
							<button id="btn" class="btn btn-danger" onclick="drop(this);" targetid="${news.N_ID}">删除</button>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<%@include file="footer.jsp" %>
	</div>
	<script>
		function drop(btn){
			var nid = $(btn).attr('targetid');
			var tr = $(btn).parent().parent();
			var td = tr.find('td')[0];
			var text = $(td).find('a').html();
			if(confirm('是否删除'+text)){
				$.get('/news/delete/'+nid);
				tr.remove();
			}else{
				
			}
		}
	</script>
</body>
</html>