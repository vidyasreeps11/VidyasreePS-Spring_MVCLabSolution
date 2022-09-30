<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Registered Student List</title>
</head>
<body>
 
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students Registered for Debate</h2></caption>
            <tr>
                <th>ID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Department</th>
                <th>Email Address</th>
                <th>Phone No</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="studentModel" items="${Students}">
                <tr>
                    <td><c:out value="${Students.reg_id}" /></td>
                    <td><c:out value="${Students.firstname}" /></td>
                    <td><c:out value="${Students.lastname}" /></td>
                    <td><c:out value="${Students.department}" /></td>
                    <td><c:out value="${Students.emailaddress}" /></td>
                    <td><c:out value="${Students.phoneno}" /></td>
                    <td>
                     <a href="edit?reg_id=<c:out value='${Students.reg_id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?reg_id=<c:out value='${Students.reg_id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    <div><br><a href="/StudentDebateRegistration/student/">Back to Home Page</a></div>
</body>
</html>