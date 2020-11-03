<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HRMS 1.0</title>
<link rel="stylesheet" type="text/css" href="./assets/bootstrap.min.css">
</head>
<body>
	<div class="alert alert-primary">
		<div class="container">
			<h1>HR Management System - v1.0</h1>
		</div>
	</div>
	
	<div class="container">
		<div>
			<a href="./">Home</a> |
			<a href="./emps-by-sal-range">Search employees by salary range</a>
		</div>
		<br><br>
		
		<h3>List of employees earning salary betwen \$${param.min} \$${param.max}</h3>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email id</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${emps}" var="e">
				<tr>
					<td>${e.id}</td>
					<td>${e.firstname } ${e.lastname }</td>
					<td>${e.email }</td>
					<td>\$${e.salary }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>