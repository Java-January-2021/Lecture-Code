<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Cars dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<table class="table table-dark">
<thead>
<tr>
<td>ID</td>
<td>Make</td>
<td>Model</td>
<td>Year</td>
<td>Color</td>
</tr>
</thead>

<c:forEach items="${cars}" var="car">
<tr>
<td>${car.id}</td>
<td><a href="/${car.id}">${car.make}</a></td>
<td>${car.model}</td>
<td>${car.year}</td>
<td>${car.color}</td>
</tr>
</c:forEach>

</table>

</div>

</body>
</html>