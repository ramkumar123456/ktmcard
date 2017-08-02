<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_User">
<form:form method="POST" action="homepaymentsuccess1.html">
<center>
<h2>Ktm Card</h2>
</center>
<table align="center">
<tr><td>Enter Card Number</td><td><input type="text" value="456556585156152"></td></tr>
</table><br>
<center><input type="submit" VALUE="Proceed"></center>
</form:form>
</security:authorize>
</body>
</html>