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
	<div>
		<h1 style="text-align:center">${news.N_TITLE }</h1>
		<h6 style="text-align:right">${news.N_DATE }</h6>
	</div>
	<div>
		${news.N_CONTENT }
	</div>
	<div>
		<c:if test="${news.N_PICSRC != null}">
		<br>
		<br>
		<hr style="border-color:#000; border-top:dotted " />
			附件：<a target="_Blank" href="${base_path }/file?file=${news.N_PICSRC}">${news.N_PICSRC}</a>
		</c:if>
	</div>
	<%@include file="footer.jsp" %>
	</div>
</body>
</html>