package soen387;

import java.util.Date;

public class gameInfo {

	private int id;
	private String gameTitle;
	private String releaseDate;
	private String genre;
	private String platform;
	private String numOfPlayers;
	private String publisher;
	private String developer;
	private String description;
	
	public gameInfo(int id, String gameTitle, String releaseDate, String genre, String platform,String numOfPlayers, String publisher, String developer, String description) {
		this.setId(id);
		this.setReleaseDate(releaseDate);
		this.setGameTitle(gameTitle);
		this.setGenre(genre);
		this.setPlatform(platform);
		this.setNumOfPlayers(numOfPlayers);
		this.setPublisher(publisher);
		this.setDeveloper(developer);
		this.setDescription(description);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(String numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	
}
