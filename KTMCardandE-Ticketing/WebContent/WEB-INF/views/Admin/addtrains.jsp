<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
              <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
    <script type="text/javascript">
    function getvalue()
    {
    	var g = $('#source').combogrid('grid');	// get datagrid object
    	var r = g.datagrid('getSelected');	// get the selected row
    	//alert(r.stationname); 
    }
    
    </script>
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
 $(document).ready(function () {
	 
	 if(!(('${command.numberofstops}')=="")){
	/*  
	    $("#jqxExpander").jqxExpander({ width: '900px',theme:'ui-start'});
		$("#jqxButton1").jqxButton({ width: '80',theme:'ui-start'});
		$("#jqxButton").jqxButton({ width: '80',theme:'ui-start'}); */
		
		
	// alert("fdgdfg");
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
	 }
			
 });
</script>

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
 <style type="text/css">
 style scoped="scoped">
        .tb{
            width:100%;
            margin:0;
            padding:5px 4px;
            border:1px solid #ccc;
            box-sizing:border-box;
        }
    </style>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_Admin">
<br>
	<form:form method="GET" action="addtrainssavesave.html">
	<input type="hidden" name="nstop" id="nstop"/>
<input type="hidden" name="st1" id="st1"/>
<input type="hidden" name="st2" id="st2"/>
<input type="hidden" name="st3" id="st3"/>
<input type="hidden" name="st4" id="st4"/>
<table>
			   
		    <tr>
			        <td><form:label path="trainnumber">TrainNumber:</form:label></td>
			        <td><form:input path="trainnumber" class="easyui-numberspinner"/></td>
			    	<td><form:errors path="trainnumber" cssClass="error"></form:errors></td>
			    </tr>
			    <tr>
			        <td><form:label path="source">Source:</form:label></td>
			        <td><form:select class="easyui-combogrid" path="source"  id="source" cssStyle="width:150px" data-options="
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
            
             onLoadSuccess:function(data){
			                 var x = '${command.source}';
			                 $(this).combogrid('setValue',x);
			                 },
				           fitColumns: true">
	    
    </form:select>
                    
                    
                    </td>
             <td><form:errors path="source" cssClass="error"></form:errors></td>
                    
			    </tr>
			      <tr>
			        <td><form:label path="destination">Destination:</form:label></td>
			        <td><form:select class="easyui-combogrid" path="destination"  id="specializtationdoctor1"  cssStyle="width:150px" data-options="
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
            
             onLoadSuccess:function(data){
			                 var x = '${command.destination}';
			                 $(this).combogrid('setValue',x);
			                 },
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
			        <td><form:input path="basefare" onblur="getvalue();" class="easyui-numberspinner"/></td>
			  	<td><form:errors path="basefare" cssClass="error"></form:errors></td>
			  
			    </tr>
			    <tr>
			        <td><form:label path="numberofstops">NumberOfStops:</form:label></td>
			        <td><form:input path="numberofstops" onkeyup="dyn();checnum()" maxlength="2" id="numberofstops"/></td>
			       <td><form:errors path="numberofstops" cssClass="error"></form:errors></td>
			        
			    </tr>
			 <tr>
<td><div id="d1"></div><font color="red"><form:errors  path="stations"/></font></td>

<td><div id="d3"></div><font color="red"><form:errors  path="arrivaltimes"/></font></td>
<td><div id="d5"></div><font color="red"><form:errors  path="departuretimes"/></font></td>
<td><div id="d6"></div><font color="red"><form:errors  path="distancefromsource"/></font></td></tr>


  </table>

 			     
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
			   
			      <input type="submit" value="Submit"/>
		      
			  
</form:form>
</security:authorize>
</body>
</html>