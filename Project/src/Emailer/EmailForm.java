package Emailer;

public class EmailForm {
	
	private String to;
	private String body;
	private String subject;
	private String result;
	
	public EmailForm() {
		this.result = "NOT_SENT";
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}
	
	
	public String getBody() {
		return body;
	}
	
	public String getTo() {
		return to;
	}
	
	public String getSubject() {
		return subject;
	}
	
    public boolean submit() {
    	
    	EmailServer emailer = new EmailServer();
    	boolean isSuccess =	emailer.send(this);
    	
    	if (isSuccess) {
    		setResult("SENT");
    		System.out.println("Email sent!");
    	} else {
    		setResult("FAILED");
    		System.out.println("Email failed!");
    	}

    	return isSuccess;
    }
	

}
