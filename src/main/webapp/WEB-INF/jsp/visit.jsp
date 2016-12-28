<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="general/header.jsp" />


<div id="main">
	<h1>Zaplanowane Wizyty:</h1>
	<c:forEach var="visit" items="${visits}">
		<div class="visitDiv">
			<h3>${visit.id} - ${visit.name}</h3>
			<i>${visit.date}</i><br/>
			<b>${visit.doctor.first_name} ${visit.doctor.last_name}</b><br/>
			${visit.medicalComment}<br/>
		</div>
	</c:forEach>
</div>

<jsp:include page="general/login.jsp" />
<jsp:include page="general/footer.jsp" />
