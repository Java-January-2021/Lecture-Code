<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Car</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h3>Add A Car</h3>
<hr>
<c:forEach items="${errors}" var="err">
<p>${err}</p>
</c:forEach>
<hr>
<form:form method="POST" action="/addCar" modelAttribute="car">
<p>
	<form:label path="make">Make:
	<form:errors path="make"/>
	<form:input path="make"/></form:label>
</p>
<p>
	<form:label path="model">Model:
	<form:errors path="model"/>
	<form:input path="model"/></form:label>
</p>
<p>
	<form:label path="year">Year:
	<form:errors path="year"/>
	<form:input path="year"/></form:label>
</p>
<p>
	<form:label path="color">Color:
	<form:errors path="color"/>
	<form:input path="color"/></form:label>
</p>
<button>Add New Car</button>
</form:form>
<hr>
<h3>Other Way</h3>
<form action="/oldaddCar" method="POST">
<div class="form-group">
<label for="make">Make</label>
<input type="text" name="make">
</div>
<div class="form-group">
<label for="model">model</label>
<input type="text" name="model">
</div>
<div class="form-group">
<label for="year">Year</label>
<input type="text" name="year">
</div>
<div class="form-group">
<label for="color">Color</label>
<input type="text" name="color">
</div>

<button>Add Car</button>
</form>

</div>
</body>
</html>