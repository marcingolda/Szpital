<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="general/header.jsp" />

<div id="main">
	<h1>OOOPS... COŚ POSZŁO NIE TAK!</h1>
	<a href="/">Wróć do strony głównej</a>
	<img src="${pageContext.request.contextPath}/images/error.jpg"/>
</div>

<jsp:include page="general/login.jsp" />
<jsp:include page="general/footer.jsp" />