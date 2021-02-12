<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add an Accessory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h2>Add An Accessory</h2>

<form:form method="POST" action="/accessory/new" modelAttribute="accessory">
<div class="form-group">
	<form:label path="car">Give This Accessory To:</form:label>
	<form:errors path="car"/>
	<form:select path="car">
	<c:forEach items="${cars}" var="car">
		<option value="${car.id}">${car.make} ${car.model}</option>
	</c:forEach>
	</form:select>
</div>

	<div class="form-group">
		<form:label path="name">Name:
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="price">Price:
		<form:errors path="price"/>
		<form:input path="price"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="description">Description:
		<form:errors path="description"/>
		<form:textarea path="description"/></form:label>
	</div>
	
	<button>Add Accessory</button>
</form:form>
</div>
</body>
</html>