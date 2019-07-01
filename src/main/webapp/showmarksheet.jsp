<%@page import="com.axelor.db.Student"%>
<%@page import="com.axelor.db.Marksheet"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%> 
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
	
	
	<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color:	#bdfee6;
  color: blue;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 900px;
  right: 60px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>
	
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Marksheet Database</title>
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
			<div class="component">
			
		<div align="right" >

<button class="open-button" onclick="openForm()">--> Add New Marksheet <--</button>
<div class="form-popup" id="myForm">
  <form action="addmarksheet" method="post" class="form-container">
    <h1>Marksheet Details</h1>

    <label for="email"><b>ID</b></label>
    <input type="text" placeholder="Enter standard" name=id value="<%=request.getAttribute("id")%>" required>
    
    <label for="email"><b>Standard</b></label>
    <input type="text" placeholder="Enter standard" name="std" required>

    <label for="psw"><b>Marks Obtained</b></label>
    <input type="text" placeholder="Enter obtained marks" name="mrkobt" required>

    <label for="psw"><b>Total Marks</b></label>
    <input type="text" placeholder="Enter total marks" name="totalmrk" required>
   
    <button type="submit" class="btn">SAVE</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Cancel</button>
  </form>
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
	

		<form class="example" method="POST" action="searchmarksheet" >
  	
		</form>		
  		</div>
	
			
			<h1>Marksheet Records</h1>
		
				<table border="3">
					<thead>					
 				<TR>
               <TH>STANDARD</TH>
               <TH>MARKS OBTAINED</TH>
               <TH>TOTAL MARKS</TH>
               <TH>PERCENTAGE</TH>      
               <Th>DELETE RECORD</Th>
               <th>UPDATE RECORD</th>
               </TR>             
					</thead>
					<tbody>
			</TR>                
   <% List<Marksheet> mrks1 = (List<Marksheet>)request.getAttribute("marksheetList"); 
        for(Marksheet mr: mrks1){%> 
             <tr> 
               <td class="user-name"><%=mr.getStd()%></td>
               <td class="user-email"><%=mr.getMarksObtain()%></td>
       		   <td class="user-email"><%=mr.getMarksOutOf()%></td>
       		   <td class="user-email"><%=mr.getPercentage()%></td>
       		   <td class="user-name"><a href='<%="deletemrk/"+mr.getMid()%>'>Click here</a></td>
               <td class="user-name"><a href='<%="updatemarksheet.jsp?id="+mr.getMid()+"&std="+mr.getStd()+"&marksobtain="+mr.getMarksObtain()+"&totalmarks="+mr.getMarksOutOf()%>' >Click here</a>
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