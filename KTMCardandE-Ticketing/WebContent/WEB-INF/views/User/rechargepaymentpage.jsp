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
<!-- 
<script>
function creditcard()
{

 window.open('creditcard.html', 'AddAmount','height=700,width=700,left=200,top=100,overflow:scroll');

}  
</script> 
<script>
function debitcard()
{

 window.open('debitcard.html', 'AddAmount','height=700,width=700,left=200,top=100,overflow:scroll');

}  
</script> 
<script>
function netbanking()
{

 window.open('netbanking.html', 'AddAmount','height=700,width=700,left=200,top=100,overflow:scroll');

}  
</script> 
<script>
function otherwallets()
{

 window.open('otherwallets.html', 'AddAmount','height=700,width=700,left=200,top=100,overflow:scroll');

}  
</script>  -->
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
<security:authorize ifAnyGranted="ROLE_User">
<br><br>
<table align="center">
<tr><td><h2>Select Payment Method</h2></td></tr><tr></tr><tr></tr>
<tr><td align="center"><a href="creditcardrecharge.html">CreditCard</a></td></tr>
<tr><td align="center"><a href="debitcardrecharge.html">DebitCard</a></td></tr>
<tr><td align="center"><a href="netbankingrecharge.html">NetBanking</a></td></tr>
<!-- <tr><td align="center"><a onclick="otherwallets()">OtherWallets</a></td></tr>
 --><!-- <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr><td></td>
<td colspan="2" align="center"><input type="submit" Class="button" value="Submit" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" value="Reset" onClick="resetfg()" Class="button"/></td></tr>

  -->
 <!-- <a href="adminlogin.html">AdminLogin</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="counterlogin.html">CounterLogin</a></h2> -->
 
</table>
</security:authorize>
</body>
</html>