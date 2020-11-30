package Reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        cancellationGUI.addCancellationButtonListener(new CancelReservationButton());
    }

    public String cancelReservation(int reservationId) {
        return reservationSystem.cancelReservation(reservationId);
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

    class CancelReservationButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int reservationId = 0;
            try {
                reservationId = Integer.parseInt(cancellationGUI.getReservationId().getText());
            } catch (NumberFormatException e) {
                cancellationGUI.displayMessage("Enter a valid reservation ID");
            }
            if (reservationId != 0) {
                String message = cancelReservation(reservationId);
                cancellationGUI.displayMessage(message);
            }
        }
    }
}
