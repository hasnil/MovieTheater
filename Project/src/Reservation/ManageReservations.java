package Reservation;

public class ManageReservations {

    private ReservationSystem reservationSystem;
    private CancellationGUI cancellationGUI;
    private ReservationGUI reservationGUI;
    private PurchaseTicketsGUI purchaseTicketsGUI;
    
    
    public ManageReservations(ReservationSystem reservationSystem, CancellationGUI cancellationGUI, 
    		ReservationGUI reservationGUI, PurchaseTicketsGUI purchaseTicketsGUI) {
        setReservationSystem(reservationSystem);
        this.cancellationGUI = cancellationGUI;
        this.reservationGUI = reservationGUI;
        this.purchaseTicketsGUI = purchaseTicketsGUI;
    }

    public void cancelReservation(int reservationId) {
        reservationSystem.cancelReservation(reservationId);
    }

    public void displayMovies() {
        reservationSystem.displayMovies();
    }

    public void displayVouchers() {
        reservationSystem.displayVouchers();
    }

    public void displayReservations() {
        reservationSystem.displayReservations();
    }

    public void setReservationSystem(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }
}
