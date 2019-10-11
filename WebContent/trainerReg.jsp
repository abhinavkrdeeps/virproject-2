<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title> Trainer Registration Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="trainerReg.css">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/trainerReg.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- //web font -->
</head>
<body>
	<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>Trainer Registration Form</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form action="TrainerServlet" method="post">
				    <input class="text" type="text" name="name" placeholder="Enter Name" required=""><br>
				    <input class="text" type="text" name="uid" placeholder="Enter Unique Id" required=""><br>
				    <input class="text" type="text" name="age" placeholder="Enter Age" required=""><br>
				<select  id="myList" name="specialization">
						<option value="" disabled selected>Enter Specialization</option>
						<option value="1">Business Intelligence</option>
						<option value="2">Design</option>
						<option value="3">Artificial Intelligence</option>
						<option value="4">Development</option>
						<option value="5">Marketing</option>

				</select>
				
				<input class="text" type="text" name="username" placeholder="Username" required=""><br>
					<input class="text" type="password" name="password" placeholder="Password" required="">
					
					
					<input type="submit" value="SIGNUP">
				</form>
				<p>Already have an Account? <a href="#"> Login Now!</a></p>
			</div>
		</div>
		
		<ul class="colorlib-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<!-- //main -->
</body>
</html>