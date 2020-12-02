package theater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageLogin {

	private LoginGUI loginGUI;
	
	public ManageLogin() {
		
		
		
		
	}
	
	
	public void setLoginGUI(LoginGUI login) {
		loginGUI = login;
		
		loginGUI.getLoginButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	
		    	//MUST CHECK IF LOGIN WORKED
		        loginGUI.setLoginSuccessful(true);
		        loginGUI.getLoginLabel().setText("Login Status: Logged In");
		    }
		});
		
	}
	
	
}
