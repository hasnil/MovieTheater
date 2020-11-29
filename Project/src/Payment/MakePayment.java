package Payment;

import java.util.Date;

public class MakePayment {

    private PaymentSystem paymentSystem;
    private TransactionForm transactionForm;

    public MakePayment(PaymentSystem paymentSystem) {
        setPaymentSystem(paymentSystem);
    }

    public boolean payWithCreditCard(String cc, int cvv, int amount) {
        return true;
    }

    public boolean payWithVoucher(int vouchNum, int amount) {
        for (Voucher voucher : paymentSystem.getVouchers())
            if (voucher.getNumber() == vouchNum)
                if (voucher.getExpiryDate().compareTo(new Date()) > 0) {
                    if (voucher.getAmount() >= amount)
                        return true;
                } else
                    return false;
        return false;
    }


    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
}
