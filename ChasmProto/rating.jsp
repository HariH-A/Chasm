<%@ page import ="java.util.ArrayList, backend.Movie" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link href="./sign.css" rel="stylesheet">
<body>
<div class="container" style="background-color:black;" class="signin">
<div class="center" style="overflow-y:scroll;padding-top:0%;height:100%;">
<form action="./rating" method="post">
	<input style="width:50px;" type="text" name="id" value="<%= request.getAttribute("rater_id")%>">
 	<jsp:useBean id="def" class="backend.Recommender"> 
	 </jsp:useBean>
			<% for(int i=0;i<6;i++){
				Movie x= def.getIndexDefault();%>
		  	    <div><p style="color: white; display:inline-block;float:right;width:45%;"><%= x.getTitle()%>
		       	    <br>Year:<%= x.getYear()%>		 	    
		       	    <br>Genres:<%= x.getGenres()%>	    
		 	    <br>Director(s):<%= x.getDirector()%>	    
		 	    <br>Runtime:<%= x.getMinutes()%></p>
  		          </div><br><img src="<%= x.getPoster()%>" style="float:left; width:50%;height:auto;">
<input style="left:20em;width:51%" type="text" name="<%= x.getTitle()%>" pattern="[0-9]" placeholder = "Rate" required/>

  		         <%}%>
<input type="submit" style="margin-top:20px;" class="signin" name="submit" id="submit"/>
</div>
</div>
</form>
</div>
</body>
</html>

