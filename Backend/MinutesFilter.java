public class MinutesFilter  implements Filters {
    private int minMinutes, maxMinutes;
    public MinutesFilter(int minutes, int maxutes)
    {
        minMinutes=minutes;
        maxMinutes=maxutes;
    }
    
    public boolean satisfies(String movieId)
    {   
        int minutes=movieDB.getMinutes(movieId);
        return minMinutes<=minutes && maxMinutes>=minutes;
    }
}
