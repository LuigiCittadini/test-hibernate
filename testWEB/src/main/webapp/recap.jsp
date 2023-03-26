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
Id User : ${user.idUser} <br/>
Nome : ${user.nome} <br/>
Cognome : ${user.cognome} <br/>

	<c:choose>
		<c:when test="${listaUser != null}">
		Lista user:  <br />
			<c:forEach items="${listaUser}" var="userLista">
				<c:out value="${userLista.nome}" />
				<c:out value="${userLista.cognome}" />
				
				<c:choose>
					<c:when test="${userLista.ruolo == 1}">
						<form action="MainServlet" method="post">
						<input type="hidden" name="idUser" value="${userLista.idUser}" /> 
						<input type="hidden" name="toRendiAmministratore" value="toRendiAmministratore" />
							<input type="submit" value="Rendi Amministratore"><br />
						</form>
					</c:when>
				</c:choose>
				<br />
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