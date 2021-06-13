<%@ page import ="java.util.ArrayList, backend.Movie" %>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="Default.css">
    <link rel="stylesheet" href="HomePage.css">
    <script src="Default.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
     <script src="HomePage.js"></script>
    </head>
    <body onload="showMovie(1)">
	<div class="PersonaMovies">
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
		<!-- Personalized Movies/Default Page-Do optimise using javabeans -->
 		  	<jsp:useBean id="def" class="backend.Recommender" scope="session"> 
     		 	<jsp:setProperty name="def" property="criteria" value="Romance"/>
     		 	</jsp:useBean>
     		 	<% 
     		 	def.setDefaultIndex();
     		 	for(int i=0;i<6;i++){
				Movie x= def.getIndexDefault();
				String picture=x.getCover();
				String title=x.getTitle();
				if(picture.equals("N/A"))
				{
					picture=x.getPoster();
				}
				%>
 			<div class="perMov">
 			  	<div class="perMovText">
		 	    <p><%= x.getTitle()%>	  </p>	<br>
    		 	    <p>Year:		<%= x.getYear()%>    	    </p>	<br>
		 	    <p>Genres:		<%= x.getGenres()%>	    </p>	<br>	
		 	    <p>Director(s):	<%= x.getDirector()%>	    </p> 	<br>	
		 	    <p>Runtime:		<%= x.getMinutes()%>	    </p>	<br>	
		 	    <p>Average Rating:	<%= x.getRating()%>	    </p>	<br> 
		      	</div>
		      <img src="<%= picture%>" class="disPersono">
		      
		  </div>
		  <%}def.setDefaultIndex();%>
			 		
