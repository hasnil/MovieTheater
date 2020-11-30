package Database;

import Registration.UserSystem;
import Reservation.ReservationSystem;
import Theater.TheaterSystem;

import java.sql.*;

public class DBController implements DBCredentials {

    private Connection conn;
    private DBLoader dbLoader;
    private UserSystem userSystem;
    private ReservationSystem reservationSystem;
    private TheaterSystem theaterSystem;

    public DBController(UserSystem userSystem, ReservationSystem reservationSystem, TheaterSystem theaterSystem) {
        initializeConnection();
        dbLoader = new DBLoader(conn);
        setUserSystem(userSystem);
        setReservationSystem(reservationSystem);
        setTheaterSystem(theaterSystem);
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

    public void setTheaterSystem(TheaterSystem theaterSystem) {
        this.theaterSystem = theaterSystem;
    }
}
