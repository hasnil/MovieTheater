package Registration;

import Reservation.StoreCredit;

import java.util.ArrayList;

public class RegisteredUser extends User {

    private String userName;
    private String password;
    private String fullName;
    private String address;
    private String creditCard;
    private ArrayList<StoreCredit> storeCredits;

    public RegisteredUser(String userName, String email, String password, String fullName, String address, String creditCard) {
        super(email);
        setUserName(userName);
        setPassword(password);
        setFullName(fullName);
        setAddress(address);
        setCreditCard(creditCard);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
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
}
