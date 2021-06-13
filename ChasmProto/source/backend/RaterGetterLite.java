package backend;

import java.util.*;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RaterGetterLite {

	public static ArrayList<Movie> defaultList;
	public RaterGetterLite() {
		//RaterDB.initialize();
		//MovieDB.initialize();
	}
	
	////////////////////////////////////
	//returns an ArrayList of Movies
	public static ArrayList<Movie> getAverageRatingsByFilter(Filters filterCriteria) {
		RaterGetter ratinGetter=new RaterGetter();
     		ArrayList<Movie> returnList=new ArrayList<Movie>();
   		ArrayList<Rating> ratingList=ratinGetter.getAverageRatingsByFilter(1,filterCriteria);
   		Collections.sort(ratingList, Collections.reverseOrder());
   		for(int i=0;i<10 && i<ratingList.size();i++)
        	{
            		Rating rating=ratingList.get(i);
			returnList.add(MovieDB.getMovie(rating.getMovieID()));
        	}
		return returnList;
	}
	////////////////////////////////////////
	/*public static ArrayList<Movie> getDefaultList(){
		return defaultList;
	}*/
     	public static ArrayList<Movie> getDefaultList(){
     		defaultList=new ArrayList<Movie>();
		defaultList.add(MovieDB.getMovie("364569"));//Oldboy
		defaultList.add(MovieDB.getMovie("118799"));//Life is beautiful
		defaultList.add(MovieDB.getMovie("112471"));//Before Sunrise
		defaultList.add(MovieDB.getMovie("60827"));//Persona
		defaultList.add(MovieDB.getMovie("2278388"));//The Grand Budapest Hotel
		defaultList.add(MovieDB.getMovie("816692"));//Interstellar
     		ArrayList<Movie> returnList=new ArrayList<Movie>();
     		ArrayList<Rating> ratingList=new ArrayList<Rating>();
     		RaterGetter ratinGetter=new RaterGetter();
     		String query="SELECT * FROM users WHERE isUser=true";
		ResultSet rs=null;
		String currRater="";
		try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "")){
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				if(rs.next()==true)
				{currRater=rs.getString(1);}
				if(rs.next()!=true){
					if(RaterDB.getRater(currRater)!=null)
						{	
							ratingList=ratinGetter.getSimilarRatings(currRater,1,1);
						}
					else{
						return defaultList;
					}	
				}
				else{
					return defaultList;
				}
     		}catch(SQLException e){
				e.printStackTrace();
		}catch(Exception e){
				e.printStackTrace();
		}
        	for(int i=0;i<10 && i<ratingList.size();i++)
        	{
            		Rating rating=ratingList.get(i);
		returnList.add(MovieDB.getMovie(rating.getMovieID()));
        	}
        	return returnList;
        }
}
