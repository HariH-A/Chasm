package backend;

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

public class registration extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		Connection objcon = null;
		PreparedStatement objps = null;
		ResultSet objRS = null;
		String rs = null;
		boolean ch;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			objcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
			PrintWriter out = response.getWriter();
			if(request.getParameter("pass").matches(request.getParameter("rpass"))){
			PreparedStatement st = objcon.prepareStatement("select * from users where Rater_ID = ?");
			st.setString(1, request.getParameter("id"));
			objRS = st.executeQuery();
			while (objRS.next()) {
			rs = objRS.getString(1);
			if (!(objRS.getString(2).matches(request.getParameter("pass")))) {
						RequestDispatcher dispatcher=request.getRequestDispatcher("registration.jsp");
						ch=false;
						request.setAttribute("check", ch);
						dispatcher.forward(request, response);
				}
			}
			if (rs == null) {

				objps = objcon.prepareStatement("insert into users values(?,?,?)");
				objps.setString(1, request.getParameter("id"));
				objps.setString(2, request.getParameter("pass"));
				objps.setBoolean(3, false);
				objps.executeUpdate();
				objcon.close();
				RequestDispatcher dispatcher=request.getRequestDispatcher("rating.jsp");
				String rater_id=request.getParameter("id");
				request.setAttribute("rater_id", rater_id);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("registration.jsp");
				ch=true;
				request.setAttribute("check", ch);
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("registration.jsp");
			ch=false;
			request.setAttribute("check", ch);
			dispatcher.forward(request, response);
			
				

				objps.close();
		}
	}		catch (SQLException e) {
			e.printStackTrace();
		}
catch (Exception e) {
			e.printStackTrace();
		}
	}

}
