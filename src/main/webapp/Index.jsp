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

<h1>Student Marksheet Entry</h1>
 
 Student name :<input type="text" name="sname" />
 Student age :<input type="text" name="age" /></br></br> 
 
 Standard : <input type="text" name="std"> 
 Marks Obtained :<input type="text" name="marksObtain" />
 Marks Total :<input type="text" name="marksOutOf" /></br></br>
 <input type="submit"  value="insert"/></br></br>
 <input type="submit" value="retrieve" formaction="retrieve"/>
</form>
</body>
</html>