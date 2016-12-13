 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	
<jsp:include page="general/header.jsp" />
 
 <div id="sign-in" class="main">
 <h2>ZAREJESTRUJ SIE!</h2>
    <form:form method="post" modelAttribute="userForm">
         <label>Imię</label>
         <form:input type="text" path="first_name"/>
         
         <label>Nazwisko</label>
         <form:input type="text" path="last_name"/>
         
         <label>E-mail</label>
         <form:input type="email" path="email" />
         
         <label>Hasło</label>
         <form:input type="password" path="password1" />
         
         <label>Powtórz hasło</label>
         <form:input type="password" path="password2" />
         
         <label>Numer PESEL</label>
         <form:input type="number" path="pesel" name="pesel" pattern="[0-9]{11}" />

         <input type="submit" value="Submit">
     </form:form>
</div>

<jsp:include page="general/footer.jsp" />