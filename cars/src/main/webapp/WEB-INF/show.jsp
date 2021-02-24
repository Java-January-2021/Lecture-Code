<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details For Specific Car</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<t:wrapper>
<div class="container">
<h2>Details For ${car.model } ${car.make}</h2>
<p>Owner: <a href="/user/${car.user.id}">${car.user.firstName}</a></p>

<c:set var="found" value="false"/>

<c:forEach items="${car.ratings}" var="rating">
<c:if test="${rating.user == user}">
<c:set var="found" value="true"/>
You have rated this car <c:out value="${rating.rating}"/>
</c:if>
</c:forEach>

<c:if test="${found == false}">
<h4>Add A Rating</h4>
<form method="POST" action="/rate/${car.id}">
<select name="rating">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
</select>
<button>Rate!</button>
</form>
</c:if>



<hr>
<h3>Liked By:</h3>
<ol>
<c:forEach items="${car.likers}" var="user">
<li>${user.firstName } ${user.lastName}</li>
</c:forEach>
</ol>
<hr>
<p>Year: ${car.year}</p>
<p>Color: ${car.color}</p>
<hr>
<h3>Accessories</h3>
<ol>
<c:forEach items="${car.accessories }" var="acc">
	<li><p>${acc.name} ${acc.description } ${acc.price}</p></li>
</c:forEach>
</ol>
<hr>
<c:choose>
<c:when test="${car.registration != null }">
<h4>Registration</h4>
<p>City: ${car.registration.city}</p>
<p>State: ${car.registration.state}</p>
</c:when>
<c:otherwise>
<hr>
<h3>Register This Car!</h3>
<form:form method="POST" action="/addRegistration" modelAttribute="tag">
    <p>
    <form:label path="city">City
    <form:errors path="city"/>
    <form:input path="city"/></form:label>
    </p>
    <p>
    <form:label path="state">State
    <form:errors path="state"/>
    <form:textarea path="state"/></form:label>
  	</p>
  	<form:hidden path="car" value="${car.id}"/>
    <button>Register This Car</button>

</form:form>
</c:otherwise>
</c:choose>

<hr>
<c:if test="${car.user.id == user.id }"> 
<h3>Edit This Car</h3>
<form:form method="POST" action="/edit/${car.id}" modelAttribute="car">
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
	<form:label path="year">Year
	<form:errors path="year"/>
	<form:input path="year"/></form:label>
	</p>
		<p>
	<form:label path="color">Color
	<form:errors path="color"/>
	<form:input path="color"/></form:label>
	</p>
<button>Update Car</button>
</form:form>

<hr>
<h3>Old Way</h3>
<form method="POST" action="/old/edit/${car.id}">
<input type="hidden" name="_method" value="put">
<p>
<label for="make">Make</label>
<input type="text" name="make" value="${car.make}">
</p>
<p>
<label for="make">Model</label>
<input type="text" name="model" value="${car.model}">
</p>
<p>
<label for="make">Year</label>
<input type="text" name="year" value="${car.year}">
</p>
<p>
<label for="make">Color</label>
<input type="text" name="color" value="${car.color}">
</p>

<button>Edit This Car</button>
<hr>
<a href="/delete/${car.id}" class="btn btn-danger">Delete</a>
</form>
</c:if>
</div>

</t:wrapper>
</body>
</html>