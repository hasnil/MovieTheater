package Reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReservationGUI {

    private ManageReservations manageReservations;
    private BufferedReader reader;

    public ReservationGUI(ManageReservations manageReservations) {
        setManageReservations(manageReservations);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void makeReservation() {
        try {
            System.out.println("Select a movie:");
            String movie = reader.readLine();
            System.out.println("Select a showtime");
            String showtime = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMovies() {
        manageReservations.displayMovies();
    }

    public void displayVouchers() {
        manageReservations.displayVouchers();
    }

    public void setManageReservations(ManageReservations manageReservations) {
        this.manageReservations = manageReservations;
    }
}
