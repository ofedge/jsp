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
<script src="/js/country.js"></script>
</head>
<body>
	<c:if test="${!empty loginUser }">
	  <p>welcome, ${loginUser }. <a href="/logout">logout</a></p>
	</c:if>
	<div id="switch_btn">
	  <input type="button" id="show_person" value="person" />
	  <input type="button" id="show_country" value="country" />
	</div>
	<div id="content">
	  <div id="person">
	    <fieldset>
	      <legend>Person</legend>
		  <fieldset>
			<legend>All Person:</legend>
			<div id="person_info">&nbsp;</div>
			<div class="pagination">
			  <input type="button" class="previous" value="previous"  />
			  <span class="number"></span>/<span class="totalPages"></span>
			  <input type="button" class="next" value="next" />
			</div>
		  </fieldset>
		  <fieldset>
		    <legend>add person</legend>
		    <form id="add_person">
		      <label for="name">name: </label>
			  <input type="text" name="name" id="name" />
			  <label for="email">email: </label>
			  <input type="email" name="email" id="email" />
			  <label for="age">age: </label>
			  <input type="number" name="age" id="age" min="1" max="100" value="20" />
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
			<legend>Search</legend>
			<p>name: <input id="name_key" /><input type="button" value="search" id="name_search"></p>
			<p id="name_area">&nbsp;</p>
			<p>email: <input id="email_key" /><input type="button" value="search" id="email_search"></p>
			<p id="email_area">&nbsp;</p>
		  </fieldset>
	    </fieldset>
	  </div>
	  <div id="country">
	    <fieldset>
	      <legend>Country</legend>
		  <fieldset>
		    <legend>Countries: </legend>
		    <div id="country_info">&nbsp;</div>
		    <div class="pagination">
			  <input type="button" class="previous" value="previous"  />
			  <span class="number"></span>/<span class="totalPages"></span>
			  <input type="button" class="next" value="next" />
			</div>
		  </fieldset>
		  <fieldset>
		  	<legend>Search</legend>
		  	<p>country name: <input id="country_key" /><input type="button" value="search" id="country_search"></p>
		  	<p id="country_area">&nbsp;</p>
		  </fieldset>
	    </fieldset>
	  </div>
	</div>
</body>
</html>