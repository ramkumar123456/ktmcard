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
<style>
 .error{
 color: #ff0000;
 }
 .txt {
 	border:2px solid #b3b3b3;
	width: 160px;
    heigth:25px; 
    border-radius:10px;
}
.button{
border:1px solid #999999; -webkit-border-radius: 42px; -moz-border-radius: 42px;border-radius: 42px;font-size:12px;font-family:times new roman, helvetica, sans-serif; padding: 5px 15px 5px 15px; text-decoration:none; display:inline-block;text-shadow: 1px 1px 0 rgba(255,255,255,0.3);font-weight:bold; color: #000000;
 background-color: #FFFFFF; background-image: -webkit-gradient(linear, left top, left bottom, from(#FFFFFF), to(#CFCFCF));
 background-image: -webkit-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -moz-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -ms-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -o-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: linear-gradient(to bottom, #FFFFFF, #CFCFCF);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#FFFFFF, endColorstr=#CFCFCF);
}

.button:hover{
 border:1px solid #7A7A7A;
 background-color: #EEEEEE; background-image: -webkit-gradient(linear, left top, left bottom, from(#EEEEEE), to(#C7C7C7));
 background-image: -webkit-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -moz-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -ms-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -o-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: linear-gradient(to bottom, #EEEEEE, #C7C7C7);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#EEEEEE, endColorstr=#C7C7C7);
}
 </style>
 <script type="text/javascript">
function prnt()
{
	window.open("printjourneytkt.html", "Ticket", "width=500,height=570");	
	
	
}
</script>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_User">
<br><br><br><br>
<h1 align="center">Credit Card Payment Page</h1>
<form:form action="aplpaymentsuccess1.html" method="POST">
<table border="0" align="center" cellpadding="3" cellspacing="2">
<tr><td>CardNumber</td><td>:</td>
<td><form:input path="cardnumber" placeholder="CardNumber"/></td><td><form:errors path="cardnumber" cssClass="error"></form:errors></td></tr>
<tr><td>Name On Card</td><td>:</td>
<td><form:input path="cardname"  placeholder="Name On Card"/></td><td><form:errors path="cardname" cssClass="error"></form:errors></td></tr>
<tr><td>Expire Date</td><td>:</td>
<td><form:input path="expiredate"   placeholder="MM/YYYY"/></td><td><form:errors path="expiredate" cssClass="error"></form:errors></td></tr>
<tr><td>Cvv Number</td><td>:</td>
<td><form:input path="cvvnumber"  placeholder="Cvv Number"/></td><td><form:errors path="cvvnumber" cssClass="error"></form:errors></td></tr>
</table>
 <center><input type="submit" Class="button" value="Pay" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="reset" value="Reset" Class="button"/></center>
</form:form>
</security:authorize>
</body>
</html>