<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Trains</title>

<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
    
    <script>
function add()
{
window.location.href="addtrains.html";
}  
</script> 
<script>
function update(){
   
    var row = $('#dg').datagrid('getSelected');
        if (row){
        	
         window.location.href="edittrain.html?id="+row.trainid;

/*         window.open('ahms_admin_EditEmployee.htm?id='+row.employeeid,'EditCustomerDeatiles','height=500,width=550,left=200,top=100,overflow: scroll');                              
*/                     }
                   else
                 {
                $.messager.alert('Warning','Select atleast one row');
                 }
     
               }
   </script>
   <script>
function del(){
    var row = $('#dg').datagrid('getSelected');
        if (row){
        	
         window.location.href="deletetrain.html?id="+row.trainid;

/*         window.open('ahms_admin_EditEmployee.htm?id='+row.employeeid,'EditCustomerDeatiles','height=500,width=550,left=200,top=100,overflow: scroll');                              
*/                     }
                   else
                 {
                $.messager.alert('Warning','Select atleast one row');
                 }
     
               }
   </script>
   <script>
        function doSearch(value){
        	
            //alert('Your input: ' + value);
         
           $('#dg').datagrid({
        	   url:"trainidsearch.html?tid="+value
           });
        }
        </script> 
        <script>
      	function refreshPage()
      	{
      		$('#dg').datagrid({url:'viewtrainsgrid.html'});
    	}
	</script>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_Admin">
<br>
<center>

	
	<div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="width:100%;max-width:220px;padding:0px 0px;">
        <input class="easyui-searchbox" data-options="prompt:'Search Train Number',searcher:doSearch" style="width:100%">
    </div>
    <br>
    <br>
     <input type="button" value="Refresh" onclick="refreshPage();" />
<br>
<br>
<div id="toolbar">
    
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">Add New</a>&nbsp;&nbsp;&nbsp;
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">Update</a> &nbsp;&nbsp;&nbsp;
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">Delete</a>
       </div>

       
 <table id="dg" class="easyui-datagrid" title="All Trains are" style="width:1320px;height:250px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:true,toolbar:'#toolbar',url:'viewtrainsgrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
         <tr>
                <th align="center" data-options="field:'trainid',width:80">Train Id</th>
                 <th align="center" data-options="field:'trainnumber',width:80">Train Number</th>
                 <th align="center" data-options="field:'source',width:100">Source</th>
                <th align="center" data-options="field:'destination',width:100,align:'right'">Destination</th>
               
                 <th align="center" data-options="field:'departuretime',width:120">Departure Time</th>
                 <th align="center" data-options="field:'arrivaltime',width:120">Arrival Time</th>
                 <th align="center" data-options="field:'numberofstops',width:80">No.Of Stops</th>
                 <th align="center" data-options="field:'stations',width:500">Stations</th>
                 <th align="center" data-options="field:'arrivaltimes',width:500">Arrival Times</th>
                 <th align="center" data-options="field:'distancefromsource',width:200">Distance from source</th>
                 <th align="center" data-options="field:'basefare',width:80">Base Fare</th>
                 <th align="center" data-options="field:'totalkms',width:80">Total Kms</th>
               
       </tr>
            	
            	
	      
	        </thead> 
    </table>
    </center>
   </security:authorize> 
</body>
</html>