package backend;

import java.util.*;

public class Movie implements Comparable<Movie>{

	// An immutable passive data object (PDO) to represent item data
	public String id;
	public String title;
	public int year;
	public String genres;
	public String director;
	public int minutes;
	public String poster;
	public double averageRating;
	public String cover;
	//public String country;

	public Movie(String anID, String aTitle, String aYear, String theGenres) {
		// just in case data file contains extra whitespace
		id = anID.trim();
		title = aTitle.trim();
		year = Integer.parseInt(aYear.trim());
		genres = theGenres;
	}

	public Movie(String anID, String aTitle, String aYear, String theGenres, String aDirector, int theMinutes, String cover) {
		// just in case data file contains extra whitespace
		id = anID.trim();
		title = aTitle.trim();
		year = Integer.parseInt(aYear.trim());
		genres = theGenres;
		director = aDirector;
		minutes = theMinutes;
		poster = cover;
	}
	public Movie(String anID, String aTitle, String aYear, String theGenres, String aDirector, int theMinutes, String cover,double avgrate) {
		// just in case data file contains extra whitespace
		id = anID.trim();
		title = aTitle.trim();
		year = Integer.parseInt(aYear.trim());
		genres = theGenres;
		director = aDirector;
		minutes = theMinutes;
		poster = cover;
		averageRating = avgrate;
	}
	public Movie(String anID, String aTitle, String aYear, String theGenres, String aDirector, int theMinutes, String theposter,double avgrate,String thecover) {
		// just in case data file contains extra whitespace
		id = anID.trim();
		title = aTitle.trim();
		year = Integer.parseInt(aYear.trim());
		genres = theGenres;
		director = aDirector;
		minutes = theMinutes;
		poster = theposter;
		averageRating = avgrate;
		cover=thecover;
	}
	// Returns ID associated with this item
	public String getID() {
		return id;
	}

	// Returns title of this item
	public String getTitle() {
		return title;
	}

	// Returns year in which this item was published
	public int getYear() {
		return year;
	}

	// Returns genres associated with this item
	public String getGenres() {
		return genres;
	}

	public String getDirector() {
		return director;
	}

	public int getMinutes() {
		return minutes;
	}
	public String getPoster(){
		return poster;
	}
	public double getRating(){
		return averageRating;
	}
	public String getCover() {
		return cover;
	}

	// Returns a string of the item's information
	public String toString() {
		String result = "Movie [id=" + id + ", title=" + title + ", year=" + year;
		result += ", genres= " + genres + "]";
		return result;
	}
	
	//compare ratings//please change later
	public int compareTo(Movie other) {
        	if (averageRating==other.averageRating)
        	{
        		if (year <other.year) return -1;
        		if (year > other.year) return 1;
        		return 0;
        	}
        	if (averageRating < other.averageRating) return -1;
        	if (averageRating > other.averageRating) return 1;
        	return 0;
	}
}
