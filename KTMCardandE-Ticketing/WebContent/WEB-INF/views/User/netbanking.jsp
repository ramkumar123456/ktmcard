<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1 align="center">Select Your Bank</h1>
<form:form action="homepaymentsuccess1.html" method="POST">
<table border="0" align="center" cellpadding="3" cellspacing="2">

<tr>
<td colspan="2" align="center"><input type="button" value="Proceed" onclick="prnt();">
</td></tr>
 
<%-- <%--  
<form:form name="f" action="j_spring_security_check" method='POST'>
<tr><td cssStyle="height:20px">CardName</td><td cssStyle="width:18px;">:</td>
<td><input/></td><td><form:errors path="username" cssClass="error"></form:errors></td></tr>
<tr><td cssStyle="height:20px">CardNumber</td><td cssStyle="width:18px;">:</td>
<td><input/></td><td><form:errors path="password" cssClass="error"></form:errors></td></tr> --%>

 <!-- <a href="adminlogin.html">AdminLogin</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="counterlogin.html">CounterLogin</a></h2> -->
 
</table>
</form:form>
</security:authorize>
</body>
</html>