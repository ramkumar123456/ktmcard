<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
    
   	     <script type="text/javascript" src="js1/jquery-1.4.2.min.js"></script>
		<script src="js1/jquery.autocomplete.js"></script>	
			 <link rel="stylesheet" type="text/css" href="css1/style.css"/>
	
		
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
  <style type="text/css">
 .tb5 {
	border:2px solid #456879;
	border-radius:10px;
	height: 30px;
	width: 230px;
}
 
 </style>
 <script>
jQuery(function(){
$("#ss").autocomplete("getbraches.jsp");
});
</script>
<script>
jQuery(function(){
$("#ss1").autocomplete("getbraches.jsp");
});
</script>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_Counter">
<h2 align="center">FindTrains</h2>
<form:form method="GET" action="findtraincountersucc.html">
<table border="0" align="center" cellpadding="3" cellspacing="2">
			   
			    <tr>
			        <td ><form:label path="source">Source:</form:label></td>
			        <td><form:input path="source" id="ss" cssClass="txt" cssStyle="height:18px;" /></td>
			        <td><form:errors path="source" cssClass="error"></form:errors></td>
			    </tr>
			      <tr>
			        <td ><form:label path="destination">Destination:</form:label></td>
			        <td><form:input path="destination" id="ss1" cssClass="txt" cssStyle="height:18px;" /></td><td style="color: red"><form:errors path="destination" cssClass="error"/></td>
			    </tr>
			     <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr><td></td>
                 <td colspan="2" align="left"><input type="submit" value="Submit" Class="button"/>
			    </table>
</form:form>
</security:authorize>
</body>
</html>