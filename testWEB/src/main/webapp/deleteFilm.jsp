<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
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

	<form action="manageAdmin.jsp" method="post">
		<input type="hidden" name="toDeleteFilm" value="toDeleteFilm"> 
		<input type="submit" value="Elimina">
	</form>


	<form action="manageAdmin.jsp">
		<input type="submit" value="home"><br />
	</form>

</body>
</html>