<!-- 		  
			<div class="perMov"><!--Oldboy(2003)
 		  	<div class="perMovText">
    		    	    <jsp:useBean id="default1" class="backend.MovieDisplayer" >
			    <jsp:setProperty name="default1" property="movieId" value="364569"/>
		 	    <p><jsp:getProperty name="default1" property="title"/>	  </p>	<br>
    		 	    <p>Year:		<jsp:getProperty name="default1" property="year"/>    	    </p>	<br>
		 	    <p>Genres:		<jsp:getProperty name="default1" property="genres"/>  	    </p>	<br>	
		 	    <p>Director(s):	<jsp:getProperty name="default1" property="director"/>	    </p> 	<br>	
		 	    <p>Runtime:		<jsp:getProperty name="default1" property="minutes"/> 	    </p>	<br>	
		 	    <p>Average Rating:	<jsp:getProperty name="default1" property="averageRating"/> </p>	<br> 
       			    </jsp:useBean>

		      	</div>
		      <img src="https://i.pinimg.com/originals/93/9e/11/939e1162894afe6e4097669684c6e30a.jpg" class="disPersono">
		      
		  </div>
		  <div class="perMov"><!--Life is Beautiful
		    	<div class="perMovText">
		    	    <jsp:useBean id="default2" class="backend.MovieDisplayer" >
 	    		    <jsp:setProperty name="default2" property="movieId" value="118799"/>
		 	    <p><jsp:getProperty name="default2" property="title"/>	  		    </p>	<br>
    		 	    <p>Year:		<jsp:getProperty name="default2" property="year"/>    	    </p>	<br>
		 	    <p>Genres:		<jsp:getProperty name="default2" property="genres"/>  	    </p>	<br>	
		 	    <p>Director(s):	<jsp:getProperty name="default2" property="director"/>	    </p> 	<br>	
		 	    <p>Runtime:		<jsp:getProperty name="default2" property="minutes"/> 	    </p>	<br>	
		 	    <p>Average Rating:	<jsp:getProperty name="default2" property="averageRating"/> </p>	<br>        		
		 	    </jsp:useBean>	
		      	</div>
		      <img src="https://wallpapercave.com/wp/wp6574108.jpg class="disPersono">
		  </div>
		  
		  <div class="perMov"><!--Before Sunrise
     		  	<div class="perMovText">
	  		    <jsp:useBean id="default3" class="backend.MovieDisplayer" >
		    	    <jsp:setProperty name="default3" property="movieId" value ="112471"/>
		 	    <p><jsp:getProperty name="default3" property="title"/>	  </p>	<br>
    		 	    <p>Year:		<jsp:getProperty name="default3" property="year"/>    	    </p>	<br>
		 	    <p>Genres:		<jsp:getProperty name="default3" property="genres"/>  	    </p>	<br>	
		 	    <p>Director(s):	<jsp:getProperty name="default3" property="director"/>	    </p> 	<br>	
		 	    <p>Runtime:		<jsp:getProperty name="default3" property="minutes"/> 	    </p>	<br>	
		 	    <p>Average Rating:	<jsp:getProperty name="default3" property="averageRating"/> </p>	<br>  
			    </jsp:useBean>		 	    	
		      	</div>
		      <img src="https://image.tmdb.org/t/p/original/tbJgSs51LvTzEMZOn3iIGNg8NY4.jpg" class="disPersono">
		  </div>

		  <div class="perMov">
   		  	<div class="perMovText"><!--Persona
		    	    <jsp:useBean id="default4" class="backend.MovieDisplayer" >
			    <jsp:setProperty name="default4" property="movieId" value ="60827"/>
		 	    <p>	<jsp:getProperty name="default4" property="title"/>	  </p>	<br>
    		 	    <p>Year:		<jsp:getProperty name="default4" property="year"/>    	    </p>	<br>
		 	    <p>Genres:		<jsp:getProperty name="default4" property="genres"/>  	    </p>	<br>	
		 	    <p>Director(s):	<jsp:getProperty name="default4" property="director"/>	    </p> 	<br>	
		 	    <p>Runtime:		<jsp:getProperty name="default4" property="minutes"/> 	    </p>	<br>	
		 	    <p>Average Rating:	<jsp:getProperty name="default4" property="averageRating"/> </p>	<br>  	
			    </jsp:useBean>
		      	</div>
		      <img src="https://i.pinimg.com/originals/10/55/e7/1055e7cd01e2555d7136e3ffeafd55f8.png" class="disPersono">
		  </div>

		  <div class="perMov">
   		  	<div class="perMovText"><!--The Grand Budapest Hotel
		    	    <jsp:useBean id="default5" class="backend.MovieDisplayer" >
			    <jsp:setProperty name="default5" property="movieId" value ="2278388"/>
		 	    <p><jsp:getProperty name="default5" property="title"/>	  </p>	<br>
    			    <p>Year:		<jsp:getProperty name="default5" property="year"/>    	    </p>	<br>
		 	    <p>Genres:		<jsp:getProperty name="default5" property="genres"/>  	    </p>	<br>	
		 	    <p>Director(s):	<jsp:getProperty name="default5" property="director"/>	    </p> 	<br>	
		 	    <p>Runtime:		<jsp:getProperty name="default5" property="minutes"/> 	    </p>	<br>	
		 	    <p>Average Rating:	<jsp:getProperty name="default5" property="averageRating"/> </p>	<br> 			
		 	     	    </jsp:useBean>
		      	</div>
		      <img src="https://images2.alphacoders.com/760/760735.jpg" class="disPersono">
		  </div>
		  
		  <div class="perMov">
   		  	<div class="perMovText"><!--Interstellar
		    	    <jsp:useBean id="default6" class="backend.MovieDisplayer" >
			    <jsp:setProperty name="default6" property="movieId" value ="816692"/>
		 	    <p><jsp:getProperty name="default6" property="title"/>	  </p>	<br>
    		 	    <p>Year:		<jsp:getProperty name="default6" property="year"/>    	    </p>	<br>
		 	    <p>Genres:		<jsp:getProperty name="default6" property="genres"/>  	    </p>	<br>	
		 	    <p>Director(s):	<jsp:getProperty name="default6" property="director"/>	    </p> 	<br>	
		 	    <p>Runtime:		<jsp:getProperty name="default6" property="minutes"/> 	    </p>	<br>	
		 	    <p>Average Rating:	<jsp:getProperty name="default6" property="averageRating"/> </p>	<br> 	
		 	    </jsp:useBean>
		      	</div>
		      <img src="https://wallpapercave.com/wp/wp2196807.jpg" class="disPersono">
		  </div>
