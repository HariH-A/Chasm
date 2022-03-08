package backend;
public class GenreFilter implements Filters {
    
    private String myGenre;
	
	public GenreFilter(String genre) {
		myGenre = genre;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDB.getGenres(id).contains(myGenre);
	}
}
