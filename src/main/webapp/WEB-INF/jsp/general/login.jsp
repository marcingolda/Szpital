<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="pl.edu.pk.bean.User" %>

<%User user = (User) session.getAttribute("user");
if (user==null){ %>
	<div id="log">
		<form:form method="post" action="login" modelAttribute="loginForm">
			Adres e-mail <form:input type="email" path="email" placeholder="adres@email.com"/> 
			Hasło <form:input type="password" path="password" placeholder="Hasło"/>
	
			<button type="submit">Zaloguj</button>
			<label class="error">${loginMessage}</label>
			<input type="checkbox" checked="checked">Zapamiętaj mnie <br/>
		</form:form>
		Nie masz konta? <a href="register">Zarejestruj się</a>
	</div>
<%} else { %>
	<div id="log">
		Witaj <%=user.getFirst_name() + " " + user.getLast_name()%>! <br/>
		Przejdź do ustawień //ToDO <br/>
		<a href="/logout">Wyloguj się</a><br/>
	</div>
<%} %>