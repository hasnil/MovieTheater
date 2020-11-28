package Registration;

public class ManageLogin {

    private UserSystem userSystem;

    public ManageLogin(UserSystem userSystem) {
        setUserSystem(userSystem);
    }

    public String logInUser(String username, String password) {
        return userSystem.logInUser(username, password);
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }
}
