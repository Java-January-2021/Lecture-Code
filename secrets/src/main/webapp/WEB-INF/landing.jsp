<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Secrets</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome ${user.firstName}</h1> - <a href="/logout">Logout</a>
<hr>
<h3>Add Secret</h3>
<form:form action="/secrets/addSecret" method="post" modelAttribute="secret">
			    <div class="form-group">
			        <form:label path="content">First Name</form:label>
			        <form:errors path="content"/>
			        <form:input path="content"/>
			    </div>
			    <button>Add Secret</button>
</form:form>
<hr>
<h3>Recent Secrets</h3>
<c:forEach items="${secrets}" var="secret">
<p>${secret.content} ${secret.createdAt}
<c:choose>
<c:when test="${user.id == secret.creator.id}">
<a href="/secrets/delete/${secret.id}">Delete</a>
</c:when>
<c:otherwise>
<c:choose>
<c:when test="${secret.likers.contains(user) }">
You Like this
</c:when>
<c:otherwise>
<a href="/secrets/like/${secret.id}">Like</a>
</c:otherwise>
</c:choose>
</c:otherwise>
</c:choose>
</p>
</c:forEach>


</div>
</body>
</html>