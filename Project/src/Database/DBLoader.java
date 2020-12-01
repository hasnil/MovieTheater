package Database;

import java.sql.*;

public class DBLoader {

    private Connection conn;
    private Statement stmt;

    public DBLoader(Connection conn) {
        setConn(conn);
    }

    public ResultSet loadUsers() {
        try {
            String query = "SELECT * FROM users";
            stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet loadVouchers() {
        try {
            String query = "SELECT * FROM vouchers";
            stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet loadReservations() {
        try {
            String query = "SELECT * FROM reservations";
            stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet loadTickets() {
        try {
            String query = "SELECT * FROM tickets";
            stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
