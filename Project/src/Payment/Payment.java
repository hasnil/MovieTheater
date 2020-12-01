package Payment;

public class Payment {
	
	private int paymentId;
	private double amount;
	private java.util.Date date;
	private boolean paymentValid;
	
	public Payment(int id, double amount) {
		this.paymentId = id;
		this.amount = amount;
		this.date = new java.util.Date();
		this.paymentValid = false;
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void updatePayment(boolean result) {
		this.paymentValid = result;
	}
	
	@Override
	public String toString() {
		String result = "Payment failed";
		
		if (paymentValid)
			result = "Payment successful";
		
		return 	"==========\n" +
				"Payment Id: " + getPaymentId() + "\n" + 
				"Date: " + getDate().toString() + "\n" +
				"Amount: $" + getAmount() + "\n" +
				"Result: " + result;
	}
}
