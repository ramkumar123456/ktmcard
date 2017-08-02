<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
              <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Trains</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
<script type="text/javascript">

function checnum()
{
	
	var dd = document.getElementById("numberofstops").value;
	
	if(isNaN(dd))
	{
		da = dd.substring(0,(dd.length-1));
	
		document.getElementById("numberofstops").value = da;
	}
}  

function dyn()
{
	 var tot = document.getElementById("numberofstops").value;
	 //alert("....tot value....."+tot);
	  var tbl = document.getElementById("d1"); 
	 var tbl3 = document.getElementById("d3");
	 var tbl5 = document.getElementById("d5");
	 var tbl6 = document.getElementById("d6");
	
	 /* var tbl7 = document.getElementById("my_div7"); */
	 var a='';
	 
	 var d='';
	 var e='';
	 var f='';
	 var g='';

		 <%
		 String atimes=(String)session.getAttribute("atimes");
		 String dtimes=(String)session.getAttribute("dtimes");
		 String stops=(String)session.getAttribute("nst");
		 String stations=(String)session.getAttribute("stations");
		 String dis1=(String)session.getAttribute("dis");
		 String at[]=atimes.split(",");
		 String dt[]=dtimes.split(",");
		 String st[]=stations.split(",");
		 String dis[]=dis1.split(",");
		 for(int i=0;i<Integer.parseInt(stops);i++)
			{
			 System.out.println("................................. in jsp is................."+i);
			 System.out.println("the arrival time length in jsp is................."+atimes.length());
				System.out.println("The arrival split times are in jsp...................::::::::::::::::"+at[i]);
			 %> 
				a += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stop'+<%=i+1%>+'  '+' '+'<input type="text" id=stops<%=i+1%> value="<%=st[i+1]%>" maxlength= "20" name=stop'+<%=i+1%>+'>';
				 
				 e +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Arrival Time'+''+'  '+'<input type="text" id=spn<%=i+1%> name=arrivaltime'+<%=i+1%>+' value="<%=at[i+1]%>" data-options="showSeconds:true,editable:false">';
				 f +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time'+''+'  '+'<input type="text" id=spnd<%=i+1%> name=departuretime'+<%=i+1%>+' value="<%=dt[i+1]%>" data-options="showSeconds:true,editable:false">';
				 g +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Distance From Source'+''+'  '+'<input type="text" id=spndd<%=i+1%> id="text"  maxlength= "20" value="<%=dis[i+1]%>" name=distance'+<%=i+1%>+'>';
				  <% } %>
	

     tbl.innerHTML=a;  
	 tbl3.innerHTML=e;//e
	 tbl5.innerHTML=f;
	 tbl6.innerHTML=g;
	 
	 for(var i=1; i<=tot; i++)
	 {
		 $('#spn'+i).timespinner({
			    showSeconds: false
			});
		 $('#spnd'+i).timespinner({
			    showSeconds: false
			});
	
	 $('#spndd'+i).numberspinner();
	 
	 
	  $('#stops'+i).combogrid({
		 panelWidth:200,
		 editable:false,
		 loadMsg:'please wait data is loading',
		 
		    idField:'stationname',
		    textField:'stationname',
		    url:'ktm_Stations.html',
		    columns:[[
		        {field:'stationname',title:'Stop Name',width:80},
		       	    ]],
	 onLoadSuccess:function(data){
			var x = '${command.source}';
			$('#stops'+i).combogrid('setValue',x);
			},		
	     fitColumns: true   

		}); 
	 
	 }
}
	
