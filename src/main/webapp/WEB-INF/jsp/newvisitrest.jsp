 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<jsp:include page="general/header.jsp" />

<div class="col-xs-12 col-md-8 w3-round-xlarge" id="main">
	<h1>Zaplanuj wizytę</h1>
	<form:form method="post" action="/newvisitsend" modelAttribute="visitForm">
		<form:hidden path="visitType" />
		<form:radiobuttons path="potentialVisit" items="${potenitalVisits}"  />
	   	<c:if test="${empty potenitalVisits}">
		   		Brak dostępnych terminów
	   	</c:if>
		<input type="submit" value="Zaplanuj wizytę">
	</form:form>
</div>

<jsp:include page="general/login.jsp" />
<jsp:include page="general/footer.jsp" />
