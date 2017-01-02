<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<jsp:include page="general/header.jsp" />

<div class="col-xs-12 col-md-8" id="main">
	<h1>Edytuj notatkę</h1>
	<form:form method="post" action="/editnote/${visit.id}" modelAttribute="visit">
		${visit.patient.first_name} ${visit.patient.first_name}<br/>
		${visit.date}<br/>
		<form:textarea path="medicalComment"/>
		<button type="submit">Zapisz</button>
	</form:form>
</div>

<jsp:include page="general/login.jsp" />
<jsp:include page="general/footer.jsp" />
