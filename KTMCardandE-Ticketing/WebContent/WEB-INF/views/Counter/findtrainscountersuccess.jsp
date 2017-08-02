<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%> 
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.view {
    background-color: #FFE4C4;
    border: 1px dotted #999;
    padding: 10px 20px 20px 20px;
    width: 10%;


    margin-bottom: -5px;
}</style>

<script type="text/javascript">
function getmenubyusername(value)
{
	//alert(value);
	var a=value.split("@");
	var m=a[0];
	var n=a[1];
	window.open('journytkt.html?r='+m+'&w='+n, 'Ticket', 'width=300,height=400');	
	}



</script>
<script type="text/javascript">
function gettrainstopdetails(value)
{
	var a=value;
	window.open('trainstopdetails.html?r='+a, 'Ticket', 'width=600,height=600');
	
	}

</script>

</head>
<body>
<security:authorize ifAnyGranted="ROLE_Counter">
<display:table name ="sessionScope.trainslistt" id ="aaa"  requestURI="prs_userfindtraidddns.htm" class="table123">     	
    	  
    	 
    	<display:column property ="trainnumber" title ="Train Number" class="view" ></display:column>
	    <display:column property ="source" title ="Source" class="view"></display:column>
		<display:column property ="destination" title ="Destination" class="view"></display:column>
	    <display:column property ="arrivaltime" title = "Arrivaltime" class="view"></display:column>
		<display:column property ="departuretime" title = "Departure Time" class="view"></display:column>
		<display:column property ="basefare" title = "Base Fare" class="view"></display:column>
	   		<display:column property ="btn" title = "Book" class="view"></display:column>
	   
		</display:table></security:authorize>
		</body>
</html>