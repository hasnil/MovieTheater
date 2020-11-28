package Database;

import Registration.UserSystem;

import java.sql.*;

public class DBController implements DBCredentials {

    private Connection conn;
    private DBLoader dbLoader;
    private UserSystem userSystem;

    public DBController(UserSystem userSystem) {
        initializeConnection();
        dbLoader = new DBLoader(conn);
        setUserSystem(userSystem);
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
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }
}
