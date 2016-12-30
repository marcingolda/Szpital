<%@page import="pl.edu.pk.bean.enums.UserType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="pl.edu.pk.bean.User" %>
<%User user = (User) session.getAttribute("user"); %>

<jsp:include page="general/header.jsp" />

<div id="main">
	<h1>${title}</h1>
	<c:forEach var="visit" items="${visits}">
		<div class="visitDiv">
			<h3>${visit.id} - ${visit.visitType.description}</h3>
			<i>${visit.date} Gabinet numer ${visit.room.roomNumber}</i><br/>
			<b>${visit.doctor.first_name} ${visit.doctor.last_name}</b><br/>
			${visit.medicalComment}<br/>
			<% if(user.getUserType() == UserType.DOCTOR){ %>
				<a href="/editnote/${visit.id}">Edytuj notatkę</a>
			<% }%>
			<c:if test="${title =='Zaplanowane wizyty'}">
				<a href="/cancelvisit/${visit.id}">Odwołaj wizytę</a>
			</c:if>
		</div>
	</c:forEach>
</div>

<jsp:include page="general/login.jsp" />
<jsp:include page="general/footer.jsp" />
