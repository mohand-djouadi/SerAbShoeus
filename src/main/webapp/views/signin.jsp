<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>
	<h2>sign In</h2>
	<form method="POST" action="">
		<label id="fname">First name</label>
		<input type="text" for="fname" name="firstname">
		
		<label id="lanem"></label>
		<input type="text" for="lname" name="lastname">
		
		<label id="email"></label>
		<input type="text" for="email" name="email">
		
		<label id="usrname"></label>
		<input type="text" for="usrname" name="username">
		
		<label id=passw""></label>
		<input type="password" for="passw" name="password">
		
		<label id="confirm"></label>
		<input type="password" for="confirm" name="confirmation">
		
		<input type="submit" value="Sign In">
	</form>
</body>
</html>