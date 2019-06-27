<%@page import="com.axelor.db.Student"%>
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
<h1>!  MarksSheet Table  !</h1>
	<TABLE BORDER="5">
                <TR>
               <TH>STUDENTID</Th>
                <TH>STUDENT NAME</TH>
                <TH>STUDENT AGE</TH>
                <th>STANDARD</th>
               <TH>MARKSOBTAIN</Th>
               <TH>MARKSTOTAL</Th>
               <TH>PERCENTAGE</Th>
               
                </TR>                
   <%ArrayList<Marksheet> mrks = (ArrayList<Marksheet>)request.getAttribute("marksheet"); 
        for(Marksheet mr: mrks){%> 
             <tr> 
                <td><%=mr.getStudent().getSid()%></td>
                <td><%=mr.getStudent().getSname()%></td>
                <td><%=mr.getStudent().getAge()%></td>
                <td><%=mr.getStd()%></td> 
                <td><%=mr.getMarksObtain()%></td> 
                <td><%=mr.getMarksOutOf()%></td>
                <td><%=mr.getPercentage()%></td>
               <td><a href='<%="delete/"+mr.getStudent().getSid()%>'>Delete</a></td>
               <td><a href="update.jsp"  <%  session.setAttribute("id", mr.getStudent().getSid());
               session.setAttribute("sname", mr.getStudent().getSname());
               session.setAttribute("age", mr.getStudent().getAge());
               
               %> >Update</a>
            </tr> <%} 
         %> 
          </TABLE>
    </Div>   
</body>
</html>