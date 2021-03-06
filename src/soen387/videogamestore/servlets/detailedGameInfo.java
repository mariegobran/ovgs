package soen387.videogamestore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soen387.gameInfo;

/**
 * Servlet implementation class detailedGameInfo
 */
@WebServlet("/detailedGameInfo")
public class detailedGameInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailedGameInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String gameId = request.getParameter("id");

		gameInfo game = null;
		
		//attributes to establish mysql connection using xampp
		String url  ="jdbc:mysql://localhost:3306/ovgs";
		String user = "root";
		// redirect link
		String redirect = "";
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


		
			ResultSet query = stt.executeQuery("SELECT * FROM games WHERE id = " + gameId +";");
								
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

									game =  new gameInfo(id, gameTitle, releaseDate, genre, platform, numOfPlayers,publisher, developer, description);
									
								}


		} catch (SQLException e) {
			System.out.println("Something went wrong with the connection: " + e );

		}
		//				System.out.println(output);
		request.setAttribute("gameDetails", game);

		ServletContext con=request.getServletContext();
		RequestDispatcher rd=con.getRequestDispatcher("/detailedGameInfo.jsp");
		rd.forward(request,response);
	}

	

}
