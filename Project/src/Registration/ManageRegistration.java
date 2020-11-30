package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageRegistration {

    private UserSystem userSystem;
    private RegistrationGUI registrationGUI;

    public ManageRegistration(UserSystem userSystem) {
        setUserSystem(userSystem);
    }

    public String checkCredentialsAvailability(String email, String username) {
        return userSystem.registerUser(email, username);
    }

//    public boolean makePayment(String email, String username, String password) {
//        return userSystem.makePayment(email, username, password);
//    }

    public void displayUsers() {
        userSystem.displayUsers();
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }


}
