<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<c:if test="${!empty loginUser }">
	  <p>welcome, ${loginUser }. <a href="/logout">logout</a></p>
	</c:if>
	<fieldset>
	  <legend>add person</legend>
	  <form id="add_person">
		<label for="name">name: </label>
		<input type="text" name="name" id="name" />
		<label for="email">email: </label>
		<input type="email" name="email" id="email" />
		<label for="age">age: </label>
		<input type="number" name="age" id="age" min="10" max="30" value="20" />
		<label for="gender">gender: </label>
		<select name="gender" id="gender">
		  <option value="male">male</option>
		  <option value="female">female</option>
		</select>
		<input type="submit" value="submit" />
	  </form>
	  <p id="form_area">&nbsp;</p>
	</fieldset>
	<fieldset>
	  <legend>All Person:</legend>
	  <div id="info">&nbsp;</div>
	  <div id="pagination">
	  	<input type="button" id="previous" value="previous"  />
	  	<span id="number"></span>/<span id="totalPages"></span>
	  	<input type="button" id="next" value="next" />
	  </div>
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