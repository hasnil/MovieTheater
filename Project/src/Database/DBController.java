package Database;

import Registration.UserSystem;
import Theater.Movie;
import Theater.ShowTime;
import Reservation.ReservationSystem;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;

public class DBController implements DBCredentials {

    private Connection conn;
    private UserDBLoader userDbLoader;
    private UserSystem userSystem;
    private ReservationSystem reservationSystem;

    public DBController(UserSystem userSystem, ReservationSystem reservationSystem) {
        initializeConnection();
        userDbLoader = new UserDBLoader(conn);
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
        ResultSet rs = userDbLoader.loadUsers();
        userSystem.loadUsers(rs);
        rs = userDbLoader.loadVouchers();
        reservationSystem.loadVouchers(rs);
        rs = userDbLoader.loadReservations();
        reservationSystem.loadReservations(rs);
        rs = userDbLoader.loadTickets();
        reservationSystem.loadTickets(rs);
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }

    public void setReservationSystem(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }


}
