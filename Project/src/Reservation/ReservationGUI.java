package Reservation;

public class ReservationGUI {

    private ManageReservations manageReservations;

    public ReservationGUI(ManageReservations manageReservations) {
        setManageReservations(manageReservations);
    }

    public void displayVouchers() {
        manageReservations.displayVouchers();
    }

    public void setManageReservations(ManageReservations manageReservations) {
        this.manageReservations = manageReservations;
    }
}
