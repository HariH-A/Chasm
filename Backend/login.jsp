<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action = "./login" method = "post" id = "login">
<table border = "1" align ="center">
<tr>
<td bordercolor = "teal" bgcolor="honeydew">User ID</td>
<td>
<input type="text" id = "id" name = "id" pattern="[0-9]{1,10}" placeholder = "Registration number" required/>
</td>
</tr>
<tr>
<td bgcolor="honeydew">password</td>
<td>
<input type="password" id = "pass" name = "pass" maxlength="12" placeholder = "Maximum 12 characters" required/>
</td>
</tr>
<td colspan = "2" align = "center" bgcolor="honeydew">
<input type ="submit" id = "sub" name = "sub" value = "submit" >
</td>
</table>
</form>
</body>
</html>