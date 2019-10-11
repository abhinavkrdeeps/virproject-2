<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<h1>Student Registration Form</h1>
	
	<%
	   String message = (String)request.getAttribute("message");
	   if(message!=null)
	   {%>
		   
		   <p><%= message %></p>
	   <%} %>
	

	<form action="studentServlet" method="post">
		<table style="with: 50%">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td></tr>
				<tr>
				<td> Father's Name:</td>
				<td><input type="text" name="fname"></td></tr>
				<tr>
				<td> UID:</td>
				<td><input type="text" name="uid"></td></tr>
				<tr>
				<td> Age:</td>
				<td><input type="text" name="age"></td></tr>
				<tr>
				<td>User Name:</td>
				<td><input type="text" name="username"></td></tr>
				<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td></tr>
				<tr>
				
				
				
		</table>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>