</script>
<script type="text/javascript">
function dyn1()
{
	 var tot = document.getElementById("numberofstops").value;
	 //alert("....tot value....."+tot);
	  var tbl = document.getElementById("d1"); 
	 var tbl3 = document.getElementById("d3");
	 var tbl5 = document.getElementById("d5");
	 var tbl6 = document.getElementById("d6");
	 /* var tbl7 = document.getElementById("my_div7"); */
	 var a='';
	 
	 var d='';
	 var e='';
	 var f='';
	 var g='';
	for(var i=0; i<tot; i++)
	{
		
		
		p=i+1;
	 // alert('221221');
	  a += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stop'+p+'  '+' '+'<input type="text" id=stops'+i+'  maxlength="20" name=stop'+i+'>';
	 
	  e +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Arrival Time'+''+'  '+'<input type="text" id=spn'+i+' name=arrivaltime'+i+' data-options="showSeconds:true,editable:false">';
	  f +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time'+''+'  '+'<input type="text" id=spnd'+i+' name=departuretime'+i+' data-options="showSeconds:true,editable:false">';
	  g +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Distance From Source'+''+'  '+'<input type="text" id=spndd'+i+' maxlength= "20" name=distance'+i+'>';
	  // b +=
	  
	  //alert('#mmm'+i);
	 
	  
	  // alert("textbox"+i);
	}

	  tbl.innerHTML=a;  
	
	 tbl3.innerHTML=e;//e
	 tbl5.innerHTML=f;
	 tbl6.innerHTML=g;
	 
	 for(var i=0; i<tot; i++)
	 {
	 	//alert("mmm");
	
	 
	 $('#spn'+i).timespinner({
			    showSeconds: false
			});
		 $('#spnd'+i).timespinner({
			    showSeconds: false
			});
	 $('#spndd'+i).numberspinner();
	
	 
	 
	  $('#stops'+i).combogrid({
		 panelWidth:200,
		 editable:false,
		 loadMsg:'please wait data is loading',
		 
		    idField:'stationname',
		    textField:'stationname',
		    url:'ktm_Stations.html',
		    columns:[[
		        {field:'stationname',title:'Stop Name',width:80},
		       	    ]],
	 onLoadSuccess:function(data){
			var x = '${command.source}';
			$('#stops'+i).combogrid('setValue',x);
			},		
	     fitColumns: true   

		}); 
	 
	 }
	
	}
