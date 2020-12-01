package Registration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserSystem {

    private ArrayList<RegisteredUser> registeredUsers;
    private ManageLogin manageLogin;

    public UserSystem() {
        registeredUsers = new ArrayList<>();
    }

    public String checkCredentials(String email, String username) {
        if (findUserByEmail(email))
            return "That email is already registered, try to log in";
        else if (findUserByUsername(username))
            return "That username already exists, try a different one";
        else
            return "Okay";
    }

    public RegisteredUser logInUser(String username, String password) {
        for (RegisteredUser user : registeredUsers)
            if (user.getUserName().equals(username) && user.getPassword().equals(password))
                return user;
        return null;
    }

    public void addUser(RegisteredUser user) {
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

    public void loadUsers(ResultSet rs) {
        try {
            while (rs.next()) {
                addUser(new RegisteredUser(
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("passw"),
                        rs.getString("fullName"),
                        rs.getString("address"),
                        rs.getString("creditCard")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ManageLogin getManageLogin() {
		return manageLogin;
	}

	public void setManageLogin(ManageLogin manageLogin) {
		this.manageLogin = manageLogin;
	}
}
