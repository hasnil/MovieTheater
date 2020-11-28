package Registration;

import java.util.ArrayList;

public class UserSystem {

    private ManageLogin manageLogin;
    private ManageRegistration manageRegistration;
    private ManageAnnualFee manageAnnualFee;
    private RegisteredUser registeredUser;
    private ArrayList<RegisteredUser> registeredUsers;

    public UserSystem(ManageLogin manageLogin, ManageRegistration manageRegistration, ManageAnnualFee manageAnnualFee, RegisteredUser registeredUser) {
        setManageLogin(manageLogin);
        setManageRegistration(manageRegistration);
        setManageAnnualFee(manageAnnualFee);
        setRegisteredUser(registeredUser);
    }

    public void setManageLogin(ManageLogin manageLogin) {
        this.manageLogin = manageLogin;
    }

    public void setManageRegistration(ManageRegistration manageRegistration) {
        this.manageRegistration = manageRegistration;
    }

    public void setManageAnnualFee(ManageAnnualFee manageAnnualFee) {
        this.manageAnnualFee = manageAnnualFee;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }
}
