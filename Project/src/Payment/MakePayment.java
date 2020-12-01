package Payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import Reservation.Voucher;
import Registration.ManageAnnualFee;
import Emailer.EmailForm;

public class MakePayment {

    private PaymentSystem paymentSystem;
    private MakePaymentGUI makePaymentGUI;
	private String description;

    public MakePayment(MakePaymentGUI makePaymentGUI, PaymentSystem paymentSystem) {
    	setDescription("");
    	setMakePaymentGUI(makePaymentGUI);
        setPaymentSystem(paymentSystem);
        makePaymentGUI.addButtonActionListener(makePaymentGUI.getSubmitPaymentButton(), new SubmitPaymentButtonListener());
    }

    public boolean payWithCreditCard(String cc, String cvv, double amount) {
        TransactionForm tf = new TransactionForm(cc, cvv, amount);
    	boolean result = tf.submit();
//    	System.out.println(tf); //print summary of the payment
    	//send receipt as email when payment is processed
    	if (result) {
    		paymentSystem.generateReceipt(getDescription(), amount);
    		EmailForm email = new EmailForm();
    		email.setSubject("Your Receipt - SLAB CINEMAS");
    		email.setBody(paymentSystem.getLastReceipt().toString());
    		//email.setTo(to); //will send to self
    		email.submit();
    	}
    	// Record payment regardless of fail/success (since it has a field to store that info)
    	paymentSystem.recordPayment(amount, result);
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

    class SubmitPaymentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            pay();
        }
    }

    private void pay() {
        String cc = makePaymentGUI.getCardNumberField().getText();
        String cvv = makePaymentGUI.getSecurityCodeField().getText();
        boolean payment = payWithCreditCard(cc, cvv, makePaymentGUI.getAmount());
        if (payment) {
            makePaymentGUI.displayMessage("Payment successful");
        }
        else {
            makePaymentGUI.displayMessage("Payment unsuccessful");
        }
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) { this.makePaymentGUI = makePaymentGUI; }
    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return this.description; }
}
