<%@page import="com.axelor.db.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  
	
	int id =(Integer)session.getAttribute("id"); 
	String sname=(String)session.getAttribute("sname");
	  int age =(Integer)session.getAttribute("age");
%>
<h1>Student Marksheet Entry</h1>
 <form align="center" name="Form" method="post" action="insert" >
 Student ID : <input type="text" name="id" value=<%=id %> />
 Student name :<input type="text" name="sname" value=<%=sname %>/>
 Student age :<input type="text" name="age" value=<%=age %> /></br></br>
  <input type="submit" value="update" formaction="update"/>
</form> 
</body>
</html>