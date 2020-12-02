package Payment;

import Reservation.Voucher;

import java.util.ArrayList;

public class PaymentSystem {

	private int receiptId; //last receipt id recorded
	private int paymentId; //last payment id recorded
	private ArrayList<Receipt> receipts;
    private ArrayList<Payment> payments;
	private ArrayList<Voucher> vouchers;
    

    public PaymentSystem() {
    	this.receiptId = 1; //start the receipt ids from 1
    	this.paymentId = 1; //start the payment ids from 1
    	receipts = new ArrayList<>();
    	payments = new ArrayList<>();
        vouchers = new ArrayList<>();
    }

    public ArrayList<Voucher> getVouchers() {
        return vouchers;
    }
    
    public ArrayList<Receipt> getReceipts() {
		return receipts;
	}
    
    public ArrayList<Payment> getPayments() {
		return payments;
	}
    
    public int getReceiptId() {
		return receiptId;
	}
    
    public Receipt getLastReceipt() {
    	return getReceipts().get(getReceiptId() - 2);
    }
    
    public void incrementReceiptId() {
		this.receiptId++;
	}
    
    public int getPaymentId() {
		return paymentId;
	}
    
    public Payment getLastPayment() {
    	return getPayments().get(getPaymentId() - 2);
    }
    
    public void incrementPaymentId() {
		this.paymentId++;
	}
    
    public void generateReceipt(String desc, Double amount) {
    	Receipt receipt = new Receipt(getReceiptId(), desc, amount);
    	getReceipts().add(receipt);
    	incrementReceiptId();
	}
    
    public void recordPayment(Double amount, boolean validity) {
    	Payment payment = new Payment(getPaymentId(), amount);
    	payment.updatePayment(validity);
    	getPayments().add(payment);
    	incrementPaymentId();
	}
}
