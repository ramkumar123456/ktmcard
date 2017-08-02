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
    $(function() {
    	$('#dg').datagrid({
    		rowStyler: function(index,row){
    			if (row.status=='pending'){
    				//return 'background-color:#6293BB;color:#fff;';
    				
    			}
    			else {
    				
    			//	return 'background-color:#ffee00;color:red;';
    			}
    		}
    	}); 
    	
    	
    });
    
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
        if (row)
        {
        	
          window.location.href="approvecard999.html?id="+row.acid;
         
      
           }
                   else
                 {
                $.messager.alert('Warning','Please select atleast one row!');
                 }
     
               }
          
</script>


<script>
function rejecting(){
    
    var row = $('#dg').datagrid('getSelected');
        if (row)
        {
        	
          window.location.href="rejectcard999.html?id="+row.acid;
         
      
           }
                   else
                 {
                $.messager.alert('Warning','Please select atleast one row!');
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
    	//alert("hai....");
    	
    	var dt1=$('#from').datebox('getValue');
    	//alert(dt1);
    	var dt2=$('#to').datebox('getValue');
    	//alert(dt2);
    	
    	
    	window.location.href="betweendates.html?from="+dt1+"&to="+dt2;
    	
    	
    }
    
    </script>
    
    <script>
    function refresh(){
		
    	//alert("enter into refresh function")
		$('#dg').datagrid({url:"gridview.html"}); 
	}
    
    </script>
    
       
</head>



<body>
<security:authorize ifAnyGranted="ROLE_User">
<center>
<h2>TopUp Transactions</h2>

    <div style="margin:20px 0;"></div>
    
     <table align="center" id="dg" title="TopUp Transactions" class="easyui-datagrid" style="width:900px;height:250px"

            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true"
            data-options="singleSelect:true,url:'topuptxs.html',onDblClickRow:function(index,row){update()},method:'get'">
           
        <thead>
            <tr>
                
         	    <th data-options="field:'cardid',width:100">CARDID</th>
         	    <th data-options="field:'topup',width:100">TOPUP</th>
                <th data-options="field:'datetime',width:100">DATE</th>
                <th data-options="field:'txid',width:100">TXID</th>
               <!--  <th data-options="field:'username',width:100">UserName</th>
                <th data-options="field:'password',width:100">PassWord</th> -->
                <th data-options="field:'topupid',width:100">TOPUPID</th>
                
               
            </tr>
        </thead>
    </table>
    </center>
  </security:authorize>
</body>
</html>