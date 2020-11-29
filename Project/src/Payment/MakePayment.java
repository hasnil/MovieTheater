package Payment;

import Reservation.Voucher;

import java.util.Date;

public class MakePayment {

    private PaymentSystem paymentSystem;
    private TransactionForm transactionForm;

    public MakePayment(PaymentSystem paymentSystem) {
        setPaymentSystem(paymentSystem);
    }

    public boolean payWithCreditCard(String cc, String cvv, double amount) {
        TransactionForm tf = new TransactionForm(cc, cvv, amount);
    	
    	boolean result = tf.submit();
    	System.out.println(tf); //print summary of the payment
    	
    	return result;
    }

    public double payWithVoucher(int vouchNum, double amount) {
        for (Voucher voucher : paymentSystem.getVouchers())
            if (voucher.getVouchNum() == vouchNum)
                if (voucher.getExpiryDate().compareTo(new Date()) > 0) {
                    if (voucher.getAmount() >= amount)
                        return 0;
                    else
                        return amount - voucher.getAmount();
                } else
                    return -1;
        return -1;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
}
