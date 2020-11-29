package Registration;

import java.util.ArrayList;

public class RegisteredUser extends User {

    private String userName;
    private String password;
    private ArrayList<StoreCredit> storeCredits;

    public RegisteredUser(String userName, String email, String password) {
        super(email);
        setUserName(userName);
        setPassword(password);
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

    @Override
    public String toString() {
        return "User name: " + getUserName() + ", email: " + getEmail() + ", password: " + getPassword();
    }
}
