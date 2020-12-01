package Registration;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LoginGUI extends JPanel {

	private JPanel frame;
	private JTextField passwordTextField, usernameTextField;
	private JButton returnHomeButton, loginButton;
	private boolean loginSuccessful = false;
	private JLabel loginLabel;
	

	public LoginGUI() {
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		buildGUI();
	}

	public void addButtonActionListener(JButton button, ActionListener actionListener) {
		button.addActionListener(actionListener);
	}

	private void buildGUI() {
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

		passwordTextField = new JTextField();
		passwordTextField.setBounds(347, 245, 289, 25);
		frame.add(passwordTextField);
		passwordTextField.setColumns(10);

		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(347, 159, 289, 25);
		frame.add(usernameTextField);

		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 150, 40);
		frame.add(returnHomeButton);

		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(817, 11, 157, 40);
		frame.add(loginLabel);

		add(frame);
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);
	}

	public void clearTextFields() {
		usernameTextField.setText("");
		passwordTextField.setText("");
	}

	public JTextField getPasswordTextField() {
		return passwordTextField;
	}

	public JTextField getUsernameTextField() { return usernameTextField; }

	public JButton getReturnHomeButton() { return returnHomeButton; }

	public boolean isLoginSuccessful() { return loginSuccessful; }

	public void setLoginSuccessful(boolean loginSuccessful) { this.loginSuccessful = loginSuccessful; }

	public JButton getLoginButton() { return loginButton; }

	public JLabel getLoginLabel() {
		return loginLabel;
	}
}
