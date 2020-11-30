package Registration;

import Payment.MakePaymentGUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserSystem {

    private ManageAnnualFee manageAnnualFee;
    private ArrayList<RegisteredUser> registeredUsers;

    public UserSystem(MakePaymentGUI makePaymentGUI) {
        manageAnnualFee = new ManageAnnualFee(makePaymentGUI);
        registeredUsers = new ArrayList<>();
    }

    public String registerUser(String email, String username) {
        if (findUserByEmail(email))
            return "That email is already registered, try to log in";
        else if (findUserByUsername(username))
            return "That username already exists, try a different one";
        else
            return "Okay";
    }

//    public boolean makePayment(String email, String username, String password) {
//        if (manageAnnualFee.payAnnualFee()) {
//            registeredUsers.add(new RegisteredUser(username, email, password));
//            return true;
//        }
//        else
//            return false;
//    }

    public RegisteredUser logInUser(String username, String password) {
        for (RegisteredUser user : registeredUsers)
            if (user.getUserName().equals(username) && user.getPassword().equals(password))
                return user;
        return null;
    }

    public void loadUsers(ResultSet rs) {
        try {
            while (rs.next()) {
                addUser(new RegisteredUser(
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("passw")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayUsers() {
        for (RegisteredUser user : registeredUsers)
            System.out.println(user);
    }

    private void addUser(RegisteredUser user) {
        registeredUsers.add(user);
    }

    private boolean findUserByEmail(String email) {
        for (RegisteredUser user : registeredUsers)
            if (user.getEmail().equals(email))
                return true;
        return false;
    }

    private boolean findUserByUsername(String username) {
        for (RegisteredUser user : registeredUsers)
            if (user.getUserName().equals(username))
                return true;
        return false;
    }
}
