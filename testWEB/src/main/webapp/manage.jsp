<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Management</title>
</head>
<body>
	<form action="update.jsp">
			<input type="submit" value="update" ><br/>
	</form>
	<form action="delete.jsp">
			<input type="submit" value="delete" ><br/>
	</form>
	<form action="logout.jsp">
			<input type="submit" value="logout" ><br/>
	</form>
<!-- 	<form action="MainServlet" method="get">
					<input type="hidden" name="toGetAll" value="toGetAll">
			<input type="submit" value="FindAll" ><br/>
	</form> -->
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