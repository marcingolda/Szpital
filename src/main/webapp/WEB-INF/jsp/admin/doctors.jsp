 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<jsp:include page="../general/header.jsp" />

<div id="main">
	<h1>Lista doktorów</h1>
	<form action="/admin/newdoctor">
   		<input type="submit" value="Dodaj Lekarza" />
	</form>
	
	<ul>
		<c:forEach var="doctor" items="${doctors}">
	   		<li>${doctor.first_name} ${doctor.last_name}  <a href="/editdoctor/${doctor.user_id}">Edytuj</a> <a href="/deletedoctor/${doctor.user_id}">Usuń</a></li>
	   	</c:forEach>
   	</ul>
</div>

<jsp:include page="../general/login.jsp" />
<jsp:include page="../general/footer.jsp" />