<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/login">
<select name="user">
<c:forEach items="${users}" var="user">
<option value="${user.id}">${user.firstName} ${user.lastName }</option>
</c:forEach>

</select>
<button>LogIn</button>
</form>
</body>
</html>