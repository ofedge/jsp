<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sing up</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/bootstrap-theme.min.css">
<script src="/js/jquery-1.11.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/general.js"></script>
<script src="js/user/signup.js"></script>
</head>
<body>
  <nav class="navbar navbar-default">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#spring-boot-demo-navbar-collpase">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">Spring Boot Demo</a>
      </div>
      <div class="collapse navbar-collapse" id="spring-boot-demo-navbar-collpase">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="/signup">Sign up</a></li>
          <li><a href="/signin">Sign in</a>
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">
    <div class="jumbotron">
      <form class="form-horizontal" action="/user/register" method="post" id="signup">
        <div class="form-group has-feedback">
          <label for="username" class="col-sm-2 control-label">username</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" id="username" name="username" placeholder="username"
            data-container="body" data-toggle="popover" data-placement="right" data-content="" tabindex="1" />
            <span class="glyphicon glyphicon-user form-control-feedback" aria-hidden="true"></span>
          </div>
        </div>
        <div class="form-group has-feedback">
          <label for="password" class="col-sm-2 control-label">password</label>
          <div class="col-sm-5">
            <input type="password" class="form-control" id="password" name="password" placeholder="password"
            data-container="body" data-toggle="popover" data-placement="right" data-content="" tabindex="2" />
            <span class="glyphicon glyphicon-lock form-control-feedback" aria-hidden="true"></span>
          </div>
        </div>
        <div class="form-group has-feedback">
          <label for="repassword" class="col-sm-2 control-label">confirm password</label>
          <div class="col-sm-5">
            <input type="password" class="form-control" id="repassword" placeholder="repassword"
            data-container="body" data-toggle="popover" data-placement="right" data-content="" tabindex="3" />
            <span class="glyphicon glyphicon-lock form-control-feedback" aria-hidden="true"></span>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-1 col-sm-5">
            <button type="submit" class="btn btn-primary" tabindex="4">Sign up</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</body>
</html>