package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class RaterDB {


		private static HashMap<String, Rater> Raters;

		public static void initialize() {
			if (Raters == null) {
				Raters = new HashMap<String, Rater>();
				String query = "select Rater_ID,ID,Rating from rating";
				Connection con = null;
				ResultSet rs = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
					Statement stmt = con.createStatement();
					rs = stmt.executeQuery(query);
					while (rs.next()) {
						String raterID=rs.getString("Rater_ID");
						String movieID=rs.getString("ID");
						double rating=rs.getDouble("Rating");
						addRaterRating(raterID, movieID, (rating));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		public static void addRaterRating(String raterID, String movieID, double rating) {
			initialize();
			Rater rater = null;
			if (Raters.containsKey(raterID)) {
				rater = Raters.get(raterID);
			} else {
				rater = new Rater(raterID);
				Raters.put(raterID, rater);
			}
			rater.addRating(movieID, rating);
		}

		public static Rater getRater(String id) {
			initialize();
			return Raters.get(id);
		}

		public static ArrayList<Rater> getRaters() {
			initialize();
			ArrayList<Rater> list = new ArrayList<Rater>(Raters.values());
			return list;
		}

		public static int size() {
			return Raters.size();
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			RaterDB.initialize();
			int size = RaterDB.size();
			System.out.println(size);
		}


}
