package Reservation;

import Payment.MakePaymentGUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationSystem {

    private MakePaymentGUI makePaymentGUI;
    private ArrayList<Voucher> vouchers;
    private ArrayList<Movie> movies;

    public ReservationSystem(MakePaymentGUI makePaymentGUI) {
        setMakePaymentGUI(makePaymentGUI);
        vouchers = new ArrayList<>();
        movies = new ArrayList<>();
    }

    public void loadMovies(ResultSet rs) {
        try {
            while (rs.next()) {
                addMovie(new Movie(
                        rs.getString("movieName"),
                        rs.getDate("releaseDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadVouchers(ResultSet rs) {
        try {
            while (rs.next()) {
                addVoucher(new Voucher(
                        rs.getInt("vouchNum"),
                        rs.getFloat("amount"),
                        rs.getDate("expiryDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadShowTimes(ResultSet rs) {
        try {
            while (rs.next()) {
                ShowTime showTime = new ShowTime(rs.getString("showTime"),
                                                 rs.getString("movieName"));
                for (Movie movie : movies)
                    if (movie.getMovieName().equals(showTime.getMovieName()))
                        movie.addShowTime(showTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayMovies() {
        for (Movie movie : movies)
            System.out.println(movie);
    }

    public void displayVouchers() {
        for (Voucher voucher : vouchers)
            System.out.println(voucher);
    }

    private void addMovie(Movie movie) {
        movies.add(movie);
    }

    private void addVoucher(Voucher voucher) {
        vouchers.add(voucher);
    }

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }
}
