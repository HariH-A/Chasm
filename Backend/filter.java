
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filter
 */
@WebServlet("/filter")
public class filter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public filter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection objcon = null;
		ResultSet objRS = null;
		String rs = null;
		PreparedStatement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			objcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
			PrintWriter out = response.getWriter();
			String year = request.getParameter("year");
			if(year == null || year =="") {
				st = objcon.prepareStatement("SELECT * FROM movies WHERE genre LIKE '%"+request.getParameter("genre")+"%' AND Director LIKE '%"+
						request.getParameter("dir")+"%' AND  year > '"+request.getParameter("yraf")+"'");
							
			}
			else {
				 st = objcon.prepareStatement("SELECT * FROM movies WHERE genre LIKE '%"+request.getParameter("genre")+"%' AND Director LIKE '%"+
						request.getParameter("dir")+"%' AND year = '"+request.getParameter("year")+"'");
			}
			objRS = st.executeQuery();
			while (objRS.next()) {
				out.print("<br><h1>Movie Details</h1><table><tr>");
				out.print("<tr><td>Movie name:</td><td>");
				out.print(objRS.getString(2));
				out.print("</td></tr><tr><td>Country:</td><td>");
				out.print(objRS.getString(4));
				out.print("</td></tr><tr><td>genre:</td><td>");
				rs = objRS.getString(2);
				out.print(objRS.getString(5));
				out.print("</td></tr><tr><td>Director:</td><td>");
				out.print(objRS.getString(6));
				out.print("</td></tr><tr><td>Year:</td><td>");
				out.print(objRS.getString(3));
				out.print("</td></tr><tr><td>Runtime (in minutes):</td><td>");
				out.print(objRS.getInt(7));
				out.print("</tr></table>");
			}

			if (rs == null) {
				out.println("<h1>Sorry no data on this movie. Maybe try checking with alternate spelling.</h1>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
