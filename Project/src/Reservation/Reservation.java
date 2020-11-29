package Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {

    private int reservationId;
    private String userName;
    private ArrayList<Ticket> tickets;

    public Reservation(int reservationId, String userName) {
        setReservationId(reservationId);
        setUserName(userName);
        tickets = new ArrayList<>();
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
