package soen387.videogamestore.servlets;

import com.mysql.jdbc.Driver;
import java.io.*;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import java.sql.*;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		if (session != null) {
			// session retrieved, continue with servlet operations
			
			String username = request.getParameter("user");
			String pw = request.getParameter("pw");

			//attributes to establish mysql connection using xampp
			String url  ="jdbc:mysql://localhost:3306/ovgs";
			String user = "root";
			// redirect link
			String redirect = "";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver found");
			}catch(ClassNotFoundException e) {
				System.out.println("Driver not found: " + e);

			}
			try {
				Connection conn = DriverManager.getConnection(url, user, "");
				System.out.println("connected successfully...");

				Statement stt = conn.createStatement();

				// select db
				stt.execute("USE ovgs;");

				//verify username and password
				//TODO check if username exists
				ResultSet query = stt.executeQuery("SELECT username, password FROM login WHERE username = '" + username +"';");
				if(query.next()) {
					String queryPW = query.getString("password");
					if(queryPW.equals(pw)) {
						redirect= "search.jsp";
						//TODO use the info to create a session for the user
					}else {
						String message = "wrong password! try again.";
						redirect = "login.jsp?message=" + URLEncoder.encode(message, "UTF-8");
					}


				}else { // if a record exists with the same username
					String message = "Username is wrong. Please register first!";
					redirect = "register.jsp?message=" + URLEncoder.encode(message, "UTF-8");

				}
			} catch (SQLException e) {
				System.out.println("Something went wrong with the connection: " + e );

			}
			session.setAttribute("name", username);
			response.sendRedirect(redirect);
		}
		else{
			// no session, return an error page
		}

	}


}
