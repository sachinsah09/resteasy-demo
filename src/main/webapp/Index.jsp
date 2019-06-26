<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RestEasy Project</title>
</head>
<body>
<form align="center" name="Form" method="post" action="insert" >
<h1>Student Marksheet</h1>
 Student Name :<input type="text" name="sname" />
 Student Percentage :	<input type="text" name="percentage" />
 </br></br>   <input type="submit"  value="Insert"/>
    <input type="submit"  value="Delete" formaction="retrieve"/>
</form>
</body>
</html>