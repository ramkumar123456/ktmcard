<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_User">
 <TABLE BORDER="1" align="center">
            <TR>
                <TH>DATE</TH>
                <TH>Base Fare</TH>
                <TH>Reservation Charge</TH>
                 <TH>Service Charge</TH>
                <TH>Total Fare</TH>
            </TR>
            <TR>
                <TD>25-04-2017</td>
                <TD>200</TD>
                <TD>20</TD>
                <td>10</td>
                <TD>220</TD>
                <td><a href="bookingnow1.html">Book Now</a></td>
            </TR>
</table>
<jsp:include page="trainslist.jsp"></jsp:include>
</security:authorize>
</body>
</html>