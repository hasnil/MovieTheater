package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageRegistration {

    private UserSystem userSystem;
    private RegistrationGUI registrationGUI;

    public ManageRegistration(RegistrationGUI registrationGUI, UserSystem userSystem) {
        setRegistrationGUI(registrationGUI);
        setUserSystem(userSystem);
        registrationGUI.addButtonActionListener(registrationGUI.getRegisterButton(), new RegistrationButtonListener());
    }

    public String checkCredentialsAvailability(String email, String username) {
        return userSystem.registerUser(email, username);
    }

    class RegistrationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            register();
        }
    }

    private void register() {
        String email = registrationGUI.getEmailTextField().getText();
        String username = registrationGUI.getUsernameTextField().getText();
        String response = checkCredentialsAvailability(email, username);
        if (!response.equals("Okay"))
            registrationGUI.displayMessage(response);
        else {
            registrationGUI.displayMessage("That username and email are available, please proceed to make a payment");
            registrationGUI.getMakePaymentButton().setEnabled(true);
        }
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }

    public void setRegistrationGUI(RegistrationGUI registrationGUI) {
        this.registrationGUI = registrationGUI;
    }
}
