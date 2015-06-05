<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>person</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/bootstrap-theme.min.css">
<script src="/js/jquery-1.11.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/general.js"></script>
<script src="/js/person/person.js"></script>
</head>
<body>
  <nav class="navbar navbar-default">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#spring-boot-demo-navbar-collpase">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">Spring Boot Demo</a>
      </div>
      <div class="navbar-collapse collapse" id="spring-boot-demo-navbar-collpase">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="/person">person</a></li>
          <li><a href="/country">country</a>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
              ${sessionUser.username }
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="/user">My Profile</a></li>
              <li class="divider"></li>
              <li><a href="/user/logout">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">
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
  </div>
</body>
</html>