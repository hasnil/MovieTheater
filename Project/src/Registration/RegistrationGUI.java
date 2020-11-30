package Registration;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationGUI extends JPanel{
	
	private JPanel frame;
	private JTextField emailTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton returnHomeButton;
	private JLabel loginLabel;
	private ManageRegistration manageRegistration;
	private JButton registerButton;
	private JButton makePaymentButton;


	public RegistrationGUI(ManageRegistration manageRegistration) {
		setManageRegistration(manageRegistration);
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(356, 88, 271, 44);
		frame.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(402, 162, 180, 38);
		frame.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Please enter your information to register. Note that there is a $20 annual fee.");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(161, 21, 662, 67);
		frame.add(lblNewLabel_5);
		
		registerButton = new JButton("Submit Registration");
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerButton.setBounds(383, 493, 217, 44);
		registerButton.addActionListener(new RegisterButton());
		frame.add(registerButton);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(367, 124, 249, 27);
		frame.add(emailTextField);
		emailTextField.setColumns(10);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(367, 199, 249, 27);
		frame.add(usernameTextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(402, 245, 180, 38);
		frame.add(lblNewLabel_1_1);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(367, 282, 249, 27);
		frame.add(passwordTextField);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(367, 357, 249, 27);
		frame.add(textField_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(402, 320, 180, 38);
		frame.add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(367, 432, 249, 27);
		frame.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("First Name");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(402, 395, 180, 38);
		frame.add(lblNewLabel_1_1_1_1);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 21, 140, 44);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(818, 21, 166, 44);
		frame.add(loginLabel);

		makePaymentButton = new JButton("Make Payment");
		makePaymentButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		makePaymentButton.setBounds(659, 493, 198, 44);
		makePaymentButton.setEnabled(false);
		frame.add(makePaymentButton);

		add(frame);
	}

	public void addRegisterButtonListener(ActionListener actionListener) {
		registerButton.addActionListener(actionListener);
	}
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}

	
	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}


	public void displayUsers() {
        manageRegistration.displayUsers();
    }

    public void setManageRegistration(ManageRegistration manageRegistration) {
        this.manageRegistration = manageRegistration;
    }

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public JTextField getUsernameTextField() {
		return usernameTextField;
	}

	public JTextField getPasswordTextField() {
		return passwordTextField;
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);
	}

	class RegisterButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			String email = getEmailTextField().getText();
			String username = getUsernameTextField().getText();
			String password = getPasswordTextField().getText();
			String response = manageRegistration.checkCredentialsAvailability(email, username);
			if (!response.equals("Okay"))
				displayMessage(response);
			else {
				displayMessage("That username and email are available, please proceed to make a payment");
				makePaymentButton.setEnabled(true);
			}
		}
	}

	public void addMakePaymentListener(ActionListener actionListener) {
		makePaymentButton.addActionListener(actionListener);
	}
}

	
	
