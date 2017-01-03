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
         <form:errors path="first_name" cssClass="error" />
         
         <label>Nazwisko</label>
         <form:input type="text" path="last_name"/>
         <form:errors path="last_name" cssClass="error" />
         
         <label>E-mail</label>
         <form:input type="email" path="email" />
         <form:errors path="email" cssClass="error" />
         
         <label>Hasło</label>
         <form:input type="password" path="password" />
         <form:errors path="password" cssClass="error" />
         
         <label>Powtórz hasło</label>
         <form:input type="password" path="password2" />
         <form:errors path="password2" cssClass="error" />
         
         <label>Numer PESEL</label>
         <form:input type="number" path="pesel" name="pesel" pattern="[0-9]{11}" />
         <form:errors path="pesel" cssClass="error" />

         <input type="submit" value="Utwórz konto" class="w3-btn-block w3-blue">
     </form:form>
</div>

<jsp:include page="general/footer.jsp" />