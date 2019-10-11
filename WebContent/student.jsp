<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.vir.model.*"%>
    <%@ page import="com.vir.dao.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
 
Student student = (Student)request.getAttribute("data");
 Student student1 = (Student)session.getAttribute("data");
System.out.println(student1+" in student.jsp");
 request.setAttribute("studentData",student); 
 session.setAttribute("studentData",student1); %>
 
 
 <%
     
 
 
 
 %>
 <form action="profile.jsp">

 
<input type="Submit" value="My Profile">
 
 </form>
 
 
 <form action="batch.jsp">

 
<input type="Submit" value="View All Batches">
 
 </form>
 
 <form action="course.jsp">

 
<input type="Submit" value="View All Courses">
 
 </form>

  <h3>Currently Enrolled Course</h3>
  




  
</body>
</html>