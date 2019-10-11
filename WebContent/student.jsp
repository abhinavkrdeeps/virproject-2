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
     EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();
     Enrollment enrollment = enrollmentDao.findByStudentId(student1.getStudentID());
     Batch batch = null;
     if(enrollment!=null){
     BatchDao batchdao = new BatchDAOImpl();
        batch = batchdao.findById(enrollment.getBatchID());
     }
 
 
 
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
 
 
 <% if(batch==null) {%>
    
      <span>currently not enrolled in any course</span>
      <form action="batch.jsp">
          <input type="submit" value="Check Out Courses">
      </form>
 
 <%} else{%>
    
<%
   CourseDAO courseDAO = new CourseDAOImpl();
   Course course = courseDAO.findById(batch.getCourseID());
%>
  <h3>Currently Enrolled Course</h3>
  
   <div class="conatiner">
   <form action="enrollment" method="delete">
      <label>Course: </label><p><%= course.getCourseName() %></p>
      <label>StartDate: </label><p><%= batch.getStartDate() %></p>
      <label>EndDate: </label><p><%= batch.getEndDate() %></p>
      
      <input type="submit" value="Cancel Enrollment">
      </form>
   
   </div>
    

 <%} %>
  
</body>
</html>