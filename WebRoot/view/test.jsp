<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/static/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="/static/css/summernote.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/summernote.min.js"></script>
<title>测试页面</title>
</head>
<body>
	<form action="#">
  <div class="form-group">
    <label for="input">Text</label>
    <input type="text" class="form-input" id="input" value="Title">
  </div>
  <div class="form-group">
    <label for="contents">Contents</label>
    <textarea name="text" class="summernote" id="contents" title="Contents"></textarea>
  </div>
  <button type="submit" class="btn btn-default">submit</button>
</form>
  <script type="text/javascript">
    $(function() {
      $('.summernote').summernote({
        height: 200
      });

      $('form').on('submit', function (e) {
        e.preventDefault();
        alert($('.summernote').summernote('code'));
        alert($('.summernote').val());
      });
    });
  </script>
</body>
</html>