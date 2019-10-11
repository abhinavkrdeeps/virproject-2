<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.vir.dao.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="com.vir.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%

		 BatchDao batchdao = new BatchDAOImpl();
		  CourseDAO courseDao = new CourseDAOImpl();
		 List<Batch> batchList = batchdao.getAllBatch();
		 
		 for(Batch batch:batchList){%>
		   <form action="batchaction" method="post">
		    
		     course : <%
		          Course course = courseDao.findById(batch.getCourseID());%>
		          <span><%= course.getCourseName() %></span>
		     startDate: <span><%= batch.getStartDate() %></span>
		     EndDate: <span><%= batch.getEndDate() %></span>
		     Price: <span><%= batch.getPrice() %></span>
		     <% session.setAttribute("batch", batch); %>
		     <select name="action">
		     	<option value="remove">Remove</option>
		     	<option value="update">Update</option>
		     </select>
		      <input type="submit" value="Submit">
		      
		    
		    </form>
		 <%} %>
</body>
</html>