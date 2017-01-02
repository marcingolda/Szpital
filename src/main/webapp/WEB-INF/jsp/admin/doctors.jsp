 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<jsp:include page="../general/header.jsp" />

<div class="col-xs-12 col-md-8 w3-round-xlarge" id="main">
	<h1><b>Lista doktorów</b></h1>
	
	<span class="error">${message}</span>
	
	<form action="/admin/newdoctor">
   		<input type="submit" value="Dodaj Lekarza" class="w3-btn-block w3-blue" />
	</form>

   	<table class="w3-table">
    <tr class="w3-blue">
      <th>Imię</th>
      <th>Nazwisko</th>
      <th>Możliwe działania</th>
    </tr>
   	<c:forEach var="doctor" items="${doctors}">
   		<tr>
	      <td>${doctor.first_name}</td>
	      <td>${doctor.last_name}</td>
	      <td><a href="/admin/editdoctor/${doctor.user_id}">Edytuj</a> <a href="/admin/deletedoctor/${doctor.user_id}">Usuń</a></td>
    	</tr>
   	</c:forEach>
  </table>
</div>

<jsp:include page="../general/login.jsp" />
<jsp:include page="../general/footer.jsp" />