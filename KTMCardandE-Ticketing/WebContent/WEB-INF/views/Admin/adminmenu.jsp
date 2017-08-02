<%@page contentType="text/html" pageEncoding="UTF-8"%>
      <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
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
<security:authorize ifAnyGranted="ROLE_Admin">
<br>
<ul>
  <li><a href="adminhome.html" >Home</a></li>
    <li><a href="counters.html" >Counters</a></li>
    <li><a href="requestedcards.html" >RequestedddCards</a></li>
    
    <li class="dropdown"><a>Profile</a>
    <div class="dropdown-content">
    <a href="adminupdateprofile.html">UpdateProfile</a>
      <a href="adminchangepassword.html">ChangePassword</a>
    </div>
   <li style="float:right"><a href="adminlogout.html">Logout</a></li>
    
  </ul>
  </security:authorize>
</body>
</html>
