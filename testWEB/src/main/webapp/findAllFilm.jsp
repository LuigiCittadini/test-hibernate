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
Username : ${user.idUser} <br/>
Nome : ${user.nome} <br/>
Cognome : ${user.cognome} <br/>

Lista Film

	<c:choose>
		<c:when test="${listaFilm != null}">
		Lista film:  <br />
			<c:forEach items="${listaFilm}" var="filmLista">
				<c:out value="${filmLista.titolo}" />
				<br />
				<c:choose>
					<c:when test="${user.ruolo == 1}">
						<form action="MainServlet" method="post">
							<input type="submit" value="GUARDA">
						</form>
						<form action="MainServlet" method="post">
							<input type="hidden" name="idFilm" value="${filmLista.idFilm}" /> 
							<input type="hidden" name="toInfoFilm" value="toInfoFilm" />
							<input type="submit" value="INFO">
							<br />
						</form>
					</c:when>					
				</c:choose>
				<c:choose>
					<c:when test="${user.ruolo == 2}">
						<form action="MainServlet" method="post">
						<input type="hidden" name="idFilm" value="${filmLista.idFilm}" /> 
							<input type="hidden" name="salvaFilmPerUpdate" value="salvaFilmPerUpdate" />
							<input type="submit" value="AGGIORNA">
						</form>
						<form action="MainServlet" method="post">
							<input type="hidden" name="idFilm" value="${filmLista.idFilm}" /> 
							<input type="hidden" name="toDeleteFilm" value="toDeleteFilm" />
							<input type="submit" value="ELIMINA">
							<br />
						</form>
					</c:when>					
				</c:choose>

				<c:out value="-------------------" />
				<br />
			</c:forEach>
		</c:when>
	</c:choose>

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