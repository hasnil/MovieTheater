package Payment;

import Reservation.Voucher;

import java.util.Date;

import Emailer.EmailForm;

public class MakePayment {

	private String description;
    private PaymentSystem paymentSystem;

    public MakePayment(PaymentSystem paymentSystem) {
    	setDescription("");
        setPaymentSystem(paymentSystem);
    }
    

    public boolean payWithCreditCard(String cc, String cvv, double amount) {
        TransactionForm tf = new TransactionForm(cc, cvv, amount);
    	
    	boolean result = tf.submit();
    	System.out.println(tf); //print summary of the payment
    	
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

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public String getDescription() {
    	return this.description;
    }
}
