<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.view {
     border: 0;


}</style>
<script type="text/javascript">
function prntkt() {
	//alert("hiiiiiiiiiiiiiiiiiiiii");
var s=document.getElementById("snum").value;
var f=document.getElementById("fare").value;
		   $.ajax({
				url:'confrmticketcounter.html?numr='+s+'&fr='+f,
				success:function(result){	
					
	       }
		   
		 
		   } );
	   
		   var printButton = document.getElementById("printpagebutton");
		   printButton.style.visibility = 'hidden';
		   window.print()
	window.self.close();
}




</script>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_Counter">
<img src="images/ktmlogo.jpg" height="150px" width="250px"><br>
<form:form method="GET" action="confrmticketcounter.html">
<%
   Date date = new Date();
   out.print( "<h4 align=\"center\">" +date.toString()+"</h4>");
%>
<table width="350px">
			    <tr>
			        <td><form:label path="btn"><b>Series Number:</b></form:label></td>
			        <td><form:input path="btn" id="snum" cssClass="view" readonly="true"/></td>
			    </tr>
			    <tr></tr>
			    <tr>
			        <td><form:label path="source"><b>Source:</b></form:label></td>
			        <td><form:input path="source" cssClass="view" readonly="true"/></td>
			    </tr>
			    <tr></tr>
			    <tr>
			        <td><form:label path="destination"><b>Destination:</b></form:label></td>
			        <td><form:input path="destination" cssClass="view" readonly="true"/></td>
			    </tr>
			    <tr></tr>
			      <tr>
			        <td><form:label path="basefare"><b>Fare:</b></form:label></td>
			        <td><form:input path="basefare"  id="fare" cssClass="view" readonly="true"/></td>
			    </tr>
			    <tr></tr>
			    </table>
			    <center>Journey Should be Perform With in two hours only</center>
			    <center><input type="button" id="printpagebutton" value="Confirm" onclick="prntkt();"/></center>
			    </form:form>
			    </security:authorize>
</body>
</html>