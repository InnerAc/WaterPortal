<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>信息门户</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
		<link href="${base_path}/static/css/bootstrap.css" type="text/css" rel="stylesheet"/>
        <link href="${base_path}/static/css/portal.css" type="text/css" rel="stylesheet"/>
        <link href="${base_path}/static/css/component.css" type="text/css" rel="stylesheet"/>
        <script src="${base_path}/static/js/base.js" ></script>
		<script src="${base_path}/static/js/jquery-2.1.4.js"></script>
        <script src="${base_path}/static/js/jquery-ui.min.js" ></script>
        <script src="${base_path}/static/js/bootstrap.min.js" ></script>
        <script src="${base_path}/static/js/myjs/portals.js" ></script>
        <script src="${base_path}/static/js/myjs/index.js" ></script>
        <script src="${base_path}/static/js/myjs/classie.js" ></script>
        
	</head>
    <body>
    	<div style="position:fixed;top:0;right:0.5%;cursor:pointer;font-size:25px;" id="showRight"> 
    		<span class="glyphicon glyphicon-backward"></span>
    	</div>
    	<div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="rightMenu">
	        <span style="font-size:25px;float:right;cursor:pointer;" class="glyphicon glyphicon-forward" id="disRight"></span> 
	        <a href="${base_path}/manager">管理</a>
	    	<a style="cursor:pointer;" onclick="saveList();">保存当前布局</a>
	    </div>
        <div class="header row">
            <div class="col-md-1 col-lg-1">
                <img class="img-responsive" src="${base_path}/static/image/logo.png">
            </div>
            <div class="col-md-8 col-lg-8" >
                <h1>江苏省水利厅门户系统</h1>
                <h3>Jiangsu Water Resources Portal</h3>
            </div>
            <div id="userInfo" class="col-md-3 col-lg-3">
            <c:if test="${user==null }">
                <br><br><br>
                <span style="float:right;cursor:pointer;" onclick="login();">登录</span>
            </c:if>
            <c:if test="${user!= null }">
            	<h3 style="float:right;">${user.U_SERVICE }:${user.U_NAME }</h3><br><br> 
            	<a style="float:right;" href="${base_path}/logout">退出</a>     	
            </c:if>
            </div>
        </div>
        <div class="bodys">
	        <div class="appdiv row" id="apps">
	        <c:forEach items="${apps }" var="app">
	            <div class="col-md-1 col-sm-3"><center>
	            <a href="${app.A_URL }"><img class="img-responsive img-circle" alt="${app.A_NAME }" src="${base_path}/static/icon/${app.A_ICON }"/>
	            <span>${app.A_NAME }</span>
	            </a>
	            </center></div>    
	        </c:forEach>
	        </div>
	        <div class="modules row" id="show_modules">
	        </div>
	        </div>
        <div>
    	<%@include file="footer.jsp" %>
    	<div style="display:none">
    		<div id="dm_queue">${user.U_LIST }</div>
    		<div id="app_queue">${user.U_APPS }</div>
    	</div>
    	</div>
    </body>
    <script type="text/javascript">
    	genModules();
    	genAPPS();
		$(function() {
   		    $("#show_modules").sortable({
				handle: ".glyphicon-move",
			});
   		    $("#show_modules").disableSelection();
   		    $('#apps').sortable();
   		    $('#apps').disableSelection();
   		    });
		rightMenu = document.getElementById('rightMenu');
		showRight = document.getElementById('showRight');
		disRight = document.getElementById('disRight');
		showRight.onclick = function(){
			classie.toggle(this,'active');
			classie.toggle(rightMenu,'cbp-spmenu-open');
		};
		disRight.onclick = function(){
			classie.toggle(this,'active');
			classie.toggle(rightMenu,'cbp-spmenu-open');
		}
    </script>
</html>