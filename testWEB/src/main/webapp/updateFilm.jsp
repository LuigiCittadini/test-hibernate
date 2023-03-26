<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="MainServlet" method="post">


<c:set var="isAvventura" value="${false}" />
<c:forEach items="${film.listaGeneriDelFilm}" var="lista">
  <c:choose>
    <c:when test="${lista.genere.contains('AVVENTURA')}">
      <c:set var="isAvventura" value="${true}" />
    </c:when>
  </c:choose>
</c:forEach>
<c:set var="isRomantico" value="${false}" />
<c:forEach items="${film.listaGeneriDelFilm}" var="lista">
  <c:choose>
    <c:when test="${lista.genere.contains('ROMANTICO')}">
      <c:set var="isRomantico" value="${true}" />
    </c:when>
  </c:choose>
</c:forEach>
<c:set var="isDrammatico" value="${false}" />
<c:forEach items="${film.listaGeneriDelFilm}" var="lista">
  <c:choose>
    <c:when test="${lista.genere.contains('DRAMMATICO')}">
      <c:set var="isDrammatico" value="${true}" />
    </c:when>
  </c:choose>
</c:forEach>
<c:set var="isThriller" value="${false}" />
<c:forEach items="${film.listaGeneriDelFilm}" var="lista">
  <c:choose>
    <c:when test="${lista.genere.contains('THRILLER')}">
      <c:set var="isThriller" value="${true}" />
    </c:when>
  </c:choose>
</c:forEach>
<c:set var="isHorror" value="${false}" />
<c:forEach items="${film.listaGeneriDelFilm}" var="lista">
  <c:choose>
    <c:when test="${lista.genere.contains('HORROR')}">
      <c:set var="isHorror" value="${true}" />
    </c:when>
  </c:choose>
</c:forEach>
<c:set var="isFantasy" value="${false}" />
<c:forEach items="${film.listaGeneriDelFilm}" var="lista">
  <c:choose>
    <c:when test="${lista.genere.contains('FANTASY')}">
      <c:set var="isFantasy" value="${true}" />
    </c:when>
  </c:choose>
</c:forEach>
<c:set var="isDocumentario" value="${false}" />
<c:forEach items="${film.listaGeneriDelFilm}" var="lista">
  <c:choose>
    <c:when test="${lista.genere.contains('DOCUMENTARIO')}">
      <c:set var="isDocumentario" value="${true}" />
    </c:when>
  </c:choose>
</c:forEach>

<c:set var="isT" value="${false}" />
  <c:choose>
    <c:when test="${film.classificazione == ('T')}">
      <c:set var="isT" value="${true}" />
    </c:when>
  </c:choose>
  <c:set var="is6" value="${false}" />
  <c:choose>
    <c:when test="${film.classificazione == ('6')}">
      <c:set var="is6" value="${true}" />
    </c:when>
  </c:choose>
  <c:set var="is14" value="${false}" />
  <c:choose>
    <c:when test="${film.classificazione == ('14')}">
      <c:set var="is14" value="${true}" />
    </c:when>
  </c:choose>
    <c:set var="is18" value="${false}" />
  <c:choose>
    <c:when test="${film.classificazione == ('18')}">
      <c:set var="is18" value="${true}" />
    </c:when>
  </c:choose>

        	
		Titolo: <input type="text" name="titolo" value="${film.titolo}">
		<br>
		Nome Regista: <input type="text" name="nomeRegista" value="${film.regista.nome}">
		<br>
		Cognome Regista: <input type="text" name="cognomeRegista" value="${film.regista.cognome}">
		<br>
		Data d' uscita: <input type="date" name="anno" value=<fmt:formatDate pattern="yyyy-MM-dd" value="${film.anno}"/> />
		<br>
		Genere:
		<p>
			<c:choose>
				<c:when test="${isAvventura}">
					<input type="checkbox" checked name="id" value="1" />AVVENTURA
    </c:when>
				<c:otherwise>
					<input type="checkbox" name="id" value="1" />AVVENTURA
      </c:otherwise>
			</c:choose>
		</p>
		<p>
			<c:choose>
				<c:when test="${isRomantico}">
					<input type="checkbox" checked name="id" value="2" />ROMANTICO
    </c:when>
				<c:otherwise>
					<input type="checkbox" name="id" value="2" />ROMANTICO
      </c:otherwise>
			</c:choose>
		</p>
		<p>
			<c:choose>
				<c:when test="${isDrammatico}">
					<input type="checkbox" checked name="id" value="3" />DRAMMATICO
    </c:when>
				<c:otherwise>
					<input type="checkbox" name="id" value="3" />DRAMMATICO
      </c:otherwise>
			</c:choose>
		</p>
		<p>
			<c:choose>
				<c:when test="${isThriller}">
					<input type="checkbox" checked name="id" value="4" />THRILLER
    </c:when>
				<c:otherwise>
					<input type="checkbox" name="id" value="4" />THRILLER
      </c:otherwise>
			</c:choose>
		</p>
		<p>
			<c:choose>
				<c:when test="${isHorror}">
					<input type="checkbox" checked name="id" value="5" />HORROR
    </c:when>
				<c:otherwise>
					<input type="checkbox" name="id" value="5" />HORROR
      </c:otherwise>
			</c:choose>
		</p>
		<p>
			<c:choose>
				<c:when test="${isFantasy}">
					<input type="checkbox" checked name="id" value="6" />FANTASY
    </c:when>
				<c:otherwise>
					<input type="checkbox" name="id" value="6" />FANTASY
      </c:otherwise>
			</c:choose>
		</p>
		<p>
			<c:choose>
				<c:when test="${isDocumentario}">
					<input type="checkbox" checked name="id" value="7" />DOCUMENTARIO
    </c:when>
				<c:otherwise>
					<input type="checkbox" name="id" value="7" />DOCUMENTARIO
      </c:otherwise>
			</c:choose>
		</p>

		<br>
		Classificazione: <select name="classificazione" id="classificazione">
		<c:choose>
		<c:when test="${isT}">
			<option value="T" selected>T</option>
			</c:when>
			<c:otherwise>
			<option value="T">T</option>
			</c:otherwise>
		</c:choose>
		<c:choose>	
		<c:when test="${is6}">
			<option value="6" selected>6</option>
			</c:when>
			<c:otherwise>
			<option value="6">6</option>
			</c:otherwise>
		</c:choose>
		<c:choose>	
		<c:when test="${is14}">
			<option value="14" selected>14</option>
			</c:when>
			<c:otherwise>
			<option value="14">14</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
		<c:when test="${is18}">
			<option value="18" selected>18</option>
			</c:when>
			<c:otherwise>
			<option value="18">18</option>
			</c:otherwise>
		</c:choose>
						
		</select><br>
		<br>
		Nazionalita: <input type="text" name="nazionalita" value="${film.nazionalita}">
		<br>
		<input type="hidden" name="idFilm" value="${film.idFilm}" >
		<input type="hidden" name="toUpdateFilm" value="toUpdateFilm" >
		<input type="submit" value="Update Film">
	</form>
	<c:choose>
		<c:when test="${user.ruolo == 2}">
			<form action="manageAdmin.jsp">
				<input type="submit" value="home"><br />
			</form>
		</c:when>
	</c:choose>

</body>
</html>