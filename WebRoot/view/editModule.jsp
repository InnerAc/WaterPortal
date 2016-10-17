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
<title>编辑模块</title>
</head>
<body>
	<div style="width:90%;margin:5%;">
		<div>
			<h1 style="text-align:center">展示模块添加</h1>
		</div>
		<br><br>
		<form class="form-inline" action="/module/edit" method="post">
			<div style="display:none">
				<input name="DM_ID" type="hidden" value="${dm.DM_ID }"/>
			</div>
			<div class="form-inline">
				模块名称:
				<input class="form-control" name="DM_NAME" type="text" value="${dm.DM_NAME }">
			</div><br>
			<div class="form-inline">
				所属部门:
				<input class="form-control" name="DM_SERVICE" type="text" value="${dm.DM_SERVICE }">
			</div><br>
			<div class="form-inline">
				展示尺寸:
				<select class="form-control" name="DM_SIZE">
					<option value="1" <c:if test="${dm.DM_SIZE=='1'}"> selected="selected" </c:if> >正常尺寸</option>
					<option value="2" <c:if test="${dm.DM_SIZE=='2'}"> selected="selected" </c:if>>长</option>
					<option value="3" <c:if test="${dm.DM_SIZE=='3'}"> selected="selected" </c:if>>超长</option>
				</select>
			</div><br>
			<div class="form-inline">
				模块管理员(输入用户登录名使用英文逗号隔开):<br>
				<input class="form-control" name="DM_EDIT" type="text" value="${dm.DM_EDIT }">
			</div><br>
			<div class="form-inline">
				信息发布员(输入用户登录名使用英文逗号隔开):<br>
				<input class="form-control" name="DM_ISSUED" type="text" value="${dm.DM_ISSUED }">
			</div><br>
			<div class="form-inline">
				允许所有人查看:
				<select class="form-control" name="DM_SHOWALL">
					<option value="1" <c:if test="${dm.DM_SHOWALL== '1'}"> selected="selected" </c:if> >允许</option>
					<option value="0" <c:if test="${dm.DM_SHOWALL== '0'}"> selected="selected" </c:if>>不允许</option>
				</select>
			</div><br>
			如果允许所有人访问，下面的不需要填写<br>
			<div class="form-inline">
				可查看该模块的部门(输入部门名称使用英文逗号隔开):<br>
				<input class="form-control" name="DM_SHOWSERVICE" type="text" value="${dm.DM_SHOWSERVICE }">
			</div><br>
			<div class="form-inline">
				可查看该模块的用户(输入用户登录名使用英文逗号隔开):<br>
				<input class="form-control" name="DM_SHOWUSER" type="text" value="${dm.DM_SHOWUSER }">
			</div><br>
			
			<input class="btn btn-primary" value="提交 " type="submit">&nbsp;&nbsp;
			<a class="btn btn-warning" href="/module/manager">返回</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-danger" onclick="drop('${dm.DM_ID}','${dm.DM_NAME}')">删除</button>
		</form>
	</div>
		<script>
		function drop(dmid,dmname){
			console.log(dmid)
			if(confirm('是否删除'+dmname)){
				$.get('/module/delete/'+dmid,function(){
					window.location.href = '/module/manager';
				});
				
			}else{
				
			}
		}
	</script>
</body>
</html>