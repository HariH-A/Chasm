package backend;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		Connection objcon = null;
		ResultSet objRS = null;
		String rs = null;
					PrintWriter out = response.getWriter();
		try {
			objcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");

			PreparedStatement st = objcon.prepareStatement("select * from users where Rater_ID = ?");
			st.setString(1, request.getParameter("id"));
			objRS=st.executeQuery();
			boolean ch;
			while (objRS.next()) {
				rs=objRS.getString(1);
				if(!(objRS.getString(2).matches(request.getParameter("pass")))) {
						RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
						ch=false;
						out.println("k");
						request.setAttribute("check", ch);
						dispatcher.forward(request, response);
					}
				else {
				st=objcon.prepareStatement("update users SET isUser='0'");
					st.execute();
					st=objcon.prepareStatement("update users SET isUser='1' where Rater_ID ="+objRS.getString(1));
					st.execute();
					RequestDispatcher dispatcher=request.getRequestDispatcher("HomePage.jsp");
					request.setAttribute("user_id",objRS.getString(1));
					dispatcher.forward(request, response);
				}
			}
			if (rs==null) {
					RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
					ch=true;
					request.setAttribute("check", ch);
					dispatcher.forward(request, response);
			}
		} catch (Exception e) {
		
			out.println(e);
		}
		out.println("ooook");
	}

}
