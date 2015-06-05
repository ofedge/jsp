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
        <legend>All Person:</legend>
        <div id="person_info">
          <table class="table">
            <thead>
              <tr>
                <th>#</th>
                <th>name</th>
                <th>email</th>
                <th>age</th>
                <th>gender</th>
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
      <fieldset>
        <legend>Search</legend>
        <form class="form-horizontal">
          <div class="form-group">
            <label for="name_key" class="control-label col-sm-2">input name to search:</label>
            <div class="col-sm-3">
              <input type="text" id="name_key" class="form-control col-sm-3" placeholder="name" />
            </div>
            <a class="btn btn-default col-sm-1" id="name_search">search</a>
          </div>
          <div id="name_area">
            <table class="table">
              <thead>
                <tr>
                  <th>#</th>
                  <th>name</th>
                  <th>email</th>
                  <th>age</th>
                  <th>gender</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>
          <hr />
          <div class="form-group">
            <label for="email_key" class="control-label col-sm-2">input email to search:</label>
            <div class="col-sm-3">
              <input type="text" id="email_key" class="form-control col-sm-3" />
            </div>
            <a class="btn btn-default col-sm-1" id="email_search">search</a>
          </div>
          <div id="email_area">
            <table class="table">
              <thead>
                <tr>
                  <th>#</th>
                  <th>name</th>
                  <th>email</th>
                  <th>age</th>
                  <th>gender</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>
        </form>
      </fieldset>
    </div>
  </div>
</body>
</html>