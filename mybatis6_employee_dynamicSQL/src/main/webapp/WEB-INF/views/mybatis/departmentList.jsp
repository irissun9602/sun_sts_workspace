<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<h1>부서별 학생 목록</h1>
		<hr />

		<c:forEach var="department" items="${ departments }">
			<h3>${ department.name }
				<small>${ department.employees.size() }명</small>
			</h3>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th> 이름</th>
						<th>부서명</th>
					
						<th>시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${ department.employees }">
						<tr>
							<td>${employee.id }</td>
							<td>${ employee.name }</td>
							<td>${department.name }</td>
							<td><fmt:formatDate pattern="HH:mm:ss"
									value="${ employee.time }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>
	</div>
</body>
</html>
