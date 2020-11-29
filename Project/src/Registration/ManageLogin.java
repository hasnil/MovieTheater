package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageLogin {

    private UserSystem userSystem;
    private LoginGUI loginGUI;

    public ManageLogin(UserSystem userSystem) {
        setUserSystem(userSystem);
    }

    public RegisteredUser logInUser(String username, String password) {
        return userSystem.logInUser(username, password);
    }

    public void setLoginGUI(LoginGUI login) {
        loginGUI = login;

        loginGUI.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                //MUST CHECK IF LOGIN WORKED
                loginGUI.setLoginSuccessful(true);
                loginGUI.getLoginLabel().setText("Login Status: Logged In");
            }
        });
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }
}
