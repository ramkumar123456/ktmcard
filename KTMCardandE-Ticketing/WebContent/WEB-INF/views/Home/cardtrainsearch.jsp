<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RegisterationPage</title>
<!-- <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script> -->
      
      <!-- for date picker -->
    <link href="Datepicker/jquery-ui.css" rel="stylesheet">
      <script src="Datepicker/jquery-1.10.2.js"></script>
      <script src="Datepicker/jquery-ui.js"></script> 
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
<body onload="lng();">
<br>
<h2 align="center">Search for train tickets!</h2>
<div align="center">
<form:form action="/KTMCardandE-Ticketing/cardbooksearch.html" method="GET">
<table border="0" align="center" cellpadding="3" cellspacing="2">
<tr><td cssStyle="height:20px">Source</td><td cssStyle="width:18px;">:</td>
<td><input path="from" cssClass="txt" cssStyle="height:18px;" styleId="from"/></td><td><form:errors path="from" cssClass="error"></form:errors></td></tr>
<tr><td cssStyle="height:20px">Destination</td><td cssStyle="width:18px;">:</td>
<td><input path="to" cssClass="txt" cssStyle="height:18px;" styleId="to"/></td><td><form:errors path="to" cssClass="error"></form:errors></td></tr>

<tr>
<tr><td cssStyle="height:20px">Date Of Journey</td><td cssStyle="width:18px;">:</td>
<td><input path="date" class="easyui-datebox"  cssStyle="txt:height:12px;" id="dateofbirth" editable="false"/></td><td><form:errors path="date" cssClass="error"></form:errors></td></tr>

<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr><td></td>
 <td colspan="2" align="center"><input type="submit" value="Submit" Class="button"/>&nbsp&nbsp&nbsp&nbsp
 <input type="button" value="Reset" onClick="this.form.reset()" Class="button"/></td> </tr>
 </td>
 </tr>
</table>
 </form:form>

</div>
</body>
</html>