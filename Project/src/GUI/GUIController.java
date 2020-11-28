package GUI;

import Registration.RegistrationGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUIController {

    private GUI gui;
    private RegistrationGUI registrationGUI;
    private BufferedReader reader;

    public GUIController() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void selectOption() {
        int option = 0;
        while (true) {
            System.out.println("Select one of the following options:");
            System.out.println("0 to quit");
            System.out.println("1 to register a user");
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
                    String response = registrationGUI.registerUser();
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

    public static void main(String[] args) {
        GUIController guiController = new GUIController();
        guiController.setGui(new GUI());
        guiController.setRegistrationGUI(new RegistrationGUI());
        guiController.selectOption();
    }
}
