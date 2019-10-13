<%@page import="com.vir.dao.TrainerDAOImpl"%>
<%@page import="com.vir.dao.TrainerDao"%>
<%@page import="com.vir.dao.CourseDAOImpl"%>
<%@page import="com.vir.dao.BatchDAOImpl"%>
<%@page import="com.vir.model.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if((String)request.getAttribute("message")!=null){%>

<%= (String)request.getAttribute("message") %>

<%} %>
		<form action="batch" method="post">
		
		CourseName:	<select name="cid">
				
				<%
				   CourseDAOImpl cdao = new CourseDAOImpl();
				   List<Course> list = cdao.getAllCourses();
				   
				   for(Course course: list) { %>
				  
				        <option value = "<%= course.getCourseID()%>"><%= course.getCourseName() %></option>
						
				
				<% } %>
				
			</select>
			
		StartDate:	<input type="text" name="startdate">
		EndDate:	<input type="text" name="enddate">	
		Price:	<input type="text" name="price">
		
		Trainer Name:	<select name="tid">
				
				<%
				  TrainerDao tdao=new TrainerDAOImpl();
				  List<Trainer> al=tdao.getAllTrainer();
				   
				   for(Trainer t: al) { %>
				  
				        <option value = "<%= t.getTrainerID()%>"><%= t.getTrainerName() %></option>
						
				
				<% } %>
				
			</select>
	   <input type="submit" value="Add">
			
		</form>
</body>
</html>