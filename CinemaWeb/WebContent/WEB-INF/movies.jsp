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
				<h2>Administera Salong</h2>
				<a href="#"><button class="buttonAuditorium" id="addAuditorium">Lägg
						till Salong</button></a>
				<form>
					<input type="text" class="inputAuditorium"
						id="editAuditorium" name="editAuditorium" value="Editera Salong">
				</form>
			</div>
			<div id="auditoriumsWrapper">
			<h2>Aktuella Salonger hos Aueronaut</h2>
			</div>
			<div id="auditoriumBodyDiv">
				<c:forEach items="${auditoriums}" var="auditorium">
					<div class="auditorium">
						<a href="GetAuditorium?id=${auditorium.id}"><br>
						<img alt="auditorium" src="img/auditorum1.png"><br>
						<c:out value="${auditorium.name}" /><br>
						</a>
					</div>
				</c:forEach>
			</div>
		</main>
	<footer><%@ include file="../footer.jsp" %></footer>
</div>


	<h1>Filmer:</h1>

	<c:forEach items="${movie}" var="movie">
		<h3>
			<c:out value="${movie.id}" />
			<a href="Movie?id=${movie.id}" name="id">
			<c:out value="${movie.title}" />
			</a>	
		</h3>
	</c:forEach>

</body>
</html>