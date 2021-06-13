<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Encode Sans Condensed' rel='stylesheet'>
<link href="./sign.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>


<div class="container">
<div class="center">
	<strong>Login</strong>
	<form action = "./login" method = "post" id = "login">  
    <label for="id"><b>User ID  :</b></label>
    <input type="text" id="id" name="id" pattern="[0-9]{1,10}" placeholder = "Registration number" required /><br>
    <label for="pass"><b>Password :</b></label>
    <input type="password" id = "pass" name = "pass" maxlength="12" placeholder="Maximum 12 characters" required/><br>
	<input type ="submit" class="signin" value="Sign In" ><br>
	<a class="signin link" href="./registration.jsp">Register</a>
	</form>
		<%
			if(request.getAttribute("check")!=null)
			{
					if(!(Boolean)(request.getAttribute("check"))){
		%> <p>Incorrect Password</p>
		<%}else{%>
		<p>Invalid Username.</p>
		<%}}%>
</div>
</div>

</body>
</html>
