package Registration;

import java.util.ArrayList;

public class UserSystem {

    private ManageLogin manageLogin;
    private ManageRegistration manageRegistration;
    private ManageAnnualFee manageAnnualFee;
    private RegisteredUser registeredUser;
    private ArrayList<RegisteredUser> registeredUsers;

//    public UserSystem(ManageLogin manageLogin, ManageRegistration manageRegistration, ManageAnnualFee manageAnnualFee, RegisteredUser registeredUser) {
//        setManageLogin(manageLogin);
//        setManageRegistration(manageRegistration);
//        setManageAnnualFee(manageAnnualFee);
//        setRegisteredUser(registeredUser);
//    }


    public UserSystem() {
        registeredUsers = new ArrayList<>();
    }

    public String registerUser(String email, String username, String password) {
        if (findUserByEmail(email))
            return "That email is already registered, try to log in";
        if (findUserByUsername(username))
            return "That username already exists, try a different one";

        registeredUsers.add(new RegisteredUser(email, username, password));
        return "User registered successfully";
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
