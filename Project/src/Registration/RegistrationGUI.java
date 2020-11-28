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

    public void registerUser() {
        try {
            System.out.println("Enter your email");
            String email = reader.readLine();
            System.out.println("Enter your username");
            String userName = reader.readLine();
            System.out.println("Enter your password");
            String password = reader.readLine();
            String response = manageRegistration.registerUser(email, userName, password);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        RegistrationGUI registrationGUI = new RegistrationGUI();
        while (true) {
            registrationGUI.registerUser();
        }
    }
}
