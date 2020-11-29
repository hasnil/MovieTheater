package Reservation;

import Payment.MakePaymentGUI;
import Payment.Voucher;

import java.util.ArrayList;

public class ReservationSystem {

    private MakePaymentGUI makePaymentGUI;
    private ArrayList<Voucher> vouchers;

    public ReservationSystem(MakePaymentGUI makePaymentGUI) {
        setMakePaymentGUI(makePaymentGUI);
    }

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }
}
