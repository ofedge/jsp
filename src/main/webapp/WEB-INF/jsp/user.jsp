<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/css/fileinput.min.css">
<script src="/js/jquery-1.11.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/fileinput.min.js"></script>
<script src="/js/general.js"></script>
<script src="/js/user/user.js"></script>
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
    <div class="media">
      <div class="media-left">
        <img alt="avatar" src="/avatar/${sessionUser.avatar}" class="media-object img-rounded" width="96" height="96" />
      </div>
      <div class="media-body">
        <form action="/user/updateProfile" method="post" enctype="multipart/form-data" class="col-sm-7">
          <div class="form-group">
            <label for="avatar" class="control-label">avatar</label>
            <input name="avatar" id="avatar" type="file" class="form-control" data-show-upload="false" accept="image/*" />
            <p class="help-block">less than 1MB</p>
          </div>
          <div class="form-group">
            <label for="realname" class="control-label">realname</label>
            <input name="realname" id="realname" type="text" class="form-control" value="${sessionUser.realname }" />
          </div>
          <div class="form-group">
            <label for="eamil" class="control-label">email</label>
            <input name="email" id="email" type="email" class="form-control" value="${sessionUser.email }" />
          </div>
          <div class="form-group">
            <label for="gender" class="control-label">gender</label>
            <select name="gender" id="gender" class="form-control" value="${sessionUser.gender }">
              <option value="male">male</option>
              <c:choose>
                <c:when test="${sessionUser.gender == 'female'}">
                  <option value="female" selected="selected">female</option>
                </c:when>
                <c:otherwise>
                  <option value="female">female</option>
                </c:otherwise>
              </c:choose>
            </select>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary">Update profile</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>