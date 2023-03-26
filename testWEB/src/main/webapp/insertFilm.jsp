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

		Titolo: <input type="text" name="titoloFilm"> <br> 
		Nome Regista: <input type="text" name="nomeRegista"> <br> 
		Cognome	Regista: <input type="text" name="cognomeRegista"> <br> 
		Data d' uscita:	<input type="date" name="dataFilm"> <br> 
		Classificazione:
		<select name="classificazioneFilm" id="classificazioneFilm">
			<option value="T">T</option>
			<option value="6">6</option>
			<option value="14">14</option>
			<option value="18">18</option>			
		</select><br>
		Nazionalita: <input type="text"	name="nazionalitaFilm"> <br>
		<p>Genere:</p>
		<p>
			<input type="checkbox" name="id" value="1" />AVVENTURA
		</p>
		<p>
			<input type="checkbox" name="id" value="2" />ROMANTICO
		</p>
		<p>
			<input type="checkbox" name="id" value="3" />DRAMMATICO
		</p>
		<p>
			<input type="checkbox" name="id" value="4" />THRILLER
		</p>
		<p>
			<input type="checkbox" name="id" value="5" />HORROR
		</p>
		<p>
			<input type="checkbox" name="id" value="6" />FANTASY
		</p>
		<p>
			<input type="checkbox" name="id" value="7" />DOCUMENTARIO
		</p>
		<br> <input type="hidden" name="insertFilm" value="insertFilm">
		<input type="submit" value="Registra film">		
	</form>
	<form action="manageAdmin.jsp">
			<input type="submit" value="home" ><br/>
	</form>

</body>
</html>