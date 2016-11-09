<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<script src="/static/js/myjs/pullmodule.js"></script>
<script src="/static/js/myjs/index.js"></script>
<style type="text/css">
table{
	table-layout: fixed;
}
td{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.icon{
	width:fill;
}
.allborder{
	border-style:solid;
	border-width: 1px;
	border-radius:5%;
}
</style>
<title>首页</title>
</head>
<body>
	<div style="width:90%;margin:5%;margin-top:1%;">
		<div>
			<div style="float:left"><img style="width:80%;" src="/static/image/logo.png"></div>
			<div>
				<h2>江苏省水利厅门户系统</h2>
				<h5>Jiangsu Water Resources Portal</h5>
			</div>
		</div>
		<br><br>
		<div class="panel panel-default">
			<div class="panel-body">
			<div class="col-md-10">
			<c:forEach items="${apps }" var="app">
				<div class="col-md-1"><center>
				<a href="${app.A_URL }"><img class="img-responsive" alt="${app.A_NAME }" src="/static/icon/${app.A_ICON }"/>
				<span>${app.A_NAME }</span>
				</a>
				</center></div>
			</c:forEach>
			</div>
			<div class="col-md-2 panel-default">
				<div class="panel-body">
					<c:if test="${userid==null }">
					<form class="form-horizontal" action="/login" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" name="userid" placeholder="用户名"/>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="pwd" placeholder="密码"/>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</form>
					</c:if>
					<c:if test="${userid !=null }">
						<a href="/logout" class="btn btn-warning">退出</a>
						<a href="/manager" class="btn btn-success">管理</a>
					</c:if>
				</div> 
			</div>
			</div>
		</div>
		<br>
		<div class="row">
			
		</div>
		<br>
		<div class="row">
			<div id="617712578"></div>
			<div id="581266426"></div>
			<div id="378088830"></div>
			<div class="col-md-4">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">实时水雨情</h3>
				</div>
				<div class="panel-body">
					<img class="col-md-12" src="/static/image/sssyq.PNG">
				</div>
			</div>
			</div>
			<div class="col-md-4">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">实时视频</h3>
				</div>
				<div class="panel-body">
					<img class="col-md-12" src="/static/image/sssp.jpg">
				</div>
			</div>
			</div>
			<div class="col-md-4">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">实时工情</h3>
				</div>
				<div class="panel-body">
					<img class="col-md-12" src="/static/image/ssgq.jpg">
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>