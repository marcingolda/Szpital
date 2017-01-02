 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<jsp:include page="../general/header.jsp" />

<div class="col-xs-12 col-md-8 w3-round-xlarge" id="main">
	<h1><b>Lista gabinetów</b></h1>
	
	<span class="error">${message}</span>
	
	<form action="/admin/newroom">
   		<input type="submit" value="Dodaj Gabinet" class="w3-btn-block w3-blue" />
	</form>
	
<table class="w3-table">
    <tr class="w3-blue">
      <th>Numer</th>
      <th>Przeznaczenie</th>
      <th>Możliwe działania</th>
    </tr>
   	<c:forEach var="room" items="${rooms}">
   		<tr>
	      <td>${room.roomNumber}</td>
	      <td>${room.roomType.description}</td>
	      <td><a href="/admin/editroom/${room.roomNumber}">Edytuj</a> <a href="/admin/deleteroom/${room.roomNumber}">Usuń</a></td>
    	</tr>
   	</c:forEach>
  </table>
</div>

<jsp:include page="../general/login.jsp" />
<jsp:include page="../general/footer.jsp" />