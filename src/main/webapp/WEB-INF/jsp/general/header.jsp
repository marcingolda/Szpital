<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Szpital</title>
<link rel="stylesheet" href='<c:url value="${pageContext.request.contextPath}/css/style.css"/>'>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- W3 theme -->
<link href="${pageContext.request.contextPath}/css/w3.css" rel="stylesheet">
</head>
<body>
<%String url = request.getRequestURI();%>
	<div id="logo">
		<img src="<c:url value="${pageContext.request.contextPath}/images/logo.png"/>">
	</div>
	<div class="container">
		<h3>
			<ul class="nav nav-pills" role="tablist" >
			        <li role="presentation" <%if(url.contains("index")){%>class="active"<%}%>><a href="/">Strona główna</a></li>
			        <li role="presentation" <%if(url.contains("about")){%>class="active"<%}%>><a href="about">O nas</a></li>
			        <li role="presentation" <%if(url.contains("offer")){%>class="active"<%}%>><a href="offer">Oferta</a></li>
			        <li role="presentation" <%if(url.contains("contact")){%>class="active"<%}%>><a href="contact">Kontakt</a></li>
			</ul>
		</h3>
	</div>

	<div class="row" id="wrap">