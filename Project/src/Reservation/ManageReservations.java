package Reservation;

public class ManageReservations {

    private ReservationSystem reservationSystem;

    public ManageReservations(ReservationSystem reservationSystem) {
        setReservationSystem(reservationSystem);
    }

    public void displayVouchers() {
        reservationSystem.displayVouchers();
    }

    public void setReservationSystem(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }
}
