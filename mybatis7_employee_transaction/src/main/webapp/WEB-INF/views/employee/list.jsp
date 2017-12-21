<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
	<div class="container">
		<h1>직원목록</h1>
		<c:if test="${ employee.id > 0 }">
        <a href="delete.do?id=${ employee.id }" class="btn btn-danger" data-confirm-delete>
          <i class="glyphicon glyphicon-remove"></i> 삭제</a>
      </c:if>
      
		<div class="pull-right mb5">
			<a href="create.do" class="btn btn-info"> <span
				class="glyphicon glyphicon-user"></span>직원등록
			</a>
		</div>
		<select name="orderIndex">
			<option value ="0"> ID 내림차순</option>
			<option value ="1"> 이름 순서</option>
			<option value ="2"> 학번 순서</option>
		</select>
		<table class="table table-bordered mt5">
			<thead>
				<tr>
					<th>id</th>
					<th>이름</th> 
					<th>부서번호</th>
					<th>부서명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${ employees }">
					<tr data-url="edit.do?id=${ employee.id }">
						<td>${ employee.id }</td>
						<td>${ employee.name }</td>
						<td>${ employee.departmentId }</td>
						<td>${ employee.departmentName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>