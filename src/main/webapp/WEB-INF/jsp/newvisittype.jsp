 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<jsp:include page="general/header.jsp" />

<div id="main">
	<h1>Zaplanuj wizytę</h1>
	<form:form method="post" action="/newvisit" modelAttribute="visit">
		Typ wizyty: 
		<form:select path="visitType">
			<c:forEach var="type" items="${types}">
		   		<form:option value="${type}" label="${type.description}"/>
		   	</c:forEach>
		</form:select>
		<input type="submit" value="wybierz">
	</form:form>
</div>

<jsp:include page="general/login.jsp" />
<jsp:include page="general/footer.jsp" />
