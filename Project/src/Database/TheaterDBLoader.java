package Database;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Theater.Movie;
import Theater.ShowTime;

public class TheaterDBLoader implements DBCredentials{
	
	private Connection conn;
    private Statement stmt;
    
    public TheaterDBLoader() {
        initializeConnection();
    }

    
    public void initializeConnection() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public ResultSet loadMovies() {
		try {
			String query = "SELECT * FROM movies";
			stmt = conn.createStatement();
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet loadShowTimes() {
		try {
			String query = "SELECT * FROM showtimes";
			stmt = conn.createStatement();
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
    
    public ArrayList<ShowTime> loadShowTimesFromDatabase(){
    	ResultSet rs = loadShowTimes();
    	ArrayList<ShowTime> showtimes = new ArrayList<ShowTime>();
    	try {
			while(rs.next()) {
				ShowTime showtime = new ShowTime(modifyDate(rs.getDate("showTimes")));
				showtimes.add(showtime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return showtimes;
    }
    
 
    public ArrayList<Movie> loadMoviesFromDatabase(){

    	
    	ArrayList<Movie> returnArrayList = new ArrayList<Movie>();
    			
    	ResultSet rs = loadMovies();
    	try {
			while(rs.next()) {
				Movie singleMovie = new Movie(rs.getString("movieName"), new ArrayList<ShowTime> (), modifyDate(rs.getDate("releaseDate")));
				returnArrayList.add(singleMovie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	ResultSet rs2 = loadShowTimes();
    	try {
			while(rs2.next()) {
				for(Movie m: returnArrayList) {
					if(m.getMovieName().equals(rs2.getString("movieName"))) {
						m.getShowTimes().add(new ShowTime(modifyDate(rs2.getDate("showTimes"))));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	return returnArrayList;
    }
    
    
    
    public ArrayList<String> loadPostersFromDatabase(){
    	ResultSet rs = loadMovies();
    	ArrayList<String> posters = new ArrayList<String>();
    	try {
			while(rs.next()) {
				posters.add(rs.getString("moviePosterUrl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return posters;
    }
    
    public LocalDateTime modifyDate(Date originalDate) {
        return new java.sql.Timestamp(originalDate.getTime()).toLocalDateTime();
    }
}

