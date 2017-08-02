<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UpdateProfile</title>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
       <link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
     
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
 
</head>
<body>
<br>
<security:authorize ifAnyGranted="ROLE_Counter">
<h2 align="center">Update Profile:</h2>
<div align="center">

<form:form action="/KTMCardandE-Ticketing/updatecountersucc.html" method="GET">
<table border="0" align="center" cellpadding="3" cellspacing="2">
<tr>
		<td></td>
		<td><form:hidden path="id"/></td>
	  </tr>
<tr><td cssStyle="height:20px">UserName</td><td cssStyle="width:18px;">:</td>
<td><form:input path="username" readonly="true" cssClass="txt" cssStyle="height:18px;" styleId="username"/></td>
<tr>
		<td></td>
		<td><form:hidden path="password"/></td>
	  </tr>
<tr>
		<td></td>
		<td><form:hidden path="conformpassword"/></td>
	  </tr>
<tr><td cssStyle="height:20px">StationName</td><td cssStyle="width:18px;">:</td>
<td><form:input path="stationname" cssClass="txt" cssStyle="height:18px;" styleId="stationname" readonly="true"/></td>
<td><form:errors path="stationname" cssClass="error"></form:errors></td></tr>

<tr><td cssStyle="height:20px">StationCode</td><td cssStyle="width:18px;">:</td>
<td><form:input path="stationcode" cssClass="txt" styleId="stationcode" onchange="unique()" cssStyle="height:18px;" readonly="true"/></td>
<td><span id="sid" style="color:red"></span><form:errors path="stationcode" cssClass="error"></form:errors></td></tr>

<tr><td cssStyle="height:20px">City</td><td cssStyle="width:18px;">:</td>
<td><form:input path="city" cssClass="txt" cssStyle="height:18px;"/></td>
<td><form:errors path="city" cssClass="error"></form:errors></td></tr>

<tr><td cssStyle="height:20px">Pincode</td><td cssStyle="width:18px;">:</td>
<td><form:input path="pincode" cssClass="txt" cssStyle="height:18px;"/></td>
<td><form:errors path="pincode" cssClass="error"></form:errors></td></tr>
<tr>
		<td></td>
		<td><form:hidden path="type"/></td>
	  </tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr><td></td><td></td>
<td colspan="2" align="left"><input type="submit" value="Update" Class="button"/>
 
</table>
 </form:form>
</div>
</security:authorize>
</body>
</html>