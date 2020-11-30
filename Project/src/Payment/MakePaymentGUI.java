package Payment;

import java.awt.Color;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;

public class MakePaymentGUI extends JPanel {
	
	private JPanel frame;
	private JTextField securityCodeField, cardNumberField;
	private JButton returnHomeButton, submitPaymentButton;
	private JLabel loginLabel, amountLabel;
	private double amount;

	public MakePaymentGUI(){
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
		JLabel informationLabel = new JLabel("Payment needed for your transaction:");
		informationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		informationLabel.setBounds(319, 11, 346, 72);
		frame.add(informationLabel);

		amountLabel = new JLabel();
		amountLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		amountLabel.setBounds(453, 82, 75, 44);
		frame.add(amountLabel);

		JLabel ccLabel = new JLabel("Please enter your credit card number:");
		ccLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ccLabel.setBounds(354, 155, 276, 46);
		frame.add(ccLabel);

		JLabel cvvLabel = new JLabel("Please enter your security code:");
		cvvLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cvvLabel.setBounds(374, 241, 235, 44);
		frame.add(cvvLabel);

		submitPaymentButton = new JButton("Submit Payment");
		submitPaymentButton.setBounds(409, 410, 166, 46);
		frame.add(submitPaymentButton);

		securityCodeField = new JTextField();
		securityCodeField.setBounds(387, 275, 209, 30);
		frame.add(securityCodeField);
		securityCodeField.setColumns(10);

		cardNumberField = new JTextField();
		cardNumberField.setColumns(10);
		cardNumberField.setBounds(364, 193, 245, 30);
		frame.add(cardNumberField);

		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 150, 43);
		frame.add(returnHomeButton);

		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(804, 17, 159, 30);
		frame.add(loginLabel);

		add(frame);
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);
	}

	public void clearTextFields() {
		cardNumberField.setText("");
		securityCodeField.setText("");
	}

	public void payWithCreditCard() {

	}

	public double getAmount() {
		return amount;
	}

	public JTextField getSecurityCodeField() {
		return securityCodeField;
	}

	public JTextField getCardNumberField() {
		return cardNumberField;
	}
	
	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}

	public JButton getSubmitPaymentButton() {
		return submitPaymentButton;
	}

	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public void setAmount(double amount) {
		this.amount = amount;
		amountLabel.setText("$" + amount);
	}
}