-->	          
	          <!-- Next and previous buttons -->
		  <a class="prev" onclick="nextMovie(-1)">&#10094;</a>
		  <a class="next" onclick="nextMovie(1)">&#10095;</a>
		  
	</div>	<!-- Persona Movies -->
	     		<div class="category">
			     <p>Your Personalized Recommendations</p>
		        </div>
	  <!-- Thumbnail Movies-->
		<div class="movieRow">	
			<jsp:useBean id="de" class="backend.Recommender"> 
			  <jsp:setProperty name="de" property="criteria" value="Romance"/>
     		 	</jsp:useBean>
     		       <% de.setDefaultIndex();%>
     		    <div class="movieColumn">
     		       <%{
     		 		Movie x=de.getIndexDefault();
	     			String picture=x.getCover();
     		 		if(picture.equals("N/A"))
				{
					picture=x.getPoster();
				}
			%>
		<img class="pero" src="<%= picture%>" onclick="currentMovie(1)" alt="Oldboy" />
		      <%}%>
		    </div>
		    
		    <div class="movieColumn">
		         <%{
				Movie x=de.getIndexDefault();
	     			String picture=x.getCover();
     		 		if(picture.equals("N/A"))
				{
					picture=x.getPoster();
				}
			  %>
		      <img class="pero" src="<%= picture %>" onclick="currentMovie(2)" alt="">
			<%}%>
		    </div>
		    		    <div class="movieColumn">
		         <%{
				Movie x=de.getIndexDefault();
	     			String picture=x.getCover();
     		 		if(picture.equals("N/A"))
				{
					picture=x.getPoster();
				}
		      	 %>
		      <img class="pero" src="<%= picture %>" onclick="currentMovie(3)" alt="">
			<%}%>
		    </div>
		    <div class="movieColumn">
		         <%{
	     			Movie x=de.getIndexDefault();
	     			String picture=x.getCover();
     		 		if(picture.equals("N/A"))
				{
					picture=x.getPoster();
				}
			%>
		      <img class="pero" src="<%= picture %>" onclick="currentMovie(4)" alt="">
			<%}%>
		    </div>		  
		    		    <div class="movieColumn">
		         <%{
				Movie x=de.getIndexDefault();
	     			String picture=x.getCover();
     		 		if(picture.equals("N/A"))
				{
					picture=x.getPoster();
				}
			%>
		      <img class="pero" src="<%= picture %>" onclick="currentMovie(5)" alt="">
			<%}%>
		    </div>
		    		    <div class="movieColumn">
		         <%{
				Movie x=de.getIndexDefault();
	     			String picture=x.getCover();
	     		 	if(picture.equals("N/A"))
				{
					picture=x.getPoster();
				}
			%>
		      <img class="pero" src="<%= picture %>" onclick="currentMovie(6)" alt="">
			<%} de.setDefaultIndex();%>
		    </div>
		</div>
<!-- First Row -->
		<div class="movieRow">
		        <jsp:useBean id="r1" class="backend.Recommender"> 
			        <jsp:setProperty name="r1" property="criteria" value ="Comedy"/>
     		 	</jsp:useBean>
     			<div class="category">
				<jsp:getProperty name="r1" property="criteria"/>
		        </div>
			<% for(int i=0;i<6;i++){
				Movie x= r1.getIndexMovie();%>
     		 	<div class="movieColumn">	
		       		<img class="thumb" src="<%= x.getPoster()%>" style="width:100%" alt="<%= 
		       		x.getTitle()%>
		       	    <br>Year:<%= x.getYear()%>		 	    
		       	    <br>Genres:<%= x.getGenres()%>	    
		 	    <br>Director(s):<%= x.getDirector()%>	    
		 	    <br>Runtime:<%= x.getMinutes()%>	    
		 	    <br>Average Rating:<%= x.getRating()%>">
		       		<div id="modalBg" class="modal">
				  <span class="close" onclick="document.getElementById('myModal').style.display='none'">&times;</span>
				  <img class="modal-content" id="img01">
				  <div id="movieDets"></div>
				</div>
	           	</div>
	           	<%}%>
		</div>
