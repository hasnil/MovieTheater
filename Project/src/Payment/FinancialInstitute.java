package Payment;

import java.util.ArrayList;

public class FinancialInstitute {
	
	private String lastResponse;
	private TransactionForm transForm;
	private double maxLimit;
	private double minLimit;
	
	public FinancialInstitute() {
		this.maxLimit = 1000.00; //dummy limit to force an upper transaction limit
		this.minLimit = 0.01; //dummy limit to force an lower transaction limit
	}
	
	public void processTransaction(TransactionForm transForm) {
		this.transForm = transForm;
		
		transForm.setDate(new java.util.Date());
		
		if (transForm.getCc().length() != 16){
			lastResponse = "CARD_NUMBER_NOT_16_DIGIT_LONG";
			this.transForm.setResult(lastResponse);
			return;
		}
		
		int size = 8;
        ArrayList<String> tokens = new ArrayList<String>();
		 
        for (int start = 0; start < transForm.getCc().length(); start += size) {
            tokens.add(transForm.getCc().substring(start, Math.min(transForm.getCc().length(), start + size)));
        }
        
		if (!isNumeric(tokens.get(0)) || !isNumeric(tokens.get(1))) {
			lastResponse = "CARD_NUMBER_CONTAINS_INVALID_CHARACTERS";
			this.transForm.setResult(lastResponse);
			return;
		}
	        
		if (transForm.getCvv().length() != 3) {
			lastResponse = "CVV_NUMBER_NOT_3_DIGIT_LONG";
			this.transForm.setResult(lastResponse);
			return;
		}
		
		if (!isNumeric(transForm.getCvv())) {
			lastResponse = "CVV_NUMBER_CONTAINS_INVALID_CHARACTERS";
			this.transForm.setResult(lastResponse);
			return;
		}
		
		if (transForm.getAmount() < getMinLimit()) {
			lastResponse = "AMOUNT_TOO_SMALL";
			this.transForm.setResult(lastResponse);
			return;
		}
		
		if (transForm.getAmount() > getMaxLimit()) {
			lastResponse = "AMOUNT_LARGER_THAN_MAX_LIMIT";
			this.transForm.setResult(lastResponse);
			return;
		}
		
		this.transForm.setResult("PROCESSED");
		
	}

	/**
	 * Checks whether string has only composed of numbers
	 *
	 * @param strNum string to be checked
	 * @return true if all characters are numerical.
	 */
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	    	Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	public double getMaxLimit() {
		return maxLimit;
	}
	
	public double getMinLimit() {
		return minLimit;
	}

}


