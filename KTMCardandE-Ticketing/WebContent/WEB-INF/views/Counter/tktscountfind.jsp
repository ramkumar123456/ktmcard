<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>Insert title here</title>
<style type="text/css">
.view {
     border: 0;


}</style>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_Counter">
<center>
	<img src="images/ktmlogo.jpg" height="150px" width="250px"><br>
<form:form method="GET" action="confrmticketcounter.html">
<br>
<h3>Tickets Count</h3>
<table width="350px" height="200" border="1">
			  
			    
			    <tr>
			        <td><form:label path="tktdate"><b>Date:</b></form:label></td>
			        <td>&nbsp;&nbsp;&nbsp;<form:input path="tktdate" cssClass="view" readonly="true"/></td>
			    </tr>
			 
			    <tr></tr>
			    <tr>
			        <td><form:label path="tottkts"><b>Total Tickets:</b></form:label></td>
			        <td>&nbsp;&nbsp;&nbsp;<form:input path="tottkts" cssClass="view" readonly="true"/></td>
			    </tr>

			    <tr></tr>
			      <tr>
			        <td><form:label path="totamnt"><b>Total Amount:</b></form:label></td>
			        <td>&nbsp;&nbsp;&nbsp;<form:input path="totamnt"  id="fare" cssClass="view" readonly="true"/></td>
			    </tr>
			    <tr></tr>
			    </table>
			   
			    </form:form>
			     </center>
			     </security:authorize>
</body>
</html>