<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security Home Page</title>
</head>
<body>
	<h1>Hello Home page here</h1>
	
	<!-- Display the user Id when the user logs in -->
 	<p>
 		User: <security:authentication property="principal.username"/>
 		<br>
 		Roles: <security:authentication property="principal.authorities"/>
 	</p>
	<hr>
		<!-- Add a link to point to /leaders ... this is for the manager -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (only for managers)
		<br>
		<a href="${pageContext.request.contextPath}/systems">Systems Meeting</a> (Only for Admins)
	</p>
	
	<hr>
	<!-- Add a Logout Button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>
</html>