package soen387;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class gamesDB {

	public static void main(String[] args) {
		// connecting with database

		//attributes to establish mysql connection using xampp
		String url  ="jdbc:mysql://localhost:3306/";
		String user = "root";

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

			// database creation
			stt.execute("CREATE DATABASE IF NOT EXISTS ovgs;");
			
			// login, games and users tables creation;
			stt.execute("CREATE TABLE IF NOT EXISTS login (userID INT AUTO_INCREMENT, username VARCHAR(50), password VARCHAR(50), PRIMARY KEY(userID));");
			stt.execute("CREATE TABLE IF NOT EXISTS games ( id INT, gameTitle VARCHAR(100), releaseDate VARCHAR(50), \r\n" + 
					"platform VARCHAR(100), numOfPlayers VARCHAR(25),\r\n" + 
					"publisher VARCHAR(100), developer VARCHAR(100), genre VARCHAR(50), \r\n" + 
					"description VARCHAR(10000), PRIMARY KEY(id));");
			stt.execute("CREATE TABLE users ( userID INT, firstName VARCHAR(50), lastName VARCHAR(50), email VARCHAR(200), address1 VARCHAR(200),\r\n" + 
					"address2 VARCHAR(200), city VARCHAR(50), state VARCHAR(50), zip VARCHAR(20), country VARCHAR(50), \r\n" + 
					"FOREIGN KEY(userID) REFERENCES login(userID), PRIMARY KEY(userID));");
			
			
			// select db
			stt.execute("USE ovgs;");


			// reading file
			BufferedReader br = null;
			FileReader fr = null;

			try {

				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader("gamesdb.txt");
				br = new BufferedReader(fr);

				String sCurrentLine;
				//game attributes
				String id= "";
				String title= "";
				String date= "";
				String platform= "";
				String nOfPlayers= "";
				String publisher= "";
				String developer= "";
				String description= "";
				String genre= "";

				while ((sCurrentLine = br.readLine()) != null) {

						if (sCurrentLine.contains("id:")) {
							id = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						}else if(sCurrentLine.contains("gameTitle:")){
							title = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						}else if(sCurrentLine.contains("ReleaseDate")) {
							date = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						}else if(sCurrentLine.contains("Platform")) {
							platform = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						}else if(sCurrentLine.contains("Number of players")) {
							nOfPlayers = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						}else if(sCurrentLine.contains("Publisher")) {
							publisher = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						}else if(sCurrentLine.contains("Developer")) {
							developer = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						}else if(sCurrentLine.contains("Overview")) {
							description = sCurrentLine.substring(sCurrentLine.indexOf(":")+1, sCurrentLine.length());
							
						}else if(sCurrentLine.contains("Genre")) {
							genre = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						}else if(sCurrentLine.contains("*****")) {

							stt.execute("INSERT INTO games (id, gameTitle, releaseDate, platform, numOfPlayers"
									+ ", publisher, developer, genre, description) VALUES (" + id  
									+ ", \"" + title
									+ "\", \"" + date
									+ "\", \"" + platform
									+ "\", \"" + nOfPlayers
									+ "\", \"" + publisher
									+ "\", \"" + developer
									+ "\", \"" + genre
									+ "\", \"" + description
									+ "\");");

					}
				}

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}

		} catch (SQLException e) {
			System.out.println("Something went wrong with the connection: " + e );

		}



	}

}
