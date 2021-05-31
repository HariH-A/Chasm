
public class YearsFilter implements Filter {
	private int myYear;
	
	public YearsFilter(int year) {
		myYear = year;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getYear(id) >= myYear;
	}

}
