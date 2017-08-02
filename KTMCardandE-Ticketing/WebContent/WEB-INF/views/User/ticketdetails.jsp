<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_User">
  <form:form method="POST" action="paymentmodepage1.html">
 <TABLE BORDER="1">
            <TR>
                <TH>TRAIN NUMBER</TH>
                <TH>TRAIN NAME</TH>
                <TH>DATE</TH>
                <TH>FROM</TH>
                <th></th>
                <TH>Base Fare</TH>
                <TH>Reservation Charge</TH>
                 <TH>Service Charge</TH>
                <TH>Total Fare</TH>
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

   </TABLE>
   <center><input type="submit" VALUE="PROCEED"></center>
   
</form:form>
</security:authorize>
</body>

</html>