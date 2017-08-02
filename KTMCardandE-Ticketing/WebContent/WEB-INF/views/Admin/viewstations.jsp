<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stations are</title>
<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
    
    <script>
function add()
{
window.open('addstation.html', 'AddStation','height=500,width=550,left=200,top=100,overflow: scroll');
}  
</script> 
<script>
function update(){
   
    var row = $('#dg').datagrid('getSelected');
   
    if (row){
        	
         //window.location.href="editstation.html?id="+row.stationid;

        window.open('editstation.html?id='+row.stationid,'Update Stations','height=500,width=550,left=200,top=100,overflow: scroll');                              
                   }
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
        	
         window.location.href="deletestation.html?id="+row.stationid;

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
        	   url:"station_searchcode.html?searchdata="+value
           });
        }
        </script> 
        <script>
      	function refreshPage()
      	{
      		$('#dg').datagrid({url:'stationsgrid.html'});
    	}
	</script>
</head>
<body>
<security:authorize ifAnyGranted="ROLE_Admin">
<br>
<center>			

<div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="width:100%;max-width:220px;padding:0px 0px;">
        <input class="easyui-searchbox" data-options="prompt:'Search Station Name/Station Code',searcher:doSearch" style="width:100%">
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
 <table id="dg" class="easyui-datagrid" title="All Stations are" style="width:500px;height:300px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:true,toolbar:'#toolbar',url:'stationsgrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'stationid',width:100">Station Id</th>
                <th align="center" data-options="field:'stationname',width:180">Station Name</th>
                 
                <th align="center" data-options="field:'stationcode',width:180">Station Code</th>
                 
                
                 
                
       </tr>    </thead> 
    </table>	
    </center>
    </security:authorize>
</body>
</html>