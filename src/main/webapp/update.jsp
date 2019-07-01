<%@page import="com.axelor.db.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Update Student Record</title>
		<meta name="description" content="Sticky Table Headers Revisited: Creating functional and flexible sticky table headers" />
		<meta name="keywords" content="Sticky Table Headers Revisited" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
	</head>
<body>

<h1>Update Student Record</h1>
 <form align="center" name="Form" method="post" action="insert" >
 Student ID : <input type="text" name="id" value=<%= request.getParameter("id") %>  />
 Student name :<input type="text" name="sname" value=<%= request.getParameter("sname") %> />
 Student age :<input type="text" name="age" value=<%= request.getParameter("age") %>  /></br></br>
  <input type="submit" value="update" formaction="update"/>
</form> 
</body>
</html>