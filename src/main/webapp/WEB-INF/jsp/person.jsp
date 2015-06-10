<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
          <div class="form-group col-sm-3">
            <label for="name_key" class="control-label">name:</label>
            <input type="text" class="form-control" id="name_key" placeholder="name" />
          </div>
          <div class="form-group col-sm-4">
            <label for="email_key" class="control-label">email:</label>
            <input type="text" class="form-control" id="email_key" placeholder="email" />
          </div>
          <div class="form-group col-sm-2">
            <label for="age_min" class="control-label">min age</label>
            <input type="number" class="form-control" id="age_min" min="0" max="100" placeholder="min age" />
          </div>
          <div class="form-group col-sm-2">
            <label for="age_max" class="control-label">max age</label>
            <input type="number" class="form-control" id="age_max" min="0" max="100" placeholder="max age" />
          </div>
          <div class="form-group col-sm-3">
            <label for="gender_key" class="control-label">gender:</label>
            <select class="form-control" id="gender_key">
              <option value="all">All</option>
              <option value="male">male</option>
              <option value="female">female</option>
            </select>
          </div>
          <div class="form-group col-sm-4">
            <label for="country_key" class="control-label">country:</label>
            <input type="text" class="form-control" id="country_key" placeholder="country" />
          </div>
          <div class="form-group col-sm-2">
            <button class="btn btn-default" id="search_person">
              <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
              <span>Search</span>
            </button>
          </div>
          <div class="form-gropu col-sm-2">
            <button type="button" class="btn btn-default" id="add_person">
              <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
              <span>Add</span>
            </button>
          </div>
        </div>
        <div class="clearfix"></div>
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
                <th>option</th>
              </tr>
            </thead>
            <tbody></tbody>
          </table>
        </div>
        <div class="pagination">
          <a class="previous btn btn-default">previous</a>
          <span class="number"></span>/<span class="totalPages"></span>(<span class="totalElements"></span>)
          <a class="next btn btn-default">next</a>
        </div>
      </fieldset>
    </div>
  </div>
  <div class="modal fade" id="add_person_modal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
          <h4>Add Person</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" id="add_person_form">
            <div class="form-group">
              <label for="name" class="control-label col-sm-2">name:</label>
              <div class="col-sm-9">
                <input type="text" class="form-control" name="name" id="name" placeholder="name" />
              </div>
            </div>
            <div class="form-group">
              <label for="email" class="control-label col-sm-2">email:</label>
              <div class="col-sm-9">
                <input type="email" class="form-control" name="email" id="email" placeholder="email" />
              </div>
            </div>
            <div class="form-group">
              <label for="age" class="control-label col-sm-2">age:</label>
              <div class="col-sm-9">
                <input type="number" class="form-control" name="age" id="age" min="1" max="100" />
              </div>
            </div>
            <div class="form-group">
              <label for="gender" class="control-label col-sm-2">gender:</label>
              <div class="col-sm-9">
                <select name="gender" id="gender" class="form-control">
                  <option value="unknown">please choose</option>
                  <option value="male">male</option>
                  <option value="female">female</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label for="country_id" class="control-label col-sm-2">country:</label>
              <div class="col-sm-9">
                <select name="countryId" id="country_id" class="form-control"></select>
              </div>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary" id="save_person">Save</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>