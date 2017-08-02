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
<center><h2><font color="red">Please Enter ValidCard Number Of Your Account</font></h2></center><br>
<jsp:include page="rechargecard.jsp"></jsp:include>
</security:authorize>
</body>
</html>