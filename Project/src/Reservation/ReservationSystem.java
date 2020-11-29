package Reservation;

import Payment.MakePaymentGUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationSystem {

    private MakePaymentGUI makePaymentGUI;
    private ArrayList<Voucher> vouchers;

    public ReservationSystem(MakePaymentGUI makePaymentGUI) {
        setMakePaymentGUI(makePaymentGUI);
        vouchers = new ArrayList<>();
    }

    public void loadVouchers(ResultSet rs) {
        try {
            while (rs.next()) {
                addVoucher(new Voucher(
                        rs.getInt("vouchNum"),
                        rs.getFloat("amount"),
                        rs.getDate("expiryDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayVouchers() {
        for (Voucher voucher : vouchers)
            System.out.println(voucher);
    }

    private void addVoucher(Voucher voucher) {
        vouchers.add(voucher);
    }

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }
}
