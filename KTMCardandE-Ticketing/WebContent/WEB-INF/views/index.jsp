<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>  
    </head>
    <body background="images/cp.png">
        <table border="0" cellpadding="1" cellspacing="1" align="center" height="646" width="100%">
            <tr>
                <td height="100" colspan="2">
                    <tiles:insertAttribute name="header" ignore="true" />
                </td>
            </tr>
            <tr>
                <td height="40">
                    <tiles:insertAttribute name="menu" />
                </td></tr>
                <tr><td height="540">
                    <tiles:insertAttribute name="body" />
                </td>
            </tr>
            <tr>
                <td height="10" colspan="2">
                    <tiles:insertAttribute name="footer" />
                </td>
            </tr>
        </table>
    </body>
</html>
