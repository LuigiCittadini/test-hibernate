<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento</title>
</head>
<body>

	<form action="MainServlet" method="post">
	
		Mail: <input type="text" name="email">
		<br>
		Password: <input type="text" name="password">
		<br>
		<input type="hidden" name="toLogin" value="toLogin">
		<input type="submit" value="Login">
	</form>

</body>
</html>