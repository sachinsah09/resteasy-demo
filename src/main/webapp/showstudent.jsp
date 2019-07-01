<%@page import="com.axelor.db.Student"%>
<%@page import="com.axelor.db.Marksheet"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%> 
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en" class="no-js">
	
	<head>
	
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Student Database</title>
		
		</div>
		
		<meta name="description" content="Sticky Table Headers Revisited: Creating functional and flexible sticky table headers" />
		<meta name="keywords" content="Sticky Table Headers Revisited" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
	</head>
	<body>
		<div class="container">
		<div class="component" >
		
		<div align="right" >
		<form class="example" method="POST" action="searchstudent">
 		<input type="text"   placeholder="Search..." name="sname">
  		<input type="submit"  value="Search"/>
		</form>		
  		</div>
  		
			<h1>Student Records</h1>
			
				<table border="3">
					<thead>					
 				<TR>
               <TH>STUDENTID</Th>
                <TH>STUDENT NAME</TH>
                <TH>STUDENT AGE</TH>
              <Th>GET ALL MARKSHEET</Th>  
               <Th>DELETE RECORD</Th>
               <th>UPDATE RECORD</th>
               </TR>             
					</thead>
					<tbody>
			</TR>                
   <%List<Student> studObj = (ArrayList<Student>)request.getAttribute("studentList"); 
        for(Student s: studObj){%> 
             <tr> 
                <td class="user-name"><%=s.getSid()%></td>
                <td class="user-email"><%=s.getSname()%></td>
                <td class="user-name"><%=s.getAge()%></td>
               <td class="user-name"><a href='<%="show?id="+s.getSid()%>'>Click here</a></td>
               <td class="user-name"><a href='<%="delete/"+s.getSid()%>'>Click here</a></td>
               <td class="user-name"><a href='<%="update.jsp?id="+s.getSid()+"&sname="+s.getSname()+"&age="+s.getAge()%>'>Click here</a></td>
            </tr> <%} 
         %> 			</tbody>
				</table>
		</div>
		</div>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
		<script src="js/jquery.stickyheader.js"></script>
	</body>
</html>