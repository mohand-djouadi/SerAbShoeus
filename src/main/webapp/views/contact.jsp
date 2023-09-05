<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/styles/styleCont.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/d477c35a70.js" crossorigin="anonymous"></script>
<title>Contact</title>
</head>
<body>
	<%@ include file="../views/includes/header.jsp" %>
	<main>
	<div class="contacts-box">
		<div class="contacts">
			<ul>
				<li>e-mail : serabshoeus@gmail.com</li>
				<li>fix number : 021345467</li>
			</ul>
		</div>
		<div class="socials-links">
			<ul>
				<li><a href="#"><i class="fa-brands fa-facebook" style="color: #7B1FA2"></i></a></li>
				<li><a href="#"><i class="fa-brands fa-instagram" style="color: #7B1FA2"></i></a></li>
				<li><a href="#"><i class="fa-brands fa-twitter" style="color: #7B1FA2"></i></a></li>
				<li><a href="#"><i class="fa-brands fa-linkedin" style="color: #7B1FA2"></i></a></li>
			</ul>
		</div>
	</div>
	<div class="contact-form">
		<form method="POST" action="">
			<input type="text" name="objectif" placeholder="objectif">
			<textarea rows="9" cols="40" name="message" placeholder="message"></textarea>
			<input type="submit" value="send">
		</form>
	</div>
	</main>
</body>
</html>