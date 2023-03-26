<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="MainServlet" method="post">

        	
		Nome: <input type="text" name="nome" value="${user.nome}">
		<br>
		Cognome: <input type="text" name="cognome" value="${user.cognome}">
		<br>
		Email: <input type="text" name="email" value="${user.email}">
		<br>
		Password: <input type="text" name="password" value="${user.password}">
		<br>
		<input type="hidden" name="idUser" value="${user.idUser}" >
		<input type="hidden" name="toUpdate" value="toUpdate" >
		<input type="submit" value="Update">
	</form>

</body>
</html>