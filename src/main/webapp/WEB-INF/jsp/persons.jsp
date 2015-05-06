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
<script src="js/general.js"></script>
</head>
<body>
	Person info:
	<c:forEach items="${persons }" var="person">
		name: ${person.name }, email: ${person.email }<br />
	</c:forEach>
</body>
</html>