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

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    
    public void generateTicket(String movieName, int seat, LocalDateTime showTime, int room, double price) {
        Ticket ticket = new Ticket(movieName, seat, showTime, room, price, getReservationId());
        tickets.add(ticket);
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
    public String getUserName() { return userName; }

    public LocalDateTime getShowTime() {
        return tickets.get(0).getShowTime();
    }
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}
