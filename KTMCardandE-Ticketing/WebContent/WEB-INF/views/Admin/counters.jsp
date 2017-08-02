<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Counter Add</title>
 <link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
</head>
<script>
/* function add()
{
window.location.href="addemp.html";
}  */

function add()
{
	var left = (screen.width/2)-(800/2);
	var top = (screen.height/2)-(400/2);
		
	
	window.open("addcounter.html","","width=500,height=500,left="+left+",top="+top);

}  
</script> 
 
<script>
	function update()
	{
    	var row = $('#dg').datagrid('getSelected');
    	
    	if (row){
    		
         /* window.location.href="updateemp.html?id="+row.id;  */ 
    		var left = (screen.width/2)-(800/2);
    		var top = (screen.height/2)-(400/2);
    			
    	
    		window.open("updatecounter.html?id="+row.id,"","width=500,height=400,left="+left+",top="+top);
    	}
    	else
     	{
        	$.messager.alert('Warning','Please select atleast one row!');
     	}
     
    }

</script>

<script>
 function del()
       {
	 	
	 	var row = $('#dg').datagrid('getSelected');
  	 	var id=row.id;
    
     
      
    	$.messager.confirm('My Title', 'Are you sure you want to delete this user?', function(r){
        if (r){
            	  
         			 window.location.href="deletecounter.html?id="+id;

            }
          });
      
       
}
 
</script>

<script>

$('#dg').datagrid('reload'); 

</script>

<script>
        function doSearch(value){
        	
            //alert('Your input: ' + value);
         
           $('#dg').datagrid({
        	   url:"counter_searchstationcode.html?stationdata="+value
           });
        }
        </script> 
        
 
        <script>
      	function refreshPage()
      	{
      		$('#dg').datagrid({url:'CounterDisplayGrid.html'});
    	}
	</script>
<body onload="gridRefresh()">
<security:authorize ifAnyGranted="ROLE_Admin">
<br>
<center>		
<h1 align="center">Counters Page</h1>
 
    
     <div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="width:100%;max-width:220px;padding:0px 0px;">
        <input class="easyui-searchbox" data-options="prompt:'Enter Station Name/Station Code',searcher:doSearch" style="width:100%">
    </div>
     <br>
     
     <input type="button" value="Refresh" onclick="refreshPage();" />

<br>
     <br>



<div id="toolbar">
    
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">Add New</a>&nbsp;&nbsp;&nbsp;
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">Update</a> &nbsp;&nbsp;&nbsp;
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">Delete</a>
       </div>
 <table id="dg" class="easyui-datagrid" title="Counter Details" style="width:780px;height:250px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:true,toolbar:'#toolbar',url:'CounterDisplayGrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'id',width:100"> Id</th>
                <th align="center" data-options="field:'username',width:120">User Name</th>
                 
                <!-- <th align="center" data-options="field:'password',width:120">Password</th>
                 <th align="center" data-options="field:'conformpassword',width:120">Confirm Password</th> -->
                 <th align="center" data-options="field:'stationname',width:200">Station Name</th>
                 <th align="center" data-options="field:'stationcode',width:100">Station Code</th>
                
                <th align="center" data-options="field:'city',width:100">City</th>
                 <th align="center" data-options="field:'pincode',width:120">Pin Code</th>
                 
                
       </tr>    </thead> 
    </table>	
</center>

</security:authorize>
</body>
</html>