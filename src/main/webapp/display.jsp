<%@page import="com.axelor.db.Marksheet"%> 
<%@page import="java.util.ArrayList"%> 
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guice-JPA-Servlet</title>
</head>
<body>

  <Div align="center">
<h1>!  Select Operation on Customer Table  !</h1>

   <TABLE BORDER="5">
          
            <TR>
                <TH>ID</TH>
                <TH>Name</TH>
               <TH>Age<Th>
                </TR>
                
   <%ArrayList<Marksheet> std =  
            (ArrayList<Marksheet>)request.getAttribute("customer"); 
        for(Marksheet mr: std){%> 
             <tr> 
                <td><%=mr.getSid()%></td> 
                <td><%=mr.getSname()%></td> 
                <td><%=mr.getPercentage()%></td> 
                <td><a href='<%="student?id="+mr.getSid()%>'>Delete</a></td>
            </tr> <%} 
         %> 
 
          </TABLE>
    </Div>
</body>
</html>