<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <h1>학생 ${ user.id > 0 ? "수정" : "등록" }</h1>
  <hr />
  <form:form method="post" modelAttribute="user">  
    <div class="form-group">
      <label>패스워드:</label>
      <form:input path="password" class="form-control w200" />
    </div>
    
    <div class="form-group">
      <label>학번:</label>
      <form:input path="userid" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>이름:</label>
      <form:input path="name" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>email</label>
    <form:input path="email" class="form-control w200" />
    
    </div>
    <div class="form-group">
      <label>departmnetId</label>
    <form:input path="departmentId" class="form-control w200" />
    
    </div>
    
    <div class="form-group">
      <label>enabled:</label>
      <form:input path="enabled" class="form-control w200" />
    </div>
    
    
    
    <div class="form-group">
      <label>userType:</label>
      <form:input path="userType" class="form-control w200" />
    </div>
    <hr />
    <div>
      <button type="submit" class="btn btn-primary">
        <span class="glyphicon glyphicon-ok"></span> 저장</button>
      <c:if test="${ user.id > 0 }">
        <a href="delete.do?id=${ user.id }" class="btn btn-danger" data-confirm-delete>
          <i class="glyphicon glyphicon-remove"></i> 삭제</a>
      </c:if>
      <a href="userList.do" class="btn btn-info">목록으로</a>
    </div>
  </form:form>
</div>
</body>
</html>
