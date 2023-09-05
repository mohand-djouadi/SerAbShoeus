<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/styles/styleSign.css" rel="stylesheet">
<title>Sign in</title>
</head>
<body>
	<a href="#">Home</a>
	<h2>sign In</h2>
	<form method="POST" action="">
		<label id="fname">First name</label>
		<input type="text" for="fname" name="firstname">
		
		<label id="lanem">Last name</label>
		<input type="text" for="lname" name="lastname">
		
		<label id="email">Email</label>
		<input type="text" for="email" name="email">
		
		<label id="usrname">Username</label>
		<input type="text" for="usrname" name="username">
		
		<label id=passw"">Password</label>
		<input type="password" for="passw" name="password">
		
		<label id="confirm">Confirmation</label>
		<input type="password" for="confirm" name="confirmation">
		
		<input type="submit" value="Sign In">
		<p>you have account <a href="#">log in</a></p>
	</form>
</body>
</html>