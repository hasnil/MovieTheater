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
                }
            }
        });
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }
}
