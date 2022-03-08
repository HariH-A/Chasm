package backend;
import java.io.IOException;
import java.util.ArrayList;
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


public class search extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		ResultSet resultSet=null;
		String rs=null;
		PreparedStatement statement=null;
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
		try (Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "")){
			ArrayList<Movie> movies=new ArrayList<Movie>();
			String sql="SELECT * FROM ";
			String parameter=request.getParameter("search");
			String checker="actioncomedyoldscifithriller";
			String antenna="";
			if(checker.contains(parameter)){
					sql+=request.getParameter("search");
					antenna="GENRE";
			}
			else{
				sql+="movies WHERE Director LIKE '%"+parameter+"%'OR Title LIKE '%"+parameter+"%'";
				antenna="DATA";
			}
			try{
				statement=connect.prepareStatement(sql);	
				resultSet= statement.executeQuery();
				while (resultSet.next()) {
					Movie mov=new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8),	resultSet.getDouble(9));
					movies.add(mov);
					rs=resultSet.getString(2);
				}
				request.setAttribute(antenna, movies);
			}catch(SQLException e){
				response.setContentType("text/html");
				out.println(e+antenna+"<html><body><h1>Sorry no results were found. </h1></body></html>");
		}catch(Exception e) {
				response.setContentType("text/html");
				out.println(e+antenna+"<html><body><h1>"+parameter+"Sorry no results were found.</h1></body></html>");
			}
		}catch(SQLException e){
				response.setContentType("text/html");
				out.println(e+"<html><body><h1>Sorry no results were found. Maybe try checking with alternate spelling.</h1></body></html>");
		}catch(Exception e){
				response.setContentType("text/html");
				out.println(e+"<html><body><h1>Sorry no results were found. Maybe try checking with alternate spelling.</h1></body></html>");
		}
			rd.include(request, response);	
	}
}
