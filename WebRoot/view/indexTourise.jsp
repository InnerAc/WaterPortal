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
            <div id="userInfo" class="col-md-3 col-lg-3" style="float:right;text-align:right;">
            <form class="bs-example bs-example-form" role="form" method=POST action="http://127.0.0.1:8080/NewSearchUI/searchIndex" target="_blank">
               <div class="input-group">
                   <input type="text" name="queryword" class="form-control" placeholder="水利垂直搜索">
                   <span class="input-group-btn">
                       <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
                   </span>
               </div>
		    </form>
            <c:if test="${user==null }">
                <br>
                <span style="cursor:pointer;" onclick="login();">登录</span>
            </c:if>
            <c:if test="${user!= null }">
            	<h3 >${user.U_SERVICE }:${user.U_NAME }</h3>
            	<a href="${base_path}/">主页</a>
            	<a href="${base_path}/logout">退出</a>     	
            </c:if>
            </div>
        </div>
        <div class="bodys">
	        <div class="appdiv row" id="apps">
	        </div>
	        <div class="modules row" id="show_modules">
	        </div>
	        </div>
        <div>
    	<%@include file="footer.jsp" %>
    	<div style="display:none">
    		<div id="dm_queue">youke</div>
    		<div id="app_queue">youke</div>
    		<div id="service_name">${user.U_SERVICE }</div>
    		<div id="token">${user.U_TOKEN }</div>
    		<div id="userid">${user.U_USERID }</div>
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