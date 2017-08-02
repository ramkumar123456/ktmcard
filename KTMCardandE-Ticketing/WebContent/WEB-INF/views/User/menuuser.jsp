<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}
li {
    float: left;
}
li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
	}
a:hover:not(.active) {
    background-color: #111;
}
.active {
background-color:#4CAF50;
}
li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #111; /*background colour for dropdown menu*/
    min-width: 140px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: white;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #111}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_User">
<ul>
<li><a href="userhome1.html">Home</a></li>
<li><a href="bookticket11.html">Book A Ticket</a></li>
<li><a href="rechargecard1.html">Recharge Card</a></li>
<li><a href="topuptransactions1.html">My TopUps</a></li>
<li><a href="viewbalance1.html">View Balance</a></li>
<li class="dropdown"><a>Profile</a>
    <div class="dropdown-content">
    <a href="userupdate1.html">UpdateProfile</a>
      <a href="changepassword1.html">ChangePassword</a>
    </div>

<li style="float:right"><a href="adminlogout.html">Logout</a></li>
</ul>
</security:authorize>
</body>
</html>


