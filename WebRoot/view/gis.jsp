<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${base_path}/static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${base_path}/static/gis/ol.css" />
<script src="${base_path}/static/js/base.js" ></script>
<script src="${base_path}/static/js/jquery-2.1.4.js"></script>
<script src="${base_path}/static/gis/ol.js"></script>
<script src="${base_path}/static/gis/olmap.js"></script>
<title>实时水雨情</title>
<style type="text/css">
.ol-popup {
position: absolute;
background-color: white;
-webkit-filter: drop-shadow(0 1px 4px rgba(0,0,0,0.2));
filter: drop-shadow(0 1px 4px rgba(0,0,0,0.2));
padding: 15px;
border-radius: 10px;
border: 1px solid #cccccc;
bottom: 12px;
left: -50px;
min-width: 140px;
}
.ol-popup:after, .ol-popup:before {
top: 100%;
border: solid transparent;
content: " ";
height: 0;
width: 0;
position: absolute;
pointer-events: none;
}
.ol-popup:after {
border-top-color: white;
border-width: 10px;
left: 48px;
margin-left: -10px;
}
.ol-popup:before {
border-top-color: #cccccc;
border-width: 11px;
left: 48px;
margin-left: -11px;
}
.ol-popup-closer {
text-decoration: none;
position: absolute;
top: 2px;
right: 8px;
}
.ol-popup-closer:after {
content: "✖";
}
</style>
</head>
<body>
<div id="mapMain" style="width:100%;">
</div>
<div id="popup" class="ol-popup">
	<a href="#" id="popup-closer" class="ol-popup-closer"></a>
	<div id="popup-content"></div>
</div>
</body>
</html>