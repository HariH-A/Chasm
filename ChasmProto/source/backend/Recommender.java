package backend;

import java.util.*;

public class Recommender implements java.io.Serializable{
	
	private List<Movie> movieList;
	private String criteria;//Filter
	private int index=-1;
	private int defIn=-1;
	private List<Movie>defaultList;
	
	public Recommender(){
		MovieDB.initialize();
		RaterDB.initialize();
		defaultList=RaterGetterLite.getDefaultList();
	}
	
	public void setCriteria(String genre){
		movieList=RaterGetterLite.getAverageRatingsByFilter(new GenreFilter(genre));
		defaultList=RaterGetterLite.getDefaultList();
		this.criteria=genre;
	}
	public void setDefaultIndex(){
		defIn=-1;
	}
	public Movie getIndexMovie(){
 	    index++;
	    return movieList.get(index);
	}
	public Movie getIndexDefault(){
 	    defIn++;
	    return defaultList.get(defIn);
	}
	
	public String getCriteria(){
		return criteria;
	}	
		
	public List<Movie> getMovieList(){
		movieList=RaterGetterLite.getAverageRatingsByFilter(new GenreFilter(criteria));
		return movieList;
	}
	public List<Movie> getDefaultList(){
		defaultList=RaterGetterLite.getDefaultList();
		return defaultList;
	}

/*public static void main(String[] args)
	{
		Recommender r1=new Recommender();
		r1.setCriteria("");
		System.out.println(r1.getMovieList().size());

	}	
	*/	
}
