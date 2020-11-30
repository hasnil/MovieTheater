package Registration;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationGUI extends JPanel{

	private JPanel frame;
	private JTextField emailTextField, usernameTextField, passwordTextField, nameTextField, addressTextField, creditCardTextField;
	private JButton returnHomeButton, registerButton, makePaymentButton;
	private JLabel loginLabel;

	public RegistrationGUI() {
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
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailLabel.setBounds(356, 69, 271, 44);
		frame.add(emailLabel);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(401, 132, 180, 38);
		frame.add(usernameLabel);

		JLabel infoLabel = new JLabel("Please enter your information to register. Note that there is a $20 annual fee.");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		infoLabel.setBounds(161, 21, 662, 67);
		frame.add(infoLabel);

		registerButton = new JButton("Submit Registration");
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerButton.setBounds(383, 493, 217, 44);
		frame.add(registerButton);

		emailTextField = new JTextField();
		emailTextField.setBounds(367, 105, 249, 27);
		frame.add(emailTextField);
		emailTextField.setColumns(10);

		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(366, 169, 249, 27);
		frame.add(usernameTextField);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(402, 196, 180, 38);
		frame.add(passwordLabel);

		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(367, 233, 249, 27);
		frame.add(passwordTextField);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(367, 302, 249, 27);
		frame.add(nameTextField);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setBounds(402, 265, 180, 38);
		frame.add(nameLabel);

		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(367, 363, 249, 27);
		frame.add(addressTextField);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressLabel.setBounds(402, 326, 180, 38);
		frame.add(addressLabel);

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

		creditCardTextField = new JTextField();
		creditCardTextField.setColumns(10);
		creditCardTextField.setBounds(367, 430, 249, 27);
		frame.add(creditCardTextField);

		JLabel creditCardNumberLabel = new JLabel("Credit Card Number");
		creditCardNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditCardNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		creditCardNumberLabel.setBounds(325, 393, 335, 38);
		frame.add(creditCardNumberLabel);

		add(frame);
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);
	}

	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}
	public JTextField getUsernameTextField() {
		return usernameTextField;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public JButton getMakePaymentButton() {
		return makePaymentButton;
	}

	public void addMakePaymentListener(ActionListener actionListener) {
		makePaymentButton.addActionListener(actionListener);
	}
}

	
	
