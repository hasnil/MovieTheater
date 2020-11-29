package Payment;

public class TransactionForm {

	private String cc;
	private int cvv;
	private double amount;
	private String result;
	private FinancialInstitute fi;
	private java.util.Date date;
	
    public TransactionForm(String cc, int cvv, double amount) {
    	this.amount = amount;
    	this.cvv = cvv;
    	this.cc = cc;
    	this.date = new java.util.Date();
    	this.result = "NOT_SUBMITTED";
    }
    
    public void setResult(String result) {
		this.result = result;
	}
    
    public String getResult() {
		return result;
	}
}