</script>



 
 <script type="text/javascript">
 function stop()
 {
	 var s='${command.numberofstops}';
	 var st11=document.getElementById("st1").value;
	 var sp11="";
	 var st22=document.getElementById("st2").value;
	 var sp22="";
	 var st33=document.getElementById("st3").value;
	 var sp33="";
	 var st44=document.getElementById("st4").value;
	 var sp44="";
	 if(st11=="")
		 {
	  		sp11='${command.stations}';
		 }
	 else
		 {
		 	sp11=st11;
		 }
	 if(st22==""){
		 
		 sp22='${command.arrivaltimes}';
	 }
	 else{
		 
	sp22=st22;	 
	 }
	 
	 if(st33=="")
	 {
	  		sp33='${command.departuretimes}';
		 }
	 else
		 {
		 	sp33=st33;
		 }
	 if(st44==""){
		 
		 sp44='${command.distancefromsource}';
	 }
	 else{
		 
	sp44=st44;	 
	 }
	 //alert(sp);
	  //alert(s);
	if(s!="")
		{
		 var tbl = document.getElementById("d1"); 
		 var tbl3 = document.getElementById("d3");
		 var tbl5 = document.getElementById("d5");
		 var tbl6 = document.getElementById("d6");
	 
	 
	 var a='';
	 var e='';
	 var f='';
	 var g='';
	 var a111;
	 var a222;
	 var a333;
	 var a444;
	 
			
	for(var i=0; i<s; i++)
	{
		var p=i+1;
		if(!(sp11=="")){
		 a111=sp11.split(",")[i+1];
		 a222=sp22.split(",")[i+1];
		a333=sp33.split(",")[i+1];
		a444=sp44.split(",")[i+1];
		}
		else{
			 a111="";
			 a222="";
			a333="";
			a444="";
		
		}
		 a += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stop'+p+'  '+' '+'<input type="text" id=stops'+i+' maxlength="20" name=stop'+i+' value='+a111+'>';
		 
		  e +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Arrival Time'+''+'  '+'<input type="text" id=spn'+i+' name=arrivaltime'+i+' data-options="showSeconds:true,editable:false"  value='+a222+'>';
		  f +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time'+''+'  '+'<input type="text" id=spnd'+i+' name=departuretime'+i+'  data-options="showSeconds:true,editable:false"  value='+a333+'>';
		  g +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Distance From Source'+''+'  '+'<input type="text" id=spndd'+i+' maxlength= "20" name=distance'+i+' value='+a444+'>';
	
	
		}
	 
	     tbl.innerHTML=a; 
		 tbl3.innerHTML=e;
		 tbl5.innerHTML=f;
		 tbl6.innerHTML=g;
		 
		 for(var i=0; i<=s; i++)
		 {
		 	
		
		 
			 $('#spn'+i).timespinner({
				    showSeconds: false
				});
			 $('#spnd'+i).timespinner({
				    showSeconds: false
				});
		 $('#spndd'+i).numberspinner();
		 
		 
		  $('#stops'+i).combogrid({
			 panelWidth:200,
			 editable:false,
			 loadMsg:'please wait data is loading',
			 
			    idField:'stationname',
			    textField:'stationname',
			    url:'ktm_Stations.html',
			    columns:[[
			        {field:'stationname',title:'Stop Name',width:80},
			       	    ]],
			       		
				 	     fitColumns: true   
				 		});   
		 
		 }
	 
		}
	
	
	
 
 }
 
 </script>
 
 <script type="text/javascript">
 $(document).ready(function () {
	
		var source='${command.source}';
	 var s='${command.numberofstops}';
	 var st11=document.getElementById("st1").value;
	 var sp11="";
	 var st22=document.getElementById("st2").value;
	 var sp22="";
	 var st33=document.getElementById("st3").value;
	 var sp33="";
	 var st44=document.getElementById("st4").value;
	 var sp44="";
	 if(st11=="")
		 {
	  		sp11='${command.stations}';
		 }
	 else
		 {
		 	sp11=st11;
		 }
	 if(st22==""){
		 
		 sp22='${command.arrivaltimes}';
	 }
	 else{
		 
	sp22=st22;	 
	 }
	 
	 if(st33=="")
	 {
	  		sp33='${command.departuretimes}';
		 }
	 else
		 {
		 	sp33=st33;
		 }
	 if(st44==""){
		 
		 sp44='${command.distancefromsource}';
	 }
	 else{
		 
	sp44=st44;	 
	 }
	 //alert(sp);
	  //alert(s);
	if(s!="")
		{
		 var tbl = document.getElementById("d1"); 
		 var tbl3 = document.getElementById("d3");
		 var tbl5 = document.getElementById("d5");
		 var tbl6 = document.getElementById("d6");
	 
	 
	 var a='';
	 var e='';
	 var f='';
	 var g='';
	 var a111;
	 var a222;
	 var a333;
	 var a444;
	 
			
	for(var i=0; i<s; i++)
	{
		var p=i+1;
		if(!(sp11=="")){
		 a111=sp11.split(",")[i+1];
		 a222=sp22.split(",")[i+1];
		a333=sp33.split(",")[i+1];
		a444=sp44.split(",")[i+1];
		}
		else{
			 a111="";
			 a222="";
			a333="";
			a444="";
		
		}
		 a += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stop'+p+'  '+' '+'<input type="text" id=stops'+i+' maxlength="20" name=stop'+i+' value='+a111+'>';
		 
		  e +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Arrival Time'+''+'  '+'<input type="text" id=spn'+i+' name=arrivaltime'+i+' data-options="showSeconds:true,editable:false"  value='+a222+'>';
		  f +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time'+''+'  '+'<input type="text" id=spnd'+i+' name=departuretime'+i+'  data-options="showSeconds:true,editable:false"  value='+a333+'>';
		  g +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Distance From Source'+''+'  '+'<input type="text" id=spndd'+i+' maxlength= "20" name=distance'+i+' value='+a444+'>';
	
	
		}
	 
	     tbl.innerHTML=a; 
		 tbl3.innerHTML=e;
		 tbl5.innerHTML=f;
		 tbl6.innerHTML=g;
		 
		 for(var i=0; i<=s; i++)
		 {
		 	
		
		 
			 $('#spn'+i).timespinner({
				    showSeconds: false
				});
			 $('#spnd'+i).timespinner({
				    showSeconds: false
				});
		 $('#spndd'+i).numberspinner();
		 
		 
		  $('#stops'+i).combogrid({
			 panelWidth:200,
			 editable:false,
			 loadMsg:'please wait data is loading',
			 
			    idField:'stationname',
			    textField:'stationname',
			    url:'ktm_Stations.html',
			    columns:[[
			        {field:'stationname',title:'Stop Name',width:80},
			       	    ]],
	
				 	     fitColumns: true   
				 		});   
		 
		 }
	 
		}
	for(var i=0;i<sp11.split(",").length;i++)
	 {	 
/* 	 document.getElementById('stops'+i).value=sp11.split(",")[i+1]; */
/* 	 document.getElementById('spn'+i).value=sp22.split(",")[i+1];
	 document.getElementById('spnd'+i).value=sp33.split(",")[i+1];
	 document.getElementById('spndd'+i).value=sp44.split(",")[i+1]; */
	 }
			
 });
</script>



<script type="text/javascript">

