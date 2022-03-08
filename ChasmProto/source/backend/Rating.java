package backend;

// An immutable passive data object (PDO) to represent the rating data
public class Rating implements Comparable<Rating> {
    private String movie;
    private double value;

    public Rating (String thismovie, double aValue) {
        movie = thismovie;
        value = aValue;
    }

    // Returns movie being rated
    public String getMovieID () {
        return movie;
    }

    // Returns the value of this rating (as a number so it can be used in calculations)
    public double getValue () {
        return value;
    }

    // Returns a string of all the rating information
    public String toString () {
        return "[" + getMovieID() + ", " + getValue() + "]";
    }

    public int compareTo(Rating other) {
        if (value < other.value) return -1;
        if (value > other.value) return 1;
        
        return 0;
    }
}
