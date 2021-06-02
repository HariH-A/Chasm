<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter</title>
</head>
<body>
<form action="./filter" method="post">
<table border = "1" align ="center">
<tr>
<td bordercolor = "teal" bgcolor="honeydew">Genre</td>
<td><input type="text" id = "genre" name = "genre" /></td>
</tr>
<tr>
<td bordercolor = "teal" bgcolor="honeydew">Director</td>
<td><input type="text" id = "dir" name = "dir" /></td>
</tr>
<tr>
<td bordercolor = "teal" bgcolor="honeydew">year </td>
<td><input type="text" id = "year" name = "year" /></td>
</tr>
<tr>
<td bordercolor = "teal" bgcolor="honeydew">Year After</td>
<td><input type="text" id = "yraf" name = "yraf" /></td>
</tr>
<td colspan = "2" align = "center" bgcolor="honeydew">
<input type ="submit" id = "sub" name = "sub" value = "submit" >
</td>
</table>
</form>
</body>
</html>