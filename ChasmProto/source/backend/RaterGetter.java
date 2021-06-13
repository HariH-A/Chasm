package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

public class RaterGetter {

	public RaterGetter() {
		//RaterDB.initialize();
	}

	private double getAverageByID(String id, int minimalRaters) {
		int numRater = 0;
		double avg = 0.0;
		for (Rater currRater : RaterDB.getRaters()) {
			if (currRater.hasRating(id)) {
				avg += currRater.getRating(id);
				numRater++;
			}
		}
		if (numRater >= minimalRaters) {
			return avg / numRater;
		}
		return 0.0;
	}

	
	//overloaded with minimal raters but input 1 for without minimal raters 
	public ArrayList<Rating> getAverageRatings(int minimalRaters) {
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ArrayList<String> movies = MovieDB.filterBy(new TrueFilter());
		for (String movieId : movies) {
			double raters = getAverageByID(movieId, minimalRaters);
			if (raters != 0.0) {
				Rating rating = new Rating(movieId, raters);
				ratings.add(rating);
			}
		}
		return ratings;
	}
	//overloaded with minimal raters but input 1 for without minimal raters 
	public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filters filterCriteria) {
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ArrayList<String> movies = MovieDB.filterBy(filterCriteria);
		for (String movieId : movies) {
			double raters = getAverageByID(movieId, minimalRaters);
			if (raters != 0.0) {
				Rating rating = new Rating(movieId, raters);
				ratings.add(rating);
			}
		}
		Collections.sort(ratings, Collections.reverseOrder());
		return ratings;
	}

	public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
		return getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, new TrueFilter());
	}

	public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters,
			Filters filterCriteria) {
		ArrayList<Rating> similarRatings = getSimilarities(id);// contains Rater ID;
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ArrayList<String> movies = MovieDB.filterBy(filterCriteria);

		for (String movieId : movies) {
			double average = weightedAverage(numSimilarRaters, similarRatings, movieId, minimalRaters);
			if (average != 0.0) {
				Rating rating = new Rating(movieId, average);
				ratings.add(rating);
			}
		}
		Collections.sort(ratings, Collections.reverseOrder());
		return ratings;
	}

	private double weightedAverage(double numSimilarRaters, ArrayList<Rating> similarRatings, String movieId,
			int minRaters) {
		double average = 0;
		int numRated = 0;
		for (int i = 0; i < numSimilarRaters && i < similarRatings.size(); i++) {
			// Rating here stores rater id and similarity with a given rater.
			Rating rat = similarRatings.get(i);
			Rater currRater = RaterDB.getRater(rat.getMovieID());
			if (currRater.hasRating(movieId)) {
				average += rat.getValue() * currRater.getRating(movieId);
				numRated++;
			}
		}
		if (minRaters <= numRated)
			return average / numRated;
		else
			return 0;
	}

	private ArrayList<Rating> getSimilarities(String id) {
		ArrayList<Rating> relativeRatings = new ArrayList<Rating>();
		Rater user = RaterDB.getRater(id);
		// Rating here stores rater id and similarity with a given rater.
		for (Rater r : RaterDB.getRaters()) {
			if (!r.getID().equals(id)) {
				double similarity = dotProduct(user, r);
				if (similarity > 0) {
					Rating rating = new Rating(r.getID(), similarity);
					relativeRatings.add(rating);
				}
			}
		}
		Collections.sort(relativeRatings, Collections.reverseOrder());
		System.out.println(relativeRatings.size());
		return relativeRatings;
	}

	private double dotProduct(Rater user, Rater r) {
		double dotProduct = 0;
		for (String movieID : user.getMoviesRated()) {
			if (r.hasRating(movieID)) {
				double userRate = 5 - user.getRating(movieID);
				double themRate = 5 - r.getRating(movieID);
				dotProduct += userRate * themRate; // resolving a vector(similarity?) into it's components and computing
													// its projection on other such vectors.
			}
		}
		return dotProduct;
	}
	/*
	//overloaded without minimal raters
	private double getAverageByID(String id){
		int numRater = 0;
		double avg = 0.0;
		for (Rater currRater : RaterDB.getRaters()) {
			if (currRater.hasRating(id)) {
				avg+=currRater.getRating(id);
				numRater++;
			}
		}
		return avg/numRater;
	}
	//overloaded without minimal raters
	public ArrayList<Rating> getAverageRatings() {
		ArrayList<Rating> ratings=new ArrayList<Rating>();
		ArrayList<String> movies=MovieDB.filterBy(new TrueFilter());
		for (String movieId:movies) {
			double raters=getAverageByID(movieId);
			if (raters!=0.0){
				Rating rating=new Rating(movieId, raters);
				ratings.add(rating);
			}
		}
		return ratings;
	}
			
	public static void main(String[] args) {
		RaterGetter s = new RaterGetter();
		int a = -1;
		Connection objcon = null;
		PreparedStatement objps = null;
		try {
			objcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
			for (Rating rating : s.getAverageRatings(1)) {
				objps = objcon.prepareStatement("UPDATE `movies` SET `Avg_Rating`='"
						+ Math.round((rating.getValue()) * 100.0) / 100.0 + "' WHERE ID='" + rating.getMovie() + "';");
				a = objps.executeUpdate();
			}
			objcon.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.print(a);
	}
	*/
}
