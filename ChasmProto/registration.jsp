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
  	<strong><br>Register</strong>
  <form action = "./registration" method = "post" id = "login">
    <label for="id"><b>User ID  :</b></label>
    <input type="text" id = "id" name = "id" pattern="[0-9]{1,10}" placeholder="Registration number" required /><br>
    <label for="pass"><b>Password :</b></label>
    <input type="password" id = "pass" name = "pass" maxlength="12" placeholder="Maximum 12 characters" required/><br>
    <label for="rpass"><b>Retype Password:</b></label>
    <input type="password" id="rpass" name = "rpass" placeholder="Retype Password" required/><br><br>
    		<input type ="submit" class="signin" value="Submit" ><br>
    		<a class="signin link" href="./login.jsp">Sign in</a>
    </form>
    		<%
			if(request.getAttribute("check")!=null)
			{
					if(!(Boolean)(request.getAttribute("check"))){
		%> <p>Password is either invalid or don't match</p>
		<%}
		else{
		%><p>Username already exists;</p>
		<%}}%>
  </div>
</div>

</body>
</html>
