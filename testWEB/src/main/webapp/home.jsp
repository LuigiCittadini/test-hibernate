<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${user == null}">
			<form action="login.jsp">
				<input type="submit" value="login"><br />
			</form>
			<form action="register.jsp">
				<input type="submit" value="register"><br />
			</form>
		</c:when>
		<c:otherwise>
			<jsp:forward page="manage.jsp"></jsp:forward>
		</c:otherwise>
	</c:choose>

</body>
</html>