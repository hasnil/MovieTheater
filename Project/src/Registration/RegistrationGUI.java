package Registration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegistrationGUI {

    private BufferedReader reader;
    private ManageRegistration manageRegistration;

    public RegistrationGUI(ManageRegistration manageRegistration) {
        setManageRegistration(manageRegistration);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String registerUser() {
        try {
            System.out.println("Enter your email");
            String email = reader.readLine();
            System.out.println("Enter your username");
            String userName = reader.readLine();
            System.out.println("Enter your password");
            String password = reader.readLine();
            return manageRegistration.registerUser(email, userName, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public void setManageRegistration(ManageRegistration manageRegistration) {
        this.manageRegistration = manageRegistration;
    }
}
