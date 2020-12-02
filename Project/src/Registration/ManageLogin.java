package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageLogin {

    private UserSystem userSystem;
    private LoginGUI loginGUI;
    private RegisteredUser user;

    public ManageLogin(UserSystem userSystem) {
        setUserSystem(userSystem);
    }

    public RegisteredUser logInUser(String username, String password) {
        return userSystem.logInUser(username, password);
    }

    class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            login();
        }
    }

    private void login() {
        if (user == null) {
            String username = loginGUI.getUsernameTextField().getText();
            String password = loginGUI.getPasswordTextField().getText();
            user = logInUser(username, password);
            loginGUI.clearTextFields();
            if (user != null) {
                loginGUI.displayMessage("Successfully logged in");
                loginGUI.setLoginSuccessful(true);
                loginGUI.getLoginLabel().setText("Login Status: Logged In");
            }
            else {
                loginGUI.displayMessage("Wrong username and/or password");
            }
        }
        else {
            loginGUI.displayMessage("You are already logged in");
        }
    }

    public UserSystem getUserSystem() {
		return userSystem;
	}

	public RegisteredUser getUser() {
		return user;
	}

	public void setLoginGUI(LoginGUI login) {
        loginGUI = login;
        loginGUI.addButtonActionListener(loginGUI.getLoginButton(), new LoginButtonListener());
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }
}
