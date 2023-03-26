<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Management</title>
</head>
<body>

	<form action="logout.jsp">
			<input type="submit" value="logout" ><br/>
	</form>
	<form action="insertFilm.jsp" method="post">
					<input type="hidden" name="insertFilm" value="insertFilm">
			<input type="submit" value="Aggiungi film" ><br/>
	</form><!-- 
	<form action="deleteFilm.jsp" method="post">
					<input type="hidden" name="toDeleteFilm" value="toDeleteFilm">
			<input type="submit" value="elimina film" ><br/>
	</form> -->
	<form action="MainServlet" method="get">
					<input type="hidden" name="toGetAll" value="toGetAll">
			<input type="submit" value="FindAll" ><br/>
	</form>
	<form action="MainServlet" method="get">
					<input type="hidden" name="toGetAllFilm" value="toGetAllFilm">
			<input type="submit" value="FindAllFilm" ><br/>
	</form>
	
	<form action="findAllFilmPerCategoria.jsp" method="get">
					<input type="hidden" name="toGetAllFilmPerCategoria" value="toGetAllFilmPerCategoria">
			<input type="submit" value="Cerca Per Categoria" ><br/>
	</form>
</body>
</html>