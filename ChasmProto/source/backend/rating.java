package backend;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class rating extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		doGet(request, response);
		RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
		Connection objcon = null;
		PreparedStatement objps = null;
		String rs = null;
		try {
			objcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
			String sql = "insert into rating values(?,?,?)";
			PreparedStatement pstmt = objcon.prepareStatement(sql);
			Recommender recom=new Recommender();
			List<Movie> def=recom.getDefaultList();
			String rater=request.getParameter("id");
			for(int i=0;i<def.size();i++) {
			    out.println("Inside");
			    String save=def.get(i).getID();
			    String movie=def.get(i).getTitle();
			    pstmt.setString(1, rater);
			    pstmt.setString(2, save);
    			    pstmt.setDouble(3, Double.parseDouble(request.getParameter(movie)));
			    pstmt.executeUpdate();
			}
			pstmt.close();
		}catch (SQLException e) {
			out.println(e);
		}
		catch (Exception e) {
			out.println(e);
		}				
		dispatcher.forward(request, response);
	}

}
