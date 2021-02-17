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
<h1>Welcome ${user.firstName } ${user.lastName}</h1>
<h2>Welcome to Cars dot Com</h2>
<p><a href="/new">Create Car</a> | <a href="/accessory/new">Create Accessory</a> | <a href="/logout">Logout</a>
<table class="table table-dark">
<thead>
<tr>
<td>Action</td>
<td>Make</td>
<td>Model</td>
<td>Year</td>
<td>Color</td>
<td># of Likes</td>
</tr>
</thead>

<c:forEach items="${cars}" var="car">
<tr>
<td>
<c:choose>
<c:when test="${car.likers.contains(user)}">
<a href="/unlike/${car.id}">Un-Like</a>
</c:when>
<c:otherwise>
<a href="/like/${car.id}">Like</a>
</c:otherwise>
</c:choose>

</td>
<td><a href="/${car.id}">${car.make}</a></td>
<td>${car.model}</td>
<td>${car.year}</td>
<td>${car.color}</td>
<td>${car.likers.size()}</td>
</tr>
</c:forEach>

</table>

</div>

</body>
</html>