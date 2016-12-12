<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="general/header.jsp" />

<div id="news">
	<h1>Aktualności</h1>
	<h4>Aktualność 1</h4>
	<p>Praesent rutrum et augue vitae vehicula. Vestibulum ante ipsum
		primis in faucibus orci luctus et ultrices posuere cubilia Curae;
		Curabitur feugiat ac erat eget venenatis. Cras fermentum placerat
		metus, a euismod quam sollicitudin non. In hac habitasse platea
		dictumst. Pellentesque sollicitudin eros nunc, nec cursus dui
		sollicitudin at. Nullam et finibus mauris. Curabitur ut semper urna,
		ac tincidunt sapien.</p>
	<h4>Aktualność 2</h4>
	<p>Praesent rutrum et augue vitae vehicula. Vestibulum ante ipsum
		primis in faucibus orci luctus et ultrices posuere cubilia Curae;
		Curabitur feugiat ac erat eget venenatis. Cras fermentum placerat
		metus, a euismod quam sollicitud.</p>
	<h4>Aktualność 3</h4>
	<p>Praesent rutrum et augue vitae vehicula. Vestibulum ante ipsum
		primis in faucibus orci luctus et ultrices posuere cubilia Curae;
		Curabitur feugiat ac erat eget venenatis. Cras fermentum placeraitudin
		at. Nullam et finibus mauris. Curabitur ut semper urna, ac tincidunt
		sapien.</p>
</div>

<div id="log">
	<form>
		Nazwa użytkownika <input type="text" placeholder="Nazwa użytkownika"
			name="uname" required> Hasło <input type="password"
			placeholder="Hasło" name="psw" required>

		<button type="submit">Zaloguj</button>
		<input type="checkbox" checked="checked">Zapamiętaj mnie
	</form>
</div>

<jsp:include page="general/footer.jsp" />
