package Registration;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LoginGUI extends JPanel {

	private JPanel frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton returnHomeButton;
	private boolean loginSuccessful = false;
	private JButton loginButton;
	private JLabel loginLabel;
	private ManageLogin manageLogin;
	

	public LoginGUI() {
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Your Username and Password to Log In");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(136, 46, 711, 40);
		frame.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(136, 113, 711, 40);
		frame.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(136, 206, 711, 40);
		frame.add(lblPassword);
		
		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginButton.setBounds(382, 425, 220, 59);
		frame.add(loginButton);
		
		textField = new JTextField();
		textField.setBounds(347, 245, 289, 25);
		frame.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(347, 159, 289, 25);
		frame.add(textField_1);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 150, 40);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(817, 11, 157, 40);
		frame.add(loginLabel);
		
		add(frame);
	}
	

	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}

	public boolean isLoginSuccessful() {
		return loginSuccessful;
	}

	public void setLoginSuccessful(boolean loginSuccessful) {
		this.loginSuccessful = loginSuccessful;
	}


	public JButton getLoginButton() {
		return loginButton;
	}
	

	public JLabel getLoginLabel() {
		return loginLabel;
	}

	
	public void setManageLogin(ManageLogin manageLogin) {
		this.manageLogin = manageLogin;
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);	
	}
}
