<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_Admin">
<br>
<jsp:include page="adminchangepassword.jsp"></jsp:include>
<h4 align="center" style="color:red">Old Password is in correct</h4>
</security:authorize>
</body>
</html>