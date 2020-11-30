package Payment;

public class Receipt {
	
	private int receiptId;
	private double amount;
	private String description;
	private java.util.Date date;
	
	public Receipt(int id, String description, double amount) {
		this.receiptId = id;
		this.description = description;
		this.amount = amount;
		this.date = new java.util.Date();
	}
	
	public int getReceiptId() {
		return receiptId;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return 	"==========\n" +
				"Receipt Id: " + getReceiptId() + "\n" + 
				"Date: " + getDate().toString() + "\n" +
				"Description: " + getDescription() + "\n" +
				"Amount: $" + getAmount();
	}
	
}
