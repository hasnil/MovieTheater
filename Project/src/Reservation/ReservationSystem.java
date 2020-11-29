package Reservation;

import Payment.MakePaymentGUI;

public class ReservationSystem {

    private MakePaymentGUI makePaymentGUI;

    public ReservationSystem(MakePaymentGUI makePaymentGUI) {
        setMakePaymentGUI(makePaymentGUI);
    }

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }
}