function  changeIt()
{

	var st11="";
	var st22="";
	var st33="";
	var st44="";
	var c=document.getElementById("nstop").value;

	
	if(c=="")
		{
		st11="${command.stations}";
		st22="${command.arrivaltimes}";
		st33="${command.departuretimes}";
		st44="${command.distancefromsource}";
		
		}
		else
			{
			st11="";
			st22="";
			st33="";
			st44="";
			}
	
	for(var i=0;i<c;i++)
	{	 
		//alert("enerd to loop"+document.getElementById('text'+i).value);
		if(st11!="")
		{
			st11=st11+","+document.getElementById('stops'+i).value;
		}
		else
		{
			//alert("enterd to else"+document.getElementById('text'+i).value);
			st11=document.getElementById('stops'+i).value;
		}
		if(st22!="")
		{
			st22=st22+","+document.getElementById('spn'+i).value;
		}
		else
		{
			//alert("enterd to else"+document.getElementById('text'+i).value);
			st22=document.getElementById('spn'+i).value;
		}
		if(st33!="")
		{
			st33=st33+","+document.getElementById('spnd'+i).value;
		}
		else
		{
			//alert("enterd to else"+document.getElementById('text'+i).value);
			st33=document.getElementById('spnd'+i).value;
		}
		if(st44!="")
		{
			st44=st44+","+document.getElementById('spndd'+i).value;
			
		}
		else
		{
			//alert("enterd to else"+document.getElementById('text'+i).value);
			st44=document.getElementById('spndd'+i).value;
		}
		
		
	}	
	//alert(st);
	document.getElementById("st1").value=st11;
	document.getElementById("st2").value=st22;
	document.getElementById("st3").value=st33;
	document.getElementById("st4").value=st44;
	
 	var tot = document.getElementById("numberofstops").value;
 //	alert("tot..."+tot);
 document.getElementById("nstop").value=tot;
 var tbl = document.getElementById("d1");
 var tbl3 = document.getElementById("d3");
 var tbl5 = document.getElementById("d5");
 var tbl6 = document.getElementById("d6");
 var sp='${command.stations}';
//alert(sp);
 var a='';
 var e='';
 var f='';
 var g='';
for(var i=0; i<=tot; i++)
{
	var p=i+1;
	 a += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stop'+p+'  '+' '+'<input type="text" id=stops'+p+'  maxlength= "20" name=stop'+p+'>';
	 
	  e +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Arrival Time'+''+'  '+'<input type="text" id=spn'+p+' name=arrivaltime'+p+' data-options="showSeconds:true,editable:false">';
	  f +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time'+''+'  '+'<input type="text" id=spnd'+p+' name=departuretime'+p+' data-options="showSeconds:true,editable:false">';
	  g +='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Distance From Source'+''+'  '+'<input type="text" id=spndd'+p+' maxlength= "20" name=distance'+p+'>';

}

 tbl.innerHTML=a; 
 tbl3.innerHTML=e;
 tbl5.innerHTML=f;
 tbl6.innerHTML=g;
 for(var i=0; i<=tot; i++)
 {
 	//alert("mmm");

 
 $('#spn'+i).timespinner({
			    showSeconds: false
			});
		 $('#spnd'+i).timespinner({
			    showSeconds: false
			});
 
 
  $('#stops'+i).combogrid({
	 panelWidth:200,
	 editable:false,
	 loadMsg:'please wait data is loading',
	 
	    idField:'stationname',
	    textField:'stationname',
	    url:'ktm_Stations.html',
	    columns:[[
	        {field:'stationname',title:'Stop Name',width:80},
	       	    ]],
 onLoadSuccess:function(data){
		var x = '${command.stations}';
		$('#stops'+i).combogrid('setValue',x);
		},		
     fitColumns: true   

	}); 
 
 }

 

 
}
</script>
 
 
</head>
<body onload="stop();">
<security:authorize ifAnyGranted="ROLE_Admin">
<br>
<h2>Update Trains</h2>
	<form:form method="GET" action="updatetrains1.html" commandName="command">
	<input type="hidden" name="nstop" id="nstop"/>
