package Payment;

import java.util.ArrayList;

public class PaymentSystem {

    private ArrayList<Voucher> vouchers;

    public PaymentSystem() {
        vouchers = new ArrayList<>();
    }

    public ArrayList<Voucher> getVouchers() {
        return vouchers;
    }
}
