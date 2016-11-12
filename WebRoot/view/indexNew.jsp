<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>信息门户</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
		<link href="/static/css/bootstrap.css" type="text/css" rel="stylesheet"/>
        <link href="/static/css/portal.css" type="text/css" rel="stylesheet"/>
        <link href="/static/css/component.css" type="text/css" rel="stylesheet"/>
		<script src="/static/js/jquery-2.1.4.js"></script>
        <script src="/static/js/jquery-ui.min.js" ></script>
        <script src="/static/js/bootstrap.min.js" ></script>
        <script src="/static/js/myjs/portals.js" ></script>
        <script src="/static/js/myjs/index.js" ></script>
        <script src="/static/js/myjs/classie.js" ></script>
        
	</head>
    <body>
    	<div style="position:fixed;top:0;right:0.5%;cursor:pointer;font-size:25px;" id="showRight"> 
    		<span class="glyphicon glyphicon-backward"></span>
    	</div>
    	<div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="rightMenu">
	        <span style="font-size:25px;float:right;cursor:pointer;" class="glyphicon glyphicon-forward" id="disRight"></span> 
	    	<a style="cursor:pointer;" onclick="saveList();">保存当前布局</a>
	        <a href="/manager">管理</a>
	    </div>
        <div class="header row">
            <div class="col-md-1 col-lg-1">
                <img class="img-responsive" src="/static/image/logo.png">
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
            	<a style="float:right;" href="/logout">退出</a>     	
            </c:if>
            </div>
        </div>
        <div class="bodys">
	        <div class="appdiv row" id="apps">
	        <c:forEach items="${apps }" var="app">
	            <div class="col-md-1 col-sm-3"><center>
	            <a href="${app.A_URL }"><img class="img-responsive img-circle" alt="${app.A_NAME }" src="/static/icon/${app.A_ICON }"/>
	            <span>${app.A_NAME }</span>
	            </a>
	            </center></div>    
	        </c:forEach>
	        </div>
	        <div class="modules row" id="show_modules">
	        </div>
	        <div class="manager row">
	        	<button class="btn btn-success" onclick="saveList();">保存当前布局</button>
	        	<a class="btn btn-success" href="/manager">管理</a>
	        </div>
	        </div>
        <div>
    	<%@include file="footer.jsp" %>
    	<div style="display:none">
    		<div id="queue">${user.U_LIST }</div>
    	</div>
    	</div>
    </body>
    <script type="text/javascript">
    	genModules();
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
			disableOther('showRight');
		};
		disRight.onclick = function(){
			classie.toggle(this,'active');
			classie.toggle(rightMenu,'cbp-spmenu-open');
			disableOther('showRight');
		}
    </script>
</html>