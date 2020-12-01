package Reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageReservations {

    private ReservationSystem reservationSystem;
    private CancellationGUI cancellationGUI;
    private ReservationGUI reservationGUI; // ??
    private PurchaseTicketsGUI purchaseTicketsGUI; // ??
    private Session currentSession;

    public ManageReservations(ReservationSystem reservationSystem, CancellationGUI cancellationGUI,
                              ReservationGUI reservationGUI, PurchaseTicketsGUI purchaseTicketsGUI) {
        setReservationSystem(reservationSystem);
        this.cancellationGUI = cancellationGUI;
        this.reservationGUI = reservationGUI;
        this.purchaseTicketsGUI = purchaseTicketsGUI;
        cancellationGUI.addButtonActionListener(cancellationGUI.getConfirmCancellationButton(), new CancelReservationButtonListener());
        purchaseTicketsGUI.addButtonActionListener(purchaseTicketsGUI.getApplyVoucherButton(), new ApplyVoucherButtonListener());
    }

    class CancelReservationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            cancel();
        }
    }

    class ApplyVoucherButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) { applyVoucher(); }
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

    private void applyVoucher() {
        int voucherId = -1;
        try {
            voucherId = Integer.parseInt(purchaseTicketsGUI.getEnterVoucherTextField().getText());
        } catch (NumberFormatException e) {
            cancellationGUI.displayMessage("Enter a valid voucher ID");
        }
        if (voucherId != -1) {
            double amount = Double.parseDouble(purchaseTicketsGUI.getTotalPriceLabel().getText().substring(14));
            double remainder = reservationSystem.applyVoucher(voucherId, amount);
            if (remainder < 0.0) {
                purchaseTicketsGUI.getTotalPriceLabel().setText("Total Price: $0.00");
                purchaseTicketsGUI.setAmount(0);
            }
            else {
                purchaseTicketsGUI.getTotalPriceLabel().setText("Total Price: $" + remainder + "0");
                purchaseTicketsGUI.setAmount(remainder);
            }
        }
    }

    private String cancelReservation(int reservationId) {
        return reservationSystem.cancelReservation(reservationId);
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


}
