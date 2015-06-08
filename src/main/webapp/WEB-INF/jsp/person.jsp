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
<link rel="stylesheet" type="text/css" href="/css/person/person.css">
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
        <legend>All Person:</legend>
        <div id="person_search" class="form-inline">
          <div class="form-group">
            <label for="name_key" class="control-label">name:</label>
            <input type="text" class="form-control" id="name_key" placeholder="name" />
          </div>
          <div class="form-group">
            <label for="email_key" class="control-label">email:</label>
            <input type="text" class="form-control" id="email_key" placeholder="email" />
          </div>
          <div class="form-group">
            <label for="age_min" class="control-label">min age</label>
            <input type="number" class="form-control" id="age_min" min="0" max="100" placeholder="min age" />
          </div>
          <div class="form-group">
            <label for="age_max" class="control-label">max age</label>
            <input type="number" class="form-control" id="age_max" min="0" max="100" placeholder="max age" />
          </div>
          <div class="form-group">
            <label for="gender_key" class="control-label">gender:</label>
            <select class="form-control" id="gender_key">
              <option value="all">All</option>
              <option value="male">male</option>
              <option value="female">female</option>
            </select>
          </div>
          <div class="form-group">
            <a class="btn btn-default" id="search_person">Search</a>
          </div>
        </div>
        <div id="person_info">
          <table class="table">
            <thead>
              <tr>
                <th>#</th>
                <th>name</th>
                <th>email</th>
                <th>age</th>
                <th>gender</th>
                <th>country</th>
              </tr>
            </thead>
            <tbody></tbody>
          </table>
        </div>
        <div class="pagination">
          <a class="previous btn btn-default">previous</a>
          <span class="number"></span>/<span class="totalPages"></span>
          <a class="next btn btn-default">next</a>
        </div>
      </fieldset>
      <fieldset>
        <legend>Add Person</legend>
        <form class="form-inline" id="add_person">
          <div class="form-group">
            <label for="name" class="control-label">name:</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="name" />
          </div>
          <div class="form-group">
            <label for="email" class="control-label">email:</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="email" />
          </div>
          <div class="form-group">
            <label for="age">age:</label>
            <input type="number" class="form-control" name="age" id="age" min="1" max="100" value="20" />
          </div>
          <div class="form-group">
            <label for="gender" class="control-label">gender:</label>
            <select name="gender" id="gender" class="form-control">
              <option value="male">male</option>
              <option value="female">female</option>
            </select>
          </div>
          <div class="form-group">
            <button class="btn btn-primary" type="submit">Add</button>
          </div>
        </form>
      </fieldset>
    </div>
  </div>
</body>
</html>