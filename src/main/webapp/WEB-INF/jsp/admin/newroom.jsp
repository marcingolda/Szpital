 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
<jsp:include page="../general/header.jsp" />

<div id="sign-in" class="main col-xs-12 col-md-8 w3-round-xlarge">
 <h2>Dodaj pokój</h2>
    <form:form method="post" action="/admin/newroom" modelAttribute="room">
         <label>Numer</label>
         <form:input type="number" path="roomNumber"/>
         <form:errors path="roomNumber" cssClass="error" />
         
         <label>Typ gabinetu</label> <br/>
         <form:select path="roomType">
	         <c:forEach var="type" items="${types}">
			    <form:option value="${type}" label="${type.description}"/>
			</c:forEach>
		</form:select> <br/>

         <input type="submit" value="Dodaj">
     </form:form>
</div>

<jsp:include page="../general/footer.jsp" />