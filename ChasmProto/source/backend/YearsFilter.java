package backend;
public class YearsFilter implements Filters {
	private int myYear;
	
	public YearsFilter(int year) {
		myYear = year;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDB.getYear(id) >= myYear;
	}

}