<!-- Second Row -->
		<div class="movieRow">
		        <jsp:useBean id="r2" class="backend.Recommender"> 
			        <jsp:setProperty name="r2" property="criteria" value ="Thriller"/>
     		 	</jsp:useBean>
     			<div class="category">
				<jsp:getProperty name="r2" property="criteria"/>
		        </div>
			<% for(int i=0;i<6;i++){
				Movie x= r2.getIndexMovie();%>
     		 	<div class="movieColumn">	
		       		<img class="thumb" src="<%= x.getPoster()%>" style="width:100%" alt="<%= 
		       		x.getTitle()%>
		       	    <br>Year:<%= x.getYear()%>		 	    
		       	    <br>Genres:<%= x.getGenres()%>	    
		 	    <br>Director(s):<%= x.getDirector()%>	    
		 	    <br>Runtime:<%= x.getMinutes()%>	    
		 	    <br>Average Rating:<%= x.getRating()%>">
		       		<div id="modalBg" class="modal">
				  <span class="close" onclick="document.getElementById('myModal').style.display='none'">&times;</span>
				  <img class="modal-content" id="img01">
				  <div id="movieDets"></div>
				</div>
	           	</div>
	           	<%}%>
		</div>
<!-- Third Row -->
      		<div class="movieRow">
		        <jsp:useBean id="r3" class="backend.Recommender"> 
			        <jsp:setProperty name="r3" property="criteria" value ="Horror"/>
     		 	</jsp:useBean>
     			<div class="category">
				<jsp:getProperty name="r3" property="criteria"/>
				
		        </div>
			<% for(int i=0;i<6;i++){
				Movie x= r3.getIndexMovie();%>
     		 	<div class="movieColumn">	
		       		<img class="thumb" src="<%= x.getPoster()%>" style="width:100%" alt="<%= 
		       		x.getTitle()%>
		       	    <br>Year:<%= x.getYear()%>		 	    
		       	    <br>Genres:<%= x.getGenres()%>	    
		 	    <br>Director(s):<%= x.getDirector()%>	    
		 	    <br>Runtime:<%= x.getMinutes()%>	    
		 	    <br>Average Rating:<%= x.getRating()%>">
		       		<div id="modalBg" class="modal">
				  <span class="close" onclick="document.getElementById('myModal').style.display='none'">&times;</span>
				  <img class="modal-content" id="img01">
				  <div id="movieDets"></div>
				</div>
	           	</div>
	           	<%}%>
		</div> 		
<!-- Fourth Row -->
      		<div class="movieRow">
		        <jsp:useBean id="r4" class="backend.Recommender"> 
			        <jsp:setProperty name="r4" property="criteria" value ="Romance"/>
     		 	</jsp:useBean>
     			<div class="category">
				<jsp:getProperty name="r4" property="criteria"/>
		        </div>
			<% for(int i=0;i<6;i++){
				Movie x= r4.getIndexMovie();%>
     		 	<div class="movieColumn">
		       		<img class="thumb" src="<%= x.getPoster()%>" style="width:100%" alt="<%= 
		       		x.getTitle()%>
		       	    <br>Year:<%= x.getYear()%>		 	    
		       	    <br>Genres:<%= x.getGenres()%>	    
		 	    <br>Director(s):<%= x.getDirector()%>	    
		 	    <br>Runtime:<%= x.getMinutes()%>	    
		 	    <br>Average Rating:<%= x.getRating()%>">
		       		<div id="modalBg" class="modal">
				  <span class="close" onclick="document.getElementById('myModal').style.display='none'">&times;</span>
				  <img class="modal-content" id="img01">
				  <div id="movieDets"></div>
				</div>
	           	</div>
	           	<%}%>
	        </div> 		
	        <script src="HomePage.js"></script>
       	        <script src="Default.js"></script>
	</body>
</html>
