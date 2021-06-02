import java.util.ArrayList;
import java.util.Collections;

public class Tester {
		 public static void printMovieAverage()
		    {
		       RaterGetter data=new RaterGetter();
		        MovieDB.initialize();
		        
		        System.out.println("Number of Movies in the File: "+MovieDB.size());
		        System.out.println("Number of Raters in the File: "+RaterDB.size());
		        
		        ArrayList<Rating> ratings=data.getAverageRatings(1);
		        Collections.sort(ratings);
		        System.out.println("Number of Movies that have atleast the minimal number of raters: "+ratings.size());
		        for(Rating rating:ratings)
		        {
		            System.out.println(rating.getValue()+" "+MovieDB.getTitle(rating.getMovie()));
		        }
		    }    
		    
		    public static void printAverageRatingsByYearAndGenre()
		    {
		        RaterGetter data=new RaterGetter();
		        MovieDB.initialize();
		        
		        System.out.println("Number of Movies in the File: "+MovieDB.size());
		        System.out.println("Number of Raters in the File: "+RaterDB.size());
		        
		        AllFilters af=new AllFilters();
		        af.addFilter(new GenreFilter("Romance"));
		        af.addFilter(new YearsFilter(1980));
		        
		        ArrayList<Rating> ratings=data.getAverageRatingsByFilter(1,af);
		        Collections.sort(ratings);
		        System.out.println("Number of Movies that matched: "+ratings.size());
		        for(Rating rating:ratings)
		        {
		            System.out.println(rating.getValue()+" Year: "+MovieDB.getYear(rating.getMovie())+" "+MovieDB.getTitle(rating.getMovie())+"\n \t"+MovieDB.getGenres(rating.getMovie()));
		        }
		    }
		    
		    public static void printSimilarRatings()
		    {
		        RaterGetter data=new RaterGetter();
		        MovieDB.initialize();
		                
		        System.out.println("Number of Movies in the File: "+MovieDB.size());
		        System.out.println("Number of Raters in the File: "+RaterDB.size());
		        
		        
		        String raterId="71";
		        int similarRaters=20;
		        int minRaters=5;
		        
		        ArrayList<Rating> ratings=data.getSimilarRatings(raterId,similarRaters,minRaters);
		        System.out.println("Number of Movies: "+ratings.size());
		        for(Rating rating:ratings)
		        {
		            System.out.println(rating.getValue()+" "+MovieDB.getTitle(rating.getMovie()));
		        }
		    }
		    public static void printSimilarRatingsByDirector()
		    {
		        RaterGetter data=new RaterGetter();
		        MovieDB.initialize();        
		        
		        System.out.println("Number of Movies in the File: "+MovieDB.size());
		        System.out.println("Number of Raters in the File: "+RaterDB.size());
		        
		        
		        String raterId="120";
		        int similarRaters=10;
		        int minRaters=2;
		        Filters filter=new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
		        
		        ArrayList<Rating> ratings=data.getSimilarRatingsByFilter(raterId,similarRaters,minRaters,filter);
		        System.out.println("Number of Movies: "+ratings.size());
		        for(Rating rating:ratings)
		        {
		            System.out.println(rating.getValue()+" "+MovieDB.getTitle(rating.getMovie()));
		        }
		    }
		    public static void printSimilarRatingsByGenreAndMinutes()
		    {
		        RaterGetter data=new RaterGetter();
		        MovieDB.initialize();
		        
		        System.out.println("Number of Movies in the File: "+MovieDB.size());
		        System.out.println("Number of Raters in the File: "+RaterDB.size());
		        
		        
		        String raterId="168";
		        int similarRaters=10;
		        int minRaters=3;
		        AllFilters filter=new AllFilters();
		        filter.addFilter(new GenreFilter("Drama"));
		        filter.addFilter(new MinutesFilter(80,120));
		        
		        ArrayList<Rating> ratings=data.getSimilarRatingsByFilter(raterId,similarRaters,minRaters,filter);
		        System.out.println("Number of Movies: "+ratings.size());
		        for(Rating rating:ratings)
		        {
		            System.out.println(rating.getValue()+" "+MovieDB.getTitle(rating.getMovie()));
		        }
		    }
		    public static void printSimilarRatingsByYearAndMinutes()
		    {
		     	RaterGetter data=new RaterGetter();
		        MovieDB.initialize();   
		        
		        System.out.println("Number of Movies in the File: "+MovieDB.size());
		        System.out.println("Number of Raters in the File: "+RaterDB.size());
		        
		        
		        String raterId="314";
		        int similarRaters=10;
		        int minRaters=5;
		        AllFilters filter=new AllFilters();
		        filter.addFilter(new YearsFilter(1975));
		        filter.addFilter(new MinutesFilter(70,200));
		        
		        ArrayList<Rating> ratings=data.getSimilarRatingsByFilter(raterId,similarRaters,minRaters,filter);
		        System.out.println("Number of Movies: "+ratings.size());
		        for(Rating rating:ratings)
		        {
		            System.out.println(rating.getValue()+" "+MovieDB.getTitle(rating.getMovie()));
		        }
		    }
		    public static void main(String[] args){
		    	//printSimilarRatingsByYearAndMinutes();
		    	//printSimilarRatingsByGenreAndMinutes();
		    	//printSimilarRatingsByDirector();
		    	//printSimilarRatings();
		    	//printMovieAverage();
		    	printAverageRatingsByYearAndGenre();
		    	
		    }
		}
