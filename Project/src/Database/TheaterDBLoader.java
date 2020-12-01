package Database;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Reservation.Session;
import Theater.Movie;
import Theater.Room;
import Theater.ShowTime;

public class TheaterDBLoader implements DBCredentials{
	
	private Connection conn;
    private DBLoader dbLoader;
    
    public TheaterDBLoader() {
        initializeConnection();
        dbLoader = new DBLoader(conn);
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
    
    
    public ArrayList<ShowTime> loadShowTimesFromDatabase(){
    	ResultSet rs = dbLoader.loadShowTimes();
    	ArrayList<ShowTime> showtimes = new ArrayList<ShowTime>();
    	
    	try {
			while(rs.next()) {
				ShowTime showtime = new ShowTime(modifyDate(rs.getDate("showTimes")));
				showtime.setRoomNumber(rs.getInt("roomNumber"));
				showtimes.add(showtime);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return showtimes;
    }
    
 
    public ArrayList<Movie> loadMoviesFromDatabase(){

    	
    	ArrayList<Movie> returnArrayList = new ArrayList<Movie>();
    			
    	ResultSet rs = dbLoader.loadMovies();
    	try {
			while(rs.next()) {
				Movie singleMovie = new Movie(rs.getString("movieName"), new ArrayList<ShowTime> (), modifyDate(rs.getDate("releaseDate")));
				returnArrayList.add(singleMovie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	ResultSet rs2 = dbLoader.loadShowTimes();
    	try {
			while(rs2.next()) {
				for(Movie m: returnArrayList) {
					if(m.getMovieName().equals(rs2.getString("movieName"))) {
						
						ShowTime showtime = new ShowTime(modifyDate(rs2.getDate("showTimes")));
						showtime.setRoomNumber(rs2.getInt("roomNumber"));
						
						m.getShowTimes().add(showtime);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	return returnArrayList;
    }
    
    
    
    public ArrayList<String> loadPostersFromDatabase(){
    	ResultSet rs = dbLoader.loadMovies();
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
    
    
    public ArrayList<Session> loadSessions(){
    	ResultSet rs2 = dbLoader.loadShowTimes();
    	ArrayList<Session> sessions = new ArrayList<Session>();
    	ArrayList<Movie> movies = loadMoviesFromDatabase();
    	
    	
    	for(Movie m: movies) {
    		
    		for(ShowTime st: m.getShowTimes()) {
    			
    			Session session = new Session(m, st, (new Room( st.getRoomNumber(), 20)));
    			sessions.add(session);
    		}
    	}
    	
    	
    	return sessions;
    }
    
    
    
    
    
    
    
}

