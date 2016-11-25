<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="0.1; url=${base_path}${url }"/>
<link rel="stylesheet" type="text/css" href="${base_path}/static/css/bootstrap.css" />
        <script src="${base_path}/static/js/base.js" ></script>
<script src="${base_path}/static/js/jquery-2.1.4.js"></script>
<title>首页</title>
</head>
<body>
	<div style="width:90%;margin:5%;">
		<div>
			<h1 style="text-align:center">${info }</h1>
		</div>
		<br><br>
		<span style="text-align:center">1秒钟将调到目标页面，<a href="${base_path}${url }">直接跳转点击这里</a></span>
	</div>
</body>
</html>