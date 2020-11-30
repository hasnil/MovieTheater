package Database;

import Registration.UserSystem;
import Theater.Movie;
import Theater.ShowTime;
import Reservation.ReservationSystem;
import Theater.TheaterSystem;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;

public class DBController implements DBCredentials {

    private Connection conn;
    private DBLoader dbLoader;
    private UserSystem userSystem;
    private ReservationSystem reservationSystem;

    public DBController(UserSystem userSystem, ReservationSystem reservationSystem) {
        initializeConnection();
        dbLoader = new DBLoader(conn);
        setUserSystem(userSystem);
        setReservationSystem(reservationSystem);
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

    public void loadFromDB() {
        ResultSet rs = dbLoader.loadUsers();
        userSystem.loadUsers(rs);
        rs = dbLoader.loadVouchers();
        reservationSystem.loadVouchers(rs);
        rs = dbLoader.loadMovies();
        reservationSystem.loadMovies(rs);
//        theaterSystem.loadMovies(rs);
        rs = dbLoader.loadShowTimes();
        reservationSystem.loadShowTimes(rs);
        rs = dbLoader.loadReservations();
        reservationSystem.loadReservations(rs);
        rs = dbLoader.loadTickets();
        reservationSystem.loadTickets(rs);
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }

    public void setReservationSystem(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }

    
    public ArrayList<ShowTime> loadShowTimesFromDatabase(){
    	ResultSet rs = dbLoader.loadShowTimes();
    	ArrayList<ShowTime> showtimes = new ArrayList<ShowTime>();
    	try {
			while(rs.next()) {
				ShowTime showtime = new ShowTime(modifyDate(rs.getDate("ShowTimes")));
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
						m.getShowTimes().add(new ShowTime(modifyDate(rs2.getDate("ShowTimes"))));
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
    
    
    //public LocalDateTime modifyDate(Date originalDate) {
    //    return originalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    //}
    
    public LocalDateTime modifyDate(Date dateToConvert) {
        return new java.sql.Timestamp(
          dateToConvert.getTime()).toLocalDateTime();
    }
}
