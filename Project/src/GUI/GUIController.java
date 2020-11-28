package GUI;

import Registration.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUIController {

    private GUI gui;
    private RegistrationGUI registrationGUI;
    private LoginGUI loginGUI;
    private BufferedReader reader;
    private boolean loggedIn;

    public GUIController() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        loggedIn = false;
    }

    public void selectOption() {
        int option = 0;
        String response = "";
        while (true) {
            System.out.println("Select one of the following options:");
            System.out.println("0 to quit");
            System.out.println("1 to register a user");
            System.out.println("2 to log in");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (option) {
                case (0): {
                    System.exit(0);
                    break;
                }
                case (1): {
                    if (!loggedIn)
                        response = registrationGUI.registerUser();
                    else
                        response = "Log out to register another user";
                    gui.displayMessage(response);
                    break;
                }
                case (2): {
                    if (!loggedIn)
                        response = "Modify";
                    else
                        response = "You are already logged in";
                    gui.displayMessage(response);
                    break;
                }
            }
        }
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public void setRegistrationGUI(RegistrationGUI registrationGUI) {
        this.registrationGUI = registrationGUI;
    }

    public void setLoginGUI(LoginGUI loginGUI) {
        this.loginGUI = loginGUI;
    }

    public static void main(String[] args) {
        GUIController guiController = new GUIController();
        guiController.setGui(new GUI());
        UserSystem userSystem = new UserSystem();
        guiController.setRegistrationGUI(new RegistrationGUI(new ManageRegistration(userSystem)));
        guiController.setLoginGUI(new LoginGUI(new ManageLogin(userSystem)));
        guiController.selectOption();
    }
}
