 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<jsp:include page="../general/header.jsp" />

<div id="main">
	<h1>Lista gabinetów</h1>
	
	<span class="error">${message}</span>
	
	<form action="/admin/newroom">
   		<input type="submit" value="Dodaj Gabinet" />
	</form>
	
	<ul>
		<c:forEach var="room" items="${rooms}">
	   		<li>${room.roomNumber} - ${room.roomType.description} <a href="/admin/editroom/${room.roomNumber}">Edytuj</a> <a href="/admin/deleteroom/${room.roomNumber}">Usuń</a></li>
	   	</c:forEach>
   	</ul>
</div>

<jsp:include page="../general/login.jsp" />
<jsp:include page="../general/footer.jsp" />