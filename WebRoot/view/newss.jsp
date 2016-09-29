<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<title>水利新闻</title>
</head>
<body>
	<div style="width:80%;margin:10%;">
	<table class="table table-condensed table-hover"><tbody>
		<c:forEach items="${newss }" var="news">
			<tr>
				<td>${news.N_service }</td>
				<td><a href="/news/${news.N_id}">${news.N_title }</a></td>
				<td>${news.N_author }</td>
				<td>${news.N_date }</td>
			</tr>
		</c:forEach>
	</tbody></table>
	</div>
</body>
</html>