package soen387.videogamestore.servlets;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soen387.gameInfo;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session =  request.getSession();
		String username = (String) session.getAttribute("name");
		
		String searchBy = request.getParameter("searchBy");
		String keyword = request.getParameter("keyword");

		ResultSet query = null;
		ArrayList<gameInfo> output = new ArrayList<gameInfo>();
		//attributes to establish mysql connection using xampp
		String url  ="jdbc:mysql://localhost:3306/ovgs";
		String user = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			out.println("Driver found");
		}catch(ClassNotFoundException e) {
			out.println("Driver not found:" + e);

		}
		try {
			Connection conn = DriverManager.getConnection(url, user, "");
			System.out.println("connected successfully...");

			Statement stt = conn.createStatement();

			// select db
			stt.execute("USE ovgs;");

			// save search term
			stt.execute("insert into searchTerms (username, keyword) values ('"+ username +"', '"+ keyword +"')");

			//switch statement for different search by values
			switch(searchBy) {
			case "gameTitle":
				break;
			case "year":
				searchBy = "releaseDate";
				break;
			case "genre":
			case "publisher":	
			case "developer":
			default:
				break;
			}
			query = stt.executeQuery("SELECT * FROM games WHERE " + searchBy + " LIKE \"%" + keyword +"%\";");
								
								while(query.next()) {
									int id = (int) query.getInt("id");
									String gameTitle = query.getString("gameTitle");
									String releaseDate =  query.getString("releaseDate");
									String platform = query.getString("platform");
									String numOfPlayers = query.getString("numOfPlayers");
									String publisher = query.getString("publisher");
									String developer = query.getString("developer");
									String genre = query.getString("genre");
									String description = query.getString("description");

									gameInfo game =  new gameInfo(id, gameTitle, releaseDate, genre, platform, numOfPlayers,publisher, developer, description);
									output.add(game);
								}
								
								


		} catch (SQLException e) {
			System.out.println("Something went wrong with the connection: " + e );

		}
		//				System.out.println(output);
		request.setAttribute("result", output);

		ServletContext con = request.getServletContext();
		RequestDispatcher rd = con.getRequestDispatcher("/searchResult.jsp");
		rd.forward(request,response);

	}

}
