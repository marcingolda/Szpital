<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="pl.edu.pk.bean.User" %>
<%@ page import="pl.edu.pk.bean.enums.UserType" %>

<%User user = (User) session.getAttribute("user");%>
<div id="log">
	<%if (user==null){ %>
			<form:form method="post" action="login" modelAttribute="loginForm">
				Adres e-mail <form:input type="email" path="email" placeholder="adres@email.com"/> 
				Hasło <form:input type="password" path="password" placeholder="Hasło"/>
		
				<button type="submit">Zaloguj</button>
				<label class="error">${loginMessage}</label>
				<input type="checkbox" checked="checked">Zapamiętaj mnie <br/>
			</form:form>
			Nie masz konta? <a href="register">Zarejestruj się</a>
	<%} else if (user.getUserType() == UserType.ADMINISTRATOR) { %>
			<a href=/admin/doctors>Zarządzaj lekarzami</a><br/>
			<a href=/admin/rooms>Zarządzaj gabinetami</a><br/>
			<br/><a href="/logout">Wyloguj się</a><br/>
	<%} else { %>
			Witaj <%=user.getFirst_name() + " " + user.getLast_name()%>! <br/>
			<a href="/visit">Zaplanowane wizyty</a><br/>
			<%if (user.getUserType() != UserType.DOCTOR) { %><a href="/newvisit">Umów wizytę</a><br/><%} %>
			<a href="/oldvisit">Archiwum wizyt</a><br/>
			<br/><a href="/logout">Wyloguj się</a><br/>
	<%} %>
</div>