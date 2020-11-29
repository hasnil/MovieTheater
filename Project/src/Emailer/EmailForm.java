package Emailer;

public class EmailForm {
	
	private String to;
	private String body;
	private String subject;
	
	public EmailForm() {
		
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
	
	public String getBody() {
		return body;
	}
	
	public String getTo() {
		return to;
	}
	
	public String getSubject() {
		return subject;
	}
	

}
