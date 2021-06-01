
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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			objcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
			PrintWriter out = response.getWriter();
			PreparedStatement st = objcon.prepareStatement("select * from users where Rater_ID = ?");
			st.setString(1, request.getParameter("id"));
			objRS = st.executeQuery();
			while (objRS.next()) {
				rs = objRS.getString(1);
				if (!(objRS.getString(2).matches(request.getParameter("pass")))) {
					out.println("<h1>INVALID PASSWORD</h1>");
					}
				else {
				out.print("<h1>WELCOME!! Logged in successfully</h1><table><tr>");
				out.print("<tr><td>User ID:</td><td>");
				out.print(objRS.getString(1));
				out.print("</tr>");
				}
			}

			if (rs == null) {
				objcon.close();
				response.setContentType("text/html");
				out.println("<html><body><h1>ID has not been Registered yet</h1></body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
