package Reservation;

import java.time.LocalDateTime;

public class Reservation {

    private int reservationId;
    private String movieName;
    private String userName;
    private LocalDateTime showTime;

    public Reservation(int reservationId, String movieName, String userName, String showTime) {
        setReservationId(reservationId);
        setMovieName(movieName);
        setUserName(userName);
        setShowTime(showTime);
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setShowTime(String showTime) {
        this.showTime = LocalDateTime.parse(showTime);
    }

    public int getReservationId() {
        return reservationId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", movieName='" + movieName + '\'' +
                ", userName='" + userName + '\'' +
                ", showTime='" + showTime + '\'' +
                '}';
    }
}
