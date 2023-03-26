<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	User ID : ${user.idUser}
	<br /> Nome : ${user.nome}
	<br /> Cognome : ${user.cognome}
	<br />

	<form action="MainServlet" method="get">
		<input type="submit" name="toGetAvventura" value="avventura"><br />
	</form>
	<form action="MainServlet" method="get">
		<input type="submit" name="toGetRomantico" value="romantico"><br />
	</form>
	<form action="MainServlet" method="get">
		<input type="submit" name="toGetDrammatico" value="drammatico"><br />
	</form>
	<form action="MainServlet" method="get">
		<input type="submit" name="toGetThriller" value="thriller"><br />
	</form>
	<form action="MainServlet" method="get">
		<input type="submit" name="toGetHorror" value="horror"><br />
	</form>
	<form action="MainServlet" method="get">
		<input type="submit" name="toGetFantasy" value="fantasy"><br />
	</form>
	<form action="MainServlet" method="get">
		<input type="submit" name="toGetDocumentario" value="documentario"><br />
	</form>


	<c:choose>
		<c:when test="${user.ruolo == 1}">
			<form action="manage.jsp">
				<input type="submit" value="home"><br />
			</form>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${user.ruolo == 2}">
			<form action="manageAdmin.jsp">
				<input type="submit" value="home"><br />
			</form>
		</c:when>
	</c:choose>
</body>
</html>