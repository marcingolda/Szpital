<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="pl.edu.pk.bean.User" %>
<%@ page import="pl.edu.pk.bean.enums.UserType" %>

<%User user = (User) session.getAttribute("user");%>
<div class="col-xs-6 col-md-4 w3-round-xlarge" id="log">
	<h6>
	<div>
	<%if (user==null){ %>
			<form:form method="post" action="login" modelAttribute="loginForm">
				<p>
					<label>Adres e-mail:</label>
					<form:input class="w3-input" type="email" path="email" placeholder="adres@email.com"/> 
				</p>
				<p>
					<label>Hasło:</label>
					<form:input class="w3-input" type="password" path="password" placeholder="Hasło"/>
				</p>
				<p>
					<button type="submit" class="btn btn-primary">Zaloguj</button>
				</p>
				<p>
					<label class="error">${loginMessage}</label>
				</p>
				<p>
					<input class="w3-check" type="checkbox"><label class="w3-validate">Zapamiętaj mnie</label>
				</p>	
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
	</h6>
</div>