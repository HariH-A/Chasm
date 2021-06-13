package backend;

import java.util.*;

public class MovieDisplayer implements java.io.Serializable{

	public String movieId;
	public String title;
	public int year;
	public String genres;
	public String director;
	public int minutes;
	public String poster;
	public double averageRating;
	public String cover;
	//public String country;

	public MovieDisplayer() {
		MovieDB.initialize();
	}

	public void setMovieId(String i){
		this.title=MovieDB.getTitle(i);
		this.year=MovieDB.getYear(i);
		this.genres=MovieDB.getGenres(i);
		this.director=MovieDB.getDirector(i); 	
		this.minutes=MovieDB.getMinutes(i);			
		this.poster=MovieDB.getPoster(i);
		this.averageRating=MovieDB.getAverageRating(i);
		this.movieId=i;
		this.cover=MovieDB.getCover(i);
	} 

	// Returns ID associated with this item
	public String getMovieId() {
		return movieId;
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
	public double getAverageRating(){
		return averageRating;
	}
	public String getCover(){
		return cover;
	}
	// Returns a string of the item's information
	public String toString() {
		String result = "Movie [id=" + movieId + ", title=" + title + ", year=" + year;
		result += ", genres= " + genres + "]";
		return result;
	}
}
