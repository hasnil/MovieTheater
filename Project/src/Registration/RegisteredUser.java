package Registration;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RegisteredUser extends User {

    private String userName;
    private String password;
    private String fullName;
    private String address;
    private String creditCard;
    private LocalDateTime regDate;
    private LocalDateTime expDate;
  

	public RegisteredUser(String userName, String email, String password, String fullName, String address, String creditCard) {
        super(email);
        setUserName(userName);
        setPassword(password);
        setFullName(fullName);
        setAddress(address);
        setCreditCard(creditCard);
        setRegistrationDate();
    }

    public LocalDateTime getExpDate() {
		return expDate;
	}

	public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    
    public void setRegistrationDate() {
        	this.regDate = LocalDateTime.now();
        	this.expDate = LocalDateTime.now().plusYears(1);
        }
    
     public void renewRegistrationDate() {
        this.expDate = expDate.plusYears(1);
     }
        
     public boolean isExpired() {
        return LocalDateTime.now().isBefore(expDate);
     }
}
