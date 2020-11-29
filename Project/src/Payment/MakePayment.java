package Payment;

public class MakePayment {

    private PaymentSystem paymentSystem;
    private TransactionForm transactionForm;

    public MakePayment(PaymentSystem paymentSystem) {
        setPaymentSystem(paymentSystem);
    }

    public boolean payWithCreditCard(String cc, int cvv, int amount) {
        return true;
    }

    public void payWithVoucher(int voucher, int amount) {

    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
}
