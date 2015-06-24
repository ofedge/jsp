<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>country</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<script src="/js/jquery-1.11.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-paginator.min.js"></script>
<script src="/js/general.js"></script>
<script src="/js/country/country.js"></script>
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
    <div id="country">
      <fieldset>
        <legend>Countries: </legend>
        <div id="country_info">
          <table class="table">
            <thead>
              <tr>
                <th>#</th>
                <th>name</th>
                <th>region</th>
                <th>code</th>
              </tr>
            </thead>
            <tbody></tbody>
          </table>
        </div>
        <div class="pagination">
          <ul id="pagination"></ul>
        </div>
      </fieldset>
    </div>
  </div>
</body>
</html>