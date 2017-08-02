<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <script type="text/javascript">
function cls()
{
opener.location.reload(true);
self.close();
}
</script>

</head>
<body onload="cls()">
<security:authorize ifAnyGranted="ROLE_Counter">
</security:authorize>
</body>
</html>
