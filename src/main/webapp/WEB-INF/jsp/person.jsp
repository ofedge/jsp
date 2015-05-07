<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>person</title>
<link rel="stylesheet" type="text/css" href="/css/general.css">
<script src="/js/jquery-1.11.2.min.js"></script>
<script src="/js/general.js"></script>
<script src="/js/person.js"></script>
</head>
<body>
	<fieldset>
		<legend>add person</legend>
		<form id="add_person">
			<p>name: <input type="text" name="name" id="name" />
			email: <input type="email" name="email" id="email" />
			<input type="submit" value="submit" /></p>
			<p id="form_area">&nbsp;</p>
		</form>
	</fieldset>
	<fieldset>
		<legend>All Person:</legend>
		<p id="info">&nbsp;</p>
	</fieldset>
	<fieldset>
		<legend>Search</legend>
		<p>name: <input name="name_key" id="name_key" /><input type="button" value="search" id="name_search"></p>
		<p id="name_area">&nbsp;</p>
		<p>email: <input name="email_key" id="email_key" /><input type="button" value="search" id="email_search"></p>
		<p id="email_area">&nbsp;</p>
	</fieldset>
</body>
</html>