package backend;
public class DirectorsFilter implements Filters{
    private String[] director;
    public DirectorsFilter(String dir)
    {
       director=dir.split(",");
    }
    
    public boolean satisfies(String movieId)
    {   
        for(String dir:director)
        {
            if(MovieDB.getDirector(movieId).contains(dir))
            return true;
        }
        return false;    
    }
}
