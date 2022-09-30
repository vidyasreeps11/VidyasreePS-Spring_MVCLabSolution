<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Debate Registration</title>
<style>
h2{text-align: center;
	font-style: italic;
	font-size:xx-large;}
h3{text-align: center;}

</style>
</head>
<body>
<div style="background-color: olive;">
<h2>Student Debate Registration Portal</h2>
</div>
<br>
<div>
<form action="StudentDebateRegistration/student/save" method="post">
<table border="3" style="border-style: double;" cellspacing="3">
<caption><b>Register New Student</b></caption>
<input type="hidden" name="reg_id" value="${student.reg_id}"/>
<tr><td>First Name</td><td><input type="text" name="firstname" value="${student.firstname}"></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lastname" value="${student.lastname}"></td></tr>
<tr><td>Department</td><td><input type="text" name="department" value="${student.department}"></td></tr>
<tr><td>Email Address</td><td><input type="text" name="emailaddress" value="${student.emailaddress}"></td></tr>
<tr><td>Phone Number</td><td><input type="text" name="phoneno" value="${student.phoneno}"></td></tr>
</table><br>
<input type="submit" value="submit">
</form>
</div>
<br>
<a href="/StudentDebateRegistration/student/list">View Registered Student List</a></h3>
</body>
</html>