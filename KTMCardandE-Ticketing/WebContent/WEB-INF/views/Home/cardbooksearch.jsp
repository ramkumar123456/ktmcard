<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function cal1()
{
	document.getElementById("second").style.display="none";
	document.getElementById("second1").style.display="none";
	document.getElementById("first").style.display="inline";
	document.getElementById("first1").style.display="inline";
	}

</script>
<script type="text/javascript">
function cal2()
{
	document.getElementById("first").style.display="none";
	document.getElementById("first1").style.display="none";
	document.getElementById("second").style.display="inline";
	document.getElementById("second1").style.display="inline";
	}

function bok()
{
	window.location.href='cardbookticketcounter.html';
	}
</script>
</head>
<body>
<h2 align="center"><font color="red">List Of Trains</font></h2>
<h2 align="center"><font color="red">Select A Train And Check Avalability</font></h2>
<div id="first" style="display: none;" >
<table border="1" align="center">
  <TR bgcolor="#336DF3">
                
              <TH>TRAIN NUMBER</TH>
                <TH>TRAIN NAME</TH>
                <TH>Date</TH>
                <TH>Availability</TH>
                <TH>Book</TH>
                
            </TR>
            <TR>
              
               <TD>123456</td>
                <TD>SATHABDHI EXPRESS</TD>
                <TD>24/03/2017</TD>
                <TD>15</TD>
                <TD><input type="button" value="Book" onclick="bok();"></TD>
               
                </TR>

</table>
</div>
<br>

<div id="first1" style="display: none;" >
<table border="1" align="center">
  <TR bgcolor="#336DF3">
                
                <TH>Base Fare1</TH>
                <TH>Service Charges</TH>
            <TH>Other Charges</TH>
                <TH>Total Fare</TH> 
            </TR>
            <TR>
              
                <TD>100</TD>
                <TD>20</TD>
                <TD>10</TD>
                <TD>130</TD>
                </TR>

</table>

</div>
<div id="second" style="display: none;" >
<table border="1" align="center">
  <TR bgcolor="#336DF3">
                
              <TH>TRAIN NUMBER</TH>
                <TH>TRAIN NAME</TH>
                <TH>Date</TH>
                <TH>Availability</TH>
                <TH>Book</TH>
            </TR>
            <TR>
              
               <TD>123457</td>
                <TD>RAJADHANI EXPRESS</TD>
                <TD>24/03/2017</TD>
                <TD>25</TD>
                <TD><input type="button" value="Book" onclick="bok2();"></TD>
               
                </TR>

</table>
</div>
<br>

<div id="second1" style="display: none;" >
<table border="1" align="center">
  <TR bgcolor="#336DF3">
                
                <TH>Base Fare1</TH>
                <TH>Service Charges</TH>
            <TH>Other Charges</TH>
                <TH>Total Fare</TH> 
            </TR>
            <TR>
              
                <TD>200</TD>
                <TD>20</TD>
                <TD>10</TD>
                <TD>230</TD>
                </TR>

</table>

</div>

<%--   <form:form method="POST" action="bookingdetails1.html"> --%>
<br>
<br>
 <TABLE BORDER="1" >
            <TR bgcolor="#F6AA1C">
                <TH>TRAIN NUMBER</TH>
                <TH>TRAIN NAME</TH>
                <TH>FROM</TH>
                <TH>DEPATURE TIME</TH>
                <TH>TO</TH>
                <TH>ARRIVAL TIME</TH>
                <TH>DISTANCE</TH>
                <TH>TRAVEL TIME</TH>
                <TH>FARE DETAILS</TH> 
            </TR>
            <TR>
                <TD>123456</td>
                <TD>SATHABDHI EXPRESS</TD>
                <TD>BZA</TD>
                <TD>00:30</TD>
                <TD>SC</TD>
                <TD>06:30</TD>
                <TD>350KM</TD>
                <TD>06:05</TD>
                <td><input type="button" value="Gold" onclick="cal1()">&nbsp;<input type="button" value="Superior" onclick="cal1()">&nbsp;<input type="button" value="Economy" onclick="cal1()">&nbsp;<input type="button" value="Second" onclick="cal1()"></td>
            </TR>
   <TR>
                <TD>123457</td>
                <TD>RAJADHANI EXPRESS</TD>
                <TD>BZA</TD>
                <TD>01:30</TD>
                <TD>SC</TD>
                <TD>07:30</TD>
                <TD>350KM</TD>
                <TD>06:05</TD>
                <td><input type="button" value="Gold" onclick="cal2()">&nbsp;<input type="button" value="Superior" onclick="cal2()">&nbsp;<input type="button" value="Economy" onclick="cal2()">&nbsp;<input type="button" value="Second" onclick="cal2()"></td>
 </TR>
</table>  
<center></center>
<%-- 	</form:form>	 --%>	 
</body>
</html>