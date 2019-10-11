<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   if(request.getAttribute("data")!=null){
	   String msg = (String)request.getAttribute("data");  
	  %>
   
   <%= msg %>

<%}%>

<form action="admin" method="post">

 username: <input type="text" name="uname">
 password: <input type="password" name="password">
 <select name="type">
 <option value="admin">As Admin</option>
 <option value="student">As Student</option>
 <option value="trainer">As Trainer</option>
 </select>
 <input type="submit" value="submit">
 
 <a href="Studentregistration.jsp">Not A user yet? Register Here</a>

</form>
</body>
</html>