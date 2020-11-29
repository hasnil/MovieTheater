package Payment;

public class TransactionForm {

	private String cc;
	private String cvv;
	private double amount;
	private String result;
	private java.util.Date date;
	
    public TransactionForm(String cc, String cvv, double amount) {
    	this.amount = amount;
    	this.cvv = cvv;
    	this.cc = cc;
    	this.date = null;
    	this.result = "NOT_PROCESSED";
    }
    
    public boolean submit() {
    	FinancialInstitute fi = new FinancialInstitute();
    	fi.processTransaction(this);
    	
    	return result.contentEquals("PROCESSED");
    }
    
    public String getCc() {
		return cc;
	}
    
    public String getCvv() {
		return cvv;
	}
    
    public double getAmount() {
		return amount;
	}
    
    public void setResult(String result) {
		this.result = result;
	}
    
    public String getResult() {
		return result;
	}
    
    public void setDate(java.util.Date date) {
		this.date = date;
	}
    
    @Override
    public String toString() {
    	return "Payment result: " + result + ", amount: " + amount + ", date: " + date.toString();
    }
}
