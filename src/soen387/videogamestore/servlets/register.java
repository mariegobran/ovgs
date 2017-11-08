package soen387.videogamestore.servlets;


import java.io.*;
import java.net.URLEncoder;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from register.jsp form
		String username = request.getParameter("user");
		String pw = request.getParameter("pw");
		String pwRE = request.getParameter("pwRe");
 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String zip = request.getParameter("zip");
		
		
		//attributes to establish mysql connection using xampp
		String url  ="jdbc:mysql://localhost:3306/ovgs";
		String user = "root";
		// redirect link
		String redirect = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver not found:" + e);

		}
		try {
			Connection conn = DriverManager.getConnection(url, user, "");
			System.out.println("connected successfully...");

			Statement stt = conn.createStatement();

			// select db
			stt.execute("USE ovgs;");

			//verify username and password
			//TODO check if username exists
			ResultSet query = stt.executeQuery("SELECT username FROM login WHERE username = '" + username +"';");
			if(!query.next()) {
				//TODO check if password is okay to use
				// at least one number, one letter, and be between 6-12 character in length.
				if(!pw.matches("(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,12})$")){
					String message = "make sure your password contains  at least \n"
							+ "one number, one letter, and be between 6-12 character in length.";
					redirect = "register.jsp?message=" + URLEncoder.encode(message, "UTF-8");
				
				// check if passwords match.
				}else if(!pw.equals(pwRE)) {
					String message = "passwords doesn't match!";
					redirect = "register.jsp?message=" + URLEncoder.encode(message, "UTF-8");
					
				}else {
				// Add new user
				stt.execute("INSERT INTO login (username, password) VALUES"
						+ "('"
						+ username + "','"
						+ pw + "');");
				//TODO RETRIVE userID from login table
				int userID= 0;
				ResultSet rs = stt.executeQuery("SELECT userID FROM login WHERE username = '"+ username +"';");
				if(rs.next()) {
				 userID = rs.getInt("userID");
				}
				//TODO create a user entry in the users table 
				stt.execute("INSERT INTO users ( userID, firstName, lastName, email, address1, address2 , city, state, zip , country) VALUES"
						+ "('"
						+ userID + "','"
						+ firstName + "','"
						+ lastName + "','"
						+ email + "','"
						+ address1 + "','"
						+ address2 + "','"
						+ city + "','"
						+ state + "','"
						+ zip + "','"
						+ country + "');");
				
				
				redirect = "login.jsp";
				//TODO use the info to create a session for the user
				}
			}else { // if a record exists with the same username
				String message = "Username already exists. please try again!";
				redirect = "register.jsp?message=" + URLEncoder.encode(message, "UTF-8");

			}
		} catch (SQLException e) {
			System.out.println("Something went wrong with the connection: " + e );

		}
		response.sendRedirect(redirect);


	}



}
