package Reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ManageReservations {

    private ReservationSystem reservationSystem;
    private CancellationGUI cancellationGUI;
    private ReservationGUI reservationGUI;
    private PurchaseTicketsGUI purchaseTicketsGUI;
    private Session currentSession;
    
    
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

    
    
    
    
    public CancellationGUI getCancellationGUI() {
		return cancellationGUI;
	}

	public void setCancellationGUI(CancellationGUI cancellationGUI) {
		this.cancellationGUI = cancellationGUI;
	}

	public ReservationGUI getReservationGUI() {
		return reservationGUI;
	}

	public void setReservationGUI(ReservationGUI reservationGUI) {
		this.reservationGUI = reservationGUI;
	}

	public PurchaseTicketsGUI getPurchaseTicketsGUI() {
		return purchaseTicketsGUI;
	}

	public void setPurchaseTicketsGUI(PurchaseTicketsGUI purchaseTicketsGUI) {
		this.purchaseTicketsGUI = purchaseTicketsGUI;
	}

	public ReservationSystem getReservationSystem() {
		return reservationSystem;
	}



	public Session getCurrentSession() {
		return currentSession;
	}






	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
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
