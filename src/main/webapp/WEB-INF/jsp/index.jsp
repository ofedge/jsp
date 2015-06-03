<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>index</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="/css/general.css">
<script src="/js/jquery-1.11.2.min.js" ></script>
<script src="/js/general.js"></script>
</head>
<body>
	<fieldset>
		<legend>login</legend>
		<form action="/login" method="post">
			<p>username: <input type="text" name="username", id="username" /></p>
			<p>password: <input type="password", name="password", id="password" /></p>
			<p><input type="submit" value="login" id="login" /></p>
		</form>
	</fieldset>
</body>
</html>