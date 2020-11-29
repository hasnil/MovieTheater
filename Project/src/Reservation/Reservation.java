package Reservation;

import java.time.LocalDateTime;

public class Reservation {

    private int reservationId;
    private String userName;

    public Reservation(int reservationId, String userName) {
        setReservationId(reservationId);
        setUserName(userName);
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getReservationId() {
        return reservationId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
