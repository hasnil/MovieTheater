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
    
    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }
	
//    public void setLoginGUI(LoginGUI login) {
//        loginGUI = login;
//        loginGUI.addButtonActionListener(loginGUI.getLoginButton(), new LoginButtonListener());
//    }

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
//    public void setLoginGUI(LoginGUI login) {
//        loginGUI = login;
//        loginGUI.addButtonActionListener(loginGUI.getLoginButton(), new LoginButtonListener());
//    }

    public RegisteredUser logInUser(String username, String password) {
        return userSystem.logInUser(username, password);
    }
    
    public void setLoginGUI(LoginGUI login) {
        loginGUI = login;

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
                        
                    }
                    else {
                        loginGUI.displayMessage("Wrong username and/or password");
                    }
                } else {
                    loginGUI.displayMessage("Logged out!");
                    logout();
                }
            }
        });
    }

    class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        	if (user == null) {
        		System.out.println("log in button pressed1");
        		login();
        	} else {
        		System.out.println("log in button pressed2");
        		logout();
        	}
        }
    }
    
    private void login() {
        if (user == null) {
            String username = loginGUI.getUsernameTextField().getText();
            String password = loginGUI.getPasswordTextField().getText();
            user = logInUser(username, password);
            loginGUI.clearTextFields();
            if (user != null) {
            	mainController.getGUIController().setUserStatus(true);
                loginGUI.displayMessage("Successfully logged in");
                loginGUI.setLoginSuccessful(true);
                loginGUI.getLoginLabel().setText("Login Status: Logged In");
            } else {
                loginGUI.displayMessage("Wrong username and/or password");
            }
        } else {
            loginGUI.displayMessage("You are already logged in");
        }
    }
    
    private void logout() {
    	user = null;
		mainController.getGUIController().setUserStatus(false);
		loginGUI.setLoginSuccessful(false);
    }

}
