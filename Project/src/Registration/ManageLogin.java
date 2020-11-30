package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainController.MainController;

public class ManageLogin {

    private UserSystem userSystem;
    private LoginGUI loginGUI;
    private RegisteredUser user;
	private MainController mainController;

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

        loginGUI.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (user == null) {
                    String username = loginGUI.getUsernameTextField().getText();
                    String password = loginGUI.getPasswordTextField().getText();
                    user = logInUser(username, password);
                    if (user != null) {
                        loginGUI.displayMessage("Successfully logged in");
                        loginGUI.setLoginSuccessful(true);
                        loginGUI.getLoginLabel().setText("Login Status: Logged In");
                        mainController.getManageTheater().setUserStatus(true);
                        mainController.getGUIController().setUserStatus(true);
                    }
                    else {
                        loginGUI.displayMessage("Wrong username and/or password");
                    }
                }
            }
        }
        else {
            loginGUI.displayMessage("You are already logged in");
        }
    }

    public void setLoginGUI(LoginGUI login) {
        loginGUI = login;
        loginGUI.addButtonActionListener(loginGUI.getLoginButton(), new LoginButtonListener());
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
}
