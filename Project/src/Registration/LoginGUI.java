package Registration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginGUI {

    private BufferedReader reader;
    private ManageLogin manageLogin;

    public LoginGUI(ManageLogin manageLogin) {
        setManageLogin(manageLogin);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String logInUser() {
        try {
            System.out.println("Enter your username");
            String username = reader.readLine();
            System.out.println("Enter your password");
            String password = reader.readLine();
            return manageLogin.logInUser(username, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public void setManageLogin(ManageLogin manageLogin) {
        this.manageLogin = manageLogin;
    }
}
