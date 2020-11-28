package Registration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginGUI {

    private BufferedReader reader;
    private ManageLogin manageLogin;

    public LoginGUI(ManageLogin manageLogin) {
        setManageLogin(manageLogin);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void setManageLogin(ManageLogin manageLogin) {
        this.manageLogin = manageLogin;
    }
}
