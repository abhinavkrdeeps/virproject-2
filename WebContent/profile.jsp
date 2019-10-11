<%@page import="com.vir.model.Enrollment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.vir.model.Student" %>
     <%@ page import="com.vir.model.Batch" %>
     <%@ page import="com.vir.model.Course" %>
    <%@ page import="com.vir.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Student student = (Student)session.getAttribute("studentData");
   System.out.println(student+" in profile.jsp");
%>

<h3>My Profile</h3>
<span>UserName: </span><p><%=student%></p> <br/>  

<p>Currently Enrolled Batch</p>

<% 
   EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();
   Enrollment enrollment = enrollmentDao.findByStudentId(student.getStudentID());
   Batch batch = new BatchDAOImpl().findById(enrollment.getBatchID());
   Course course = new CourseDAOImpl().findById(batch.getBatchID());
   
   %>
   
   <div>
      <p> <%= batch.getBatchID() %></p><br/>
      
      <p><%= course.getCourseName() %></p>
      
      <p><%= batch.getStartDate() %></p>
      
      <p><%= batch.getEndDate() %></p>
      
     
      
   
   </div>
</body>
</html>