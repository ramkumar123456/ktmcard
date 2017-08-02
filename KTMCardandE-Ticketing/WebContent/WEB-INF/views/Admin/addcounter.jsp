<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Counters</title>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
       <link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
     
  <style>
 .error{
 color: #ff0000;
 }
    .txt {
 	border:2px solid #b3b3b3;
	width: 160px;
    heigth:25px; 
    border-radius:10px;
}
.button{
border:1px solid #999999; -webkit-border-radius: 42px; -moz-border-radius: 42px;border-radius: 42px;font-size:12px;font-family:times new roman, helvetica, sans-serif; padding: 5px 15px 5px 15px; text-decoration:none; display:inline-block;text-shadow: 1px 1px 0 rgba(255,255,255,0.3);font-weight:bold; color: #000000;
 background-color: #FFFFFF; background-image: -webkit-gradient(linear, left top, left bottom, from(#FFFFFF), to(#CFCFCF));
 background-image: -webkit-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -moz-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -ms-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -o-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: linear-gradient(to bottom, #FFFFFF, #CFCFCF);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#FFFFFF, endColorstr=#CFCFCF);
}

.button:hover{
 border:1px solid #7A7A7A;
 background-color: #EEEEEE; background-image: -webkit-gradient(linear, left top, left bottom, from(#EEEEEE), to(#C7C7C7));
 background-image: -webkit-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -moz-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -ms-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -o-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: linear-gradient(to bottom, #EEEEEE, #C7C7C7);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#EEEEEE, endColorstr=#C7C7C7);
}
 </style>
 <script>
      function uniqueuser(){
    		var u= document.getElementById("username").value;
    		$.ajax({
    				
    				url:'addcountre_userunique.html',
    				success:function(result)
    				{
    				var e = result.trim().split(",");
    					
    					for (var i=0;i<e.length;i++)
    						{
    						
    						if(u == e[i])
    							{
    						
    							document.getElementById("sid").innerHTML ="Username " + u  + " already exists,Please try another name";
    							
    							
    							document.getElementById("username").value = "";
    						
    							return false;
    							}
    						else{
    							document.getElementById("sid").innerHTML= "";

    						}
    						
    						}
    					}
    			});


    		}
      
      </script>
     <!--  <script type="text/javascript">
        function getStationName(){
        	alert("hi");
            var val = $('#stationcode').combogrid('getValue');
            alert(val);
        }
        </script> -->
        
  
   <script>
   function getStationName()
  {
	
	 /*   var val = $('#stationname').combogrid('grid');
	   
	   var r = val.datagrid('getSelected'); */
	  
	   var sname = $('#stationname').combogrid('getValue');
	   //alert(sname);
	  $.ajax({
	   	 
	    url: 'ktm_StationsCode.html',   
	   	data:"stationname="+sname,
	   
	    success: function(response){
	   			
	      
	   			//alert(response);
	   			
	   		    document.getElementById("stationcode").value = response;
	   			
				 
	   		
	    },
	    error: function(e){
	   		// alert('Error: ' + e);
	    }
	    }); 
} 
  
  </script>       
        
        
        
        
        
</head>

<body>
<security:authorize ifAnyGranted="ROLE_Admin">
<br>
<h2 align="center">Add Counter:</h2>
<div align="center">

<form:form action="/KTMCardandE-Ticketing/addcountersucc.html" method="POST">
<table border="0" align="center" cellpadding="3" cellspacing="2">
<tr>
		<td></td>
		<td><form:hidden path="id"/></td>
	  </tr>
	  <tr>
		<td></td>
		<td><form:hidden path="type"/></td>
	  </tr>
<tr><td cssStyle="height:20px">UserName</td><td cssStyle="width:18px;">:</td>
<td><form:input path="username" cssClass="txt" cssStyle="height:18px;" styleId="username" onchange="uniqueuser()"/><td><span id="sid" style="color:red"></span><form:errors path="username" cssClass="error"></form:errors></td></tr>
<tr><td cssStyle="height:20px">Password:</td><td cssStyle="width:18px;">:</td>
<td><form:password path="password" cssClass="txt" cssStyle="height:18px;" styleId="password"/></td><td><form:errors path="password" cssClass="error"></form:errors></td></tr>
<tr><td cssStyle="height:20px">ConformPassword:</td><td cssStyle="width:18px;">:</td>
<td><form:password path="conformpassword" cssClass="txt" cssStyle="height:18px;" styleId="conformpassword"/></td><td><form:errors path="conformpassword" cssClass="error"></form:errors></td></tr>
<tr>
	<td cssStyle="height:20px">StationName</td><td cssStyle="width:18px;">:</td>
	<%-- <td><form:input path="stationname" cssClass="txt" cssStyle="height:18px;" styleId="stationname"/></td> --%>
	
	<td><form:select class="easyui-combogrid" path="stationname"  id="stationname" name="stationname" value="stationname" cssStyle="width:150px" data-options="
           panelWidth: 200,
            idField: 'stationname',
            textField: 'stationname',
                        url: 'ktm_Stations.html',
            
           	loadMsg:'please wait data is loading',
              editable:false,
            columns: [[
                {field:'stationname',title:'stationname',width:100}
               ]],
            
             onLoadSuccess:function(data){
			                 var x = '${command.stationname}';
			                 $(this).combogrid('setValue',x);
			                 },
				           fitColumns: true">
	    
    </form:select>
                    
                    
                    </td>
	<td><form:errors path="stationname" cssClass="error"></form:errors></td></tr>
<tr>
	<td cssStyle="height:20px">StationCode</td><td cssStyle="width:18px;">:</td>
<td><form:input path="stationcode" cssClass="txt" styleId="stationcode" onchange="unique()" onclick="getStationName()" cssStyle="height:18px;" readonly="true"/></td>



<%-- <td><form:select class="easyui-combogrid" path="stationcode"  onclick="getStationName()" id="stationcode" name="stationcode" cssStyle="width:150px" data-options="
           panelWidth: 200,
            idField: 'stationcode',
            textField: 'stationcode',
            url: 'ktm_StationsCode.html',
            
           	loadMsg:'please wait data is loading',
              editable:false,
            columns: [[
                {field:'stationcode',title:'stationcode',width:100}
               ]],
            
             onLoadSuccess:function(data){
			                 var x = '${command.stationcode}';
			                 $(this).combogrid('setValue',x);
			                 },
				           fitColumns: true">
	    
    </form:select>
                    
                    
                    </td> --%>

<td><span id="sid" style="color:red"></span>
<form:errors path="stationcode" cssClass="error"></form:errors></td></tr>
<tr><td cssStyle="height:20px">City</td><td cssStyle="width:18px;">:</td>
<td><form:input path="city" cssClass="txt" cssStyle="height:18px;"/></td><td><form:errors path="city" cssClass="error"></form:errors></td></tr>

<tr><td cssStyle="height:20px">Pincode</td><td cssStyle="width:18px;">:</td>
<td><form:input path="pincode" cssClass="txt" cssStyle="height:18px;"/></td><td><form:errors path="pincode" cssClass="error"></form:errors></td></tr>
</td></tr>

<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr><td></td><td></td>
<td colspan="2" align="left"><input type="submit" value="Add" Class="button"/>
 &nbsp&nbsp&nbsp&nbsp
 <input type="button" value="Reset" onClick="this.form.reset()" Class="button"/></td> </tr>
</table>
 </form:form>
</div>
</security:authorize>
</body>
</html>