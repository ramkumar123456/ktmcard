<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
 
   <%
   try{
     String s[]=null;
     System.out.println("coming to get brancges jspppppppppppppppppp");
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ktmtrain","ktmtrain");
     Statement st=con.createStatement();
     ResultSet rs = st.executeQuery("select * from KTM_STATION WHERE STATIONNAME IS NOT NULL");
    
       List li = new ArrayList();
       
       while(rs.next())
       {
    	  
           
           li.add(rs.getString(3));
           System.out.println("error..page.sttttttttringggg" +rs.getString(3));
           
           
       }
       List l= new ArrayList(new LinkedHashSet(li));
       String[] str = new String[l.size()];
       Iterator it = l.iterator();
 
       int i = 0;
       while(it.hasNext())
       {
           String p = (String)it.next();
           str[i] = p;
           i++;
       }
 
    //jQuery related start
       String query = (String)request.getParameter("q");
 
       int cnt=1;
       for(int j=0;j<str.length;j++)
       {
           if(str[j].toUpperCase().startsWith(query.toUpperCase()))
           {
              out.print(str[j]+"\n");
              if(cnt>=5)// 5=How many results have to show while we are typing(auto suggestions)
              break;
              cnt++;
            }
       }
    //jQuery related end
 
rs.close();
st.close();
con.close();
 
}
catch(Exception e){
e.printStackTrace();
}
 
//www.java4s.com
%>