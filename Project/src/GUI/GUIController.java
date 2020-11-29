package GUI;

import Database.DBController;
import Payment.MakePayment;
import Payment.MakePaymentGUI;
import Payment.PaymentSystem;
import Registration.*;
import Reservation.ManageReservations;
import Reservation.ReservationGUI;
import Reservation.ReservationSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUIController {

    private GUI gui;
    private RegistrationGUI registrationGUI;
    private LoginGUI loginGUI;
    private MakePaymentGUI makePaymentGUI;
    private ReservationGUI reservationGUI;
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
            System.out.println("3 to log out");
            System.out.println("4 to view all users");
            System.out.println("5 to view all vouchers");
            System.out.println("6 to view all movies");
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
                    if (!loggedIn) {
                        response = loginGUI.logInUser();
                        if (response.equals("Successfully logged in"))
                            loggedIn = true;
                    }
                    else
                        response = "You are already logged in";
                    gui.displayMessage(response);
                    break;
                }
                case (3): {
                    if (!loggedIn)
                        response = "You are not logged in";
                    else {
                        loggedIn = false;
                        response = "Successfully logged out";
                    }
                    gui.displayMessage(response);
                    break;
                }
                case (4): {
                    registrationGUI.displayUsers();
                    break;
                }
                case (5): {
                    reservationGUI.displayVouchers();
                    break;
                }
                case (6): {
                    reservationGUI.displayMovies();
                    break;
                }
            }
        }
    }

    public void loadFromDB(DBController dbController) {
        dbController.loadFromDB();
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

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }

    public void setReservationGUI(ReservationGUI reservationGUI) {
        this.reservationGUI = reservationGUI;
    }

    public static void main(String[] args) {
        GUIController guiController = new GUIController();
        guiController.setGui(new GUI());
        PaymentSystem paymentSystem = new PaymentSystem();
        MakePaymentGUI makePaymentGUI = new MakePaymentGUI(new MakePayment(paymentSystem));
        guiController.setMakePaymentGUI(makePaymentGUI);
        UserSystem userSystem = new UserSystem(makePaymentGUI);
        guiController.setRegistrationGUI(new RegistrationGUI(new ManageRegistration(userSystem)));
        ReservationSystem reservationSystem = new ReservationSystem(makePaymentGUI);
        guiController.setReservationGUI(new ReservationGUI(new ManageReservations(reservationSystem)));
        guiController.setLoginGUI(new LoginGUI(new ManageLogin(userSystem)));
        guiController.loadFromDB(new DBController(userSystem, reservationSystem));
        guiController.selectOption();
    }
}
