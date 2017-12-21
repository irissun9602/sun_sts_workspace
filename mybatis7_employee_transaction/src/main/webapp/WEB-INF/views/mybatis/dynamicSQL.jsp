<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
  <div class="container">
	<h1>dynamicSQL</h1>
	<hr />
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th>id</th>
	      <th>name</th>
	      <th>departmentId</th> <th>departmentName</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr><td colspan="4">list1</td></tr>
	    <c:forEach var="user" items="${ list1 }">
	      <tr>
	        <td>${ user.id }</td>
	        <td>${ user.name }</td>
            <td>${ user.departmentId }</td>            
            <td>${ user.departmentName }</td>
	      </tr>
	    
	    </c:forEach>
	  </tbody>
	</table>
  </div>
</body>
</html>