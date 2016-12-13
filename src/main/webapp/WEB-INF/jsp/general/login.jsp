<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div id="log">
	<form method="post" action="login">
		Nazwa użytkownika <input type="text" placeholder="Nazwa użytkownika"
			name="uname" required> Hasło <input type="password"
			placeholder="Hasło" name="psw" required>

		<button type="submit">Zaloguj</button>
		<label class="error">${loginMessage}</label>
		<input type="checkbox" checked="checked">Zapamiętaj mnie <br/>
	</form>
	Nie masz konta? <a href="register">Zarejestruj się</a>
</div>