<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Codice Film : ${film.idFilm}
	<br /> Titolo : ${film.titolo}
	<br /> Regista : ${film.regista.nome} ${film.regista.cognome}
	<br /> Anno: <fmt:formatDate pattern="dd-MM-yyyy" value="${film.anno}" />
	<br /> Genere: ${film.listaGeneriDelFilm}
	<br /> Classificazione: ${film.classificazione}
	<br /> Nazionalita: ${film.nazionalita}
	<br />
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