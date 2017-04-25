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

	<h1>Film:</h1>

		<h3>
			<a href="Movie?id=${movie.id}" >
			<c:out value="${movie.title}" />
			</a>	
		</h3>
		<h5>
			Minuter: <c:out value="${movie.duration}" /><br>
			Beskrivning: <c:out value="${movie.description}" /><br>
			Tillåten från ålder: <c:out value="${movie.ageRequirement}" /><br>
			Producerad år: <c:out value="${movie.year}" /><br>
			Genre: <c:out value="${movie.genre}" /><br>
			Språk: <c:out value="${movie.language}" />
    	</h5>
    	

</body>
</html>