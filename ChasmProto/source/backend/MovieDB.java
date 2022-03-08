package backend;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieDB {

	public static void main(String[] args) {
		MovieDB.initialize();
		int size = MovieDB.size();
		System.out.println(size);
	}
	// TODO Auto-generated method stub

	private static HashMap<String, Movie> Movies;

	public static void initialize() {
		if (Movies == null) {
			Movies = new HashMap<String, Movie>();
			String query = "select id,title,year,genre,director,minutes,poster,avg_rating,wallpaper from movies";
			Connection con = null;
			ResultSet rs = null;
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
				Statement stmt = con.createStatement();
				rs=stmt.executeQuery(query);
				while (rs.next()) {
					Movies.put(rs.getString("id"),
							(new Movie(rs.getString("id"), 
								   rs.getString("title"), 
						 	           rs.getString("year"),	
						  		   rs.getString("genre"), 
						  		   rs.getString("director"),
   			  		          Integer.parseInt(rs.getString("minutes")), 
   			  		                           rs.getString("Poster"),	
							           rs.getDouble("avg_rating"),
							           rs.getString("wallpaper"))));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static boolean containsID(String id) {
		initialize();
		return Movies.containsKey(id);
	}

	public static int getYear(String id) {
		initialize();
		return Movies.get(id).getYear();
	}

	public static String getGenres(String id) {
		initialize();
		return Movies.get(id).getGenres();
	}

	public static String getTitle(String id) {
		initialize();
		return Movies.get(id).getTitle();
	}

	public static Movie getMovie(String id) {
		initialize();
		return Movies.get(id);
	}

	public static int getMinutes(String id) {
		initialize();
		return Movies.get(id).getMinutes();
	}

	public static String getDirector(String id) {
		initialize();
		return Movies.get(id).getDirector();
	}

	public static String getPoster(String id) {
		initialize();
		return Movies.get(id).getPoster();
	}	
	public static String getCover(String id) {
		initialize();
		return Movies.get(id).getCover();
	}
	public static double getAverageRating(String id) {
		initialize();
		return Movies.get(id).getRating();
	}
	
	public static int size() {
		return Movies.size();
	}
	
	public static ArrayList<String> filterBy(Filters f) {
		initialize();
		ArrayList<String> list = new ArrayList<String>();
		for (String id : Movies.keySet()) {
			if (f.satisfies(id)) {
				list.add(id);
			}
		}

		return list;
	}

	//Returns an ArrayList of Movies
	public static ArrayList<Movie> filter(Filters f) {
		initialize();
		ArrayList<Movie> list = new ArrayList<Movie>();
		for (String id : Movies.keySet()) {
			if (f.satisfies(id)) {
				list.add(Movies.get(id));
			}
		}

		return list;
	}

}
