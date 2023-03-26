<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>

<form action="MainServlet" method="post">
	
	Username : ${user.idUser} <br/>
	Nome : ${user.nome} <br/>
	Cognome : ${user.cognome} <br/>
		<br>
		<input type="hidden" name="idUser" value="${user.idUser}" >
		<input type="hidden" name="toDelete" value="toDelete">
		<input type="submit" value="Elimina">
	</form>

</body>
</html>