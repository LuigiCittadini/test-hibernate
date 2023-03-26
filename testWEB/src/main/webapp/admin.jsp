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
		Lista user:  <br/>
			<c:forEach items="${listaUser}" var="userLista">
				 <c:out value="${userLista.nome}" />
				 <c:out value="${userLista.cognome}" />
				 <br/>
				 <c:out value="-------------------"/>
				 <br/>
			</c:forEach>
		</c:when>
	</c:choose>
	
	
	<form action="manageAdmin.jsp">
			<input type="submit" value="home" ><br/>
	</form>
</body>
</html>