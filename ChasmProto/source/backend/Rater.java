package backend;
import java.util.*;
public class Rater{
    private String myID;
    private HashMap<String,Rating> myRatings;//movieId is the String
    
    
    public Rater(String id) {
        myID = id;
        myRatings = new HashMap<String,Rating>();
    }
    
    public void addRating(String movie, double rating)
    {
         myRatings.put(movie,new Rating(movie,rating));
    }
    public boolean hasRating(String movie)
    {
        return myRatings.containsKey(movie);
    }
    public String getID()
    {      return myID;         }
    
    public double getRating(String movie)
    {
        Rating rate=myRatings.get(movie);
        return rate.getValue();
    }
    public int numRatings()
    {
        return myRatings.size();
    }
    public ArrayList<String> getMoviesRated()
    {
        ArrayList<String> ratedMovieIDs=new ArrayList<String>();
        for(String id:myRatings.keySet())
        {
            ratedMovieIDs.add(id);
        }
        return ratedMovieIDs;
    }
}
