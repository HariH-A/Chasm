
public class MinutesFilter  implements Filter {
    private int minMinutes, maxMinutes;
    public MinutesFilter(int minutes, int maxutes)
    {
        minMinutes=minutes;
        maxMinutes=maxutes;
    }
    
    public boolean satisfies(String movieId)
    {   
        int minutes=MovieDatabase.getMinutes(movieId);
        return minMinutes<=minutes && maxMinutes>=minutes;
    }
}
