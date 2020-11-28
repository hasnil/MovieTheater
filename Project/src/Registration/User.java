package Registration;

import java.util.ArrayList;

public class User {

    private String email;
//    private ArrayList<Reservation> reservations;
    private ArrayList<Voucher> vouchers;

    public User(String email) {
        setEmail(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
