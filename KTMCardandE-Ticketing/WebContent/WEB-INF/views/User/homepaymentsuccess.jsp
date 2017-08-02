<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function prnt()
{
	window.open("printjourneytkt.html", "Ticket", "width=500,height=570");	
	
	
}
</script>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_User">
<h1 align="center">Your Payment is successful</h1>
<h3 align="center">Available Balance is 250</h3>
<table align="center">
<tr><td></td></tr>
<tr><td>
<input type="button" value="Proceed" onclick="prnt();">
</td></tr>
</table>
</security:authorize>
</body>
</html>