package Registration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegistrationGUI {

    private BufferedReader reader;
    private ManageRegistration manageRegistration;

    public RegistrationGUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        manageRegistration = new ManageRegistration(new UserSystem());
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

    public static void main(String[] args) {
        RegistrationGUI registrationGUI = new RegistrationGUI();
        while (true) {
            registrationGUI.registerUser();
        }
    }
}
