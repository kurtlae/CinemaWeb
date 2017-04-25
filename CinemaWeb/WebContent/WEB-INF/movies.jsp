<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<header><%@ include file="../header.jsp" %></header>
		<div class="navbarDiv"><%@ include file="../navBar.jsp" %></div>
		<main>
					<div id="auditoriumHeaderDiv">
				<h2>Administera Film</h2>
				<a href="#"><button class="buttonMovie" id="addMovie">Lägg
						till Salong</button></a>
				<form>
					<input type="text" class="inputMovie"
						id="editMovie" name="editMovie" value="Editera Film">
				</form>
			</div>
		<div id="moviesWrapper">
	<h2>Aktuella Filmer hos Aeronaut</h2>
	</div>
		<div id="movieBodyDiv">
			<c:forEach items="${movie}" var="movie">
		<div class="movies">
			<!-- <c:out value="${movie.id}" /> -->
			<a href="GetMovie?id=${movie.id}">
			<c:out value="${movie.title}" />
			</a>	
		</div>
			</c:forEach>
		</div>
		</main>
	<footer><%@ include file="../footer.jsp" %></footer>
</div>
</body>
</html>