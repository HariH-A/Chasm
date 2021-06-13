<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList, backend.Movie" %>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="Default.css">
    <link rel="stylesheet" href="search.css">
    <script src="Default.js"></script>
<title></title>
    </head>
    <body>
  		<div class="barcontain">
		        <div class="search-container">
	    			<form action="./search" method="post">
	      			<input  type="text" placeholder="Search Movies or Directors" id="search" name="search">
	      			<button type="submit"><i class="fa fa-search"></i></button>
	    			</form>
 			</div>	
			<div class="navibar" id="nb">
				  <a href="javascript:void(0);" class="menuicon navicons" onclick="responsiveNaviBar()">
					 <div class="menuContainer" onclick="menuBar(this)">
					  <div class="bar1"></div>
					  <div class="bar2"></div>
					  <div class="bar3"></div>
					 </div>
				  </a>
				  <a href="./HomePage.jsp" class="navicons"><i class="fa fa-home"></i></a> 
				  <div class="dropdown navicons">
				  	<a href="#"><i class="fa fa-film"></i></a> 
				    <div class="dropdown-content">
					<form method="post" action="./search">
					<input type="hidden" name="search" value="action">
					<i onclick="submitMyForm(1)">Action</i>
					</form>
					
					<form method="post" action="./search">
					<input type="hidden" name="search" value="comedy">
					<i onclick="submitMyForm(2)">Comedy</i>
					</form>
									
					<form method="post" action="./search">
					<input type="hidden" name="search" value="old">
					<i onclick="submitMyForm(3)">Retro</i>
					</form>
									
					<form method="post" action="./search">
					<input type="hidden" name="search" value="scifi">
					<i onclick="submitMyForm(4)">Sci-Fi</i>
					</form>
					
					<form method="post" action="./search">
					<input type="hidden" name="search" value="thriller">
					<i onclick="submitMyForm(5)">Thriller</i>
					</form>
				    </div>
				  </div> 
				   <div class="dropdown navicons">
				  	<a><i class="fa fa-user"></i></a> 
				    <div class="dropdown-content">
				    <%if(request.getAttribute("user_id")!=null){%>
					<i><%= request.getAttribute("user_id")%></i>
					<%}else{%><i>You are not logged in</i><%}%>
					<a href="./rating.jsp"><i>Rate Movies</i></a>
				      </div>
				  </div> 
				  <form class="navicons" method="post" action="./logout">
					<i onclick="submitMyForm(6)" class="fa fa-eject"></i>
			    	  <form>
			</div>
		</div>
			<%
			if(request.getAttribute("DATA") != null)
			{
				ArrayList<Movie> obj= (ArrayList<Movie>)request.getAttribute("DATA");
				int i = 0;
			%>
				<div class="movieContainer">
			<%
				while(i!=obj.size()){ %>
					<img src="<%= obj.get(i).getPoster() %>" width=100px height=100px>
					<table>
						  <tr>
						  	<td colspan="2" style="text-align:center;font-size:xx-large;"><%= obj.get(i).getTitle() %></td>
						  </tr>
						  <tr>
						  	<th>Genre:</th>
						  	<td><%= obj.get(i).getGenres() %></td>
						  </tr>
						  <tr>
						  	<th>Director(s):</th>
						  	<td><%= obj.get(i).getDirector() %></td>
						  </tr>
						  <tr>
						  	<th>Year:</th>
						  	<td><%= obj.get(i).getYear() %></td>
						  </tr>
						  <tr>
						  	<th>Runtime(In Minutes):</th>
						  	<td><%= obj.get(i).getMinutes() %></td>
						  <tr>
						  	<th>Average Rating:</th>
						  	<td><%= obj.get(i).getRating() %></td>
						  </tr>
					 </table>
					<%i++;
				}
			}
			%>
			
		</div>
		<%
			if(request.getAttribute("GENRE") != null)
			{
				ArrayList<Movie> obj= (ArrayList<Movie>)request.getAttribute("GENRE");
				int i = 0;
			%>
		<div class="movieContainer">
			<%
				while(i!=obj.size()){ %>
					<p><%= obj.get(i).getTitle() %></p>
					<%i++;
				}
			}
			%>
		</div>
		    <script src="Default.js"></script>
    </body>
</html>
