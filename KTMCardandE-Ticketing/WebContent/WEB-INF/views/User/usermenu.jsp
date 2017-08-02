<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
var slideimages=new Array()
function slideshowimages()
{
for (i=0;i<slideshowimages.arguments.length;i++)
{
slideimages[i]=new Image()
slideimages[i].src=slideshowimages.arguments[i]
}
}
</script>
    </head>
    <body >
    
    <security:authorize ifAnyGranted="ROLE_User">
<img src="images/jj.jpg" alt="We will help you" title="We will help you" name="slide" border=0 width=1250 height=600>
<script type="text/javascript">
slideshowimages("images/k1.jpg","images/kk.jpg","images/ki.jpg","images/jjj.jpg")
var slideshowspeed=3500
var whichimage=0
function slideit()
{
if (!document.images)
return
document.images.slide.src=slideimages[whichimage].src
if (whichimage<slideimages.length-1)
whichimage++
else
whichimage=0
setTimeout("slideit()",slideshowspeed)
}
slideit()
</script>
</security:authorize>
    </body>
</html>