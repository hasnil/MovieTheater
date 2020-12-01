package Reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageReservations {

    private ReservationSystem reservationSystem;
    private CancellationGUI cancellationGUI;
    private ReservationGUI reservationGUI; // ??
    private PurchaseTicketsGUI purchaseTicketsGUI; // ??

    public ManageReservations(ReservationSystem reservationSystem, CancellationGUI cancellationGUI, 
    		ReservationGUI reservationGUI, PurchaseTicketsGUI purchaseTicketsGUI) {
        setReservationSystem(reservationSystem);
        this.cancellationGUI = cancellationGUI;
        this.reservationGUI = reservationGUI;
        this.purchaseTicketsGUI = purchaseTicketsGUI;
        cancellationGUI.addButtonActionListener(cancellationGUI.getConfirmCancellationButton(), new CancelReservationButtonListener());
    }

    class CancelReservationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            cancel();
        }
    }

    private void cancel() {
        int reservationId = -1;
        try {
            reservationId = Integer.parseInt(cancellationGUI.getReservationIdTextField().getText());
        } catch (NumberFormatException e) {
            cancellationGUI.displayMessage("Enter a valid reservation ID");
        }
        if (reservationId != -1) {
            String message = cancelReservation(reservationId);
            cancellationGUI.displayMessage(message);
        }
    }

    private String cancelReservation(int reservationId) {
        return reservationSystem.cancelReservation(reservationId);
    }

    public void setReservationSystem(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }
}
