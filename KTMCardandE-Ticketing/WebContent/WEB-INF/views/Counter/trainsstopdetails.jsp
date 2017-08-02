<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib uri="http://displaytag.sf.net" prefix="display"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.view {
    background-color: #33F6FF;
    border: 1px dotted #999;
    padding: 10px 20px 20px 20px;
    width: 10%;


    margin-bottom: -5px;
}</style>

</head>
<body>

<display:table name ="sessionScope.trnstops" id ="aaa"  requestURI="prs_userfindtraidddns.htm" class="table123">     	
    	  
    	 
    
	    <display:column property ="stations" title ="Station" class="view"></display:column>
		
	    <display:column property ="arrivaltimes" title = "Arrivaltime" class="view"></display:column>
		<display:column property ="departuretimes" title = "Departure Time" class="view"></display:column>
		
	   		<display:column property ="distancefromsource" title = "Distance From Source" class="view"></display:column>
	   
		</display:table>
		
</body>
</html>