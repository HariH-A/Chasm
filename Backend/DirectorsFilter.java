
public class DirectorsFilter implements Filter{
    private String[] director;
    public DirectorsFilter(String dir)
    {
       director=dir.split(",");
    }
    
    public boolean satisfies(String movieId)
    {   
        for(String dir:director)
        {
            if(MovieDatabase.getDirector(movieId).contains(dir))
            return true;
        }
        return false;    
    }
}
