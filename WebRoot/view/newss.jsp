<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${base_path}/static/css/bootstrap.css" />
        <script src="${base_path}/static/js/base.js" ></script>
<script src="${base_path}/static/js/jquery-2.1.4.js"></script>
<title>水利新闻</title>
</head>
<body>
	<div style="width:80%;margin:10%;">
	<h2 style="text-align:center;">${dm.DM_NAME }</h2>
	<table class="table table-condensed table-hover"><tbody>
		<c:forEach items="${newss }" var="news">
			<tr>
				<td width="1%"><span style="color:#0030bd;" class="glyphicon glyphicon-tint"></span></td>
				<td><a href="${base_path}/news/${news.N_ID}">${news.N_TITLE }</a></td>
				<td>${news.N_AUTHER }</td>
				<td>${news.N_DATE }</td>
			</tr>
		</c:forEach>
	</tbody></table>
	</div>
</body>
</html>