<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<HTML>
<HEAD>
<STYLE>
body
{
 border-radius: 20px;
 border-style: double;
 border-color: blue;
 position: absolute;
 width: 850px;
 height: 705px;
 top: 15px;
 left: 45px;
 padding: 30px 30px 50px 30px;
 background-color: #20B2AA;
}
#tbl,#tbl2
{
border-collapse:collapse;
font-size:18;
font-family:Century Gothic;
}
.demo
{
position:absolute;
left:35px;
top:380px;
font-size:17;
font-family:Arial;
font-weight:bold;
margin-top:35px;
border-collapse:collapse;
}
#demoname
{
font-size:15px
}
.btn
{
position:absolute;
top:355px;
left:620px;
}

.class
{
color: 
}
</STYLE>

<SCRIPT>
function myFun()
{
var a=document.form1.txtname.value;
document.getElementById("demoname").innerHTML=a;
var b=document.form1.txtfname.value;
document.getElementById("demofname").innerHTML=b;
var c=document.form1.txtins.value;
document.getElementById("demoins").innerHTML=c;
var d=document.form1.txtbatch.value;
document.getElementById("demobatch").innerHTML=d;
var e=document.form1.txtoffice.value;
document.getElementById("demooffice").innerHTML=e;
var f=document.form1.txtweb.value;
document.getElementById("demoweb").innerHTML=f;
var g=document.form1.txtit.value;
document.getElementById("demoit").innerHTML=g;
var h=document.form1.txtc.value;
document.getElementById("democ").innerHTML=h;
var txt1=eval(parseFloat(document.form1.txtoffice.value)+parseFloat(document.form1.txtweb.value)
+parseFloat(document.form1.txtit.value)+parseFloat(document.form1.txtc.value));
document.getElementById("demototal").innerHTML=txt1;
var txt2=eval(parseFloat(txt1*100)/400);
document.getElementById("demoper").innerHTML=txt2.toFixed(2)+"%";

switch(true)
{
case(txt2>=80):
document.getElementById("demograde").innerHTML="A1";
break;
case(txt2>=70):
document.getElementById("demograde").innerHTML="A";
break;
case(txt2>=60):
document.getElementById("demograde").innerHTML="B";
break;
case(txt2>=50):
document.getElementById("demograde").innerHTML="C";
break;
case(txt2>=40):
document.getElementById("demograde").innerHTML="D";
break;
case(txt2<40):
document.getElementById("demograde").innerHTML="Fail";
break;
}

}
</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</HEAD>

<BODY >

<form align="center" name="Form" method="post" action="insert" >
<DIV class="color">
<H1 align="center"style="font-family:cambria;font-size:40";><U>STUDENT MARKSHEET DATABASE</H1>
<FIELDSET>
<LEGEND> STUDENT INFORMATION </LEGEND>
<TABLE align="center" id="tbl">
<FORM name="form1">
</TR>
<TD width="140">Student Name:</TD> <TD><INPUT type="text" name="sname"/></TD ></br>
<TD > Student Age:</TD><TD> <INPUT type="text" name="age"/></TD>
</TR></br></TABLE>
	</FIELDSET></BR>
	<FIELDSET></BR>
	<LEGEND> MARKS INFORMATION </LEGEND>

</br>
<TABLE id="tbl2">
	<TR>
	<TD> STANDARD :</TD><TD> <INPUT type="text" name="std"  size="10"/> </TD>
	</TR>
	<TR>
	<TD> MARKS OBTAINED:</TD><TD>  <INPUT type="text" name="marksObtain" size="10"/></TD>
	</TR>
	<TR>
	<TD> TOTAL MARKS:</TD><TD> <INPUT type="text" name="marksOutOf"  size="10"/> </TD>
	</TR>
	<TR>
	<TD></TD>
	</TR>
</TABLE>

</FIELDSET>
<DIV class="btn">
	</br></br></br></br>
	<button style="font-size:17" type="submit" formaction="insert">Submit</button>
	<button style="font-size:17" type="Reset">Reset</button>
</DIV>
</form>

</body>
</html>