<input type="hidden" name="st1" id="st1"/>
<input type="hidden" name="st2" id="st2"/>
<input type="hidden" name="st3" id="st3"/>
<input type="hidden" name="st4" id="st4"/>
<table>
			    <tr>
			        <td><form:label path="trainid">trainid:</form:label></td>
			        <td><form:input path="trainid"/></td>
			   		    <tr>
			        <td><form:label path="trainnumber">TrainNumber:</form:label></td>
			        <td><form:input path="trainnumber" class="easyui-numberspinner"/></td>
			    	<td><form:errors path="trainnumber" cssClass="error"></form:errors></td>
			    </tr>
			   <tr>
			        <td><form:label path="source">Source:</form:label></td>
			        <td><form:select class="easyui-combogrid" path="source"  id="source"  cssStyle="width:150px"  data-options="
           panelWidth: 200,
           value:'${command.source}',
            idField: 'stationname',
            textField: 'stationname',
                        url: 'ktm_Stations.html',
            
           	loadMsg:'please wait data is loading',
              editable:false,
            columns: [[
                {field:'stationname',title:'Souce',width:80}
               ]],
            
				           fitColumns: true">
	    
    </form:select>
                    
                    
                    </td>
             <td><form:errors path="source" cssClass="error"></form:errors></td>
                    
			    </tr>
			      <tr>
			        <td><form:label path="destination">Destination:</form:label></td>
			        <td><form:select class="easyui-combogrid" path="destination"  id="specializtationdoctor1"  cssStyle="width:150px" value="${command.destination}" data-options="
           panelWidth: 200,
           value:'${command.destination}',
            idField: 'stationname',
            textField: 'stationname',
                        url: 'ktm_Stations.html',
            
           	loadMsg:'please wait data is loading',
              editable:false,
            columns: [[
                {field:'stationname',title:'Souce',width:80}
               ]],
            
				           fitColumns: true">
	    	
    </form:select>    
                    </td>
         <td><form:errors path="destination" cssClass="error"></form:errors></td>
                    
			    </tr>
			    <tr>
			        <td><form:label path="arrivaltime">ArrivalTime:</form:label></td>
			        <td><form:input class="easyui-timespinner" path="arrivaltime"/></td>
			    	<td><form:errors path="arrivaltime" cssClass="error"></form:errors></td>
			    
			    </tr>
			      <tr>
			        <td><form:label path="departuretime">DepartureTime:</form:label></td>
			        <td><form:input class="easyui-timespinner" path="departuretime"/></td>
			       <td><form:errors path="departuretime" cssClass="error"></form:errors></td>
			        
			    </tr>
			     <tr>
			        <td><form:label path="totalkms">TotalKms:</form:label></td>
			        <td><form:input path="totalkms" class="easyui-numberspinner"/></td>
			      <td><form:errors path="totalkms" cssClass="error"></form:errors></td>
			        
			    </tr>
			     <tr>
			        <td><form:label path="basefare">BaseFare:</form:label></td>
			        <td><form:input path="basefare" onblur="getvalue();"/></td>
			  	<td><form:errors path="basefare" cssClass="error"></form:errors></td>
			  
			    </tr>
			    <tr>
			        <td><form:label path="numberofstops">NumberOfStops:</form:label></td>
			        <td><form:input path="numberofstops" onkeyup="dyn1();checnum()" onkeypress="return isNumber(event)" maxlength="2"  id="numberofstops"/></td>
			       <td><form:errors path="numberofstops" cssClass="error"></form:errors></td>
			        
			    </tr>
			 <tr>
<td><div id="d1"></div><font color="red"><form:errors  path="stations"/></font></td>

<td><div id="d3"></div><font color="red"><form:errors  path="arrivaltimes"/></font></td>
<td><div id="d5"></div><font color="red"><form:errors  path="departuretimes"/></font></td>
<td><div id="d6"></div><font color="red"><form:errors  path="distancefromsource"/></font></td></tr>

			     
			   <%--  <tr>
			        <td><form:label path="availabledays">availabledays:</form:label></td>
			       <td><form:checkbox path="availabledays" id="su" value="Sunday" />Sunday</td></tr>
<tr><td></td><td><form:checkbox path="availabledays" id="mo" value="Monday"/>Monday</td></tr>
<tr><td></td><td><form:checkbox path="availabledays" id="tu" value="Tuesday"/>Tuesday</td></tr>
<tr><td></td><td><form:checkbox path="availabledays" id="we" value="Wednesday"/>Wednesday</td></tr>
<tr><td></td><td><form:checkbox path="availabledays" id="th" value="Thursday"/>Thursday</td></tr>
<tr><td></td><td><form:checkbox path="availabledays" id="fr" value="Friday"/>Friday</td></tr>
<tr><td></td><td><form:checkbox path="availabledays" id="sa" value="Saturday"/>Saturday</td>
			    </tr> --%>
			     <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			    </table>
</form:form>
</security:authorize>
</body>
</html>