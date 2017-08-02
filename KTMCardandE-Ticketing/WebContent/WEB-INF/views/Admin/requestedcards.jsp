<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
      <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Users</title>
  <meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
    
    
    <!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script> -->
    <style>
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
     <script type="text/javascript">
     function cellStyler(value,row,index){
    			if (row.status=='Pending'){
    				return 'color:blue;font-weight:bold';
    				
    			}
    			else if(row.status=='Rejected'){
    				
    				return 'color:red;font-weight:bold';
    			}
else if(row.status=='Approved'){
    				
    				return 'color:green;font-weight:bold';
    			}
    		}
  
    	
    	
 
    
    </script>
    
    <script>
    function checkbox(){
    	
    	//alert("haiii");
    	
    	
    }
    
    
    
    </script>
  
    <script>
function adding()
{
 /* window.location.href="addcard999.html"; */
 window.open("addcard999.html","AddCard","height=900,width=750,left=300,right=200"); 
}  
</script> 

<script>
function approving(){
    
    var row = $('#dg').datagrid('getSelected');
    
    if(row.status=="Rejected")
	{
		alert("Sorry....!!!! access is denied");
	}
    else{
        if (row)
        {
        	
          window.location.href="approvecard999.html?id="+row.acid;
         
      
           }
                   else
                 {
                $.messager.alert('Warning','Please select atleast one row!');
                 }
     
               }
}
          
</script>


<script>
function rejecting(){
 
    var row = $('#dg').datagrid('getSelected');
   
    if(row.status=="Approved")
    	{
    		alert("Sorry....!!!! access is denied");
    	}
    else{
    	
   
        if (row)
        {
        	
          window.location.href="rejectcard999.html?id="+row.acid;
         
      
           }
                   else
                 {
                $.messager.alert('Warning','Please select atleast one row!');
                 }
     
               }
     }
</script>


<script>
function updating(){
    
    var row = $('#dg').datagrid('getSelected');
        if (row)
        {
        	
         /* window.location.href="editcamp999.html?id="+row.campid; */
         window.open("editcard999.html?id="+row.acid,"AddCard","height=900,width=750,left=300,right=200");
      
           }
                   else
                 {
                $.messager.alert('Warning','Please select atleast one row!');
                 }
     
               }
          
</script>
  <script>
    function deleting()
       {
	 
       var row = $('#dg').datagrid('getSelected');
         
       
       if(row)
       {
    	 
      	  $.messager.confirm('Warning', 'Are you sure you want to delete this user?', function(r){
              if (r){
            	  
        	  window.location.href="deletecard999.html?cid="+row.acid;
            	  
              }
          });
       }
       else
    	   {
           $.messager.alert('Warning','Please select atleast one row!');
    	   } 
}
      
       </script>
       
       
       
         <script>
         function doSearch(value)
         {
        
            
         	$('#dg').datagrid({url:"finding.html?value="+value
                
          
             });
         	
         	
         }
    </script> 
    <script>

    function searchdate()
    {
    	alert("hai....");
    	
    	var dt1=$('#from').datebox('getValue');
    	alert(dt1);
    	var dt2=$('#to').datebox('getValue');
    	alert(dt2);
    	
    	
    	window.location.href="betweendates.html?from="+dt1+"&to="+dt2;
    	
    	
    }
    
    </script>
    
    <script>
    function refresh(){
		
    
		$('#dg').datagrid({url:"adrequsedcards.html"}); 
	}
    
    </script>
    
       
</head>



<body>
<security:authorize ifAnyGranted="ROLE_Admin">

<br><br>
<center>
<h2>Requested Cards</h2>
<br>
<br>

   <div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="width:100%;max-width:220px;padding:0px 0px;">
    
        <input class="easyui-searchbox" data-options="prompt:'Enter Status',searcher:doSearch" style="width:150px"> <input type="button" value="Refresh" onclick="refresh()">
       

        
    </div>
    
     <table align="center" id="dg" title="List Of RequestedCards" class="easyui-datagrid" style="width:1020px;height:350px"

            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true"
            data-options="singleSelect:true,url:'adrequsedcards.html',onDblClickRow:function(index,row){update()},method:'get'">
           
        <thead>
            <tr>
               <!--  <th data-options="field:'chk' , checkbox:true"></th> -->
         	    <th data-options="field:'acid'">AcId</th>
                <th data-options="field:'status',styler:cellStyler">Status</th>
                 <th data-options="field:'type'">Type</th>
         	    <th data-options="field:'firstname'">FirstName</th>
                <th data-options="field:'middlename'">MiddleName</th>
                <th data-options="field:'lastname'">LastName</th>
                <th data-options="field:'username'">UserName</th>
                <th data-options="field:'dateofbirth'">DateOfBirth</th>
                
                <th data-options="field:'gender'">Gender</th>
                <th data-options="field:'email'">Email</th>
                <th data-options="field:'mobileno'">MobileNo</th>
                <th data-options="field:'address'">Address</th>
                <th data-options="field:'pincode'">Pincode</th>
                <th data-options="field:'country'">Country</th>
                <th data-options="field:'state'">State</th>
                <th data-options="field:'city'">City</th>
                <th data-options="field:'cardid'">CardId</th>
                <th data-options="field:'registerdate'">RegisterDate</th>
                
               

              
                
            </tr>
        </thead>
    </table>
  <div style="margin:20px 0;"  align="center"> 
       <input type="button" name="Approved" value="Approve" onclick="approving()" class="button">&nbsp;&nbsp;&nbsp; 
        <input type="button" name="Rejected" value="Reject" onclick="rejecting()" class="button">&nbsp;&nbsp;&nbsp;
      <!--   <input type="button" name="Add" value="Add" onclick="adding()" class="button">&nbsp;&nbsp;&nbsp; 
         <input type="button" name="Edit" value="Edit" onclick="updating()" class="button">&nbsp;&nbsp;&nbsp;  -->
        <input type="button" name="Delete" value="Delete" onclick="deleting()" class="button">&nbsp;&nbsp;&nbsp; 
         
       </div>
       </center>
       </security:authorize>
</body>
</html>