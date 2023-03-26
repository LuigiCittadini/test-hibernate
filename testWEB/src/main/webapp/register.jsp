<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>

	<form action="MainServlet" method="post">	
	    
		Nome: <input type="text" name="nome">
		<br>
		Cognome: <input type="text" name="cognome">
		<br>
		Email: <input type="text" name="email">
		<br>
		Password: <input type="text" name="password">
		<br>
		<input type="hidden" name="toInsert" value="toInsert">
		<input type="submit" value="Registrazione">
	</form>
	
</body>
</html>